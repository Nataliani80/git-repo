package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class PhoneBook {

    private Map<String, HashSet<String>> phones = new HashMap<>();


    void add(String name, String phoneNumber) {
        HashSet<String> value = phones.get(name);
        if (value == null) {
            value = new HashSet<>();
            value.add(phoneNumber);
            phones.put(name, value);
        } else {
            value.add(phoneNumber);
        }
    }

    HashSet<String> get(String name) {
        return phones.get(name);
    }
}
