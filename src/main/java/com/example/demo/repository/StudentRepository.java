package com.example.demo.repository;

import com.example.demo.dao.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Student repository.
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
