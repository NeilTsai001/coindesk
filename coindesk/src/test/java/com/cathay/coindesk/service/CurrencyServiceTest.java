package com.cathay.coindesk.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cathay.coindesk.entity.CurrencyEntity;
import com.cathay.coindesk.enums.CurrencyEnum;
import com.cathay.coindesk.model.dto.CurrencyDto;
import com.cathay.coindesk.model.transfer.CurrencyDataTransfer;
import com.cathay.coindesk.repository.CurrencyRepository;

@ExtendWith(MockitoExtension.class)
public class CurrencyServiceTest {

    private static final List<CurrencyEntity> CURRENCY_ENTITIES = new ArrayList<>();
    private static final CurrencyEntity USD_CURRENCY_ENTITY = new CurrencyEntity();
    private static final CurrencyEntity GBP_CURRENCY_ENTITY = new CurrencyEntity();
    private static final CurrencyEntity EUR_CURRENCY_ENTITY = new CurrencyEntity();
    private static final CurrencyEntity SAVED_ENTITY = new CurrencyEntity();
    private static final Date NOW = new Date();

    private CurrencyService currencyService;

    @Mock(lenient = true)
    private CurrencyRepository currencyRepository;

    @BeforeEach
    void setup() throws Exception {

        currencyService = new CurrencyService();
        currencyService.setCurrencyRepository(currencyRepository);

        USD_CURRENCY_ENTITY.setId(1L);
        USD_CURRENCY_ENTITY.setName("USD");
        USD_CURRENCY_ENTITY.setChineseName("美金");
        USD_CURRENCY_ENTITY.setRate(new BigDecimal(19305.3552));

        GBP_CURRENCY_ENTITY.setId(2L);
        GBP_CURRENCY_ENTITY.setName("GBP");
        GBP_CURRENCY_ENTITY.setChineseName("英鎊");
        GBP_CURRENCY_ENTITY.setRate(new BigDecimal(16131.4003));

        EUR_CURRENCY_ENTITY.setId(3L);
        EUR_CURRENCY_ENTITY.setName("EUR");
        EUR_CURRENCY_ENTITY.setChineseName("歐元");
        EUR_CURRENCY_ENTITY.setRate(new BigDecimal(18806.2345));
        CURRENCY_ENTITIES.add(USD_CURRENCY_ENTITY);
        CURRENCY_ENTITIES.add(GBP_CURRENCY_ENTITY);
        CURRENCY_ENTITIES.add(EUR_CURRENCY_ENTITY);

        when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(SAVED_ENTITY);
        doNothing().when(currencyRepository).deleteById(Mockito.any());
        doNothing().when(currencyRepository).flush();
        when(currencyRepository.getByName(Mockito.any())).thenReturn(USD_CURRENCY_ENTITY);
        when(currencyRepository.findAll()).thenReturn(CURRENCY_ENTITIES);
    }

    @Test
    void getCurrencyList() throws Exception {
        List<CurrencyDto> currencyDtos = currencyService.getCurrencyList();
        currencyDtos.forEach(e -> assertThat(e).isInstanceOf(CurrencyDto.class));
        verify(currencyRepository, times(1)).findAll();
        System.out.println("getCurrencyList: " + currencyDtos.toString());
    }

    @Test
    void getCurrency() throws Exception {
        CurrencyDto currencyDto = currencyService.getCurrency(CurrencyEnum.USD.getName());
        assertThat(currencyDto.getName()).isEqualTo(CurrencyEnum.USD.getName());
        verify(currencyRepository, times(1)).getByName(Mockito.any());
        System.out.println("getCurrency: " + currencyDto);
    }

    @Test
    void createCurrency() throws Exception {
        SAVED_ENTITY.setId(4L);
        SAVED_ENTITY.setName(CurrencyEnum.USD.getName());
        SAVED_ENTITY.setChineseName("美金");
        SAVED_ENTITY.setRate(new BigDecimal(16666.6666));
        SAVED_ENTITY.setCreateTime(NOW);
        CurrencyDto currencyDto = CurrencyDataTransfer.toCurrencyDto(SAVED_ENTITY);
        currencyService.save(currencyDto);
        verify(currencyRepository, times(1)).getByName(Mockito.any());
        verify(currencyRepository, times(1)).saveAndFlush(Mockito.any());
    }

    @Test
    void updateCurrency() throws Exception {
        SAVED_ENTITY.setId(1L);
        SAVED_ENTITY.setName(CurrencyEnum.USD.getName());
        SAVED_ENTITY.setChineseName("美金");
        SAVED_ENTITY.setRate(new BigDecimal(11111.2222));
        SAVED_ENTITY.setUpdateTime(NOW);
        CurrencyDto currencyDto = CurrencyDataTransfer.toCurrencyDto(SAVED_ENTITY);
        currencyService.update(currencyDto);
        verify(currencyRepository, times(1)).getByName(Mockito.any());
        verify(currencyRepository, times(1)).saveAndFlush(Mockito.any());
        System.out.println("updateCurrency: " + currencyDto.toString());
    }

    @Test
    void deleteCurrency() throws Exception {
        CurrencyDto currencyDto = CurrencyDataTransfer.toCurrencyDto(SAVED_ENTITY);
        currencyService.delete(currencyDto.getName());
        verify(currencyRepository, times(1)).getByName(Mockito.any());
        verify(currencyRepository, times(1)).deleteById(Mockito.any());
        verify(currencyRepository, times(1)).flush();
    }
}
