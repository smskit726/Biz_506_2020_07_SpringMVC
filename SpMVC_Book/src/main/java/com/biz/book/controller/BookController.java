package com.biz.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bService;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(int size, int page) {
		
		Pageable pageable = PageRequest.of(page, size);
		return "book/list";
	}
}
