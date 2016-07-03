package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.ui.swing.SwingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rowan on 03.07.2016.
 */
public class SwingAppListener implements ActionListener{

    private SwingApp swingApp;

    public SwingAppListener(SwingApp swingApp){
        this.swingApp = swingApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(swingApp.getNewPatientBtn())) {
            createNewPatientPanel();
        } else if (e.getSource().equals(swingApp.getOpenDatabaseBtn())) {
            createDatabasePanel();
        } else if (e.getSource().equals(swingApp.getShowTreeButton())) {
            createTreePanel();
        } else if (e.getSource().equals(swingApp.getExitBtn())) {
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
        JOptionPane.showMessageDialog(null, "under construction");
    }
}
