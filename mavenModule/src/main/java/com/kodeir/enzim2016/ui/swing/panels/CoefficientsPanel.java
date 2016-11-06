package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimDateField;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFloatField;
import com.kodeir.enzim2016.ui.swing.commons.EnzimLabel;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;
import com.kodeir.enzim2016.ui.swing.listeners.KeyboardListener;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class CoefficientsPanel extends JPanel{

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JLabel label;

    private JFormattedTextField astField;
    private JFormattedTextField altField;
    private JFormattedTextField kfkField;
    private JFormattedTextField ldgField;
    private JFormattedTextField shfField;
    private JFormattedTextField ggtpField;
    private JFormattedTextField heField;
    private JFormattedTextField gldgField;
    private JFormattedTextField checkupDateField;


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

    public CoefficientsPanel(int helpMap){
        this.setLayout(new GridBagLayout());
        addComponents();
        addListeners(helpMap);
    }

    private void addComponents() {
        label = new JLabel(rb.getString("coefficients"));
        label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize()+2));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,0,2));

        label = new EnzimLabel(rb.getString("coefficients.ast"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,1,1));
        label = new EnzimLabel(rb.getString("coefficients.alt"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,1));
        label = new EnzimLabel(rb.getString("coefficients.kfk"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,1));
        label = new EnzimLabel(rb.getString("coefficients.ldg"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,1));

        astField = new EnzimFloatField();
        this.add(astField, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,2));
        altField = new EnzimFloatField();
        this.add(altField, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,2));
        kfkField = new EnzimFloatField();
        this.add(kfkField, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,2));
        ldgField = new EnzimFloatField();
        this.add(ldgField, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,2));

        label = new EnzimLabel(rb.getString("coefficients.shf"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,3));
        label = new EnzimLabel(rb.getString("coefficients.ggtp"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,3));
        label = new EnzimLabel(rb.getString("coefficients.he"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,3));
        label = new EnzimLabel(rb.getString("coefficients.gldg"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,3));

        shfField = new EnzimFloatField();
        this.add(shfField, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,4));
        ggtpField = new EnzimFloatField();
        this.add(ggtpField, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,4));
        heField = new EnzimFloatField();
        this.add(heField, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,4));
        gldgField = new EnzimFloatField();
        this.add(gldgField, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,4));

        label = new EnzimLabel(rb.getString("coefficients.checkup_date"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,5));
        checkupDateField = new EnzimDateField();
        this.add(checkupDateField, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,5));
        label = new EnzimLabel(rb.getString("interface.date_format"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,5));
    }

    public void setValues(float ast, float alt, float kfk, float ldg,
                     float shf, float ggtp, float he, float gldg,
                     LocalDate checkupDate){
        astField.setText(String.valueOf(ast));
        altField.setText(String.valueOf(alt));
        kfkField.setText(String.valueOf(kfk));
        ldgField.setText(String.valueOf(ldg));
        shfField.setText(String.valueOf(shf));
        ggtpField.setText(String.valueOf(ggtp));
        heField.setText(String.valueOf(he));
        gldgField.setText(String.valueOf(gldg));
        checkupDateField.setText(String.valueOf(checkupDate));
    }

    public void addListeners(int helpMap){
        for (Component c: this.getComponents()){
            c.addKeyListener(new KeyboardListener(helpMap, this));
        }
    }
}
