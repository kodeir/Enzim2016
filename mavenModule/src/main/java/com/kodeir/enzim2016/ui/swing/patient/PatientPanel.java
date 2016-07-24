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

package com.kodeir.enzim2016.ui.swing.patient;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.patients.Patient;
import com.kodeir.enzim2016.ui.swing.SwingCommons;

import javax.swing.*;
import java.awt.*;
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
    private JTextField patientBirthdateField;

    private JTextField astField;
    private JTextField altField;
    private JTextField kfkField;
    private JTextField ldgField;
    private JTextField shfField;
    private JTextField ggtpField;
    private JTextField heField;
    private JTextField gldgField;
    private JTextField checkupDateField;

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
        label = new JLabel("New patient");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,1,0,2));

        label = new JLabel("Name");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,1,1));
        patientNameField = new JTextField();
        this.add(patientNameField, SwingCommons.setConstraintsHorizontal(0.5,1,1,3));

        label = new JLabel("Surname");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,2,1));
        patientSurnameField = new JTextField();
        this.add(patientSurnameField, SwingCommons.setConstraintsHorizontal(0.5,1,2,3));

        label = new JLabel("Patronymic");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,3,1));
        patientPatronymicField = new JTextField();
        this.add(patientPatronymicField, SwingCommons.setConstraintsHorizontal(0.5,1,3,3));

        label = new JLabel("Bithdate");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,4,1));
        patientBirthdateField = new JTextField();
        this.add(patientBirthdateField, SwingCommons.setConstraintsHorizontal(0.5,1,4));
    }

    private void addCoefficientsComponents(){
        label = new JLabel("Coefficients");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,1,5,2));

        label = new JLabel(rb.getString("coefficients.ast"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,6,1));
        label = new JLabel(rb.getString("coefficients.alt"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,1,6));
        label = new JLabel(rb.getString("coefficients.kfk"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,2,6));
        label = new JLabel(rb.getString("coefficients.ldg"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,3,6));

        astField = new JTextField();
        this.add(astField, SwingCommons.setConstraintsHorizontal(0.5,0,7));
        altField = new JTextField();
        this.add(altField, SwingCommons.setConstraintsHorizontal(0.5,1,7));
        kfkField = new JTextField();
        this.add(kfkField, SwingCommons.setConstraintsHorizontal(0.5,2,7));
        ldgField = new JTextField();
        this.add(ldgField, SwingCommons.setConstraintsHorizontal(0.5,3,7));

        label = new JLabel(rb.getString("coefficients.shf"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,8));
        label = new JLabel(rb.getString("coefficients.ggtp"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,1,8));
        label = new JLabel(rb.getString("coefficients.he"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,2,8));
        label = new JLabel(rb.getString("coefficients.gldg"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,3,8));

        shfField = new JTextField();
        this.add(shfField, SwingCommons.setConstraintsHorizontal(0.5,0,9));
        ggtpField = new JTextField();
        this.add(ggtpField, SwingCommons.setConstraintsHorizontal(0.5,1,9));
        heField = new JTextField();
        this.add(heField, SwingCommons.setConstraintsHorizontal(0.5,2,9));
        gldgField = new JTextField();
        this.add(gldgField, SwingCommons.setConstraintsHorizontal(0.5,3,9));

        label = new JLabel("Checkup Date");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,10,2));
        checkupDateField = new JTextField();
        this.add(checkupDateField, SwingCommons.setConstraintsHorizontal(0.5,2,10,2));
    }

    private void addButtons(){
        addCoefficientsBtn = new JButton("Add new coefficients");
        this.add(addCoefficientsBtn, SwingCommons.setConstraintsHorizontal(0.5,2,11,2));

        addPatientBtn = new JButton("Add patient to the database");
        this.add(addPatientBtn, SwingCommons.setConstraintsHorizontal(0.5,0,12,2));

        returnBtn = new JButton("Return with no changes");
        this.add(returnBtn, SwingCommons.setConstraintsHorizontal(0.5,2,12,2));
    }
}
