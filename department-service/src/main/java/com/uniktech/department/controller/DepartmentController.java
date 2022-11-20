package com.uniktech.department.controller;

import com.uniktech.department.dto.Txn;
import com.uniktech.department.entity.Department;
import com.uniktech.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getTxns")
    public List<Txn> getAllTxnByTopic(){
        return departmentService.getAllTxnByTopic();
    }

    @PostMapping("/create")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/get/{id}")
    public Department findDepartmentById(@PathVariable(value = "id") Long departmentId) {
        log.info("inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }
}
