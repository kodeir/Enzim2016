package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.logic.Diagnosis;
import com.kodeir.enzim2016.logic.EnzimLogic;
import com.kodeir.enzim2016.patients.Patient;
import com.kodeir.enzim2016.ui.swing.tree.DiagnosesTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rowan on 03.07.2016.
 */
public class DiagnosesTreeListener implements ActionListener {

    private DiagnosesTree diagnosesTree;

    public DiagnosesTreeListener (DiagnosesTree diagnosesTree){
        this.diagnosesTree = diagnosesTree;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(diagnosesTree.getDoDiagnoseBtn())) {
            doDiagnose();
        }
    }

    private void doDiagnose(){
        if (diagnosesTree.setFloats()){
            float[] floats = diagnosesTree.getFloats();
            Patient patient = new Patient("tree", "tree", floats[0], floats[1], floats[2], floats[3], floats[4], floats[5], floats[6], floats[7]);
            Diagnosis diagnosis = new EnzimLogic();
            diagnosis.diagnose(patient);
            diagnosesTree.setInjuredOrgan(patient.getInjuredOrgan());
            diagnosesTree.setDisease(patient.getDisease());
        } else {
            JOptionPane.showMessageDialog(null, diagnosesTree.getMissedCoefficients());
            JOptionPane.showMessageDialog(null, diagnosesTree.getWrongCoefficients());
        }

    }
}