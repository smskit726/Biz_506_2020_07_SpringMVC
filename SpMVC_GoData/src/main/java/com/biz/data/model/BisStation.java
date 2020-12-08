package com.biz.data.model;

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
public class BisStation {

	/*
	 * {
	 * 		"STATION_NUM"	:	1,
	 * 		"BUSSTOP_NAME"	:	"동원촌",
	 * 		"ARS_ID"		:	"5396",
	 * 		"NEXT_BUSSTOP"	:	"비아동주민센터(앞)",
	 * 		"BUSSTOP_ID"	:	2513,
	 * 		"LONGITUDE"		:	126.927,
	 * 		"NAME_E"		:	"Dongwonchon",
	 * 		"LATITUDE"		:	35.14214722
	 * }
	 */
	
	private String STATION_NUM;
	private String BUSSTOP_ID;
	private String BUSSTOP_NAME;
	private String NAME_E;
//	private String ARS_ID;
//	private String NEXT_BUSSTOP;
}
