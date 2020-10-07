$(function () {
  $("td.book-title").click(function () {
    let seq = $(this).data("seq");
    // path Variable 방식
    document.location.href = `${rootPath}/books/detail/${seq}`;

    // query String 방식
    // document.location.href = `${rootPath}/books/detail?seq=${seq}`
  });
});
