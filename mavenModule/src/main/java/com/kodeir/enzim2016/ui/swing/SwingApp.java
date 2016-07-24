package com.kodeir.enzim2016.ui.swing;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.listeners.SwingAppPanelListener;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class SwingApp {

    private JFrame frame;
    private SwingAppPanel swingAppPanel;
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    public SwingApp(){
        initialize();
    }

    public static void startSwing() {
        EventQueue.invokeLater(() -> {
            try {
                new SwingApp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize(){
        swingAppPanel = new SwingAppPanel();
        frame = new EnzimFrame(rb.getString("interface.name"), swingAppPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addListeners();
    }

    public void clearFrame(){
        SwingUtilities.invokeLater(() -> frame.getContentPane().removeAll());
    }

    private void addListeners(){
        swingAppPanel.getNewPatientBtn().addActionListener(new SwingAppPanelListener(this, swingAppPanel));
        swingAppPanel.getOpenDatabaseBtn().addActionListener(new SwingAppPanelListener(this, swingAppPanel));
        swingAppPanel.getShowTreeButton().addActionListener(new SwingAppPanelListener(this, swingAppPanel));
        swingAppPanel.getExitBtn().addActionListener(new SwingAppPanelListener(this, swingAppPanel));
    }

}
