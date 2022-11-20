package com.uniktech.department.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniktech.department.dto.Txn;
import com.uniktech.department.entity.Department;
import com.uniktech.department.feign.PersistorClient;
import com.uniktech.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Value("${spring.application.name}")
    private String TOPIC;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JmsService jmsService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PersistorClient persistorClient;

    public Department saveDepartment(Department department) {
        log.info("inside saveDepartment method of DepartmentService");
        try {
            jmsService.sendMessage(objectMapper.writeValueAsString(department));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } finally {
            return departmentRepository.save(department);
        }
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("inside findDepartmentById method of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Txn> getAllTxnByTopic() {
        return persistorClient.getAllTxnByTopic(TOPIC);
    }
}
