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

    private PatientPIPanel patientPIPanel;

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

    public PatientPIPanel getPatientPIPanel() {
        return patientPIPanel;
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
        patientPIPanel = new PatientPIPanel();
        this.add(patientPIPanel, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,0,4,4));
    }

    private void addCoefficientsComponents(){
        label = new JLabel(rb.getString("coefficients"));
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

        label = new EnzimLabel(rb.getString("coefficients.checkup_date"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,10));
        checkupDateField = new EnzimDateField();
        this.add(checkupDateField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,10));
        label = new EnzimLabel(rb.getString("interface.date_format"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,10));

    }

    private void addButtons(){
        addPatientBtn = new JButton(rb.getString("interface.patient.add"));
        this.add(addPatientBtn, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,11,2));

        returnBtn = new JButton(rb.getString("interface.patient.quit.button"));
        this.add(returnBtn, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,12,2));
    }

    private void addListeners(){
        addPatientBtn.addActionListener(new PatientPanelListener(this));
        returnBtn.addActionListener(new PatientPanelListener(this));
    }
}
