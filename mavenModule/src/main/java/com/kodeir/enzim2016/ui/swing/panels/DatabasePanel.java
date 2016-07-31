package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimGridBagConstraints;
import com.kodeir.enzim2016.ui.swing.listeners.DatabasePanelListener;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class DatabasePanel extends JPanel {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JLabel label;

    private JList<String> patientsList;
    private JButton addNewPatient;

    private JPanel patientPIPanel;

    private JTable coefficientsTable;
    private JLabel injuredOrgan;
    private JLabel disease;
    private JButton addNewCoefficients;

    private JFrame frame;

    private JButton exitBtn;

    public JFrame getFrame(){
        return frame;
    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public DatabasePanel(){
        this.setLayout(new GridBagLayout());
        addPatientsPanel();
        addPatientPIPanel();
        addCoefficientsPanel();
        addDiagnosePanel();
        addExitButton();
        addListeners();
    }

    private void addPatientsPanel() {
        patientsList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(patientsList);
        this.add(scrollPane, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,0,1,14));

        addNewPatient = new JButton(rb.getString("interface.patient.add"));
        this.add(addNewPatient, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,14,1));
    }

    private void addPatientPIPanel() {
        patientPIPanel = new PatientPIPanel();
        this.add(patientPIPanel, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,0,4,5));
    }

    private void addCoefficientsPanel() {
        coefficientsTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(coefficientsTable);
        this.add(scrollPane, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,5,4,5));

        addNewCoefficients = new JButton(rb.getString("interface.database.add_coefficients"));
        this.add(addNewCoefficients, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,10,4));
    }

    private void addDiagnosePanel() {

    }

    private void addExitButton() {
        exitBtn = new JButton(rb.getString("interface.database.close"));
        this.add(exitBtn, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,4,14,1));
    }

    private void addListeners(){
        exitBtn.addActionListener(new DatabasePanelListener(this));
    }

}
