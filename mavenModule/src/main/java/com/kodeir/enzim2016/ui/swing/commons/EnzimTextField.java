package com.kodeir.enzim2016.ui.swing.commons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sergei Riabinin on 24.07.2016.
 */
public class EnzimTextField extends JTextField {

    public EnzimTextField(){
        this(150,25);
    }

    public EnzimTextField(int width, int height){
        super();
        setPreferredSize(new Dimension(width,height));
        setMinimumSize(new Dimension(width,height));
        setMaximumSize(new Dimension(width,height));
    }
}
