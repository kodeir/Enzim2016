package com.kodeir.enzim2016.thesaurus;

/**
 * Created by Rowan on 11.06.2016.
 */
public enum Diseases {

    INGECTIOUS_MONONUCLEOSIS("Infectious mononucleosis","Инфекционный мононуклеоз"),

    OBSTRUCTIVE_JAUNDICE("Obstructive jaundice","Обтурационная желтуха"),

    FATTY_LIVER("Fatty liver","Жировая печень"),
    LIVER_METASTASES("Liver metastases", "Печень с метастазами"),
    LIVER_METASTATIC_TUMOR_NODULES("Liver with metastatic tumor nodules", "Печень с метаститическими опухолевыми узлами"),

    TOXIC_DAMAGE("Toxic damage","Токсическое повреждение"),

    //CHRONIC_HEPATITIS("Chronic hepatitis","Хронический гепатит"),
    CHRONIC_AGGRESSIVE_HEPATITIS("Chronic agressive hepatitis","Хронический агрессивный гепатит"),
    CHRONIC_ALCOHOLIC_TOXIC_HEPATITIS("Chronic alcoholic toxic hepatitis","Хронический алкогольный токсический гепатит"),
    CHRONIC_PERSISTENT_HEPATITIS("Chronic persistent hepatitis","Хронический персистирующий гепатит"),
    NONSPECIFIC_REACTIVE_HEPATITIS("Nonspecific reactive hepatitis","Неспецифический реактивный гепатит"),

    //ACUTE_VIRAL_HEPATITIS("Acute viral hepatitis","Острый вирусный гепатит"),
    VIRAL_HEPATITIS("Viral hepatitis","Острый вирусный гепатит"),
    ALCOHOLIC_HEPATITIS("Alcoholic hepatitis","Алкогольный гепатит"),


    //CIRRHOSIS("Cirrhosis","Цирроз"),
    ALCOHOLIC_TOXIC_CIRRHOSIS("Alcoholic toxic cirrhosis","Алкогольный токсический цирроз"),
    BILIARY_CIRRHOSIS("Biliary cirrhosis","Желчный цирроз"),
    //INTRAHEPATIC_CHOLESTASIS("Intrahepatic cholestasis","Внутрипеченочный холестаз"),
    //EXTRAHEPATIC_CHOLESTASIS("Extrahepatic cholestasis","Внепеченочный холестаз"),
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
