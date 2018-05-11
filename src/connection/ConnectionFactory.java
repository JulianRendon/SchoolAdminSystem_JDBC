/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Julian
 */
public class ConnectionFactory {

    private static Connection connection = null;

    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "student";
    public static final String PASS = "oracle";

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public void closeConnection() throws SQLException {

        if (connection != null) {
            connection.close();
        }
    }
}
