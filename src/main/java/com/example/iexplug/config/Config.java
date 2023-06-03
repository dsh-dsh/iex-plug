package com.example.iexplug.config;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Configuration
public class Config {

    @Bean("companies")
    public List<String[]> getCompanyList() {
        String fileName = "/cvs/company.csv";
        try (InputStream inputStream = getClass().getResourceAsStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             CSVReader reader = new CSVReader(inputStreamReader)) {
            return reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }

}
