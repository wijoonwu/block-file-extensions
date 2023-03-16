let del = {

    init: function () {
        let _this = this;
        $(".delete-custom-extension").on("click", () => {
            _this.deleteCustomExtension();
        });
    },


    deleteCustomExtension: function () {
        let CustomExtension = {
            id: event.target.parentElement.getAttribute('id'),
            name: event.target.parentElement.getAttribute('name')
        }
        $.ajax({
            type: "DELETE",
            url: "/custom",
            data:JSON.stringify(CustomExtension),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location.reload();
        });
    }

}

del.init();