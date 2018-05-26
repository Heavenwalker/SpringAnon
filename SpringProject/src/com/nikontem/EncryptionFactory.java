package com.nikontem;

import java.util.ArrayList;
import java.util.Map;

public class EncryptionFactory {
    private String encryptionMethod;
    private Map<String, ArrayList> sensitiveData;

    public EncryptionFactory(String encryptionMethod, Map<String, ArrayList> crossedFields) {
        this.encryptionMethod = encryptionMethod;
        this.sensitiveData = crossedFields;
    }

    Encryptor encryptor = null;

    public Encryptor EncryptMethod() {
        if (encryptionMethod.equals("AES")) {
            encryptor = new AESEncryption(sensitiveData);
            encryptor.Encrypt();
        }
        return encryptor;
    }


}
