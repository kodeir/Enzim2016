package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.Database;
import com.kodeir.enzim2016.commons.PatientsDatabase;
import com.kodeir.enzim2016.commons.PropertyHandler;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.pi.Patient;
import com.kodeir.enzim2016.ui.swing.SwingApp;
import com.kodeir.enzim2016.ui.swing.panels.DatabasePanel;
import com.kodeir.enzim2016.ui.swing.panels.EnzimPanel;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.PatientPanel;
import com.kodeir.enzim2016.ui.swing.panels.TreePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class EnzimPanelListener implements ActionListener{

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private Database database;

    private EnzimPanel enzimPanel;

    public EnzimPanelListener(EnzimPanel enzimPanel){
        this.enzimPanel = enzimPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(enzimPanel.getNewPatientBtn())) {
            createNewPatientPanel();
        } else if (e.getSource().equals(enzimPanel.getOpenDatabaseBtn())) {
            createDatabasePanel();
        } else if (e.getSource().equals(enzimPanel.getShowTreeButton())) {
            createTreePanel();
        } else if (e.getSource().equals(enzimPanel.getExitBtn())) {
            System.exit(0);
        }
    }

    private void createNewPatientPanel(){
        PatientPanel patientPanel = new PatientPanel();
        patientPanel.setFrame(EnzimFrame.setupPanel(rb.getString("interface.create.new_patient"), patientPanel));
    }

    private void createDatabasePanel(){
        new DatabasePanelCreator(database);
    }

    private void createTreePanel(){
        EnzimFrame.setupPanel(rb.getString("interface.tree.panel"), new TreePanel());
    }

}
