package com.biz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.mapper.BookDao;
import com.biz.book.model.BookVO;

@Controller
@RequestMapping(value = "/books")
public class BooksController {
	
	@Autowired
	private BookDao bookDao;
	
	// localhost:8080/book/books
	// localhost:8080/book/books/
//	@ResponseBody
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String list(Model model) {
		
		List<BookVO> bookList = bookDao.selectAll();
		
		model.addAttribute("BOOKS", bookList);
		model.addAttribute("BODY", "BOOK-LIST");
		return "home";
	}
	
	@RequestMapping(value = "/input", method=RequestMethod.GET)
	public String input(Model model) {
		
		// Controller의 Mapping method의 return type이 String 일 때, null 값을 return 하면
		// Mapping method를 호출할 때 사용했던 mapping URL.jsp 형식의 return문이 자동으로 생성된다.
		// return null;
		
		model.addAttribute("BODY", "BOOK-WRITE");
		model.addAttribute("bookVO", new BookVO());
		return "home";
	}
}
