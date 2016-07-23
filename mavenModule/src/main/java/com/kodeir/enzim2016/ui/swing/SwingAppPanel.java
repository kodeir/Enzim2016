package com.kodeir.enzim2016.ui.swing;

import com.kodeir.enzim2016.commons.UTF8Control;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class SwingAppPanel extends JPanel {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JLabel label;
    private JButton newPatientBtn;
    private JButton openDatabaseBtn;
    private JButton showTreeButton;
    private JButton exitBtn;

    public JButton getNewPatientBtn() {
        return newPatientBtn;
    }

    public JButton getOpenDatabaseBtn() {
        return openDatabaseBtn;
    }

    public JButton getShowTreeButton() {
        return showTreeButton;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public SwingAppPanel(){
        this.setLayout(new GridBagLayout());
        addNewPatient();
        addOpenDatabase();
        addShowTree();
        addExit();
    }

    public void addNewPatient(){
        newPatientBtn = new JButton("new P icon");
        this.add(newPatientBtn, SwingCommons.setConstraintsHorizontal(0.5, 0, 0));

        label = new JLabel(rb.getString("interface.create.new_patient"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5, 1, 0));
    }

    public void addOpenDatabase(){
        openDatabaseBtn = new JButton("new DB icon");
        this.add(openDatabaseBtn, SwingCommons.setConstraintsHorizontal(0.5, 0, 1));

        label = new JLabel(rb.getString("interface.open.database"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5, 1, 1));
    }

    public void addShowTree(){
        showTreeButton = new JButton("tree icon");
        this.add(showTreeButton, SwingCommons.setConstraintsHorizontal(0.5, 0, 2));

        label = new JLabel(rb.getString("interface.open.tree"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5, 1, 2));
    }

    public void addExit(){
        exitBtn = new JButton("exit icon");
        this.add(exitBtn, SwingCommons.setConstraintsHorizontal(0.5, 0, 3));

        label = new JLabel(rb.getString("interface.exit"));
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5, 1, 3));
    }
}
