package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.*;
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

    private JLabel label;

    private JTextField patientNameField;
    private JTextField patientSurnameField;
    private JTextField patientPatronymicField;
    private JFormattedTextField patientBirthdateField;

    private JFormattedTextField astField;
    private JFormattedTextField altField;
    private JFormattedTextField kfkField;
    private JFormattedTextField ldgField;
    private JFormattedTextField shfField;
    private JFormattedTextField ggtpField;
    private JFormattedTextField heField;
    private JFormattedTextField gldgField;
    private JFormattedTextField checkupDateField;

    private JButton addPatientBtn;
    private JButton returnBtn;

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

    public JTextField getPatientNameField() {
        return patientNameField;
    }

    public JTextField getPatientSurnameField() {
        return patientSurnameField;
    }

    public JTextField getPatientPatronymicField() {
        return patientPatronymicField;
    }

    public JFormattedTextField getPatientBirthdateField() {
        return patientBirthdateField;
    }

    public JFormattedTextField getAstField() {
        return astField;
    }

    public JFormattedTextField getAltField() {
        return altField;
    }

    public JFormattedTextField getKfkField() {
        return kfkField;
    }

    public JFormattedTextField getLdgField() {
        return ldgField;
    }

    public JFormattedTextField getShfField() {
        return shfField;
    }

    public JFormattedTextField getGgtpField() {
        return ggtpField;
    }

    public JFormattedTextField getHeField() {
        return heField;
    }

    public JFormattedTextField getGldgField() {
        return gldgField;
    }

    public JFormattedTextField getCheckupDateField() {
        return checkupDateField;
    }

    public PatientPanel() {
        this.setLayout(new GridBagLayout());
        addPatientComponents();
        addCoefficientsComponents();
        addButtons();
        addListeners();
    }

    private void addPatientComponents(){
        label = new EnzimLabel("New patient");
        label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize()+2));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,0,2));

        //Name
        label = new EnzimLabel("Name");
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,1,1));
        patientNameField = new EnzimTextField(300,25);
        this.add(patientNameField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,1,3));

        //Surname
        label = new EnzimLabel("Surname");
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,2,1));
        patientSurnameField = new EnzimTextField(300,25);
        this.add(patientSurnameField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,2,3));

        //Patronymic
        label = new EnzimLabel("Patronymic");
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,3,1));
        patientPatronymicField = new EnzimTextField(300,25);
        this.add(patientPatronymicField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,3,3));

        //Birthdate
        label = new EnzimLabel("Birthdate");
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,4,1));
        patientBirthdateField = new EnzimDateField();
        this.add(patientBirthdateField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,4));
        label = new EnzimLabel("(yyyy-mm-dd)");
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,4));
    }

    private void addCoefficientsComponents(){
        label = new JLabel("Coefficients");
        label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize()+2));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,5,2));

        label = new EnzimLabel(rb.getString("coefficients.ast"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,6,1));
        label = new EnzimLabel(rb.getString("coefficients.alt"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,6));
        label = new EnzimLabel(rb.getString("coefficients.kfk"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,6));
        label = new EnzimLabel(rb.getString("coefficients.ldg"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,3,6));

        astField = new EnzimFloatField();
        this.add(astField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,7));
        altField = new EnzimFloatField();
        this.add(altField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,7));
        kfkField = new EnzimFloatField();
        this.add(kfkField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,7));
        ldgField = new EnzimFloatField();
        this.add(ldgField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,3,7));

        label = new EnzimLabel(rb.getString("coefficients.shf"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,8));
        label = new EnzimLabel(rb.getString("coefficients.ggtp"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,8));
        label = new EnzimLabel(rb.getString("coefficients.he"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,8));
        label = new EnzimLabel(rb.getString("coefficients.gldg"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,3,8));

        shfField = new EnzimFloatField();
        this.add(shfField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,9));
        ggtpField = new EnzimFloatField();
        this.add(ggtpField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,9));
        heField = new EnzimFloatField();
        this.add(heField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,9));
        gldgField = new EnzimFloatField();
        this.add(gldgField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,3,9));

        label = new EnzimLabel("Checkup Date");
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,10));
        checkupDateField = new EnzimDateField();
        this.add(checkupDateField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,10));
        label = new EnzimLabel("(yyyy-mm-dd)");
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,10));

    }

    private void addButtons(){
        addPatientBtn = new JButton("Add patient to the database");
        this.add(addPatientBtn, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,11,2));

        returnBtn = new JButton("Return with no changes");
        this.add(returnBtn, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,12,2));
    }

    private void addListeners(){
        addPatientBtn.addActionListener(new PatientPanelListener(this));
        returnBtn.addActionListener(new PatientPanelListener(this));
    }
}
