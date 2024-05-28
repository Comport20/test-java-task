package domain;

import java.util.List;

public interface CRUD {
    void getAllEntity();
    String postEntity(Credential credential);
    String deleteEntity(long account);
    String updateEntity(Credential credential);
    String getEntity(long account);
}
