package com.biz.bbs.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.bbs.model.ImageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService{

	/*
	 * BbsController의 write POST에서 파일을 수신한 후 이곳으로 전달하여 실제 서버로 파일을 복사하는코드를 생성
	 */
	public String fileUp(MultipartFile file) {
		
		// 파일 이름 추출
		String fileName = file.getOriginalFilename();
		// Tomcat 서버의 home 디렉토리
		String rootPath = System.getProperty("catalina.home");
		
		File dir = new File(rootPath, "tmpFolder");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		// 이미 있거나 생성된 tmpFolder와 업로드할 파일 이름을 연결하여
		// 파일 정보로 생성
		File serverSaveFile = new File(dir.getAbsolutePath(), fileName);
		FileOutputStream outFile;
		BufferedOutputStream outStream;
		try {
			outFile = new FileOutputStream(serverSaveFile);
			outStream = new BufferedOutputStream(outFile);
			
			// Bin파일을 OutputStream으로 저장하기
			byte[] fileData = file.getBytes(); //파일 크기와 데이터 추출
			
			outStream.write(fileData);
			outStream.close();
			
		} catch (FileNotFoundException e) {
			log.debug("파일을 찾을 수 없습니다 :(");
		} catch (IOException e) {
			log.debug("파일을 업로드 중 ERROR 발생 :(");
		}
		return null;
	}

	@Override
	public boolean fileDelete(String b_file) {
		
		return false;
	}

	@Override
	public List<ImageVO> filesUp(MultipartHttpServletRequest files) {
		// TODO Auto-generated method stub
		return null;
	}
}
