package ca.mikegabelmann.demo2.codes;


public enum Sex {
    M("Male"),
    F("Female"),
    ;

    /**
     * Constructor.
     * @param sex biological sex
     */
    Sex(final String sex) {
        this.sex = sex;
    }

    private final String sex;

    @Override
    public String toString() {
        return sex;
    }

}
