package com.sdt.courseservice.services;

import com.sdt.courseservice.feign.GradesClient;
import com.sdt.courseservice.repositories.CourseRepo;
import com.sdt.courseservice.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepo courseRepo;
    private final GradesClient gradesClient;

    public CourseService(CourseRepo courseRepo, GradesClient gradesClient) {
        this.courseRepo = courseRepo;
        this.gradesClient = gradesClient;
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepo.findById(id);
    }

    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public List<?> getGradesOfCourse(Long courseId) {
        Optional<Course> course = courseRepo.findById(courseId);
        if(course.isPresent()) {
            return gradesClient.getGradesBySubject(course.get().getName()).getBody();
        } else {
            return null;
        }
    }



}
