package com.sdt.gradingservice.repositories;

import com.sdt.gradingservice.domain.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepo extends CrudRepository<Grade, Long> {
    List<Grade> findAll();

    List<Grade> findAllBySubject(String subject);

    @Override
    List<Grade> findAllById(Iterable<Long> longs);
}
