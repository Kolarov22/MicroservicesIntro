package com.sdt.professorservice.services;

import com.sdt.professorservice.repositories.TeacherRepo;
import com.sdt.professorservice.domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepo.findById(id);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public List<Long> getTeacherCourses(Long id) {
        if (teacherRepo.findById(id).isEmpty()) {
            return null;
        }
        return teacherRepo.findById(id).get().getCourses();
    }


}
