package com.uniktech.user.feign;

import com.uniktech.user.dto.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface DepartmentClient {

    @GetMapping("/departments/get/{id}")
    Department getDepartmentById(@PathVariable(value="id") Long departmentId);
}
