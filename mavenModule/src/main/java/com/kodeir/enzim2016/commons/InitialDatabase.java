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

import com.kodeir.enzim2016.patients.Patient;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 23.07.2016.
 */
public class InitialDatabase {

    private Database database;
    private List<Patient> patients;

    private String testDbName = "enzim2016db";
    private String testDbUser = "defaultUser";
    private String testDbPwd = "default password";
    private String createTablePatients = "CREATE TABLE PATIENTS (" +
            "patientId IDENTITY" +
            ", name VARCHAR(255)" +
            ", surname VARCHAR(255)" +
            ", birthDate DATE" +
            ")";
    private String createTableCoefficients = "CREATE TABLE COEFFICIENTS (" +
            "date_inserted DATE PRIMARY KEY" +
            ", FOREIGN KEY patientId REFERENCES PATIENTS(patientId)" +
            ", AST FLOAT" +
            ", ALT FLOAT" +
            ", KFK FLOAT" +
            ", LDG FLOAT" +
            ", SHF FLOAT" +
            ", GGTP FLOAT" +
            ", GLDG FLOAT" +
            ", HE FLOAT" +
            ")";

    public InitialDatabase(){
        createPatients();
        createDatabase();
    }

    private void createPatients(){
        patients = new ArrayList<Patient>();
        patients.add(new Patient("name","agamanov",100, 1, 200, 200, 100, 1, 700, 13));
        patients.add(new Patient("name","barabanov",130, 20, 120, 200, 1200, 300, 800, 2));
        patients.add(new Patient("name","veneaminov",64, 50, 180, 2500, 1200, 20, 1200, 2));
        patients.add(new Patient("name","gurev",50, 150, 30, 500, 150, 120, 700, 10));
        patients.add(new Patient("name","durov",51, 100, 20, 200, 1200, 20, 1500, 10));
        patients.add(new Patient("name","egorov",100, 130, 20, 200, 1000, 1, 600, 30));
        patients.add(new Patient("name","zuravlev",80, 90, 200, 1200, 1500, 200, 1200, 10));
        patients.add(new Patient("name","zenkin",120, 120, 1500, 200, 1000, 200, 600, 10));
        patients.add(new Patient("name","karenina",68, 102, 200, 300, 230, 20, 789, 20));
        patients.add(new Patient("name","kirilov",110, 60, 100, 500, 200, 10, 1000, 10));
        patients.add(new Patient("name","leonidov",120, 100, 100, 230, 200, 1, 1400, 10));
        patients.add(new Patient("name","mechnikov",55, 150, 200, 2000, 200, 10, 1200, 5));
        patients.add(new Patient("name","nosov",60, 60, 1050, 1000, 130, 1, 1300, 10));
        patients.add(new Patient("name","ogurcov",68, 20, 130, 1000, 100, 20, 1200, 10));
        patients.add(new Patient("name","pirogov",70, 20, 130, 200, 100, 20, 1300, 2));
        patients.add(new Patient("name","ryabinin",42, 40, 100, 1000, 600, 12, 1600, 50));
        patients.add(new Patient("name","serebryanyi",50, 100, 100, 200, 120, 20, 700, 10));
        patients.add(new Patient("name","sukarev",60, 60, 200, 200, 200, 10, 700, 10));
        patients.add(new Patient("name","timiryazev",100, 120, 200, 300, 300, 40, 1200, 30));
        patients.add(new Patient("name","uvarov",90, 100, 110, 220, 200, 10, 1200, 2));
        patients.add(new Patient("name","udonov",60, 140, 200, 2300, 120, 10, 780, 5));
        patients.add(new Patient("name","faronov",140, 60, 40, 200, 100, 20, 700, 20));
        patients.add(new Patient("name","hudyakov",140, 50, 1700, 200, 120, 230, 820, 4));
        patients.add(new Patient("name","cereteli",50, 130, 130, 400, 1000, 30, 1100, 2));
        patients.add(new Patient("name","chekmincev",130, 40, 100, 300, 1200, 200, 1300, 5));
        patients.add(new Patient("name","shuvalov",50, 150, 100, 700, 300, 60, 700, 10));
        patients.add(new Patient("name","emanoylov",100, 200, 100, 230, 100, 200, 1300, 20));
        patients.add(new Patient("name","umashev",60, 20, 120, 1000, 100, 200, 1400, 3));
        patients.add(new Patient("name","hacker",50, 60, 100, 300, 80, 12, 1500, 70));
    }
    private void createDatabase(){
        database = new Database();
        database.setConnection(testDbName, testDbUser, testDbPwd);
        database.setStatement();
        database.runExecuteUpdateQuery(createTablePatients);
        database.runExecuteUpdateQuery(createTableCoefficients);
        for (Patient p: patients) {
            String insertIntoPatients = "INSERT INTO PATIENTS(NAME, SURNAME, BIRTHDATE) VALUES(" +
                    "'" + p.getName() + "'" +
                    ", '" + p.getSurname() + "'" +
                    ", '2001-01-01'" +
                    ")";
            database.runExecuteUpdateQuery(insertIntoPatients);

            String insertIntoCoefficients = "INSERT INTO COEFFICIENTS(date_inserted, patientId, AST, ALT, KFK, LDG, SHF, GGTP, GLDG, HE) VALUES(" +
                    "'" + LocalDate.now() + "'" +
                    ", (SELECT IDENTITY())" +
                    ", " + p.getAsT() +
                    ", " + p.getAlT() +
                    ", " + p.getKFK() +
                    ", " + p.getLDG() +
                    ", " + p.getShF() +
                    ", " + p.getGGTP() +
                    ", " + p.getGlDG() +
                    ", " + p.getHE() +
                    ")";
            database.runExecuteUpdateQuery(insertIntoCoefficients);
        }

    }
}
