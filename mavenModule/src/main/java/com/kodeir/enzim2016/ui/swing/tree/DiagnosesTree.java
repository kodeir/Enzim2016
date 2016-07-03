package com.kodeir.enzim2016.ui.swing.tree;

import com.kodeir.enzim2016.ui.swing.SwingCommons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rowan on 03.07.2016.
 *
 */
public class DiagnosesTree extends Container {

    private JLabel label;

    private JTextField astField;
    private JTextField altField;
    private JTextField kfkField;
    private JTextField ldgField;
    private JTextField shfField;
    private JTextField ggtpField;
    private JTextField heField;
    private JTextField gldgField;

    private JButton getResult;
    private JLabel injuredOrgan;
    private JLabel disease;

    private JTree tree;

    public DiagnosesTree(){
        this.setLayout(new GridBagLayout());
        addFields();
        addResultButton();
        addResults();
        addTree();
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
    }

    private void addResultButton(){
        getResult = new JButton("Диагностировать");
        this.add(getResult, SwingCommons.setConstraintsHorizontal(0.5,1,4,2));
    }

    private void addResults(){

    }

    private void addTree(){

    }

}
