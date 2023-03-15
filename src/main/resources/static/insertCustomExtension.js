let object = {

    init: function () {
        let _this = this;

        $("#insertCustomExtension").on("click", () => {
            _this.insertCustomExtension();
        });
    },


    insertCustomExtension: function () {
        let CustomExtension = {
            name: $("#customExtensionName").val()
        }
        $.ajax({
            type: "POST",
            url: "/add-custom",
            data: JSON.stringify(CustomExtension),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location.reload();
        });
    }

}

object.init();