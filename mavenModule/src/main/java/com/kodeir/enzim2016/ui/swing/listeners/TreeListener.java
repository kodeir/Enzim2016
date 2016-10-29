package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.logic.Diagnosis;
import com.kodeir.enzim2016.logic.EnzimLogic;
import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.ui.swing.panels.TreePanel;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class TreeListener implements ActionListener {

    private TreePanel treePanel;

    public TreeListener(TreePanel treePanel){
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
            Coefficients coefficients = new Coefficients(0, 0, floats[0], floats[1], floats[2], floats[3], floats[4], floats[5], floats[6], floats[7], LocalDate.now());
            Diagnosis diagnosis = new EnzimLogic();

            Map<Integer,String> diagnoseMap = diagnosis.defineInjuredOrgan(coefficients);
            treePanel.getDiagnosePanel().setInjuredOrgan(diagnosis.getDiagnose(diagnoseMap));
            if (diagnosis.getKey(diagnoseMap) > 0){
                treePanel.collapseTree();
                treePanel.getTree().setSelectionPath(new TreePath(
                        treePanel.getTreeModel().getPathToRoot(
                                TreeNodesMap.getInjuredOrganMap().get(
                                        diagnosis.getKey(diagnoseMap)))));
            }

            diagnoseMap = diagnosis.defineDisease(coefficients);
            treePanel.getDiagnosePanel().setDisease(diagnosis.getDiagnose(diagnoseMap));
            if (diagnosis.getKey(diagnoseMap) > 0){
                treePanel.collapseTree();
                treePanel.getTree().setSelectionPath(new TreePath(
                        treePanel.getTreeModel().getPathToRoot(
                                TreeNodesMap.getDiseaseMap().get(
                                        diagnosis.getKey(diagnoseMap)))));
            }

        } else {
            JOptionPane.showMessageDialog(null, treePanel.getMissedCoefficients());
            JOptionPane.showMessageDialog(null, treePanel.getWrongCoefficients());
        }

    }
}
