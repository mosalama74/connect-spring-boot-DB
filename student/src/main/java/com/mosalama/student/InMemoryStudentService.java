package com.mosalama.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("im")
public class InMemoryStudentService implements StudentService{

    private final InMemoryDao dao;

    public InMemoryStudentService(InMemoryDao dao) {
        this.dao = dao;
    }


    @Override
    public Student save(Student student) {
        return dao.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudentByEmail(String email) {
        return dao.getStudentByEmail(email);
    }

    @Override
    public Student update(Student student) {
        return dao.update(student);
    }

    @Override
    public void deleteStudentByEmail(String email) {
        dao.deleteStudentByEmail(email);
    }
}
