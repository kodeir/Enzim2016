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
import com.kodeir.enzim2016.pi.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class PatientsDatabase {

    public static final String createTablePatients = "CREATE TABLE IF NOT EXISTS PATIENTS (" +
            "  patient_id IDENTITY" +
            ", name VARCHAR(255)" +
            ", surname VARCHAR(255)" +
            ", patronymic VARCHAR(255)" +
            ", birthDate DATE" +
            ")";

    public static final String createTableCoefficients = "CREATE TABLE IF NOT EXISTS COEFFICIENTS (" +
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
            ")";

    public static String insertToPatiens(String name, String surname, String patronymic, LocalDate birthDate){
        return "INSERT INTO PATIENTS(NAME, SURNAME, PATRONYMIC, BIRTHDATE) VALUES(" +
                "  '" + name + "'" +
                ", '" + surname + "'" +
                ", '" + patronymic + "'" +
                ", '" + birthDate + "'" +
                ")";
    }

    public static String insertToCoefficients(LocalDate checkupDate, float ast, float alt, float kfk, float ldg, float shf, float ggtp, float he, float gldg){
        return "INSERT INTO COEFFICIENTS(checkup_date, patient_id, AST, ALT, KFK, LDG, SHF, GGTP, GLDG, HE) VALUES(" +
                " '" + checkupDate + "'" +
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
    }

    public static boolean connectToDatabaseAnyway(Database database){
        return database.setConnection(
                PropertyHandler.getInstance().getValue("datasource.url"),
                PropertyHandler.getInstance().getValue("datasource.username"),
                PropertyHandler.getInstance().getValue("datasource.password"));
    }

    public static boolean connectToDatabaseIfExists(Database database){
        return database.setConnectionIfDbExist(
                PropertyHandler.getInstance().getValue("datasource.url"),
                PropertyHandler.getInstance().getValue("datasource.username"),
                PropertyHandler.getInstance().getValue("datasource.password"));
    }

    public static String selectAll(Database database){
        ResultSet rs = database.runSelectQuery("SELECT * " +
                "FROM PATIENTS P " +
                "JOIN COEFFICIENTS C " +
                "ON P.patient_id = C.patient_id");
        List<Patient> patients = new ArrayList<>();
        try {
            while (rs.next()){
                Coefficients coefficients = new Coefficients(rs.getLong("COEFFICIENT_ID"),rs.getLong("PATIENT_ID"),
                        rs.getFloat("AST"),rs.getFloat("ALT"),rs.getFloat("KFK"),rs.getFloat("LDG"),
                        rs.getFloat("SHF"),rs.getFloat("GGTP"),rs.getFloat("GLDG"),rs.getFloat("HE"),
                        rs.getDate("CHECKUP_DATE").toLocalDate());
                List<Coefficients> coefficientses = new ArrayList<>();
                coefficientses.add(coefficients);
                patients.add(new Patient(rs.getLong("PATIENT_ID"),
                        rs.getString("NAME"),rs.getString("SURNAME"),rs.getString("PATRONYMIC"),
                        rs.getDate("BIRTHDATE").toLocalDate(),
                        coefficientses));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Arrays.toString(patients.toArray());
    }
}
