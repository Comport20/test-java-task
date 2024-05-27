package com.memoryDB.controller;

import com.memoryDB.domain.Credential;
import com.memoryDB.domain.MemoryDBCRUDImp;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CredentialController {
    private final MemoryDBCRUDImp memoryDBCRUDImp;

    public CredentialController(MemoryDBCRUDImp memoryDBCRUDImp) {
        this.memoryDBCRUDImp = memoryDBCRUDImp;
    }

    @GetMapping("/credential")
    public ResponseEntity<List<Credential>> getCredentials(){
        List<Credential> credentialList = memoryDBCRUDImp.getAllEntity();
        if(credentialList != null)
            return ResponseEntity.ok(credentialList);
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/credential/{account}")
    public ResponseEntity<Credential> getCredential(@PathVariable(name = "account") long account){
        Credential getCredential = memoryDBCRUDImp.getEntity(account);
        if(getCredential != null)
            return ResponseEntity.ok(getCredential);
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/credential")
    public ResponseEntity<Credential> postCredential(@RequestBody @Validated Credential credential){
        Credential postCredential = memoryDBCRUDImp.postEntity(credential);
        if(postCredential != null)
            return ResponseEntity.ok(credential);
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/credential/{account}")
    public ResponseEntity<Credential> deleteCredential(@PathVariable(name = "account") long account){
        Credential deleteCredential = memoryDBCRUDImp.deleteEntity(account);
        if(deleteCredential != null)
            return ResponseEntity.ok(deleteCredential);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/credential/{account}")
    public ResponseEntity<Credential> updateCredential(@PathVariable(name = "account") long account, @RequestParam(defaultValue = "undefined") String name, @RequestParam(defaultValue = "-1") double value){
        Credential updateCredential = memoryDBCRUDImp.updateEntity(account, name,value);
        if(updateCredential != null)
            return ResponseEntity.ok(updateCredential);
        return ResponseEntity.notFound().build();
    }
}
