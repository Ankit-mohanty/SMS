package org.jt.studentManagementSystem.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"studentPhone","studentFee" })
public class Student {
    @Positive//here it define onle positive number only.Even it did not get ZERO.For Zero we are using Postive or Zero.
    @Min(value = 100)//here we define thye roll should npt be less than 100.
//    @Size(min = 100,max = 500) // by using this we are specifying this annoation.
    @JsonAlias("roll")
    private int studentRoll;
    @NotNull//null is not allowed
    @NotEmpty// not empty. it can teke the space beacuse it check the length.
    @NotBlank// it check the charecter if the charecter is not is allow.
    private String studentName;
    @PositiveOrZero
    @Digits(integer = 5, fraction = 2)//we can not add more than 5 dgits
    private double studentFee;
    @Email(message = "Student email should be in proper format")//make sure elail is validated
    private String studentEmail;
    @NotNull
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile Number should be in proper format")
    private String studentPhone;//jackson,graphana,actuator
    private List<String> hobbies;
    private Address address;//we band Address class in student. It is called nested object.

}
