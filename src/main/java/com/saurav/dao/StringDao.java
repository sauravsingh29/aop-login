package com.saurav.dao;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StringDao {

    private final Map<Integer, String> strings = new HashMap<>(0);

    private final AtomicInteger ids = new AtomicInteger(1);

    public void add(String name) {
        strings.put(ids.getAndIncrement(), name);
    }

    public String getAny() {
        Random random = new Random();
        return strings.getOrDefault(random.nextInt(ids.get() + 1), new String("Not found."));
    }
}
