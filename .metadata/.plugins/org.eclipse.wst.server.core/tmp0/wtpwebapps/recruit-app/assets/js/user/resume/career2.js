$(function () {
    var KeywordModel = Backbone.Model.extend({});
    window.ResumeForm.Career.KeywordSearchCollection =
      Backbone.Collection.extend({
        url: "/User/Resume/PartKeywordSearch",
        model: KeywordModel,
      });

    window.ResumeForm.Career.DutySelectView = Backbone.View.extend({
      el: "#dutySelectPop",
      initialize: function (options) {
        _.extend(this, options);

        this.keywordSearchCollection.on(
          "sync",
          this.keywordSearchResultBind,
          this
        );
        this.keywordtemplate = _.template(
          $("#tplKeywordCheckBox").html()
        );
        this.tplDepth = _.template($("#tplDepthCommonItem").html());
        this.tplCommonSearch = _.template(
          $("#tplCommonSearch").html()
        );
        //this.applyKeywordCnt();
      },
      events: {
        "click  .listDutyStep1 .button": "dutyStep1Click",
        "click  .listDutyStep2 :button": "dutyStep2Click",
        "click  .colKeyword .list ul :checkbox": "dutyStep3Click",
        "click  .buttonConfirm": "dutySelectConfirm",
        "click  .direct .buttonInput": "directInputClick", //키워드 직접 입력
        "click  .listSelected .buttonReset": "resetClick", //선택 키워드 초기화
        "click  .listSelected .buttonDelete":
          "selectedKeywordDelClick", //선택 특정 키워드 제거
        "keyup  #Career_JobSearchText": "searchTextKeyUp",
      },
      init: function ($caller) {
        var caller = $caller,
          that = this,
          container = caller.closest(".container"),
          partCtgrCode = container
            .find("[data-type='M_MainField_Ctgr']")
            .val(),
          partCode = container
            .find("[data-type='M_MainField']")
            .val(), //2depth
          keywords = container
            .find("[data-type='M_MainJob']")
            .val(),
          directKeywords = container
            .find("[data-type='Job_Field_Direct']")
            .val(),
          $depth1btn,
          $depth2Btn;

        this.$caller = $caller;

        this.$el
          .find(".listDutyStep1 :button")
          .removeClass("selected");
        this.$el
          .find(".listDutyStep2 :button")
          .removeClass("selected");

        this.resetKeyword();
        $(".dev-direct-item").remove(); // 직접입력키워드 초기화

        var dirtKwrdArray = directKeywords.split("/");
        var kwrdArray = keywords.split("/");
        $.each(dirtKwrdArray, function (idx, direct) {
          $.each(kwrdArray, function (idx, kwrd) {
            if (direct == kwrd) {
              kwrdArray.splice(idx, 1);
            }
          });
        });

        if (partCtgrCode !== "") {
          var that = this;
          $depth1btn = $(
            ".listDutyStep1 :button[data-value='" +
              partCtgrCode +
              "']"
          );
          $depth1btn.trigger("foucs").trigger("click");
          if (partCode > 0) {
            $depth2btn = $(
              "#listDutyStep2 :button[data-value='" +
                partCode +
                "']"
            );
            $depth2btn.trigger("focus").addClass("selected");
            this.setPart($depth2btn);
          }
          this.bindKeyword(
            partCode,
            function () {
              if (kwrdArray.length > 0) {
                //var keyword = keywords.split("/");
                for (var i = 0; i < kwrdArray.length; i++) {
                  var $obj = $(
                    "#listDutyStep3 :checkbox[data-lower-text='" +
                      kwrdArray[i].trim().toLowerCase() +
                      "']"
                  );
                  if ($obj.size() > 0) {
                    $obj.trigger("click");
                  }
                }
              }
            },
            this
          );
        } else {
          this.$(".listDutyStep1 :button").removeClass("selected");
        }

        if (directKeywords != "") {
          for (var i = 0; i < dirtKwrdArray.length; i++) {
            that.setKeyword(dirtKwrdArray[i]);
          }
        }

        this.dutyStep1SelectedCheck();
        this.dutyStep2SelectedCheck();

        this.$el.find("[data-comp_type='jkAc']").jkAc2({
          collection: this.keywordSearchCollection,
          containerQuery: ".container",
          emptyKeywordMsgShow: false,
          parentView: that,
          callback: that.keywordSearchSelect,
        });
      },
      setPart: function ($target) {
        var partCode = $target.data("value"),
          partName = $target.data("name");
        var item = {
          Key_No: partCode,
          Keyword: partName,
          Key_Type: "part",
        };
        //$(_.template($("#tplSelectedKeyword").html(), item)).insertBefore(this.$(".listSelected .buttonReset"))
        this.$(".listSelected")
          .find(".dev-select-item .depth2-item")
          .append(
            $(_.template($("#tplSelectedKeywordNew").html(), item))
          );

        if (
          this.$(".listSelected")
            .find(".dev-select-item")
            .hasClass("blind")
        ) {
          this.$(".listSelected")
            .find(".dev-select-item")
            .removeClass("blind");
        }
      },
      setKeyword: function (directKeyword) {
        var item = {
          Key_No: directKeyword,
          Keyword: directKeyword,
          Key_Type: "keyword",
        };
        var $listSelected = $(".listSelected");

        if ($listSelected.find(".self").length == 0) {
          $listSelected
            .find(".list-selected-item")
            .after(
              "<div class='list-selected-item self dev-direct-item'><div class='item depth2-item'></div></div>"
            );
        }

        var $direct = this.$(".listSelected").find(".self");
        $direct
          .find(".depth2-item")
          .append(
            $(_.template($("#tplSelectedKeywordNew").html(), item))
          );
      },
      keywordSearchSelect: function (e) {
        var that = this,
          json = $(e.currentTarget).data("json"),
          prevCtgrCode = this.$el
            .find(".listDutyStep1 .selected")
            .data("value"),
          prevPartCode = this.$el
            .find(".listDutyStep2 .selected")
            .data("value");

        // 직접입력
        if (typeof json == "undefined") {
          var directKeyword = $(e.currentTarget).data("text");
          this.directInputClick(directKeyword);
        } else {
          // 기존 코드
          if (prevCtgrCode != json.Part_Ctgr_Code) {
            this.$el
              .find(".listDutyStep1 .selected")
              .removeClass("selected");
            var $depth1btn = this.$el.find(
              ".listDutyStep1 :button[data-value='" +
                json.Part_Ctgr_Code +
                "']"
            );
            $depth1btn.trigger("foucs").trigger("click");
          }

          if (prevPartCode != json.Part_Code) {
            this.$el
              .find(".listDutyStep2 .selected")
              .removeClass("selected");
            var $depth2btn = this.$el.find(
              ".listDutyStep2 :button[data-value='" +
                json.Part_Code +
                "']"
            );
            $depth2btn.trigger("click", [{ bindFlag: "N" }]);
            this.bindKeyword(
              json.Part_Code,
              function () {
                if (json.Key_No) {
                  that.$el
                    .find(
                      ".colKeyword :checkbox[value='" +
                        json.Key_No +
                        "']"
                    )
                    .click();
                }
              },
              this
            );
          } else {
            that.$el
              .find(
                ".colKeyword :checkbox[value='" + json.Key_No + "']"
              )
              .click();
          }
        }
      },
      keywordSearchResultBind: function () {
        // 담당직무 검색
        var that = this;
        var searchText = $("#dutySearchAutoComplete")
          .find('[data-comp_type="jkAcInput"]')
          .val();
        if (this.keywordSearchCollection.length > 0) {
          this.$el
            .find(".popupSearchDuty")
            .html("<div class='list'><ul></ul></div>");
          this.keywordSearchCollection.each(function (item) {
            that.$el
              .find(".popupSearchDuty .list ul")
              .append(
                that.tplCommonSearch(
                  _.extend(
                    { itemJson: JSON.stringify(item.toJSON()) },
                    {
                      Highlight_Name: item
                        .get("Result_Text")
                        .replace(
                          searchText,
                          "<em>" + searchText + "</em>"
                        ),
                    }
                  )
                )
              );
          });
        } else {
          this.$el
            .find(".popupSearchDuty")
            .html(
              "<button type='button' class='button text notFound' data-text='" +
                searchText +
                "'><span><em>" +
                searchText +
                "</em> 직접입력</span></button>"
            );
        }

        this.$el.find(".popupSearchDuty").removeClass("hidden");
      },
      dutyStep1Click: function (e) {
        var that = this,
          $source = $(e.currentTarget),
          partCtgrCode = $source.data("value"),
          $subUl = this.$("#listDutyStep2 ul");

        if ($source.hasClass("selected")) {
          event.preventDefault();
          return;
        }
        $(".listDutyStep1 :button").removeClass("selected");
        $("#listDutyStep2 :button").removeClass("selected");
        $source.addClass("selected");
        $subUl.html("");

        var filterData =
          window.ResumeForm.PartCollection.byPartCtgr(partCtgrCode);
        $(filterData).each(function () {
          var item = this.toJSON();
          $subUl.append(
            that.tplDepth({
              code: item.Part_Code,
              text: item.Part_Name,
              ctgr: item.Part_Ctgr_Code,
            })
          );
        });

        this.resetKeyword();
        this.dutyStep1SelectedCheck();
        this.dutyStep2SelectedCheck();
        //this.applyKeywordCnt();
      },
      dutyStep2Click: function (e, data) {
        var bindFlag =
          typeof data == "undefined" || data == "" || data == null
            ? "Y"
            : data.bindFlag;
        var $source = $(e.currentTarget),
          partCode = $source.data("value"),
          partName = $source.data("name"),
          partCtgrCode = $source.data("ctgr_value");

        if ($source.hasClass("selected")) {
          event.preventDefault();
          return;
        }
        $("#listDutyStep2 :button").removeClass("selected");
        $source.addClass("selected");
        this.dutyStep2SelectedCheck();
        if (bindFlag == "Y") {
          this.bindKeyword(partCode, function () {}, this);
        }
        this.resetKeyword();
        //$(".dev-select-item").addClass("blind");
        if (
          this.$(".listSelected")
            .find(".dev-select-item")
            .hasClass("blind")
        ) {
          this.$(".listSelected")
            .find(".dev-select-item")
            .removeClass("blind");
        }
        var item = {
          Key_No: partCode,
          Keyword: partName,
          Key_Type: "part",
        };
        this.$(".listSelected")
          .find(".dev-select-item .depth2-item")
          .append(
            $(_.template($("#tplSelectedKeywordNew").html(), item))
          );
        //this.applyKeywordCnt();
      },
      dutyStep3Click: function (e) {
        var $source = $(e.currentTarget),
          flagChecked = $source.is(":checked"),
          selctedCode = $source.val(),
          selctedText = $source.data("text"),
          item = {
            Key_No: selctedCode,
            Keyword: selctedText,
            Key_Type: "keyword",
          };

        if (flagChecked && this.selectedKeywordCnt() >= 5) {
          e.preventDefault();
          alert("전문분야는 최대 5개까지 선택 가능합니다.");
          return;
        }

        if (
          this.$(".listSelected").find(".depth3-item").length == 0
        ) {
          this.$(".listSelected")
            .find(".dev-select-item")
            .append("<div class='item depth3-item'></div>");
        }

        if (flagChecked) {
          this.$(".listSelected")
            .find(".dev-select-item .depth3-item")
            .append(
              $(
                _.template($("#tplSelectedKeywordNew").html(), item)
              )
            );
        } else {
          this.$(".listSelected .depth3-item")
            .find(":button[data-code='" + selctedCode + "']")
            .remove();
          if (
            this.$(
              ".listSelected .dev-select-item .depth3-item"
            ).find(".dev-button-item").length == 0
          ) {
            this.$(
              ".listSelected .dev-select-item .depth3-item"
            ).remove();
          }
        }

        if (
          this.$(".listSelected")
            .find(".dev-select-item")
            .hasClass("blind")
        ) {
          this.$(".listSelected")
            .find(".dev-select-item")
            .removeClass("blind");
        }

        //this.applyKeywordCnt();
      },
      dutySelectConfirm: function (e) {
        var that = this;
        var selectedMainJobCtgrCode = "",
          selectedMainJobCode = "",
          selectedKeyword = [],
          directkeyword = [],
          isValid = true,
          $caller_InputWrap = this.$caller.closest(".input");
        var partName = "";

        selectedMainJobCtgrCode = this.$(
          ".listDutyStep1 ul :button"
        )
          .filter(".selected")
          .data("value");
        selectedMainJobCode = this.$("#listDutyStep2 ul :button")
          .filter(".selected")
          .data("value");

        // 키워드 넣어줌

        this.$el
          .find(".listSelected .buttonDelete")
          .each(function () {
            if (
              $(this).parent().parent().hasClass("dev-select-item")
            ) {
              if ($(this).data("type") == "keyword") {
                var keyword = $(this).find("span").html();
                if (!that.validationChecker(keyword)) {
                  isValid = false;
                  return false;
                }
                selectedKeyword.push(keyword);
              } else {
                partName = $(this).find("span").html();
              }
            } else {
              if ($(this).data("type") == "keyword") {
                var keyword = $(this).find("span").html();
                if (!that.validationChecker(keyword)) {
                  isValid = false;
                  return false;
                }
                directkeyword.push(keyword);
              }
            }
          });

        if (isValid) {
          $caller_InputWrap
            .find("[data-type='M_MainField_Ctgr']")
            .val(selectedMainJobCtgrCode);
          $caller_InputWrap
            .find("[data-type='M_MainField']")
            .val(
              selectedMainJobCode == null
                ? "0"
                : selectedMainJobCode
            );

          var keywords = selectedKeyword.join("/");
          var viewkeywords = selectedKeyword.join(",");
          var directkeywords = directkeyword.join("/");
          var viewDirectkeywords = directkeyword.join(",");
          var totalKeyword =
            keywords == ""
              ? directkeywords
              : keywords + "/" + directkeywords;

          if (
            keywords == "" &&
            partName == "" &&
            directkeyword == ""
          ) {
            $caller_InputWrap.removeClass("is-value");
          } else {
            $caller_InputWrap.addClass("is-value");
          }

          var displayStr = "";
          if (viewkeywords == "") {
            //displayStr = partName;
            if (viewDirectkeywords == "") displayStr = partName;
            else
              displayStr =
                partName == ""
                  ? viewDirectkeywords
                  : partName + "," + viewDirectkeywords;
          } else {
            //displayStr = (partName == "") ? viewkeywords : partName + ">" + viewkeywords;
            if (viewDirectkeywords == "")
              displayStr =
                partName == ""
                  ? viewkeywords
                  : partName + ">" + viewkeywords;
            else
              displayStr =
                partName == ""
                  ? viewkeywords + "," + viewDirectkeywords
                  : partName +
                    ">" +
                    (viewkeywords + "," + viewDirectkeywords);
          }
          $caller_InputWrap.find(".value").html(displayStr); // 담당직무 노출되는 div
          //$caller_InputWrap.find(".value").html(keywords);
          $caller_InputWrap
            .find("[data-type='M_MainJob']")
            .val(totalKeyword);
          $caller_InputWrap
            .find("[data-type='Job_Field_Direct']")
            .val(directkeywords);
          this.$el.addClass("hidden");
        }
      },
      searchDutyClick: function (e) {
        var $source = $(e.currentTarget),
          jsonData = $source.data("json"),
          partCtgrCode = jsonData.Part_Ctgr_Code,
          partCode = jsonData.Part_Code,
          Key_No = jsonData.Key_No,
          prevPartCode = $("#listDutyStep2 .selected").data(
            "value"
          ),
          $depth1Btn = $(
            ".listDutyStep1 :button[data-value='" +
              partCtgrCode +
              "']"
          ),
          $depth2Btn;

        if (partCode != prevPartCode) {
          $(".listDutyStep1 :button").removeClass("selected");
          $("#listDutyStep2 :button").removeClass("selected");
          $depth1Btn.trigger("focus").trigger("click");
          $depth2Btn = $(
            "#listDutyStep2 :button[data-value='" + partCode + "']"
          );
          $depth2Btn.trigger("focus").addClass("selected");
          this.dutyStep2SelectedCheck();

          this.bindKeyword(
            partCode,
            function () {
              var $depth3Btn = $(
                ".colKeyword .list ul :checkbox[value='" +
                  Key_No +
                  "']"
              );
              $depth3Btn.trigger("click");
              var $btnWrap = $depth3Btn.closest("li");
              $(".colKeyword .list").scrollTop(
                $btnWrap.position().top - $btnWrap.height()
              );
            },
            this
          );
        } else {
          var $depth3Btn = $(
            ".colKeyword .list ul :checkbox[value='" + Key_No + "']"
          );
          $depth3Btn.trigger("click");
          var $btnWrap = $depth3Btn.closest("li");
          $(".colKeyword .list").scrollTop(
            $btnWrap.position().top - $btnWrap.height()
          );
        }

        $(".popupSearchDuty").addClass("hidden");
        $("#Career_JobSearchText").val("");
      },
      bindKeyword: function (partCode, callback, $this) {
        var $subUl = this.$el.find(".colKeyword .list ul");
        $subUl.html("");
        $.getJSON(
          "/User/Resume/GetKeyword",
          { partCode: partCode },
          function (subJsonData) {
            for (var i = 0; i < subJsonData.length; i++) {
              subJsonData[i].KeywordLowerCase =
                subJsonData[i].Keyword.toLowerCase();
              $subUl.append(
                $this.keywordtemplate(
                  _.extend(subJsonData[i], {
                    Form: "career",
                    isChecked: "",
                  })
                )
              );
            }

            if (subJsonData.length == 0) {
              $("#listDutyStep3").hide();
              $("#listDutyStep3Message .message")
                .text("← 전문분야 미제공 직무입니다")
                .show();
              $("#listDutyStep3Message").show();
            }
            callback();
          }
        );
      },
      resetKeyword: function () {
        $(".dev-select-item .item").remove();
        if (
          !this.$(".listSelected")
            .find(".dev-select-item")
            .hasClass("blind")
        ) {
          this.$(".listSelected")
            .find(".dev-select-item")
            .addClass("blind");
        }
        //$(".dev-direct-item").remove(); //직접입력 키워드 초기화
        this.$(".listSelected")
          .find(".dev-select-item")
          .append("<div class='item depth2-item'></div>");
        $(".colKeyword .list :checkbox:checked").attr(
          "checked",
          false
        );
      },
      selectedKeywordCnt: function () {
        var selectedKwrdCnt = $(
          ".formCareer .listSelected .dev-select-item .depth3-item .dev-button-item"
        ).size();
        var directKwrdCnt = $(
          ".formCareer .listSelected .dev-direct-item .dev-button-item"
        ).size();
        return selectedKwrdCnt + directKwrdCnt;
      },
      selectedJobTypeCnt: function () {
        return this.$el.find(".listDutyStep1 .selected").size();
      },
      validationChecker: function (keyword) {
        if (keyword == "") {
          alert("키워드를 입력해주세요.");
          return false;
        }
        if (keyword.length > 50) {
          alert("키워드는 50자를 넘을 수 없습니다.");
          return false;
        }
        var blank_pattern = /[\s]/g;
        if (blank_pattern.test(keyword) == true) {
          alert("직접입력 키워드는 공백이 허용되지 않습니다. ");
          return false;
        }

        return true;
      },

      directInputClick: function (directKeyword) {
        var that = this;

        if (this.selectedKeywordCnt() >= 5) {
          alert("전문분야는 최대 5개까지 선택 가능합니다.");
          return false;
        }

        if (
          $(
            ".listSelected button[data-code='" +
              directKeyword +
              "']"
          ).size() > 0
        ) {
          alert("이미 등록된 키워드 입니다.");
          return false;
        }

        if (that.validationChecker(directKeyword)) {
          that.setKeyword(directKeyword);
        }
      },
      resetClick: function (e) {
        $(".listDutyStep1 :button").removeClass("selected");
        $("#listDutyStep2 :button").removeClass("selected");
        $(".dev-direct-item").remove();
        $(".dev-select-item").addClass("blind");
        this.resetKeyword();
        //this.applyKeywordCnt();
        this.dutyStep1SelectedCheck();
        this.dutyStep2SelectedCheck();
      },
      selectedKeywordDelClick: function (e) {
        var $source = $(e.currentTarget),
          $item = $source.closest(".item"),
          code = $source.data("code");

        // 직접
        if ($source.parent().parent().hasClass("dev-direct-item")) {
          var $directKwrdParent = $source.parent().parent();
          $source.remove();
          if (
            $directKwrdParent.find(".dev-button-item").length == 0
          )
            $(".dev-direct-item").remove();
        } else {
          if ($.isNumeric(code)) {
            $("#career_M_MainJob_" + code).prop("checked", false);
          }

          if ($item.hasClass("depth2-item")) {
            $source.remove();
            $("#listDutyStep2 :button").removeClass("selected");
            //3depth 삭제
            var partCode = $source.data("value");
            $item
              .closest(".list-selected-item")
              .find(".depth3-item")
              .remove();
            this.resetKeyword();
            this.dutyStep2SelectedCheck();
          } else {
            $source.remove();
            this.dutyStep3SelectedCheck();
          }
        }

        //this.applyKeywordCnt();
      },
      //applyKeywordCnt: function () {
      //    $(".colKeyword .selection em").html(this.selectedKeywordCnt());
      //    this.$el.find(".colDuty .selection em").html(this.selectedJobTypeCnt());
      //},
      dutyStep1SelectedCheck: function () {
        if (this.$(".listDutyStep1 .selected").size() > 0) {
          this.$("#listDutyStep2").show();
          this.$("#listDutyStep2Message").hide();
        } else {
          this.$("#listDutyStep2").hide();
          this.$("#listDutyStep2 ul").html("");
          this.$("#listDutyStep2Message").show();
        }
      },
      dutyStep2SelectedCheck: function () {
        if (this.$("#listDutyStep2 .selected").size() > 0) {
          $("#listDutyStep3").show();
          $("#listDutyStep3Message").hide();
        } else {
          $("#listDutyStep3").hide();
          this.$("#listDutyStep3 ul").html("");
          $("#listDutyStep3Message .message")
            .text("← 직무를 선택해주세요")
            .show();
          $("#listDutyStep3Message").show();
        }
      },
      dutyStep3SelectedCheck: function () {
        if (
          this.$(".listSelected .depth3-item").find(
            ".dev-button-item"
          ).length == 0
        ) {
          this.$(".listSelected .depth3-item").remove();
        }
      },
      searchTextKeyUp: function () {
        if ($("#Career_JobSearchText").val() == "") {
          this.$el.find(".popupSearchDuty").addClass("hidden");
        }
      },
    });
  });