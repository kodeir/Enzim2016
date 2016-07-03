package com.kodeir.enzim2016.ui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rowan on 03.07.2016.
 */
public class SwingApp {

    private JFrame frame;
    private GridBagConstraints constraints;
    private final int HORIZONTAL = GridBagConstraints.HORIZONTAL;

    private JButton newPatientBtn;
    private JButton openDatabaseBtn;

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

    public SwingApp(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame("Enzim 2016");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
    }

    private void addComponentsToPane(Container pane){
        pane.setLayout(new GridBagLayout());

        newPatientBtn = new JButton("Button 1");
        pane.add(newPatientBtn, setConstraints(0.5, HORIZONTAL, 0, 0));

        openDatabaseBtn = new JButton("Button 1");
        pane.add(openDatabaseBtn, setConstraints(0.5, HORIZONTAL, 1, 0));

    }

    private GridBagConstraints setConstraints(double weightx, int fill, int gridx, int gridy){
        constraints.weightx = weightx;
        constraints.fill = fill;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        return constraints;
    }


}
