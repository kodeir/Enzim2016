package com.kodeir.enzim2016.ui.swing;

import com.kodeir.enzim2016.ui.swing.listeners.SwingAppPanelListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rowan on 03.07.2016.
 */
public class SwingAppPanel extends JPanel {

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
        this.addNewPatient();
        this.addOpenDatabase();
        this.addShowTree();
        this.addExit();
    }

    public void addNewPatient(){
        newPatientBtn = new JButton("new P icon");
        this.add(newPatientBtn, SwingCommons.setConstraintsHorizontal(0.5, 0, 0));

        label = new JLabel("создать нового пациента");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5, 1, 0));
    }

    public void addOpenDatabase(){
        openDatabaseBtn = new JButton("new DB icon");
        this.add(openDatabaseBtn, SwingCommons.setConstraintsHorizontal(0.5, 0, 1));

        label = new JLabel("открыть базу данных");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5, 1, 1));
    }

    public void addShowTree(){
        showTreeButton = new JButton("tree icon");
        this.add(showTreeButton, SwingCommons.setConstraintsHorizontal(0.5, 0, 2));

        label = new JLabel("посмотреть дерево диагнозов");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5, 1, 2));
    }

    public void addExit(){
        exitBtn = new JButton("exit icon");
        this.add(exitBtn, SwingCommons.setConstraintsHorizontal(0.5, 0, 3));

        label = new JLabel("выход");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5, 1, 3));
    }


}
