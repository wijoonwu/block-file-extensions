class CustomExtensionInserter {
  constructor() {
    this.registerEventListeners();
  }

  registerEventListeners() {
    $("#insert-custom-extension").on("click",
        this.insertCustomExtension.bind(this));
    $(".custom-extension-input").on("input", this.filterInput.bind(this));
  }

  filterInput(event) {
    let inputValue = event.target.value;
    inputValue = inputValue.replace(/<\/?[a-z][\s\S]*>/gi, ''); // HTML 태그 제거
    inputValue = inputValue.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣\s]/g, ''); // 한글 문자 및 공백 제거
    if (event.target.value !== inputValue) {
      event.target.value = inputValue;
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
