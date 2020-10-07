<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${rootPath}/static/css/member-write.css?ver=100701"/>
<script>

	// 함수를 변수처럼 선언하는 ES6코드
	// 함수를 변수처럼 선언하면 = JS 객체화된다.
	// 함수 = 객체 = 변수
	// 1급 함수 : 함수자체를 다른함수의 매개변수로 전달할 수 있다.
	const id_check = function(username){
		
		if(username ===""){
			$("div#msg_username").css("display","block")
			$("div#msg_username span").css("color","red")
			$("div#msg_username span").text("USER ID를 입력해주세요")
			$("#username").focus()
			return false;
		}
		
		$.ajax({
            url : "${rootPath}/member/id_check",
            method : "POST",
            data : {"username" : username },
            beforeSend : function(ax){
               ax.setRequestHeader ("${_csrf.headerName}", "${_csrf.token}")
            }, 
            success : function(result){
               
               $("div#msg_username").css("display","block")
               if(result === "OK"){
                  //alert("사용가능한 username입니다")
                  $("div#msg_username span").text("사용가능한 ID입니다")
                  $("div#msg_username span").css("color","blue")
                  $("#password").focus() // 사용가능하면 비밀번호 누르는 데로 포커스 이동해라 커서가 거기로 바뀜
               } else {
                  //alert("이미 등록된 username입니다")
                  $("div#msg_username span").text("이미 등록된 ID입니다")
                  $("div#msg_username span").css("color","red")
                  $("#username").focus() //다시입력해
               }
               
            },
            error : function(){
               alert("서버 통신오류 입니다!")
            } 
         })
	}


   $(function(){
      
      $("#btn_save").click(function(){
         let username = $("#username").val()
         let password= $("#password").val()
         let re_password = $("#re_password").val()
         
         if(username === ""){
            alert("ID 중복검사를 수행하세요")
            $("#username").focus()
            return false
         }
         if(password === ""){
            alert("비밀번호를 입력해 주세요")
            $("#password").focus()
            return false
         }
         if(re_password===""){
            alert("비밀번호 확인을 입력해 주세요")
            $("#re_password").focus()
            return false
         }
         
         if(password !== re_password){
            alert("비밀번호와 비밀번호 확인란이 같지 않습니다")
            $("password").val("") //값을 0으로 만들고 비번 다시 입력해
            $("#re_password").val("")
            $("#password").focus()
            return false
         }
         $("form").submit()
      })
      
      /*
      input box에 focus()있다가 다른 곳으로 focus()가 이동할때 발생되는 event
      ID 중복 버튼을 클릭하지 않아도 ID 중복검사를 할 수 있도록 username input box에 blur event를 설정
      */
      $("#username").blur(function(){
    	  let username = $("#username").val()
    	  id_check(username)
      })
      
      $("#m_username").click(function(){
         
         let username = $("#username").val()
         id_check(username)
      })
   })
</script>
<style>
div#msg_username {
	display: none;
}
</style>

<%/*
Controller에서 @SessionAttributes()와 @ModelAttribute() 설정이 있고 jsp에서 Spring 래그 taglib를 사용하면서
form:form에 modelAttribute를 설정해 두면 현재 이 JSP에는 username, password, re_password만 있지만
memberVO 만들어진 UserDetailsVO에 설정된 모든 변수가 마치 input hidden으로 설정된것과 같이 포함되어 있다.
*/%>

<form:form id="member-write" modelAttribute="memberVO">
	<fieldset>
		<legend>회원가입</legend>
		<div>
			<label>회원ID</label><form:input path="username" class="username"/>
			<button type="button" id="m_username" class="m_username">ID 중복검사</button>
		</div>
		<div id="msg_username">
			<label></label>
			<span></span>
		</div>
		<div>
			<label>비밀번호</label><form:input path="password" type="password"/>
		</div>

		<div>
			<label>비밀번호확인</label><input id="re_password" name="re_password" type="password"/>
		</div>

		
		<div id="btn_box">
			<button type="button" id="btn_home">홈으로</button>
			<button type="button" id="btn_save">다음으로</button>
		</div>
	</fieldset>
</form:form>