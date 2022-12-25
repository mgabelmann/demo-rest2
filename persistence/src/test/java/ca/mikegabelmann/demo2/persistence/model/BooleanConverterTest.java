package ca.mikegabelmann.demo2.persistence.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BooleanConverterTest {
    private BooleanConverter converter = new BooleanConverter();

    @Test
    @DisplayName("convert to database")
    void convertToDatabaseColumn() {
        Assertions.assertEquals(null, converter.convertToDatabaseColumn(null));
        Assertions.assertEquals('Y', converter.convertToDatabaseColumn(Boolean.TRUE));
        Assertions.assertEquals('N', converter.convertToDatabaseColumn(Boolean.FALSE));
    }

    @Test
    @DisplayName("convert to entity")
    void test1_convertToEntityAttribute() {
        Assertions.assertEquals(null, converter.convertToEntityAttribute(null));
        Assertions.assertEquals(Boolean.TRUE, converter.convertToEntityAttribute('Y'));
        Assertions.assertEquals(Boolean.FALSE, converter.convertToEntityAttribute('N'));
    }

    @Test
    @DisplayName("lowercase values are false")
    void test2_convertToEntityAttribute() {
        Assertions.assertEquals(Boolean.FALSE, converter.convertToEntityAttribute('y'));
        Assertions.assertEquals(Boolean.FALSE, converter.convertToEntityAttribute('n'));
    }

    @Test
    @DisplayName("alternative true/false values")
    void test3_convertToEntityAttribute() {
        Assertions.assertEquals(Boolean.FALSE, converter.convertToEntityAttribute('T'));
        Assertions.assertEquals(Boolean.FALSE, converter.convertToEntityAttribute('F'));

        Assertions.assertEquals(Boolean.FALSE, converter.convertToEntityAttribute('t'));
        Assertions.assertEquals(Boolean.FALSE, converter.convertToEntityAttribute('f'));
    }

}