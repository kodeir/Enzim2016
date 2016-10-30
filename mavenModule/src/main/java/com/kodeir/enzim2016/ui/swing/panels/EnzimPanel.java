/*
 * Copyright (c) 2007, 2016 Vyacheslav Ryabinin and/or his affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Vyacheslav Ryabinin or the names of his
 *     affiliates may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 *  THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;
import com.kodeir.enzim2016.ui.swing.listeners.EnzimPanelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class EnzimPanel extends JPanel {

    private static final EnzimLogger logger = new EnzimLogger(EnzimPanel.class.getName());

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JLabel label;
    private JButton newPatientBtn;
    private JButton openDatabaseBtn;
    private JButton showTreeButton;
    private JButton exitBtn;

    /*
    The following icons are Designed by Freepik and distributed by Flaticon
    http://www.flaticon.com/packs/hospital-set
     */
    private String newPatientBtnIcoPath = "clinic-history.png";
    private String openDatabaseBtnIcoPath = "laptop.png";
    private String showTreeButtonIcoPath = "stethoscope.png";
    private String exitBtnIcoPath = "band-aid.png";


    public JButton getNewPatientBtn() {
        return newPatientBtn;
    }

    public JButton getOpenDatabaseBtn() {
        return openDatabaseBtn;
    }

    public JButton getShowTreeButton() {
        return showTreeButton;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public EnzimPanel(){
        logger.log(Level.INFO, "Creating main panel - EnzimPanel;");
        this.setLayout(new GridBagLayout());
        addNewPatient();
        addOpenDatabase();
        addShowTree();
        addExit();
        addListeners();
        logger.log(Level.INFO, "EnzimPanel is created;");
    }

    public void addNewPatient(){
        newPatientBtn = new JButton(addImage(newPatientBtnIcoPath));
        EnzimSwingCommons.setSize(newPatientBtn, 55, 55);
        this.add(newPatientBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 0));

        label = new JLabel(rb.getString("interface.create.new_patient"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 0));
    }

    public void addOpenDatabase(){
        openDatabaseBtn = new JButton(addImage(openDatabaseBtnIcoPath));
        EnzimSwingCommons.setSize(openDatabaseBtn, 55, 55);
        this.add(openDatabaseBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 1));

        label = new JLabel(rb.getString("interface.open.database"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 1));
    }

    public void addShowTree(){
        showTreeButton = new JButton(addImage(showTreeButtonIcoPath));
        EnzimSwingCommons.setSize(showTreeButton, 55, 55);
        this.add(showTreeButton, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 2));

        label = new JLabel(rb.getString("interface.open.tree"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 2));
    }

    public void addExit(){
        exitBtn = new JButton(addImage(exitBtnIcoPath));
        EnzimSwingCommons.setSize(exitBtn, 55, 55);
        this.add(exitBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 3));

        label = new JLabel(rb.getString("interface.exit"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 3));
    }

    private void addListeners(){
        getNewPatientBtn().addActionListener(new EnzimPanelListener(this));
        getOpenDatabaseBtn().addActionListener(new EnzimPanelListener(this));
        getShowTreeButton().addActionListener(new EnzimPanelListener(this));
        getExitBtn().addActionListener(new EnzimPanelListener(this));
    }

    private ImageIcon addImage(String imageName){
        ImageIcon icon = null;
        try {
            logger.log(Level.INFO, "Loading image " + imageName + ";");
            icon = new ImageIcon(Paths.get(ClassLoader.getSystemResource(imageName).toURI()).toString());
            logger.log(Level.INFO, "Resizing image " + imageName + "to fit button size;");
            icon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        } catch (URISyntaxException e) {
            logger.log(Level.WARNING, "Image can't be loaded: " + e);
        }
        return icon;
    }
}
