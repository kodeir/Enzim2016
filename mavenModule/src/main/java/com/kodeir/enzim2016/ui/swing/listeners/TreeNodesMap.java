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

    private static Map<String,DefaultMutableTreeNode> treeNodeMap = new HashMap<>();

    private static DefaultMutableTreeNode injuredOrgan_diagnose_1 = new DefaultMutableTreeNode(
            rb.getString("organs.LIVER")
                    + rb.getString("organs.BILIARY_TRACT"));

    private static DefaultMutableTreeNode injuredOrgan_diagnose_2 = new DefaultMutableTreeNode(
            rb.getString("organs.SKELETAL_MUSCLE"));

    private static DefaultMutableTreeNode injuredOrgan_diagnose_3 = new DefaultMutableTreeNode(
            rb.getString("organs.HEART"));

    private static DefaultMutableTreeNode injuredOrgan_diagnose_4 = new DefaultMutableTreeNode(
            rb.getString("organs.BLOOD"));

    private static DefaultMutableTreeNode injuredOrgan_diagnose_5 = new DefaultMutableTreeNode(
            rb.getString("organs.LIVER")
                    + rb.getString("organs.BILIARY_TRACT"));

    private static DefaultMutableTreeNode injuredOrgan_diagnose_6 = new DefaultMutableTreeNode(
            rb.getString("organs.LIVER"));

    private static DefaultMutableTreeNode injuredOrgan_diagnose_7 = new DefaultMutableTreeNode(
            rb.getString("organs.BONE_TISSUE"));

    static {
        treeNodeMap.put(rb.getString("organs.LIVER") + rb.getString("organs.BILIARY_TRACT")
                ,injuredOrgan_diagnose_1);
        treeNodeMap.put(rb.getString("organs.SKELETAL_MUSCLE")
                ,injuredOrgan_diagnose_2);
        treeNodeMap.put(rb.getString("organs.HEART")
                ,injuredOrgan_diagnose_3);
        treeNodeMap.put(rb.getString("organs.BLOOD")
                ,injuredOrgan_diagnose_4);
        treeNodeMap.put(rb.getString("organs.LIVER") + rb.getString("organs.BILIARY_TRACT")
                ,injuredOrgan_diagnose_5);
        treeNodeMap.put(rb.getString("organs.LIVER")
                ,injuredOrgan_diagnose_6);
        treeNodeMap.put(rb.getString("organs.BONE_TISSUE")
                ,injuredOrgan_diagnose_7);
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
            rb.getString("diseases.HEPATITIS_CHRONIC"));

    private static DefaultMutableTreeNode disease_result_14 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE"));

    private static DefaultMutableTreeNode disease_result_15 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_NONSPECIFIC_REACTIVE"));

    private static DefaultMutableTreeNode disease_result_16 = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTASES"));

    private static DefaultMutableTreeNode disease_result_17 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS"));

    private static DefaultMutableTreeNode disease_result_18 = new DefaultMutableTreeNode(
            rb.getString("diseases.FATTY_LIVER"));

    private static DefaultMutableTreeNode disease_result_19 = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE"));

    private static DefaultMutableTreeNode disease_result_20 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_21 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_result_22 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_23 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT") + " ? ");

    private static DefaultMutableTreeNode disease_result_24 = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT"));

    private static DefaultMutableTreeNode disease_result_25 = new DefaultMutableTreeNode(
            rb.getString("diseases.TOXIC_DAMAGE"));

    private static DefaultMutableTreeNode disease_result_26 = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES") + " ? ");

    private static DefaultMutableTreeNode disease_result_27 = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES"));

    private static DefaultMutableTreeNode disease_result_28 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_result_29 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY"));

    private static DefaultMutableTreeNode disease_result_30 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_result_31 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_result_32 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_result_33 = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    static {
        treeNodeMap.put(rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS")
                ,disease_result_1);
        treeNodeMap.put(rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? "
                ,disease_result_2);
        treeNodeMap.put(rb.getString("diseases.OBSTRUCTIVE_JAUNDICE")
                ,disease_result_3);
        treeNodeMap.put(rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? "
                ,disease_result_4);
        treeNodeMap.put(rb.getString("diseases.TOXIC_DAMAGE")
                ,disease_result_5);
        treeNodeMap.put(rb.getString("diseases.TOXIC_DAMAGE") + " ? "
                ,disease_result_6);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? "
                ,disease_result_7);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_ALCOHOLIC")
                ,disease_result_8);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? "
                ,disease_result_9);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_VIRAL") + " ? "
                ,disease_result_10);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_VIRAL")
                ,disease_result_11);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_VIRAL") + " ? "
                ,disease_result_12);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_CHRONIC")
                ,disease_result_13);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE")
                ,disease_result_14);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_NONSPECIFIC_REACTIVE")
                ,disease_result_15);
        treeNodeMap.put(rb.getString("diseases.LIVER_METASTASES")
                ,disease_result_16);
        treeNodeMap.put(rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")
                ,disease_result_17);
        treeNodeMap.put(rb.getString("diseases.FATTY_LIVER")
                ,disease_result_18);
        treeNodeMap.put(rb.getString("diseases.OBSTRUCTIVE_JAUNDICE")
                ,disease_result_19);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? "
                ,disease_result_20);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC")
                ,disease_result_21);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? "
                ,disease_result_22);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT") + " ? "
                ,disease_result_23);
        treeNodeMap.put(rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT")
                ,disease_result_24);
        treeNodeMap.put(rb.getString("diseases.TOXIC_DAMAGE")
                ,disease_result_25);
        treeNodeMap.put(rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES") + " ? "
                ,disease_result_26);
        treeNodeMap.put(rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES")
                ,disease_result_27);
        treeNodeMap.put(rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? "
                ,disease_result_28);
        treeNodeMap.put(rb.getString("diseases.CIRRHOSIS_BILIARY")
                ,disease_result_29);
        treeNodeMap.put(rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? "
                ,disease_result_30);
        treeNodeMap.put(rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? "
                ,disease_result_31);
        treeNodeMap.put(rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC")
                ,disease_result_32);
        treeNodeMap.put(rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? "
                ,disease_result_33);
    }
}
