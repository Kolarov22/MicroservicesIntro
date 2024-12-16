package com.sdt.professorservice.repositories;

import com.sdt.professorservice.domain.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Long> {
    List<Teacher> findAll();


}
