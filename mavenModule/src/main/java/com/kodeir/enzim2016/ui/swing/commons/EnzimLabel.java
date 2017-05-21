package com.kodeir.enzim2016.ui.swing.commons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sergei Riabinin on 24.07.2016.
 */
public class EnzimLabel extends JLabel {

    public EnzimLabel(){
        this("",150,25);
    }

    public EnzimLabel(String labelText){
        this(labelText,100,25);
    }

    public EnzimLabel(String labelText, int width, int height){
        super(labelText);
        setPreferredSize(new Dimension(width,height));
        setMinimumSize(new Dimension(width,height));
        setMaximumSize(new Dimension(width,height));
    }

}
