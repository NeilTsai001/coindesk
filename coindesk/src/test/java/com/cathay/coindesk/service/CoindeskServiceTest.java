package com.cathay.coindesk.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cathay.coindesk.model.dto.CoindeskDto;
import com.cathay.coindesk.model.transfer.CoindeskDataTransfer;
import com.cathay.coindesk.util.RestUtil;

@ExtendWith(MockitoExtension.class)
public class CoindeskServiceTest {

    private static final String URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    @Mock
    private CoindeskService coindeskService;

    @BeforeEach
    void setup() throws Exception {
        when(coindeskService.getCoindesk(Mockito.any())).thenReturn(CoindeskDataTransfer.toCoindeskDto(RestUtil.getResponseObject(URL, new HashMap<>())));
    }

    @Test
    void getCoindesk() {
        CoindeskDto coindeskDto = coindeskService.getCoindesk(Mockito.any());
        assertThat(coindeskDto).isInstanceOf(CoindeskDto.class);
        System.out.println("getCoindesk: " + coindeskDto.toString());
    }
}
