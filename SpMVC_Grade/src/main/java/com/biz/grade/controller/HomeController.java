package com.biz.grade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.grade.model.GradeVO;
import com.biz.grade.service.GradeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private GradeServiceImpl gService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<GradeVO> gradeList = gService.selectAll();
		model.addAttribute("G_LIST", gradeList);
		return "home";
	}
	
	@RequestMapping(value = "/input", method=RequestMethod.GET)
	public String write(@ModelAttribute GradeVO gradeVO) {
		return "g-write";
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String write(@ModelAttribute GradeVO gradeVO, Model model) {
		
		gService.calcScore(gradeVO);
//		log.debug("전송된 데이터 {}",gradeVO.toString());
		gService.insert(gradeVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		
		long long_id = Long.valueOf(id);
		int ret = gService.delete(long_id);
		
		if(ret>0) {
			log.debug("삭제된 데이터 {}", ret);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model model) {
		long long_id = Long.valueOf(id);
		GradeVO gradeVO = gService.findById(long_id);
		model.addAttribute("GRADE", gradeVO);
		return "g-write";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(GradeVO gradeVO) {
		
		gService.calcScore(gradeVO);
		int ret = gService.update(gradeVO);
		
		if(ret>0) {
			log.debug("UPDATE 데이터 {}개", ret);
		}
		
		return "redirect:/";
	}
}
