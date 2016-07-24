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
 *  THIS SOFTWARE IS PROVIDED BY The COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 *  The IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL The COPYRIGHT OWNER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY TheORY OF
 *  LIABILITY, WheTheR IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTheRWISE) ARISING IN ANY WAY OUT OF The USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF The POSSIBILITY OF SUCH DAMAGE.
 */

package com.kodeir.enzim2016.pi;

import java.time.LocalDate;

/**
 * Created by Sergei Riabinin on 24.07.2016.
 */
public class Coefficients {

    private long coefficients_id;
    private long patient_id;

    private float ast;
    private float alt;
    private float kfk;
    private float ldg;
    private float shf;
    private float ggtp;
    private float he;
    private float gldg;

    private LocalDate checkupDate;

    public Coefficients(long coefficients_id, long patient_id, float asT, float alT, float kfk, float ldg, float shF, float ggtp, float he, float glDG, LocalDate checkupDate) {
        this.coefficients_id = coefficients_id;
        this.patient_id = patient_id;
        this.ast = asT;
        this.alt = alT;
        this.kfk = kfk;
        this.ldg = ldg;
        this.shf = shF;
        this.ggtp = ggtp;
        this.he = he;
        this.gldg = glDG;
        this.checkupDate = checkupDate;
    }

    public long getCoefficients_id() {
        return coefficients_id;
    }

    public void setCoefficients_id(long coefficients_id) {
        this.coefficients_id = coefficients_id;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public float getAst() {
        return ast;
    }

    public void setAst(float asT) {
        ast = asT;
    }

    public float getAlt() {
        return alt;
    }

    public void setAlt(float alT) {
        alt = alT;
    }

    public float getKfk() {
        return kfk;
    }

    public void setKfk(float kfk) {
        this.kfk = kfk;
    }

    public float getLdg() {
        return ldg;
    }

    public void setLdg(float ldg) {
        this.ldg = ldg;
    }

    public float getShf() {
        return shf;
    }

    public void setShf(float shF) {
        shf = shF;
    }

    public float getGgtp() {
        return ggtp;
    }

    public void setGgtp(float ggtp) {
        this.ggtp = ggtp;
    }

    public float getHe() {
        return he;
    }

    public void setHe(float he) {
        this.he = he;
    }

    public float getGldg() {
        return gldg;
    }

    public void setGldg(float glDG) {
        gldg = glDG;
    }

    public LocalDate getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(LocalDate checkupDate) {
        this.checkupDate = checkupDate;
    }

    public String toString(){
        return checkupDate + ": " +
                ast + ", " +
                alt + ", " +
                kfk + ", " +
                ldg + ", " +
                shf + ", " +
                ggtp + ", " +
                he + ", " +
                gldg + "; ";
    }
}
