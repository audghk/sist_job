$(function () {
    // spell check
    var $formIntroduction = $(".formWrapIntroduction"),
      $textarea = $formIntroduction.find(".textarea-introduction"),
      $buttonCheck = $formIntroduction.find(
        ".butttonCheckSpelling"
      ),
      $buttonCheckEnd = $formIntroduction.find(".buttonCheckEnd"),
      $popupCheckSpelling = $formIntroduction.find(
        ".popupCheckSpelling"
      ),
      $checkSpellingResult = $formIntroduction.find(
        ".checkSpellingResult"
      ),
      $checkSpellingResultCounter =
        $checkSpellingResult.find("strong"),
      $isInit = false;
    $fullpage = $(".fullpage-introduction");
    var Spell = Spell || {};
    Spell.IsCheck = false;
    var introduceModel = Backbone.Model.extend({
      defaults: function () {
        return {
          Header: "",
          Contents: "",
        };
      },
    });

    function whichAnimationEvent() {
      var t,
        el = document.createElement("fakeelement");

      var animations = {
        animation: "animationend",
        OAnimation: "oAnimationEnd",
        MozAnimation: "animationend",
        WebkitAnimation: "webkitAnimationEnd",
      };

      for (t in animations) {
        if (el.style[t] !== undefined) {
          return animations[t];
        }
      }
    }

    var IntroduceCollection = Backbone.Collection.extend({
      model: introduceModel,
    });
    var introduceCollection = new IntroduceCollection(
      JSON.parse("null")
    );
    var IntroduceView = Backbone.View.extend({
      el: "#formIntroduction",
      spellCheckView: null,
      initialize: function (options) {
        _.extend(this, options);
        var that = this;
        this.introduceArea = this.$("#introduceContainers");
        this.tplIntroduceItem = _.template(
          $("#tplIntroduceItem").html()
        );
        if (this.introduceCollection.size() == 0) {
          that.addItemClick();
          $(".buttonChangeList").hide(); // 순서변경 버튼 지우기
        }
        this.render();
      },
      events: {
        "click .buttonAddField": "addItemClick",
        "click .buttonDelete": "removeItemclick",
        "keyup [id^='ResumeProfile_Contents_']": "profileKeyup",
        "click .butttonCheckSpelling": "spellCheckClick",
        "click .buttonChangeList": "buttonChangeListClick",
        "click .buttonConfirm": "buttonListOrderConfirmClick",
      },
      render: function () {
        var that = this;

        that.introduceArea.html("");

        this.introduceCollection.each(function (item) {
          that.introduceArea.append(
            that.tplIntroduceItem(
              _.extend(item.toJSON(), { cid: item.cid })
            )
          );
        });
        this.$("[id^='ResumeProfile_Contents_']").each(function () {
          that.profileCharCount($(this));
        });
      },
      addItemClick: function () {
        this.addCollectionItem(
          new this.introduceCollection.model()
        );
      },
      addCollectionItem: function (item) {
        var that = this;
        var templateData = _.extend(item.toJSON(), {
          cid: item.cid,
        });
        this.introduceArea.append(
          this.tplIntroduceItem(templateData)
        );

        //자기소개서 항목 생기면 순서변경버튼 보여주기
        $(".buttonChangeList").show();
      },
      removeItemclick: function (e) {
        var $btn = $(e.currentTarget),
          $container = $btn.closest(".row"),
          cid = $container.data("cid");
        this.introduceCollection.remove(
          this.introduceCollection.get(cid)
        );
        $container.remove();

        //자기소개서 항목 전부 지웠을경우 순서변경 지우기
        if ($("#introduceContainers").find(".row").size() == 0) {
          $(".buttonChangeList").hide();
          $("#InputStat_UserIntroduceInputStat").val("False");
        }
      },
      profileKeyup: function (e) {
        this.profileCharCount($(e.currentTarget));
      },
      profileCharCount: function ($ele) {
        var $row = $ele.closest(".row"),
          len = $ele.val().length;

        $row.find(".counting em").html(this.numberWithCommas(len));
      },
      numberWithCommas: function (x) {
        if (!x) {
          return "";
        }

        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      },
      spellCheckClick: function () {
        var that = this;

        // spell check
        var $fullpage = $(".fullpage-introduction"),
          $checkSpellingResult = $fullpage.find(".result"),
          $checkSpellingResultCounter =
            $checkSpellingResult.find("strong");

        if (!that.validateSpellCheck()) {
          alert(
            "맞춤법 검사는 자기소개서를 입력해야지 가능합니다."
          );
          return false;
        }

        var introduceData = that.makeIntroduceData();

        if (!this.spellCheckView) {
          this.spellCheckView = new SpellCheckView({
            parent: that,
            introduce: introduceData,
          });
        } else {
          this.spellCheckView.setOptions({
            introduce: introduceData,
          });
          this.spellCheckView.render();
        }
      },

      buttonChangeListClick: function () {
        var that = this;
        var introductionData = that.makeIntroduceDataForList().json;

        ui.user.resumemng.selfIntroduction.popupChangeList.setData(
          introductionData
        );
        ui.user.resumemng.selfIntroduction.popupChangeList.attached();
        ui.user.resumemng.selfIntroduction.popupChangeList.initialize();
      },
      buttonListOrderConfirmClick: function () {
        var that = this;
        var introductionData = that.setIntroduceDataForList().json;

        if (introductionData.length) {
          this.initialize({
            introduceCollection: new IntroduceCollection(
              introductionData
            ),
          });
          $(".formIntroduction").find("textarea").trigger("input");
        }
        ui.user.resumemng.selfIntroduction.popupChangeList.detached();
      },

      textareaScroll: function (e) {
        var $textareaTag = $(e.currentTarget),
          scrollTop = $textareaTag.scrollTop(),
          $textareaComp = $textareaTag.closest(".textarea"),
          $clickArea = $textareaComp.find(".clickable");

        $clickArea.find("button").each(function () {
          var initTop = $(this).data("init_top").val();
          $(this).offset.top = initTop + scrollTop;
        });
      },
      validateSpellCheck: function () {
        var isValidate = false;

        this.$el
          .find("input[name='ResumeProfile.Index']")
          .each(function () {
            var cIdx = this.value;

            if (
              $.trim($("#ResumeProfile_Header_" + cIdx).val()) !=
                "" ||
              $.trim($("#ResumeProfile_Contents_" + cIdx).val()) !=
                ""
            ) {
              isValidate = true;
              return false;
            }
          });

        return isValidate;
      },
      makeIntroduceData: function () {
        var obj = {
          json: [],
          text: "",
        };

        this.$el
          .find("input[name='ResumeProfile.Index']")
          .each(function () {
            var cIdx = this.value;
            var header = $("#ResumeProfile_Header_" + cIdx).val();
            var contents = $(
              "#ResumeProfile_Contents_" + cIdx
            ).val();

            obj.json.push({
              Header: header,
              Contents: contents,
            });

            obj.text += header + "\n" + contents + "\n";
          });

        return obj;
      },

      makeIntroduceDataForList: function () {
        var obj = {
          json: [],
          text: "",
        };

        var i = 1;
        this.$el
          .find("input[name='ResumeProfile.Index']")
          .each(function () {
            var cIdx = this.value;
            var header = $("#ResumeProfile_Header_" + cIdx).val();
            var contents = $(
              "#ResumeProfile_Contents_" + cIdx
            ).val();

            obj.json.push({
              index: i,
              header: header,
              description: contents,
            });

            obj.text += header + "\n" + contents + "\n";
            i++;
          });

        return obj;
      },
      setIntroduceDataForList: function () {
        var obj = {
          json: [],
          text: "",
        };

        this.$el.find(".list-item").each(function () {
          var header = $.trim(
            $(this).find(".content-header").html()
          );
          var contents = $.trim(
            $(this).find(".content-description").html()
          );

          if (header != "") {
            header = stripHtml(
              replaceAll(
                $.trim($(this).find(".content-header").html()),
                "<br>",
                "\r\n"
              )
            );
          }

          if (contents != "") {
            contents = stripHtml(
              replaceAll(
                $.trim($(this).find(".content-description").html()),
                "<br>",
                "\r\n"
              )
            );
          }

          obj.json.push({
            Header: header,
            Contents: contents,
          });

          obj.text += header + "\n" + contents + "\n";
        });

        return obj;
      },
    });

    var SpellCheckView = Backbone.View.extend({
      el: ".fullpage-introduction",
      wordEditLayerView: null,
      options: {
        parent: null,
        introduce: null,
        words: [],
      },
      initialize: function (options) {
        this.setOptions(options);
        this.introduceArea = this.$("#devSpellCheckIntroduce");
        this.tplIntroduceItem = _.template(
          $("#tplSpellCheckIntroduceItem").html()
        );
        this.tplErrorButton = _.template(
          $("#tplSpellCheckErrorButton").html()
        );
        this.wordEditLayerView = new WordEditLayerView();
        this.render();
      },
      events: {
        "click .buttonCheckEnd": "buttenCheckEndClick",
        "click .butttonCheckSpelling": "butttonCheckSpellingClick",
        "click .devErrorWord": "devErrorWordClick",
      },
      setOptions: function (options) {
        _.extend(this.options, options);
      },
      show: function () {
        $("html").css("overflow", "hidden");
        $(".fullpage")
          .removeClass("fadeOut")
          .addClass("fadeIn")
          .attr("aria-hidden", "false");
      },
      hide: function () {
        $("html").css("overflow", "inherit");
        $(".fullpage")
          .removeClass("fadeIn")
          .addClass("fadeOut")
          .attr("aria-hidden", "true");
      },
      showContents: function () {
        this.$el.find(".fullpage-header").show();
        this.$el.find(".fullpage-body").show();
      },
      hideContents: function () {
        this.$el.find(".fullpage-header").hide();
        this.$el.find(".fullpage-body").hide();
      },
      setErrorWordsCount: function () {
        if (this.$el.find(".devErrorWord").length) {
          this.$el
            .find(".result")
            .html(
              "맞춤법에 어긋난 단어가 <strong>" +
                this.$el.find(".devErrorWord").length +
                "개</strong> 있습니다."
            );
        } else {
          this.$el
            .find(".result")
            .html("맞춤법에 어긋난 단어가 없습니다.");
        }
      },
      createGuid: function createGuid() {
        function S4() {
          return (((1 + Math.random()) * 0x10000) | 0)
            .toString(16)
            .substring(1);
        }
        return (
          S4() +
          S4() +
          "-" +
          S4() +
          "-4" +
          S4().substr(0, 3) +
          "-" +
          S4() +
          "-" +
          S4() +
          S4() +
          S4()
        ).toLowerCase();
      },
      getUniqueWords: function () {
        var uniqueWords = [];

        var prevWord = null;
        var i = 0;

        if (!this.options.words.length) {
          return uniqueWords;
        }

        do {
          if (
            !prevWord ||
            (prevWord &&
              prevWord.errorWord !==
                this.options.words[i].errorWord)
          ) {
            prevWord = this.options.words[i];
            uniqueWords.push(this.options.words[i]);
          }

          i++;
        } while (i < this.options.words.length);

        return uniqueWords;
      },
      setErrorWordsDataIndex: function () {
        // 교정 단어 인덱스 설정
        this.$el.find(".devErrorWord").each(function (i) {
          $(this).attr("data-index", i + 1);
        });
      },
      drawIntroduce: function () {
        var cloneData = this.options.introduce.json.slice(0);
        var uniques = this.getUniqueWords();
        var mappingErrorWords = {};

        for (var j = 0; j < cloneData.length; j++) {
          var item = cloneData[j];
          var header = item.Header;
          var contents = replaceAll(item.Contents, "\r\n", "<br>");
          contents = replaceAll(contents, "\n", "<br>");

          // 교정 가능한 단어 태그로 치환
          for (var i = 0; i < uniques.length; i++) {
            var word = uniques[i];
            var guid = this.createGuid();
            header = replaceAll(header, word.errorWord, guid);
            contents = replaceAll(contents, word.errorWord, guid);

            mappingErrorWords[guid] = this.tplErrorButton(word);
          }

          var changeData = {
            Header: header,
            Contents: contents,
          };

          cloneData[j] = changeData;
        }

        // 자기소개서 영역에 그린다
        for (var i = 0; i < cloneData.length; i++) {
          var item = cloneData[i];
          var header = item.Header;
          var contents = item.Contents;

          for (var key in mappingErrorWords) {
            header = replaceAll(
              header,
              key,
              mappingErrorWords[key]
            );
            contents = replaceAll(
              contents,
              key,
              mappingErrorWords[key]
            );
          }

          this.introduceArea.append(
            this.tplIntroduceItem({
              Header: header,
              Contents: contents,
            })
          );
        }

        // 교정 단어 인덱스 설정
        this.setErrorWordsDataIndex();
      },

      executeSpellCheck: function () {
        if (Spell.IsCheck) {
          alert("맞춤법 검사 진행중입니다. 잠시만 기다려주세요.");
          return;
        }

        var that = this;
        that.showContents();
        ui.user.resumemng.spellcheck.progressbar.once(function () {
          $.ajax({
            url: "/User/Resume/SpellChecker",
            data: {
              checkString: encodeURIComponent(
                that.options.introduce.text
              ),
            },
            type: "post",
            timeout: 30000,
            beforeSend: function () {
              Spell.IsCheck = true;
            },
            complete: function () {
              Spell.IsCheck = false;
            },
            error: function (xmlhttprequest, textstatus, message) {
              if (textstatus === "timeout") {
                alert(
                  "너무 많은 데이터를 입력하여 검사가 정상적으로 되지 않습니다."
                );
              } else {
                alert(
                  "맞춤법 검사에서 알수 없는 문제가 발생 했습니다.\n교정하려는 문장을 고객센터에 보내주시면\n자세한 분석 후 안내해드리겠습니다.\n\n[잡코리아 고객센터]\nhelpdesk@jobkorea.co.kr"
                );
              }
            },
            success: function (result) {
              if (result.returnCode < 0) {
                var msg = "";

                switch (result.returnCode) {
                  case -1:
                    alert("자기소개서를 입력해 주세요.");
                    break;
                  case -2:
                    alert("스크립트를 입력 할 수 없습니다.");
                    break;
                  default:
                    alert(
                      "데이터 통신중 오류가 발생하였습니다. code:" +
                        result.returnCode
                    );
                    break;
                }
              } else {
                that.introduceArea.html("");
                that.options.words = result.data;
                that.drawIntroduce();
                that.wordEditLayerView.setOptions({
                  parent: that,
                  words: that.options.words,
                  $errorWords: that.$el.find(".devErrorWord"),
                });
                that.wordEditLayerView.show(0);
                that.showContents();
              }
            },
          });
        });
      },
      setIntroduceData: function () {
        var obj = {
          json: [],
          text: "",
        };

        this.$el.find(".document").each(function () {
          var header = $.trim(
            $(this).find(".document-header").html()
          );
          var contents = $.trim(
            $(this).find(".document-content").html()
          );

          if (header != "") {
            header = stripHtml(
              replaceAll(
                $.trim($(this).find(".document-header").html()),
                "<br>",
                "\r\n"
              )
            );
          }

          if (contents != "") {
            contents = stripHtml(
              replaceAll(
                $.trim($(this).find(".document-content").html()),
                "<br>",
                "\r\n"
              )
            );
          }

          obj.json.push({
            Header: header,
            Contents: contents,
          });

          obj.text += header + "\n" + contents + "\n";
        });

        this.options.introduce = obj;
      },

      buttenCheckEndClick: function () {
        this.wordEditLayerView.hide();
        this.setIntroduceData();
        if (this.options.parent) {
          if (this.options.introduce.json.length) {
            this.options.parent.initialize({
              introduceCollection: new IntroduceCollection(
                this.options.introduce.json
              ),
            });
            $(".formIntroduction")
              .find("textarea")
              .trigger("input");
          }
        }

        this.hide();
      },
      butttonCheckSpellingClick: function () {
        this.wordEditLayerView.hide();
        this.setIntroduceData();
        this.executeSpellCheck();
      },
      devErrorWordClick: function (e) {
        this.wordEditLayerView.show(
          parseInt($(e.currentTarget).data("index")) - 1
        );
      },
      render: function () {
        var that = this;
        that.show();
        that.executeSpellCheck();
      },
    });
    var introduceView = new IntroduceView({
      introduceCollection: introduceCollection,
    });
  });