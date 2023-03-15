let obj = {

    init: function () {
        let _this = this;
        $(".deleteCustomExtension").on("click", () => {
            _this.deleteCustomExtension();
        });
    },


    deleteCustomExtension: function () {
        let CustomExtension = {
            id: event.target.parentElement.parentElement.getAttribute('id')
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

obj.init();