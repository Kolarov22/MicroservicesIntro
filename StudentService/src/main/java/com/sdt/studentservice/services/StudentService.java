package com.sdt.studentservice.services;

import com.sdt.studentservice.domain.Student;
import com.sdt.studentservice.feign.GradesClient;
import com.sdt.studentservice.repositories.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepo studentRepo;
    private final GradesClient gradesClient;

    public StudentService(StudentRepo studentRepo, GradesClient gradesClient) {
        this.studentRepo = studentRepo;
        this.gradesClient = gradesClient;
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepo.findById(id);
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Long> getCourses(Long id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));
        return student.getCourses();
    }

    public List<?> getGrades(Long id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));
        return gradesClient.findGradesByIds(student.getGrades()).getBody();
    }



}
