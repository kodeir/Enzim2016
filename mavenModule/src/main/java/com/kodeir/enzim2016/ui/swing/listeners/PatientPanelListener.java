package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.EnzimDatabase;
import com.kodeir.enzim2016.commons.PatientsDatabase;
import com.kodeir.enzim2016.commons.PropertyHandler;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.panels.CoefficientsPanel;
import com.kodeir.enzim2016.ui.swing.panels.PatientPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class PatientPanelListener implements ActionListener {

    private EnzimDatabase database;
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;

    private StringBuilder errors;

    private PatientPanel patientPanel;
    private CoefficientsPanel coefficientsPanel;
    private CoefficientsHandler coefficientsHandler;

    private boolean createdFromDB;

    public PatientPanelListener(PatientPanel patientPanel, CoefficientsPanel coefficientsPanel, boolean createdFromDB){
        this.patientPanel = patientPanel;
        this.coefficientsPanel = coefficientsPanel;
        this.createdFromDB = createdFromDB;
        coefficientsHandler = new CoefficientsHandler(coefficientsPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(patientPanel.getAddPatientBtn())){
            addPatient();
        } else if (e.getSource().equals(patientPanel.getReturnBtn())){
            exit(false);
        }
    }

    private void addPatient(){
        if (connectToDatabase()){
            database.setStatement();

            if (checkInput()){
                database.runExecuteUpdateQuery(PatientsDatabase.insertToPatiens(name, surname, patronymic, birthDate));
                database.runExecuteUpdateQuery(PatientsDatabase.insertToCoefficients(coefficientsHandler.getCheckupDate(),
                        coefficientsHandler.getAst(),
                        coefficientsHandler.getAlt(),
                        coefficientsHandler.getKfk(),
                        coefficientsHandler.getLdg(),
                        coefficientsHandler.getShf(),
                        coefficientsHandler.getGgtp(),
                        coefficientsHandler.getHe(),
                        coefficientsHandler.getGldg()));
                if (createdFromDB) {
                    JOptionPane.showMessageDialog(null, rb.getString("interface.patient.added"));
                    exit(true);
                } else {
                    Object[] options = {rb.getString("interface.Yes"),
                            rb.getString("interface.No.add"),
                            rb.getString("interface.exit")};
                    int choice = JOptionPane.showOptionDialog(null,
                            rb.getString("interface.patient.added.goto"),
                            "",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[2]);
                    switch (choice){
                        case JOptionPane.YES_OPTION: new DatabasePanelCreator();
                            exit(true);
                        case JOptionPane.CANCEL_OPTION: exit(true);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,errors.toString());
            }
            database.closeConnection();
        }
    }

    private boolean connectToDatabase(){
        database = new EnzimDatabase();
        return database.setConnectionIfDbExist(
                PropertyHandler.getInstance().getValue("datasource.url"),
                PropertyHandler.getInstance().getValue("datasource.username"),
                PropertyHandler.getInstance().getValue("datasource.password"));
    }

    private boolean checkInput(){
        boolean check = true;
        errors = new StringBuilder();
        buildErrorString(rb.getString("errors.coefficients.missed"));
        if (!checkName()){
            buildErrorString(rb.getString("patient.name"));
            check = false;
        }
        if (!checkSurname()){
            buildErrorString(rb.getString("patient.surname"));
            check = false;
        }
        if (!checkPatronymic()){
            buildErrorString(rb.getString("patient.patronymic"));
            check = false;
        }
        if (!checkBirthdate()){
            buildErrorString(rb.getString("patient.birthdate"));
            check = false;
        }
        if (!coefficientsHandler.checkAst()){
            buildErrorString(rb.getString("coefficients.ast"));
            check = false;
        }
        if (!coefficientsHandler.checkAlt()){
            buildErrorString(rb.getString("coefficients.alt"));
            check = false;
        }
        if (!coefficientsHandler.checkKfk()){
            buildErrorString(rb.getString("coefficients.kfk"));
            check = false;
        }
        if (!coefficientsHandler.checkLdg()){
            buildErrorString(rb.getString("coefficients.ldg"));
            check = false;
        }
        if (!coefficientsHandler.checkShf()){
            buildErrorString(rb.getString("coefficients.shf"));
            check = false;
        }
        if (!coefficientsHandler.checkGgtp()){
            buildErrorString(rb.getString("coefficients.ggtp"));
            check = false;
        }
        if (!coefficientsHandler.checkHe()){
            buildErrorString(rb.getString("coefficients.he"));
            check = false;
        }
        if (!coefficientsHandler.checkGldg()){
            buildErrorString(rb.getString("coefficients.gldg"));
            check = false;
        }
        if (!coefficientsHandler.checkCheckupdate()){
            buildErrorString(rb.getString("coefficients.checkup_date"));
            check = false;
        }
        return check;
    }

    private void buildErrorString(String s){
        errors.append(s);
        errors.append(System.getProperty("line.separator"));
    }

    private boolean checkName(){
        if (patientPanel.getPatientPIPanel().getPatientNameField().getText().equals("")){
            return false;
        } else {
            name = patientPanel.getPatientPIPanel().getPatientNameField().getText();
            return true;
        }
    }

    private boolean checkSurname(){
        if (patientPanel.getPatientPIPanel().getPatientSurnameField().getText().equals("")){
            return false;
        } else {
            surname = patientPanel.getPatientPIPanel().getPatientSurnameField().getText();
            return true;
        }
    }

    private boolean checkPatronymic(){
        if (patientPanel.getPatientPIPanel().getPatientPatronymicField().getText().equals("")){
            return false;
        } else {
            patronymic = patientPanel.getPatientPIPanel().getPatientPatronymicField().getText();
            return true;
        }
    }

    private boolean checkBirthdate(){
        if (checkDate(patientPanel.getPatientPIPanel().getPatientBirthdateField().getText())){
            birthDate = LocalDate.parse(patientPanel.getPatientPIPanel().getPatientBirthdateField().getText());
            return true;
        } else {
            return false;
        }
    }

    private boolean checkDate(String text){
        if (text.equals("") || text.equals("    -  -  ")){
            return false;
        } else {
            return true;
        }
    }

    private void exit(boolean forceExit){
        if (forceExit){
            patientPanel.getFrame().dispose();
        } else {
            Object[] options = {rb.getString("interface.patient.quit.yes"),
                    rb.getString("interface.patient.quit.no")};
            if (JOptionPane.showOptionDialog(null,
                    rb.getString("interface.patient.quit.question"),
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            ) == JOptionPane.YES_OPTION) {
                patientPanel.getFrame().dispose();
            }
        }
    }
}
