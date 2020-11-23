package com.biz.grade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.grade.model.GradeVO;

public interface GradeDao {

	@Select("SELECT * FROM tbl_grade WHERE g_seq=#{id}")
	public GradeVO findById(long id);

	@Select("SELECT * FROM tbl_grade ORDER BY g_code")
	public List<GradeVO> selectAll();
	
	public int insert(GradeVO gradeVO);
	
	@Delete("DELETE FROM tbl_grade WHERE g_seq=#{id}")
	public int delete(long id);
	
	public int update(GradeVO gradeVO);
}
