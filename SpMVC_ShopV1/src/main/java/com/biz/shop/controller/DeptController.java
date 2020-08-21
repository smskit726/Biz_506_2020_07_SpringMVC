package com.biz.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.model.DeptVO;
import com.biz.shop.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/dept")
@Controller
public class DeptController {
	
	@Autowired
	@Qualifier("dServiceV1")
	DeptService dService;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String list(Model model) {
		
		List<DeptVO> deptList = dService.selectAll();
		
		model.addAttribute("DEPT_LIST", deptList);
		model.addAttribute("BODY","DEPT_LIST");
		
		return "home";
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		
		model.addAttribute("BODY","DEPT_WRITE");
		return "home";
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute DeptVO deptVO) {
		log.debug("거래처정보입력 : {}", deptVO.toString());
		
		int ret = dService.insert(deptVO);
		return "redirect:/";
	}

}
