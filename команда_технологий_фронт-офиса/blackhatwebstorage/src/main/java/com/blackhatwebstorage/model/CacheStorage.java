package com.blackhatwebstorage.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CacheStorage {
    private Map<String, String> consumerMap;

    public CacheStorage() {
        this.consumerMap = new HashMap<>(18758328);
    }
    public String getConsumer(String phone){
        if (consumerMap.containsKey(phone))
            return consumerMap.get(phone);
        return null;
    }
    public Map<String, String> getConsumerMap() {
        return consumerMap;
    }

    public void setConsumerMap(Map<String, String> consumerMap) {
        this.consumerMap = consumerMap;
    }
}
