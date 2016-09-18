package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.Database;
import com.kodeir.enzim2016.commons.PatientsDatabase;
import com.kodeir.enzim2016.commons.PropertyHandler;
import com.kodeir.enzim2016.commons.UTF8Control;
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

    private Database database;
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private float ast;
    private float alt;
    private float kfk;
    private float ldg;
    private float shf;
    private float ggtp;
    private float he;
    private float gldg;
    private LocalDate checkupDate;

    private StringBuilder errors;

    private PatientPanel patientPanel;

    public PatientPanelListener(PatientPanel patientPanel){
        this.patientPanel = patientPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(patientPanel.getAddPatientBtn())){
            addPatient();
        } else if (e.getSource().equals(patientPanel.getReturnBtn())){
            exit();
        }
    }

    private void addPatient(){
        if (connectToDatabase()){
            database.setStatement();
            if (checkInput()){
                database.runExecuteUpdateQuery(PatientsDatabase.insertToPatiens(name, surname, patronymic, birthDate));
                database.runExecuteUpdateQuery(PatientsDatabase.insertToCoefficients(checkupDate, ast, alt, kfk, ldg, shf, ggtp, he, gldg));

                Object[] options = {rb.getString("interface.Yes"),
                        rb.getString("interface.No")};
                if (JOptionPane.showOptionDialog(null,
                        rb.getString("interface.patient.added"),
                        "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                ) == JOptionPane.YES_OPTION){
                    //open database
                }
            } else {
                JOptionPane.showMessageDialog(null,errors.toString());
            }
            database.closeConnection();
        }
    }

    private boolean connectToDatabase(){
        database = new Database();
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
        if (!checkAst()){
            buildErrorString(rb.getString("coefficients.ast"));
            check = false;
        }
        if (!checkAlt()){
            buildErrorString(rb.getString("coefficients.alt"));
            check = false;
        }
        if (!checkKfk()){
            buildErrorString(rb.getString("coefficients.kfk"));
            check = false;
        }
        if (!checkLdg()){
            buildErrorString(rb.getString("coefficients.ldg"));
            check = false;
        }
        if (!checkShf()){
            buildErrorString(rb.getString("coefficients.shf"));
            check = false;
        }
        if (!checkGgtp()){
            buildErrorString(rb.getString("coefficients.ggtp"));
            check = false;
        }
        if (!checkHe()){
            buildErrorString(rb.getString("coefficients.he"));
            check = false;
        }
        if (!checkGldg()){
            buildErrorString(rb.getString("coefficients.gldg"));
            check = false;
        }
        if (!checkCheckupdate()){
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

    private boolean checkAst(){
        if (patientPanel.getAstField().getText().equals("")){
            return false;
        } else {
            ast = ((Number) patientPanel.getAstField().getValue()).floatValue();
            return true;
        }
    }

    private boolean checkAlt(){
        if (patientPanel.getAltField().getText().equals("")){
            return false;
        } else {
            alt = ((Number) patientPanel.getAltField().getValue()).floatValue();
            return true;
        }
    }

    private boolean checkKfk(){
        if (patientPanel.getKfkField().getText().equals("")){
            return false;
        } else {
            kfk = ((Number) patientPanel.getKfkField().getValue()).floatValue();
            return true;
        }
    }

    private boolean checkLdg(){
        if (patientPanel.getLdgField().getText().equals("")){
            return false;
        } else {
            ldg = ((Number) patientPanel.getLdgField().getValue()).floatValue();
            return true;
        }
    }

    private boolean checkShf(){
        if (patientPanel.getShfField().getText().equals("")){
            return false;
        } else {
            shf = ((Number) patientPanel.getShfField().getValue()).floatValue();
            return true;
        }
    }

    private boolean checkGgtp(){
        if (patientPanel.getGgtpField().getText().equals("")){
            return false;
        } else {
            ggtp = ((Number) patientPanel.getGgtpField().getValue()).floatValue();
            return true;
        }
    }

    private boolean checkHe(){
        if (patientPanel.getHeField().getText().equals("")){
            return false;
        } else {
            he = ((Number) patientPanel.getHeField().getValue()).floatValue();
            return true;
        }
    }

    private boolean checkGldg(){
        if (patientPanel.getGldgField().getText().equals("")){
            return false;
        } else {
            gldg = ((Number) patientPanel.getGldgField().getValue()).floatValue();
            return true;
        }
    }

    private boolean checkCheckupdate(){
        if (checkDate(patientPanel.getCheckupDateField().getText())){
            checkupDate = LocalDate.parse(patientPanel.getCheckupDateField().getText());
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

    private void exit(){
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
        ) == JOptionPane.YES_OPTION){
            patientPanel.getFrame().dispose();
        }
    }
}
