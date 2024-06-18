package ca.mikegabelmann.demo2.controller.rest;

import ca.mikegabelmann.demo2.controller.rest.mapper.DtoMapper;
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

    /** Path for REST endpoint. */
    public static final String PATH_SEARCH1 = "/groupTypeCodes/search1";

    private final GroupTypeCodeService groupTypeCodeService;

    private final DtoMapper dtoMapper;


    @Autowired
    public GroupTypeCodeRestController(final GroupTypeCodeService groupTypeCodeService, final DtoMapper dtoMapper) {
        this.groupTypeCodeService = groupTypeCodeService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(path = "/groupTypeCodes/countries")
    public ResponseEntity<Map<String, String>> getCountries() {
        List<GroupTypeCode> results = groupTypeCodeService.findGroupTypeCodesByGroupId("CNT");
        return ResponseEntity.ok(results.stream().collect(Collectors.toMap(x -> x.getId().getTypeId(), GroupTypeCode::getDescription)));
    }

    @GetMapping(path = "/groupTypeCodes/provincesByCountry")
    public ResponseEntity<Map<String, String>> getProvincesByCountry(@RequestParam(value="country") String country) {
        List<GroupTypeCode> results = groupTypeCodeService.findGroupTypeCodesByParentType("CNT", country, "PRO");
        return ResponseEntity.ok(results.stream().collect(Collectors.toMap(x -> x.getId().getTypeId(), GroupTypeCode::getDescription)));
    }

}
