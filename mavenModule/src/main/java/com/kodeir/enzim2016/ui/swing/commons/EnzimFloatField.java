package com.kodeir.enzim2016.ui.swing.commons;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class EnzimFloatField extends JFormattedTextField {

    public EnzimFloatField(){
        this(150, 25);
    }

    public EnzimFloatField(int width, int height){
        super(new DecimalFormat("#.00"));
        setPreferredSize(new Dimension(width,height));
        setMinimumSize(new Dimension(width,height));
        setMaximumSize(new Dimension(width,height));
    }
}
