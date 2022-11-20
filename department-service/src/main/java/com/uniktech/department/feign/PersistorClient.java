package com.uniktech.department.feign;

import com.uniktech.department.dto.Txn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PERSISTOR-SERVICE")
public interface PersistorClient {

    @GetMapping("/search/{topic}/all")
    List<Txn> getAllTxnByTopic(@PathVariable(value="topic") String topic);
}
