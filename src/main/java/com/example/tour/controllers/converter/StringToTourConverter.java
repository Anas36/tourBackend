package com.example.tour.controllers.converter;

import com.example.tour.models.Tour;
import com.example.tour.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToTourConverter  implements Converter<String, Tour> {

        @Autowired TourService tourService;
        @Override
        public Tour convert(String from) {
            return  tourService.getTourById(Long.parseLong(from));
        }
}
