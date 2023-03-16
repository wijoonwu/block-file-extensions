class CustomExtensionDeleter {
    constructor() {
        this.registerEventListeners();
    }

    registerEventListeners() {
        $(".custom-extension-items").on("click", ".delete-custom-extension", (event) => {
            event.preventDefault();
            event.stopPropagation();
            this.deleteCustomExtension(event);
        });
    }

    deleteCustomExtension(event) {
        const customExtension = {
            id: event.target.parentElement.getAttribute('id'),
            name: event.target.parentElement.getAttribute('name')
        };

        $.ajax({
            type: "DELETE",
            url: "/custom",
            data: JSON.stringify(customExtension),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location.reload();
        });
    }
}

new CustomExtensionDeleter();
