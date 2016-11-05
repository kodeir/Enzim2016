package com.kodeir.enzim2016.ui.swing.commons;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.listeners.KeyboardListener;
import com.kodeir.enzim2016.ui.swing.panels.TutorialPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Created by Sergei Riabinin on 24.07.2016.
 */
public class EnzimFrame extends JFrame {

    private static final EnzimLogger logger = new EnzimLogger(EnzimFrame.class.getName());

    public EnzimFrame(String frameName, JPanel panel){
        super(frameName);
        invoke(panel, 0);
    }

    public EnzimFrame(String frameName, JPanel panel, int helpMap){
        super(frameName);
        invoke(panel, helpMap);
    }

    private void invoke(JPanel panel, int helpMap){
        SwingUtilities.invokeLater(() -> {
            getContentPane().add(panel);
            pack();
            setLocationRelativeTo(null);
            setResizable(true);
            setExtendedState(Frame.NORMAL);
            setVisible(true);
            addKeyListener(new KeyboardListener(helpMap));
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
        });
    }
}
