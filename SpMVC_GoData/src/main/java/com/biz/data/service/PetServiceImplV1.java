package com.biz.data.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.data.config.DataGoConfig;
import com.biz.data.model.pet.GoPetVO;
import com.biz.data.model.pet.RfcOpenAPI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PetServiceImplV1 implements PetService{
	
	public List<GoPetVO> getHosp(String cat, String search) {
		
		String queryString = DataGoConfig.PET_URL;
		queryString += "/getDongMulHospital";
		queryString += "?ServiceKey=" + DataGoConfig.SERVICE_KEY;
		queryString += "&pageNo=1";
		queryString += "&numOfRows=100";
//		queryString += "dongName=";
		
		try {
			if(!search.isEmpty()) {
				queryString += "&dongName=" + URLEncoder.encode(search, "UTF-8");
			} else {
				queryString += "&address=" + URLEncoder.encode(search, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			log.debug("인코딩 에러 :(");
		}
		
//		log.debug("URI >> {}", queryString);
		
		// springframework.http 패키지의 클래스
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
//		headers.setContentType(MediaType.APPLICATION_XML);
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//		MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
//		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_XML));
//		messageConverters.add(converter);
		
		RestTemplate restTemp = new RestTemplate();
//		restTemp.setMessageConverters(messageConverters);
		
		URI restURI = null;

		ResponseEntity<RfcOpenAPI> result = null;
		
		// GoPetVO가 담긴 리스트 타입으로 RestTemplate의 데이터를 받고자 할때
		// List는 클래스가 아닌 인터페이스이기 때문에 RestTemplate에서 데이터를 생성하지 못한다.
		// 인터페이스를 RestTemplate의 데이터 타입으로 사용하기 위해서
		// ParameterizedTypeReference 클래스를 이용하여 변환을 시켜줘야 한다.
//		ParameterizedTypeReference<List<GoPetVO>> paramType = 
//				new ParameterizedTypeReference<List<GoPetVO>>() {
//				};
		
		try {
//			ResponseEntity<String> restString = null;
			
			restURI = new URI(queryString);
//			result = restTemp.exchange(restURI, HttpMethod.GET, entity, paramType);
			result = restTemp.exchange(restURI, HttpMethod.GET, entity, RfcOpenAPI.class);
//			restString = restTemp.exchange(restURI, HttpMethod.GET, entity, String.class);
//			log.debug(restString.toString());
			List<GoPetVO> petList = result.getBody().body.data.list;
//			
//			log.debug(petList.toString());
			
			return petList;
		} catch (URISyntaxException e) {
			log.debug("URI 입력 오류 :(");
		}
		
		return null;
	}

}
