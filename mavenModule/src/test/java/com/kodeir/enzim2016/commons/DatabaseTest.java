/*
 * Copyright (c) 2007, 2016 Vyacheslav Ryabinin and/or his affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Vyacheslav Ryabinin or the names of his
 *     affiliates may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 *  THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.kodeir.enzim2016.commons;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Sergei Riabinin on 10.07.2016.
 */
public class DatabaseTest {

    private static Database database = new Database();
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