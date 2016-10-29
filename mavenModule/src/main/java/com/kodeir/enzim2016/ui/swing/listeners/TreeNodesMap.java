package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.commons.UTF8Control;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by rowan on 10/23/16.
 */
public class TreeNodesMap {

    private static ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private static Map<Integer,DefaultMutableTreeNode> injuredOrganMap = new HashMap<>();

    public static Map<Integer,DefaultMutableTreeNode> getInjuredOrganMap() {
        return injuredOrganMap;
    }

    private static Map<String,DefaultMutableTreeNode> diseaseMap = new HashMap<>();

    public static Map<String, DefaultMutableTreeNode> getDiseaseMap() {
        return diseaseMap;
    }

    private static DefaultMutableTreeNode injuredOrgan_LIVER_BILIARY_TRACT_ALT = new DefaultMutableTreeNode(
            rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"));

    private static DefaultMutableTreeNode injuredOrgan_SKELETAL_MUSCLE = new DefaultMutableTreeNode(
            rb.getString("organs.SKELETAL_MUSCLE"));

    private static DefaultMutableTreeNode injuredOrgan_HEART = new DefaultMutableTreeNode(
            rb.getString("organs.HEART"));

    private static DefaultMutableTreeNode injuredOrgan_BLOOD = new DefaultMutableTreeNode(
            rb.getString("organs.BLOOD"));

    private static DefaultMutableTreeNode injuredOrgan_LIVER_BILIARY_TRACT_GGTP = new DefaultMutableTreeNode(
            rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"));

    private static DefaultMutableTreeNode injuredOrgan_LIVER = new DefaultMutableTreeNode(
            rb.getString("organs.LIVER"));

    private static DefaultMutableTreeNode injuredOrgan_BONE_TISSUE = new DefaultMutableTreeNode(
            rb.getString("organs.BONE_TISSUE"));

    public static DefaultMutableTreeNode getInjuredOrgan_LIVER_BILIARY_TRACT_ALT() {
        return injuredOrgan_LIVER_BILIARY_TRACT_ALT;
    }

    public static DefaultMutableTreeNode getInjuredOrgan_SKELETAL_MUSCLE() {
        return injuredOrgan_SKELETAL_MUSCLE;
    }

    public static DefaultMutableTreeNode getInjuredOrgan_HEART() {
        return injuredOrgan_HEART;
    }

    public static DefaultMutableTreeNode getInjuredOrgan_BLOOD() {
        return injuredOrgan_BLOOD;
    }

    public static DefaultMutableTreeNode getInjuredOrgan_LIVER_BILIARY_TRACT_GGTP() {
        return injuredOrgan_LIVER_BILIARY_TRACT_GGTP;
    }

    public static DefaultMutableTreeNode getInjuredOrgan_LIVER() {
        return injuredOrgan_LIVER;
    }

    public static DefaultMutableTreeNode getInjuredOrgan_BONE_TISSUE() {
        return injuredOrgan_BONE_TISSUE;
    }

    static {
        injuredOrganMap.put(1, injuredOrgan_LIVER_BILIARY_TRACT_ALT);
        injuredOrganMap.put(2, injuredOrgan_BONE_TISSUE);
        injuredOrganMap.put(3, injuredOrgan_LIVER);
        injuredOrganMap.put(4, injuredOrgan_LIVER_BILIARY_TRACT_GGTP);
        injuredOrganMap.put(5, injuredOrgan_BLOOD);
        injuredOrganMap.put(6, injuredOrgan_HEART);
        injuredOrganMap.put(7, injuredOrgan_SKELETAL_MUSCLE);
    }

    private static DefaultMutableTreeNode disease_result_1 = new DefaultMutableTreeNode(
            rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS"));

    private static DefaultMutableTreeNode disease_result_2 = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? ");

    private static DefaultMutableTreeNode disease_result_3 = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE"));

    private static DefaultMutableTreeNode disease_result_4 = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? ");

    private static DefaultMutableTreeNode disease_result_5 = new DefaultMutableTreeNode(
            rb.getString("diseases.TOXIC_DAMAGE"));

    private static DefaultMutableTreeNode disease_result_6 = new DefaultMutableTreeNode(
            rb.getString("diseases.TOXIC_DAMAGE") + " ? ");

    private static DefaultMutableTreeNode disease_result_7 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_8 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_ALCOHOLIC"));

    private static DefaultMutableTreeNode disease_result_9 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_10 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_VIRAL") + " ? ");

    private static DefaultMutableTreeNode disease_result_11 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_VIRAL"));

    private static DefaultMutableTreeNode disease_result_12 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_VIRAL") + " ? ");

    private static DefaultMutableTreeNode disease_result_13 = new DefaultMutableTreeNode(
            rb.getString("diseases.FATTY_LIVER"));

    private static DefaultMutableTreeNode disease_result_14 = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE"));

    private static DefaultMutableTreeNode disease_result_15 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_16 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_result_17 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_18 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT") + " ? ");

    private static DefaultMutableTreeNode disease_result_19 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT"));

    private static DefaultMutableTreeNode disease_result_20 = new DefaultMutableTreeNode(
            rb.getString("diseases.TOXIC_DAMAGE"));

    private static DefaultMutableTreeNode disease_result_21 = new DefaultMutableTreeNode(
            rb.getString("diseases.FATTY_LIVER"));

    private static DefaultMutableTreeNode disease_result_22 = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE"));

    private static DefaultMutableTreeNode disease_result_23 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_24 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_result_25 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_26 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT") + " ? ");

    private static DefaultMutableTreeNode disease_result_27 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT"));

    private static DefaultMutableTreeNode disease_result_28 = new DefaultMutableTreeNode(
            rb.getString("diseases.TOXIC_DAMAGE"));

    private static DefaultMutableTreeNode disease_result_29 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE"));

    private static DefaultMutableTreeNode disease_result_30 = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES") + " ? ");

    private static DefaultMutableTreeNode disease_result_31 = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES"));

    private static DefaultMutableTreeNode disease_result_32 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_result_33 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY"));

    private static DefaultMutableTreeNode disease_result_34 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_result_35 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_36 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_result_37 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_38 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE"));

    private static DefaultMutableTreeNode disease_result_39 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_NONSPECIFIC_REACTIVE"));

    private static DefaultMutableTreeNode disease_result_40 = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTASES") + " ? " + " , " + rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_result_41 = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES") + " ? ");

    private static DefaultMutableTreeNode disease_result_42 = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES"));

    private static DefaultMutableTreeNode disease_result_43 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_result_44 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY"));

    private static DefaultMutableTreeNode disease_result_45 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_result_46 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_47 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_result_48 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_49 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS"));

    static {

    }
}
