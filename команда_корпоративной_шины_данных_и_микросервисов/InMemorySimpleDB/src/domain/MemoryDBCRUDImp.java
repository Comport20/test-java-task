package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoryDBCRUDImp implements CRUD{
    private final Map<Long,Credential> memoryDBHashMap;
    public MemoryDBCRUDImp(){
        memoryDBHashMap = new HashMap<>();
    }
    @Override
    public String postEntity(Credential credential) {
        if(!memoryDBHashMap.containsKey(credential.getAccount())) {
            memoryDBHashMap.put(credential.getAccount(), credential);
            return credential.toString();
        }
        return null;
    }
    @Override
    public String getEntity(long account) {
        if(memoryDBHashMap.containsKey(account)){
            return memoryDBHashMap.get(account).toString();
        }
        return null;
    }
    @Override
    public void getAllEntity() {
        for(Map.Entry<Long,Credential> entry: memoryDBHashMap.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    @Override
    public String deleteEntity(long account) {
        if(memoryDBHashMap.containsKey(account)) {
            String removeCredential = memoryDBHashMap.get(account).toString();
            memoryDBHashMap.remove(account);
            return removeCredential;
        }
        return null;
    }
    @Override
    public String updateEntity(Credential credential) {
        if(memoryDBHashMap.containsKey(credential.getAccount())){
            deleteEntity(credential.getAccount());
            postEntity(credential);
            return credential.toString();
        }
        return null;
    }
}
