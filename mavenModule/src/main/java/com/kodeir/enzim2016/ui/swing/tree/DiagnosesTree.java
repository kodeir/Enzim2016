package com.kodeir.enzim2016.ui.swing.tree;

import com.kodeir.enzim2016.ui.swing.SwingCommons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rowan on 03.07.2016.
 *
 */
public class DiagnosesTree extends Container {

    private GridBagConstraints constraints;

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
        constraints = new GridBagConstraints();
        addFields();
        addResultButton();
        addResults();
        addTree();
    }

    private void addFields(){

    }

    private void addResultButton(){
        getResult = new JButton("Диагностировать");
        SwingCommons.setConstraintsHorizontal(0.5,1,4,2);
    }

    private void addResults(){

    }

    private void addTree(){

    }

}
