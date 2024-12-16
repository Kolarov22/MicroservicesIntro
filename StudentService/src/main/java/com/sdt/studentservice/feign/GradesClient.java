package com.sdt.studentservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("GRADING-SERVICE")
public interface GradesClient {

    @PostMapping("api/v1/grades/byIds")
    ResponseEntity<List<?>> findGradesByIds(@RequestBody List<Long> ids);
}
