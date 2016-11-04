package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.ui.swing.panels.AboutPanel;
import com.kodeir.enzim2016.ui.swing.panels.EnzimPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei Riabinin on 04.11.2016.
 */
public class AboutPanelListener implements ActionListener{
    private static final EnzimLogger logger = new EnzimLogger(EnzimPanel.class.getName());

    private AboutPanel aboutPanel;

    public AboutPanelListener(AboutPanel aboutPanel){
        this.aboutPanel = aboutPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(aboutPanel.getTutorialBtn())){
            createTutorialPanel();
        }
    }

    private void createTutorialPanel() {

    }
}
