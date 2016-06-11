package java.com.kodeir.enzim2016.logic;

/**
 * Created by Rowan on 11.06.2016.
 */
public enum Diagnoses {

    CHRONIC_HEPATITIS("Chronic hepatitis","Хронический гепатит"),
    ACUTE_VIRAL_HEPATITIS("Acute viral hepatitis","Острый вирусный гепатит"),
    ALCOHOLIC_HEPATITIS("Alcoholic hepatitis","Алкогольный гепатит"),
    CIRRHOSIS("Cirrhosis","Цирроз"),
    INTRAHEPATIC_CHOLESTASIS("Intrahepatic cholestasis","Внутрипеченочный холестаз"),
    EXTRAHEPATIC_CHOLESTASIS("Extrahepatic cholestasis","Внепеченочный холестаз");

    private String en;
    private String ru;

    Diagnoses(String en, String ru) {
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
