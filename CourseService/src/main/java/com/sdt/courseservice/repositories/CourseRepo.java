package com.sdt.courseservice.repositories;

import com.sdt.courseservice.domain.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
    List<Course> findAll();
}
