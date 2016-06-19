package com.kodeir.enzim2016.patients;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rowan on 11.06.2016.
 */
public class Patient {

    private String name;
    private String surname;

    private float AsT;
    private float AlT;
    private float KFK;
    private float LDG;
    private float ShF;
    private float GGTP;
    private float GlDG;
    private float HE;

    private String injuredOrgan;
    private String disease;

    public Patient(String name, String surname) {
        this(name, surname, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Patient(String name, String surname, float asT, float alT, float KFK, float LDG, float shF, float GGTP, float glDG, float HE) {
        this.name = name;
        this.surname = surname;
        this.AsT = asT;
        this.AlT = alT;
        this.KFK = KFK;
        this.LDG = LDG;
        this.ShF = shF;
        this.GGTP = GGTP;
        this.GlDG = glDG;
        this.HE = HE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getAsT() {
        return AsT;
    }

    public void setAsT(float asT) {
        AsT = asT;
    }

    public float getAlT() {
        return AlT;
    }

    public void setAlT(float alT) {
        AlT = alT;
    }

    public float getKFK() {
        return KFK;
    }

    public void setKFK(float KFK) {
        this.KFK = KFK;
    }

    public float getLDG() {
        return LDG;
    }

    public void setLDG(float LDG) {
        this.LDG = LDG;
    }

    public float getShF() {
        return ShF;
    }

    public void setShF(float shF) {
        ShF = shF;
    }

    public float getGGTP() {
        return GGTP;
    }

    public void setGGTP(float GGTP) {
        this.GGTP = GGTP;
    }

    public float getGlDG() {
        return GlDG;
    }

    public void setGlDG(float glDG) {
        GlDG = glDG;
    }

    public float getHE() {
        return HE;
    }

    public void setHE(float HE) {
        this.HE = HE;
    }

    public String getInjuredOrgan(){
        return injuredOrgan;
    }

    public void setInjuredOrgan(String injuredOrgan){
        this.injuredOrgan = injuredOrgan;
    }

    public String getDisease(){
        return disease;
    }

    public void setDisease(String disease){
        this.disease = disease;
    }
}
