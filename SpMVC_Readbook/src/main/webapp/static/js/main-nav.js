$(function () {
  // 화면을 세로방향으로 스크롤할때
  $(window).scroll(function () {
    let headerHeight = $("header").height(); // header tag의 높이값
    // 윈도우 화면의 최상단 좌표 가져오기
    let windowTop = $(window).scrollTop();
    if (windowTop > headerHeight) {
      $("#main-nav").css("position", "fixed");
      $("#main-nav").css("top", "0");
    } else {
      $("#main-nav").css("position", "relative");
    }
  });

  $("li#menu-home").click(function () {});
  $("li#menu-books").click(function () {});
  $("li#menu-read-book").click(function () {});
  $("li#menu-login").click(function () {});

  // nav의 li tag를 클릭했을때
  $("#main-nav li").click(function () {
    let menu_text = $(this).text(); // text 값 추출
    let menu_id = $(this).attr("id"); // id 값 추출

    if (menu_id === "menu-home") {
      document.location.href = `${rootPath}/`;
    } else if (menu_text === "도서정보") {
      document.location.href = `${rootPath}/books`;
    } else if (menu_id === "menu-read-book") {
      document.location.href = `${rootPath}/read`;
    } else if (menu_id === "menu-join") {
      document.location.href = `${rootPath}/member/join`;
    }
  });
});
