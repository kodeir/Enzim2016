package com.kodeir.enzim2016.ui.swing.listeners;

import com.kodeir.enzim2016.ui.swing.panels.CoefficientsPanel;

import java.time.LocalDate;

/**
 * Created by Sergei Riabinin on 25.09.2016.
 */
public class CoefficientsHandler {

    private float ast;
    private float alt;
    private float kfk;
    private float ldg;
    private float shf;
    private float ggtp;
    private float he;
    private float gldg;
    private LocalDate checkupDate;

    private CoefficientsPanel coefficientsPanel;

    public float getAst() {
        return ast;
    }

    public float getAlt() {
        return alt;
    }

    public float getKfk() {
        return kfk;
    }

    public float getLdg() {
        return ldg;
    }

    public float getShf() {
        return shf;
    }

    public float getGgtp() {
        return ggtp;
    }

    public float getHe() {
        return he;
    }

    public float getGldg() {
        return gldg;
    }

    public LocalDate getCheckupDate() {
        return checkupDate;
    }

    public CoefficientsHandler(CoefficientsPanel coefficientsPanel){
        this.coefficientsPanel = coefficientsPanel;
    }

    public boolean checkAst(){
        if (coefficientsPanel.getAstField().getText().equals("")){
            return false;
        } else {
            ast = ((Number) coefficientsPanel.getAstField().getValue()).floatValue();
            return true;
        }
    }

    public boolean checkAlt(){
        if (coefficientsPanel.getAltField().getText().equals("")){
            return false;
        } else {
            alt = ((Number) coefficientsPanel.getAltField().getValue()).floatValue();
            return true;
        }
    }

    public boolean checkKfk(){
        if (coefficientsPanel.getKfkField().getText().equals("")){
            return false;
        } else {
            kfk = ((Number) coefficientsPanel.getKfkField().getValue()).floatValue();
            return true;
        }
    }

    public boolean checkLdg(){
        if (coefficientsPanel.getLdgField().getText().equals("")){
            return false;
        } else {
            ldg = ((Number) coefficientsPanel.getLdgField().getValue()).floatValue();
            return true;
        }
    }

    public boolean checkShf(){
        if (coefficientsPanel.getShfField().getText().equals("")){
            return false;
        } else {
            shf = ((Number) coefficientsPanel.getShfField().getValue()).floatValue();
            return true;
        }
    }

    public boolean checkGgtp(){
        if (coefficientsPanel.getGgtpField().getText().equals("")){
            return false;
        } else {
            ggtp = ((Number) coefficientsPanel.getGgtpField().getValue()).floatValue();
            return true;
        }
    }

    public boolean checkHe(){
        if (coefficientsPanel.getHeField().getText().equals("")){
            return false;
        } else {
            he = ((Number) coefficientsPanel.getHeField().getValue()).floatValue();
            return true;
        }
    }

    public boolean checkGldg(){
        if (coefficientsPanel.getGldgField().getText().equals("")){
            return false;
        } else {
            gldg = ((Number) coefficientsPanel.getGldgField().getValue()).floatValue();
            return true;
        }
    }

    public boolean checkCheckupdate(){
        if (checkDate(coefficientsPanel.getCheckupDateField().getText())){
            checkupDate = LocalDate.parse(coefficientsPanel.getCheckupDateField().getText());
            return true;
        } else {
            return false;
        }
    }

    public boolean checkDate(String text){
        if (text.equals("") || text.equals("    -  -  ")){
            return false;
        } else {
            return true;
        }
    }

}
