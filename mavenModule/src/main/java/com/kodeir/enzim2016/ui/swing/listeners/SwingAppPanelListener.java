package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.ui.swing.SwingApp;
import com.kodeir.enzim2016.ui.swing.SwingAppPanel;
import com.kodeir.enzim2016.ui.swing.tree.DiagnosesTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rowan on 03.07.2016.
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
        JOptionPane.showMessageDialog(null, "under construction");
    }

    private void createDatabasePanel(){
        JOptionPane.showMessageDialog(null, "under construction");
    }

    private void createTreePanel(){
        swingApp.clearFrame();
        SwingUtilities.invokeLater(() -> {
            DiagnosesTree tree = new DiagnosesTree();
            swingApp.setupFrame(tree, Frame.MAXIMIZED_BOTH);
        });

    }
}
