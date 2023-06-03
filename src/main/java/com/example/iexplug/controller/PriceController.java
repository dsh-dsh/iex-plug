package com.example.iexplug.controller;

import com.example.iexplug.dto.PriceDTO;
import com.example.iexplug.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stable/stock")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping("/{symbol}/quote")
    public PriceDTO getCompanies(@PathVariable String symbol, @RequestParam String token) {
        return priceService.getBySymbol(symbol, token);
    }

    // curl http://localhost:8090/stable/stock/AAME/quote?token=some_token

}