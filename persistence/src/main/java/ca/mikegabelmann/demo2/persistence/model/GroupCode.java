package ca.mikegabelmann.demo2.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "GROUP_CODE")
public class GroupCode {
    @Id
    @Column(name = "GROUP_ID", nullable = false, unique = true, length = 5)
    private String groupId;

    @Column(name = "DESCRIPTION", nullable = false, length = 255)
    private String description;


    /** No args constructor, used by JPA. */
    protected GroupCode() {
        this(null, null);
    }

    /**
     * All args constructor.
     * @param groupId group id
     * @param description description
     */
    public GroupCode(final String groupId, final String description) {
        this.groupId = groupId;
        this.description = description;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("GroupCode{groupId='%s', description='%s'}", groupId, description);
    }

}
