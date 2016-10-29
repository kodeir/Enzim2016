package com.kodeir.enzim2016.commons;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by Sergei Riabinin on 10.07.2016.
 */
public class EnzimDatabase implements Database {

    private static final EnzimLogger logger = new EnzimLogger(EnzimDatabase.class.getName());

    private Connection connection = null;
    private Statement statement = null;

    private boolean printSqlException(SQLException e, String message){
        logger.log(Level.SEVERE, message
                                + "\n"
                                + "Error code: " + e.getErrorCode()
                                + "\n"
                                + e.getMessage()
                                + "\n"
                                , e);
        return false;
    }

    public boolean setConnectionIfDbExist(String database, String user, String password){
        try {
            connection = DriverManager.getConnection("jdbc:h2:./data/" + database + ";CIPHER=AES;IFEXISTS=TRUE", user, password);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return printSqlException(e, "Failed to open connection to " + database + " with user = " + user + "!");
        }
    }

    public boolean setConnection(String database, String user, String password){
        try {
            connection = DriverManager.getConnection("jdbc:h2:./data/" + database + ";CIPHER=AES", user, password);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return printSqlException(e, "Failed to open connection to " + database + " with user = " + user + "!");
        }
    }

    public boolean closeConnection(){
        try{
            if (statement != null) {
                statement.close();
                logger.log(Level.FINE, "Statement was closed successfully.");
                return true;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return printSqlException(e, "Failed to close a statement.");
        }
        try{
            if (connection != null) {
                connection.close();
                logger.log(Level.FINE, "Connection was closed successfully.");
                return true;
            } else {
                return true;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return printSqlException(e, "Failed to close a connection.");
        }
    }

    public boolean setStatement(){
        try {
            statement = connection.createStatement();
            return true;
        } catch (SQLException e) {
            return printSqlException(e, "Failed to create a statement.");
        }
    }

    public boolean closeStatement(){
        try {
            statement.close();
            return true;
        } catch (SQLException e) {
            return printSqlException(e, "Failed to close a statement.");
        }
    }

    public boolean runExecuteUpdateQuery(String sql){
        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            return printSqlException(e, "ExecuteUpdateQuery failed");
        }
    }

    public boolean runExecute(String sql){
        try {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            return printSqlException(e, "ExecuteQuery failed");
        }
    }

    //TODO get rid of null
    public ResultSet runSelectQuery(String sql){
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            printSqlException(e, "SelectQuery failed");
            return null;
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
            return printSqlException(e, "Commit failed");
        }
    }

    private void deleteDatabase(String dbName){
        runExecute("SHUTDOWN");
        org.h2.tools.DeleteDbFiles.execute("./data",dbName,true);
    }

}
