package org.jt.studentManagementSystem.service;

import org.jt.studentManagementSystem.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(int roll) {
        for (Student student : students) {
            if (student.getStudentRoll() == roll)
                return student;
        }
        throw new RuntimeException("Student Not Found");
    }

    public Student deleteStudent(int roll) {
        var student = getStudent(roll);
        students.remove(student);
        return student;
    }

    public Student updateStudent(int roll, Student student) {
        var existingStudent = getStudent(roll);

        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentFee(student.getStudentFee());
        existingStudent.setStudentEmail(student.getStudentEmail());
        existingStudent.setStudentPhone(student.getStudentPhone());
        existingStudent.setHobbies(student.getHobbies());
        existingStudent.setAddress(student.getAddress());

        var index = getIndex(roll);
        students.set(index, existingStudent);
        return existingStudent;
    }

    //It is helper function gor update method.
    private int getIndex(int roll) {
        for (int i = 0; i < students.size(); i++) {
            var student = students.get(i);
            if (student.getStudentRoll() == roll)
                return i;
        }
        return -1;
    }
}
