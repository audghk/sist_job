$(function () {
    window.ResumeForm.Career = {};
    window.ResumeForm.Career.CareerTermMsgVisible = function () {
      var careerYear = $("#spn_Career_Term_Year").text(),
        careerMonth = $("#spn_Career_Term_Month").text(),
        abroadCareerYear = $("#spn_Abroad_Career_Term_Year").text(),
        abroadCareerMonth = $(
          "#spn_Abroad_Career_Term_Month"
        ).text();

      if (
        careerYear != "0" ||
        careerMonth != "0" ||
        abroadCareerYear != "0" ||
        abroadCareerMonth != "0"
      ) {
        $("#formCareer .header .term").show();
      } else {
        $("#formCareer .header .term").hide();
      }

      if (abroadCareerYear != "0" || abroadCareerMonth != "0") {
        $(
          ".formWrapCareer .buttonIsOExperience.devBtnForeignWork"
        ).html("<span>해외근무경험 수정</span>");
        $("#spn_Abroad_Career").show();
      } else {
        $(
          ".formWrapCareer .buttonIsOExperience.devBtnForeignWork"
        ).html("<span>해외 근무 경험 추가하기</span>");
        $("#spn_Abroad_Career").hide();
      }
    };

    var FrgnWork = {};
    FrgnWork.LocalSearchModel = Backbone.Model.extend({});
    FrgnWork.LocalSearchCollection = Backbone.Collection.extend({
      url: "/User/Resume/LocalCodeSearch",
      model: FrgnWork.LocalSearchModel,
    });
    FrgnWork.localSearchCollection =
      new FrgnWork.LocalSearchCollection();
    FrgnWork.Model = Backbone.Model.extend({});
    FrgnWork.Collection = Backbone.Collection.extend({
      model: FrgnWork.Model,
    });

    FrgnWork.collection = new FrgnWork.Collection();
    FrgnWork.Resource = JSON.parse("[]");
    if (FrgnWork.Resource != null) {
      $.each(FrgnWork.Resource, function (idx, resource) {
        FrgnWork.collection.add(resource);
      });
    }

    FrgnWork.View = Backbone.View.extend({
      el: "#popupOWorkExperience",
      initialize: function (options) {
        _.extend(this, options);
        this.searchTemplate = _.template(
          "<li><button type='button' class='button' data-json='<%=itemJson%>'><span><%=HighLight_Text%></span></button></li>"
        );
        this.template = _.template($("#tplFrgnWorkItem").html());
        this.collection.on("add", this.addCollectionItem, this);
        this.collection.on(
          "remove",
          this.removeCollectionItem,
          this
        );
        this.searchCollection.on(
          "sync",
          this.searchCollectionRefresh,
          this
        );
        this.rowNo = 1;
        this.render();
        if (this.collection.size() == 0) {
          this.collection.add(new this.collection.model());
        }
        this.btnShowHide();
      },
      events: {
        "click .buttonAdd": "addItemClick",
        "click .buttonDelete": "deleteItemClick",
        "click .buttonRegister": "registerClick",
      },
      render: function () {
        this.collection.each(function (item) {
          this.addCollectionItem(item);
        }, this);
      },
      addCollectionItem: function (item) {
        var templateData = {
          data: item.toJSON(),
          cid: item.cid,
          no: this.getRowNo(),
        };
        this.$el
          .find(".popupContainer")
          .append(this.template(templateData));
        this.$("[data-comp_type='jkAc']:last").jkAc2({
          collection: this.searchCollection,
          containerQuery: ".row",
        });
      },
      removeCollectionItem: function (item) {
        var cid = item.cid,
          $container = this.$("[name='FrgnWork.index']")
            .filter("[value='" + cid + "']")
            .closest(".row");
        $container.remove();
        this.btnShowHide();
      },
      addItemClick: function (e) {
        if (this.$el.find(".row").size() >= 3) {
          alert("해외 근무 경험을 3개까지 입력 가능합니다.");
          return false;
        }

        if (this.validation(true)) {
          this.collection.add(new this.collection.model());
          this.btnShowHide();
        }
      },
      deleteItemClick: function (e) {
        var $source = $(e.currentTarget),
          $row = $source.closest(".row");

        var cid = $row.find("[name='FrgnWork.index']").val();
        this.collection.remove(this.collection.get(cid));
      },
      btnShowHide: function () {
        this.$el.find(".buttonAdd").hide();
        this.$el.find(".buttonDelete").hide();

        if (this.$el.find(".row").size() >= 3) {
          this.$el.find(".buttonDelete").show();
        } else {
          this.$el.find(".buttonAdd").filter(":last").show();
          this.$el
            .find(".buttonDelete")
            .filter(":not(:last)")
            .show();
        }
      },
      getRowNo: function () {
        return this.rowNo++;
      },
      searchCollectionRefresh: function () {
        var that = this,
          $curInputEle = this.$(
            "[data-comp_type='jkAcInput']:focus"
          ),
          $curResultWrapEle = $curInputEle
            .closest("[data-comp_type='jkAc']")
            .find("[data-comp_type='jkAcResultWrap']");

        $curResultWrapEle.html("<div class='list'><ul></ul><div>");
        $curResultWrapEle.addClass("hidden");

        if ($curInputEle.val() != "") {
          if (this.searchCollection.length > 0) {
            this.searchCollection.each(function (item) {
              var templateData = _.extend(
                {
                  HighLight_Text: item
                    .get("Result_Text")
                    .replace(
                      $curInputEle.val(),
                      "<em>" + $curInputEle.val() + "</em>"
                    ),
                },
                { itemJson: JSON.stringify(item.toJSON()) }
              );
              $curResultWrapEle
                .find(".list ul")
                .append(that.searchTemplate(templateData));
            }, this);
            $curResultWrapEle.removeClass("hidden");
          } else {
          }
        } else {
        }
      },
      registerClick: function (e) {
        var totalTermMonth = 0,
          totalAbroadYear = 0,
          totalAbroadMonth = 0,
          abroadCode = [],
          abroadName = [],
          monthDiff = 0;

        if (this.validation(false)) {
          this.$("[name='FrgnWork.index']").each(function () {
            var idx = $(this).val();
            if ($localCode != "") {
              ($localCode = $("#FrgnWork_Local_Code_" + idx)),
                ($localName = $("#FrgnWork_Local_Name_" + idx)),
                ($localCtgrName = $(
                  "#FrgnWork_Local_Ctgr_Name_" + idx
                )),
                ($sym = $("#FrgnWork_Frgn_SYM_" + idx)),
                ($eym = $("#FrgnWork_Frgn_EYM_" + idx));
              abroadCode.push($localCode.val());
              abroadName.push(
                $localCtgrName.val() + ">" + $localName.val()
              );
              monthDiff = Resume.Utilities.getMonthCnt(
                $sym.val(),
                $eym.val()
              );
              totalTermMonth = totalTermMonth + monthDiff;
            }
          });

          if (totalTermMonth > 0) {
            totalAbroadYear = Math.floor(totalTermMonth / 12);
            $("#spn_Abroad_Career_Term_Year").html(totalAbroadYear);
            totalAbroadMonth = totalTermMonth % 12;
            $("#spn_Abroad_Career_Term_Month").html(
              totalAbroadMonth
            );
            $("#spn_Abroad_Local_Name").html(abroadName.join(", "));
          } else {
            $("#spn_Abroad_Career_Term_Year").html("0");
            $("#spn_Abroad_Career_Term_Month").html("0");
            $("#spn_Abroad_Local_Name").html("");
          }

          window.ResumeForm.Career.CareerTermMsgVisible();
          Resume.Utilities.popupHidden(this.$el);
        }
      },
      showErrorMsg: function ($ele, msg) {
        var $inputWrap = $ele.closest(".input"),
          $validationWrap = $inputWrap.find(".validation"),
          inputTitle = $inputWrap.find("label").html();

        $inputWrap.addClass("error");
        if ($ele.val() == "") {
          $validationWrap.html(
            msg || inputTitle + "을/를 입력해주세요."
          );
        } else {
          $validationWrap.html(
            msg || inputTitle + "을/를 확인해주세요."
          );
        }
        $validationWrap.removeClass("hidden");
      },
      validation: function (isEmptyRowCheck) {
        var that = this;
        var flag = true;
        this.$("[name='FrgnWork.index']").each(function () {
          var idx = $(this).val();
          ($localCode = $("#FrgnWork_Local_Code_" + idx)),
            ($sym = $("#FrgnWork_Frgn_SYM_" + idx)),
            ($eym = $("#FrgnWork_Frgn_EYM_" + idx));
          if (
            !(
              isEmptyRowCheck == false &&
              $localCode.val() == "" &&
              $sym.val() == "" &&
              $eym.val() == ""
            )
          ) {
            if ($localCode.val() == "") {
              that.showErrorMsg($localCode);
              flag = false;
              return;
            }
            if (!Resume.Utilities.isValidYearMonth($sym.val())) {
              that.showErrorMsg($sym);
              flag = false;
              return;
            }
            if (!Resume.Utilities.isValidYearMonth($eym.val())) {
              that.showErrorMsg($eym);
              flag = false;
              return;
            }

            var monthDiff = Resume.Utilities.getMonthCnt(
              $sym.val(),
              $eym.val()
            );
            if (monthDiff < 0) {
              that.showErrorMsg($sym, "기간을 확인해주세요.");
              that.showErrorMsg($eym, "기간을 확인해주세요.");
              flag = false;
              return;
            }
          }
        });

        return flag;
      },
    });

    var frgnWorkView = new FrgnWork.View({
      collection: FrgnWork.collection,
      searchCollection: FrgnWork.localSearchCollection,
    });
  });