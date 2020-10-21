package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.model.BbsVO;
import com.biz.bbs.service.BbsService;
import com.biz.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RequiredArgsConstructor
@RequestMapping(value = "/bbs")
@Controller
public class BbsController {

	@Qualifier("bbsServiceV1")
	@Autowired
	private BbsService bbsService;
	
	/*
	 * return문에 bbs/list 문자열이 있으면
	 * 1. tiles-layout.xml에서 bbs/list로 설정된 항목을 검사
	 * 2. 만약 해당하는 항목이 있으면 layout을 rendering 할것이다.
	 * 3. 작성된 tiles-layout.xml에는 bbs/*로 설정된 항목이 있으므로
	 * 4. * 대신 list문자열을 치환하여 마치 bbs/list 항목이 있는것처럼 변환이된다.
	 * 5. * 대신 치환된 list 문자열은 {1}.jsp 항목에서 {1} 대신 list 문자열로 치환된다.
	 * 6. 결국 bbs/list라고 return된 문자열은 list.jsp파일을 읽어서
	 * 7. rendering 하는 용도로 사용된다.
	 */
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<BbsVO> bbsList = bbsService.selectAll();
		model.addAttribute("BBS_LIST",bbsList);
		return "/bbs/list";
	}

	/*
	@RequestMapping(value = "/{seq}/list", method = RequestMethod.GET)
	public String list() {
		return "redirect:/bbs/list";
	}
	*/
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {		
		return "/bbs/write";
	}
	
	/*
	 * form에서 보낸 파일 받기
	 * MultipartFile 클래스를 매개변수로 설정하여 파일을 받기
	 * 이 클래스에 @RequestParam(이름) : 이름 = form에서 input type=file로 설정된
	 * tag의 name 값
	 */
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BbsVO bbsVO, @RequestParam("file") MultipartFile file) {
		
		log.debug("업로드한 파일 >> " + file.getOriginalFilename());
		bbsService.insert(bbsVO, file);
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value = "/detail/{seq}", method = RequestMethod.GET)
	public String detail(@PathVariable("seq")String seq, Model model) {
		long long_seq = Long.valueOf(seq);
		BbsVO bbsVO = bbsService.findBySeq(long_seq);
		model.addAttribute("BBSVO",bbsVO);
		return "/bbs/detail";
	}
	
	/*
	@RequestMapping(value = "/{seq}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		
		long long_seq = Long.valueOf(seq);
		bbsService.delete(long_seq);
		return "redirect:/bbs/list";
	}
	*/
	
	@RequestMapping(value = "/{seq}/{url}", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, @PathVariable("url") String url, Model model) {
		
		long long_seq = Long.valueOf(seq);
		String ret_url = "redirect:/bbs/list";
		
		if(url.equalsIgnoreCase("DELETE")) {
			bbsService.delete(long_seq);
		} else if(url.equalsIgnoreCase("UPDATE")) {
			model.addAttribute("BBSVO", bbsService.findBySeq(long_seq));
			ret_url = "/bbs/write";
		}
		return ret_url;
	}
}
