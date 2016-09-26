package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimDateField;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;
import com.kodeir.enzim2016.ui.swing.commons.EnzimLabel;
import com.kodeir.enzim2016.ui.swing.commons.EnzimTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class PatientPIPanel extends JPanel{

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JLabel label;

    private JTextField patientNameField;
    private JTextField patientSurnameField;
    private JTextField patientPatronymicField;
    private JFormattedTextField patientBirthdateField;

    public JTextField getPatientNameField() {
        return patientNameField;
    }

    public void setPatientNameField(String s) {
        patientNameField.setText(s);
    }

    public JTextField getPatientSurnameField() {
        return patientSurnameField;
    }

    public void setPatientSurnameField(String s) {
        patientSurnameField.setText(s);
    }

    public JTextField getPatientPatronymicField() {
        return patientPatronymicField;
    }

    public void setPatientPatronymicField(String s) {
        patientPatronymicField.setText(s);
    }

    public JFormattedTextField getPatientBirthdateField() {
        return patientBirthdateField;
    }

    public void setPatientBirthdateField(String s) {
        patientBirthdateField.setText(s);
    }

    public PatientPIPanel(){
        this.setLayout(new GridBagLayout());
        addPatientPIComponents();
    }

    private void addPatientPIComponents(){
        label = new EnzimLabel(rb.getString("patient.new_patient"));
        label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize()+2));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,0,2));

        //Name
        label = new EnzimLabel(rb.getString("patient.name"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,1,1));
        patientNameField = new EnzimTextField(450,25);
        this.add(patientNameField, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,1,3));

        //Surname
        label = new EnzimLabel(rb.getString("patient.surname"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,2,1));
        patientSurnameField = new EnzimTextField(450,25);
        this.add(patientSurnameField, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,2,3));

        //Patronymic
        label = new EnzimLabel(rb.getString("patient.patronymic"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,3,1));
        patientPatronymicField = new EnzimTextField(450,25);
        this.add(patientPatronymicField, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,3,3));

        //Birthdate
        label = new EnzimLabel(rb.getString("patient.birthdate"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,4,1));
        patientBirthdateField = new EnzimDateField(150,25);
        this.add(patientBirthdateField, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,4));
        label = new EnzimLabel(rb.getString("interface.date_format"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,4));
    }

    public void setEditable(boolean editable){
        patientNameField.setEditable(editable);
        patientSurnameField.setEditable(editable);
        patientPatronymicField.setEditable(editable);
        patientBirthdateField.setEditable(editable);
    }
}
