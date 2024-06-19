package ca.mikegabelmann.demo2.persistence.model;

import java.time.LocalDate;

/**
 * Used to construct Model/JPA objects with 'sane' defaults.
 */
public class ModelTestFactory {
    /** Do not instantiate this class. */
    private ModelTestFactory() {}

    public static SexCode getSexCode_Male() {
        return new SexCode("M", "Male");
    }

    public static SexCode getSexCode_Female() {
        return new SexCode("F", "Female");
    }

    public static Person getPerson(final SexCode sexCode) {
        assert sexCode != null;
        return new Person(null, "firstName", "lastName", LocalDate.now(), sexCode);
    }

    public static Person getPerson_Male() {
        return getPerson(getSexCode_Male());
    }

    public static Person getPerson_Female() {
        return getPerson(getSexCode_Female());
    }

    public static Address getAddress(final Person person) {
        assert person != null;
        return new Address(null, "firstName lastName", "city", "pr", "postal", "co", true, person);
    }

    public static GroupCode getGroupCode(final String groupId, final String description) {
        assert groupId != null;
        assert description != null;

        return new GroupCode(groupId, description);
    }

    public static GroupTypeCode getGroupTypeCode(
            final String typeId,
            final String description,
            final int position,
            final boolean effective,
            final GroupCode groupCode,
            final GroupTypeCode groupTypeCode) {

        assert typeId != null;
        assert description != null;
        assert position >= 0;
        assert groupCode != null;

        return new GroupTypeCode(new GroupTypeCodeId(groupCode.getGroupId(), typeId), description, position, effective, groupCode, groupTypeCode);
    }

}
