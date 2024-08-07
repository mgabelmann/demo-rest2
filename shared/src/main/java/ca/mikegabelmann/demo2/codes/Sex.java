package ca.mikegabelmann.demo2.codes;

public enum Sex {
    M("Male"),
    F("Female"),
    ;

    private final String name;

    /**
     * Constructor.
     * @param name biological sex
     */
    Sex(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
