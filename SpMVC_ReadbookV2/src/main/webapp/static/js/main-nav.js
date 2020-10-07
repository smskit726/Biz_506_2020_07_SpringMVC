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
    } else if (menu_id === "menu-mypage") {
      document.location.href = `${rootPath}/member/mypage`;
    } else if (menu_id === "menu-login") {
      // localhost:8080/book/login
      // spring security에서 자체 지원되는 login form을 사용하기 위해
      document.location.href = `${rootPath}/login`;
    } else if (menu_id === "menu-logout") {
      $.ajax({
        // localhost:8080/book/logout
        url: `${rootPath}/logout`,
        method: "POST",
        // spring security 에서 logout을 수행할 때 post 방식으로 요청을 해야한다.
        // post 방식으로 ajax 요청을 할 때 보안경고가 뜨고 서버가 거부하는 현상이 발생한다.
        // spring security server는 post방식으로 요청을 할 때, csrf_token 값을 건네주어야 한다.
        // spring form tag를 사용할 때는 문제가 없는데 ajax 방식으로 요청을 할 때는 수동으로 설정을 한다.
        // 그때 사용하는 속성이 berforSend이다.
        // beforeSend Call back 함수를 붙여서 setRequestHeader에 csrf 속성값들을 설정하여 전달해주어야 한다.
        beforeSend: function (ax) {
          ax.setRequestHeader(`${csrf_header}`, `${csrf_token}`);
        },
        success: function (result) {
          document.location.replace(`${rootPath}/`);
        },
        error: function () {
          alert("서버와 통신오류 발생!");
        },
      });
    }
  });
});
