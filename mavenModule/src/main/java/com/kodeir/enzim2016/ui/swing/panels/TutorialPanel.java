package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 04.11.2016.
 */
public class TutorialPanel extends JPanel {
    private static final EnzimLogger logger = new EnzimLogger(EnzimPanel.class.getName());
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JButton mainMenuGuide;
    private JButton newPatientGuide;
    private JButton databaseGuide;
    private JButton treeGuide;
    private JButton newCoefficientsGuide;
    private JTextArea textArea;

    public JButton getMainMenuGuide() {
        return mainMenuGuide;
    }

    public JButton getNewPatientGuide() {
        return newPatientGuide;
    }

    public JButton getDatabaseGuide() {
        return databaseGuide;
    }

    public JButton getTreeGuide() {
        return treeGuide;
    }

    public JButton getNewCoefficientsGuide() {
        return newCoefficientsGuide;
    }

    public TutorialPanel(){
        this(4);
    }

    public TutorialPanel(int panelId){
        setupPanel();
        switch (panelId){
            // 0 - New Patient Panel
            case 0: addPatientPanelGuide();
            // 1 - Database Panel
            case 1: addDatabasePanelGuide();
            // 2 - Diagnose Tree Panel
            case 2: addTreeGuide();
            // 3 - New Coefficients Panel
            case 3: addNewCoefficientsGuide();
            // 4 - About Panel
            case 4: {
                addMainMenuGuide();
                addPatientPanelGuide();
                addDatabasePanelGuide();
                addTreeGuide();
                addNewCoefficientsGuide();
            }
        }
    }

    private void setupPanel() {
        this.setLayout(new GridBagLayout());

        mainMenuGuide = new JButton("mainBtn");
        EnzimSwingCommons.setSize(mainMenuGuide, 100, 25);
        this.add(mainMenuGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 0));
        JLabel label = new JLabel("main");
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 0));

        newPatientGuide = new JButton("pBtn");
        EnzimSwingCommons.setSize(newPatientGuide, 100, 25);
        this.add(newPatientGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 1));
        label = new JLabel("p");
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 1));

        databaseGuide = new JButton("dbBtn");
        EnzimSwingCommons.setSize(databaseGuide, 100, 25);
        this.add(databaseGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 2));
        label = new JLabel("db");
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 2));

        treeGuide = new JButton("treeBtn");
        EnzimSwingCommons.setSize(treeGuide, 100, 25);
        this.add(treeGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 3));
        label = new JLabel("tree");
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 3));

        newCoefficientsGuide = new JButton("coeffBtn");
        EnzimSwingCommons.setSize(newCoefficientsGuide, 100, 25);
        this.add(newCoefficientsGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 4));
        label = new JLabel("coeff");
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 4));

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        EnzimSwingCommons.setSize(scrollPane, 500, 300);
        this.add(scrollPane, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 5, 2, 1));
    }

    private void addMainMenuGuide() {

    }

    private void addPatientPanelGuide() {

    }

    private void addDatabasePanelGuide() {

    }

    private void addTreeGuide() {

    }

    private void addNewCoefficientsGuide() {

    }
}
