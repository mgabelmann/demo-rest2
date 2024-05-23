package ca.mikegabelmann.demo2.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "GROUP_TYPE_CODE")
public class GroupTypeCode {
    @EmbeddedId
    private GroupTypeCodeId id;

    @Column(name = "DESCRIPTION", nullable = false, length = 255)
    private String description;

    @Column(name = "POSITION", nullable = false, length = 5)
    private int position;

    @Convert(converter = BooleanConverter.class)
    @Column(name = "EFFECTIVE", nullable = false, length = 1)
    private Boolean effective;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", nullable = false, insertable = false, updatable = false)
    private GroupCode groupCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "P_GROUP_ID", referencedColumnName = "GROUP_ID"),
        @JoinColumn(name = "P_TYPE_ID", referencedColumnName = "TYPE_ID")
    })
    private GroupTypeCode groupTypeCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupTypeCode")
    private List<GroupTypeCode> groupTypeCodes;


    /** No args constructor, used by JPA. */
    protected GroupTypeCode() {
        this(null, null, 0, null, null, null);
    }

    /**
     * All args constructor.
     * @param id identifier
     * @param description description
     * @param position custom order
     * @param effective in use or not
     * @param groupCode group
     * @param groupTypeCode group type
     */
    public GroupTypeCode(
        final GroupTypeCodeId id,
        final String description,
        final int position,
        final Boolean effective,
        final GroupCode groupCode,
        final GroupTypeCode groupTypeCode) {

        this.id = id;
        this.description = description;
        this.position = position;
        this.effective = effective;
        this.groupCode = groupCode;
        this.groupTypeCode = groupTypeCode;

        this.groupTypeCodes = new ArrayList<>();
    }

    public GroupTypeCodeId getId() {
        return id;
    }

    public void setId(GroupTypeCodeId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Boolean getEffective() {
        return effective;
    }

    public void setEffective(Boolean effective) {
        this.effective = effective;
    }

    public GroupCode getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
    }

    public GroupTypeCode getGroupTypeCode() {
        return groupTypeCode;
    }

    public void setGroupTypeCode(GroupTypeCode groupTypeCode) {
        this.groupTypeCode = groupTypeCode;
    }

    public List<GroupTypeCode> getGroupTypeCodes() {
        return groupTypeCodes;
    }

    public void setGroupTypeCodes(List<GroupTypeCode> groupTypeCodes) {
        this.groupTypeCodes = groupTypeCodes;
    }

    @Override
    public String toString() {
        return "GroupTypeCode{" + "id=" + id +
                ", description='" + description + '\'' +
                ", position=" + position +
                ", effective=" + effective +
                ", groupCode=" + groupCode +
                ", groupTypeCode=" + groupTypeCode +
                //", groupTypeCodes=" + groupTypeCodes +
                '}';
    }

}
