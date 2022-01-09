package ca.mikegabelmann.demo2.persistence.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class GroupTypeCodeId implements Serializable {

    @Column(name = "GROUP_ID", nullable = false, length = 5)
    private String groupId;

    @Column(name = "TYPE_ID", nullable = false, length = 5)
    private String typeId;


    /** No args constructor. */
    protected GroupTypeCodeId() {
        this(null, null);
    }

    /**
     * All args constructor.
     * @param groupId group id
     * @param typeId type id
     */
    public GroupTypeCodeId(final String groupId, final String typeId) {
        this.groupId = groupId;
        this.typeId = typeId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return String.format("GenericTypeCodeId{groupId='%s', typeId='%s'}", groupId, typeId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupTypeCodeId that = (GroupTypeCodeId) o;

        if (!groupId.equals(that.groupId)) return false;
        return typeId.equals(that.typeId);
    }

    @Override
    public int hashCode() {
        int result = groupId.hashCode();
        result = 31 * result + typeId.hashCode();
        return result;
    }

}
