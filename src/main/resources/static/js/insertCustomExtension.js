class CustomExtensionInserter {
    constructor() {
        this.registerEventListeners();
    }

    registerEventListeners() {
        $("#insert-custom-extension").on("click", this.insertCustomExtension.bind(this));
    }

    insertCustomExtension() {
        const customExtension = {
            name: $("#custom-extension-name").val()
        };

        $.ajax({
            type: "POST",
            url: "/custom",
            data: JSON.stringify(customExtension),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location.reload();
        });
    }
}

new CustomExtensionInserter();
