package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.EnzimDatabase;
import com.kodeir.enzim2016.commons.PatientsDatabase;
import com.kodeir.enzim2016.commons.PropertyHandler;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.panels.NewCoefficientsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 25.09.2016.
 */
public class NewCoefficientsListener implements ActionListener {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private StringBuilder errors;

    private long patientId;

    private NewCoefficientsPanel newCoefficientsPanel;
    private CoefficientsHandler coefficientsHandler;
    private EnzimDatabase database;

    public NewCoefficientsListener(NewCoefficientsPanel newCoefficientsPanel, long patientId){
        this.newCoefficientsPanel = newCoefficientsPanel;
        this.patientId = patientId;
        coefficientsHandler = new CoefficientsHandler(newCoefficientsPanel.getCoefficientsPanel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newCoefficientsPanel.getAddNewCoefficientsBtn())) {
            if (addCoefficients()) {
                if (connectToDatabase()){
                    database.setStatement();
                    database.runExecuteUpdateQuery(PatientsDatabase.insertToCoefficientsManual(
                            coefficientsHandler.getCheckupDate(),
                            patientId,
                            coefficientsHandler.getAst(),
                            coefficientsHandler.getAlt(),
                            coefficientsHandler.getKfk(),
                            coefficientsHandler.getLdg(),
                            coefficientsHandler.getShf(),
                            coefficientsHandler.getGgtp(),
                            coefficientsHandler.getHe(),
                            coefficientsHandler.getGldg()
                    ));
                }
                JOptionPane.showMessageDialog(null,"true");
            } else {
                JOptionPane.showMessageDialog(null,errors.toString());
            }
        } else if (e.getSource().equals(newCoefficientsPanel.getReturnBtn())) {
            exit("Return?");
        }
    }

    private boolean addCoefficients() {
        boolean check = true;
        errors = new StringBuilder();
        buildErrorString(rb.getString("errors.coefficients.missed"));
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

    private void exit(String exitText){
        Object[] options = {rb.getString("interface.Yes"),
                rb.getString("interface.No")};
        if (JOptionPane.showOptionDialog(null,
                exitText,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        ) == JOptionPane.YES_OPTION){
            newCoefficientsPanel.getFrame().dispose();
        }
    }

    private boolean connectToDatabase(){
        database = new EnzimDatabase();
        return database.setConnectionIfDbExist(
                PropertyHandler.getInstance().getValue("datasource.url"),
                PropertyHandler.getInstance().getValue("datasource.username"),
                PropertyHandler.getInstance().getValue("datasource.password"));
    }

}
