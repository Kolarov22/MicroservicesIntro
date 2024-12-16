package com.sdt.gradingservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private Long id;
    private String subject;
    private int grade;

    public Grade() {
    }

    public Grade(Long id, String subject, int grade) {
        this.id = id;
        this.subject = subject;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



}
