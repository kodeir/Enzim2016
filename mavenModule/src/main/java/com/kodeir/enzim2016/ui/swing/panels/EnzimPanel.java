package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;
import com.kodeir.enzim2016.ui.swing.listeners.EnzimPanelListener;

import javax.swing.*;
import java.awt.*;
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
    private JButton showTreeBtn;
    private JButton aboutBtn;
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

    public JButton getShowTreeBtn() {
        return showTreeBtn;
    }

    public JButton getAboutBtn() {
        return aboutBtn;
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
        addAbout();
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
        showTreeBtn = new JButton(addImage(showTreeButtonIcoPath));
        EnzimSwingCommons.setSize(showTreeBtn, 55, 55);
        this.add(showTreeBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 2));

        label = new JLabel(rb.getString("interface.open.tree"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 2));
    }

    public void addAbout(){
        aboutBtn = new JButton();
        EnzimSwingCommons.setSize(aboutBtn, 55, 55);
        this.add(aboutBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 3));

        label = new JLabel(rb.getString("interface.about"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 3));
    }

    public void addExit(){
        exitBtn = new JButton(addImage(exitBtnIcoPath));
        EnzimSwingCommons.setSize(exitBtn, 55, 55);
        this.add(exitBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5, 0, 4));

        label = new JLabel(rb.getString("interface.exit"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5, 1, 4));
    }

    private void addListeners(){
        getNewPatientBtn().addActionListener(new EnzimPanelListener(this));
        getOpenDatabaseBtn().addActionListener(new EnzimPanelListener(this));
        getShowTreeBtn().addActionListener(new EnzimPanelListener(this));
        aboutBtn.addActionListener(new EnzimPanelListener(this));
        getExitBtn().addActionListener(new EnzimPanelListener(this));
    }

    private ImageIcon addImage(String imageName){
        ImageIcon icon = null;
        try {
            logger.log(Level.INFO, "Loading image " + imageName + ";");
            icon = new ImageIcon(getClass().getClassLoader().getResource(imageName));
            icon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        } catch (NullPointerException e) {
            logger.log(Level.WARNING, "Image can't be loaded: " + e);
        }
        return icon;
    }
}
