package com.kodeir.enzim2016.ui.swing.commons;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Sergei Riabinin on 24.07.2016.
 */
public class EnzimDateField extends JFormattedTextField {

    public EnzimDateField(){
        this(150, 25);
    }

    public EnzimDateField(int width, int height){
        super(new SimpleDateFormat("yyyy-MM-dd"));
        setupDateTextField();
        setPreferredSize(new Dimension(width,height));
        setMinimumSize(new Dimension(width,height));
        setMaximumSize(new Dimension(width,height));
    }

    private void setupDateTextField(){
        try {
            MaskFormatter maskFormatter = new MaskFormatter("####-##-##");
            maskFormatter.install(this);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
