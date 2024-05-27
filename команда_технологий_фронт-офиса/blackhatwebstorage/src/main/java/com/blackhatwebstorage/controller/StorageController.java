package com.blackhatwebstorage.controller;

import com.blackhatwebstorage.model.CacheStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {
    @Autowired
    CacheStorage cacheStorage;

    @GetMapping(value = "/phone",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getConsumers(@RequestParam(defaultValue = "9000000000") String phone) {
        String name = cacheStorage.getConsumer(phone);
        String responseBody = "phone:" + phone + "\nname:" + name;
        return ResponseEntity.ok(responseBody);
    }
}
