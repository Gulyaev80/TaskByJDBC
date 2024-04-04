package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final Util INSTANCE = new Util();
    private Connection connection;

    public Util() {

    }

    public static Util getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybd", "root", "root");
            System.out.println("Connection OK!");
        }
        return connection;
    }



    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
        System.out.println("Connection close!!!");
    }


}
