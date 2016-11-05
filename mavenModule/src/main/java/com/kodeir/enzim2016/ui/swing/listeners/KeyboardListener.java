package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.HelpPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Created by Sergei Riabinin on 05.11.2016.
 */
public class KeyboardListener implements KeyListener{

    private static final EnzimLogger logger = new EnzimLogger(KeyboardListener.class.getName());
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private int helpMap;

    public KeyboardListener(int helpMap){
        this.helpMap = helpMap;
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
                logger.log(Level.INFO, "(listener) F1 was released;");
                HelpPanel helpPanel = new HelpPanel();
                helpPanel.setFrame(new EnzimFrame(rb.getString("interface.tutorial"), new HelpPanel(helpMap)));
                break;
            /*
            case KeyEvent.VK_ESCAPE:
                logger.log(Level.INFO, "ESCAPE was released;");
                this.dispose();
                break;
            */
        }
    }
}
