package com.sdt.courseservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("GRADING-SERVICE")
public interface GradesClient {

    @GetMapping("api/v1/grades/subject/{subject}")
    public ResponseEntity<List<?>> getGradesBySubject(@PathVariable String subject);

}
