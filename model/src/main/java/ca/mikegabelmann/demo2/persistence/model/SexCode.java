package ca.mikegabelmann.demo2.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SEX_CODE")
public class SexCode {

    @Id
    @Column(name = "SEX_CODE", length = 1, nullable = false, unique = true)
    private String id;

    @Column(name = "VALUE", length = 24, nullable = false)
    private String value;

    @OneToMany(mappedBy = "person")
    private final List<Person> person = new ArrayList<>();


    public SexCode() {

    }

    public SexCode(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
