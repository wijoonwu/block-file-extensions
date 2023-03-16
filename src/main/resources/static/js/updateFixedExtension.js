let update = {

    init: function () {
        let _this = this;

        $(".update-fixed-extension").on("click", () => {
            _this.updateFixedExtension();
        });
    },


    updateFixedExtension: function () {
        let FixedExtension = {
            id: event.target.getAttribute('id'),
            name: event.target.getAttribute('name')
        }
        $.ajax({
            type: "PUT",
            url: "/fixed",
            data: JSON.stringify(FixedExtension),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
        });
    }

}

update.init();