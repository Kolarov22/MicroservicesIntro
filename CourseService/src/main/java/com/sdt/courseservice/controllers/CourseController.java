package com.sdt.courseservice.controllers;

import com.sdt.courseservice.domain.Course;
import com.sdt.courseservice.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(Long id) {
        if (courseService.getCourseById(id).isPresent()) {
            return ResponseEntity.ok(courseService.getCourseById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{courseId}/grades")
    public ResponseEntity<?> getGradesOfCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getGradesOfCourse(courseId));
    }
}
