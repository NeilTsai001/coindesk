package com.cathay.coindesk.model.transfer;

import org.springframework.beans.BeanUtils;

import com.cathay.coindesk.entity.CurrencyEntity;
import com.cathay.coindesk.model.dto.CurrencyDto;

public class CurrencyDataTransfer {

	public static CurrencyDto toCurrencyDto(CurrencyEntity entity) {
		CurrencyDto currencyDto = new CurrencyDto();
		if (entity != null) {
			BeanUtils.copyProperties(entity, currencyDto);
		}

		return currencyDto;
	}

	public static CurrencyEntity toCurrencyEntity(CurrencyDto dto) {
		CurrencyEntity currencyEntity = new CurrencyEntity();
		BeanUtils.copyProperties(dto, currencyEntity);

		return currencyEntity;
	}

	public static CurrencyEntity toCurrencyEntity(CurrencyDto dto, Long id) {
		CurrencyEntity currencyEntity = toCurrencyEntity(dto);
		if (id != null) {
			currencyEntity.setId(id);
		}

		return currencyEntity;
	}

}
