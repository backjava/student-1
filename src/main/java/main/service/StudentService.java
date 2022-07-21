package main.service;

import main.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    ResponseEntity getStudentById(int id);
}
