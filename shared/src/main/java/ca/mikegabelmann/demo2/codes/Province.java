package ca.mikegabelmann.demo2.codes;

public enum Province {
    //Canada
    AB("Alberta"),
    BC("British Columbia"),
    ON("Ontario"),

    //USA
    CA("California"),
    WA("Washington"),
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
