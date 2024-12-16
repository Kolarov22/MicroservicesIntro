package com.sdt.courseservice.domain;

import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Long teacherId;

    public Course() {
    }

    public Course(Long id, String name, String description, Long teacherId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacherId = teacherId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacher(Long teacherId) {
        this.teacherId = teacherId;
    }
}
