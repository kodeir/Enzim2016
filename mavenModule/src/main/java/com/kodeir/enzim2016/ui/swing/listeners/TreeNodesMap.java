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

    private static Map<Integer,DefaultMutableTreeNode> diseaseMap = new HashMap<>();

    public static Map<Integer, DefaultMutableTreeNode> getDiseaseMap() {
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

    private static DefaultMutableTreeNode disease_1_MONONUCLEOSIS_INFECTIOUS = new DefaultMutableTreeNode(
            rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS"));

    private static DefaultMutableTreeNode disease_2_OBSTRUCTIVE_JAUNDICE = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? ");

    private static DefaultMutableTreeNode disease_3_OBSTRUCTIVE_JAUNDICE = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE"));

    private static DefaultMutableTreeNode disease_4_OBSTRUCTIVE_JAUNDICE = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? ");

    private static DefaultMutableTreeNode disease_5_TOXIC_DAMAGE = new DefaultMutableTreeNode(
            rb.getString("diseases.TOXIC_DAMAGE"));

    private static DefaultMutableTreeNode disease_6_TOXIC_DAMAGE = new DefaultMutableTreeNode(
            rb.getString("diseases.TOXIC_DAMAGE") + " ? ");

    private static DefaultMutableTreeNode disease_7_HEPATITIS_ALCOHOLIC = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? ");

    private static DefaultMutableTreeNode disease_8_HEPATITIS_ALCOHOLIC = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_ALCOHOLIC"));

    private static DefaultMutableTreeNode disease_9_HEPATITIS_ALCOHOLIC = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? ");

    private static DefaultMutableTreeNode disease_10_HEPATITIS_VIRAL = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_VIRAL") + " ? ");

    private static DefaultMutableTreeNode disease_11_HEPATITIS_VIRAL = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_VIRAL"));

    private static DefaultMutableTreeNode disease_12_HEPATITIS_VIRAL = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_VIRAL") + " ? ");

    private static DefaultMutableTreeNode disease_13_FATTY_LIVER = new DefaultMutableTreeNode(
            rb.getString("diseases.FATTY_LIVER"));

    private static DefaultMutableTreeNode disease_14_OBSTRUCTIVE_JAUNDICE = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE"));

    private static DefaultMutableTreeNode disease_15_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_16_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_17_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_18_HEPATITIS_CHRONIC_PERSISTENT = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT") + " ? ");

    private static DefaultMutableTreeNode disease_19_HEPATITIS_CHRONIC_PERSISTENT = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT"));

    private static DefaultMutableTreeNode disease_20_TOXIC_DAMAGE = new DefaultMutableTreeNode(
            rb.getString("diseases.TOXIC_DAMAGE"));

    private static DefaultMutableTreeNode disease_21_FATTY_LIVER = new DefaultMutableTreeNode(
            rb.getString("diseases.FATTY_LIVER"));

    private static DefaultMutableTreeNode disease_22_OBSTRUCTIVE_JAUNDICE = new DefaultMutableTreeNode(
            rb.getString("diseases.OBSTRUCTIVE_JAUNDICE"));

    private static DefaultMutableTreeNode disease_23_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_24_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_25_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_26_HEPATITIS_CHRONIC_PERSISTENT = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT") + " ? ");

    private static DefaultMutableTreeNode disease_27_HEPATITIS_CHRONIC_PERSISTENT = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT"));

    private static DefaultMutableTreeNode disease_28_TOXIC_DAMAGE = new DefaultMutableTreeNode(
            rb.getString("diseases.TOXIC_DAMAGE"));

    private static DefaultMutableTreeNode disease_29_HEPATITIS_CHRONIC_AGGRESSIVE = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE"));

    private static DefaultMutableTreeNode disease_30_LIVER_METASTATIC_TUMOR_NODULES = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES") + " ? ");

    private static DefaultMutableTreeNode disease_31_LIVER_METASTATIC_TUMOR_NODULES = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES"));

    private static DefaultMutableTreeNode disease_32_CIRRHOSIS_BILIARY = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_33_CIRRHOSIS_BILIARY = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY"));

    private static DefaultMutableTreeNode disease_34_CIRRHOSIS_BILIARY = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_35_CIRRHOSIS_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_36_CIRRHOSIS_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_37_CIRRHOSIS_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_38_HEPATITIS_CHRONIC_AGGRESSIVE = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE"));

    private static DefaultMutableTreeNode disease_39_HEPATITIS_NONSPECIFIC_REACTIVE = new DefaultMutableTreeNode(
            rb.getString("diseases.HEPATITIS_NONSPECIFIC_REACTIVE"));

    private static DefaultMutableTreeNode disease_40_LIVER_METASTASES_CIRRHOSIS_BILIARY = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTASES") + " ? " + " , " + rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_41_LIVER_METASTATIC_TUMOR_NODULES = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES") + " ? ");

    private static DefaultMutableTreeNode disease_42_LIVER_METASTATIC_TUMOR_NODULES = new DefaultMutableTreeNode(
            rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES"));

    private static DefaultMutableTreeNode disease_43_CIRRHOSIS_BILIARY = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_44_CIRRHOSIS_BILIARY = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY"));

    private static DefaultMutableTreeNode disease_45_CIRRHOSIS_BILIARY = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ");

    private static DefaultMutableTreeNode disease_46_CIRRHOSIS_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_47_CIRRHOSIS_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC"));

    private static DefaultMutableTreeNode disease_48_CIRRHOSIS_ALCOHOLIC_TOXIC = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ");

    private static DefaultMutableTreeNode disease_49_CIRRHOSIS_POSTHEPATITIS = new DefaultMutableTreeNode(
            rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS"));

    public static DefaultMutableTreeNode getDisease_1_MONONUCLEOSIS_INFECTIOUS() {
        return disease_1_MONONUCLEOSIS_INFECTIOUS;
    }

    public static DefaultMutableTreeNode getDisease_2_OBSTRUCTIVE_JAUNDICE() {
        return disease_2_OBSTRUCTIVE_JAUNDICE;
    }

    public static DefaultMutableTreeNode getDisease_3_OBSTRUCTIVE_JAUNDICE() {
        return disease_3_OBSTRUCTIVE_JAUNDICE;
    }

    public static DefaultMutableTreeNode getDisease_4_OBSTRUCTIVE_JAUNDICE() {
        return disease_4_OBSTRUCTIVE_JAUNDICE;
    }

    public static DefaultMutableTreeNode getDisease_5_TOXIC_DAMAGE() {
        return disease_5_TOXIC_DAMAGE;
    }

    public static DefaultMutableTreeNode getDisease_6_TOXIC_DAMAGE() {
        return disease_6_TOXIC_DAMAGE;
    }

    public static DefaultMutableTreeNode getDisease_7_HEPATITIS_ALCOHOLIC() {
        return disease_7_HEPATITIS_ALCOHOLIC;
    }

    public static DefaultMutableTreeNode getDisease_8_HEPATITIS_ALCOHOLIC() {
        return disease_8_HEPATITIS_ALCOHOLIC;
    }

    public static DefaultMutableTreeNode getDisease_9_HEPATITIS_ALCOHOLIC() {
        return disease_9_HEPATITIS_ALCOHOLIC;
    }

    public static DefaultMutableTreeNode getDisease_10_HEPATITIS_VIRAL() {
        return disease_10_HEPATITIS_VIRAL;
    }

    public static DefaultMutableTreeNode getDisease_11_HEPATITIS_VIRAL() {
        return disease_11_HEPATITIS_VIRAL;
    }

    public static DefaultMutableTreeNode getDisease_12_HEPATITIS_VIRAL() {
        return disease_12_HEPATITIS_VIRAL;
    }

    public static DefaultMutableTreeNode getDisease_13_FATTY_LIVER() {
        return disease_13_FATTY_LIVER;
    }

    public static DefaultMutableTreeNode getDisease_14_OBSTRUCTIVE_JAUNDICE() {
        return disease_14_OBSTRUCTIVE_JAUNDICE;
    }

    public static DefaultMutableTreeNode getDisease_15_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC() {
        return disease_15_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_16_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC() {
        return disease_16_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_17_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC() {
        return disease_17_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_18_HEPATITIS_CHRONIC_PERSISTENT() {
        return disease_18_HEPATITIS_CHRONIC_PERSISTENT;
    }

    public static DefaultMutableTreeNode getDisease_19_HEPATITIS_CHRONIC_PERSISTENT() {
        return disease_19_HEPATITIS_CHRONIC_PERSISTENT;
    }

    public static DefaultMutableTreeNode getDisease_20_TOXIC_DAMAGE() {
        return disease_20_TOXIC_DAMAGE;
    }

    public static DefaultMutableTreeNode getDisease_21_FATTY_LIVER() {
        return disease_21_FATTY_LIVER;
    }

    public static DefaultMutableTreeNode getDisease_22_OBSTRUCTIVE_JAUNDICE() {
        return disease_22_OBSTRUCTIVE_JAUNDICE;
    }

    public static DefaultMutableTreeNode getDisease_23_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC() {
        return disease_23_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_24_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC() {
        return disease_24_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_25_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC() {
        return disease_25_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_26_HEPATITIS_CHRONIC_PERSISTENT() {
        return disease_26_HEPATITIS_CHRONIC_PERSISTENT;
    }

    public static DefaultMutableTreeNode getDisease_27_HEPATITIS_CHRONIC_PERSISTENT() {
        return disease_27_HEPATITIS_CHRONIC_PERSISTENT;
    }

    public static DefaultMutableTreeNode getDisease_28_TOXIC_DAMAGE() {
        return disease_28_TOXIC_DAMAGE;
    }

    public static DefaultMutableTreeNode getDisease_29_HEPATITIS_CHRONIC_AGGRESSIVE() {
        return disease_29_HEPATITIS_CHRONIC_AGGRESSIVE;
    }

    public static DefaultMutableTreeNode getDisease_30_LIVER_METASTATIC_TUMOR_NODULES() {
        return disease_30_LIVER_METASTATIC_TUMOR_NODULES;
    }

    public static DefaultMutableTreeNode getDisease_31_LIVER_METASTATIC_TUMOR_NODULES() {
        return disease_31_LIVER_METASTATIC_TUMOR_NODULES;
    }

    public static DefaultMutableTreeNode getDisease_32_CIRRHOSIS_BILIARY() {
        return disease_32_CIRRHOSIS_BILIARY;
    }

    public static DefaultMutableTreeNode getDisease_33_CIRRHOSIS_BILIARY() {
        return disease_33_CIRRHOSIS_BILIARY;
    }

    public static DefaultMutableTreeNode getDisease_34_CIRRHOSIS_BILIARY() {
        return disease_34_CIRRHOSIS_BILIARY;
    }

    public static DefaultMutableTreeNode getDisease_35_CIRRHOSIS_ALCOHOLIC_TOXIC() {
        return disease_35_CIRRHOSIS_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_36_CIRRHOSIS_ALCOHOLIC_TOXIC() {
        return disease_36_CIRRHOSIS_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_37_CIRRHOSIS_ALCOHOLIC_TOXIC() {
        return disease_37_CIRRHOSIS_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_38_HEPATITIS_CHRONIC_AGGRESSIVE() {
        return disease_38_HEPATITIS_CHRONIC_AGGRESSIVE;
    }

    public static DefaultMutableTreeNode getDisease_39_HEPATITIS_NONSPECIFIC_REACTIVE() {
        return disease_39_HEPATITIS_NONSPECIFIC_REACTIVE;
    }

    public static DefaultMutableTreeNode getDisease_40_LIVER_METASTASES_CIRRHOSIS_BILIARY() {
        return disease_40_LIVER_METASTASES_CIRRHOSIS_BILIARY;
    }

    public static DefaultMutableTreeNode getDisease_41_LIVER_METASTATIC_TUMOR_NODULES() {
        return disease_41_LIVER_METASTATIC_TUMOR_NODULES;
    }

    public static DefaultMutableTreeNode getDisease_42_LIVER_METASTATIC_TUMOR_NODULES() {
        return disease_42_LIVER_METASTATIC_TUMOR_NODULES;
    }

    public static DefaultMutableTreeNode getDisease_43_CIRRHOSIS_BILIARY() {
        return disease_43_CIRRHOSIS_BILIARY;
    }

    public static DefaultMutableTreeNode getDisease_44_CIRRHOSIS_BILIARY() {
        return disease_44_CIRRHOSIS_BILIARY;
    }

    public static DefaultMutableTreeNode getDisease_45_CIRRHOSIS_BILIARY() {
        return disease_45_CIRRHOSIS_BILIARY;
    }

    public static DefaultMutableTreeNode getDisease_46_CIRRHOSIS_ALCOHOLIC_TOXIC() {
        return disease_46_CIRRHOSIS_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_47_CIRRHOSIS_ALCOHOLIC_TOXIC() {
        return disease_47_CIRRHOSIS_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_48_CIRRHOSIS_ALCOHOLIC_TOXIC() {
        return disease_48_CIRRHOSIS_ALCOHOLIC_TOXIC;
    }

    public static DefaultMutableTreeNode getDisease_49_CIRRHOSIS_POSTHEPATITIS() {
        return disease_49_CIRRHOSIS_POSTHEPATITIS;
    }

    static {
        diseaseMap.put(1, disease_1_MONONUCLEOSIS_INFECTIOUS);
        diseaseMap.put(2, disease_2_OBSTRUCTIVE_JAUNDICE);
        diseaseMap.put(3, disease_3_OBSTRUCTIVE_JAUNDICE);
        diseaseMap.put(4, disease_4_OBSTRUCTIVE_JAUNDICE);
        diseaseMap.put(5, disease_5_TOXIC_DAMAGE);
        diseaseMap.put(6, disease_6_TOXIC_DAMAGE);
        diseaseMap.put(7, disease_7_HEPATITIS_ALCOHOLIC);
        diseaseMap.put(8, disease_8_HEPATITIS_ALCOHOLIC);
        diseaseMap.put(9, disease_9_HEPATITIS_ALCOHOLIC);
        diseaseMap.put(10, disease_10_HEPATITIS_VIRAL);
        diseaseMap.put(11, disease_11_HEPATITIS_VIRAL);
        diseaseMap.put(12, disease_12_HEPATITIS_VIRAL);
        diseaseMap.put(13, disease_13_FATTY_LIVER);
        diseaseMap.put(14, disease_14_OBSTRUCTIVE_JAUNDICE);
        diseaseMap.put(15, disease_15_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC);
        diseaseMap.put(16, disease_16_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC);
        diseaseMap.put(17, disease_17_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC);
        diseaseMap.put(18, disease_18_HEPATITIS_CHRONIC_PERSISTENT);
        diseaseMap.put(19, disease_19_HEPATITIS_CHRONIC_PERSISTENT);
        diseaseMap.put(20, disease_20_TOXIC_DAMAGE);
        diseaseMap.put(21, disease_21_FATTY_LIVER);
        diseaseMap.put(22, disease_22_OBSTRUCTIVE_JAUNDICE);
        diseaseMap.put(23, disease_23_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC);
        diseaseMap.put(24, disease_24_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC);
        diseaseMap.put(25, disease_25_HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC);
        diseaseMap.put(26, disease_26_HEPATITIS_CHRONIC_PERSISTENT);
        diseaseMap.put(27, disease_27_HEPATITIS_CHRONIC_PERSISTENT);
        diseaseMap.put(28, disease_28_TOXIC_DAMAGE);
        diseaseMap.put(29, disease_29_HEPATITIS_CHRONIC_AGGRESSIVE);
        diseaseMap.put(30, disease_30_LIVER_METASTATIC_TUMOR_NODULES);
        diseaseMap.put(31, disease_31_LIVER_METASTATIC_TUMOR_NODULES);
        diseaseMap.put(32, disease_32_CIRRHOSIS_BILIARY);
        diseaseMap.put(33, disease_33_CIRRHOSIS_BILIARY);
        diseaseMap.put(34, disease_34_CIRRHOSIS_BILIARY);
        diseaseMap.put(35, disease_35_CIRRHOSIS_ALCOHOLIC_TOXIC);
        diseaseMap.put(36, disease_36_CIRRHOSIS_ALCOHOLIC_TOXIC);
        diseaseMap.put(37, disease_37_CIRRHOSIS_ALCOHOLIC_TOXIC);
        diseaseMap.put(38, disease_38_HEPATITIS_CHRONIC_AGGRESSIVE);
        diseaseMap.put(39, disease_39_HEPATITIS_NONSPECIFIC_REACTIVE);
        diseaseMap.put(40, disease_40_LIVER_METASTASES_CIRRHOSIS_BILIARY);
        diseaseMap.put(41, disease_41_LIVER_METASTATIC_TUMOR_NODULES);
        diseaseMap.put(42, disease_42_LIVER_METASTATIC_TUMOR_NODULES);
        diseaseMap.put(43, disease_43_CIRRHOSIS_BILIARY);
        diseaseMap.put(44, disease_44_CIRRHOSIS_BILIARY);
        diseaseMap.put(45, disease_45_CIRRHOSIS_BILIARY);
        diseaseMap.put(46, disease_46_CIRRHOSIS_ALCOHOLIC_TOXIC);
        diseaseMap.put(47, disease_47_CIRRHOSIS_ALCOHOLIC_TOXIC);
        diseaseMap.put(48, disease_48_CIRRHOSIS_ALCOHOLIC_TOXIC);
        diseaseMap.put(49, disease_49_CIRRHOSIS_POSTHEPATITIS);
    }
}
