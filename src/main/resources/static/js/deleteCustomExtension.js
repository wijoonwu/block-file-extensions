let del = {

    init: function () {
        let _this = this;
        $(".delete-custom-extension").on("click", () => {
            _this.deleteCustomExtension();
        });
    },


    deleteCustomExtension: function () {
        let CustomExtension = {
            id: event.target.parentElement.getAttribute('id')
        }
        $.ajax({
            type: "DELETE",
            url: "/custom/" +CustomExtension.id,
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location.reload();
        });
    }

}

del.init();