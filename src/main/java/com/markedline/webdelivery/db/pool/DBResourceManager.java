package com.markedline.webdelivery.db.pool;

import java.util.ResourceBundle;

public class DBResourceManager {
    private static final String DB_PROPS_FILE_PATH = "resources.db";

    private final static DBResourceManager instance = new DBResourceManager();

    private final ResourceBundle bundle = ResourceBundle.getBundle(DB_PROPS_FILE_PATH);

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}
