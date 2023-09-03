package ca.mikegabelmann.demo2.persistence.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


/**
 * Convenience class to convert DB String to Boolean values. We use this in place of Hibernates, so we don't have to
 * import hibernate-core in our model layer.
 */
@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, Character> {
    public static final Character BOOLEAN_Y = 'Y';
    public static final Character BOOLEAN_N = 'N';

    @Override
    public Character convertToDatabaseColumn(Boolean aBoolean) {
        final Character c;

        if (aBoolean != null) {
            c = aBoolean ? BOOLEAN_Y : BOOLEAN_N;

        } else {
            c = null;
        }

        return c;
    }

    @Override
    public Boolean convertToEntityAttribute(Character character) {
        return character == null ? null : character.equals(BOOLEAN_Y);
    }

}
