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

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.ui.swing.commons.EnzimSwingCommons;
import com.kodeir.enzim2016.ui.swing.commons.EnzimLabel;
import com.kodeir.enzim2016.ui.swing.commons.EnzimTextField;
import com.kodeir.enzim2016.ui.swing.listeners.TreeListener;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Rowan on 03.07.2016.
 *
 */

//TODO get rid of spaghetti and get an xml?
public class TreePanel extends JPanel {

    private ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private JLabel label;

    private JTextField astField;
    private JTextField altField;
    private JTextField kfkField;
    private JTextField ldgField;
    private JTextField shfField;
    private JTextField ggtpField;
    private JTextField heField;
    private JTextField gldgField;

    private JButton doDiagnoseBtn;
    private DiagnosePanel diagnosePanel;

    private float floatChecker;
    private float[] floats;
    private String missedCoefficients;
    private String wrongCoefficients;

    private DefaultMutableTreeNode injuredOrgan;
    private DefaultMutableTreeNode disease;
    private JTree tree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode AlT_Node_0;

    public DefaultMutableTreeNode getAlT_Node_0(){
        return AlT_Node_0;
    }
    public DefaultMutableTreeNode getInjuredOrgan(){
        return injuredOrgan;
    }
    public DefaultMutableTreeNode getdisease(){
        return disease;
    }
    public JTree getTree(){
        return tree;
    }
    public DefaultTreeModel getTreeModel(){
        return treeModel;
    }

    public JButton getDoDiagnoseBtn() {
        return doDiagnoseBtn;
    }

    public DiagnosePanel getDiagnosePanel() {
        return diagnosePanel;
    }

    public String getMissedCoefficients() {
        return missedCoefficients;
    }

    public String getWrongCoefficients() {
        return wrongCoefficients;
    }

    public TreePanel(){
        this.setLayout(new GridBagLayout());
        addFields();
        addResultButton();
        addResults();
        addTree();
        addListeners();
    }

