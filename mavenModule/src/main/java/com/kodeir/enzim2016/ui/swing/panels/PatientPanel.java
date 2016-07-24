/*
 * Copyright (c) 2007, 2016 Vyacheslav Ryabinin and/or his affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Vyacheslav Ryabinin or the names of his
 *     affiliates may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 *  THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimGridBagConstraints;
import com.kodeir.enzim2016.ui.swing.commons.EnzimDateField;
import com.kodeir.enzim2016.ui.swing.commons.EnzimLabel;
import com.kodeir.enzim2016.ui.swing.commons.EnzimTextField;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 24.07.2016.
 */
public class PatientPanel extends JPanel {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JLabel label;

    private JTextField patientNameField;
    private JTextField patientSurnameField;
    private JTextField patientPatronymicField;
    private JFormattedTextField patientBirthdateField;

    private JTextField astField;
    private JTextField altField;
    private JTextField kfkField;
    private JTextField ldgField;
    private JTextField shfField;
    private JTextField ggtpField;
    private JTextField heField;
    private JTextField gldgField;
    private JFormattedTextField checkupDateField;

    private JButton addCoefficientsBtn;
    private JButton addPatientBtn;
    private JButton returnBtn;

    public JButton getAddPatientBtn() {
        return addPatientBtn;
    }

    public JButton getAddCoefficientsBtn() {
        return addCoefficientsBtn;
    }

    public JButton getReturnBtn() {
        return returnBtn;
    }

    public PatientPanel() {
        this.setLayout(new GridBagLayout());
        addPatientComponents();
        addCoefficientsComponents();
        addButtons();
    }

    private void addPatientComponents(){
        label = new EnzimLabel("New patient");
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
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,5,2));

        label = new EnzimLabel(rb.getString("coefficients.ast"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,6,1));
        label = new EnzimLabel(rb.getString("coefficients.alt"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,6));
        label = new EnzimLabel(rb.getString("coefficients.kfk"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,6));
        label = new EnzimLabel(rb.getString("coefficients.ldg"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,3,6));

        astField = new EnzimTextField();
        this.add(astField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,7));
        altField = new EnzimTextField();
        this.add(altField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,7));
        kfkField = new EnzimTextField();
        this.add(kfkField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,7));
        ldgField = new EnzimTextField();
        this.add(ldgField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,3,7));

        label = new EnzimLabel(rb.getString("coefficients.shf"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,8));
        label = new EnzimLabel(rb.getString("coefficients.ggtp"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,8));
        label = new EnzimLabel(rb.getString("coefficients.he"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,8));
        label = new EnzimLabel(rb.getString("coefficients.gldg"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,3,8));

        shfField = new JTextField();
        this.add(shfField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,9));
        ggtpField = new JTextField();
        this.add(ggtpField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,1,9));
        heField = new JTextField();
        this.add(heField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,9));
        gldgField = new JTextField();
        this.add(gldgField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,3,9));

        label = new EnzimLabel("Checkup Date");
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,10,2));
        checkupDateField = new JFormattedTextField(new SimpleDateFormat("yyyy-mm-dd"));
        setupDateTextField(patientBirthdateField);
        this.add(checkupDateField, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,10,2));
    }

    private void addButtons(){
        addCoefficientsBtn = new JButton("Add new coefficients");
        this.add(addCoefficientsBtn, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,11,2));

        addPatientBtn = new JButton("Add patient to the database");
        this.add(addPatientBtn, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,12,2));

        returnBtn = new JButton("Return with no changes");
        this.add(returnBtn, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,2,12,2));
    }

    private void setupDateTextField(JFormattedTextField textField){
        try {
            MaskFormatter maskFormatter = new MaskFormatter("####-##-##");
            maskFormatter.install(textField);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
