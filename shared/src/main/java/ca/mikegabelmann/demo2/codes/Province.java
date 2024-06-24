package ca.mikegabelmann.demo2.codes;

public enum Province {
    AB("Alberta"),
    BC("British Columbia"),
    ON("Ontario"),
    ;

    private final String name;

    Province(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
