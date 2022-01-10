package ca.mikegabelmann.demo2.persistence.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, Character> {

    @Override
    public Character convertToDatabaseColumn(Boolean aBoolean) {
        final Character c;

        if (aBoolean != null) {
            c = aBoolean ? 'Y' : 'N';

        } else {
            c = null;
        }

        return c;
    }

    @Override
    public Boolean convertToEntityAttribute(Character character) {
        final Boolean b;

        if (character != null) {
            b = character.equals('Y');

        } else {
            b = null;
        }

        return b;
    }

}
