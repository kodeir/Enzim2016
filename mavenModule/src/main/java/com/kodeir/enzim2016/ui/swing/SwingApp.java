package com.kodeir.enzim2016.ui.swing;

import com.kodeir.enzim2016.ui.swing.listeners.SwingAppListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rowan on 03.07.2016.
 */
public class SwingApp {

    private JFrame frame;
    private GridBagConstraints constraints;
    private final int HORIZONTAL = GridBagConstraints.HORIZONTAL;

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

    public SwingApp(){
        initialize();
    }

    public static void startSwing() {
        EventQueue.invokeLater(() -> {
            try {
                SwingApp swingApp = new SwingApp();
                swingApp.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize(){
        frame = new JFrame("Enzim 2016");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
    }

    private void addComponentsToPane(Container pane){
        SwingUtilities.invokeLater(() -> {
            pane.setLayout(new GridBagLayout());
            constraints = new GridBagConstraints();

            newPatientBtn = new JButton("new P icon");
            pane.add(newPatientBtn, setConstraintsHorizontal(0.5, 0, 0));

            label = new JLabel("создать нового пациента");
            pane.add(label, setConstraintsHorizontal(0.5, 1, 0));

            openDatabaseBtn = new JButton("new DB icon");
            pane.add(openDatabaseBtn, setConstraintsHorizontal(0.5, 0, 1));

            label = new JLabel("открыть базу данных");
            pane.add(label, setConstraintsHorizontal(0.5, 1, 1));

            showTreeButton = new JButton("tree icon");
            pane.add(showTreeButton, setConstraintsHorizontal(0.5, 0, 2));

            label = new JLabel("посмотреть дерево диагнозов");
            pane.add(label, setConstraintsHorizontal(0.5, 1, 2));

            exitBtn = new JButton("exit icon");
            pane.add(exitBtn, setConstraintsHorizontal(0.5, 0, 3));

            label = new JLabel("выход");
            pane.add(label, setConstraintsHorizontal(0.5, 1, 3));

            setupFrame(pane);
        });
    }

    public void setupFrame(Container pane){
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        addListeners();
    }

    private void addListeners(){
        getNewPatientBtn().addActionListener(new SwingAppListener(this));
        getOpenDatabaseBtn().addActionListener(new SwingAppListener(this));
        getShowTreeButton().addActionListener(new SwingAppListener(this));
        getExitBtn().addActionListener(new SwingAppListener(this));
    }

    public void clearFrame(){
        SwingUtilities.invokeLater(() -> {
            frame.getContentPane().removeAll();
        });
    }

    private GridBagConstraints setConstraintsHorizontal(double weightx, int gridx, int gridy){
        constraints.weightx = weightx;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        return constraints;
    }


}
