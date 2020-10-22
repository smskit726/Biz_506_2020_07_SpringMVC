package com.biz.bbs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.model.BbsVO;
import com.biz.bbs.service.BbsService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@CrossOrigin({"http://127.0.0.1:5500", "https://naver.com", "*"})
@RestController
@RequestMapping(value = "/api")
public class BbsAPIController {

	@Autowired
	@Qualifier("bbsServiceV1")
	private BbsService bbsService;
	
	// localhost:8080/bbs/api/bbs 요청을 하면 게시판 list를 보내달라(getter 하겠다)
	// http://127.0.0.1:5500 에서 api요청이 오면, CORS Policy를 무시하고 응답하라
//	@CrossOrigin("http://127.0.0.1:5500")
	@RequestMapping(value = "/bbs", method = RequestMethod.GET)
	public List<BbsVO> bbs_list() {
		
		List<BbsVO> bbsList = bbsService.selectAll();
		return bbsList;
	}
	
	// localhost:8080/bbs/api/bbs/3 게시판 데이터중에서 3번 data를 1개를 보내달라
	@RequestMapping(value = "/bbs/{seq}", method = RequestMethod.GET)
	public BbsVO bbs_item(@PathVariable("seq")String seq) {
		
		long long_seq = Long.valueOf(seq);
		BbsVO bbsVO = bbsService.findBySeq(long_seq);
		return bbsVO;
	}
	
	// form에 데이터를 입력하고 submit을 수행하면 데이터를 수신하여 insert하라
	// VO 클래스를 매개변수로 지정하고 데이터를 수신한다.
	// @ModelAttribute를 사용하여 form에서 submit한 데이터를 VO에 담기
	// 4.x 이상에서는 @ModelAttribute Annotation을 생략해도
	// form의 input tag에 지정된 name값과 같은 구조를 가진 VO를 매개변수로 설정하면
	// 자동으로 @ModelAttribute를 지정한 것과 똑같은 효과를 낸다.
	@RequestMapping(value = "/bbs", method = RequestMethod.POST)
	public String bbs_insert(@ModelAttribute BbsVO bbsVO) {
		log.debug("POST RequestMethod Type으로 요청된 method");
		log.debug("수신한 데이터 {}", bbsVO.toString());
		return "bbs_insert";
	}
	
	// form에 데이터를 입력하고 submit을 수행하면 데이터를 update하라
	@RequestMapping(value = "/bbs", method = RequestMethod.PUT)
	public String bbs_update(@ModelAttribute BbsVO bbsVO) {
		log.debug("PUT RequestMethod Type으로 요청된 method");
		log.debug("수신한 데이터 {}", bbsVO.toString());
		return "bbs_update";
	}
	
	/*	
	 특정한 게시판데이터를 delete 하라
	 삭제할 게시판의 id(seq)값 1개만 받으면 된다.
	 id값 1개를 받기위해서 VO를 사용하는 것은 왠지 낭비같다.
	 1개의 String형 변수만 받아도 되는데,
	 front에서 Ajax로 데이터를 보낼때 보내는 방식에 따라 문자열형 변수로 보낼수도 있고,
	 JSON형식으로 보낼수도 있다.
	 문자열형으로 보내면 String id와 같이 받으면 되는데
	 JSON형식으로 보냈을때는 약간의 문제를 일으킨다.
	 이유는 Spring 태생적으로 JSON을 지원하지 않기 때문이다.
	 그래서 사용하는 방법이 Map<String, String> 형식의 매개변수를 만들어주고
	 @RequestBody 붙여주는 방식을 사용한다.
	 @RequestBody는 절대 생략할 수 없다.
	 */
	@RequestMapping(value = "/bbs", method = RequestMethod.DELETE)
	public String bbs_delete(@RequestBody Map<String, String> data) {
		log.debug("DELETE RequestMethod Type으로 요청된 method");
		log.debug("seq value {}", data.get("seq"));
		return "bbs_delete";
	}
	
}
