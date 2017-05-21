package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;
import com.kodeir.enzim2016.ui.swing.listeners.AboutPanelListener;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Created by Sergei Riabinin on 04.11.2016.
 */
public class AboutPanel extends JPanel {
    private static final EnzimLogger logger = new EnzimLogger(EnzimPanel.class.getName());
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JButton tutorialBtn;

    public JButton getTutorialBtn(){
        return tutorialBtn;
    }

    public AboutPanel(){
        logger.log(Level.INFO, "Creating AboutPanel;");
        this.setLayout(new GridBagLayout());
        addAbout();
        addLicense();
        addTutorial();
        addListeners();
        logger.log(Level.INFO, "AboutPanel is created;");
    }

    private void addAbout() {
        JLabel label = new JLabel(rb.getString("interface.about"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 0));

        JTextArea aboutTxtArea = new JTextArea();
        aboutTxtArea.setEditable(false);
        aboutTxtArea.setText(
                rb.getString("interface.about.1") +
                        rb.getString("interface.about.2") +
                        rb.getString("interface.tutorial.instructions.panels.patient.11")
        );

        JScrollPane scrollPane = new JScrollPane(aboutTxtArea);
        EnzimSwingCommons.setSize(scrollPane, 600, 100);
        this.add(scrollPane, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 1));
    }

    private void addLicense() {
        JLabel label = new JLabel(rb.getString("interface.about.copyright"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 2));

        JTextArea licenseTxtArea = new JTextArea();
        licenseTxtArea.setEditable(false);
        licenseTxtArea.setText(
                rb.getString("interface.about.copyright.1") +
                        rb.getString("interface.about.copyright.2") +
                        rb.getString("interface.about.copyright.3") +
                        rb.getString("interface.about.copyright.4") +
                        rb.getString("interface.about.copyright.5") +
                        rb.getString("interface.about.copyright.6")
                );

        JScrollPane scrollPane = new JScrollPane(licenseTxtArea);
        EnzimSwingCommons.setSize(scrollPane, 600, 300);
        this.add(scrollPane, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 3));
    }

    private void addTutorial() {
        tutorialBtn = new JButton(rb.getString("interface.about.tutorial"));
        EnzimSwingCommons.setSize(tutorialBtn, 600, 25);
        this.add(tutorialBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 4));
    }

    public void addListeners(){
        tutorialBtn.addActionListener(new AboutPanelListener(this));
    }
}
