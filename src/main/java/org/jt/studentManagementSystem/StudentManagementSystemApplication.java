package org.jt.studentManagementSystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.jt.studentManagementSystem.domain.ContactInformation;
import org.jt.studentManagementSystem.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ContactInformation.class)
/*@OpenAPIDefinition(
		info = @Info(
                title = "Student Management System",
                description = "Manage Student Recodrd",
                version = "v1"
        )
)*/
public class StudentManagementSystemApplication {
/*@Autowired
private ObjectMapper objectMapper;*/
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}


/*	CommandLineRunner commandLineRunner(){
		return args -> {
			Student stud=new Student();
			stud.setStudentRoll(101);
			stud.setStudentName("Ankit");
			var json= objectMapper.writeValueAsString(stud);
			System.out.println(json);
			 String obj= """
      "studentRoll"=102,
      "studentName"="Ankit"
					 """;
			 Student student1=objectMapper.readValue(obj,Student.class);
			System.out.println(student1);
		};
	}*/
}
// confuguration.properties work is to read application properties data.