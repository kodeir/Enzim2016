package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 04.11.2016.
 */
public class TutorialPanel extends JPanel {
    private static final EnzimLogger logger = new EnzimLogger(EnzimPanel.class.getName());
    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    public TutorialPanel(){
        this(4);
    }

    public TutorialPanel(int panelId){
        switch (panelId){
            // 0 - New Patient Panel
            case 0: {}
            // 1 - Database Panel
            case 1: {}
            // 2 - Diagnose Tree Panel
            case 2: {}
            // 3 - New Coefficients Panel
            case 3: {}
            // 4 - About Panel
            case 4: {}
        }
    }
}
