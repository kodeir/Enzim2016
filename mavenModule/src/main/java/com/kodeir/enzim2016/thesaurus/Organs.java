package com.kodeir.enzim2016.thesaurus;

/**
 * Created by Rowan on 11.06.2016.
 */
public enum Organs {

    LIVER("liver","печень"),
    BILIARY_TRACT("biliary tract","желчные пути"),
    LIVER_N_TRACT("liver, biliary tract","печень, желчные пути"),
    HEART("heart","сердце"),
    SKELETAL_MUSCLE("skeletal muscle","скелетная мышца"),
    BLOOD("blood diseases, anemia, hemolysis", "заболевания крови, анемии, гемолиз"),
    BONE_TISSUE("bone tissue","костная ткань");

    private String en;
    private String ru;

    Organs(String en, String ru){
        this.en = en;
        this.ru = ru;
    }

    public String getEn() {
        return en;
    }

    public String getRu() {
        return ru;
    }
}
