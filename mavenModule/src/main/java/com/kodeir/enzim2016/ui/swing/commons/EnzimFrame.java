package com.kodeir.enzim2016.ui.swing.commons;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.ui.swing.listeners.KeyboardListener;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

/**
 * Created by Sergei Riabinin on 24.07.2016.
 *
 * JFrame which is extended with some default settings for the program's needs.
 */
public class EnzimFrame extends JFrame {

    private static final EnzimLogger logger = new EnzimLogger(EnzimFrame.class.getName());

    public EnzimFrame(String frameName, JPanel panel){
        super(frameName);
        logger.log(Level.INFO, "Default EnzimFrame to be created;");
        invoke(panel, 0);
    }

    /**
     *
     * @param frameName frame's name
     * @param panel panel to be added to ContentPane
     * @param helpMap int constant (help panel mapping) to be passed to KeyboardListener
     * @see com.kodeir.enzim2016.data.HelpMapping
     */
    public EnzimFrame(String frameName, JPanel panel, int helpMap){
        super(frameName);
        logger.log(Level.INFO, "Mapped EnzimFrame to be created;");
        invoke(panel, helpMap);
    }

    /**
     * Method places frame to the center of the screen,
     * Resizable = false,
     * Focused for KeyListener
     *
     * @param panel panel to be added to ContentPane
     * @param helpMap int constant (help panel mapping) to be passed to KeyboardListener
     * @see com.kodeir.enzim2016.data.HelpMapping
     * @see com.kodeir.enzim2016.ui.swing.listeners.KeyboardListener
     */
    private void invoke(JPanel panel, int helpMap){
        SwingUtilities.invokeLater(() -> {
            getContentPane().add(panel);
            pack();
            setLocationRelativeTo(null);
            setResizable(false);
            setExtendedState(Frame.NORMAL);
            setVisible(true);
            addKeyListener(new KeyboardListener(helpMap, panel));
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
        });
    }
}
