package com.mosalama.student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryDao {

    private List<Student> STUDENTS = new ArrayList<Student>();

    public Student save(Student student) {
         STUDENTS.add(student);

         return student;
    }

    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    public Student getStudentByEmail(String email) {

        var student = STUDENTS.stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElse(null);

        return student;
    }

    public Student update(Student student) {
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);

        if (studentIndex != -1) {
            STUDENTS.set(studentIndex, student);
            return student;
        }
        return null;
    }

    public void deleteStudentByEmail(String email) {
        var student = getStudentByEmail(email);
        if(student != null) {
            STUDENTS.remove(student);
        }

    }
}
