package ca.mikegabelmann.demo2.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "SEX_CODE")
public class SexCode {

    @Id
    @Column(name = "ID", length = 1, nullable = false, unique = true)
    private String id;

    @Column(name = "DESCRIPTION", length = 24, nullable = false)
    private String description;


    /** No args constructor. */
    public SexCode() {
        this(null, null);
    }

    /** Required args constructor. */
    public SexCode(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
