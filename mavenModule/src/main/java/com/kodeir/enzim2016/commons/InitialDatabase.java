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

import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.pi.Diagnose;
import com.kodeir.enzim2016.pi.Patient;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 23.07.2016.
 */
public class InitialDatabase {

    private static ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private static Database database;
    private static List<Patient> patients;
    private static List<Coefficients> coefficientsArray;
    private static List<Diagnose> diagnoses;

    private static String initialDbName = "enzim2016";
    private static String initialDbUser = "defaultUser";
    private static String initialDbPwd = "default password";
    private static String dbParams = ";CIPHER=AES";

    public static String createInitialDatabase(){
        if (checkIfDbFileExists()){
            return rb.getString("interface.create.initial_database.exists");
        } else {
            deleteDatabase();
            createPatients();
            createDatabase();
            return rb.getString("interface.create.initial_database.created");
        }
    }

    private static boolean checkIfDbFileExists(){
        return (new File("./data/"+initialDbName+".mv.db").exists());
    }

    private static void deleteDatabase(){
        database = new Database();
        database.setConnection(initialDbName + dbParams, initialDbUser, initialDbPwd);
        database.setStatement();
        database.runExecute("SHUTDOWN");
        org.h2.tools.DeleteDbFiles.execute("./data",initialDbName,true);
    }

    private static void createPatients(){
        patients = new ArrayList<Patient>();
        patients.add(createPatient(0,"name","agamanov","patron",100, 1, 200, 200, 100, 1, 700, 13));
        patients.add(createPatient(1,"name","barabanov","patron",130, 20, 120, 200, 1200, 300, 800, 2));
        patients.add(createPatient(2,"name","veneaminov","patron",64, 50, 180, 2500, 1200, 20, 1200, 2));
        patients.add(createPatient(3,"name","gurev","patron",50, 150, 30, 500, 150, 120, 700, 10));
        patients.add(createPatient(4,"name","durov","patron",51, 100, 20, 200, 1200, 20, 1500, 10));
        patients.add(createPatient(5,"name","egorov","patron",100, 130, 20, 200, 1000, 1, 600, 30));
        patients.add(createPatient(6,"name","zuravlev","patron",80, 90, 200, 1200, 1500, 200, 1200, 10));
        patients.add(createPatient(7,"name","zenkin","patron",120, 120, 1500, 200, 1000, 200, 600, 10));
        patients.add(createPatient(8,"name","karenina","patron",68, 102, 200, 300, 230, 20, 789, 20));
        patients.add(createPatient(9,"name","kirilov","patron",110, 60, 100, 500, 200, 10, 1000, 10));
        patients.add(createPatient(10,"name","leonidov","patron",120, 100, 100, 230, 200, 1, 1400, 10));
        patients.add(createPatient(11,"name","mechnikov","patron",55, 150, 200, 2000, 200, 10, 1200, 5));
        patients.add(createPatient(12,"name","nosov","patron",60, 60, 1050, 1000, 130, 1, 1300, 10));
        patients.add(createPatient(13,"name","ogurcov","patron",68, 20, 130, 1000, 100, 20, 1200, 10));
        patients.add(createPatient(14,"name","pirogov","patron",70, 20, 130, 200, 100, 20, 1300, 2));
        patients.add(createPatient(15,"name","ryabinin","patron",42, 40, 100, 1000, 600, 12, 1600, 50));
        patients.add(createPatient(16,"name","serebryanyi","patron",50, 100, 100, 200, 120, 20, 700, 10));
        patients.add(createPatient(17,"name","sukarev","patron",60, 60, 200, 200, 200, 10, 700, 10));
        patients.add(createPatient(18,"name","timiryazev","patron",100, 120, 200, 300, 300, 40, 1200, 30));
        patients.add(createPatient(19,"name","uvarov","patron",90, 100, 110, 220, 200, 10, 1200, 2));
        patients.add(createPatient(20,"name","udonov","patron",60, 140, 200, 2300, 120, 10, 780, 5));
        patients.add(createPatient(21,"name","faronov","patron",140, 60, 40, 200, 100, 20, 700, 20));
        patients.add(createPatient(22,"name","hudyakov","patron",140, 50, 1700, 200, 120, 230, 820, 4));
        patients.add(createPatient(23,"name","cereteli","patron",50, 130, 130, 400, 1000, 30, 1100, 2));
        patients.add(createPatient(24,"name","chekmincev","patron",130, 40, 100, 300, 1200, 200, 1300, 5));
        patients.add(createPatient(25,"name","shuvalov","patron",50, 150, 100, 700, 300, 60, 700, 10));
        patients.add(createPatient(26,"name","emanoylov","patron",100, 200, 100, 230, 100, 200, 1300, 20));
        patients.add(createPatient(27,"name","umashev","patron",60, 20, 120, 1000, 100, 200, 1400, 3));
        patients.add(createPatient(28,"name","hacker","patron",50, 60, 100, 300, 80, 12, 1500, 70));
    }

