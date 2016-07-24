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
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sergei Riabinin on 23.07.2016.
 */
public class InitialDatabaseTest {

    private static ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private String initialDbName = "enzim2016";
    private String initialDbUser = "defaultUser";
    private String initialDbPwd = "default password";
    private String dbParams = ";CIPHER=AES";
    private Database database;

    private List<Patient> patients;


    @Test
    public void createInitialDatabaseTest(){
        assertEquals(rb.getString("interface.create.initial_database.created"), InitialDatabase.createInitialDatabase());
    }


    //@Test
    //public void createInitialDatabaseTest(){
    //    assertEquals(rb.getString("interface.create.initial_database.exists"), InitialDatabase.createInitialDatabase());
    //}

    @Test
    public void select(){
        database = new Database();
        database.setConnection(initialDbName + dbParams, initialDbUser, initialDbPwd);
        database.setStatement();
        ResultSet rs = database.runSelectQuery("SELECT * " +
                "FROM PATIENTS P " +
                "JOIN COEFFICIENTS C " +
                "ON P.patient_id = C.patient_id");
        patients = new ArrayList<>();

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

        System.out.println(Arrays.toString(patients.toArray()));
    }
}