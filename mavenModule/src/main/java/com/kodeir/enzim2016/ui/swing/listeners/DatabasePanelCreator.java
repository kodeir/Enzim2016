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

package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.Database;
import com.kodeir.enzim2016.commons.PropertyHandler;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.pi.Patient;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.DatabasePanel;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 18.09.2016.
 */
public class DatabasePanelCreator {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    Database database;

    public DatabasePanelCreator(Database database){
        this.database = database;
        createDatabasePanel();
    }

    private void createDatabasePanel(){
        List<Patient> patients = getPatients();
        DatabasePanel databasePanel = new DatabasePanel(patients);
        databasePanel.setFrame(EnzimFrame.setupPanel(rb.getString("interface.database"), databasePanel));
        for (Patient p: patients){
            databasePanel.setPatientsListModel(p.getId() + ". " +
                    p.getSurname() + " " +
                    p.getName().substring(0,1) + "." +
                    p.getPatronymic().substring(0,1) + ". ; " +
                    rb.getString("interface.database.birthdate") + p.getBirthDate());
        }
    }

    private List<Patient> getPatients(){
        if (connectToDatabase()){
            database.setStatement();
            //return PatientsDatabase.selectAll(database);
            List<Patient> patients = new ArrayList<>();
            JOptionPane.showMessageDialog(null,"array");
            ResultSet rs = database.runSelectQuery("SELECT * " +
                    "FROM PATIENTS P " +
                    "JOIN COEFFICIENTS C " +
                    "ON P.patient_id = C.patient_id");
            JOptionPane.showMessageDialog(null,"before try");
            if (rs == null) {
                JOptionPane.showMessageDialog(null,"0");
            }
            try {
                while (rs.next()){
                    Coefficients coefficients = new Coefficients(rs.getLong("COEFFICIENT_ID"),rs.getLong("PATIENT_ID"),
                            rs.getFloat("AST"),rs.getFloat("ALT"),rs.getFloat("KFK"),rs.getFloat("LDG"),
                            rs.getFloat("SHF"),rs.getFloat("GGTP"),rs.getFloat("HE"),rs.getFloat("GLDG"),
                            rs.getDate("CHECKUP_DATE").toLocalDate());
                    List<Coefficients> coefficientses = new ArrayList<>();
                    coefficientses.add(coefficients);
                    patients.add(new Patient(rs.getLong("PATIENT_ID"),
                            rs.getString("NAME"),rs.getString("SURNAME"),rs.getString("PATRONYMIC"),
                            rs.getDate("BIRTHDATE").toLocalDate(),
                            coefficientses));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            return patients;
        }
        return new ArrayList<>();
    }

    private boolean connectToDatabase(){
        JOptionPane.showMessageDialog(null,"before db");
        database = new Database();
        JOptionPane.showMessageDialog(null,"db");
        return database.setConnectionIfDbExist(
                PropertyHandler.getInstance().getValue("datasource.url"),
                PropertyHandler.getInstance().getValue("datasource.username"),
                PropertyHandler.getInstance().getValue("datasource.password"));
    }

}
