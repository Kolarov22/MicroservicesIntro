package com.sdt.studentservice.controllers;

import com.sdt.studentservice.domain.Student;
import com.sdt.studentservice.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        if(studentService.getStudent(id).isPresent()) {
            return ResponseEntity.ok(studentService.getStudent(id).get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Long>> getCourses(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getCourses(id));
    }

    @GetMapping("/{id}/grades")
    public ResponseEntity<List<?>> getGrades(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getGrades(id));
    }


}
