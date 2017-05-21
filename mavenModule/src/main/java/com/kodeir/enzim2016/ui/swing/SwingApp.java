package com.kodeir.enzim2016.ui.swing;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.data.HelpMapping;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.EnzimPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class SwingApp {

    private static final EnzimLogger logger = new EnzimLogger(SwingApp.class.getName());

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JFrame frame;

    public SwingApp(){
        logger.log(Level.INFO, "Starting Swing application;");
        frame = new EnzimFrame(rb.getString("interface.name"), new EnzimPanel(), HelpMapping.HELP_MAIN);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void startSwing() {
        logger.log(Level.INFO, "Invoking Swing application;");
        EventQueue.invokeLater(() -> {
            try {
                new SwingApp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
