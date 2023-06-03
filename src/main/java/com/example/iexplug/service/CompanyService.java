package com.example.iexplug.service;

import com.example.iexplug.dto.CompanyDTO;
import com.example.iexplug.exception.WrongTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private List<String[]> companies;

    @Value("${iex.token}")
    private String token;

    private Map<String, CompanyDTO> map;

    @PostConstruct
    void init() {
        map = companies.stream()
                .map(arr -> new CompanyDTO(arr[0], arr[1], true))
                .collect(Collectors.toMap(CompanyDTO::getSymbol, Function.identity()));
    }

    public CompanyDTO getBySymbol(String symbol) {
        return map.get(symbol);
    }

    public Collection<CompanyDTO> getAllCompanies(String token) {
        if(!this.token.equals(token)) throw new WrongTokenException();
        return map.values();
    }
}
