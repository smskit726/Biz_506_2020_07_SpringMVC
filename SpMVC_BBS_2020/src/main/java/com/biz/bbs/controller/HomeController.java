package com.biz.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		/*
		 * Controller의 method에서 home 문자열을 return하면
		 * 1. tiles-layout.xml에서 definition 항목에 home으로 선언된 tag가 있는지 검사
		 * 2. 만약 있으면 template으로 선언된 *.jsp(layout.jsp)파일을 찾는다.
		 * 3. layout.jsp에 tiles:insertAttribute로 설정된 항목을 찾아서
		 * 4. tiles-layout.xml의 put-attribute로 선언된 이름을 비교한다.
		 * 5. 일치하는 이름이 있으면 value로 선언된 *.jsp파일을 가져와
		 * 6. layout.jsp파일과 합성하여 rendering을 준비한다.
		 * 7. 만약 home이라고 선언된 항목이 tiles-layout.xml에 없을 경우는
		 * 8. 원래 설계된 순서대로 InternalViewResolver가 작동되어 /WEB-INF/views 폴더에서 home.jsp 파일을 찾아 rendering 한다.
		 */
		return "home";
	}

}
