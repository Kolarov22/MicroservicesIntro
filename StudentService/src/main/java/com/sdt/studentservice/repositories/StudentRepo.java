package com.sdt.studentservice.repositories;

import com.sdt.studentservice.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
    List<Student> findAll();
}
