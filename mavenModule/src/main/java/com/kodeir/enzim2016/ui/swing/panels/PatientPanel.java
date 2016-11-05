package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.data.HelpMapping;
import com.kodeir.enzim2016.ui.swing.commons.*;
import com.kodeir.enzim2016.ui.swing.listeners.KeyboardListener;
import com.kodeir.enzim2016.ui.swing.listeners.PatientPanelListener;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 24.07.2016.
 */
public class PatientPanel extends JPanel {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JFrame frame;

    private PatientPIPanel patientPIPanel;
    private CoefficientsPanel coefficientsPanel;
    private DatabasePanel databasePanel;

    private JButton addPatientBtn;
    private JButton returnBtn;

    private boolean createdFromDB;

    public JButton getAddPatientBtn() {
        return addPatientBtn;
    }

    public JButton getReturnBtn() {
        return returnBtn;
    }

    public JFrame getFrame(){
        return frame;
    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    public PatientPIPanel getPatientPIPanel() {
        return patientPIPanel;
    }

    public PatientPanel(boolean createdFromDB) {
        this.setLayout(new GridBagLayout());
        this.createdFromDB = createdFromDB;
        addPatientComponents();
        addCoefficientsComponents();
        addButtons();
        addListeners();
    }

    public PatientPanel(boolean createdFromDB, DatabasePanel databasePanel) {
        this.setLayout(new GridBagLayout());
        this.createdFromDB = createdFromDB;
        this.databasePanel = databasePanel;
        addPatientComponents();
        addCoefficientsComponents();
        addButtons();
        addListeners();
    }

    private void addPatientComponents(){
        patientPIPanel = new PatientPIPanel(HelpMapping.HELP_PATIENT);
        this.add(patientPIPanel, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,0,4,4));
    }

    private void addCoefficientsComponents(){
        coefficientsPanel = new CoefficientsPanel();
        this.add(coefficientsPanel, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,5,4,4));
    }

    private void addButtons(){
        addPatientBtn = new JButton(rb.getString("interface.patient.add"));
        this.add(addPatientBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,11,2));

        returnBtn = new JButton(rb.getString("interface.patient.quit.button"));
        this.add(returnBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,12,2));
    }

    private void addListeners(){
        addPatientBtn.addActionListener(new PatientPanelListener(this, coefficientsPanel, createdFromDB, databasePanel));
        returnBtn.addActionListener(new PatientPanelListener(this, coefficientsPanel, createdFromDB));
        for (Component c: this.getComponents()){
            c.addKeyListener(new KeyboardListener(HelpMapping.HELP_PATIENT));
        }
    }
}
