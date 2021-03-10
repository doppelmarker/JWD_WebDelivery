package com.markedline.webdelivery.db;

public class MySQLDriverLoader {

    private static final MySQLDriverLoader instance = new MySQLDriverLoader();
    private static final String MYSQL_DRIVER_CLASSPATH = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(MYSQL_DRIVER_CLASSPATH);
        } catch (ClassNotFoundException e) {
            throw new DBDriverLoadingException(e);
        }
    }

    private MySQLDriverLoader() {}

    public static MySQLDriverLoader getInstance() {
        return instance;
    }
}
