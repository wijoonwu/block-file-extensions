let update = {

    init: function () {
        let _this = this;

        $(".updateFixedExtension").on("click", () => {
            alert(event.target.getAttribute('name'));
            _this.updateFixedExtension();
        });
    },


    updateFixedExtension: function () {
        let CustomExtension = {
            id: event.target.getAttribute('id'),
            name: event.target.getAttribute('name')
        }
        $.ajax({
            type: "PUT",
            url: "/custom",
            data: JSON.stringify(CustomExtension),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
        });
    }

}

update.init();