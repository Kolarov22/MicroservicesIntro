package com.sdt.gradingservice.controllers;

import com.sdt.gradingservice.domain.Grade;
import com.sdt.gradingservice.services.GradeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grades")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public ResponseEntity<?> fallbackGrading(Exception e) {
        return new ResponseEntity<>("Service is down", HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PostMapping()
    public ResponseEntity<?> saveGrade(@RequestBody Grade grade) {
        gradeService.saveGrade(grade);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        if(gradeService.getGradeById(id).isPresent()) {
            return ResponseEntity.ok(gradeService.getGradeById(id).get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Grade>> getAllGrades() {
        return ResponseEntity.ok(gradeService.getAllGrades());
    }

    @GetMapping("/subject/{subject}")
    public ResponseEntity<List<?>> getGradesBySubject(@PathVariable String subject) {
        return ResponseEntity.ok(gradeService.getGradesBySubject(subject));
    }

    @PostMapping("/byIds")
    public ResponseEntity<List<?>> findGradesByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(gradeService.findGradesByIds(ids));
    }

    @GetMapping("/dead")
    @CircuitBreaker(name = "gradingService", fallbackMethod = "fallbackGrading")
    public ResponseEntity<?> dead() {
        if(Math.random() > 0.5){
            throw new RuntimeException("Service is down");
        }
            return new ResponseEntity<>("Service is up", HttpStatus.OK);
    }
}
