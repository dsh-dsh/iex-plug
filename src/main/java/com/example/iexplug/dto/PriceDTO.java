package com.example.iexplug.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PriceDTO {
    private String symbol;
    @JsonProperty("latestPrice")
    private double value;
}
