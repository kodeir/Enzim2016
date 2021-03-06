package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.EnzimDatabase;
import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.PropertyHandler;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.pi.Patient;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.DatabasePanel;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;

/**
 * Created by Sergei Riabinin on 18.09.2016.
 */
public class DatabasePanelCreator {

    private static final EnzimLogger logger = new EnzimLogger(DatabasePanelCreator.class.getName());

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private EnzimDatabase database;
    private DatabasePanel databasePanel;
    private List<Patient> patients;

    private String sqlQuery = "SELECT * FROM PATIENTS P JOIN COEFFICIENTS C ON P.patient_id = C.patient_id ORDER BY P.patient_id ASC";

    /**
     * Default constructor is used for creating Database Panel with the panel itself
     */
    public DatabasePanelCreator(){
        //logger.log(Level.INFO, "DatabasePanelCreator default constructor");
        database = new EnzimDatabase();
        createDatabasePanel();
    }

    /**
     * Used for updating current Database Panel
     * @param databasePanel DatabasePanel
     */
    public DatabasePanelCreator(DatabasePanel databasePanel){
        //logger.log(Level.INFO, "DatabasePanelCreator Update constructor");
        this.databasePanel = databasePanel;
        database = new EnzimDatabase();
        updateDatabasePanel();
    }

    private void createDatabasePanel(){
        setPatients();
        initializeDatabasePanel();
        fillPatientsListModel();
    }

    private void updateDatabasePanel(){
        //int selectedIndex is used to remember current patient (where cursor is)
        int selectedIndex = databasePanel.getPatientsList().getSelectedIndex();
        setPatients();
        cleanDatabasePanelLists();
        fillPatientsListModel();
        //after data and panel are refreshed, back cursor to previously selected patient
        databasePanel.getPatientsList().setSelectedIndex(selectedIndex);
    }

    private void setPatients(){
        patients = getPatientsFromDb();
        Collections.sort(patients);
    }

    private List<Patient> getPatientsFromDb(){
        if (connectToDatabase()){
            database.setStatement();
            List<Patient> patients = new ArrayList<>();
            ResultSet rs = database.runSelectQuery(sqlQuery);
            if (rs == null) {
                JOptionPane.showMessageDialog(null, rb.getString("interface.database.result_error"));
            } else {
                try {
                    long check = -1;
                    int position = -1;
                    while (rs.next()) {
                        // get current patient id
                        long patientId = rs.getLong(rb.getString("database.patient.id"));
                        /*
                        check if patient id was already used
                        (based on 'ORDER BY P.patient_id ASC')
                        if it was used, just add a new set of coefficients
                         */
                        if (patientId == check){
                            patients.get(position).getCoefficients().add(setCoefficients(rs));
                        } else {
                            check = patientId;
                            patients.add(setPatient(rs, patientId, new ArrayList<>(Collections.singletonList(setCoefficients(rs)))));
                            position = patients.size() - 1;
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, rb.getString("interface.database.result_error"));
                }
            }
            return patients;
        }
        return new ArrayList<>();
    }

    private void initializeDatabasePanel(){
        databasePanel = new DatabasePanel(patients);
        databasePanel.setFrame(new EnzimFrame(rb.getString("interface.database"), databasePanel, 2));
    }

    private void cleanDatabasePanelLists() {
        databasePanel.getPatientsListModel().removeAllElements();
        databasePanel.getCoefficientsListModel().removeAllElements();
        //logger.log(Level.INFO, "List Model were cleaned");
        databasePanel.setPatients(patients);
        //logger.log(Level.INFO, "Patiens List was reloaded");
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

    private Coefficients setCoefficients(ResultSet rs) throws SQLException {
        return new Coefficients(
                rs.getLong(rb.getString("database.coefficients.id")),
                rs.getLong(rb.getString("database.patient.id")),
                rs.getFloat(rb.getString("database.coefficients.ast")),
                rs.getFloat(rb.getString("database.coefficients.alt")),
                rs.getFloat(rb.getString("database.coefficients.kfk")),
                rs.getFloat(rb.getString("database.coefficients.ldg")),
                rs.getFloat(rb.getString("database.coefficients.shf")),
                rs.getFloat(rb.getString("database.coefficients.ggtp")),
                rs.getFloat(rb.getString("database.coefficients.he")),
                rs.getFloat(rb.getString("database.coefficients.gldg")),
                rs.getDate(rb.getString("database.checkup.date")).toLocalDate());
    }

    private Patient setPatient(ResultSet rs, long patientId, List<Coefficients> coefficientsList) throws SQLException {
        return new Patient(
                patientId,
                rs.getString(rb.getString("database.patient.name")),
                rs.getString(rb.getString("database.patient.surname")),
                rs.getString(rb.getString("database.patient.patronymic")),
                rs.getDate(rb.getString("database.patient.birthdate")).toLocalDate(),
                coefficientsList);
    }

    private boolean connectToDatabase(){
        return database.setConnectionIfDbExist(
                PropertyHandler.getInstance().getValue("datasource.url"),
                PropertyHandler.getInstance().getValue("datasource.username"),
                PropertyHandler.getInstance().getValue("datasource.password"));
    }

}
