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

package com.kodeir.enzim2016.ui.swing.tree;

import com.kodeir.enzim2016.thesaurus.Diseases;
import com.kodeir.enzim2016.thesaurus.Organs;
import com.kodeir.enzim2016.ui.swing.SwingCommons;
import com.kodeir.enzim2016.ui.swing.listeners.DiagnosesTreeListener;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Rowan on 03.07.2016.
 *
 */

//TODO get rid of spaghetti and get an xml
public class DiagnosesTree extends JPanel {

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
    private JLabel injuredOrgan;
    private JLabel disease;

    private JTree tree;

    private float floatChecker;
    private float[] floats;
    private String missedCoefficients;
    private String wrongCoefficients;

    public JButton getDoDiagnoseBtn() {
        return doDiagnoseBtn;
    }

    public void setInjuredOrgan(String s) {
        injuredOrgan.setText(s);
    }

    public void setDisease(String s) {
        disease.setText(s);
    }

    public String getMissedCoefficients() {
        return missedCoefficients;
    }

    public String getWrongCoefficients() {
        return wrongCoefficients;
    }

    public DiagnosesTree(){
        this.setLayout(new GridBagLayout());
        addFields();
        addResultButton();
        addResults();
        addTree();
        addListeners();
    }

    private void addFields(){
        label = new JLabel("АСТ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,0));
        label = new JLabel("АЛТ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,1,0));
        label = new JLabel("КФК");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,2,0));
        label = new JLabel("ЛДГ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,3,0));

        astField = new JTextField();
        this.add(astField, SwingCommons.setConstraintsHorizontal(0.5,0,1));
        altField = new JTextField();
        this.add(altField, SwingCommons.setConstraintsHorizontal(0.5,1,1));
        kfkField = new JTextField();
        this.add(kfkField, SwingCommons.setConstraintsHorizontal(0.5,2,1));
        ldgField = new JTextField();
        this.add(ldgField, SwingCommons.setConstraintsHorizontal(0.5,3,1));

        label = new JLabel("ЩФ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,2));
        label = new JLabel("ГГТП");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,1,2));
        label = new JLabel("ХЭ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,2,2));
        label = new JLabel("ГЛДГ");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,3,2));

