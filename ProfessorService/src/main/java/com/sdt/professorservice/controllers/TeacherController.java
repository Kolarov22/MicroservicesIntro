package com.sdt.professorservice.controllers;

import com.sdt.professorservice.domain.Teacher;
import com.sdt.professorservice.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping()
    public ResponseEntity<?> saveTeacher(@RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Long id) {
        if (teacherService.getTeacherById(id).isPresent()) {
            return ResponseEntity.ok(teacherService.getTeacherById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getTeacherCourses(@PathVariable Long id) {
        if (teacherService.getTeacherCourses(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacherService.getTeacherCourses(id));
    }
}
