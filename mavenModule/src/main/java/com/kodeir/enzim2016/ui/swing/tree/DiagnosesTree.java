package com.kodeir.enzim2016.ui.swing.tree;

import com.kodeir.enzim2016.ui.swing.SwingCommons;
import com.kodeir.enzim2016.ui.swing.listeners.DiagnosesTreeListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Rowan on 03.07.2016.
 *
 */
public class DiagnosesTree extends JPanel {

    private JLabel label;

    private JTextField astField;
    private JTextField altField;
    private JTextField kfkField;
    private JTextField ldgField;
    private JTextField shfField;
    private JTextField ggtpField;
    private JTextField heField;
    private JTextField gldgField;

    private JButton doDiagnoseBtn;
    private JLabel injuredOrgan;
    private JLabel disease;

    private JTree tree;

    private float floatChecker;
    private float[] floats;
    private String missedCoefficients;
    private String wrongCoefficients;

    public JButton getDoDiagnoseBtn() {
        return doDiagnoseBtn;
    }

    public void setInjuredOrgan(String s) {
        injuredOrgan.setText(s);
    }

    public void setDisease(String s) {
        disease.setText(s);
    }

    public String getMissedCoefficients() {
        return missedCoefficients;
    }

    public String getWrongCoefficients() {
        return wrongCoefficients;
    }

    public DiagnosesTree(){
        this.setLayout(new GridBagLayout());
        addFields();
        addResultButton();
        addResults();
        addTree();
        addListeners();
    }

    private void addFields(){
        label = new JLabel("АСТ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,0));
        label = new JLabel("АЛТ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,1,0));
        label = new JLabel("КФК");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,2,0));
        label = new JLabel("ЛДГ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,3,0));

        astField = new JTextField();
        this.add(astField, SwingCommons.setConstraintsHorizontal(0.5,0,1));
        altField = new JTextField();
        this.add(altField, SwingCommons.setConstraintsHorizontal(0.5,1,1));
        kfkField = new JTextField();
        this.add(kfkField, SwingCommons.setConstraintsHorizontal(0.5,2,1));
        ldgField = new JTextField();
        this.add(ldgField, SwingCommons.setConstraintsHorizontal(0.5,3,1));

        label = new JLabel("ЩФ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,2));
        label = new JLabel("ГГТП");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,1,2));
        label = new JLabel("ХЭ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,2,2));
        label = new JLabel("ГЛДГ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,3,2));

        shfField = new JTextField();
        this.add(shfField, SwingCommons.setConstraintsHorizontal(0.5,0,3));
        ggtpField = new JTextField();
        this.add(ggtpField, SwingCommons.setConstraintsHorizontal(0.5,1,3));
        heField = new JTextField();
        this.add(heField, SwingCommons.setConstraintsHorizontal(0.5,2,3));
        gldgField = new JTextField();
        this.add(gldgField, SwingCommons.setConstraintsHorizontal(0.5,3,3));
    }

    private void addResultButton(){
        doDiagnoseBtn = new JButton("Диагностировать");
        this.add(doDiagnoseBtn, SwingCommons.setConstraintsHorizontal(0.5,1,4,2));
    }

    private void addResults(){
        label = new JLabel("Поверждённый орган:");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,5));
        injuredOrgan = new JLabel("");
        this.add(injuredOrgan, SwingCommons.setConstraintsHorizontal(0.5,1,5,3));

        label = new JLabel("Заболевание:");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,6));
        disease = new JLabel("");
        this.add(disease, SwingCommons.setConstraintsHorizontal(0.5,1,6,3));

    }

    private void addTree(){

    }

    public float[] getFloats(){
        return floats;
    }

    public boolean setFloats(){
        StringBuffer missed = new StringBuffer("Не введены следущюие коэффициенты: ");
        StringBuffer wrong = new StringBuffer("Для следующих коэффициентов введено неверное значение: ");

        floats = new float[8];
        float checker;

        if (!astField.getText().equals("")){
            if (parseFloatFromString(astField.getText())){
                floats[0] = floatChecker;
            } else {
                wrong.append(" АСТ");
            }
        } else {
            missed.append(" АСТ");
        }
        if (!altField.getText().equals("")){
            if (parseFloatFromString(altField.getText())){
                floats[1] = floatChecker;
            } else {
                wrong.append(" АЛТ");
            }
        } else {
            missed.append(" АЛТ");
        }
        if (!kfkField.getText().equals("")){
            if (parseFloatFromString(kfkField.getText())){
                floats[2] = floatChecker;
            } else {
                wrong.append(" КФК");
            }
        } else {
            missed.append(" КФК");
        }
        if (!ldgField.getText().equals("")){
            if (parseFloatFromString(ldgField.getText())){
                floats[3] = floatChecker;
            } else {
                wrong.append(" ЛДГ");
            }
        } else {
            missed.append(" ЛДГ");
        }
        if (!shfField.getText().equals("")){
            if (parseFloatFromString(shfField.getText())){
                floats[4] = floatChecker;
            } else {
                wrong.append(" ЩФ");
            }
        } else {
            missed.append(" ЩФ");
        }
        if (!ggtpField.getText().equals("")){
            if (parseFloatFromString(ggtpField.getText())){
                floats[5] = floatChecker;
            } else {
                wrong.append(" ГГТП");
            }
        } else {
            missed.append(" ГГТП");
        }
        if (!heField.getText().equals("")){
            if (parseFloatFromString(heField.getText())){
                floats[6] = floatChecker;
            } else {
                wrong.append(" ХЭ");
            }
        } else {
            missed.append(" ХЭ");
        }
        if (!gldgField.getText().equals("")){
            if (parseFloatFromString(gldgField.getText())){
                floats[7] = floatChecker;
            } else {
                wrong.append(" ГЛДГ");
            }
        } else {
            missed.append(" ГЛДГ");
        }

        missedCoefficients = missed.toString();
        wrongCoefficients = wrong.toString();

        if (!missedCoefficients.equals("Не введены следущюие коэффициенты: ") || !wrongCoefficients.equals("Для следующих коэффициентов введено неверное значение: ")){
            return false;
        } else {
            return true;
        }
    }

    public void addListeners(){
        doDiagnoseBtn.addActionListener(new DiagnosesTreeListener(this));
    }

    private boolean parseFloatFromString(String s){
        try {
            floatChecker = Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
