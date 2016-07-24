package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.logic.Diagnosis;
import com.kodeir.enzim2016.logic.EnzimLogic;
import com.kodeir.enzim2016.patients.Patient;
import com.kodeir.enzim2016.ui.swing.panels.TreePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class DiagnosesTreeListener implements ActionListener {

    private TreePanel treePanel;

    public DiagnosesTreeListener (TreePanel treePanel){
        this.treePanel = treePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(treePanel.getDoDiagnoseBtn())) {
            doDiagnose();
        }
    }

    private void doDiagnose(){
        if (treePanel.setFloats()){
            float[] floats = treePanel.getFloats();
            Patient patient = new Patient("tree", "tree", floats[0], floats[1], floats[2], floats[3], floats[4], floats[5], floats[6], floats[7]);
            Diagnosis diagnosis = new EnzimLogic();
            diagnosis.diagnose(patient);
            treePanel.setInjuredOrgan(patient.getInjuredOrgan());
            treePanel.setDisease(patient.getDisease());
        } else {
            JOptionPane.showMessageDialog(null, treePanel.getMissedCoefficients());
            JOptionPane.showMessageDialog(null, treePanel.getWrongCoefficients());
        }

    }
}
