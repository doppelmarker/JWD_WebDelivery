package com.markedline.webdelivery.db;

import com.markedline.webdelivery.listener.AppContextListener;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class MySQLDriverLoader {

    private static final MySQLDriverLoader instance = new MySQLDriverLoader();
    private static final Logger logger = Logger.getLogger(AppContextListener.class);
    private static final String ERROR_LOADING_DB_DRIVER = "Can't find database driver class.";

    private MySQLDriverLoader() {}

    public void load(String driverName) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FATAL, ERROR_LOADING_DB_DRIVER);
            throw new DBDriverLoadingException(e);
        }
    }

    public static MySQLDriverLoader getInstance() {
        return instance;
    }
}
