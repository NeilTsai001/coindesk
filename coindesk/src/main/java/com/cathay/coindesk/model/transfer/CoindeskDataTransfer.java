package com.cathay.coindesk.model.transfer;

import com.cathay.coindesk.model.dto.CoindeskDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoindeskDataTransfer {

	public static final ObjectMapper MAPPER = new ObjectMapper();

	public static CoindeskDto toCoindeskDto(Object object) {

		return MAPPER.convertValue(object, CoindeskDto.class);
	}

}
