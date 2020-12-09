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
public class BisStationData {

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
	
	public String STATION_NUM;
	public String BUSSTOP_ID;
	public String BUSSTOP_NAME;
	public String NAME_E;
	public String ARS_ID;
	public String NEXT_BUSSTOP;
	public String LONGITUDE;
	public String LATITUDE;

}
