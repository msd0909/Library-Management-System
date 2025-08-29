package com.wipro.libsystem.controller;

import com.wipro.libsystem.entity.Student;
import com.wipro.libsystem.repository.AddressRepository;
import com.wipro.libsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")  // Angular port
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    // Save Student with Address
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student); // saves student + address
    }

    // Get all Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    // Update Student + Address
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

        student.setUsername(updatedStudent.getUsername());
        student.setPassword(updatedStudent.getPassword());
        student.setEmail(updatedStudent.getEmail());
        student.setPhoneNo(updatedStudent.getPhoneNo());

        if (student.getAddress() != null) {
            student.getAddress().setDoorNo(updatedStudent.getAddress().getDoorNo());
            student.getAddress().setStreet(updatedStudent.getAddress().getStreet());
            student.getAddress().setCity(updatedStudent.getAddress().getCity());
            student.getAddress().setState(updatedStudent.getAddress().getState());
            student.getAddress().setPincode(updatedStudent.getAddress().getPincode());
        } else {
            student.setAddress(updatedStudent.getAddress());
        }

        return studentRepository.save(student);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        studentRepository.delete(student);
        return "Student with ID " + id + " deleted successfully!";
    }
}
