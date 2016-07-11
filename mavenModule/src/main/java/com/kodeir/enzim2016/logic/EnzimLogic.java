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

import com.kodeir.enzim2016.patients.Patient;
import com.kodeir.enzim2016.thesaurus.Diseases;
import com.kodeir.enzim2016.thesaurus.Organs;

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

    private Patient patient;
    private ResourceBundle rb = ResourceBundle.getBundle("rb");

    private float AsT;
    private float AlT;
    private float KFK;
    private float LDG;
    private float ShF;
    private float GGTP;
    private float GlDG;
    private float HE;

    public void diagnose(Patient patient) {
        setPatient(patient);
        patient.setInjuredOrgan(defineInjuredOrgan());
        patient.setDisease(defineDisease());
    }

    private void setPatient(Patient patient){
        this.patient = patient;
        this.AsT = patient.getAsT();
        this.AlT = patient.getAlT();
        this.KFK = patient.getKFK();
        this.LDG = patient.getLDG();
        this.ShF = patient.getShF();
        this.GGTP = patient.getGGTP();
        this.HE = patient.getHE();
        this.GlDG = patient.getGlDG();
    }

    private String defineInjuredOrgan(){
        if (isBetween(AsT,41,151)) {
            if (isBetween(AlT,41,251)){
                return rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT");
            } else if (isBetween(AlT,0,41)){
                if (isBetween(KFK,15,176)){
                    if (isBetween(LDG,150,591)){
                        if (ShF >= 80 ){
                            if (isBetween(GGTP,0,51)) {
                                return rb.getString("organs.BONE_TISSUE");
                            } else if (isBetween(GGTP,51,151)){
                                return rb.getString("organs.LIVER");
                            } else if (isBetween(GGTP,151,951)){
                                return rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT");
                            } else {
                                return rb.getString("errors.ggtp");
                            }
                        } else {
                            return rb.getString("errors.shf");
                        }
                    } else if (isBetween(LDG,591,2751)) {
                        return rb.getString("organs.BLOOD");
                    } else {
                        return rb.getString("errors.ldg");
                    }
                } else if (isBetween(KFK,176,501)) {
                    return rb.getString("organs.HEART");
                } else if (isBetween(KFK,501,1751)) {
                    return rb.getString("organs.SKELETAL_MUSCLE");
                } else {
                    return rb.getString("errors.kfk");
                }
            } else {
                return rb.getString("errors.alt");
            }
        } else {
            return rb.getString("errors.ast");
        }
    }

    private String defineDisease(){
        if (isBetween(AsT, 41, 151)) {
            if (isBetween(AsT/AlT, 0.1f, 0.6f)) {
                return deRitisRatio_01_05();
            } else if (isBetween(AsT/AlT, 0.6f, 1)) {
                return deRitisRatio_06_09();
            } else if (AsT/AlT >= 1) {
                return deRitisRatio_1();
            } else {
                return rb.getString("errors.calcError");
            }
        } else {
            return rb.getString("errors.calcError");
        }
    }

    private String deRitisRatio_01_05(){
        if (isBetween(LDG, 591, 2751)){
            return rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS");
        } else if (isBetween(LDG, 150, 591)){
            if (ShF > 270){
                if (isBetween(LDG,11,76)){
                    if (((AsT+AlT)/GlDG >= 51) ||
                        ((AsT+AlT)/GlDG < 40)) {
                        return rb.getString("diseases.OBSTRUCTIVE_JAUNDICE") + " ? ";
                    } else if (isBetween(((AsT+AlT)/GlDG),40,51)){
                        return rb.getString("diseases.OBSTRUCTIVE_JAUNDICE");
                    } else {
                        return rb.getString("errors.calcError");
                    }
                } else if (isBetween(patient.getGlDG(),0,11)){
                    if ((patient.getAsT()+patient.getAlT())/patient.getGlDG() >= 51){
                        return Diseases.TOXIC_DAMAGE.getEn();
                    } else if ((patient.getAsT()+patient.getAlT())/patient.getGlDG() < 51){
                        return Diseases.TOXIC_DAMAGE.getEn() + " ? ";
                    } else {
                        return rb.getString("errors.calcError");
                    }
                } else {
                    return "GlDG is not in the range of >80. Diagnose can't be done.";
                }
            } else if (isBetween(patient.getShF(),80,271)){
                if (patient.getGGTP() >= 151){
                    if (patient.getGGTP()/patient.getAsT() >= 7){
                        return Diseases.ALCOHOLIC_HEPATITIS.getEn() + " ? ";
                    } else if (isBetween((patient.getGGTP()/patient.getAsT()),3,7)){
                        return Diseases.ALCOHOLIC_HEPATITIS.getEn();
                    } else if (patient.getGGTP()/patient.getAsT() < 3){
                        return Diseases.ALCOHOLIC_HEPATITIS.getEn() + " ? ";
                    } else {
                        return rb.getString("errors.calcError");
                    }
                } else if (patient.getGGTP() < 150){
                    if (patient.getGGTP()/patient.getAsT() >= 4){
                        return Diseases.VIRAL_HEPATITIS.getEn() + " ? ";
                    } else if (isBetween((patient.getGGTP()/patient.getAsT()),1,4)){
                        return Diseases.VIRAL_HEPATITIS.getEn();
                    } else if (patient.getGGTP()/patient.getAsT() < 1){
                        return Diseases.VIRAL_HEPATITIS.getEn() + " ? ";
                    } else {
                        return rb.getString("errors.calcError");
                    }
                } else {
                    return "GlDG is not in the range of >80. Diagnose can't be done.";
                }
            } else {
                return "ShF is not in the range of >80. Diagnose can't be done.";
            }
        } else {
            return "LDG is not in the range of 150-2750. Diagnose can't be done.";
        }
    }

    private String deRitisRatio_06_09(){
        if (isBetween(patient.getShF(), 371, 1501)){
            return deRitisRatio_06_09_HE_calcs();
        } else if (isBetween(patient.getShF(), 80, 371)){
            if (patient.getGGTP() >= 11) {
                return deRitisRatio_06_09_HE_calcs();
            } else if (isBetween(patient.getGGTP(), 0, 11)){
                return Diseases.CHRONIC_AGGRESSIVE_HEPATITIS.getEn();
            } else {
                return "GGTP is not in the range of 80-1500. Diagnose can't be done.";
            }
        } else {
            return "ShF is not in the range of 80-1500. Diagnose can't be done.";
        }
    }

    private String deRitisRatio_06_09_HE_calcs(){
        if (isBetween(patient.getHE(),2701,3751)){
            return Diseases.FATTY_LIVER.getEn();
        } else if (isBetween(patient.getHE(),1751,2701)){
            if (patient.getGlDG() >= 11){
                return Diseases.OBSTRUCTIVE_JAUNDICE.getEn();
            } else if (isBetween(patient.getGlDG(), 0, 11)) {
                if (patient.getGGTP()/patient.getAsT() >= 4){
                    return Diseases.CHRONIC_ALCOHOLIC_TOXIC_HEPATITIS.getEn() + " ? ";
                } else if (isBetween((patient.getGGTP()/patient.getAsT()),1,4)){
                    return Diseases.CHRONIC_ALCOHOLIC_TOXIC_HEPATITIS.getEn();
                } else if (patient.getGGTP()/patient.getAsT() < 1){
                    return Diseases.CHRONIC_ALCOHOLIC_TOXIC_HEPATITIS.getEn() + " ? ";
                } else {
                    return "Calculation error";
                }
            } else {
                return "GGTP/AST is not in the range of > 0. Diagnose can't be done.";
            }
        } else if (isBetween(patient.getHE(),1201,1751)){
            if (patient.getGGTP() / patient.getAsT() >= 2){
                return Diseases.CHRONIC_PERSISTENT_HEPATITIS.getEn() + " ? ";
            } else if (isBetween(patient.getGGTP() / patient.getAsT(), 0, 2)) {
                return Diseases.CHRONIC_PERSISTENT_HEPATITIS.getEn();
            } else {
                return "GGTP/AST is not in the range of > 0. Diagnose can't be done.";
            }
        } else if (isBetween(patient.getHE(),500,1201)){
            return Diseases.TOXIC_DAMAGE.getEn();
        } else {
            return "HE is not in the range of 80-1500. Diagnose can't be done.";
        }
    }

    private String deRitisRatio_1(){
        if (patient.getHE() >= 1501){
            if (patient.getGGTP() >= 251){
                return deRitisRatio_1_ShF_calcs();
            } else if (isBetween(patient.getGGTP(),151,251)){
                return Diseases.CHRONIC_AGGRESSIVE_HEPATITIS.getEn();
            } else if (patient.getGGTP() < 151){
                return Diseases.NONSPECIFIC_REACTIVE_HEPATITIS.getEn();
            } else {
                return "Calculation error";
            }
        } else if (isBetween(patient.getHE(), 500, 1501)){
            if (patient.getGGTP() >= 351){
                return Diseases.LIVER_METASTASES.getEn() + " ? " + " , " + Diseases.BILIARY_CIRRHOSIS.getEn() + " ? ";
            } else if (isBetween(patient.getGGTP(),151,351)){
                return deRitisRatio_1_ShF_calcs();
            } else if (patient.getGGTP() < 151){
                return Diseases.POSTHEPATITIS_CIRRHOSIS.getEn();
            } else {
                return "Calculation error";
            }
        } else {
            return "HE is not in the range of 80-1500. Diagnose can't be done.";
        }
    }

    private String deRitisRatio_1_ShF_calcs(){
        if (isBetween(patient.getShF(), 471, 1501)) {
            if (isBetween(patient.getGlDG(), 11, 76)){
                if ((patient.getAsT() + patient.getAlT())/patient.getGlDG() >= 11){
                    return Diseases.LIVER_METASTATIC_TUMOR_NODULES.getEn() + " ? ";
                } else if (isBetween(((patient.getAsT() + patient.getAlT())/patient.getGlDG()),0,11)){
                    return Diseases.LIVER_METASTATIC_TUMOR_NODULES.getEn();
                } else {
                    return "(AsT+AlT)/GLDG is not in the range of > 0. Diagnose can't be done.";
                }
            } else if (isBetween(patient.getGlDG(), 0, 11)){
                if ((patient.getAsT() + patient.getAlT())/patient.getGlDG() >= 21){
                    return Diseases.BILIARY_CIRRHOSIS.getEn() + " ? ";
                } else if (isBetween(((patient.getAsT() + patient.getAlT())/patient.getGlDG()),5,21)){
                    return Diseases.BILIARY_CIRRHOSIS.getEn();
                } else if ((patient.getAsT() + patient.getAlT())/patient.getGlDG() < 5){
                    return Diseases.BILIARY_CIRRHOSIS.getEn() + " ? ";
                } else {
                    return "Calculation error";
                }
            } else {
                return "GlDG is not in the range of 0-75. Diagnose can't be done.";
            }
        } else if (isBetween(patient.getShF(), 80, 471)){
            if (patient.getGGTP()/patient.getAsT() >= 7){
                return Diseases.ALCOHOLIC_TOXIC_CIRRHOSIS.getEn() + " ? ";
            } else if (isBetween((patient.getGGTP()/patient.getAsT()),3,7)){
                return Diseases.ALCOHOLIC_TOXIC_CIRRHOSIS.getEn();
            } else if (patient.getGGTP()/patient.getAsT() < 3){
                return Diseases.ALCOHOLIC_TOXIC_CIRRHOSIS.getEn() + " ? ";
            } else {
                return "Calculation error";
            }
        } else {
            return "ShF is not in the range of 80-1500. Diagnose can't be done.";
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
}
