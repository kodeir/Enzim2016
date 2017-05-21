package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.logic.Diagnosis;
import com.kodeir.enzim2016.logic.EnzimLogic;
import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.pi.Patient;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class DatabasePanelListener implements ActionListener, ListSelectionListener {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());
    private DatabasePanel databasePanel;
    private CoefficientsPanel coefficientsPanel;

    public DatabasePanelListener(DatabasePanel databasePanel){
        this.databasePanel = databasePanel;
    }

    public DatabasePanelListener(DatabasePanel databasePanel, CoefficientsPanel coefficientsPanel){
        this.databasePanel = databasePanel;
        this.coefficientsPanel = coefficientsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(databasePanel.getAddNewPatientBtn())) {
            PatientPanel patientPanel = new PatientPanel(true, databasePanel);
            patientPanel.setFrame(new EnzimFrame(rb.getString("interface.create.new_patient"), patientPanel, 1));
        } else if (e.getSource().equals(databasePanel.getAddNewCoefficientsBtn())) {
            NewCoefficientsPanel newCoefficientsPanel = new NewCoefficientsPanel(getPatientId(), databasePanel);
            newCoefficientsPanel.setFrame(new EnzimFrame(rb.getString("interface.database.coefficients_add"), newCoefficientsPanel, 4));
        } else if (e.getSource().equals(databasePanel.getShowTreeBtn())) {
            showTree();
        } else if (e.getSource().equals(databasePanel.getExitBtn())) {
            exit();
        }

    }

    private long getPatientId(){
        String id = databasePanel.getPatientsListModel().get(databasePanel.getPatientsList().getSelectedIndex()).toString();
        System.out.println(id);
        return Long.parseLong(id.substring(0, id.indexOf(".")));
    }

    private void showTree(){
        TreePanel treePanel = new TreePanel(
                    coefficientsPanel.getAstField().getText(),
                    coefficientsPanel.getAltField().getText(),
                    coefficientsPanel.getKfkField().getText(),
                    coefficientsPanel.getLdgField().getText(),
                    coefficientsPanel.getShfField().getText(),
                    coefficientsPanel.getGgtpField().getText(),
                    coefficientsPanel.getHeField().getText(),
                    coefficientsPanel.getGldgField().getText()
            );

        treePanel.setFrame(new EnzimFrame(rb.getString("interface.tree.panel"), treePanel, 3));
    }

    private void exit(){
        Object[] options = {rb.getString("interface.Yes"),
                rb.getString("interface.No")};
        if (JOptionPane.showOptionDialog(null,
                rb.getString("interface.database.close"),
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        ) == JOptionPane.YES_OPTION){
            databasePanel.getFrame().dispose();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        databasePanel.getAddNewCoefficientsBtn().setEnabled(true);
        if (!e.getValueIsAdjusting()) {
            if (e.getSource().equals(databasePanel.getPatientsList())) {
                if (!databasePanel.getPatientsListModel().isEmpty()) {
                    setPatient();
                }
            } else if (e.getSource().equals(databasePanel.getCoefficientsList())) {
                databasePanel.getShowTreeBtn().setEnabled(true);
                if (!databasePanel.getCoefficientsList().isSelectionEmpty()) {
                    setCoefficients();
                }
            }
        }
    }

    private void setPatient(){
        String id = databasePanel.getPatientsListModel().get(databasePanel.getPatientsList().getSelectedIndex()).toString();
        int spaceIndex = id.indexOf(".");
        long patientId = Long.parseLong(id.substring(0,spaceIndex));

        List<Patient> patients = databasePanel.getPatients();
        for (Patient p : patients){
            if (p.getId() == patientId){
                databasePanel.getPatientPIPanel().setPatientNameField(p.getName());
                databasePanel.getPatientPIPanel().setPatientSurnameField(p.getSurname());
                databasePanel.getPatientPIPanel().setPatientPatronymicField(p.getPatronymic());
                databasePanel.getPatientPIPanel().setPatientBirthdateField(p.getBirthDate().toString());

                databasePanel.getCoefficientsListModel().removeAllElements();

                databasePanel.setCoefficientses(p.getCoefficients());
                for (Coefficients c: p.getCoefficients()){
                    String coefficients = Arrays.toString(c.toObjects());
                    coefficients = coefficients.substring(1,coefficients.length());
                    databasePanel.setCoefficientsListModel(coefficients);
                }
            }
        }
    }

    private void setCoefficients() {
        if (databasePanel.getCoefficientsListModel().getSize() != 0) {
            String id = databasePanel.getCoefficientsListModel().get(databasePanel.getCoefficientsList().getSelectedIndex()).toString();
            long coefficientId = Long.parseLong(id.substring(0, id.indexOf(",")));
            for (Coefficients c: databasePanel.getCoefficientses()){
                if (c.getCoefficients_id() == coefficientId) {
                    Diagnosis diagnosis = new EnzimLogic();
                    databasePanel.getDiagnosePanel().setInjuredOrgan(diagnosis.getDiagnose(diagnosis.defineInjuredOrgan(c)));
                    databasePanel.getDiagnosePanel().setDisease(diagnosis.getDiagnose(diagnosis.defineDisease(c)));

                    databasePanel.getCoefficientsPanel().setValues(
                            c.getAst(),
                            c.getAlt(),
                            c.getKfk(),
                            c.getLdg(),
                            c.getShf(),
                            c.getGgtp(),
                            c.getHe(),
                            c.getGldg(),
                            c.getCheckupDate()
                    );
                }
            }
        }
    }
}
