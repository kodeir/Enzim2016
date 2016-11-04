package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.panels.AboutPanel;
import com.kodeir.enzim2016.ui.swing.panels.EnzimPanel;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.PatientPanel;
import com.kodeir.enzim2016.ui.swing.panels.TreePanel;
import sun.reflect.generics.tree.Tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class EnzimPanelListener implements ActionListener{

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private EnzimPanel enzimPanel;

    public EnzimPanelListener(EnzimPanel enzimPanel){
        this.enzimPanel = enzimPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(enzimPanel.getNewPatientBtn())) {
            createNewPatientPanel();
        } else if (e.getSource().equals(enzimPanel.getOpenDatabaseBtn())) {
            createDatabasePanel();
        } else if (e.getSource().equals(enzimPanel.getShowTreeBtn())) {
            createTreePanel();
        } else if (e.getSource().equals(enzimPanel.getAboutBtn())) {
            createAboutPanel();
        } else if (e.getSource().equals(enzimPanel.getExitBtn())) {
            System.exit(0);
        }
    }

    private void createNewPatientPanel(){
        PatientPanel patientPanel = new PatientPanel(false);
        patientPanel.setFrame(new EnzimFrame(rb.getString("interface.create.new_patient"), patientPanel));
    }

    private void createDatabasePanel(){
        new DatabasePanelCreator();
    }

    private void createTreePanel(){
        TreePanel treePanel = new TreePanel();
        treePanel.setFrame(new EnzimFrame(rb.getString("interface.tree.panel"), new TreePanel()));
    }

    private void createAboutPanel() {
        new EnzimFrame(rb.getString("interface.about"), new AboutPanel());
    }

}
