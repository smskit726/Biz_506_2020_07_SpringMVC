package com.biz.data.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.data.config.DataGoConfig;
import com.biz.data.model.StationList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BisServiceImplV1 {

	public String getStation() {
	      
	      // 공공DB로부터 데이터를 수집하는 용도의 클래스
	      RestTemplate restTemp = new RestTemplate();
	      ResponseEntity<StationList> resList = null;
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	      
	      String strURI = DataGoConfig.BIS_URL + "?serviceKey=" + DataGoConfig.SERVICE_KEY;
	      log.debug("URI >> {}", strURI);
	      try {
	         URI bisURI = new URI(strURI);
//	         headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//	         HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
	         
	         resList = restTemp.exchange(bisURI, HttpMethod.GET, entity, StationList.class);
//	         log.debug(resList.getBody().toString());
	         return resList.getBody().STATION_LIST.toString();
	         
	      } catch (URISyntaxException e) {
	         log.debug("URI 정보가 잘못되었습니다");
	      }
	      return null;
	   }
}
