package com.example.iexplug.dto;

import lombok.Data;

@Data
public class ErrorResponseDTO {
    private String error;

    public ErrorResponseDTO(String error) {
        this.error = error;
    }
}
