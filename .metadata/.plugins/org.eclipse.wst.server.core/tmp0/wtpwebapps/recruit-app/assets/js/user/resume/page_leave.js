window.ResumeForm = {};

      //false: 페이지이탈 alert뜸, true: 안뜸
      var exitStat = false;

      (function (window, modal) {
        modal.visible = function (element) {
          element
            .fadeTo("1000", 1, function () {
              $(this).show();
            })
            .attr("aria-hidden", "false");
          element.css("overflow-y", "hidden");
        };
        modal.hidden = function (element) {
          element
            .fadeTo("1000", 0, function () {
              $(this).hide();
            })
            .attr("aria-hidden", "true");
          element.css("overflow-y", "visible");
        };
      })(window, (window.modal = window.modal || {}));

      //dropdown 선택 값 hidden 과 동기화
      $(function () {
        $(".formWrap").on(
          "click",
          ".dropdown .list button[data-value]",
          function () {
            var $this = $(this);
            var dataValue = $this.data("value");
            var $synEle = $this.closest(".dropdown").find("input:hidden");
            $synEle.val(dataValue);
          }
        );
        $(".formWrap").on("click", ".checkbox :checkbox", function () {
          var $this = $(this),
            checkedValue = $this.data("checked-value"),
            nonCheckedValue = $this.data("non-checked-value"),
            $synEle = $this.closest(".checkbox").find("input:hidden");

          if ($this.is(":checked")) {
            $synEle.val(checkedValue);
          } else {
            $synEle.val(nonCheckedValue);
          }
        });

        $(".button.is-event.is-popup-visible").on("click", function () {
          var $this = $(this);
          var $target = $this.data("target");
          var $position = $this.data("position");

          if ($position && $position == "center") {
            Resume.Utilities.popupVisibleCenter($($target), $this);
          } else {
            Resume.Utilities.popupVisible($($target), $this);
          }
        });
        $(".button.is-event.is-popup-hidden").on("click", function () {
          var $this = $(this);
          var $target = $this.data("target");
          Resume.Utilities.popupHidden($($target), $this);
        });
      });
      (function ($) {
        $(document).on("DOMNodeInserted", function (e) {
          var $target = $(e.target);
          var $dropdown = $target.find(".dropdown");
          if ($dropdown) {
            $dropdown.Dropdown();
          }
          var $input = $target.find(".textarea");
          if ($input) {
            $input.Textarea();
          }
          var $input = $target.find(".input");
          if ($input) {
            $input.Input();
          }
        });
      })(jQuery);

      function subject_check(input_str, nonchar) {
        var result = true;
        var char_cnt = 0;

        for (var i = 0; i < input_str.length; i++) {
          if (
            (input_str.charAt(i) >= "0" && input_str.charAt(i) <= "9") ||
            (input_str.charAt(i) >= "A" && input_str.charAt(i) <= "Z") ||
            (input_str.charAt(i) >= "a" && input_str.charAt(i) <= "z") ||
            (input_str.charAt(i) >= "ㄱ" && input_str.charAt(i) <= "힣") ||
            input_str.charAt(i) == "+" ||
            input_str.charAt(i) == "#"
          ) {
            char_cnt++;
          } else if (
            nonchar.indexOf(input_str.substring(i, i + 1)) >= 0 ||
            input_str.charCodeAt(i) == 32
          ) {
          } else {
            result = false;
            break;
          }
        }
        return result;
      }

      $(function () {
        /* 직무 */
        var JobTypeKeywordSearchCollection = Backbone.Collection.extend({
          url: "/User/Resume/PartKeywordSearch",
          model: KeywordModel,
        });

        var jobType = new JobType({
          onRemoveBizjobtypeCallBack: function () {
            onRefreshSkill();
          },
        });
        var jobTypeView = new JobTypeView({
          keywordSearchCollection: new JobTypeKeywordSearchCollection(),
          parent: jobType,
          onConfirmCallBack: function (item) {
            jobType.setBizJobTypeKeywords(item);
            onRefreshSkill();
          },
        });

        jobType.jobTypeView = jobTypeView;

        /* 희망근무조건 > 산업 */
        var BizTypeKeywordSearchCollection = Backbone.Collection.extend({
          url: "/User/Resume/BizTypeKeywordSearch",
          model: KeywordModel,
        });
        var wishView = new WishView({
          localCollection: new LocalCollection(),
        });

        var bizTypeView = new BizJobTypeView({
          el: "#wishBiztypeSelectPop",
          keywordSearchCollection: new BizTypeKeywordSearchCollection(),
          parent: wishView,
          onConfirmCallBack: function (item, currentbizjobtype) {
            wishView.setBizJobTypeKeywords(item, currentbizjobtype);
          },
        });

        wishView.bizTypeView = bizTypeView;

        var IsEditPage = "False" == "True";

        $(".input").Input();
        $(".textarea").Input();
        $(".dropdown").Dropdown();
        $(".textarea").Textarea();

        if ($(".modalJoinComplete").size() > 0) {
          modal.visible($(".modalJoinComplete"));
          $(".modalJoinComplete .buttonNewcomer").click(function () {
            $("#eventCareerStat").val("0");
            Resume.Utilities.setInitStarterInputStat();
            Resume.Utilities.setInputStatSync();
            modal.hidden($(".modalJoinComplete"));
          });
          $(".modalJoinComplete .buttonCareer").click(function () {
            $("#eventCareerStat").val("1");
            Resume.Utilities.setInitCareerInputStat();
            Resume.Utilities.setInputStatSync();
            modal.hidden($(".modalJoinComplete"));
          });
        } else {
          if ($("#UserResume_R_No").val() == "") {
            Resume.Utilities.setInitStarterInputStat();
          }
        }

        if ($(".modalExit").size() > 0) {
          $(".resumeHeader a").click(function () {
            var href = $(this).attr("href");
            $("#pageUnloadUrl").val(href);
            $(".modalExit").show();
            return false;
          });
          $("#btnNoSaveExit").click(function () {
            exitStat = true;
            window.location.href = $("#pageUnloadUrl").val();
          });
          $("#btnSaveExit").click(function () {
            exitStat = true;
            //저장하고
            dataFormatRemove();
            Save({
              successCallback: function () {
                location.href = $("#pageUnloadUrl").val();
              },
              alwaysCallback: function (result) {
                dataFormatAdd();
                modal.hidden($(".modalWriteNotcomplete"));
              },
            });
          });
          $("#btnPopClose, #btnModalExitClose").click(function () {
            $(".modalExit").hide();
          });

          $("#btnModalRequiredClose").click(function () {
            $(".modalRequiredField").hide();
          });
        }

        $(".resumeResolution .buttonDelete").click(function () {
          $("#UserResume_Will_Cntnt").val("");
          $(".resumeResolution").hide();
        });

        // hide dropdown menu on click outside of the element
        $(document).on("click", function (event) {
          var $trigger = $(".dropdown");
          if ($trigger !== event.target && !$trigger.has(event.target).length) {
            var $openDropdown = $(".dropdown").filter(".expanded");

            //선택 안누르고 닫으면 값 복원
            if (
              $openDropdown.size() > 0 &&
              $openDropdown.find(":radio").size() > 0
            ) {
              var $prevCheckedEle = $openDropdown
                .find(":radio, :checkbox")
                .filter(function () {
                  return $(this).data("prevchecked") == true;
                });
              $openDropdown.find(":radio:checked").prop("checked", false);
              $openDropdown.find(":checkbox:checked").prop("checked", false);
              $prevCheckedEle.prop("checked", true);
            }

            Resume.Utilities.unsetExpandedDropdown();
          }
        });

        var validation = function () {
          flag = true;
          var $titleEle = $("#UserResume_M_Resume_Title");
          var resumetitle = $.trim($titleEle.val());

          var nonchar = "-+()%,./'[]&!?\""; //허용된 특수문자( 허용되는 특수문자는 여기에 추가)
          if (!subject_check(resumetitle, nonchar)) {
            alert(
              "이력서 제목에 " +
                nonchar +
                " 이외의 특수문자는 입력하실 수 없습니다."
            );
            $titleEle.focus();
            return false;
          }
          var birthDay = $("#UserInfo_M_Born").val();
          if (birthDay && !Resume.Utilities.isValidYearMonthDay(birthDay)) {
            Resume.Utilities.validationMsgShow(
              $("#UserInfo_M_Born").closest(".input"),
              "생년월일을 확인해주세요."
            );
            return false;
          }

          $("input[name='File_Type']").each(function () {
            if ($(this).val() == "0") {
              Resume.Utilities.validationMsgShow($(this).closest(".dropdown"));
              flag = false;
              return false;
            }
          });

          var MAX_JOBTYPE_COUNT = 4;
          var jobtypeLength = $('input[name="UserWishWork.Str_JobTypeCode"]')
            .val()
            .split(",")
            .filter(function (element) {
              if (element > 0) return true;
            }).length;

          if (jobtypeLength > MAX_JOBTYPE_COUNT) {
            alert(
              "희망직무는 " +
                MAX_JOBTYPE_COUNT +
                "개까지 선택 가능합니다. 직무 수정 후 저장해 주세요."
            );
            return false;
          }

          var MAX_SKILL_COUNT = 20;
          var skillLength = $('input[name="Skill.index"]').length;
          if (skillLength > MAX_SKILL_COUNT) {
            alert("스킬은 " + MAX_SKILL_COUNT + "개까지 등록 가능합니다.");
            return false;
          }

          if (!flag) {
            return false;
          }

          return true;
        };

        //아래의 기능들은 최초 작성시에만 사용.
        if (!IsEditPage) {
          //5분마다 자동 저장
          setInterval(function () {
            // 로그인 연장 관련 팝업 표시 될 경우 자동 저장 불가 처리 2017.12.26 jroko
            if (LoginWatcher.IsShowLayer()) {
              exitStat = true;
              return;
            }

            var flag = validation();
            if (flag) {
              dataFormatRemove();
              Save({
                alwaysCallback: dataFormatAdd,
                successCallback: function () {
                  //Resume.Utilities.notifacation($('.notifacation'));
                  ui.user.resumemng.popupTemporaryStorage.once();

                  $(".save-time").html(getDateTime() + " 저장 완료");
                },
                tempStat: true,
              });
            }
          }, 1000 * 60 * 5);

          //미리 보기 버튼 클릭
          $(".buttonPreview").click(function () {
            var flag = validation();
            if (flag) {
              dataFormatRemove();
              Save({
                successCallback: function () {
                  var url =
                    "/User/Resume/PreView?rNo=" + $("#UserResume_R_No").val();
                  var win = window.open(
                    url,
                    "Resume_Preview",
                    "width=1000,height=1200,status=0,scrollbars=1"
                  );
                  if (win) {
                    win.focus();
                  } else {
                    $(".modal-spinner").hide();
                  }
                },
                alwaysCallback: dataFormatAdd,
              });
            }
          });
        }

        //임시저장 버튼 클릭
        $(".buttonSaveTemporary").click(function () {
          var flag = validation();
          if (flag) {
            dataFormatRemove();
            Save({
              alwaysCallback: dataFormatAdd,
              successCallback: function () {
                //Resume.Utilities.notifacation($('.notifacation'));
                ui.user.resumemng.popupTemporaryStorage.once();
              },
            });
          }
        });

        function watchEvent(isEditPage) {
          var options = null;

          if (!isEditPage) {
            options = {
              SaveFunction: function () {
                var flag = validation();
                if (flag) {
                  dataFormatRemove();
                  Save({
                    alwaysCallback: dataFormatAdd,
                    successCallback: function () {
                      Resume.Utilities.notifacation($(".notifacation"));
                    },
                  });
                }
              },
            };
          } else {
            options = {
              LoginDescription: "다시 한번 로그인 하신 후 이용해주세요.",
            };
          }

          LoginWatcher.Init(options);
        }

        // 로그인 유효시간 체크 이벤트 2017.12.26 jroko
        watchEvent(IsEditPage);

        var getParameterByName = function (name, url) {
          if (!url) url = window.location.href;
          name = name.replace(/[\[\]]/g, "\\$&");
          var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
          if (!results) return null;
          if (!results[2]) return "";
          return decodeURIComponent(results[2].replace(/\+/g, " "));
        };

        //작성완료 버튼 클릭
        $(".buttonComplete").click(function () {
          exitStat = true;
          var flag = validation();
          if (flag) {
            dataFormatRemove();
            Save({
              strongValidation: true,
              successCallback: function (isEventEntry) {
                var rNo = $("#UserResume_R_No").val();

                // 이력서 유도 2018-03-23 LMJ
                if (resume_target !== undefined) {
                  if (resume_target.resumeManager !== undefined) {
                    resume_target.resumeManager.complete(rNo);
                  }
                }

                setCookie(
                  "CareerHealthNewIdx",
                  null,
                  -1,
                  "/",
                  "jobkorea.co.kr"
                ); //경력 쿠키 삭제

                if (IsEditPage) {
                  //키워드 전환 스크립트
                  //NsmConversionClick('160');

                  //Google Tag Manager
                  GA_Virtual(
                    "PC_이력서수정",
                    "https://www.jobkorea.co.kr/virtual/User/Resume/Save"
                  );
                  if ($("#UserResume_R_Input_Stat").val() == "3") {
                    //완성이력서
                    if ($("#UserResume_R_Default_Stat").val() == "True") {
                      GA_Virtual(
                        "홈>개인회원>이력서>기본이력서업데이트>기본_업데이트완료",
                        "https://www.jobkorea.co.kr/virtual/User/Resume/1st_update_complete"
                      );

                      if (
                        $("#formPortfolio")
                          .find(".portfolioList")
                          .find("li")
                          .size() > 0
                      ) {
                        BrazeSetCustomUserAttribute(101, "Y");
                      } else {
                        BrazeSetCustomUserAttribute(101, "N");
                      }

                      if ($("#UserInfo_M_Gender").val() == "True") {
                        BrazeSetCustomUserAttribute(103, "F");
                      } else {
                        BrazeSetCustomUserAttribute(103, "M");
                      }
                    } else {
                      GA_Virtual(
                        "홈>개인회원>이력서>추가이력서업데이트>추가_업데이트완료",
                        "https://www.jobkorea.co.kr/virtual/User/Resume/re_update_complete"
                      );
                    }
                  }

                  if (isEventEntry)
                    location.href =
                      "/User/Resume/View?rNo=" + rNo + "&isEventEntry=true";
                  else
                    location.href =
                      "/User/Resume/View?rNo=" + rNo + "&afterEdit=1";
                } else {
                  //키워드 전환 스크립트
                  //NsmConversionClick('110');

                  //공고뷰, 기업홈 플로팅버튼 선배에게 질문하기 클릭 진입 여부 확인
                  if (getParameterByName("qstn") == null ? false : true) {
                    location.href = "/User/Qstn/" + getParameterByName("qstn");
                  } else {
                    location.href = "/User/Resume/Complete?rNo=" + rNo;
                  }
                }
              },
              alwaysCallback: function () {
                dataFormatAdd();
              },
            });
          }
        });

        $(".buttonNewResume").click(function () {
          location.href = "/User/Resume/Write?isEmptyFormOffer=True";
        });

        var partCollection = Backbone.Collection.extend({
          url: "/User/Resume/GetPartCode",
          byPartCtgr: function (ctgrCode) {
            return this.filter(function (m) {
              return m.get("Part_Ctgr_Code") == ctgrCode;
            });
          },
        });
        window.ResumeForm.PartCollection = new partCollection();
        window.ResumeForm.PartCollection.fetch();

        window.ResumeForm.FixedMenuView = new window.ResumeForm.FixedMenuView();
        window.ResumeForm.AdditionView = new window.ResumeForm.AdditionView();

        $(".modalRequiredField .buttonYes").on("click", function () {
          $(".modalRequiredField").hide();
        });
        $(".modalRequiredField .button-temp").on("click", function () {
          var flag = validation();
          if (flag) {
            dataFormatRemove();
            Save({
              alwaysCallback: dataFormatAdd,
              successCallback: function () {
                ui.user.resumemng.popupTemporaryStorage.once();
                $(".save-time").html(getDateTime() + " 저장 완료");
                $(".modalRequiredField").hide();
              },
            });
          }
        });

        //자기소개서(formIntroduction)
        $(".formIntroduction")
          .on("keyup input", "textarea", function (e) {
            var $this = $(this);
            if ($this.is(":visible")) {
              $this.outerHeight(
                this.scrollHeight + ($this.outerHeight() - $this.innerHeight())
              );
              $this.closest(".textarea-introduction").length &&
                $this
                  .closest(".textarea-introduction")
                  .outerHeight($this.outerHeight() + 2)
                  .find(".backdrop")
                  .outerHeight($this.outerHeight());
            }
          })
          .find("textarea")
          .trigger("input");

        //담당 업무 관련(formCareer)
        $(".formCareer")
          .on("keyup input", "textarea", function (e) {
            var $this = $(this);
            if ($this.is(":visible")) {
              $(this).css("height", "auto");
              $(this).height(this.scrollHeight);
            }
          })
          .find("textarea")
          .trigger("input");

        if (
          getCookie("monConvertModelClose") == null &&
          $(".modalAlbamonResume").length
        ) {
          $(".modalAlbamonResume")
            .find(".buttonNo, .buttonClose")
            .click(function () {
              $(".modalAlbamonResume").hide();
              setCookie("monConvertModelClose", "1");
            });

          $(".modalAlbamonResume")
            .find(".buttonYes")
            .click(function () {
              exitStat = true;
              location.href = "/User/Resume/ConvertMonResume";
            });

          $(".modalAlbamonResume").show();
        }
      });

      function Save(options) {
        if (!options.tempStat) {
          $(".modal-spinner").show();
        }
        if (options.strongValidation) {
          $("#hdnIsCompleteSave").val("True");
        } else {
          $("#hdnIsCompleteSave").val("False");
        }

        setResumePimAgree("save");
        var jsonData = $("#frm1").serializeArray();
        $.post(
          "/User/Resume/Save?_=" + new Date().getTime(),
          jsonData,
          function (result) {
            if (typeof options.alwaysCallback === "function") {
              options.alwaysCallback();
            }

            if (result.saveResult.IsSuccess) {
              $("#UserResume_R_No").val(result.saveResult.RNo);
              $("#LastEditDateTicks").val(result.saveResult.LastEditDateTicks);

              // ==== Braze =====
              // 기본이력서인 경우
              if (
                result.BrazeData != undefined &&
                result.BrazeData != null &&
                result.BrazeData.R_Default_Stat == 1
              ) {
                if ($("#UserResume_R_Input_Stat").val() == "3") {
                  //완성이력서
                  // 이력서업데이트 custom event
                  let brazeProps = Object.assign(
                    {},
                    {
                      career_flag: result.BrazeData.CareerFlag,
                      r_input_stat: result.BrazeData.R_Input_Stat,
                    }
                  );
                  BrazeCustomEventSetProperty(4, "", brazeProps);
                }
                //기본이력서 완성이거나, 기본이력서 수정 중 경력->신입, 신입->경력 변경될 경우
                if (
                  (window.location.href.toLowerCase().indexOf("write") &&
                    result.BrazeData.R_Input_Stat == 3) ||
                  result.isDefaultResumeChangeCareerStat
                ) {
                  BrazeSetCustomUserAttribute(5, result.BrazeData.CareerFlag);
                }

                //기업리뷰
                if (
                  result.BrazeReviewInfo != undefined &&
                  result.BrazeReviewInfo != null
                ) {
                  BrazeSetCustomUserAttribute(
                    6,
                    result.BrazeReviewInfo.CNT_END
                  );
                  BrazeSetCustomUserAttribute(
                    7,
                    result.BrazeReviewInfo.CNT_ING
                  );
                  BrazeSetCustomUserAttribute(
                    8,
                    result.BrazeReviewInfo.CNT_WAIT
                  );
                }

                // Braze
                if (result.BrazeData != undefined && result.BrazeData != null) {
                  BrazeSetCustomUserAttribute(26, result.BrazeData.R_No); // 기본이력서, 기본이력서_번호
                  BrazeSetCustomUserAttribute(
                    120,
                    result.BrazeData.M_LastSchool
                  ); // 기본이력서, 개인_최종학력
                  BrazeSetCustomUserAttribute(
                    231,
                    result.BrazeData.M_Career_Level
                  ); // 기본이력서, 개인_총경력연차
                }

                // Braze
                if (
                  result.BrazeUserInfo != undefined &&
                  result.BrazeUserInfo != null
                ) {
                  BrazeSetCustomUserAttribute(
                    11,
                    result.BrazeUserInfo.R_Edit_Dt
                  ); // 기본이력서 작성일
                  BrazeSetCustomUserAttribute(13, result.BrazeUserInfo.C_Name); // 기본이력서, 이력서_재직회사
                  BrazeSetCustomUserAttribute(
                    14,
                    result.BrazeUserInfo.RetireSt
                  ); // 기본이력서, 이력서_재직여부
                  BrazeSetCustomUserAttribute(
                    15,
                    result.BrazeUserInfo.M_MainJob
                  ); // 기본이력서, 이력서_재직회사직무
                  BrazeSetCustomUserAttribute(
                    22,
                    result.BrazeUserInfo.M_MainPay_NHIS
                  );
                  BrazeSetCustomUserAttribute(
                    23,
                    result.BrazeUserInfo.C_Name_NHIS
                  );
                  BrazeSetCustomUserAttribute(
                    24,
                    result.BrazeUserInfo.M_MainJob_NHIS
                  );
                  BrazeSetCustomUserAttribute(
                    25,
                    result.BrazeUserInfo.C_Name2_NHIS
                  );
                }
              }

              // Braze
              if (
                result.BrazeUserInfo != undefined &&
                result.BrazeUserInfo != null
              ) {
                // 신규등록
                if ($("#UserResume_R_Input_Stat").val() != "3") {
                  if (result.BrazeData.R_Default_Stat == 1) {
                    BrazeSetCustomUserAttribute(
                      9,
                      result.BrazeUserInfo.Default_Resume == 1
                    ); // 기본이력서 보유
                  } else {
                    BrazeSetCustomUserAttribute(
                      10,
                      result.BrazeUserInfo.Add_Resume_Cnt
                    ); // 이력서_추가이력서 수
                  }
                }
                BrazeSetCustomUserAttribute(
                  12,
                  result.BrazeUserInfo.Skill_Names
                ); // 이력서_보유스킬
                BrazeSetCustomUserAttribute(16, result.BrazeUserInfo.JobTypes); // 기본이력서, 이력서_직무
                BrazeSetCustomUserAttribute(
                  17,
                  result.BrazeUserInfo.JobKeywords
                ); // 기본이력서, 이력서_직무키워드
                BrazeSetCustomUserAttribute(
                  210,
                  result.BrazeUserInfo.Soft_Skill_Names
                ); // 이력서_소프트스킬
                BrazeSetCustomUserAttribute(
                  108,
                  result.BrazeUserInfo.AreaLocalNames
                ); // 기본이력서, 희망근무조건_희망근무지
                BrazeSetCustomUserAttribute(
                  109,
                  result.BrazeUserInfo.BizJobKeywordsArray
                ); // 기본이력서, 희망근무조건_산업키워드
              }

              if (result.saveResult.IsFirst) {
                alert(
                  "이력서가 완성되었습니다. 이제 이력서로 활동이 가능합니다."
                );
              }

              if (typeof options.successCallback === "function") {
                options.successCallback(result.saveResult.isEventEntry);
              }

              // 자발적 입력동인 강화
              try {
                if (
                  window.opener.location.href.indexOf("/Recruit/OnPass") > 0 ||
                  window.opener.location.href.indexOf("/User/ApplyMng") > 0
                ) {
                  window.opener.location.reload();
                }
              } catch (e) {
                console.log("부모창 없음");
              }
            } else {
              if (result.saveResult.ServerError) {
                exitStat = true;
                serverErrorHandle(result.saveResult);
              } else {
                resetInvalidFieldsView(window.ResumeForm.invalidFields);
                invalidFieldsView(result.invalidFields);

                if (options.strongValidation) {
                  $(".valid-notice").html(
                    "아래 <span>미작성된 항목</span>만 입력하시면 포지션 제안을 받거나, 입사지원을 할 수 있습니다."
                  );
                } else {
                  $(".valid-notice").html(
                    "<span>아래 항목을 입력해주셔야 임시저장 가능합니다.</span>"
                  );
                }
              }
            }
          }
        )
          .fail(function (result) {
            if (typeof options.alwaysCallback === "function") {
              options.alwaysCallback(result.saveResult.IsSuccess);
            }
            exitStat = false;
            alert(
              "알수 없는 문제가 발생했습니다.\n이력서 등록/수정이 원활치 않으면 고객센터로 연락주세요.\n고객센터 : 1588-9350 / helpdesk@jobkorea.co.kr"
            );
          })
          .always(function () {
            $(".modal-spinner").hide();
          });
      }

      function setResumePimAgree(type) {
        var essential = false;
        $("#frm1")
          .find(".dev-essential")
          .each(function () {
            if ($(this).val() != "") {
              essential = true;
            }
          });

        var optional = false;
        var msg = "";
        var cnt = 0;
        $("#frm1")
          .find(".dev-optional")
          .each(function (index) {
            var item = $(this).data("privacy");
            if ($(this).is(":hidden")) {
              if ($(this).val() == "True") {
                if (msg == "") msg = item;
                cnt += 1;
              }
            } else {
              if ($(this).val() != "") {
                if (msg == "") msg = item;
                cnt += 1;
              }
            }
          });

        if (cnt > 0) optional = true;

        if (essential) {
          $("#hidPimAgreeEssentialStat").val(1);
        }

        msg =
          cnt - 1 == 0
            ? "(" + msg + ")"
            : "(" + msg + " 외 " + (cnt - 1) + "건)";
        if (optional) {
          if (type == "saveafter") {
            $(".dev-policy-optional").text(
              "선택항목이 입력되어 있습니다. 동의 후 저장해 주세요. " + msg
            );
          } else {
            $("#hidPimAgreeOptionalStat").val(1);
          }
        } else {
          $("#hidPimAgreeOptionalStat").val(0);
        }
      }

      function serverErrorHandle(result) {
        if (result.ServerError.Message == "로그인이 만료 되었습니다.") {
          LoginWatcher.ShowLoginLayer();
          return;
        } else {
          alert(result.ServerError.Message);
        }

        if (result.ServerError.RedirectUrl) {
          location.href = result.ServerError.RedirectUrl;
        }
      }

      function checkExceptionInputHidden(errorFormKey) {
        var result = false;
        var exceptionRegexs = ["Career\[[a-zA-Z]+[0-9]+\].C_Name"];

        for (var i = 0; i < exceptionRegexs.length; i++) {
          var regex = new RegExp(exceptionRegexs[i]);

          if (regex.test(errorFormKey)) {
            result = true;
            break;
          }
        }

        return result;
      }

      function formErrorNameToID(errorFormKey) {
        var result = "";
        var cid = errorFormKey.match(/[a-zA-Z]+[0-9]+/);

        result = errorFormKey.replace(".", "_");

        if (cid) {
          result = result.replace("[" + cid + "]", "");
          result = result + "_" + cid;
        }

        return result;
      }

      function invalidFieldsView(invalidFields) {
        if (invalidFields) {
          window.ResumeForm.invalidFields = invalidFields;

          $.each(invalidFields, function (resultIndex, result) {
            try {
              if (result.FormError.Key) {
                var index = result.FormError.Index;

                if (index == -1) {
                  if (checkExceptionInputHidden(result.FormError.Key)) {
                    var id = formErrorNameToID(result.FormError.Key);

                    if (id) {
                      $ele = $("#" + id);
                    }
                  } else {
                    $ele = $("[name='" + result.FormError.Key + "']");
                  }
                } else {
                  if (result.FormError.Key == "UnivSchool_Grade") {
                    result.FormError.Key = "UnivSchool_Grade_c";
                  }

                  $ele = $("[id^='" + result.FormError.Key + "']").eq(index);
                }
                if ($ele.size() > 0) {
                  var $eleWrap = $ele.closest("div");
                  Resume.Utilities.validationMsgShow(
                    $eleWrap,
                    result.FormError.Message
                  );
                }
              }
            } catch (e) {}
          });

          var groupedFields = _.groupBy(invalidFields, "MasterName");
          var cnt = Object.values(groupedFields).length;
          var item = "";
          $(".modalRequiredField table tbody").html("");
          $.each(groupedFields, function (groupIndex, groups) {
            var masterName = groups[0].MasterName;
            var propertyDisplayNames = [];

            if (masterName == null) return;

            $.each(groups, function (propertyIndex, property) {
              if (
                propertyDisplayNames.indexOf(property.PropertyDisplayName) == -1
              ) {
                propertyDisplayNames.push(property.PropertyDisplayName);
              }
            });

            $(".modalRequiredField table tbody").append(
              "<tr><th>" +
                masterName +
                "</th> \
                        <td>" +
                propertyDisplayNames.join(", ") +
                "</td> \
                    </tr>"
            );

            if (cnt == 1) item = masterName;
          });

          if (cnt > 0) {
            $(".modalRequiredField").show();
            setResumePimAgree("saveafter");

            if (item == "개인정보 수집 및 이용동의") {
              $("html").animate(
                { scrollTop: $("#divPolicy").offset().top },
                500
              );
            }
          }
        }
      }

      function resetInvalidFieldsView(invalidFields) {
        if (invalidFields) {
          $.each(invalidFields, function (resultIndex, result) {
            try {
              if (result.FormError.Key) {
                var index = result.FormError.Index;

                if (index == -1) {
                  if (checkExceptionInputHidden(result.FormError.Key)) {
                    var id = formErrorNameToID(result.FormError.Key);

                    if (id) {
                      $ele = $("#" + id);
                    }
                  } else {
                    $ele = $("[name='" + result.FormError.Key + "']");
                  }
                } else {
                  if (result.FormError.Key == "UnivSchool_Grade") {
                    result.FormError.Key = "UnivSchool_Grade_c";
                  }

                  $ele = $("[id^='" + result.FormError.Key + "']").eq(index);
                }
                if ($ele.size() > 0) {
                  var $eleWrap = $ele.closest("div");
                  Resume.Utilities.resetValidation(
                    $eleWrap,
                    result.FormError.Message
                  );
                }
              }
            } catch (e) {}
          });
        }
      }

      function errorhandle(result) {
        var index = result.FormError.Index;
        var $ele;
        if (!result.FormError.Key) {
          alert(result.FormError.Message);
        } else {
          if (index == -1) {
            if (checkExceptionInputHidden(result.FormError.Key)) {
              var id = formErrorNameToID(result.FormError.Key);

              if (id) {
                $ele = $("#" + id);
              }
            } else {
              $ele = $("[name='" + result.FormError.Key + "']");
            }
          } else {
            if (result.FormError.Key == "UnivSchool_Grade") {
              result.FormError.Key = "UnivSchool_Grade_c";
            }

            $ele = $("[id^='" + result.FormError.Key + "']").eq(index);
          }
          if ($ele.size() > 0 && $ele.is(":visible")) {
            var $eleWrap = $ele.closest("div");
            Resume.Utilities.validationMsgShow(
              $eleWrap,
              result.FormError.Message
            );
          } else {
            if (result.FormError.Key == "PIOfferAgree.IpAgree") {
              var $eleWrap = $ele.closest("div");
              $eleWrap.find("a").focus();
              $(window).scrollTop($("#formJobPreference")[0].offsetTop);
            }
            alert(result.FormError.Message);
          }
        }
      }

      function dataFormatRemove() {
        $("[data-format-type='month']").each(function () {
          $(this).val($(this).val().replace(/\./g, ""));
        });
        $("[data-format-type='year_month_day']").each(function () {
          $(this).val($(this).val().replace(/\./g, ""));
        });
        $("[data-format-type='price']").each(function () {
          $(this).val($(this).val().replace(/\,/g, ""));
        });
      }

      function dataFormatAdd() {
        $("[data-format-type='month']").each(function () {
          $(this).trigger("input");
        });
        $("[data-format-type='year_month_day']").each(function () {
          $(this).val($(this).val().replace(/\./g, ""));
          $(this).trigger("input");
        });
        $("[data-format-type='price']").each(function () {
          $(this).val($(this).val().replace(/\,/g, ""));
          $(this).trigger("input");
        });
      }

      function replaceAll(str, searchStr, replaceStr) {
        return str.split(searchStr).join(replaceStr);
      }

      // replaceText 변수에 치환하고자 하는 태그와 검색 텍스트를 $1로 지정
      // 예) '<em>$1</em>'
      function replaceHighlight(originText, searchText, replaceText) {
        var _originText = originText;
        var variable = searchText;

        if (originText.indexOf("+") > -1) {
          //console.log(originText);
          variable = replaceAll(variable, "+", "\\+");
        }

        var regex = new RegExp("(" + variable + ")", "gi");

        return _originText.replace(regex, replaceText);
      }

      function stripHtml(str) {
        if (str === null || str === "") return false;
        else str = str.toString();
        return str.replace(/<[^>]*>/g, "");
      }

      function setExitStat(stat) {
        exitStat = stat;
      }

      function getDateTime() {
        var d = new Date();
        var s =
          leadingZeros(d.getFullYear(), 4) +
          "-" +
          leadingZeros(d.getMonth() + 1, 2) +
          "-" +
          leadingZeros(d.getDate(), 2) +
          " " +
          leadingZeros(d.getHours(), 2) +
          ":" +
          leadingZeros(d.getMinutes(), 2) +
          ":" +
          leadingZeros(d.getSeconds(), 2);

        return s;
      }

      function leadingZeros(n, digits) {
        var zero = "";
        n = n.toString();

        if (n.length < digits) {
          for (i = 0; i < digits - n.length; i++) zero += "0";
        }
        return zero + n;
      }

      //fixedMenu
      $(function () {
        var $menu = $(".fixedMenu");
        if ($menu.length < 1) {
          return false;
        }
        var $window = $(window);
        var $offsetY = $menu.offset().top;
        var $scrolled = 0;

        $window.on("scroll", function () {
          $scrolled = $(this).scrollTop();
          if ($scrolled >= $offsetY) {
            $menu.addClass("fixed");
          } else {
            $menu.removeClass("fixed");
          }
        });
      });

      (function () {
        var $careerDescription = $(".careerDescription");
        var $buttonTip = $careerDescription.find(".buttonTip");
        var $tooltip = $careerDescription.find(".tooltip");
        var $buttonCloseTooltip = $tooltip.find(".buttonClose");
        $buttonTip.on("click", function (e) {
          $tooltip.removeClass("hidden");
          e.preventDefault();
        });
        $buttonCloseTooltip.on("click", function () {
          $tooltip.addClass("hidden");
        });

        // agree tooltip
        $(".formJobPreference")
          .find(".buttonTip")
          .on("click", function (e) {
            Resume.Utilities.popupVisible($(".tooltipAgree"));
            e.preventDefault();
          });
      })();