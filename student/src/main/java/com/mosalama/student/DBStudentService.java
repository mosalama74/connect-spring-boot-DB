package com.mosalama.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("db")
public class DBStudentService implements StudentService{

    private StudentRepository repo;

    public DBStudentService(StudentRepository repository) {
        this.repo = repository;
    }

    @Override
    public Student save(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public Student update(Student student) {
        return repo.save(student);
    }

    @Override
    public void deleteStudentByEmail(String email) {
        repo.deleteByEmail(email);
    }
}
