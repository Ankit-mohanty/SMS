package org.jt.studentManagementSystem.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Address info")
public class Address {
    @Schema(example = "BBSR")
    private String city;
    @Schema(example = "Odisha")
    private String state;
    @Schema(example = "India")
    private String countary;

}
