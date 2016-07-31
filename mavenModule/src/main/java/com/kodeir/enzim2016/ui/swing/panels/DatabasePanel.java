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

    private JTextField name;
    private JTextField surname;
    private JTextField patronymic;
    private JFormattedTextField birthdate;

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
    }

    private void addPatientPIPanel() {
    }

    private void addCoefficientsPanel() {

    }

    private void addDiagnosePanel() {

    }

    private void addExitButton() {
        exitBtn = new JButton(rb.getString("interface.database.close"));
        this.add(exitBtn, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,15,1));
    }

    private void addListeners(){
        exitBtn.addActionListener(new DatabasePanelListener(this));
    }

}
