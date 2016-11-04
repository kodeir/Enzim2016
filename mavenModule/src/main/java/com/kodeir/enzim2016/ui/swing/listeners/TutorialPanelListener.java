package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.panels.EnzimPanel;
import com.kodeir.enzim2016.ui.swing.panels.TutorialPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 04.11.2016.
 */
public class TutorialPanelListener implements ActionListener {
    private static final EnzimLogger logger = new EnzimLogger(TutorialPanelListener.class.getName());
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private TutorialPanel tutorialPanel;

    public TutorialPanelListener(TutorialPanel tutorialPanel){
        this.tutorialPanel = tutorialPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(tutorialPanel.getMainMenuGuide())){
            tutorialPanel.addMainMenuGuide();
        } else if (e.getSource().equals(tutorialPanel.getNewPatientGuide())){
            tutorialPanel.addPatientPanelGuide();
        } else if (e.getSource().equals(tutorialPanel.getDatabaseGuide())){
            tutorialPanel.addDatabasePanelGuide();
        } else if (e.getSource().equals(tutorialPanel.getTreeGuide())){
            tutorialPanel.addTreeGuide();
        } else if (e.getSource().equals(tutorialPanel.getNewCoefficientsGuide())){
            tutorialPanel.addTreeGuide();
        }
    }
}
