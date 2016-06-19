package com.kodeir.enzim2016.thesaurus;

/**
 * Created by Rowan on 11.06.2016.
 */
public enum Diseases {

    INGECTIOUS_MONONUCLEOSIS("Infectious mononucleosis","Инфекционный мононуклеоз"),

    OBSTRUCTIVE_JAUNDICE("Obstructive jaundice","Обтурационная желтуха"),

    TOXIC_DAMAGE("Toxic damage","Токсическое повреждение"),

    CHRONIC_HEPATITIS("Chronic hepatitis","Хронический гепатит"),
    ACUTE_VIRAL_HEPATITIS("Acute viral hepatitis","Острый вирусный гепатит"),
    ALCOHOLIC_HEPATITIS("Alcoholic hepatitis","Алкогольный гепатит"),
    CIRRHOSIS("Cirrhosis","Цирроз"),
    BILIARY_CIRRHOSIS("Biliary cirrhosis","Желчные циррозы"),
    INTRAHEPATIC_CHOLESTASIS("Intrahepatic cholestasis","Внутрипеченочный холестаз"),
    EXTRAHEPATIC_CHOLESTASIS("Extrahepatic cholestasis","Внепеченочный холестаз"),
    POSTHEPATITIS_CIRRHOSIS("Posthepatitis cirrhosis","Постгепатические циррозы");

    private String en;
    private String ru;

    Diseases(String en, String ru) {
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
