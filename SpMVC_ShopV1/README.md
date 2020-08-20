# Spring Project 빛나리 쇼핑몰 V1
* 상품관리, 거래처관리, 회원가입, 로그인을 포함

* DB 오라클
* 반응형 메뉴를 사용, 반응형 메인화면 구현

## Project 시작
* Java Version 1.8로 변경
* Spring Framework 5.2.8
* Lombok, Logback
* views/home.jsp 삭제 후 재생성
* Run Service 수행하여 Home화면이 나타나도록

## DB 연동 설정 (pom.xml)
* spring-jdbc
* mybatis
* mybatis-spring
* commons-dbcp2
* ojdbc

* spring/appServlet/mybatis-context.xml 파일생성 및 작성

## URL(Uniform Resource Location), URI(Uniform Resource Identifier)
* URL : 파일 식별자
* URI : 통합 자원 식별자

### View 단에서 사용하는 URL
* <a href ="http://localhost:8080/shop/">서버 Home</a> : Tomcat Was에게 shop이라는 Context를 가진 project가 작동되고 있는냐? 라고 묻는 Request
* <a href ="http://localhost:8080/shop/product/list">상품리스트</a> : shop Context의 Dispatcher에게 produxt/list를 수행할 수 있는 Controller method가 있느냐? 라고 묻는 Request
* 이 HTML코드를 화면에서 만나면 Hyper Text(anchor 문자열)를 클릭했을때 서버에 Request한다. 이 때 수행하는 Request는 method=RequestMethod.GET 설정된 함수에서 처리한다.

* href : Hypertext Reference, URL 주소라고 생각하면 됨.

### HTML 코드에서 GET method로 Request를 요청하는 곳들
* anchor tag: <a href="주소">텍스트</a>

* script에서 : document.location.href="주소"
* script에서 : document.location.replace=("주소")

* css 가져오기 : <link rel="stylesheet" href="주소"/>
* script 가져오기 : <script src="주소"></script>
* image 보이기 : <img src="주소"/>
* 배경이미지 : background-image : url("주소")
