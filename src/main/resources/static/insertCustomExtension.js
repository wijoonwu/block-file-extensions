let object = {

    init: function () {
        let _this = this;

        $("#custom-extension-name").on("click", () => {
            _this.insertCustomExtension();
        });
    },

    insertCustomExtension: function () {
        let CustomExtension = {
            name: $("#custom-extension-name").val()
        }
        $.ajax({
            type: "POST",
            url: "/custom",
            data: JSON.stringify(CustomExtension),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location.reload();
        });
    }
}

object.init();