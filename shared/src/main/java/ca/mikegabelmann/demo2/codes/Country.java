package ca.mikegabelmann.demo2.codes;

public enum Country {
    CA("Canada"),
    US("United States of America"),
    ;

    private final String name;

    Country(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
