package com.wipro.libsystem.service;
import com.wipro.libsystem.entity.Student;
import com.wipro.libsystem.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student stu = getStudentById(id);
        stu.setUsername(studentDetails.getUsername());
        stu.setPassword(studentDetails.getPassword());
        stu.setPhoneNo(studentDetails.getPhoneNo());
        stu.setAddress(studentDetails.getAddress());
        return studentRepository.save(stu);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
