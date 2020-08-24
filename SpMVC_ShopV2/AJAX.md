# Ajax(Async JavaScript and XML)
* web client와 web server간에 request와 response를 교환하는 방식 중의 하나
* 일반적인 request, response는 client에서 request를 요청한 후 서버로부터 response(결과)과 도착할 때까지 client는 하던일을 멈추고 기다려야 한다. 이 방식은 화면전체를 새롭게 다시 rendering하거나 할때는 상관없으나 사소한 데이터 몇개만 서버로부터 요청하여 받고자 할 때는 매우 부담스럽다.
* 서버와 통신을 수행할 때 web client에 내장된 XMLHttpRequest를 프로토콜을 사용하여 request, response를 수행하면, web client가 하던일을 중단하는 일 없이 연속적인 업무를 수행할 수 있다.