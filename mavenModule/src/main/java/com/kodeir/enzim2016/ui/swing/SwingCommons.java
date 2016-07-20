package com.kodeir.enzim2016.ui.swing;

import java.awt.*;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class SwingCommons {

    public static GridBagConstraints setConstraintsHorizontal(double weightx, int gridx, int gridy){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = weightx;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        return constraints;
    }

    public static GridBagConstraints setConstraintsHorizontal(double weightx, int gridx, int gridy, int gridwidth){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = weightx;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        return constraints;
    }
}
