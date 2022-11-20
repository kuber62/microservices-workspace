package com.uniktech.persistor.controller;

import com.uniktech.persistor.entity.Transaction;
import com.uniktech.persistor.service.PersistorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
@Slf4j
public class PersistorController {

    @Autowired
    private PersistorService persistorService;

    @GetMapping("/all")
    public List<Transaction> getAll(){
        log.info("inside getAll method of PersistorController");
        return persistorService.fetchAll();
    }

    @GetMapping("/{topic}/all")
    public List<Transaction> getAllTxnByTopic(@PathVariable(value="topic") String topic) {
        log.info("inside getAll method of PersistorController");
        return persistorService.getAllTxnByTopic(topic);
    }
}
