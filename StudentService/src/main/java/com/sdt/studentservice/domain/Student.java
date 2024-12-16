package com.sdt.studentservice.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ElementCollection
    private List<Long> grades = new ArrayList<>();
    @ElementCollection
    private List<Long> courses = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String name, List<Long> grades, List<Long> courses) {
        this.id = id;
        this.name = name;
        this.grades = grades;
        this.courses = courses;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getGrades() {
        return grades;
    }

    public void setGrades(List<Long> grades) {
        this.grades = grades;
    }

    public List<Long> getCourses() {
        return courses;
    }

    public void setCourses(List<Long> courses) {
        this.courses = courses;
    }
}