        shfField = new JTextField();
        this.add(shfField, SwingCommons.setConstraintsHorizontal(0.5,0,3));
        ggtpField = new JTextField();
        this.add(ggtpField, SwingCommons.setConstraintsHorizontal(0.5,1,3));
        heField = new JTextField();
        this.add(heField, SwingCommons.setConstraintsHorizontal(0.5,2,3));
        gldgField = new JTextField();
        this.add(gldgField, SwingCommons.setConstraintsHorizontal(0.5,3,3));
    }

    private void addResultButton(){
        doDiagnoseBtn = new JButton("Диагностировать");
        this.add(doDiagnoseBtn, SwingCommons.setConstraintsHorizontal(0.5,1,4,2));
    }

    private void addResults(){
        label = new JLabel("Поверждённый орган:");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,5));
        injuredOrgan = new JLabel("");
        this.add(injuredOrgan, SwingCommons.setConstraintsHorizontal(0.5,1,5,3));

        label = new JLabel("Заболевание:");
        this.add(label, SwingCommons.setConstraintsHorizontal(0.5,0,6));
        disease = new JLabel("");
        this.add(disease, SwingCommons.setConstraintsHorizontal(0.5,1,6,3));

    }

    private void addTree(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        root.add(createInjuredOrganBranch());
        root.add(createDiseaseBranch());

        tree = new JTree(root);
        tree.setRootVisible(false);
        tree.setMinimumSize(new Dimension(1000,500));

        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setMinimumSize(new Dimension(1000,500));
        this.add(scrollPane, SwingCommons.setConstraintsHorizontal(0.5,0,7,4));
    }

    private DefaultMutableTreeNode createInjuredOrganBranch(){
        DefaultMutableTreeNode injuredOrgan = new DefaultMutableTreeNode("Повреждённый орган");

        DefaultMutableTreeNode AsT_Node = new DefaultMutableTreeNode("АСТ 41-150");
        injuredOrgan.add(AsT_Node);
        DefaultMutableTreeNode AlT_Node_0 = new DefaultMutableTreeNode("АлТ 41-250");
        DefaultMutableTreeNode AlT_Node_1 = new DefaultMutableTreeNode("АлТ 0-40");
        AsT_Node.add(AlT_Node_0);
        AsT_Node.add(AlT_Node_1);
        DefaultMutableTreeNode diagnose = new DefaultMutableTreeNode(Organs.LIVER_N_TRACT.getRu());
        AlT_Node_0.add(diagnose);
        DefaultMutableTreeNode KFK_Node_0 = new DefaultMutableTreeNode("КФК 501-1750");
        DefaultMutableTreeNode KFK_Node_1 = new DefaultMutableTreeNode("КФК 176-500");
        DefaultMutableTreeNode KFK_Node_2 = new DefaultMutableTreeNode("КФК 15-175");
        AlT_Node_1.add(KFK_Node_0);
        AlT_Node_1.add(KFK_Node_1);
        AlT_Node_1.add(KFK_Node_2);
        diagnose = new DefaultMutableTreeNode(Organs.SKELETAL_MUSCLE.getRu());
        KFK_Node_0.add(diagnose);
        diagnose = new DefaultMutableTreeNode(Organs.HEART.getRu());
        KFK_Node_1.add(diagnose);
        DefaultMutableTreeNode LDG_Node_0 = new DefaultMutableTreeNode("ЛДГ 591-2750");
        DefaultMutableTreeNode LDG_Node_1 = new DefaultMutableTreeNode("ЛДГ 150-590");
        KFK_Node_2.add(LDG_Node_0);
        KFK_Node_2.add(LDG_Node_1);
        diagnose = new DefaultMutableTreeNode(Organs.BLOOD.getRu());
        LDG_Node_0.add(diagnose);
        DefaultMutableTreeNode SHF_Node = new DefaultMutableTreeNode("ЩФ >80");
        LDG_Node_1.add(SHF_Node);
        DefaultMutableTreeNode GGTP_Node_0 = new DefaultMutableTreeNode("ГГТП 151-950");
        DefaultMutableTreeNode GGTP_Node_1 = new DefaultMutableTreeNode("ГГТП 51-150");
        DefaultMutableTreeNode GGTP_Node_2 = new DefaultMutableTreeNode("ГГТП 0-50");
        SHF_Node.add(GGTP_Node_0);
        SHF_Node.add(GGTP_Node_1);
        SHF_Node.add(GGTP_Node_2);
        diagnose = new DefaultMutableTreeNode(Organs.LIVER_N_TRACT.getRu());
        GGTP_Node_0.add(diagnose);
        diagnose = new DefaultMutableTreeNode(Organs.LIVER.getRu());
        GGTP_Node_1.add(diagnose);
        diagnose = new DefaultMutableTreeNode(Organs.BONE_TISSUE.getRu());
        GGTP_Node_2.add(diagnose);

        return injuredOrgan;
    }

    private DefaultMutableTreeNode createDiseaseBranch(){
        DefaultMutableTreeNode disease = new DefaultMutableTreeNode("Болезнь");

        DefaultMutableTreeNode AsT_Node = new DefaultMutableTreeNode("АСТ 41-150");
        disease.add(AsT_Node);

        DefaultMutableTreeNode deRitis01_05_Node = new DefaultMutableTreeNode("АсТ/АлТ 0.1-0.5");
        DefaultMutableTreeNode deRitis06_09_Node = new DefaultMutableTreeNode("АсТ/АлТ 0.6-0.9");
        DefaultMutableTreeNode deRitis1_Node = new DefaultMutableTreeNode("АсТ/АлТ > 1");

        AsT_Node.add(deRitis01_05_Node);
        AsT_Node.add(deRitis06_09_Node);
        AsT_Node.add(deRitis1_Node);

        DefaultMutableTreeNode LDG_Node_0 = new DefaultMutableTreeNode("ЛДГ 591-2750");
        DefaultMutableTreeNode LDG_Node_1 = new DefaultMutableTreeNode("ЛДГ 150-590");

        deRitis01_05_Node.add(LDG_Node_0);
        deRitis01_05_Node.add(LDG_Node_1);

        DefaultMutableTreeNode result = new DefaultMutableTreeNode(Diseases.INGECTIOUS_MONONUCLEOSIS.getRu());
        LDG_Node_0.add(result);

        DefaultMutableTreeNode SHF_Node_0 = new DefaultMutableTreeNode("ЩФ > 270");
        DefaultMutableTreeNode SHF_Node_1 = new DefaultMutableTreeNode("ЩФ 80-270");

        LDG_Node_1.add(SHF_Node_0);
        LDG_Node_1.add(SHF_Node_1);

        DefaultMutableTreeNode GLDG_Node_0 = new DefaultMutableTreeNode("ГЛДГ 11-75");
        DefaultMutableTreeNode GLDG_Node_1 = new DefaultMutableTreeNode("ГЛДГ 0-10");

        SHF_Node_0.add(GLDG_Node_0);
        SHF_Node_0.add(GLDG_Node_1);

        DefaultMutableTreeNode AsT_AlT_GLDG_Node_0 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ > 50");
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_1 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ 40-50");
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_2 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ < 40");

        GLDG_Node_0.add(AsT_AlT_GLDG_Node_0);
        GLDG_Node_0.add(AsT_AlT_GLDG_Node_1);
        GLDG_Node_0.add(AsT_AlT_GLDG_Node_2);

        result = new DefaultMutableTreeNode(Diseases.OBSTRUCTIVE_JAUNDICE.getRu() + " ? ");
        AsT_AlT_GLDG_Node_0.add(result);
        result = new DefaultMutableTreeNode(Diseases.OBSTRUCTIVE_JAUNDICE.getRu());
        AsT_AlT_GLDG_Node_1.add(result);
        result = new DefaultMutableTreeNode(Diseases.OBSTRUCTIVE_JAUNDICE.getRu() + " ? ");
        AsT_AlT_GLDG_Node_2.add(result);

        AsT_AlT_GLDG_Node_0 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ > 50");
        AsT_AlT_GLDG_Node_1 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ <= 50");

        GLDG_Node_1.add(AsT_AlT_GLDG_Node_0);
        GLDG_Node_1.add(AsT_AlT_GLDG_Node_1);

        result = new DefaultMutableTreeNode(Diseases.TOXIC_DAMAGE.getRu());
        AsT_AlT_GLDG_Node_0.add(result);
        result = new DefaultMutableTreeNode(Diseases.TOXIC_DAMAGE.getRu() + " ? ");
        AsT_AlT_GLDG_Node_1.add(result);

        DefaultMutableTreeNode GGTP_Node_0 = new DefaultMutableTreeNode("ГГТП > 150");
        DefaultMutableTreeNode GGTP_Node_1 = new DefaultMutableTreeNode("ГГТП <= 150");

        SHF_Node_1.add(GGTP_Node_0);
        SHF_Node_1.add(GGTP_Node_1);

        DefaultMutableTreeNode GGTP_AsT_Node_0 = new DefaultMutableTreeNode("ГГТП/АСТ > 6");
        DefaultMutableTreeNode GGTP_AsT_Node_1 = new DefaultMutableTreeNode("ГГТП/АСТ 3-6");
        DefaultMutableTreeNode GGTP_AsT_Node_2 = new DefaultMutableTreeNode("ГГТП/АСТ < 3");

        GGTP_Node_0.add(GGTP_AsT_Node_0);
        GGTP_Node_0.add(GGTP_AsT_Node_1);
        GGTP_Node_0.add(GGTP_AsT_Node_2);

        result = new DefaultMutableTreeNode(Diseases.ALCOHOLIC_HEPATITIS.getRu() + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(Diseases.ALCOHOLIC_HEPATITIS.getRu());
        GGTP_AsT_Node_1.add(result);
        result = new DefaultMutableTreeNode(Diseases.ALCOHOLIC_HEPATITIS.getRu() + " ? ");
        GGTP_AsT_Node_2.add(result);

        GGTP_AsT_Node_0 = new DefaultMutableTreeNode("ГГТП/АСТ > 3");
        GGTP_AsT_Node_1 = new DefaultMutableTreeNode("ГГТП/АСТ 1-3");
        GGTP_AsT_Node_2 = new DefaultMutableTreeNode("ГГТП/АСТ <1");

        GGTP_Node_1.add(GGTP_AsT_Node_0);
        GGTP_Node_1.add(GGTP_AsT_Node_1);
        GGTP_Node_1.add(GGTP_AsT_Node_2);

        result = new DefaultMutableTreeNode(Diseases.VIRAL_HEPATITIS.getRu() + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(Diseases.VIRAL_HEPATITIS.getRu());
        GGTP_AsT_Node_1.add(result);
        result = new DefaultMutableTreeNode(Diseases.VIRAL_HEPATITIS.getRu() + " ? ");
        GGTP_AsT_Node_2.add(result);

        // de ritis 0.6-0.9

        SHF_Node_0 = new DefaultMutableTreeNode("ЩФ 371-1500");
        SHF_Node_1 = new DefaultMutableTreeNode("ЩФ 80-370");

        deRitis06_09_Node.add(SHF_Node_0);
        deRitis06_09_Node.add(SHF_Node_1);

        SHF_Node_0.add(add_HE_Node_0());
        SHF_Node_0.add(add_HE_Node_1());
        SHF_Node_0.add(add_HE_Node_2());
        SHF_Node_0.add(add_HE_Node_3());

        GGTP_Node_0 = new DefaultMutableTreeNode("ГГТП > 11");
        GGTP_Node_1 = new DefaultMutableTreeNode("ГГТП 0-10");
        SHF_Node_1.add(GGTP_Node_0);
        SHF_Node_1.add(GGTP_Node_1);

        GGTP_Node_0.add(add_HE_Node_0());
        GGTP_Node_0.add(add_HE_Node_1());
        GGTP_Node_0.add(add_HE_Node_2());
        GGTP_Node_0.add(add_HE_Node_3());

        result = new DefaultMutableTreeNode(Diseases.CHRONIC_PERSISTENT_HEPATITIS.getRu());
        GGTP_Node_1.add(result);

        // deRitis 1

        DefaultMutableTreeNode HE_Node_0 = new DefaultMutableTreeNode("ХЭ > 1500");
        DefaultMutableTreeNode HE_Node_1 = new DefaultMutableTreeNode("ХЭ 500-1500");
        deRitis1_Node.add(HE_Node_0);
        deRitis1_Node.add(HE_Node_1);

        GGTP_Node_0 = new DefaultMutableTreeNode("ГГТП > 250");
        GGTP_Node_1 = new DefaultMutableTreeNode("ГГТП 151-250");
        DefaultMutableTreeNode GGTP_Node_2 = new DefaultMutableTreeNode("ГГТП < 151");
        HE_Node_0.add(GGTP_Node_0);
        HE_Node_0.add(GGTP_Node_1);
        HE_Node_0.add(GGTP_Node_2);

        GGTP_Node_0.add(add_SHF_Node_0());
        GGTP_Node_0.add(add_SHF_Node_1());

        result = new DefaultMutableTreeNode(Diseases.CHRONIC_AGGRESSIVE_HEPATITIS.getRu());
        GGTP_Node_1.add(result);
        result = new DefaultMutableTreeNode(Diseases.NONSPECIFIC_REACTIVE_HEPATITIS.getRu());
        GGTP_Node_2.add(result);

        GGTP_Node_0 = new DefaultMutableTreeNode("ГГТП > 350");
        GGTP_Node_1 = new DefaultMutableTreeNode("ГГТП 151-350");
        GGTP_Node_2 = new DefaultMutableTreeNode("ГГТП < 151");
        HE_Node_1.add(GGTP_Node_0);
        HE_Node_1.add(GGTP_Node_1);
        HE_Node_1.add(GGTP_Node_2);
        result = new DefaultMutableTreeNode(Diseases.LIVER_METASTASES.getRu() + " ? " + Diseases.BILIARY_CIRRHOSIS.getRu() + " ? ");
        GGTP_Node_0.add(result);

        GGTP_Node_1.add(add_SHF_Node_0());
        GGTP_Node_1.add(add_SHF_Node_1());

        result = new DefaultMutableTreeNode(Diseases.POSTHEPATITIS_CIRRHOSIS.getRu());
        GGTP_Node_2.add(result);

        return disease;
    }

    private DefaultMutableTreeNode add_HE_Node_0() {
        DefaultMutableTreeNode HE_Node_0 = new DefaultMutableTreeNode("ХЭ 2701-3750");
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(Diseases.FATTY_LIVER.getRu());
        HE_Node_0.add(result);
        return HE_Node_0;
    }

    private DefaultMutableTreeNode add_HE_Node_1() {
        DefaultMutableTreeNode HE_Node_1 = new DefaultMutableTreeNode("ХЭ 1751-2700");
        DefaultMutableTreeNode GLDG_Node_0 = new DefaultMutableTreeNode("ГЛДГ > 10");
        DefaultMutableTreeNode GLDG_Node_1 = new DefaultMutableTreeNode("ГЛДГ 0-10");
        HE_Node_1.add(GLDG_Node_0);
        HE_Node_1.add(GLDG_Node_1);
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(Diseases.OBSTRUCTIVE_JAUNDICE.getRu());
        GLDG_Node_0.add(result);
        DefaultMutableTreeNode GGTP_AsT_Node_0 = new DefaultMutableTreeNode("ГГТП/АСТ > 3");
        DefaultMutableTreeNode GGTP_AsT_Node_1 = new DefaultMutableTreeNode("ГГТП/АСТ 1-3");
        DefaultMutableTreeNode GGTP_AsT_Node_2 = new DefaultMutableTreeNode("ГГТП/АСТ <1");
        GLDG_Node_1.add(GGTP_AsT_Node_0);
        GLDG_Node_1.add(GGTP_AsT_Node_1);
        GLDG_Node_1.add(GGTP_AsT_Node_2);
        result = new DefaultMutableTreeNode(Diseases.CHRONIC_ALCOHOLIC_TOXIC_HEPATITIS.getRu() + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(Diseases.CHRONIC_ALCOHOLIC_TOXIC_HEPATITIS.getRu());
        GGTP_AsT_Node_1.add(result);
        result = new DefaultMutableTreeNode(Diseases.CHRONIC_ALCOHOLIC_TOXIC_HEPATITIS.getRu() + " ? ");
        GGTP_AsT_Node_2.add(result);
        return HE_Node_1;
    }

    private DefaultMutableTreeNode add_HE_Node_2() {
        DefaultMutableTreeNode HE_Node_2 = new DefaultMutableTreeNode("ХЭ 1201-1750");
        DefaultMutableTreeNode GGTP_AsT_Node_0 = new DefaultMutableTreeNode("ГГТП/АСТ > 1");
        DefaultMutableTreeNode GGTP_AsT_Node_1 = new DefaultMutableTreeNode("ГГТП/АСТ 0-1");
        HE_Node_2.add(GGTP_AsT_Node_0);
        HE_Node_2.add(GGTP_AsT_Node_1);
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(Diseases.CHRONIC_PERSISTENT_HEPATITIS.getRu() + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(Diseases.CHRONIC_PERSISTENT_HEPATITIS.getRu());
        GGTP_AsT_Node_1.add(result);
        return HE_Node_2;
    }

    private DefaultMutableTreeNode add_HE_Node_3() {
        DefaultMutableTreeNode HE_Node_3 = new DefaultMutableTreeNode("ХЭ 500-1200");
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(Diseases.TOXIC_DAMAGE.getRu());
        HE_Node_3.add(result);
        return HE_Node_3;
    }

    private DefaultMutableTreeNode add_SHF_Node_0() {
        DefaultMutableTreeNode SHF_Node_0 = new DefaultMutableTreeNode("ЩФ 471-1500");
        DefaultMutableTreeNode GLDG_Node_0 = new DefaultMutableTreeNode("ГЛДГ 11-75");
        DefaultMutableTreeNode GLDG_Node_1 = new DefaultMutableTreeNode("ГЛДГ 0-10");
        SHF_Node_0.add(GLDG_Node_0);
        SHF_Node_0.add(GLDG_Node_1);
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_0 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ > 10");
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_1 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ 0-10");
        GLDG_Node_0.add(AsT_AlT_GLDG_Node_0);
        GLDG_Node_0.add(AsT_AlT_GLDG_Node_1);
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(Diseases.LIVER_METASTATIC_TUMOR_NODULES.getRu() + " ? ");
        AsT_AlT_GLDG_Node_0.add(result);
        result = new DefaultMutableTreeNode(Diseases.LIVER_METASTATIC_TUMOR_NODULES.getRu());
        AsT_AlT_GLDG_Node_1.add(result);
        AsT_AlT_GLDG_Node_0 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ > 20");
        AsT_AlT_GLDG_Node_1 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ 5-20");
        DefaultMutableTreeNode AsT_AlT_GLDG_Node_2 = new DefaultMutableTreeNode("(АСТ + АЛТ) / ГЛДГ < 5");
        GLDG_Node_1.add(AsT_AlT_GLDG_Node_0);
        GLDG_Node_1.add(AsT_AlT_GLDG_Node_1);
        GLDG_Node_1.add(AsT_AlT_GLDG_Node_2);
        result = new DefaultMutableTreeNode(Diseases.BILIARY_CIRRHOSIS.getRu() + " ? ");
        AsT_AlT_GLDG_Node_0.add(result);
        result = new DefaultMutableTreeNode(Diseases.BILIARY_CIRRHOSIS.getRu());
        AsT_AlT_GLDG_Node_1.add(result);
        result = new DefaultMutableTreeNode(Diseases.BILIARY_CIRRHOSIS.getRu() + " ? ");
        AsT_AlT_GLDG_Node_2.add(result);
        return SHF_Node_0;
    }

    private DefaultMutableTreeNode add_SHF_Node_1() {
        DefaultMutableTreeNode SHF_Node_1 = new DefaultMutableTreeNode("ЩФ 80-470");
        DefaultMutableTreeNode GGTP_AsT_Node_0 = new DefaultMutableTreeNode("ГГТП/АСТ > 6");
        DefaultMutableTreeNode GGTP_AsT_Node_1 = new DefaultMutableTreeNode("ГГТП/АСТ 3-6");
        DefaultMutableTreeNode GGTP_AsT_Node_2 = new DefaultMutableTreeNode("ГГТП/АСТ < 3");
        SHF_Node_1.add(GGTP_AsT_Node_0);
        SHF_Node_1.add(GGTP_AsT_Node_1);
        SHF_Node_1.add(GGTP_AsT_Node_2);
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(Diseases.ALCOHOLIC_TOXIC_CIRRHOSIS.getRu() + " ? ");
        GGTP_AsT_Node_0.add(result);
        result = new DefaultMutableTreeNode(Diseases.ALCOHOLIC_TOXIC_CIRRHOSIS.getRu());
        GGTP_AsT_Node_1.add(result);
        result = new DefaultMutableTreeNode(Diseases.ALCOHOLIC_TOXIC_CIRRHOSIS.getRu() + " ? ");
        GGTP_AsT_Node_2.add(result);
        return SHF_Node_1;
    }

    public float[] getFloats(){
        return floats;
    }

    public boolean setFloats(){
        StringBuffer missed = new StringBuffer("Не введены следущюие коэффициенты: ");
        StringBuffer wrong = new StringBuffer("Для следующих коэффициентов введено неверное значение: ");

        floats = new float[8];
        float checker;

        if (!astField.getText().equals("")){
            if (parseFloatFromString(astField.getText())){
                floats[0] = floatChecker;
            } else {
                wrong.append(" АСТ");
            }
        } else {
            missed.append(" АСТ");
        }
        if (!altField.getText().equals("")){
            if (parseFloatFromString(altField.getText())){
                floats[1] = floatChecker;
            } else {
                wrong.append(" АЛТ");
            }
        } else {
            missed.append(" АЛТ");
        }
        if (!kfkField.getText().equals("")){
            if (parseFloatFromString(kfkField.getText())){
                floats[2] = floatChecker;
            } else {
                wrong.append(" КФК");
            }
        } else {
            missed.append(" КФК");
        }
        if (!ldgField.getText().equals("")){
            if (parseFloatFromString(ldgField.getText())){
                floats[3] = floatChecker;
            } else {
                wrong.append(" ЛДГ");
            }
        } else {
            missed.append(" ЛДГ");
        }
        if (!shfField.getText().equals("")){
            if (parseFloatFromString(shfField.getText())){
                floats[4] = floatChecker;
            } else {
                wrong.append(" ЩФ");
            }
        } else {
            missed.append(" ЩФ");
        }
        if (!ggtpField.getText().equals("")){
            if (parseFloatFromString(ggtpField.getText())){
                floats[5] = floatChecker;
            } else {
                wrong.append(" ГГТП");
            }
        } else {
            missed.append(" ГГТП");
        }
        if (!heField.getText().equals("")){
            if (parseFloatFromString(heField.getText())){
                floats[6] = floatChecker;
            } else {
                wrong.append(" ХЭ");
            }
        } else {
            missed.append(" ХЭ");
        }
        if (!gldgField.getText().equals("")){
            if (parseFloatFromString(gldgField.getText())){
                floats[7] = floatChecker;
            } else {
                wrong.append(" ГЛДГ");
            }
        } else {
            missed.append(" ГЛДГ");
        }

        missedCoefficients = missed.toString();
        wrongCoefficients = wrong.toString();

        if (!missedCoefficients.equals("Не введены следущюие коэффициенты: ") || !wrongCoefficients.equals("Для следующих коэффициентов введено неверное значение: ")){
            return false;
        } else {
            return true;
        }
    }

    public void addListeners(){
        doDiagnoseBtn.addActionListener(new DiagnosesTreeListener(this));
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
