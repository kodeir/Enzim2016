package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.ui.swing.SwingApp;
import com.kodeir.enzim2016.ui.swing.panels.EnzimPanel;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.PatientPanel;
import com.kodeir.enzim2016.ui.swing.panels.TreePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class EnzimPanelListener implements ActionListener{

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
        setupPanel("New patient", patientPanel);
    }

    private void createDatabasePanel(){
        JOptionPane.showMessageDialog(null, "under construction");
    }

    private void createTreePanel(){
        setupPanel("Diagnoses Tree", new TreePanel());
    }

    private void setupPanel(String frameName, JPanel panel){
        new EnzimFrame(frameName, panel);
    }
}