    private static Patient createPatient(long id, String name, String surname, String patron, float asT, float alT, float kfk, float ldg, float shF, float ggtp, float he, float glDG){
        Coefficients coefficients = new Coefficients(0, 0, asT, alT, kfk, ldg, shF, ggtp, he, glDG, LocalDate.now());
        coefficientsArray = new ArrayList<>();
        coefficientsArray.add(coefficients);
        return new Patient(id,name,surname,patron,LocalDate.now(),coefficientsArray);
    }

    private static void createDatabase(){
        database = new Database();
        database.setConnection(initialDbName, initialDbUser, initialDbPwd);
        database.setStatement();

        database.runExecuteUpdateQuery("CREATE TABLE IF NOT EXISTS PATIENTS (" +
                "  patient_id IDENTITY" +
                ", name VARCHAR(255)" +
                ", surname VARCHAR(255)" +
                ", patronymic VARCHAR(255)" +
                ", birthDate DATE" +
                ")"
        );

        database.runExecuteUpdateQuery("CREATE TABLE IF NOT EXISTS COEFFICIENTS (" +
                "  coefficient_id BIGINT AUTO_INCREMENT NOT NULL" +
                ", checkup_date DATE" +
                ", patient_id BIGINT" +
                ", foreign key (patient_id) references public.PATIENTS(patient_id)" +
                ", AST FLOAT" +
                ", ALT FLOAT" +
                ", KFK FLOAT" +
                ", LDG FLOAT" +
                ", SHF FLOAT" +
                ", GGTP FLOAT" +
                ", GLDG FLOAT" +
                ", HE FLOAT" +
                ")"
        );

        for (Patient p: patients) {
            String insertIntoPatients = "INSERT INTO PATIENTS(NAME, SURNAME, PATRONYMIC, BIRTHDATE) VALUES(" +
                    "  '" + p.getName() + "'" +
                    ", '" + p.getSurname() + "'" +
                    ", '" + p.getPatronymic() + "'" +
                    ", '" + p.getBirthDate() + "'" +
                    ")";
            database.runExecuteUpdateQuery(insertIntoPatients);

            float ast = 0f;
            float alt = 0f;
            float kfk = 0f;
            float ldg = 0f;
            float shf = 0f;
            float ggtp = 0f;
            float he = 0f;
            float gldg = 0f;

            List<Coefficients> coefficients = p.getCoefficients();
            for (Coefficients c: coefficients){
                ast = c.getAst();
                alt = c.getAlt();
                kfk = c.getKfk();
                ldg = c.getLdg();
                shf = c.getShf();
                ggtp = c.getGgtp();
                he = c.getHe();
                gldg = c.getGldg();
            }

            String insertIntoCoefficients = "INSERT INTO COEFFICIENTS(checkup_date, patient_id, AST, ALT, KFK, LDG, SHF, GGTP, GLDG, HE) VALUES(" +
                    " '" + LocalDate.now() + "'" +
                    ", (SELECT IDENTITY())" +
                    ", " + ast +
                    ", " + alt +
                    ", " + kfk +
                    ", " + ldg +
                    ", " + shf +
                    ", " + ggtp +
                    ", " + gldg +
                    ", " + he +
                    ")";
            database.runExecuteUpdateQuery(insertIntoCoefficients);

        }
    }

}
