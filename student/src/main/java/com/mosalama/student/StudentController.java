package com.mosalama.student;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {


    private final StudentService studentService;


    public StudentController(
       @Qualifier("db") StudentService studentService
    ) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student saveStudent(
         @RequestBody Student student
    ) {
        return studentService.save(student);
    }

    @GetMapping("/{email}")
    public Student findStudentByEmail(
          @PathVariable("email")  String email
    ){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping
    public Student updateStudent(
            @RequestBody Student student
    ){
        return studentService.update(student);
    }

    @DeleteMapping("/{email}")
    public void deleteStudent(
            @PathVariable("email") String email
    ) {
        studentService.deleteStudentByEmail(email);
    }


}
