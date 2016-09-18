package com.kodeir.enzim2016.ui.swing.commons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sergei Riabinin on 24.07.2016.
 */
public class EnzimFrame extends JFrame {

    public EnzimFrame(String frameName, JPanel panel){
        super(frameName);
        setVisible(true);
        SwingUtilities.invokeLater(() -> {
            getContentPane().add(panel);
            pack();
            setLocationRelativeTo(null);
            setResizable(true);
            setExtendedState(Frame.NORMAL);
            setVisible(true);
        });
    }

    public static EnzimFrame setupPanel(String frameName, JPanel panel){
        return new EnzimFrame(frameName, panel);
    }
}
