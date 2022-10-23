package com.cathay.coindesk.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.cathay.coindesk.model.dto.CoindeskDto;
import com.cathay.coindesk.model.transfer.CoindeskDataTransfer;
import com.cathay.coindesk.util.RestUtil;

@Service
public class CoindeskService {

	public CoindeskDto getCoindesk(String url) {

		return CoindeskDataTransfer.toCoindeskDto(RestUtil.getResponseObject(url, new HashMap<>()));

	}
}
