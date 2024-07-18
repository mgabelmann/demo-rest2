package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.controller.rest.mapper.DtoMapper;
import ca.mikegabelmann.demo2.dto.GroupTypeCodeDto;
import ca.mikegabelmann.demo2.persistence.model.GroupTypeCode;
import ca.mikegabelmann.demo2.persistence.service.GroupTypeCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class GroupTypeCodeRestController {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(GroupTypeCodeRestController.class);

    //Paths for REST endpoints
    public static final String PATH_SEARCH0 = "/groupTypeCodes/searchByGroup";
    public static final String PATH_SEARCH1 = "/groupTypeCodes/searchByParentAndGroup";
    public static final String PATH_SEARCH2 = "/groupTypeCodes/countries";
    public static final String PATH_SEARCH3 = "/groupTypeCodes/provincesByCountry";

    private final GroupTypeCodeService groupTypeCodeService;

    private final DtoMapper dtoMapper;


    @Autowired
    public GroupTypeCodeRestController(final GroupTypeCodeService groupTypeCodeService, final DtoMapper dtoMapper) {
        this.groupTypeCodeService = groupTypeCodeService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(path = GroupTypeCodeRestController.PATH_SEARCH0)
    public ResponseEntity<Map<String, String>> getGroupTypeCodes(
            @RequestParam(value = "groupId") String groupId) {

        List<GroupTypeCode> results = groupTypeCodeService.findGroupTypeCodesByGroupId(groupId);
        return ResponseEntity.ok(results.stream().collect(Collectors.toMap(x -> x.getId().getTypeId(), GroupTypeCode::getDescription)));
    }

    @GetMapping(path = GroupTypeCodeRestController.PATH_SEARCH1)
    public ResponseEntity<List<GroupTypeCodeDto>> getGroupTypeCodes(
            @RequestParam(value = "pGroupId") String pGroupId,
            @RequestParam(value = "pTypeId") String pTypeId,
            @RequestParam(value = "groupId") String groupId) {

        List<GroupTypeCode> results = groupTypeCodeService.findGroupTypeCodesByParentType(pGroupId, pTypeId, groupId);
        return ResponseEntity.ok(results.stream().map(x -> new GroupTypeCodeDto(x.getId().getGroupId(), x.getId().getTypeId(), x.getDescription())).collect(Collectors.toList()));
    }

    @GetMapping(path = GroupTypeCodeRestController.PATH_SEARCH2)
    public ResponseEntity<List<GroupTypeCodeDto>> getCountries() {
        List<GroupTypeCode> results = groupTypeCodeService.findGroupTypeCodesByGroupId("CNT");
        return ResponseEntity.ok(results.stream().map(x -> new GroupTypeCodeDto(x.getId().getGroupId(), x.getId().getTypeId(), x.getDescription())).collect(Collectors.toList()));
    }

    @GetMapping(path = GroupTypeCodeRestController.PATH_SEARCH3)
    public ResponseEntity<List<GroupTypeCodeDto>> getProvincesByCountry(
            @RequestParam(value = "country") String country) {

        List<GroupTypeCode> results = groupTypeCodeService.findGroupTypeCodesByParentType("CNT", country, "PRO");
        return ResponseEntity.ok(results.stream().map(x -> new GroupTypeCodeDto(x.getId().getGroupId(), x.getId().getTypeId(), x.getDescription())).collect(Collectors.toList()));
    }

}
