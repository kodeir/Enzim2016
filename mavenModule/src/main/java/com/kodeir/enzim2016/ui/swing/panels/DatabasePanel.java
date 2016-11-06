package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.data.HelpMapping;
import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.pi.Patient;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;
import com.kodeir.enzim2016.ui.swing.listeners.DatabasePanelListener;
import com.kodeir.enzim2016.ui.swing.listeners.KeyboardListener;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class DatabasePanel extends JPanel {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JLabel label;

    private int listClicker = 0;

    private JList<String> patientsList;
    private DefaultListModel patientsListModel;
    private JButton addNewPatientBtn;
    private List<Patient> patients;

    private PatientPIPanel patientPIPanel;
    private CoefficientsPanel coefficientsPanel;

    private JList<String> coefficientsList;
    private DefaultListModel coefficientsListModel;
    private List<Coefficients> coefficientses;

    private DiagnosePanel diagnosePanel;

    private JButton addNewCoefficientsBtn;

    private JFrame frame;

    private JButton showTreeBtn;
    private JButton exitBtn;

    public List<Coefficients> getCoefficientses() {
        return coefficientses;
    }

    public void setCoefficientses(List<Coefficients> coefficientses) {
        this.coefficientses = coefficientses;
    }

    public JButton getAddNewPatientBtn() {
        return addNewPatientBtn;
    }

    public JButton getAddNewCoefficientsBtn() {
        return addNewCoefficientsBtn;
    }

    public JList<String> getCoefficientsList() {
        return coefficientsList;
    }

    public DiagnosePanel getDiagnosePanel() {
        return diagnosePanel;
    }

    public JFrame getFrame(){
        return frame;
    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    public DefaultListModel getPatientsListModel() {
        return patientsListModel;
    }

    public JList<String> getPatientsList() {
        return patientsList;
    }

    public void setPatientsListModel(String s) {
        patientsListModel.addElement(s);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients){
        this.patients = patients;
    }

    public PatientPIPanel getPatientPIPanel() {
        return patientPIPanel;
    }

    public CoefficientsPanel getCoefficientsPanel() {
        return coefficientsPanel;
    }

    public DefaultListModel getCoefficientsListModel() {
        return coefficientsListModel;
    }

    public void setCoefficientsListModel(String s) {
        coefficientsListModel.addElement(s);
    }

    public JButton getShowTreeBtn(){
        return showTreeBtn;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public DatabasePanel(List<Patient> patients){
        this.setLayout(new GridBagLayout());
        addPatientsPanel();
        addPatientPIPanel();
        addCoefficientsPanel();
        addDiagnosePanel();
        addTreeButton();
        addExitButton();
        addListeners();
        this.patients = patients;
    }

    private void addPatientsPanel() {
        label = new JLabel(rb.getString("interface.database.patients_list"));
        label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize()+2));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,0));

        patientsListModel = new DefaultListModel();
        patientsList = new JList<>(patientsListModel);
        patientsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(patientsList);
        // (gridheight) 19 * 25 = 475, (ipady) 19 * 5 = 95; 570
        EnzimSwingCommons.setSize(scrollPane,300,570);
        this.add(scrollPane, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,1,1,19));

        addNewPatientBtn = new JButton(rb.getString("interface.patient.add"));
        this.add(addNewPatientBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,20));
    }

    private void addPatientPIPanel() {
        patientPIPanel = new PatientPIPanel(HelpMapping.HELP_DATABASE);
        this.add(patientPIPanel, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,0,4,5));
    }

    private void addCoefficientsPanel() {
        label = new JLabel(rb.getString("interface.database.coefficients_list"));
        label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize()+2));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,5,2));

        coefficientsListModel = new DefaultListModel();
        coefficientsList = new JList<>(coefficientsListModel);
        coefficientsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(coefficientsList);
        // (gridheight) 5 * 25 = 125
        EnzimSwingCommons.setSize(scrollPane,600,125);
        this.add(scrollPane, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,6,4,5));

        coefficientsPanel = new CoefficientsPanel(HelpMapping.HELP_DATABASE);
        this.add(coefficientsPanel, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,11,4,5));

        addNewCoefficientsBtn = new JButton(rb.getString("interface.database.add_coefficients"));
        addNewCoefficientsBtn.setEnabled(false);
        this.add(addNewCoefficientsBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,16,2));
    }

    private void addDiagnosePanel() {
        diagnosePanel = new DiagnosePanel();
        this.add(diagnosePanel, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,17,4,2));
    }

    private void addTreeButton() {
        showTreeBtn = new JButton(rb.getString("interface.database.tree"));
        showTreeBtn.setEnabled(false);
        this.add(showTreeBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,19,2));
    }

    private void addExitButton() {
        exitBtn = new JButton(rb.getString("interface.database.close"));
        this.add(exitBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,20,2));
    }

    private void addListeners(){
        patientsList.addListSelectionListener(new DatabasePanelListener(this));
        coefficientsList.addListSelectionListener(new DatabasePanelListener(this));
        showTreeBtn.addActionListener(new DatabasePanelListener(this, coefficientsPanel));
        exitBtn.addActionListener(new DatabasePanelListener(this));
        addNewPatientBtn.addActionListener(new DatabasePanelListener(this));
        addNewCoefficientsBtn.addActionListener(new DatabasePanelListener(this));
        for (Component c: this.getComponents()){
            c.addKeyListener(new KeyboardListener(HelpMapping.HELP_DATABASE, this));
        }
    }

}
