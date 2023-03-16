class CustomExtensionInserter {
    constructor() {
        this.registerEventListeners();
    }

    registerEventListeners() {
        $("#insert-custom-extension").on("click", this.insertCustomExtension.bind(this));
        $(".custom-extension-input").on("input", this.filterKoreanInput.bind(this));
    }

    filterKoreanInput(event) {
        const inputValue = event.target.value;
        const filteredValue = inputValue.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, ''); // 한글 문자를 제거
        if (inputValue !== filteredValue) {
            event.target.value = filteredValue;
        }
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

$(document).ready(function () {
    $(".custom-extension-item").each(function () {
        const textWidth = $(this).children("span").width();
        const buttonWidth = $(this).children("button").outerWidth(true);
        $(this).width(textWidth + buttonWidth + 10);
    });
});
