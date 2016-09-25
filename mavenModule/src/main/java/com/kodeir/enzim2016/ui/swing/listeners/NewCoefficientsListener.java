package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.panels.NewCoefficientsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 25.09.2016.
 */
public class NewCoefficientsListener implements ActionListener {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private NewCoefficientsPanel newCoefficientsPanel;

    public NewCoefficientsListener(NewCoefficientsPanel newCoefficientsPanel){
        this.newCoefficientsPanel = newCoefficientsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newCoefficientsPanel.getAddNewCoefficientsBtn())) {
            if (addCoefficients()) {
                exit("Return? add true");
            } else {
                exit("Return? add false");
            }
        } else if (e.getSource().equals(newCoefficientsPanel.getReturnBtn())) {
            exit("Return?");
        }
    }

    private boolean addCoefficients() {
        return false;
    }

    private void exit(String exitText){
        Object[] options = {rb.getString("interface.Yes"),
                rb.getString("interface.No")};
        if (JOptionPane.showOptionDialog(null,
                exitText,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        ) == JOptionPane.YES_OPTION){
            newCoefficientsPanel.getFrame().dispose();
        }
    }
}
