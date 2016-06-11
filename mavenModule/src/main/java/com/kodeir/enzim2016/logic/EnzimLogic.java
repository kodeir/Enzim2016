package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.patients.Patient;
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
        patient.setInjeredOrgan(defineInjuredOrgan());
        patient.setDisease(defineDisease());
    }

    private String defineInjuredOrgan(){
        if (patient.getAsT() > 49 && patient.getAsT() < 51) {
            if (patient.getAlT() > 19 && patient.getAlT() < 21){
                return Organs.LIVER_N_TRACT.getEn();
            } else if (patient.getAlT() > 99 && patient.getAlT() < 101){
                if (patient.getKFK() > 14 && patient.getKFK() < 16){
                    if (patient.getLDG() > 149 && patient.getLDG() < 151){
                        if (patient.getShF() > 119 && patient.getShF() < 121){
                            if (patient.getGGTP() > 74 && patient.getGGTP() < 76){
                                return Organs.LIVER.getEn();
                            } else {
                                return "ShF and/or GGTP is not in the range. Diagnose can't be done.";
                            }
                        } else if (patient.getShF() > 449 && patient.getShF() < 501){
                            if (patient.getGGTP() > 14 && patient.getGGTP() < 16){
                                return Organs.BONE_TISSUE.getEn();
                            } else if (patient.getGGTP() > 749 && patient.getGGTP() < 751){
                                return Organs.LIVER_N_TRACT.getEn();
                            } else {
                                return "ShF and/or GGTP is not in the range. Diagnose can't be done.";
                            }
                        }
                    } else if (patient.getLDG() > 2499 && patient.getLDG() < 2501) {
                        return Organs.BLOOD.getEn();
                    } else {
                        return "LDG <> 150, or <> 2500. Diagnose can't be done.";
                    }
                } else if (patient.getKFK() > 249 && patient.getKFK() < 251) {
                    return Organs.HEART.getEn();
                } else if (patient.getKFK() > 1499 && patient.getKFK() < 1501) {
                    return Organs.SKELETAL_MUSCLE.getEn();
                } else {
                    return "KFK <> 15, or <> 250, or 1500. Diagnose can't be done.";
                }
            } else {
                return "AlT <> 20, or <> 100. Diagnose can't be done.";
            }
        } else {
            return "AsT <> 50. Diagnose can't be done.";
        }
        return null;
    }

    private String defineDisease(){
        return null;
    }
}
