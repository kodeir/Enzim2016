package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimFrame;
import com.kodeir.enzim2016.ui.swing.panels.AboutPanel;
import com.kodeir.enzim2016.ui.swing.panels.EnzimPanel;
import com.kodeir.enzim2016.ui.swing.panels.TutorialPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 04.11.2016.
 */
public class AboutPanelListener implements ActionListener{
    private static final EnzimLogger logger = new EnzimLogger(AboutPanelListener.class.getName());
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

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
        new EnzimFrame(rb.getString("interface.tutorial"), new TutorialPanel(), 0);
    }
}
