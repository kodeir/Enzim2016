package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.ui.swing.SwingApp;
import com.kodeir.enzim2016.ui.swing.SwingAppPanel;
import com.kodeir.enzim2016.ui.swing.patient.PatientPanel;
import com.kodeir.enzim2016.ui.swing.tree.DiagnosesTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class SwingAppPanelListener implements ActionListener{

    private SwingApp swingApp;
    private SwingAppPanel swingAppPanel;

    public SwingAppPanelListener(SwingApp swingApp, SwingAppPanel swingAppPanel){
        this.swingAppPanel = swingAppPanel;
        this.swingApp = swingApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(swingAppPanel.getNewPatientBtn())) {
            createNewPatientPanel();
        } else if (e.getSource().equals(swingAppPanel.getOpenDatabaseBtn())) {
            createDatabasePanel();
        } else if (e.getSource().equals(swingAppPanel.getShowTreeButton())) {
            createTreePanel();
        } else if (e.getSource().equals(swingAppPanel.getExitBtn())) {
            System.exit(0);
        }
    }

    private void createNewPatientPanel(){
        PatientPanel patientPanel = new PatientPanel();
        setupPanel(patientPanel);
    }

    private void createDatabasePanel(){
        JOptionPane.showMessageDialog(null, "under construction");
    }

    private void createTreePanel(){
        setupPanel(new DiagnosesTree());
    }

    private void setupPanel(JPanel panel){
        //swingApp.clearFrame();
        //SwingUtilities.invokeLater(() -> swingApp.setupFrame(panel, Frame.NORMAL));

        JFrame frame = new JFrame("");
        EventQueue.invokeLater(() -> {
            try {
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        SwingUtilities.invokeLater(() -> {
            swingAppPanel = new SwingAppPanel();
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(true);
            frame.setExtendedState(Frame.NORMAL);
            frame.setVisible(true);
        });
    }
}
