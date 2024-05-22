package ca.mikegabelmann.demo2.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "SEX_CODE")
public class SexCode {
    @Id
    @Column(name = "ID", length = 1, nullable = false, unique = true)
    private String id;

    @Column(name = "DESCRIPTION", length = 24, nullable = false)
    private String description;


    /** No args constructor, used by JPA. */
    protected SexCode() {
        this(null, null);
    }

    /** Required args constructor. */
    public SexCode(final String id, final String description) {
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

    @Override
    public String toString() {
        return "SexCode{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
