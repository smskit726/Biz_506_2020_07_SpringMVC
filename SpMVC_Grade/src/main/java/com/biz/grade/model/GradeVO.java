package com.biz.grade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GradeVO {

	private Long g_seq;
	private String g_code;
	private String g_name;
	private int g_kor;
	private int g_eng;
	private int g_math;
	private int g_total;
	private int g_avg;

}
