package com.saurav.service;

import com.saurav.dao.StringDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.UndeclaredThrowableException;

@Service
public class RandomString {

    @Autowired
    private StringDao stringDao;


    public void add(String name) {
        stringDao.add(name);
    }

    public String random() {
        return stringDao.getAny();
    }

    public void logError() throws UndeclaredThrowableException{
        throw new RuntimeException("I am forced to throw");
    }
}