    private void addFields(){
        label = new EnzimLabel(rb.getString("coefficients.ast"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,0));
        label = new EnzimLabel(rb.getString("coefficients.alt"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,0));
        label = new EnzimLabel(rb.getString("coefficients.kfk"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,0));
        label = new EnzimLabel(rb.getString("coefficients.ldg"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,0));

        astField = new EnzimTextField();
        this.add(astField, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,1));
        altField = new EnzimTextField();
        this.add(altField, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,1));
        kfkField = new EnzimTextField();
        this.add(kfkField, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,1));
        ldgField = new EnzimTextField();
        this.add(ldgField, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,1));

        label = new EnzimLabel(rb.getString("coefficients.shf"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,2));
        label = new EnzimLabel(rb.getString("coefficients.ggtp"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,2));
        label = new EnzimLabel(rb.getString("coefficients.he"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,2));
        label = new EnzimLabel(rb.getString("coefficients.gldg"));
        this.add(label, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,2));

        shfField = new EnzimTextField();
        this.add(shfField, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,3));
        ggtpField = new EnzimTextField();
        this.add(ggtpField, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,3));
        heField = new EnzimTextField();
        this.add(heField, EnzimSwingCommons.setConstraintsHorizontal(0.5,2,3));
        gldgField = new EnzimTextField();
        this.add(gldgField, EnzimSwingCommons.setConstraintsHorizontal(0.5,3,3));
    }

    private void addResultButton(){
        doDiagnoseBtn = new JButton(rb.getString("diagnose.do"));
        this.add(doDiagnoseBtn, EnzimSwingCommons.setConstraintsHorizontal(0.5,1,4,2));
    }

    private void addResults(){
        diagnosePanel = new DiagnosePanel();
        this.add(diagnosePanel, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,5,4,4));
    }

    private void addTree(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        root.add(createInjuredOrganBranch());
        root.add(createDiseaseBranch());

        treeModel = new DefaultTreeModel(root);

        tree = new JTree(treeModel);
        tree.setRootVisible(false);
        tree.setMinimumSize(new Dimension(600,500));
        tree.getExpandsSelectedPaths();

        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setMinimumSize(new Dimension(600,500));
        this.add(scrollPane, EnzimSwingCommons.setConstraintsHorizontal(0.5,0,9,4));
    }

    private DefaultMutableTreeNode createInjuredOrganBranch(){
        injuredOrgan = new DefaultMutableTreeNode(rb.getString("organs.Injured_organ"));

        DefaultMutableTreeNode AsT_Node = new DefaultMutableTreeNode(rb.getString("coefficients.ast.41_150"));
        injuredOrgan.add(AsT_Node);
         AlT_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.alt.41_250"));
        DefaultMutableTreeNode AlT_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.alt.0_40"));
        AsT_Node.add(AlT_Node_0);
        AsT_Node.add(AlT_Node_1);
        DefaultMutableTreeNode diagnose = new DefaultMutableTreeNode(rb.getString("organs.LIVER")
                + rb.getString("organs.BILIARY_TRACT"));
        AlT_Node_0.add(diagnose);
        DefaultMutableTreeNode KFK_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.kfk.501_1750"));
        DefaultMutableTreeNode KFK_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.kfk.176_500"));
        DefaultMutableTreeNode KFK_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.kfk.15_175"));
        AlT_Node_1.add(KFK_Node_0);
        AlT_Node_1.add(KFK_Node_1);
        AlT_Node_1.add(KFK_Node_2);
        diagnose = new DefaultMutableTreeNode(rb.getString("organs.SKELETAL_MUSCLE"));
        KFK_Node_0.add(diagnose);
        diagnose = new DefaultMutableTreeNode(rb.getString("organs.HEART"));
        KFK_Node_1.add(diagnose);
        DefaultMutableTreeNode LDG_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ldg.591_2750"));
        DefaultMutableTreeNode LDG_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ldg.150_590"));
        KFK_Node_2.add(LDG_Node_0);
        KFK_Node_2.add(LDG_Node_1);
        diagnose = new DefaultMutableTreeNode(rb.getString("organs.BLOOD"));
        LDG_Node_0.add(diagnose);
        DefaultMutableTreeNode SHF_Node = new DefaultMutableTreeNode(rb.getString("coefficients.shf.more.80"));
        LDG_Node_1.add(SHF_Node);
        DefaultMutableTreeNode GGTP_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.151_950"));
        DefaultMutableTreeNode GGTP_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.51_150"));
        DefaultMutableTreeNode GGTP_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.0_50"));
        SHF_Node.add(GGTP_Node_0);
        SHF_Node.add(GGTP_Node_1);
        SHF_Node.add(GGTP_Node_2);
        diagnose = new DefaultMutableTreeNode(rb.getString("organs.LIVER")
                + rb.getString("organs.BILIARY_TRACT"));
        GGTP_Node_0.add(diagnose);
        diagnose = new DefaultMutableTreeNode(rb.getString("organs.LIVER"));
        GGTP_Node_1.add(diagnose);
        diagnose = new DefaultMutableTreeNode(rb.getString("organs.BONE_TISSUE"));
        GGTP_Node_2.add(diagnose);

        return injuredOrgan;
    }

    private DefaultMutableTreeNode createDiseaseBranch(){
        disease = new DefaultMutableTreeNode(rb.getString("diseases.Disease"));

        DefaultMutableTreeNode AsT_Node = new DefaultMutableTreeNode(rb.getString("coefficients.ast.41_150"));
        disease.add(AsT_Node);

        DefaultMutableTreeNode deRitis01_05_Node = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt.01_05"));
        DefaultMutableTreeNode deRitis06_09_Node = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt.06_09"));
        DefaultMutableTreeNode deRitis1_Node = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt.more.1"));

        AsT_Node.add(deRitis01_05_Node);
        AsT_Node.add(deRitis06_09_Node);
        AsT_Node.add(deRitis1_Node);

        DefaultMutableTreeNode LDG_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ldg.591_2750"));
        DefaultMutableTreeNode LDG_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ldg.150_590"));

        deRitis01_05_Node.add(LDG_Node_0);
        deRitis01_05_Node.add(LDG_Node_1);

        DefaultMutableTreeNode result = new DefaultMutableTreeNode(rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS"));
        LDG_Node_0.add(result);

        DefaultMutableTreeNode SHF_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.shf.more.270"));
        DefaultMutableTreeNode SHF_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.shf.80_270"));

        LDG_Node_1.add(SHF_Node_0);
        LDG_Node_1.add(SHF_Node_1);

        DefaultMutableTreeNode GLDG_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.gldg.11_75"));
        DefaultMutableTreeNode GLDG_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.gldg.0_10"));

        SHF_Node_0.add(GLDG_Node_0);
        SHF_Node_0.add(GLDG_Node_1);

        DefaultMutableTreeNode AsT_AlT_GLDG_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.more.50"));
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.40_50"));
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.less.40"));

        GLDG_Node_0.add(AsT_AlT_GLDG_Node_0);
        GLDG_Node_0.add(AsT_AlT_GLDG_Node_1);
        GLDG_Node_0.add(AsT_AlT_GLDG_Node_2);

        result = new DefaultMutableTreeNode(rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? ");
        AsT_AlT_GLDG_Node_0.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.OBSTRUCTIVE_JAUNDICE"));
        AsT_AlT_GLDG_Node_1.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? ");
        AsT_AlT_GLDG_Node_2.add(result);

        AsT_AlT_GLDG_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.more.50"));
        AsT_AlT_GLDG_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.less.50"));

        GLDG_Node_1.add(AsT_AlT_GLDG_Node_0);
        GLDG_Node_1.add(AsT_AlT_GLDG_Node_1);

        result = new DefaultMutableTreeNode(rb.getString("diseases.TOXIC_DAMAGE"));
        AsT_AlT_GLDG_Node_0.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.TOXIC_DAMAGE") + " ? ");
        AsT_AlT_GLDG_Node_1.add(result);

        DefaultMutableTreeNode GGTP_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.more.150"));
        DefaultMutableTreeNode GGTP_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.less.150"));

        SHF_Node_1.add(GGTP_Node_0);
        SHF_Node_1.add(GGTP_Node_1);

        DefaultMutableTreeNode GGTP_AsT_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.more.6"));
        DefaultMutableTreeNode GGTP_AsT_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.3_6"));
        DefaultMutableTreeNode GGTP_AsT_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.less.3"));

        GGTP_Node_0.add(GGTP_AsT_Node_0);
        GGTP_Node_0.add(GGTP_AsT_Node_1);
        GGTP_Node_0.add(GGTP_AsT_Node_2);

        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_ALCOHOLIC"));
        GGTP_AsT_Node_1.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? ");
        GGTP_AsT_Node_2.add(result);

        GGTP_AsT_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.more.3"));
        GGTP_AsT_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.1_3"));
        GGTP_AsT_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.less.1"));

        GGTP_Node_1.add(GGTP_AsT_Node_0);
        GGTP_Node_1.add(GGTP_AsT_Node_1);
        GGTP_Node_1.add(GGTP_AsT_Node_2);

        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_VIRAL") + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_VIRAL"));
        GGTP_AsT_Node_1.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_VIRAL") + " ? ");
        GGTP_AsT_Node_2.add(result);

        // de ritis 0.6-0.9

        SHF_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.shf.371_1500"));
        SHF_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.shf.80_370"));

        deRitis06_09_Node.add(SHF_Node_0);
        deRitis06_09_Node.add(SHF_Node_1);

        SHF_Node_0.add(add_HE_Node_0());
        SHF_Node_0.add(add_HE_Node_1());
        SHF_Node_0.add(add_HE_Node_2());
        SHF_Node_0.add(add_HE_Node_3());

        GGTP_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.more.11"));
        GGTP_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.0_10"));
        SHF_Node_1.add(GGTP_Node_0);
        SHF_Node_1.add(GGTP_Node_1);

        GGTP_Node_0.add(add_HE_Node_0());
        GGTP_Node_0.add(add_HE_Node_1());
        GGTP_Node_0.add(add_HE_Node_2());
        GGTP_Node_0.add(add_HE_Node_3());

        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_CHRONIC"));
        GGTP_Node_1.add(result);

        // deRitis 1

        DefaultMutableTreeNode HE_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.he.more.1500"));
        DefaultMutableTreeNode HE_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.he.500_1500"));
        deRitis1_Node.add(HE_Node_0);
        deRitis1_Node.add(HE_Node_1);

        GGTP_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.more.250"));
        GGTP_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.151_250"));
        DefaultMutableTreeNode GGTP_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.less.151"));
        HE_Node_0.add(GGTP_Node_0);
        HE_Node_0.add(GGTP_Node_1);
        HE_Node_0.add(GGTP_Node_2);

        GGTP_Node_0.add(add_SHF_Node_0());
        GGTP_Node_0.add(add_SHF_Node_1());

        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE"));
        GGTP_Node_1.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_NONSPECIFIC_REACTIVE"));
        GGTP_Node_2.add(result);

        GGTP_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.more.350"));
        GGTP_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.151_350"));
        GGTP_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp.less.151"));
        HE_Node_1.add(GGTP_Node_0);
        HE_Node_1.add(GGTP_Node_1);
        HE_Node_1.add(GGTP_Node_2);
        result = new DefaultMutableTreeNode(rb.getString("diseases.LIVER_METASTASES") + " ? " + rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");
        GGTP_Node_0.add(result);

        GGTP_Node_1.add(add_SHF_Node_0());
        GGTP_Node_1.add(add_SHF_Node_1());

        result = new DefaultMutableTreeNode(rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS"));
        GGTP_Node_2.add(result);

        return disease;
    }

    private DefaultMutableTreeNode add_HE_Node_0() {
        DefaultMutableTreeNode HE_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.he.2701_3750"));
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(rb.getString("diseases.FATTY_LIVER"));
        HE_Node_0.add(result);
        return HE_Node_0;
    }

    private DefaultMutableTreeNode add_HE_Node_1() {
        DefaultMutableTreeNode HE_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.he.1751_2700"));
        DefaultMutableTreeNode GLDG_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.gldg.more.10"));
        DefaultMutableTreeNode GLDG_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.gldg.0_10"));
        HE_Node_1.add(GLDG_Node_0);
        HE_Node_1.add(GLDG_Node_1);
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(rb.getString("diseases.OBSTRUCTIVE_JAUNDICE"));
        GLDG_Node_0.add(result);
        DefaultMutableTreeNode GGTP_AsT_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.more.3"));
        DefaultMutableTreeNode GGTP_AsT_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.1_3"));
        DefaultMutableTreeNode GGTP_AsT_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.less.3"));
        GLDG_Node_1.add(GGTP_AsT_Node_0);
        GLDG_Node_1.add(GGTP_AsT_Node_1);
        GLDG_Node_1.add(GGTP_AsT_Node_2);
        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC"));
        GGTP_AsT_Node_1.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");
        GGTP_AsT_Node_2.add(result);
        return HE_Node_1;
    }

    private DefaultMutableTreeNode add_HE_Node_2() {
        DefaultMutableTreeNode HE_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.he.1201-1750"));
        DefaultMutableTreeNode GGTP_AsT_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.more.1"));
        DefaultMutableTreeNode GGTP_AsT_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.0_1"));
        HE_Node_2.add(GGTP_AsT_Node_0);
        HE_Node_2.add(GGTP_AsT_Node_1);
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT") + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT"));
        GGTP_AsT_Node_1.add(result);
        return HE_Node_2;
    }

    private DefaultMutableTreeNode add_HE_Node_3() {
        DefaultMutableTreeNode HE_Node_3 = new DefaultMutableTreeNode(rb.getString("coefficients.he.500_1200"));
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(rb.getString("diseases.TOXIC_DAMAGE"));
        HE_Node_3.add(result);
        return HE_Node_3;
    }

    private DefaultMutableTreeNode add_SHF_Node_0() {
        DefaultMutableTreeNode SHF_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.shf.471_1500"));
        DefaultMutableTreeNode GLDG_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.gldg.11_75"));
        DefaultMutableTreeNode GLDG_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.gldg.0_10"));
        SHF_Node_0.add(GLDG_Node_0);
        SHF_Node_0.add(GLDG_Node_1);
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.more.10"));
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.0_10"));
        GLDG_Node_0.add(AsT_AlT_GLDG_Node_0);
        GLDG_Node_0.add(AsT_AlT_GLDG_Node_1);
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES") + " ? ");
        AsT_AlT_GLDG_Node_0.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES"));
        AsT_AlT_GLDG_Node_1.add(result);
        AsT_AlT_GLDG_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.more.20"));
        AsT_AlT_GLDG_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.5_20"));
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.ast_alt_gldg.less.5"));
        GLDG_Node_1.add(AsT_AlT_GLDG_Node_0);
        GLDG_Node_1.add(AsT_AlT_GLDG_Node_1);
        GLDG_Node_1.add(AsT_AlT_GLDG_Node_2);
        result = new DefaultMutableTreeNode(rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");
        AsT_AlT_GLDG_Node_0.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.CIRRHOSIS_BILIARY"));
        AsT_AlT_GLDG_Node_1.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");
        AsT_AlT_GLDG_Node_2.add(result);
        return SHF_Node_0;
    }

    private DefaultMutableTreeNode add_SHF_Node_1() {
        DefaultMutableTreeNode SHF_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.shf.80_470"));
        DefaultMutableTreeNode GGTP_AsT_Node_0 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.more.6"));
        DefaultMutableTreeNode GGTP_AsT_Node_1 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.3_6"));
        DefaultMutableTreeNode GGTP_AsT_Node_2 = new DefaultMutableTreeNode(rb.getString("coefficients.ggtp_ast.less.3"));
        SHF_Node_1.add(GGTP_AsT_Node_0);
        SHF_Node_1.add(GGTP_AsT_Node_1);
        SHF_Node_1.add(GGTP_AsT_Node_2);
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC"));
        GGTP_AsT_Node_1.add(result);
        result = new DefaultMutableTreeNode(rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");
        GGTP_AsT_Node_2.add(result);
        return SHF_Node_1;
    }

    public float[] getFloats(){
        return floats;
    }

    public boolean setFloats(){
        StringBuilder missed = new StringBuilder(rb.getString("errors.coefficients.missed"));
        StringBuilder wrong = new StringBuilder(rb.getString("errors.coefficients.wrong"));

        floats = new float[8];

        if (!astField.getText().equals("")){
            if (parseFloatFromString(astField.getText())){
                floats[0] = floatChecker;
            } else {
                wrong.append(" ");
                wrong.append(rb.getString("coefficients.ast"));
            }
        } else {
            missed.append(" ");
            missed.append(rb.getString("coefficients.ast"));
        }
        if (!altField.getText().equals("")){
            if (parseFloatFromString(altField.getText())){
                floats[1] = floatChecker;
            } else {
                wrong.append(" ");
                wrong.append(rb.getString("coefficients.alt"));
            }
        } else {
            missed.append(" ");
            missed.append(rb.getString("coefficients.alt"));
        }
        if (!kfkField.getText().equals("")){
            if (parseFloatFromString(kfkField.getText())){
                floats[2] = floatChecker;
            } else {
                wrong.append(" ");
                wrong.append(rb.getString("coefficients.kfk"));
            }
        } else {
            missed.append(" ");
            missed.append(rb.getString("coefficients.kfk"));
        }
        if (!ldgField.getText().equals("")){
            if (parseFloatFromString(ldgField.getText())){
                floats[3] = floatChecker;
            } else {
                wrong.append(" ");
                wrong.append(rb.getString("coefficients.ldg"));
            }
        } else {
            missed.append(" ");
            missed.append(rb.getString("coefficients.ldg"));
        }
        if (!shfField.getText().equals("")){
            if (parseFloatFromString(shfField.getText())){
                floats[4] = floatChecker;
            } else {
                wrong.append(" ");
                wrong.append(rb.getString("coefficients.shf"));
            }
        } else {
            missed.append(" ");
            missed.append(rb.getString("coefficients.shf"));
        }
        if (!ggtpField.getText().equals("")){
            if (parseFloatFromString(ggtpField.getText())){
                floats[5] = floatChecker;
            } else {
                wrong.append(" ");
                wrong.append(rb.getString("coefficients.ggtp"));
            }
        } else {
            missed.append(" ");
            missed.append(rb.getString("coefficients.ggtp"));
        }
        if (!heField.getText().equals("")){
            if (parseFloatFromString(heField.getText())){
                floats[6] = floatChecker;
            } else {
                wrong.append(" ");
                wrong.append(rb.getString("coefficients.he"));
            }
        } else {
            missed.append(" ");
            missed.append(rb.getString("coefficients.he"));
        }
        if (!gldgField.getText().equals("")){
            if (parseFloatFromString(gldgField.getText())){
                floats[7] = floatChecker;
            } else {
                wrong.append(" ");
                wrong.append(rb.getString("coefficients.gldg"));
            }
        } else {
            missed.append(" ");
            missed.append(rb.getString("coefficients.gldg"));
        }

        missedCoefficients = missed.toString();
        wrongCoefficients = wrong.toString();

        return missedCoefficients.equals(rb.getString("errors.coefficients.missed"))
                && wrongCoefficients.equals(rb.getString("errors.coefficients.wrong"));
    }

    private void addListeners(){
        doDiagnoseBtn.addActionListener(new TreeListener(this));
    }

    private boolean parseFloatFromString(String s){
        try {
            floatChecker = Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
