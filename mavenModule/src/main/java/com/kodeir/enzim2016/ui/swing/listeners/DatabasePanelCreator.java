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
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 18.09.2016.
 */
public class DatabasePanelCreator {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private Database database;
    private DatabasePanel databasePanel;
    private List<Patient> patients;

    public DatabasePanelCreator(){
        database = new Database();
        createDatabasePanel();
    }

    private void createDatabasePanel(){
        setPatients();
        initializePanel();
        fillPatientsListModel();
    }

    private void setPatients(){
        patients = getPatientsFromDb();
        //TODO: get sorted right
        Collections.sort(patients);
    }

    private void initializePanel(){
        databasePanel = new DatabasePanel(patients);
        databasePanel.setFrame(new EnzimFrame(rb.getString("interface.database"), databasePanel));
    }

    private void fillPatientsListModel(){
        for (Patient p: patients){
            databasePanel.setPatientsListModel(
                    p.getId() + ". " +
                    p.getSurname() + " " +
                    p.getName().substring(0,1) + "." +
                    p.getPatronymic().substring(0,1) + ". ; " +
                    rb.getString("interface.database.birthdate") + p.getBirthDate()
            );
        }
    }

    private List<Patient> getPatientsFromDb(){
        if (connectToDatabase()){
            database.setStatement();
            List<Patient> patients = new ArrayList<>();
            ResultSet rs = database.runSelectQuery("SELECT * FROM PATIENTS P JOIN COEFFICIENTS C ON P.patient_id = C.patient_id ORDER BY P.patient_id ASC");
            if (rs == null) {
                JOptionPane.showMessageDialog(null,"0");
            } else {
                try {
                    long check = -1;
                    int position = -1;

                    while (rs.next()) {

                        long patientId = rs.getLong("PATIENT_ID");
                        if (patientId == check){
                            patients.get(position).getCoefficients().add(setCoefficients(rs));
                        } else {
                            check = patientId;
                            Coefficients coefficients = setCoefficients(rs);
                            List<Coefficients> coefficientses = new ArrayList<>();
                            coefficientses.add(coefficients);
                            patients.add(new Patient(patientId,
                                    rs.getString("NAME"), rs.getString("SURNAME"), rs.getString("PATRONYMIC"),
                                    rs.getDate("BIRTHDATE").toLocalDate(),
                                    coefficientses));
                            position = patients.size() - 1;
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            return patients;
        }
        return new ArrayList<>();
    }

    private Coefficients setCoefficients(ResultSet rs) throws SQLException {
        return new Coefficients(rs.getLong("COEFFICIENT_ID"), rs.getLong("PATIENT_ID"),
                                        rs.getFloat("AST"), rs.getFloat("ALT"), rs.getFloat("KFK"), rs.getFloat("LDG"),
                                        rs.getFloat("SHF"), rs.getFloat("GGTP"), rs.getFloat("HE"), rs.getFloat("GLDG"),
                                        rs.getDate("CHECKUP_DATE").toLocalDate());
    }

    private boolean connectToDatabase(){
        return database.setConnectionIfDbExist(
                PropertyHandler.getInstance().getValue("datasource.url"),
                PropertyHandler.getInstance().getValue("datasource.username"),
                PropertyHandler.getInstance().getValue("datasource.password"));
    }

}
