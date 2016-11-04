package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;
import com.kodeir.enzim2016.ui.swing.listeners.TutorialPanelListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
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

    private JTextPane textPane;
    private StyledDocument styledDocument;

    private JFrame frame;

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

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
        this(0);
    }

    public TutorialPanel(int panelId){
        setupPanel();
        switch (panelId){
            case 0: addMainMenuGuide();
                    break;
            case 1: addPatientPanelGuide();
                    break;
            case 2: addDatabasePanelGuide();
                    break;
            case 3: addTreeGuide();
                    break;
            case 4: addNewCoefficientsGuide();
                    break;
            default: addMainMenuGuide();
                    break;
        }
        addListeners();
    }

    private void setupPanel() {
        this.setLayout(new GridBagLayout());

        mainMenuGuide = new JButton(rb.getString("interface.tutorial.instructions") +
                rb.getString("interface.tutorial.instructions.panels.main"));
        EnzimSwingCommons.setSize(mainMenuGuide, 100, 25);
        this.add(mainMenuGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 0));

        newPatientGuide = new JButton(rb.getString("interface.tutorial.instructions") +
                rb.getString("interface.tutorial.instructions.panels.patient"));
        EnzimSwingCommons.setSize(newPatientGuide, 100, 25);
        this.add(newPatientGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 1));

        databaseGuide = new JButton(rb.getString("interface.tutorial.instructions") +
                rb.getString("interface.tutorial.instructions.panels.database"));
        EnzimSwingCommons.setSize(databaseGuide, 100, 25);
        this.add(databaseGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 2));

        treeGuide = new JButton(rb.getString("interface.tutorial.instructions") +
                rb.getString("interface.tutorial.instructions.panels.tree"));
        EnzimSwingCommons.setSize(treeGuide, 100, 25);
        this.add(treeGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 3));

        newCoefficientsGuide = new JButton(rb.getString("interface.tutorial.instructions") +
                rb.getString("interface.tutorial.instructions.panels.coefficients"));
        EnzimSwingCommons.setSize(newCoefficientsGuide, 100, 25);
        this.add(newCoefficientsGuide, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 4));

        textPane = new JTextPane();
        textPane.setEditable(false);
        styledDocument = textPane.getStyledDocument();
        JScrollPane scrollPane = new JScrollPane(textPane);
        EnzimSwingCommons.setSize(scrollPane, 500, 300);
        this.add(scrollPane, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 5));
    }

    public void addMainMenuGuide() {
        textPane.setText(rb.getString("interface.tutorial.instructions.panels.main.1"));

        try {
            styledDocument.insertString(styledDocument.getLength(),
                    "\n" + "\n" +
                    rb.getString("interface.tutorial.instructions.button") +
                    " \"" + rb.getString("interface.create.new_patient") + "\"" + ": " +
                    rb.getString("interface.tutorial.instructions.panels.main.2") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.main.3") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.main.4") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.main.5") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.further") +
                    " \"" + rb.getString("interface.tutorial.instructions") +
                    rb.getString("interface.tutorial.instructions.panels.patient") + "\"."

                    + "\n" + "\n" +
                    rb.getString("interface.tutorial.instructions.button") +
                    " \"" + rb.getString("interface.create.new_patient") + "\"" + ": " +
                    rb.getString("interface.tutorial.instructions.panels.main.2") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.main.3") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.main.4") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.main.5") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.further") +
                    " \"" + rb.getString("interface.tutorial.instructions") +
                    rb.getString("interface.tutorial.instructions.panels.patient") + "\"."

                    + "\n" + "\n" +
                    rb.getString("interface.tutorial.instructions.button") +
                    " \"" + rb.getString("interface.create.new_patient") + "\"" + ": " +
                    rb.getString("interface.tutorial.instructions.panels.main.2") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.main.3") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.main.4") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.main.5") + "\n" +
                    rb.getString("interface.tutorial.instructions.panels.further") +
                    " \"" + rb.getString("interface.tutorial.instructions") +
                    rb.getString("interface.tutorial.instructions.panels.patient") + "\"."
                    + "\n" + "\n"
                    ,setStyleHeader(false)
            );
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void addPatientPanelGuide() {
        textPane.setText("new patient guide");
    }

    public void addDatabasePanelGuide() {
        textPane.setText("db guide");
    }

    public void addTreeGuide() {
        textPane.setText("tree guide");
    }

    public void addNewCoefficientsGuide() {
        textPane.setText("coeff guide");
    }

    private void addListeners(){
        mainMenuGuide.addActionListener(new TutorialPanelListener(this));
        newPatientGuide.addActionListener(new TutorialPanelListener(this));
        databaseGuide.addActionListener(new TutorialPanelListener(this));
        treeGuide.addActionListener(new TutorialPanelListener(this));
        newCoefficientsGuide.addActionListener(new TutorialPanelListener(this));
    }

    private Style setStyleHeader(boolean bold){
        Style style = textPane.addStyle("header", null);
        StyleConstants.setBold(style, bold);
        return style;
    }
}
