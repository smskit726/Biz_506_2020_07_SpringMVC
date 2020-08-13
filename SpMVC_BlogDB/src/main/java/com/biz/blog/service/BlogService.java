package com.biz.blog.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.blog.model.BlogVO;

@Service
public class BlogService {

	/*
	 * ServletContext
	 * Tomcat 위에서 실행되는 WA(Web App)의 모든 정보를 담고있는 객체
	 * 
	 * 이미 Spring Project에서는 ServletContext 클래스의 객체 인스턴스가 만들어져 있기 때문에
	 * 가져다 사용하기 위해서 AutoWired로 묶어주기
	 */
	
	@Autowired
	private ServletContext context;
	private String serverRootPath;
	private String blogFile;
	
	public BlogService() {
		this.blogFile = "blog.txt";
//		this.serverRootPath = context.getRealPath("/");
		
	}
	
	public List<BlogVO> selectAll() {
		this.serverRootPath = context.getRealPath("/");
		
		Path path = null;
		try {
			System.out.println("서버 rootPath : " + this.serverRootPath);
			
			// 서버의 root path와 blog파일 이름을 묶어서 파일관련 연산을 수행할때 사용할 file 객체 생성
			File file = new File(this.serverRootPath,blogFile);
			
			path = Paths.get(file.toString());
			// Java 1.8 이상에서만 정상 작동 되는 코드
			List<String> strList = Files.readAllLines(path);
			List<BlogVO> blogList = new ArrayList<BlogVO>();
			
			// title, content, user
			for(String str : strList) {
				System.out.println(str);
				String[] sSplit = str.split(":");
				BlogVO blogVO = new BlogVO();
				blogVO.setTitle(sSplit[0]);
				blogVO.setContent(sSplit[1]);
				blogVO.setUser(sSplit[2]);
				
				blogList.add(blogVO);
			}
			return blogList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	 * blog 글쓰기를 수행하고 저장을 하면
	 * server RootPath에 blog.txt라는 파일로 저장하겠다.
	 */
	public void insert(BlogVO blogVO) {
		
		// Java 1.8 이상에서만 정상 작동 되는 코드
		this.serverRootPath =  context.getRealPath("/");
		File file = new File(this.serverRootPath,blogFile);
		Path path = null;
		FileWriter fileWriter = null;
		PrintWriter print = null;

		
		try {
			System.out.println("파일저장 : " + this.serverRootPath);
			path = Paths.get(file.toString());
			fileWriter = new FileWriter(path.toString(), true);
			print = new PrintWriter(fileWriter);
			
			String strBlog = String.format("%s:%s:%s\n", blogVO.getTitle(), blogVO.getContent(), blogVO.getUser());
			
			// DB로 가기전에 file로 저장해보자!
			print.print(strBlog);
			print.flush();
			print.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
