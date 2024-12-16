package com.sdt.gradingservice.services;

import com.sdt.gradingservice.repositories.GradeRepo;
import com.sdt.gradingservice.domain.Grade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepo gradeRepo;

    public GradeService(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    public void saveGrade(Grade grade) {
        gradeRepo.save(grade);
    }

    public void deleteGrade(Long id) {
        gradeRepo.deleteById(id);
    }

    public List<Grade> getAllGrades() {
        return gradeRepo.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepo.findById(id);
    }

    public List<Grade> getGradesBySubject(String subject) {
        return gradeRepo.findAllBySubject(subject);
    }

    public List<Grade> findGradesByIds(List<Long> ids) {
        return gradeRepo.findAllById(ids);
    }



}
