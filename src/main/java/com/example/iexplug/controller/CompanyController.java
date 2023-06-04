package com.example.iexplug.controller;

import com.example.iexplug.dto.CompanyDTO;
import com.example.iexplug.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/stable/ref-data")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/symbols")
    public Collection<CompanyDTO> getCompanies(@RequestParam String token) {
        return companyService.getAllCompanies(token);
    }

}
