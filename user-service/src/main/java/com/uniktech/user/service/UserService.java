package com.uniktech.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniktech.user.dto.Department;
import com.uniktech.user.dto.Txn;
import com.uniktech.user.dto.UnikContext;
import com.uniktech.user.dto.UserResponse;
import com.uniktech.user.entity.Users;
import com.uniktech.user.feign.DepartmentClient;
import com.uniktech.user.feign.PersistorClient;
import com.uniktech.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Value("${spring.application.name}")
    private String TOPIC;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JmsService jmsService;

    @Autowired
    private DepartmentClient departmentClient;

    @Autowired
    private PersistorClient persistorClient;

    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users user) {
        log.info("inside saveUser method of UserService");
        try {
            jmsService.sendMessage(objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } finally {
            return userRepository.save(user);
        }
    }

    public UserResponse findUserByIdWithDepartment(Long userId) {
        log.info("inside findUserById method of UserService");
        Users user = userRepository.findByUserId(userId);
        Department department = departmentClient.getDepartmentById(user.getDepartmentId());
        return new UserResponse(user,department);
    }

    public List<Txn> getAllTxnByTopic() {
        return persistorClient.getAllTxnByTopic(TOPIC);
    }
}
