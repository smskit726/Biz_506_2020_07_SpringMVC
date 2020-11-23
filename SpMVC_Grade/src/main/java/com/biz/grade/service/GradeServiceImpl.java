package com.biz.grade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.grade.mapper.GradeDao;
import com.biz.grade.model.GradeVO;

@Service
public class GradeServiceImpl {

	@Autowired
	private GradeDao gradeDao;
	
	public List<GradeVO> selectAll(){
		return gradeDao.selectAll();
	}
	
	public GradeVO calcScore(GradeVO gradeVO) {
		
		int total = gradeVO.getG_kor()+gradeVO.getG_eng()+gradeVO.getG_math();
		int avg = total / 3;
		gradeVO.setG_total(total);
		gradeVO.setG_avg(avg);
		return gradeVO;
	}
	
	public int insert(GradeVO gradeVO) {
		return gradeDao.insert(gradeVO);
	}

	public GradeVO findById(long id) {
		return gradeDao.findById(id);
	}

	public int delete(long id) {
		
		int ret = gradeDao.delete(id);
		return ret;
	}

	public int update(GradeVO gradeVO) {
		
		int ret = gradeDao.update(gradeVO);
		return ret;
	}
}
