package com.kodeir.enzim2016.commons;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Sergei Riabinin on 10.07.2016.
 */
public class EnzimDatabaseTest {

    private static EnzimDatabase database = new EnzimDatabase();
    private static String testDbName = "database";
    private static String testDbUser = "user";
    private static String testDbPwd = "password password";
    private static String dbParams = ";DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1";
    private static String createTablePatients = "CREATE TABLE PATIENTS (" +
            "patientId INTEGER AUTO_INCREMENT PRIMARY KEY" +
            ", name VARCHAR(255)" +
            ", surname VARCHAR(255)" +
            ", birthDate DATE" +
            ")";
    private static String insertIntoPatients = "INSERT INTO PATIENTS(NAME, SURNAME, BIRTHDATE) VALUES(" +
            "'Name'" +
            ", 'Surname'" +
            ", '2001-01-01'" +
            ")";

    private static void createCleanDb(){
        database.setConnection(testDbName + dbParams, testDbUser, testDbPwd);
    }

    private static void createCleanDbWithStatement(){
        database.setConnection(testDbName + dbParams, testDbUser, testDbPwd);
        database.setStatement();
    }

    private static void deleteDatabase(){
        database.setConnection(testDbName + dbParams, testDbUser, testDbPwd);
        database.setStatement();
        database.runExecute("SHUTDOWN");
        org.h2.tools.DeleteDbFiles.execute("./data",testDbName,true);
    }

    @Before
    public void before(){
        deleteDatabase();
    }

    @After
    public void after(){
        deleteDatabase();
    }

    @Test
    public void testSetConnectionExist1()  {
        assertFalse(database.setConnectionIfDbExist(testDbName + dbParams, testDbUser, testDbPwd));
    }

    @Test
    public void testSetConnectionExist2()  {
        createCleanDb();
        assertTrue(database.setConnectionIfDbExist(testDbName + dbParams, testDbUser, testDbPwd));
    }


    @Test
    public void testSetConnectionNew1()  {
        assertTrue(database.setConnection(testDbName + dbParams, testDbUser, testDbPwd));
    }

    @Test
    public void testSetConnectionNew2()  {
        createCleanDb();
        assertTrue(database.setConnection(testDbName + dbParams, testDbUser, testDbPwd));
    }

    @Test
    public void testCloseConnection()  {
        createCleanDb();
        assertTrue(database.closeConnection());
    }

    @Test
    public void testSetStatement()  {
        createCleanDb();
        assertTrue(database.setStatement());
    }

    @Test
    public void testCloseStatement()  {
        createCleanDbWithStatement();
        assertTrue(database.closeStatement());
    }

    @Test
    public void testCreate()  {
        createCleanDbWithStatement();
        assertTrue(database.runExecuteUpdateQuery(createTablePatients));
    }

    @Test
    public void testInsert()  {
        createCleanDbWithStatement();
        database.runExecuteUpdateQuery(createTablePatients);
        assertTrue(database.runExecuteUpdateQuery(insertIntoPatients));
    }

    @AfterClass
    public static void afterClass(){
        deleteDatabase();
    }
}