package com.kodeir.enzim2016.ui.swing.commons;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
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
public class EnzimFrame extends JFrame implements KeyListener{

    private static final EnzimLogger logger = new EnzimLogger(EnzimFrame.class.getName());
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private int helpMap;

    public EnzimFrame(String frameName, JPanel panel){
        super(frameName);
        SwingUtilities.invokeLater(() -> {
            getContentPane().add(panel);
            pack();
            setLocationRelativeTo(null);
            setResizable(true);
            setExtendedState(Frame.NORMAL);
            setVisible(true);
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
        });
    }

    public EnzimFrame(String frameName, JPanel panel, int helpMap){
        super(frameName);
        this.helpMap = helpMap;
        SwingUtilities.invokeLater(() -> {
            getContentPane().add(panel);
            pack();
            setLocationRelativeTo(null);
            setResizable(true);
            setExtendedState(Frame.NORMAL);
            setVisible(true);
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        logger.log(Level.INFO, "KeyEvent");
        switch (e.getKeyCode()){
            case KeyEvent.VK_F1:
                logger.log(Level.INFO, "F1 was released;");
                TutorialPanel tutorialPanel = new TutorialPanel();
                tutorialPanel.setFrame(new EnzimFrame(rb.getString("interface.tutorial"), new TutorialPanel(helpMap)));
                break;
            case KeyEvent.VK_ESCAPE:
                logger.log(Level.INFO, "ESCAPE was released;");
                this.dispose();
                break;
        }
    }
}
