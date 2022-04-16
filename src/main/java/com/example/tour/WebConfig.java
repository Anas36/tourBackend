package com.example.tour;

import com.example.tour.controllers.converter.StringToTourConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired StringToTourConverter stringToTourConverter;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToTourConverter);
    }
}