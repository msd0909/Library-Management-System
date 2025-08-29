package com.wipro.libsystem.service;

import com.wipro.libsystem.entity.Student;
import com.wipro.libsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private StudentRepository studentRepository;

    public boolean validateStudent(String username, String password) {
        Optional<Student> student = studentRepository.findByUsernameAndPassword(username, password);
        return student.isPresent();
    }
}
