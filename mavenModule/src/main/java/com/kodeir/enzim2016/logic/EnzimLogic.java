package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.patients.Patient;
import com.kodeir.enzim2016.thesaurus.Diseases;
import com.kodeir.enzim2016.thesaurus.Organs;

/*
 * Copyright (c) 2007, 2016 Vyacheslav Ryabinin and/or his affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Vyacheslav Ryabinin or the names of his
 *     affiliates may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/**
 * Created by Sergei Ryabinin on 11.06.2016.
 *
 * The EnzimLogic class implements diagnostic algorithms for liver diseases,
 * which was introduced by Vyacheslav Ryabinin in "The development and use
 * of new approaches to the analysis of laboratory and biochemical tests
 * for the differential diagnosis of liver diseases.", Chelyabinsk, 2007.
 *
 */
public class EnzimLogic implements Diagnosis {

    private Patient patient;

    public void diagnose(Patient patient) {
        this.patient = patient;
        patient.setInjuredOrgan(defineInjuredOrgan());
        patient.setDisease(defineDisease());
    }

    private String defineInjuredOrgan(){
        if (patient.getAsT() >= 41 && patient.getAsT() < 151) {
            if (patient.getAlT() >= 41 && patient.getAlT() < 251){
                return Organs.LIVER_N_TRACT.getEn();
            } else if (patient.getAlT() >= 0 && patient.getAlT() < 41){
                if (patient.getKFK() >= 15 && patient.getKFK() < 176){
                    if (patient.getLDG() >= 150 && patient.getLDG() < 591){
                        if (patient.getShF() >= 80  && patient.getShF() < 271){
                            if (patient.getGGTP() >= 0 && patient.getGGTP() < 51){
                                return Organs.LIVER.getEn();
                            } else {
                                return "GGTP is not in the range of 0-50. Diagnose can't be done.";
                            }
                        } else if (patient.getShF() >= 271){
                            if (patient.getGGTP() >= 51 && patient.getGGTP() < 151){
                                return Organs.BONE_TISSUE.getEn();
                            } else if (patient.getGGTP() >= 151 && patient.getGGTP() < 951){
                                return Organs.LIVER_N_TRACT.getEn();
                            } else {
                                return "GGTP is not in the range of 51-951. Diagnose can't be done.";
                            }
                        } else {
                            return "ShF is not in the range of >80 . Diagnose can't be done.";
                        }
                    } else if (patient.getLDG() >= 591 && patient.getLDG() < 2751) {
                        return Organs.BLOOD.getEn();
                    } else {
                        return "LDG is not in the range of 150-2750. Diagnose can't be done.";
                    }
                } else if (patient.getKFK() >= 176 && patient.getKFK() < 501) {
                    return Organs.HEART.getEn();
                } else if (patient.getKFK() >= 501 && patient.getKFK() < 1751) {
                    return Organs.SKELETAL_MUSCLE.getEn();
                } else {
                    return "KFK is not in the range of 15-1750. Diagnose can't be done.";
                }
            } else {
                return "AlT is not in the range of 0-250. Diagnose can't be done.";
            }
        } else {
            return "AsT is not in the range of 41-150. Diagnose can't be done.";
        }
    }

    private String defineDisease(){
        if (isBetween(patient.getAsT(), 41, 151)) {
            if (isBetween(patient.getAsT()/patient.getAlT(), 0.1f, 0.6f)) {
                return deRitisRatio_01_05();
            } else if (isBetween(patient.getAsT()/patient.getAlT(), 0.6f, 1)) {
                return deRitisRatio_06_09();
            } else if (patient.getAsT()/patient.getAlT() >= 1) {
                return deRitisRatio_1();
            } else {
                return "Calculation error";
            }
        } else {
            return "Calculation error";
        }
    }

    private String deRitisRatio_01_05(){
        if (isBetween(patient.getLDG(), 591, 2751)){
            return Diseases.INGECTIOUS_MONONUCLEOSIS.getEn();
        } else if (isBetween(patient.getLDG(), 150, 591)){
            if (patient.getShF() > 270){
                if (isBetween(patient.getGlDG(),11,76)){
                    if ((patient.getAsT()+patient.getAlT())/patient.getGlDG() >= 51){
                        return Diseases.OBSTRUCTIVE_JAUNDICE.getEn() + " ? ";
                    } else if (isBetween(((patient.getAsT()+patient.getAlT())/patient.getGlDG()),40,51)){
                        return Diseases.OBSTRUCTIVE_JAUNDICE.getEn();
                    } else if ((patient.getAsT()+patient.getAlT())/patient.getGlDG() < 40){
                        return Diseases.OBSTRUCTIVE_JAUNDICE.getEn() + " ? ";
                    } else {
                        return "Calculation error";
                    }
                } else if (isBetween(patient.getGlDG(),0,11)){
                    if ((patient.getAsT()+patient.getAlT())/patient.getGlDG() >= 51){
                        return Diseases.TOXIC_DAMAGE.getEn();
                    } else if ((patient.getAsT()+patient.getAlT())/patient.getGlDG() < 51){
                        return Diseases.TOXIC_DAMAGE.getEn() + " ? ";
                    } else {
                        return "Calculation error";
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
                        return "Calculation error";
                    }
                } else if (patient.getGGTP() < 150){
                    if (patient.getGGTP()/patient.getAsT() >= 4){
                        return Diseases.VIRAL_HEPATITIS.getEn() + " ? ";
                    } else if (isBetween((patient.getGGTP()/patient.getAsT()),1,4)){
                        return Diseases.VIRAL_HEPATITIS.getEn();
                    } else if (patient.getGGTP()/patient.getAsT() < 1){
                        return Diseases.VIRAL_HEPATITIS.getEn() + " ? ";
                    } else {
                        return "Calculation error";
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
        return null;
    }

    private String deRitisRatio_1(){
        return null;
    }

    /**
     *
     * @param numberToCheck number to check between lowest and highest
     * @param lowest number >= lowest
     * @param highest number < highest (which means that highest should be expected+1)
     * @return
     */
    private boolean isBetween(float numberToCheck, float lowest, float highest){
        if (numberToCheck >= lowest && numberToCheck < highest) {
            return true;
        } else {
            return false;
        }
    }
}
