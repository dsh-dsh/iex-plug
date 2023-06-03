package com.example.iexplug.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompanyDTO {
    private String symbol;
    private String name;
    @JsonProperty("isEnabled")
    private boolean isEnabled;
}
