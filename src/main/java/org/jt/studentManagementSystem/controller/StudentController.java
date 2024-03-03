package org.jt.studentManagementSystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.jt.studentManagementSystem.domain.ContactInformation;
import org.jt.studentManagementSystem.domain.Student;
import org.jt.studentManagementSystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Student Related API", description = "The Student Controller, adhering to MVC naming conventions, orchestrates student-related operations, encompassing tasks like adding new students, updating information, retrieving details, ensuring" +
        " an integral role in enhancing codebase organization and maintainability.")
// This annotaion change the name student controller in swager web
public class StudentController {
    private final StudentService studentService;
    private final ContactInformation contactInformation;

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "This APi use to insert the data")
    public Student saveStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{roll}")
    @Operation(summary = "This ia use to update the data")
    public String updateStudent(@Min(value = 100) @PathVariable int roll, @Valid @RequestBody Student student) {
        String mesg = "Updated___Sucessfully";
        studentService.updateStudent(roll, student);
        return "{\"message\": " + mesg + "}";
    }

    @DeleteMapping("/delete/{roll}")
    @Operation(summary = "This API use to delete the data")
    @ApiResponse(description = "Student Roll not found", content = @Content
            (schema = @Schema(implementation = ProblemDetail.class)))
    public String deleteByid(@Min(value = 100) @PathVariable int roll) {
        String mesg = "Deleted___Sucessfully";
        studentService.deleteStudent(roll);
        return "{\"message\": " + mesg + "}";
    }

    @GetMapping("/retriveAll")
    @Operation(summary = "This is API is use tp getAll data")
    public List<Student> students() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{roll}")
//    @Operation(description = "This ia use to get a single data by roll")
    @Operation(summary = "This ia use to get a single data by roll")
    public Student getStudent(@PathVariable int roll) {
        return studentService.getStudent(roll);
    }

    @GetMapping("/contactInfo")
    public ContactInformation contactInformation() {
        System.out.println("Contact controller");
        return contactInformation;
    }
}
