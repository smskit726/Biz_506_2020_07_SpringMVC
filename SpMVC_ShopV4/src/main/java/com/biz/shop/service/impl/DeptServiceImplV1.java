package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.shop.model.DeptVO;
import com.biz.shop.persistence.DeptDao;
import com.biz.shop.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value = "dServiceV1")
public class DeptServiceImplV1 implements DeptService{

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<DeptVO> selectAll() {
		return deptDao.selectAll();
	}

	@Override
	public DeptVO findById(String id) {
		
		return deptDao.findById(id);
	}

	@Override
	public int insert(DeptVO vo) {
		
		int ret = deptDao.insert(vo);
		
		if(ret>0) {
			log.debug("INSERT 성공 {}개 데이터 추가", ret);
		} else {
			log.debug("INSERT 실패 {}", ret);
		}
		return ret;
	}

	@Override
	public int update(DeptVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public String getDCode() {
		
		String retDCode = "D001";
		
		try {
			String maxCode = deptDao.maxDCode();
			String preCode = maxCode.substring(0,1);
			int dcode = Integer.valueOf(maxCode.substring(1)) + 1;
		
			retDCode = String.format("%s%03d", preCode, dcode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return retDCode;
	}

}
