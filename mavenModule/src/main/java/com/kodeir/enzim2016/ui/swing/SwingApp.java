package com.kodeir.enzim2016.ui.swing;

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
    private ResourceBundle rb = ResourceBundle.getBundle("rb");

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
        frame = new JFrame(rb.getString("interface.name"));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents();
    }

    private void addComponents(){
        SwingUtilities.invokeLater(() -> {
            swingAppPanel = new SwingAppPanel();
            setupFrame(swingAppPanel, Frame.NORMAL);
        });
    }

    public void setupFrame(Component component, int maximized){
        frame.getContentPane().add(component);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setExtendedState(maximized);
        frame.setVisible(true);
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
