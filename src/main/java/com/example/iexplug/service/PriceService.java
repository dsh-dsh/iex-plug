package com.example.iexplug.service;

import com.example.iexplug.dto.PriceDTO;
import com.example.iexplug.exception.WrongTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PriceService {

    @Autowired
    private List<String[]> companies;

    @Value("${iex.token}")
    private String token;

    private Map<String, PriceDTO> map;
    private ThreadLocalRandom random = ThreadLocalRandom.current();

    @PostConstruct
    void init() {
        map = getMap();
    }

    public PriceDTO getBySymbol(String symbol, String token) {
        if(!this.token.equals(token)) throw new WrongTokenException();
        PriceDTO dto = map.get(symbol);
        double value = dto.getValue();
        double max = value / 10;
        int sign = random.nextBoolean() ? 1 : -1;
        dto.setValue(value + (random.nextDouble(max) * sign));
        return dto;
    }

    private Map<String, PriceDTO> getMap() {
        double min = 100.0;
        double max = 1000.0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return companies.stream()
                    .map(arr -> new PriceDTO(arr[0], random.nextDouble(min, max)))
                    .collect(Collectors.toMap(PriceDTO::getSymbol, Function.identity()));
    }
}
