package com.memoryDB.domain;

import java.util.List;

public interface MemoryDBCRUD {
    List<Credential> getAllEntity();
    Credential postEntity(Credential credential);
    Credential deleteEntity(long account);
    Credential updateEntity(long account,String name, double value);
    Credential getEntity(long account);

}
