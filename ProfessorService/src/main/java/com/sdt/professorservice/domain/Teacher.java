package com.sdt.professorservice.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String department;
    @ElementCollection
    private List<Long> courses = new ArrayList<>();

    public Teacher() {
    }


    public Teacher(Long id, String name, String department, List<Long> courses) {
        this.id = id;
        this.name = name;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Long> getCourses() {
        return courses;
    }

    public void setCourses(List<Long> courses) {
        this.courses = courses;
    }
}
