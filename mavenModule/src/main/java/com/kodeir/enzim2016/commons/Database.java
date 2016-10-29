package com.kodeir.enzim2016.commons;

import java.sql.ResultSet;

/**
 * Created by Sergei Riabinin on 29.10.2016.
 */
public interface Database {

    boolean setConnectionIfDbExist(String database, String user, String password);

    boolean setConnection(String database, String user, String password);

    boolean closeConnection();

    boolean setStatement();

    boolean closeStatement();

    boolean runExecuteUpdateQuery(String sql);

    boolean runExecute(String sql);

    ResultSet runSelectQuery(String sql);

    boolean connectionIsNull();

    boolean statementIsNull();

    boolean commit();

}
