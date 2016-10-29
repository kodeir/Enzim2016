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

package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.pi.Patient;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Sergei Riabinin on 11.06.2016.
 *
 * The EnzimLogic class implements diagnostic algorithms for liver diseases,
 * which was introduced by Vyacheslav Ryabinin in "The development and use
 * of new approaches to the analysis of laboratory and biochemical tests
 * for the differential diagnosis of liver diseases.", Chelyabinsk, 2007.
 *
 */
public class EnzimLogic implements Diagnosis {

    private static ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    private float AsT;
    private float AlT;
    private float KFK;
    private float LDG;
    private float ShF;
    private float GGTP;
    private float GlDG;
    private float HE;

    private void setCoefficients(Coefficients coefficients){
        this.AsT = coefficients.getAst();
        this.AlT = coefficients.getAlt();
        this.KFK = coefficients.getKfk();
        this.LDG = coefficients.getLdg();
        this.ShF = coefficients.getShf();
        this.GGTP = coefficients.getGgtp();
        this.HE = coefficients.getHe();
        this.GlDG = coefficients.getGldg();
    }

    /**
     *
     * @param coefficients patient coefficients
     * @return Map<Integer, String> where String is an injured organ
     * and Integer is a key to map injured organ with a tree node
     *
     * @see com.kodeir.enzim2016.ui.swing.listeners.TreeNodesMap
     * @see com.kodeir.enzim2016.ui.swing.listeners.TreeListener
     */
    public Map<Integer, String> defineInjuredOrgan(Coefficients coefficients){
        setCoefficients(coefficients);
        if (isBetween(AsT,41,151)) {
            if (isBetween(AlT,41,251)){
                return createMap(1, rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"));
            } else if (isBetween(AlT,0,41)){
                if (isBetween(KFK,15,176)){
                    if (isBetween(LDG,150,591)){
                        if (ShF >= 80 ){
                            if (isBetween(GGTP,0,51)) {
                                return createMap(2, rb.getString("organs.BONE_TISSUE"));
                            } else if (isBetween(GGTP,51,151)){
                                return createMap(3, rb.getString("organs.LIVER"));
                            } else if (isBetween(GGTP,151,951)){
                                return createMap(4, rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"));
                            } else {
                                return createMap(0, rb.getString("errors.calc.ggtp.btwn.0_950"));
                            }
                        } else {
                            return createMap(0, rb.getString("errors.shf.more.80"));
                        }
                    } else if (isBetween(LDG,591,2751)) {
                        return createMap(5, rb.getString("organs.BLOOD"));
                    } else {
                        return createMap(0, rb.getString("errors.calc.ldg.btwn.150_2750"));
                    }
                } else if (isBetween(KFK,176,501)) {
                    return createMap(6, rb.getString("organs.HEART"));
                } else if (isBetween(KFK,501,1751)) {
                    return createMap(7, rb.getString("organs.SKELETAL_MUSCLE"));
                } else {
                    return createMap(0, rb.getString("errors.calc.kfk.btwn.15_1750"));
                }
            } else {
                return createMap(0, rb.getString("errors.calc.alt.btwn.0_250"));
            }
        } else {
            return createMap(0, rb.getString("errors.calc.ast.btwn.41-150"));
        }
    }

    public String defineDisease(Coefficients coefficients){
        setCoefficients(coefficients);
        if (isBetween(AsT, 41, 151)) {
            if (isBetween(AsT/AlT, 0.1f, 0.6f)) {
                return deRitisRatio_01_05();
            } else if (isBetween(AsT/AlT, 0.6f, 1)) {
                return deRitisRatio_06_09();
            } else if (AsT/AlT >= 1) {
                return deRitisRatio_1();
            } else {
                return rb.getString("errors.calc.error");
            }
        } else {
            return rb.getString("errors.calc.ast.btwn.41-150");
        }
    }

    @Override
    public String getDiagnose(Map<Integer, String> diagnoseMap) {
        String diagnose = "";
        for (Map.Entry<Integer,String> entry: diagnoseMap.entrySet()){
            diagnose = entry.getValue();
        }
        return diagnose;
    }

    @Override
    public Integer getKey(Map<Integer, String> diagnoseMap) {
        int key = 0;
        for (Map.Entry<Integer,String> entry: diagnoseMap.entrySet()){
            key = entry.getKey();
        }
        return key;
    }

    private String deRitisRatio_01_05(){
        if (isBetween(LDG, 591, 2751)){
            return rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS");
        } else if (isBetween(LDG, 150, 591)){
            if (ShF > 270){
                if (isBetween(GlDG,11,76)){
                    if (((AsT+AlT)/GlDG >= 51) || ((AsT+AlT)/GlDG < 40)) {
                        return rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? ";
                    } else if (isBetween(((AsT+AlT)/GlDG),40,51)){
                        return rb.getString("diseases.OBSTRUCTIVE_JAUNDICE");
                    } else {
                        return rb.getString("errors.calc.error");
                    }
                } else if (isBetween(GlDG,0,11)){
                    if ((AsT+AlT)/GlDG >= 51){
                        return rb.getString("diseases.TOXIC_DAMAGE");
                    } else if ((AsT+AlT)/GlDG < 51){
                        return rb.getString("diseases.TOXIC_DAMAGE") + " ? ";
                    } else {
                        return rb.getString("errors.calc.error");
                    }
                } else {
                    return rb.getString("errors.calc.gldg.btwn.0_75");
                }
            } else if (isBetween(ShF,80,271)){
                if (GGTP >= 151){
                    if ((GGTP/AsT >= 7) || (GGTP/AsT < 3)){
                        return rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? ";
                    } else if (isBetween((GGTP/AsT),3,7)){
                        return rb.getString("diseases.HEPATITIS_ALCOHOLIC");
                    } else {
                        return rb.getString("errors.calc.error");
                    }
                } else if (GGTP < 150){
                    if ((GGTP/AsT >= 4) || (GGTP/AsT < 1)){
                        return rb.getString("diseases.HEPATITIS_VIRAL") + " ? ";
                    } else if (isBetween((GGTP/AsT),1,4)){
                        return rb.getString("diseases.HEPATITIS_VIRAL");
                    } else {
                        return rb.getString("errors.calc.error");
                    }
                } else {
                    return rb.getString("errors.calc.error");
                }
            } else {
                return rb.getString("errors.shf.more.80");
            }
        } else {
            return rb.getString("errors.calc.ldg.btwn.150_2750");
        }
    }

    private String deRitisRatio_06_09(){
        if (isBetween(ShF, 371, 1501)){
            return deRitisRatio_06_09_HE_calcs();
        } else if (isBetween(ShF, 80, 371)){
            if (GGTP >= 11) {
                return deRitisRatio_06_09_HE_calcs();
            } else if (isBetween(GGTP, 0, 11)){
                return rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE");
            } else {
                return rb.getString("errors.calc.ggtp.less.0");
            }
        } else {
            return rb.getString("errors.shf.btwn.80_1500");
        }
    }

    private String deRitisRatio_06_09_HE_calcs(){
        if (isBetween(HE,2701,3751)){
            return rb.getString("diseases.FATTY_LIVER");
        } else if (isBetween(HE,1751,2701)){
            if (GlDG >= 11){
                return rb.getString("diseases.OBSTRUCTIVE_JAUNDICE");
            } else if (isBetween(GlDG, 0, 11)) {
                if ((GGTP/AsT >= 4) || (GGTP/AsT < 1)){
                    return rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC") + " ? ";
                } else if (isBetween((GGTP/AsT),1,4)){
                    return rb.getString("diseases.HEPATITIS_CHRONIC_ALCOHOLIC_TOXIC");
                } else {
                    return rb.getString("errors.calc.error");
                }
            } else {
                return rb.getString("errors.calc.ggtp_ast.more.0");
            }
        } else if (isBetween(HE,1201,1751)){
            if (GGTP / AsT >= 2){
                return rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT") + " ? ";
            } else if (isBetween(GGTP / AsT, 0, 2)) {
                return rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT");
            } else {
                return rb.getString("errors.calc.ggtp_ast.more.0");
            }
        } else if (isBetween(HE,500,1201)){
            return rb.getString("diseases.TOXIC_DAMAGE");
        } else {
            return rb.getString("errors.calc.he.btwn.500_3750");
        }
    }

    private String deRitisRatio_1(){
        if (HE >= 1501){
            if (GGTP >= 251){
                return deRitisRatio_1_ShF_calcs();
            } else if (isBetween(GGTP,151,251)){
                return rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE");
            } else if (GGTP < 151){
                return rb.getString("diseases.HEPATITIS_NONSPECIFIC_REACTIVE");
            } else {
                return rb.getString("errors.calc.error");
            }
        } else if (isBetween(HE, 500, 1501)){
            if (GGTP >= 351){
                return rb.getString("diseases.LIVER_METASTASES") + " ? " + " , " + rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ";
            } else if (isBetween(GGTP,151,351)){
                return deRitisRatio_1_ShF_calcs();
            } else if (GGTP < 151){
                return rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS");
            } else {
                return rb.getString("errors.calc.error");
            }
        } else {
            return rb.getString("errors.calc.he.less.500");
        }
    }

    private String deRitisRatio_1_ShF_calcs(){
        if (isBetween(ShF, 471, 1501)) {
            if (isBetween(GlDG, 11, 76)){
                if ((AsT + AlT)/GlDG >= 11){
                    return rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES") + " ? ";
                } else if (isBetween(((AsT + AlT)/GlDG),0,11)){
                    return rb.getString("diseases.LIVER_METASTATIC_TUMOR_NODULES");
                } else {
                    return rb.getString("errors.calc.ast_alt_gldg.more.0");
                }
            } else if (isBetween(GlDG, 0, 11)){
                if ((AsT + AlT)/GlDG >= 21){
                    return rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ";
                } else if (isBetween(((AsT + AlT)/GlDG),5,21)){
                    return rb.getString("diseases.CIRRHOSIS_BILIARY");
                } else if ((AsT + AlT)/GlDG < 5){
                    return rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? ";
                } else {
                    return rb.getString("errors.calc.error");
                }
            } else {
                return rb.getString("errors.calc.gldg.btwn.0_75");
            }
        } else if (isBetween(ShF, 80, 471)){
            if (GGTP/AsT >= 7){
                return rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ";
            } else if (isBetween((GGTP/AsT),3,7)){
                return rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC");
            } else if (GGTP/AsT < 3){
                return rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? ";
            } else {
                return rb.getString("errors.calc.error");
            }
        } else {
            return rb.getString("errors.shf.btwn.80_1500");
        }
    }

    /**
     *
     * @param numberToCheck number to check between lowest and highest
     * @param lowest number >= lowest
     * @param highest number < highest (which means that highest should be expected+1)
     * @return true if numberToCheck is >= lowest and < highest
     */
    private boolean isBetween(float numberToCheck, float lowest, float highest){
        return (numberToCheck >= lowest && numberToCheck < highest);
    }

    private Map<Integer,String> createMap(Integer i, String s){
        Map<Integer,String> map = new HashMap<>();
        map.put(i,s);
        return map;
    }
}
