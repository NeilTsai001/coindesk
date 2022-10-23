package com.cathay.coindesk.model.dto;

import java.util.Arrays;
import java.util.List;

import com.cathay.coindesk.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseDto {

	private static final String SUCCESS = StatusEnum.SUCCESS.getName();

	private static final String FAILED = StatusEnum.FAILED.getName();

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<CurrencyDto> currencyDto;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private CoindeskDto coindeskDto;

	private String status;

	public ResponseDto() {

	}

	public ResponseDto(CurrencyDto dto) {
		this.currencyDto = Arrays.asList(dto);
	}
	
	public ResponseDto(List<CurrencyDto> dtos) {
		this.currencyDto = dtos;
	}
	
	public ResponseDto(CoindeskDto dto) {
		this.coindeskDto = dto;
	}

	public List<CurrencyDto> getCurrencyDto() {
		return currencyDto;
	}

	public void setCurrencyDto(List<CurrencyDto> currencyDto) {
		this.currencyDto = currencyDto;
	}

	public CoindeskDto getCoindeskDto() {
		return coindeskDto;
	}

	public void setCoindeskDto(CoindeskDto coindeskDto) {
		this.coindeskDto = coindeskDto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static ResponseDto success(CurrencyDto dto) {
		ResponseDto responseDto = new ResponseDto(dto);
		responseDto.setStatus(SUCCESS);
		return responseDto;
	}
	
	public static ResponseDto success(List<CurrencyDto> dtos) {
		ResponseDto responseDto = new ResponseDto(dtos);
		responseDto.setStatus(SUCCESS);
		return responseDto;
	}
	
	public static ResponseDto success(CoindeskDto dto) {
		ResponseDto responseDto = new ResponseDto(dto);
		responseDto.setStatus(SUCCESS);
		return responseDto;
	}

	public static ResponseDto failed(CurrencyDto dto) {
		ResponseDto responseDto = new ResponseDto(dto);
		responseDto.setStatus(FAILED);
		return responseDto;
	}
	
	public static ResponseDto failed() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(FAILED);
		return responseDto;
	}
}
