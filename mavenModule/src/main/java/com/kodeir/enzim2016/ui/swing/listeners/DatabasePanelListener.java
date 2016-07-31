package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.pi.Patient;
import com.kodeir.enzim2016.ui.swing.panels.DatabasePanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class DatabasePanelListener implements ActionListener, ListSelectionListener {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    DatabasePanel databasePanel;

    public DatabasePanelListener(DatabasePanel databasePanel){
        this.databasePanel = databasePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(databasePanel.getExitBtn())) {
            exit();
        }
    }

    private void exit(){
        Object[] options = {"Yes",
                "No"};
        if (JOptionPane.showOptionDialog(null,
                "Close database?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        ) == JOptionPane.YES_OPTION){
            databasePanel.getFrame().dispose();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        String id = databasePanel.getPatientsListModel().get(databasePanel.getPatientsList().getSelectedIndex()).toString();
        int spaceIndex = id.indexOf(".");
        long patientId = Long.parseLong(id.substring(0,spaceIndex));

        List<Patient> patients = databasePanel.getPatients();
        for (Patient p : patients){
            if (p.getId() == patientId){
                databasePanel.getPatientPIPanel();
            }
        }
    }
}
