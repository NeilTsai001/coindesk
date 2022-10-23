package com.cathay.coindesk.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


public class RestUtil {

	@Bean("restTemplate")
	public static RestTemplate getInstance(MappingJackson2HttpMessageConverter converter) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}

	public static Object getResponseObject(String url, Map<String, String> uriVariables) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(new MediaType("application", "javascript", Charset.forName("UTF-8")));
		converter.setSupportedMediaTypes(mediaTypes);
		RestTemplate restTemplate = getInstance(converter);
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity(url, Object.class, uriVariables);
		return responseEntity.getBody();

	}
}
