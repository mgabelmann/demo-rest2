package ca.mikegabelmann.demo2.codes;

public enum Group {
    CNT("Country"),
    PRO("Province"),
    ZIP("Postal or Zip Code"),
    ;

    private final String name;

    Group(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
