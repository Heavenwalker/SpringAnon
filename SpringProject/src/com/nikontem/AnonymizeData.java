package com.nikontem;

import java.util.*;

public class AnonymizeData {

    private Map<String, ArrayList> encryptedData = new HashMap<>();
    private List<String[]> cypherFields = new ArrayList<>();
    private List<String> index = new ArrayList<>();
    private int j;

    public AnonymizeData(Map<String, ArrayList> encryptedData, List<String[]> cypherFields) {
        this.encryptedData = encryptedData;
        this.cypherFields = cypherFields;
    }

    private List<String[]> mergeData() {

        for (Map.Entry<String, ArrayList> entry : encryptedData.entrySet()) {
            for (int i = 0; i < cypherFields.get(0).length; i++) {
                if (cypherFields.get(0)[i].equals(entry.getKey())) {
                    index.add(Integer.toString(i));
                }
            }
        }

        for (int i = 0; i < index.size(); i++) {
            for (Map.Entry<String, ArrayList> entry : encryptedData.entrySet()) {
                if (cypherFields.get(0)[Integer.parseInt(index.get(i))].equals(entry.getKey())) {
                    for (String[] e : cypherFields) {
                        if (e[Integer.parseInt(index.get(i))].equals(entry.getKey())) {

                            j = 0;

                        } else {

                            e[Integer.parseInt(index.get(i))] = entry.getValue().get(j).toString();
                            j++;

                        }
                    }
                }
            }
        }


        return cypherFields;
    }


    public List<String[]> getCypherFields() {
        return mergeData();
    }
}