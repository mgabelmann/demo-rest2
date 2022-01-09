package ca.mikegabelmann.demo2.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "GROUP_CODE")
public class GroupCode {

    @Id
    @Column(name = "GROUP_ID", unique = true, nullable = false, length = 5)
    private String groupId;

    @Column(name = "DESCRIPTION", nullable = false, length = 64)
    private String description;


    /** No args constructor. */
    protected GroupCode() {
        this(null, null);
    }

    /**
     * All args constructor.
     * @param groupId group id
     * @param description description
     */
    public GroupCode(String groupId, String description) {
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
