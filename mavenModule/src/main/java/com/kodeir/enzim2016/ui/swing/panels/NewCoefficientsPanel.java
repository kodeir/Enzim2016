package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;
import com.kodeir.enzim2016.ui.swing.listeners.KeyboardListener;
import com.kodeir.enzim2016.ui.swing.listeners.NewCoefficientsListener;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 25.09.2016.
 */
public class NewCoefficientsPanel extends JPanel{

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JFrame frame;

    private JButton addNewCoefficientsBtn;
    private JButton returnBtn;

    private DatabasePanel databasePanel;
    private long patientId;

    private CoefficientsPanel coefficientsPanel;

    public JButton getAddNewCoefficientsBtn() {
        return addNewCoefficientsBtn;
    }

    public JButton getReturnBtn() {
        return returnBtn;
    }

    public CoefficientsPanel getCoefficientsPanel(){
        return this.coefficientsPanel;
    }

    public JFrame getFrame(){
        return frame;
    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    public NewCoefficientsPanel(long patientId, DatabasePanel databasePanel) {
        this.setLayout(new GridBagLayout());
        this.patientId = patientId;
        this.databasePanel = databasePanel;
        addCoefficientsComponents();
        addButtons();
        addListeners();
    }

    private void addCoefficientsComponents() {
        coefficientsPanel = new CoefficientsPanel();
        this.add(coefficientsPanel, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,0,4,4));
    }

    private void addButtons() {
        addNewCoefficientsBtn = new JButton(rb.getString("interface.database.coefficients_add"));
        this.add(addNewCoefficientsBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,6,2));

        returnBtn = new JButton(rb.getString("interface.return"));
        this.add(returnBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,7,2));
    }

    private void addListeners() {
        addNewCoefficientsBtn.addActionListener(new NewCoefficientsListener(this, patientId, databasePanel));
        returnBtn.addActionListener(new NewCoefficientsListener(this, patientId));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyboardListener(this));
    }
}
