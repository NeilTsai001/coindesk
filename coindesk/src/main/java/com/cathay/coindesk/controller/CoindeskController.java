package com.cathay.coindesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.coindesk.config.CoindeskConfig;
import com.cathay.coindesk.model.dto.CurrencyDto;
import com.cathay.coindesk.model.dto.ResponseDto;
import com.cathay.coindesk.service.CoindeskService;
import com.cathay.coindesk.service.CurrencyService;

@RestController
@RequestMapping(value = "/coindeskController")
public class CoindeskController {

    @Autowired
    private CoindeskConfig coindeskConfig;

    @Autowired
    private CoindeskService coindeskService;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping(value = "getCoindesk")
    @ResponseBody
    public ResponseDto getCoindesk() {
        try {
            return ResponseDto.success(coindeskService.getCoindesk(coindeskConfig.getUrl()));
        } catch (Exception e) {
            return ResponseDto.failed();
        }
    }

    @GetMapping(value = "getCurrencyList")
    @ResponseBody
    public ResponseDto getCurrencyList() {
        try {
            return ResponseDto.success(currencyService.getCurrencyList());
        } catch (Exception e) {
            return ResponseDto.failed();
        }
    }

    @GetMapping(value = "getCurrency/{name}")
    @ResponseBody
    public ResponseDto getCurrency(@PathVariable String name) {
        return ResponseDto.success(currencyService.getCurrency(name));
    }

    @PostMapping(value = "createCurrency")
    @ResponseBody
    public ResponseDto createCurrency(@RequestBody CurrencyDto dto) {
        try {
            currencyService.save(dto);
            return ResponseDto.success(dto);
        } catch (Exception e) {
            return ResponseDto.failed(dto);
        }
    }

    @PostMapping(value = "updateCurrency")
    @ResponseBody
    public ResponseDto updateCurrency(@RequestBody CurrencyDto dto) {
        try {
            currencyService.update(dto);
            return ResponseDto.success(dto);
        } catch (Exception e) {
            return ResponseDto.failed(dto);
        }
    }

    @PostMapping(value = "deleteCurrency")
    @ResponseBody
    public ResponseDto deleteCurrency(@RequestBody CurrencyDto dto) {
        try {
            currencyService.delete(dto.getName());
            return ResponseDto.success(dto);
        } catch (Exception e) {
            return ResponseDto.failed(dto);
        }
    }
}
