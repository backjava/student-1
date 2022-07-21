package main.service;

import main.model.Student;
import main.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import main.model.StudentRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity getStudentById(@PathVariable int id) {
      Optional<Student> student = studentRepository.findById(id);
      if (student.isPresent()) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      } else {
          return new ResponseEntity(student.get().getName(), HttpStatus.OK);
      }
    }
}
