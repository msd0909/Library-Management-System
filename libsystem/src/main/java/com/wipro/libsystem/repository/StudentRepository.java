package com.wipro.libsystem.repository;
import com.wipro.libsystem.entity.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByUsernameAndPassword(String username, String password);
}
