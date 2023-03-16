class FixedExtensionUpdater {
    constructor() {
        this.registerEventListeners();
    }

    registerEventListeners() {
        $(".update-fixed-extension").on("click", this.updateFixedExtension.bind(this));
    }

    updateFixedExtension(event) {
        const fixedExtension = {
            id: event.target.getAttribute('id'),
            name: $(this).attr('name')
        };

        $.ajax({
            type: "PUT",
            url: "/fixed",
            data: JSON.stringify(fixedExtension),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
        });
    }
}

new FixedExtensionUpdater();
