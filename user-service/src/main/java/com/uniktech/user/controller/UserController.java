package com.uniktech.user.controller;

import com.uniktech.user.config.UnikServiceProperties;
import com.uniktech.user.dto.Txn;
import com.uniktech.user.dto.UserResponse;
import com.uniktech.user.entity.Users;
import com.uniktech.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/users")
@Slf4j
@EnableConfigurationProperties(UnikServiceProperties.class)
public class UserController {

	@Autowired
	private UnikServiceProperties unikServiceProperties;
	
	@Autowired
    private UserService userService;
    
    @GetMapping("/getMessage")
    public String getMessageFromConfigServer() {
        return unikServiceProperties.getMessage();
    }

    @GetMapping("/getTxns")
    public List<Txn> getAllTxnByTopic(){
        return userService.getAllTxnByTopic();
    }

    @PostMapping("/create")
    public Users saveUser(@RequestBody Users user) {
        log.info("inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/get/{id}")
    public UserResponse findUserById(@PathVariable("id") Long userId) {
        log.info("inside findUserById method of UserController");
        return userService.findUserByIdWithDepartment(userId);
    }
}
