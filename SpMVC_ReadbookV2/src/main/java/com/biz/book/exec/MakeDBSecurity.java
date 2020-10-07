package com.biz.book.exec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * jasypt 패키지의 StandardPBEStringEncryptor 클래스를 사용하여
 * DB 접속용 username password를 암호화 하여 문자열을 추출
 */
public class MakeDBSecurity {
	public static void main(String[] args) {
		String propsFile = "./src/main/webapp/WEB-INF/spring/db.connect.properties";
		StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
		Scanner scan = new Scanner(System.in);
		Map<String, String> envList = System.getenv();
		String saltPassword = envList.get("BIZ.NET");
		
		if(saltPassword == null) {
			System.out.println("BIZ.NET 환경변수 설정값이 없습니다. 확인하세요 :(");
			return;
		}
		
		System.out.printf("BIZ.NET 환경변수 : %s\n", saltPassword);
		
		System.out.print("DB UserName >> ");
		String userName = scan.nextLine();
		
		System.out.print("DB Password >> ");
		String password = scan.nextLine();
		
		pbe.setAlgorithm("PBEWithMD5AndDES");
		pbe.setPassword(saltPassword);
		
		String encUserName = pbe.encrypt(userName);
		String encPassword = pbe.encrypt(password);
		
		String saveUserName = String.format("oracle.username=ENC(%s)", encUserName);
		String savePassword = String.format("oracle.password=ENC(%s)", encPassword);
		
		try {
			PrintWriter out = new PrintWriter(propsFile);
			out.println(saveUserName);
			out.println(savePassword);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
//			e.printStackTrace();
		}
		
		scan.close();
		System.out.println("DB 연결 속성파일 생성 완료 :)");
		
		
	}
}
