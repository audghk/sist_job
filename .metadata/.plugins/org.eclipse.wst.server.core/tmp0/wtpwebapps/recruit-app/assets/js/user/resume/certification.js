$(function () {
  var tempLicense = null;
  var tempLicenseCollection = null;

  var LicenseSearchCollection = Backbone.Collection.extend({
    //url: "/User/Resume/LicenseSearch",
    url: "/User/Resume/LicenseSearch_02",
    titleColumn: "Lc_Name",
    subColumn: "Lc_Pub",
  });

  var LicenseModel = Backbone.Model.extend({});
  var LicenseCollection = Backbone.Collection.extend({
    model: LicenseModel,
  });

  var licenseCollection = new LicenseCollection(JSON.parse("[]"));

  var LicenseView = Backbone.View.extend({
    el: "#license_containers",
    initialize: function (options) {
      var that = this;
      _.extend(this, options);
      this.template = _.template($("#tplLicenseItem").html());
      this.searchTemplate = _.template($("#tplCommonSearch").html());
      this.searchFailTemplate = _.template($("#tplCommonNotFound").html());
      this.searchDirectTemplate = _.template($("#tplCommonDirectInput").html());
      this.searchcollection.on("sync", this.searchCollectionRefresh, this);
      this.render();
      if (this.collection.size() == 0) {
        that.addItemClick();
      }
      this.$el
        .closest(".form")
        .find(".buttonAddField")
        .click(function (e) {
          that.addItemClick(e);
        });
      this.$el
        .closest(".form")
        .find(".certificateDescription .buttonDeleteField")
        .click(function (e) {
          that.etcTextDeleteClick(e);
        });
    },
    events: {
      "click .buttonDeleteField": "removeItemclick",
    },
    searchCollectionRefresh: function (collection) {
      var that = this,
        $curInputEle = this.$("[data-comp_type='jkAcInput']:focus"),
        $curResultWrapEle = $curInputEle
          .closest("[data-comp_type='jkAc']")
          .find("[data-comp_type='jkAcResultWrap']");

      var titleColumn = collection.titleColumn;
      var subColumn = collection.subColumn;

      $curResultWrapEle.html("<div class='list'><ul></ul><div>");
      $curResultWrapEle.addClass("hidden");

      if (collection.length > 0) {
        collection.each(function (item) {
          var sub =
            item.get(subColumn) === null ||
            item.get(subColumn) === undefined ||
            item.get(subColumn) === ""
              ? ""
              : " | " + item.get(subColumn);

          var templateData = _.extend(
            item.toJSON(),
            {
              Highlight_Name:
                item
                  .get(titleColumn)
                  .replace(
                    $curInputEle.val(),
                    "<em>" + $curInputEle.val() + "</em>"
                  ) + sub,
            },
            { itemJson: JSON.stringify(item.toJSON()) }
          );
          $curResultWrapEle
            .find(".list ul")
            .append(that.searchTemplate(templateData));
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
            JSON.parse('{ "' + titleColumn + '":"' + $curInputEle.val() + '" }')
          ),
        })
      );
      $curResultWrapEle.removeClass("hidden");
    },
    render: function () {
      var that = this;
      this.collection.each(function (item) {
        that.addCollectionItem(item);
      }, this);
    },
    getRowNo: function () {
      return this.$(".container").size() + 1;
    },
    addItemClick: function () {
      this.addCollectionItem(new this.collection.model());
    },

    addCollectionItem: function (item, check) {
      var that = this;
      var templateData = {
        data: item.toJSON(),
        cid: item.cid,
        no: this.getRowNo(),
      };
      //if (check == 1) {
      //    this.$el.append(this.template(templateData).replaceAll("disabled", ""));
      //} else {
      //    this.$el.append(this.template(templateData));
      //}
      this.$el.append(this.template(templateData));

      this.$("[data-comp_type='jkAc']:last").jkAc2({
        collection: this.searchcollection,
        containerQuery: ".row",
      });
    },
    removeItemclick: function (e) {
      var $btn = $(e.currentTarget),
        $container = $btn.closest(".container"),
        $form = $container.closest(".form"),
        cid = $container.data("cid");

      this.collection.remove(this.collection.get(cid));

      $container.remove();
      $form
        .find(".container:first")
        .removeClass()
        .addClass("container container1");

      if ($form.find(".container").length == 0)
        $("#InputStat_LicenseInputStat").val("False");
    },
    etcTextDeleteClick: function (e) {
      var $btn = $(e.currentTarget),
        $container = $btn.closest(".certificateDescription");

      $container.remove();
    },
  });

  var licenseView = new LicenseView({
    collection: licenseCollection,
    searchcollection: new LicenseSearchCollection(),
  });

  NaverLicense = licenseView;
  NaverLicenseCollection = LicenseCollection;
});

$(document).ready(function () {
  $("#devNaverDescript, #devNaverClose").on("click", function () {
    setNaverDescript();
  });
  var setNaverDescript = function () {
    var $ele = $(".devNaverElement");
    $ele.find("#tooltip-career-delete-duplicate-period").toggle("attached");
    /*
                if ($ele.find("#tooltip-career-delete-duplicate-period").hasClass("attached")) {
                    alert("test310")
                    $ele.find("#tooltip-career-delete-duplicate-period").removeClass("attached");
                } else {
                    alert("test313")
                    $ele.find("#tooltip-career-delete-duplicate-period").addClass("attached");
                }
                */
  };

  $(".tooltip-popup .button-close").click(function () {
    if ($(this).parents(".tooltip-popup").hasClass("attached")) {
      $(this).parents(".tooltip-popup").removeClass("attached");
    } else {
      $(this).parents(".tooltip-popup").addClass("attached");
    }
  });

  $(".buttonIsOExperience").click(function () {
    if ($(this).siblings(".tooltip-popup").hasClass("attached")) {
      $(this).siblings(".tooltip-popup").removeClass("attached");
    } else {
      $(this).siblings(".tooltip-popup").addClass("attached");
    }
  });

  $(".dev-naver-license").click(function () {
    GA_Event("이력서작성_PC", "네이버 자격증", "자격증 불러오기");
    jk.user.resume.write.naverlicense.events().onClickNaverLicense();
  });
});

function GetNaverLicenseResult() {
  $.ajax({
    type: "GET",
    async: false,
    url: "/User/Resume/NaverLicenseResult",
    success: function (result) {
      if (result.length > 0) {
        var naverLicenseCollection = new NaverLicenseCollection(result);
        for (i = 0; i < result.length; i++) {
          NaverLicense.addCollectionItem(naverLicenseCollection.models[i]);
        }
      } else {
        alert("네이버 자격증이 없습니다.");
      }
    },
  });
}
