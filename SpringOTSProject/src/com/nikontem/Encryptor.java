package com.nikontem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Encryptor {

    Map<String, ArrayList> crossedFields = new HashMap<>();


    public Encryptor(Map<String, ArrayList> crossedFields) {
        this.crossedFields = crossedFields;
    }

    abstract void Encrypt();

    abstract Map<String, ArrayList> getMap();

    public Map<String, ArrayList> getCrossedFields() {
        return crossedFields;
    }
}
