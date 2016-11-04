package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;

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

    public AboutPanel(){
        logger.log(Level.INFO, "Creating AboutPanel;");
        this.setLayout(new GridBagLayout());

        logger.log(Level.INFO, "AboutPanel is created;");
    }
}
