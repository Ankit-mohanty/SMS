package org.jt.studentManagementSystem.service;

import org.jt.studentManagementSystem.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void addStudent() {
        Student st=new Student();
        st.setStudentRoll(1);
        st.setStudentName("Rahul");
        StudentService ss=new StudentService();
        var result=ss.addStudent(st);
        Assertions.assertEquals(result.getStudentRoll(),1);
    }
}