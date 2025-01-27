package com.mosalama.student;

import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    Student save(Student student);
    List<Student> getAllStudents();
    Student getStudentByEmail(String email);
    Student update(Student student);
    void deleteStudentByEmail(String email);
}
