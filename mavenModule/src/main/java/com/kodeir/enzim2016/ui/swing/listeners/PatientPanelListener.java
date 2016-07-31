package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.Database;
import com.kodeir.enzim2016.commons.PatientsDatabase;
import com.kodeir.enzim2016.commons.PropertyHandler;
import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.pi.Patient;
import com.kodeir.enzim2016.ui.swing.panels.PatientPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class PatientPanelListener implements ActionListener {

    private Database database;

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

    private PatientPanel patientPanel;

    public PatientPanelListener(PatientPanel patientPanel){
        this.patientPanel = patientPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(patientPanel.getAddPatientBtn())){
            if (connectToDatabase()){
                System.out.println(database.setStatement());
                if (checkInput()){
                    JOptionPane.showMessageDialog(null, "All is OK!");
                    database.runExecuteUpdateQuery(PatientsDatabase.insertToPatiens(name, surname, patronymic, birthDate));
                    database.runExecuteUpdateQuery(PatientsDatabase.insertToCoefficients(checkupDate, ast, alt, kfk, ldg, shf, ggtp, he, gldg));
                    System.out.println(PatientsDatabase.selectAll(database));
                }
                database.closeConnection();
            }
        } else if (e.getSource().equals(patientPanel.getReturnBtn())){
            int choice = JOptionPane.showConfirmDialog(null,
                    "Your input will be lost. Do you want to quit?",
                    "Warning",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (choice==0){
                patientPanel.getFrame().dispose();
            }
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
        if (!checkName()){
            JOptionPane.showMessageDialog(null, "Name input is not correct!");
            check = false;
        }
        if (!checkSurname()){
            JOptionPane.showMessageDialog(null, "Surname input is not correct!");
            check = false;
        }
        if (!checkPatronymic()){
            JOptionPane.showMessageDialog(null, "Patronymic input is not correct!");
            check = false;
        }
        if (!checkBirthdate()){
            JOptionPane.showMessageDialog(null, "Birthdate input is not correct!");
            check = false;
        }
        if (!checkAst()){
            JOptionPane.showMessageDialog(null, "Ast input is not correct!");
            check = false;
        }
        if (!checkAlt()){
            JOptionPane.showMessageDialog(null, "Alt input is not correct!");
            check = false;
        }
        if (!checkKfk()){
            JOptionPane.showMessageDialog(null, "Kfk input is not correct!");
            check = false;
        }
        if (!checkLdg()){
            JOptionPane.showMessageDialog(null, "Ldg input is not correct!");
            check = false;
        }
        if (!checkShf()){
            JOptionPane.showMessageDialog(null, "Shf input is not correct!");
            check = false;
        }
        if (!checkGgtp()){
            JOptionPane.showMessageDialog(null, "GGTP input is not correct!");
            check = false;
        }
        if (!checkHe()){
            JOptionPane.showMessageDialog(null, "He input is not correct!");
            check = false;
        }
        if (!checkGldg()){
            JOptionPane.showMessageDialog(null, "Gldg input is not correct!");
            check = false;
        }
        if (!checkCheckupdate()){
            JOptionPane.showMessageDialog(null, "Checkup date input is not correct!");
            check = false;
        }
        return check;
    }

    private boolean checkName(){
        if (patientPanel.getPatientNameField().getText().equals("")){
            return false;
        } else {
            name = patientPanel.getPatientNameField().getText();
            return true;
        }
    }

    private boolean checkSurname(){
        if (patientPanel.getPatientSurnameField().getText().equals("")){
            return false;
        } else {
            surname = patientPanel.getPatientSurnameField().getText();
            return true;
        }
    }

    private boolean checkPatronymic(){
        if (patientPanel.getPatientPatronymicField().getText().equals("")){
            return false;
        } else {
            patronymic = patientPanel.getPatientPatronymicField().getText();
            return true;
        }
    }

    private boolean checkBirthdate(){
        if (checkDate(patientPanel.getPatientBirthdateField().getText())){
            birthDate = LocalDate.parse(patientPanel.getPatientBirthdateField().getText());
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
}
