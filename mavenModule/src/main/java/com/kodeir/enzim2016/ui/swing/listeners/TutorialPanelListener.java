package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.panels.HelpPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 04.11.2016.
 */
public class TutorialPanelListener implements ActionListener {
    private static final EnzimLogger logger = new EnzimLogger(TutorialPanelListener.class.getName());
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private HelpPanel helpPanel;

    public TutorialPanelListener(HelpPanel helpPanel){
        this.helpPanel = helpPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(helpPanel.getMainMenuGuide())){
            helpPanel.addMainMenuGuide();
        } else if (e.getSource().equals(helpPanel.getNewPatientGuide())){
            helpPanel.addPatientPanelGuide();
        } else if (e.getSource().equals(helpPanel.getDatabaseGuide())){
            helpPanel.addDatabasePanelGuide();
        } else if (e.getSource().equals(helpPanel.getTreeGuide())){
            helpPanel.addTreeGuide();
        } else if (e.getSource().equals(helpPanel.getNewCoefficientsGuide())){
            helpPanel.addNewCoefficientsGuide();
        }
    }
}
