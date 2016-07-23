package com.kodeir.enzim2016.commons;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.LogManager;

/**
 * Created by Sergei Riabinin on 10.07.2016.
 */
public class Database {

    //private static final LogManager log = new LogManager(Database.class.getName());
    private Connection connection = null;
    private Statement statement = null;

    /*
    private boolean printSqlException(SQLException e, String message){
        log.log(Level.SEVERE, message
                                + "\n"
                                + "Error code: " + e.getErrorCode()
                                + "\n"
                                + e.getMessage()
                                + "\n"
                                , e);
        return false;
    }
    */

    public boolean setConnectionIfDbExist(String database, String user, String password){
        try {
            connection = DriverManager.getConnection("jdbc:h2:./data/" + database + ";CIPHER=AES;IFEXISTS=TRUE", user, password);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
            //return printSqlException(e, "Failed to open connection to " + url + " with user = " + user + "!");
        }
    }

    public boolean setConnection(String database, String user, String password){
        try {
            connection = DriverManager.getConnection("jdbc:h2:./data/" + database + ";CIPHER=AES", user, password);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
            //return printSqlException(e, "Failed to open connection to " + url + " with user = " + user + "!");
        }
    }

    public boolean closeConnection(){
        try{
            if (statement != null) {
                statement.close();
                return true;
                //log.log(Level.FINE, "Statement was closed successfully.");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
            //return printSqlException(e, "Failed to close statement.");
        }
        try{
            if (connection != null) {
                connection.close();
                return true;
                //log.log(Level.FINE, "Connection was closed successfully.");
            } else {
                return true;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
            //return printSqlException(e, "Failed to close connection.");
        }
    }

    public boolean setStatement(){
        try {
            statement = connection.createStatement();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean closeStatement(){
        try {
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean runExecuteUpdateQuery(String sql){
        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean runExecute(String sql){
        try {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean connectionIsNull(){
        return connection == null;
    }

    public boolean statementIsNull(){
        return statement == null;
    }

    public boolean commit(){
        try {
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
