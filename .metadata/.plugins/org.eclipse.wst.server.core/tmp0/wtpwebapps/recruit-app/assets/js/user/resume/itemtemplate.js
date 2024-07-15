$(function () {
    window.ResumeForm.BaseView = Backbone.View.extend({
        initialize: function (options) {
            _.extend(this, options);
            this.render();
            this.collection.on("add", this.addItem, this);
            this.collection.on("remove", this.removeItem, this);
            if (this.collection.size() == 0) {
                this.collection.add(new this.model());
            }

            Resume.Utilities.setValueDropdown(this.$el.find(".dropdown"));
            var that = this;
            this.$el.closest(".form").find(".buttonAddField").click(function (e) {
                that.addItemClick(e);
            });
        },
        addItem: function (item) {
            var templateData = _.extend(item.toJSON(), { cid: item.cid });
            this.$el.append(this.template(templateData));
        },
        events: {
            "click .buttonAddField": "addItemClick",
            "click .buttonDeleteField": "removeItemclick"
        },
        addItemClick: function (e) {
            this.collection.add(new this.model({
                OrdNo: this.collection.size() + 1,
                idx: new Date().getTime()
            }));
        },
        removeItemclick: function (e) {
            var $btn = $(e.currentTarget);
            var $container = $btn.closest(".container");
            var cid = $container.data("cid");
            this.collection.remove(this.collection.get(cid));
            $container.remove();
        },
        render: function () {
            this.collection.each(function (item) {
                var templateData = _.extend(item.toJSON(), { cid: item.cid });
                this.$el.append(this.template(templateData));
            }, this);
        }
    });
});