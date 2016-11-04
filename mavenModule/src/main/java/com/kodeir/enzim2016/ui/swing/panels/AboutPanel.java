package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;

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

    private JLabel label;
    private JTextArea aboutTxtArea;

    public AboutPanel(){
        logger.log(Level.INFO, "Creating AboutPanel;");
        this.setLayout(new GridBagLayout());
        addAbout();
        addLicense();
        addFaq();
        logger.log(Level.INFO, "AboutPanel is created;");
    }

    private void addAbout() {
        label = new JLabel(rb.getString("interface.about"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 0));

        aboutTxtArea = new JTextArea();
        EnzimSwingCommons.setSize(aboutTxtArea, 600, 150);
        this.add(aboutTxtArea, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 1));
    }

    private void addLicense() {

    }

    private void addFaq() {

    }
}
