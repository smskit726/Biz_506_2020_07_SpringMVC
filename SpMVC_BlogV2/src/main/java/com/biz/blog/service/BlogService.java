package com.biz.blog.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.biz.blog.model.BlogVO;

@Service
public class BlogService {

	private String blogFile = "blog.txt";
	
	public void selectAll() {
		ClassPathResource rs = new ClassPathResource(blogFile);
		Path path = null;
		try {
			path = Paths.get(rs.getURI());
			// Java 1.8 이상에서만 정상 작동 되는 코드
			List<String> blogList = Files.readAllLines(path);
			for(String str : blogList) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(BlogVO blogVO) {
		
		// Server의 class 들이 저장되는 폴더 가져오기
		ClassPathResource rs = new ClassPathResource(blogFile);
		
		// Java 1.8 이상에서만 정상 작동 되는 코드
		Path path = null;
		FileWriter fileWriter = null;
		PrintWriter print = null;
		
		try {
			path = Paths.get(rs.getURI());
			fileWriter = new FileWriter(path.toString(), true);
			print = new PrintWriter(fileWriter);
			
			String strBlog = String.format("%s:%s:%s\n", blogVO.getTitle(), blogVO.getContent(), blogVO.getUser());
			
			// DB로 가기전에 file로 저장해보자!
			print.println(strBlog);
			print.flush();
			print.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
