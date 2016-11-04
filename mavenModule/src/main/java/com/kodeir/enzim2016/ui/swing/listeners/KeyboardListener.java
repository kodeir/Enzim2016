package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Created by Sergei Riabinin on 04.11.2016.
 */
public class KeyboardListener implements KeyEventDispatcher {
    private static final EnzimLogger logger = new EnzimLogger(KeyboardListener.class.getName());
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private EnzimPanel enzimPanel;
    private PatientPanel patientPanel;
    private DatabasePanel databasePanel;
    private TreePanel treePanel;
    private NewCoefficientsPanel newCoefficientsPanel;

    public KeyboardListener(JPanel panel){
        if (panel instanceof EnzimPanel) {
            this.enzimPanel = (EnzimPanel) panel;
        } else if (panel instanceof PatientPanel){
            this.patientPanel = (PatientPanel) panel;
            logger.log(Level.INFO, "frame == true");
        } else if (panel instanceof DatabasePanel){
            this.databasePanel = (DatabasePanel) panel;
        } else if (panel instanceof TreePanel){
            this.treePanel = (TreePanel) panel;
        } else if (panel instanceof NewCoefficientsPanel){
            this.newCoefficientsPanel = (NewCoefficientsPanel) panel;
        }

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_F1:
                    logger.log(Level.INFO, "F1 == true");
                    new EnzimFrame(rb.getString("interface.tutorial"), new TutorialPanel());
                    break;
                case KeyEvent.VK_ESCAPE:
                    logger.log(Level.INFO, "ESC == true");
                    if (enzimPanel == null) {
                        if (patientPanel!=null) {
                            patientPanel.getFrame().dispose();
                        } else if (databasePanel!=null) {
                            databasePanel.getFrame().dispose();
                        } else if (treePanel!=null) {
                            treePanel.getFrame().dispose();
                        } else if (newCoefficientsPanel!=null) {
                            newCoefficientsPanel.getFrame().dispose();
                        }
                    }
            }
        }
        // Pass the KeyEvent to the next KeyEventDispatcher in the chain
        return false;
    }
}
