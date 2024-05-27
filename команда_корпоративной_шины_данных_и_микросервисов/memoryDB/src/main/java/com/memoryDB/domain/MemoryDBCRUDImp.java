package com.memoryDB.domain;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemoryDBCRUDImp implements MemoryDBCRUD {
    private final Map<Long,Credential> memoryDBHashMap;
    public MemoryDBCRUDImp(){
        memoryDBHashMap = new HashMap<>();
    }
    @Override
    public Credential postEntity(Credential credential) {
        if(!memoryDBHashMap.containsKey(credential.getAccount())) {
            memoryDBHashMap.put(credential.getAccount(), credential);
            return credential;
        }
        return null;
    }
    @Override
    public Credential getEntity(long account) {
        if(memoryDBHashMap.containsKey(account)){
            return memoryDBHashMap.get(account);
        }
        return null;
    }
    @Override
    public List<Credential> getAllEntity() {
        if(!memoryDBHashMap.isEmpty())
            return new ArrayList<>(memoryDBHashMap.values());
        return null;
    }

    @Override
    public Credential deleteEntity(long account) {
        if(memoryDBHashMap.containsKey(account)) {
            Credential removeCredential = memoryDBHashMap.get(account);
            memoryDBHashMap.remove(account);
            return removeCredential;
        }
        return null;
    }
    @Override
    public Credential updateEntity(long account, String name, double value) {
        if(memoryDBHashMap.containsKey(account)){
            Credential credential = memoryDBHashMap.get(account);
            if(!name.equals("undefined"))
                credential.setName(name);
            if(value != -1)
                credential.setValue(value);
            return credential;
        }
        return null;
    }
}
