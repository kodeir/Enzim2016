package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.commons.UTF8Control;
import com.kodeir.enzim2016.pi.Coefficients;
import com.kodeir.enzim2016.pi.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

/**
 * Created by Sergei Riabinin on 19.06.2016.
 */
@RunWith(Parameterized.class)
public class EnzimLogicTest {

    private static ResourceBundle rb = ResourceBundle.getBundle("rb", new UTF8Control());

    Coefficients coefficients;
    String injuredOrgan;
    String disease;

    @Parameterized.Parameters
    public static Object[][] patientData() {
        return new Object[][] {
                //agamanov 0
                {100, 1, 200, 200, 100, 1, 700, 13,
                        rb.getString("organs.HEART"), rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")},
                //barabanov 1
                {130, 20, 120, 200, 1200, 300, 800, 2,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? "},
                //veneaminov 2
                {64, 50, 180, 2500, 1200, 20, 1200, 2,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")},
                //gurev 3
                {50, 150, 30, 500, 150, 120, 700, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.HEPATITIS_VIRAL")},
                //durov 4
                {51, 100, 20, 200, 1200, 20, 1500, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.TOXIC_DAMAGE") + " ? "},
                //egorov 5
                {100, 130, 20, 200, 1000, 1, 600, 30,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.TOXIC_DAMAGE")},
                //zuravlev 6
                {80, 90, 200, 1200, 1500, 200, 1200, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.TOXIC_DAMAGE")},
                //zenkin 7
                {120, 120, 1500, 200, 1000, 200, 600, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? "},
                //karenina 8
                {68, 102, 200, 300, 230, 20, 789, 20,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.TOXIC_DAMAGE")},
                //kirilov 9
                {110, 60, 100, 500, 200, 10, 1000, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")},
                //leonidov 10
                {120, 100, 100, 230, 200, 1, 1400, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")},
                //mechnikov 11
                {55, 150, 200, 2000, 200, 10, 1200, 5,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS")},
                //nosov 12
                {60, 60, 1050, 1000, 130, 1, 1300, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")},
                //ogurcov 13
                {68, 20, 130, 1000, 100, 20, 1200, 10,
                        rb.getString("organs.BLOOD"), rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")},
                //pirogov 14
                {70, 20, 130, 200, 100, 20, 1300, 2,
                        rb.getString("organs.BONE_TISSUE"), rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")},
                //ryabinin 15
                {42, 40, 100, 1000, 600, 12, 1600, 50,
                        rb.getString("organs.BLOOD"), rb.getString("diseases.HEPATITIS_NONSPECIFIC_REACTIVE")},
                //serebryanyi 16
                {50, 100, 100, 200, 120, 20, 700, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.HEPATITIS_VIRAL") + " ? "},
                //sukarev 17
                {60, 60, 200, 200, 200, 10, 700, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")},
                //timiryazev 18
                {100, 120, 200, 300, 300, 40, 1200, 30,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.TOXIC_DAMAGE")},
                //uvarov 19
                {90, 100, 110, 220, 200, 10, 1200, 2,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.HEPATITIS_CHRONIC_AGGRESSIVE")},
                //udonov 20
                {60, 140, 200, 2300, 120, 10, 780, 5,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS")},
                //faronov 21
                {140, 60, 40, 200, 100, 20, 700, 20,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_POSTHEPATITIS")},
                //hudyakov 22
                {140, 50, 1700, 200, 120, 230, 820, 4,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC") + " ? "},
                //cereteli 23
                {50, 130, 130, 400, 1000, 30, 1100, 2,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.TOXIC_DAMAGE")},
                //chekmincev 24
                {130, 40, 100, 300, 1200, 200, 1300, 5,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.CIRRHOSIS_BILIARY") + " ? "},
                //shuvalov 25
                {50, 150, 100, 700, 300, 60, 700, 10,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS")},
                //emanoylov 26
                {100, 200, 100, 230, 100, 200, 1300, 20,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.HEPATITIS_ALCOHOLIC") + " ? "},
                //umashev 27
                {60, 20, 120, 1000, 100, 200, 1400, 3,
                        rb.getString("organs.BLOOD"), rb.getString("diseases.CIRRHOSIS_ALCOHOLIC_TOXIC")},
                //hacker 28
                {50, 60, 100, 300, 80, 12, 1500, 70,
                        rb.getString("organs.LIVER") + ", " + rb.getString("organs.BILIARY_TRACT"), rb.getString("diseases.HEPATITIS_CHRONIC_PERSISTENT")},


        };
    }

    public EnzimLogicTest(float asT, float alT, float KFK, float LDG, float shF, float GGTP, float HE, float glDG,
                          String injuredOrgan, String disease){
        coefficients = new Coefficients(0, 0, asT, alT, KFK, LDG, shF, GGTP, HE, glDG, LocalDate.now());
        this.injuredOrgan = injuredOrgan;
        this.disease = disease;
    }

    @Test
    public void testDiagnose() throws Exception {
        Diagnosis diagnosis = new EnzimLogic();
        assertEquals(injuredOrgan, diagnosis.getDiagnose(diagnosis.defineInjuredOrgan(coefficients)));
        assertEquals(disease, diagnosis.getDiagnose(diagnosis.defineDisease(coefficients)));
    }
}