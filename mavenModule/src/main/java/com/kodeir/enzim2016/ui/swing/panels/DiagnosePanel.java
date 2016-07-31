package com.kodeir.enzim2016.ui.swing.panels;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimGridBagConstraints;
import com.kodeir.enzim2016.ui.swing.commons.EnzimLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 31.07.2016.
 */
public class DiagnosePanel extends JPanel {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JLabel label;
    private JLabel injuredOrgan;
    private JLabel disease;

    public JLabel getInjuredOrgan() {
        return injuredOrgan;
    }

    public void setInjuredOrgan(String s) {
        injuredOrgan.setText(s);
    }

    public JLabel getDisease() {
        return disease;
    }

    public void setDisease(String s) {
        disease.setText(s);
    }

    public DiagnosePanel(){
        this.setLayout(new GridBagLayout());
        addDiagnoseComponents();
    }

    private void addDiagnoseComponents(){
        label = new EnzimLabel(rb.getString("organs.Injured_organ"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,0,2));

        injuredOrgan = new JLabel("");
        injuredOrgan.setFont(new Font(injuredOrgan.getFont().getFontName(), Font.BOLD, injuredOrgan.getFont().getSize()+2));
        this.add(injuredOrgan, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,1,4));

        label = new EnzimLabel(rb.getString("diseases.Disease"));
        this.add(label, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,2,2));

        disease = new JLabel("");
        disease.setFont(new Font(disease.getFont().getFontName(), Font.BOLD, disease.getFont().getSize()+2));
        this.add(disease, EnzimGridBagConstraints.setConstraintsHorizontal(0.5,0,3,4));
    }
}
