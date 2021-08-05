package com.solvd.savich.database;

import com.solvd.savich.music.properties.Util;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector {
    private final static Logger LOGGER = Logger.getLogger(Util.class);
    private final String url = Util.getPropertiesValue("URL");
    private final String login = Util.getPropertiesValue("LOGIN");
    private final String password = Util.getPropertiesValue("PASSWORD");

    public Connection getConnect() {
       Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, login, password);

        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

}
