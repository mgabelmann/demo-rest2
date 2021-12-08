package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.persistence.model.Sex;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class SexConverter implements Converter<String, Sex> {

    @Override
    public Sex convert(String source) {
        return Sex.valueOf(source);
    }

}
