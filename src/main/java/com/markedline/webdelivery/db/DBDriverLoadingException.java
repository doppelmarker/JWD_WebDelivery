package com.markedline.webdelivery.db;

public class DBDriverLoadingException extends RuntimeException {

    public DBDriverLoadingException(Exception e) {
        super(e);
    }
}
