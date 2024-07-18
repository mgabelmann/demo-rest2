package ca.mikegabelmann.demo2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class GroupTypeCodeDto {
    private String group;
    private String type;
    private String description;
}
