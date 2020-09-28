# Spring form taglib
* spring project에서 사용할 수 있는 JSP확장 taglib이다.
* form taglib를 사용하면 Controller의 model과 연동하여 input관련 form을 비교적 쉽게 구현할 수 있도록 한다.

## form taglib 프로젝트 작성 순서
0. 'http://www.springframework.org/tags/form' 를 taglib로 설정
1. form에서 input box를 구현하고 : html5 tag로
2. input box의 name값과 같은 이름의 필드변수를 갖는 vo 클래스를 작성한다.
3. form의 form tag를 form:form으로, input tag를 form:input으로 변경
4. input tag의 id 속성을 모두 제거, name 속성을 path 속성으로 변경  
자동으로 name과 id 값이 path에 지정한 값으로 설정된다.
5. input tag는 반드시 self closing 하여준다. ex) <form:input path=""/>
6. form:form tag method를 제거해도 된다. 기본값은 method="POST"로 설정된다.
7. action부분을 필요에 따라 설정
8. modelAttribute에 controller에서 model에 싣어 보내는 vo이름을 작성해야한다.