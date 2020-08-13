# WAS : Web Application Service(Server)
* Web Browser를 사용하여 Server와 통신을 하면서 어떤 일을 수행하는 어플리케이션
* 클래스에 포함된 method는 함수라고 표현하자

## Web Browser에서 Server에 보내는 Request
* a href="주소" : Hyper Text를 보여주고, Hyper Text를 클릭했을 때 Server로 Request를 보내는 가장 기본적인 형태 
이 Request를 Controller에서 받아서 처리할 때는 method=Request.GET로 지정된 함수가 연산을 수행하는 처리를한다.

* form tag의 button을 클릭했을 때 Server로 Request를 보내는 형태 
input box에 문자열을 입력한 후 button을 클릭하면 그 문자열들을 Query String이라는 형식으로 바꾸어서 Server에 한꺼번에 Request한다.

* form tag에 특별히 method라는 것을 지정하지 않으면 Controller에서 처리할 때는 method=Request.GET로 지정된 함수가 처리한다.

* form tag에 method를 지정(통상 POST)하면 Controller에서 처리할 때는 지정된 처리가 표현된 함수가 처리한다.

## Request, Response
* Request1 ( a href="input" ) == Response1 ( write.jsp )
* Request2 ( write.jsp, form, input, button click )
 ==> Controller
 ==> write ( String title, String Content )
* Response2 ( writer 함수에서 model에 TITLE, CONTENT attribute를 설정하고, view.jsp와 Rendering)
 ==> html 코드를 보내주기
 
 ### 주의사항!! WAS 만들면서 외부의 css파일을 link하여 jsp에 부착할 때
 * 외부에 css파일을 만들고 style을 저장한 다음 jsp파일에서 link를 하여 사용할 때, css 파일을 변경하고 저장하였지만 화면에 반영이 안되는 경우가 있다.
 * 서버 App을 Run as Server로 실행을 하면 Tomcat이 jsp파일을 _jsp.java파일로 변환하고, class 파일로 컴파일을 하는데 jsp파일을 변경하면, 그때마다 jsp를 _jsp.java로 변환을 하게된다. 그래야만 변경된 jsp화면이 사용자에게 보여지게 된다.
 * 그런데 css와 같은 파일은 Tomcat이 변경된 것을 인지하지 못하고 Run As Server를 수행했을 때 서버에 올려있는 css 파일을 갱신하지 않는다
 * 이러한 문제로, css파일의 내용을 변경하고 view를 새로고침하여도 변경된 css가 반영이 안된다.
 * 이런 문제를 해결하는 트릭으로 css파일에 의미없는 문자열을 부착하여 Tomcat에게 파일의 변화됨을 알려줄 수 있다.
 * <link href="파일.css?ver=00001"/> 형식으로 link 코드를 작성하자