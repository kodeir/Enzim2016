package com.kodeir.enzim2016.ui.swing;

import com.kodeir.enzim2016.ui.swing.listeners.SwingAppPanelListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rowan on 03.07.2016.
 */
public class SwingApp {

    private JFrame frame;
    private SwingAppPanel swingAppPanel;

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
        addComponents();
    }

    private void addComponents(){
        SwingUtilities.invokeLater(() -> {
            swingAppPanel = new SwingAppPanel();
            setupFrame(swingAppPanel);
        });
    }

    public void setupFrame(Component component){
        frame.getContentPane().add(component);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        addListeners();
    }

    public void clearFrame(){
        SwingUtilities.invokeLater(() -> {
            frame.getContentPane().removeAll();
        });
    }

    private void addListeners(){
        swingAppPanel.getNewPatientBtn().addActionListener(new SwingAppPanelListener(this, swingAppPanel));
        swingAppPanel.getOpenDatabaseBtn().addActionListener(new SwingAppPanelListener(this, swingAppPanel));
        swingAppPanel.getShowTreeButton().addActionListener(new SwingAppPanelListener(this, swingAppPanel));
        swingAppPanel.getExitBtn().addActionListener(new SwingAppPanelListener(this, swingAppPanel));
    }

}
