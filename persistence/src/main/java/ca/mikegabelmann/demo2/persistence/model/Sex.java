package ca.mikegabelmann.demo2.persistence.model;

public enum Sex {
    MALE(1),
    FEMALE(2),
    ;

    /**
     * Constructor.
     * @param sex biological sex
     */
    Sex(final int sex) {
        this.sex = sex;
    }

    private final int sex;

    @Override
    public String toString() {
        return "" + sex;
    }

}
