$(function() {
	var HighSchoolModel = Backbone.Model.extend({
		defaults: {
			Ged_Stat: 0,
		},
	});
	var HighSchoolCollection = Backbone.Collection.extend({
		model: HighSchoolModel,
	});
	var highSchoolCollection = new HighSchoolCollection(
		JSON.parse("null")
	);

	var UnivMajorCollection = Backbone.Collection.extend({});
	var UnivSchoolModel = Backbone.Model.extend({
		parse: function(response) {
			response.UnivMajor = new UnivMajorCollection(
				response.UnivMajor
			);
			return response;
		},
	});
	var UnivSchoolCollection = Backbone.Collection.extend({
		model: UnivSchoolModel,
	});
	var univSchoolCollection = new UnivSchoolCollection(
		JSON.parse("[]")
	);

	var HighSchoolSearchCollection = Backbone.Collection.extend({
		url: "/User/Resume/HighSchoolSearchJson",
		titleColumn: "School_Name",
	});
	var UnivSchoolSearchCollection = Backbone.Collection.extend({
		url: "/User/Resume/UnivSearchJson",
		titleColumn: "School_Name",
	});
	var UnivMajorSearchCollection = Backbone.Collection.extend({
		url: "/User/Resume/MajorSearchJson",
		titleColumn: "Major_Name",
	});

	var SchoolView = Backbone.View.extend({
		el: "#school_containers",
		initialize: function(options) {
			var that = this;
			_.extend(this, options);
			this.rowNo = 1;
			this.highSchoolSearchCollection.on(
				"sync",
				this.searchCollectionRefresh,
				this,
				this.highSchoolSearchCollection
			);
			this.univSchoolSearchCollection.on(
				"sync",
				this.searchCollectionRefresh,
				this,
				this.univSchoolSearchCollection
			);
			this.univMajorSearchCollection.on(
				"sync",
				this.searchCollectionRefresh,
				this,
				this.univMajorSearchCollection
			);

			this.highSchoolSearchTemplate = _.template(
				$("#tplSchoolAutoComplete").html()
			);
			this.searchTemplate = _.template(
				$("#tplCommonSearch").html()
			);
			this.searchFailTemplate = _.template(
				$("#tplCommonNotFound").html()
			);
			this.searchDirectTemplate = _.template(
				$("#tplCommonDirectInput").html()
			);
			this.univMajorTpl = _.template(
				$("#tplUnivMajorItem").html()
			);

			this.highSchoolTpl = _.template($("#tplHighSchool").html());
			this.univSchoolTpl = _.template($("#tplUnivSchool").html());
			this.schoolTpl = _.template($("#tplSchool").html());
			this.render();
			this.$el
				.closest(".formWrap")
				.find(".buttonAddField")
				.click(function(e) {
					that.addItemClick(e);
				});
			this.$el
				.closest(".formWrap")
				.find("#LowLastEduLevel")
				.click(function(e) {
					that.checkLastEduClick(e);
				});

			$("#otherMajorDeletePop .buttonConfirm").click(function(
				e
			) {
				that.majorDeletePopConfirmClick(e);
			});

			if (
				this.highSchoolCollection.size() == 0 &&
				this.univSchoolCollection.size() == 0
			) {
				that.addItemClick();
			}
			Resume.Utilities.setValueDropdown(
				this.$el.find(".dropdown")
			);
			this.initSetting();
		},
		events: {
			"click .dropdown-education-category .list .button":
				"schoolTypeClick", //학교 구분 선택
			"click .buttonEducationMajor": "otherMajorClick", //다른 전공 버튼 토글 클릭
			"click .buttonEducationContents": "gradPaperClick", //졸업논문/작품 버튼 토글 클릭
			"click .buttonDeleteField": "removeItemclick",
			"click .devGedCheck": "gedCheckClick", //검정고시 여부 토글 클릭
			"click #lbl_education_school": "alertMsg",
		},
		render: function() {
			var that = this;
			this.highSchoolCollection.each(function(item) {
				that.addCollectionItem(item, that.highSchoolTpl);
			}, this);
			this.univSchoolCollection.each(function(item) {
				that.addCollectionItem(item, that.univSchoolTpl);
			}, this);
		},
		addCollectionItem: function(item, tpl, collection) {
			var that = this,
				templateData = {
					data: item.toJSON(),
					cid: item.cid,
					no: this.getRowNo(),
				};

			this.$el.append(tpl(templateData));
			var $newContainer = this.$el.find(
				".container[data-cid='" + item.cid + "']"
			);

			if (tpl == this.highSchoolTpl) {
				$("#highSchoolAutocomplete_" + item.cid).jkAc2({
					collection: this.highSchoolSearchCollection,
					containerQuery: ".row",
				});
			} else {
				var subUnivMajorJson = item.get("UnivMajor");

				for (var i = subUnivMajorJson.length; i < 2; i++) {
					var majorTypeCode = null;
					//주전공 코드가 없으면 주전공 코드를 생성.
					if (
						_.where(subUnivMajorJson, { Major_Type_Code: 1 })
							.length == 0
					) {
						majorTypeCode = 1;
					}
					subUnivMajorJson.push({
						Major_Name: "",
						Major_Code: "",
						Major_Type_Code: majorTypeCode,
						Major_Aftn_Code: "",
					});
				}

				for (var i = 0; i < subUnivMajorJson.length; i++) {
					var temp = {
						data: subUnivMajorJson[i],
						idx: i,
						school_cid: item.cid,
					};
					if (temp.data.Major_Type_Code === 1) {
						$newContainer
							.find(".devMainMajorTemplateArea")
							.html(this.univMajorTpl(temp));
					} else {
						$newContainer
							.find(".devOtherUnivMajorTemplateArea")
							.append(this.univMajorTpl(temp));
					}
				}

				$("#UnivSchoolautoComplete_" + templateData.cid).jkAc2({
					collection: this.univSchoolSearchCollection,
					defaultParam: {
						schlTypeCode: templateData.data.Schl_Type_Code,
					},
					containerQuery: ".row",
				});

				$newContainer
					.find("[id^='UnivMajorAutoComplete']")
					.each(function() {
						$(this).jkAc2({
							collection: that.univMajorSearchCollection,
							containerQuery: ".row",
						});
					});
			}
		},
		searchCollectionRefresh: function(collection) {
			var that = this,
				$curInputEle = this.$(
					"[data-comp_type='jkAcInput']:focus"
				),
				$curResultWrapEle = $curInputEle
					.closest("[data-comp_type='jkAc']")
					.find("[data-comp_type='jkAcResultWrap']");

			var titleColumn = collection.titleColumn;

			var template;
			if (collection == this.highSchoolSearchCollection) {
				template = that.highSchoolSearchTemplate;
			} else {
				template = that.searchTemplate;
			}

			$curResultWrapEle.html("<div class='list'><ul></ul><div>");
			$curResultWrapEle.addClass("hidden");

			if (collection.length > 0) {
				collection.each(function(item) {
					var templateData = _.extend(
						item.toJSON(),
						{
							Highlight_Name: item
								.get(titleColumn)
								.replace(
									$curInputEle.val(),
									"<em>" + $curInputEle.val() + "</em>"
								),
						},
						{
							itemJson: JSON.stringify(item.toJSON()).replace(
								"'",
								"&apos;"
							),
						}
					);
					$curResultWrapEle
						.find(".list ul")
						.append(template(templateData));
				}, this);
			} else {
				$curResultWrapEle.html(
					that.searchFailTemplate({
						searchText: $curInputEle.val(),
					})
				);
			}

			$curResultWrapEle.append(
				that.searchDirectTemplate({
					searchText: $curInputEle.val(),
					itemJson: JSON.stringify(
						JSON.parse(
							'{ "' +
							titleColumn +
							'":"' +
							$curInputEle.val() +
							'" }'
						)
					).replace("'", "&apos;"),
				})
			);
			$curResultWrapEle.removeClass("hidden");
		},

		alertMsg: function(e) {
			var $source = $(e.currentTarget),
				$container = $source.closest(".container");

			Resume.Utilities.validationMsgShow(
				$container.find(".dropdown-education-category")
			);
		},

		addItem: function(item) {
			var templateData = _.extend(item.toJSON(), {
				cid: item.cid,
			});
			if (item.get("stype") == 0) {
				this.$el.append(
					_.template($("#tplSchool").html(), templateData)
				);
			}
		},

		removeItemclick: function(e) {
			var $btn = $(e.currentTarget),
				$container = $btn.closest(".container"),
				$form = $container.closest(".formWrap"),
				cid = $container.data("cid");

			this.highSchoolCollection.remove(
				this.highSchoolCollection.get(cid)
			);
			this.univSchoolCollection.remove(
				this.univSchoolCollection.get(cid)
			);

			$container.remove();
			$form
				.find(".container:first")
				.removeClass()
				.addClass("container container1");
		},

		schoolTypeClick: function(e) {
			var that = this,
				$source = $(e.currentTarget),
				$container = $source.closest(".container"),
				schl_type_code = $source.data("schltypecode"),
				cid = $container.data("cid");

			if (schl_type_code == "0") {
				var model = new this.highSchoolCollection.model();
				var no =
					$(".formEducation .container").index($container) + 1;
				var templateData = {
					data: model.toJSON(),
					cid: model.cid,
					no: no,
				};
				$container.replaceWith(this.highSchoolTpl(templateData));
				var $newContainer = this.$(
					".container[data-cid='" + model.cid + "']"
				);
				$newContainer.find("[data-comp_type='jkAc']").jkAc2({
					collection: this.highSchoolSearchCollection,
					containerQuery: ".row",
				});
			} else {
				var model = new this.univSchoolCollection.model();
				model.set("Schl_Type_Code", schl_type_code);
				var no =
					$(".formEducation .container").index($container) + 1;
				var templateData = {
					data: model.toJSON(),
					cid: model.cid,
					no: no,
				};
				$container.replaceWith(this.univSchoolTpl(templateData));
				var $newContainer = this.$(
					".container[data-cid='" + model.cid + "']"
				);

				$newContainer
					.find(".devMainMajorTemplateArea")
					.html(
						this.univMajorTpl({
							idx: 0,
							school_cid: model.cid,
							data: { Major_Type_Code: 1 },
						})
					);
				$newContainer
					.find(".devOtherUnivMajorTemplateArea")
					.html(
						this.univMajorTpl({
							idx: 1,
							school_cid: model.cid,
							data: {},
						})
					);

				$("#UnivSchoolautoComplete_" + model.cid).jkAc2({
					collection: this.univSchoolSearchCollection,
					defaultParam: { schlTypeCode: schl_type_code },
					containerQuery: ".row",
				});

				$newContainer
					.find("[id^='UnivMajorAutoComplete']")
					.each(function() {
						$(this).jkAc2({
							collection: that.univMajorSearchCollection,
							containerQuery: ".row",
						});
					});
			}
		},
		addItemClick: function(e) {
			var no = this.getRowNo();
			this.$el.append(this.schoolTpl({ no: no }));

			//추가된 Row의 학교 구분 하이라이트 처리
			var $newRow = this.$el.find(".container" + no);
			$newRow.find(".dropdown-education-category button").focus();
		},
		getRowNo: function() {
			return this.$(".container").size() + 1;
		},
		initSetting: function() {
			this.$(".devTrnfCheck").each(function() {
				Resume.Utilities.setCheckedCheckbox($(this));
			});
			this.eduLevelCheck();
		},
		otherMajorClick: function(e) {
			var $source = $(e.currentTarget),
				$container = $source.closest(".container"),
				$targetRow = $container.find(".devOtherUnivMajorRow"),
				$targetBtn = $container.find(".buttonEducationMajor");

			if ($targetRow.is(":visible")) {
				if ($targetRow.size() > 1) {
					var $pop = $(".popupMajor"),
						otherMajorTemplate = _.template(
							$("#tplOtherMajorDeleteViewItem").html()
						);

					$pop
						.find(".devUnivCid")
						.val(
							$targetRow.eq(0).closest(".container").data("cid")
						);
					$pop.find(".list").html("");

					$targetRow.each(function() {
						var otherMajorJson = {
							Major_Name: $(this)
								.find("[data-type='Major_Name']")
								.val(),
							Major_Type_Name: $(this)
								.find(".buttonChoose span")
								.text(),
							Row_Id: $(this).data("rowid"),
						};
						$pop
							.find(".list")
							.append(otherMajorTemplate(otherMajorJson));
					});

					$pop.removeClass("hidden").attr("aria-hidden", "false");
					var top = $source.closest(".container").position().top;
					$pop.css("top", top + "px");
					var offsettop = $source.closest("div").offset().top;
					var screenHeightHalf =
						top > 100 ? screen.height / 2 : screen.height / 4;
					$("html, body").animate(
						{ scrollTop: offsettop - screenHeightHalf },
						400
					);
				} else {
					$targetRow.hide();
					$targetRow.find("input").val("");
					Resume.Utilities.clearValueDropdown(
						$targetRow.find(".dropdown")
					);
					Resume.Utilities.clearValueInput(
						$targetRow.find(".input")
					);
					$targetBtn.removeClass("selected");
				}
			} else {
				$targetRow.show();
				$targetBtn.addClass("selected");
			}
		},
		majorDeletePopConfirmClick: function(e) {
			var that = this,
				$curPop = $("#otherMajorDeletePop"),
				$univContainerId = $curPop.find(".devUnivCid").val(),
				$univContainer = this.$el
					.find(".container")
					.filter("[data-cid='" + $univContainerId + "']");

			$curPop.find(":checkbox:checked").each(function() {
				var rowId = $(this).data("rowid");
				var $deleterow = $univContainer
					.find(".devOtherUnivMajorRow")
					.filter("[data-rowid='" + rowId + "']");
				if ($deleterow.size() > 0) {
					$deleterow.remove();
				}
			});
			if (
				$univContainer.find(".devOtherUnivMajorRow").size() == 0
			) {
				$univContainer
					.find(".buttonEducationMajor")
					.removeClass("selected");
			} else {
				var loopIdx = 1;
				//이름 재할당 ModelBinder에서 인식을 위해
				$univContainer
					.find(".devOtherUnivMajorRow")
					.each(function() {
						$(this)
							.find("[data-type='Major_Name']")
							.attr(
								"name",
								"UnivSchool[" +
								$univContainerId +
								"].UnivMajor[" +
								loopIdx +
								"].Major_Name"
							);
						$(this)
							.find("[data-type='Major_Code']")
							.attr(
								"name",
								"UnivSchool[" +
								$univContainerId +
								"].UnivMajor[" +
								loopIdx +
								"].Major_Code"
							);
						$(this)
							.find("[data-type='Major_Aftn_Code']")
							.attr(
								"name",
								"UnivSchool[" +
								$univContainerId +
								"].UnivMajor[" +
								loopIdx +
								"].Major_Aftn_Code"
							);
						$(this)
							.find("[id^='UnivMajor_Major_Type_Code']")
							.attr(
								"name",
								"UnivSchool[" +
								$univContainerId +
								"].UnivMajor[" +
								loopIdx +
								"].Major_Type_Code"
							);
						$(this)
							.find("[id^='UnivMajor_Index_Name']")
							.attr(
								"name",
								"UnivSchool[" +
								$univContainerId +
								"].UnivMajor[" +
								loopIdx +
								"].Index_Name"
							);
						loopIdx++;
					});
			}

			Resume.Utilities.popupHidden($("#otherMajorDeletePop"));
		},
		gradPaperClick: function(e) {
			var $source = $(e.currentTarget),
				$container = $source.closest(".container"),
				$targetRow = $container.find(".devGradPaperRow"),
				$targetBtn = $container.find(".buttonEducationContents");

			if ($targetRow.is(":visible")) {
				$targetRow.hide();
				$targetRow.find("textarea").val("");
				$targetBtn.removeClass("selected");
			} else {
				$targetRow.show();
				$targetBtn.addClass("selected");
			}
		},
		gedCheckClick: function(e) {
			var $source = $(e.currentTarget),
				$input = $source.closest(".checkbox"),
				$container = $input.closest(".container");

			var model = new this.highSchoolCollection.model();
			var no =
				$(".formEducation .container").index($container) + 1;

			if ($input.find(":checkbox").is(":checked")) {
				var templateData = {
					data: _.extend(model.toJSON(), { Ged_Stat: 0 }),
					cid: model.cid,
					no: no,
				};
			} else {
				var templateData = {
					data: _.extend(model.toJSON(), { Ged_Stat: 1 }),
					cid: model.cid,
					no: no,
				};
			}
			$container.replaceWith(this.highSchoolTpl(templateData));
			var $newContainer = this.$(
				".container[data-cid='" + model.cid + "']"
			);
			$newContainer.find("[data-comp_type='jkAc']").jkAc2({
				collection: this.highSchoolSearchCollection,
			});
		},
		checkLastEduClick: function(e) {
			this.eduLevelCheck();
		},
		eduLevelCheck: function() {
			var flag = $("#LowLastEduLevel").is(":checked");
			$("#school_containers").toggle(!flag);
			$("#school_addbutton").toggle(!flag);
		},
	});

	schoolView = new SchoolView({
		highSchoolCollection: highSchoolCollection,
		univSchoolCollection: univSchoolCollection,
		highSchoolSearchCollection: new HighSchoolSearchCollection(),
		univSchoolSearchCollection: new UnivSchoolSearchCollection(),
		univMajorSearchCollection: new UnivMajorSearchCollection(),
	});
});