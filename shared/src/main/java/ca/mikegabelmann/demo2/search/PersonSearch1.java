package ca.mikegabelmann.demo2.search;

import ca.mikegabelmann.demo2.codes.Sex;

import java.time.LocalDate;

/**
 * NOTE: by creating a class to contain the search parameters, you don't have to refactor your endpoint or alter
 * any clients. Just update this class with the new property and you are done, except for your service.
 */
public class PersonSearch1 {

    private Sex sex;
    private LocalDate date;


    public PersonSearch1() {

    }

    public PersonSearch1(Sex sex, LocalDate date) {
        this.sex = sex;
        this.date = date;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonSearch1{");
        sb.append("sex=").append(sex);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }

}
