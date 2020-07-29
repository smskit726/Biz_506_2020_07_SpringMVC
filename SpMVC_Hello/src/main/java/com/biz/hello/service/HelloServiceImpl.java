package com.biz.hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
	
	@Override
	public int add(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	
	@Override	
	public float add(float num1, float num2) {
		float sum = num1 + num2;
		return sum;
	}
	
	@Override
	public String add(String str1, String str2) {
		String strS = str1 + str2;
		return strS;
	}
	
	
	
	
}
