$(document).ready(function () {
  $('body').on('click', '.delete-custom-extension', function () {
    const id = $(this).attr('id');
    const name = $(this).data('name');

    $.ajax({
      url: '/custom',
      type: 'DELETE',
      contentType: 'application/json',
      data: JSON.stringify({
        id: id,
        name: name
      })
    }).done(function (result) {
      alert(result);
      location.reload();
    });
  });
});
