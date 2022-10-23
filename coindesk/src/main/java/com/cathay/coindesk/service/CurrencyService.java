package com.cathay.coindesk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.cathay.coindesk.entity.CurrencyEntity;
import com.cathay.coindesk.model.dto.CurrencyDto;
import com.cathay.coindesk.model.transfer.CurrencyDataTransfer;
import com.cathay.coindesk.repository.CurrencyRepository;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Transactional
    public List<CurrencyDto> getCurrencyList() {
        List<CurrencyEntity> currencyEntities = currencyRepository.findAll();
        return currencyEntities.stream().map(t -> CurrencyDataTransfer.toCurrencyDto(t)).collect(Collectors.toList());
    }

    @Transactional
    public CurrencyDto getCurrency(String name) {
        return CurrencyDataTransfer.toCurrencyDto(currencyRepository.getByName(name));
    }

    @Transactional
    public void save(CurrencyDto dto) {
        CurrencyEntity currencyEntity = currencyRepository.getByName(dto.getName());
        if (ObjectUtils.isEmpty(currencyEntity)) {
            currencyRepository.saveAndFlush(CurrencyDataTransfer.toCurrencyEntity(dto));
        } else {
            currencyRepository.saveAndFlush(CurrencyDataTransfer.toCurrencyEntity(dto, currencyEntity.getId()));
        }
    }

    @Transactional
    public void update(CurrencyDto dto) {
        CurrencyEntity currencyEntity = currencyRepository.getByName(dto.getName());
        currencyRepository.saveAndFlush(CurrencyDataTransfer.toCurrencyEntity(dto, currencyEntity.getId()));
    }

    @Transactional
    public void delete(String name) {
        CurrencyEntity currencyEntity = currencyRepository.getByName(name);
        currencyRepository.deleteById(currencyEntity.getId());
        currencyRepository.flush();
    }

    public void setCurrencyRepository(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

}
