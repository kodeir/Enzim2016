package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.patients.Patient;
import com.kodeir.enzim2016.thesaurus.Diseases;
import com.kodeir.enzim2016.thesaurus.Organs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ResourceBundle;

import static org.junit.Assert.*;

/**
 * Created by Rowan on 19.06.2016.
 */
@RunWith(Parameterized.class)
public class EnzimLogicTest {
    Patient patient;
    String injuredOrgan;
    String disease;
    String name = "Test_Name";
    String surname = "Test_Surname";
    static ResourceBundle rb = ResourceBundle.getBundle("rb");

    @Parameterized.Parameters
    public static Object[][] patientData() {
        return new Object[][] {
                //agamanov 0
                {100, 1, 200, 200, 100, 1, 700, 13,
                        Organs.HEART.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                //barabanov 1
                {130, 20, 120, 200, 1200, 300, 800, 2,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.BILIARY_CIRRHOSIS.getEn() + " ? "},
                //veneaminov 2
                {64, 50, 180, 2500, 1200, 20, 1200, 2,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                //gurev 3
                {50, 150, 30, 500, 150, 120, 700, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.VIRAL_HEPATITIS.getEn()},
                //durov 4
                //{51, 100, 20, 200, 1200, 20, 1500, 10,
                //        Organs.LIVER_N_TRACT.getEn(), Diseases.CHRONIC_PERSISTENT_HEPATITIS.getEn()},
                //egorov 5
                {100, 130, 20, 200, 1000, 1, 600, 30,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.TOXIC_DAMAGE.getEn()},
                //zuravlev 6
                {80, 90, 200, 1200, 1500, 200, 1200, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.TOXIC_DAMAGE.getEn()},
                //zenkin 7
                {120, 120, 1500, 200, 1000, 200, 600, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.BILIARY_CIRRHOSIS.getEn() + " ? "},
                //karenina 8
                {68, 102, 200, 300, 230, 20, 789, 20,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.TOXIC_DAMAGE.getEn()},
                //kirilov 9
                {110, 60, 100, 500, 200, 10, 1000, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                //leonidov 10
                {120, 100, 100, 230, 200, 1, 1400, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                //mechnikov 11
                {55, 150, 200, 2000, 200, 10, 1200, 5,
                        Organs.LIVER_N_TRACT.getEn(), rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS")},
                //nosov 12
                {60, 60, 1050, 1000, 130, 1, 1300, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                //ogurcov 13
                {68, 20, 130, 1000, 100, 20, 1200, 10,
                        Organs.BLOOD.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                //pirogov 14
                {70, 20, 130, 200, 100, 20, 1300, 2,
                        Organs.BONE_TISSUE.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                //ryabinin 15
                {42, 40, 100, 1000, 600, 12, 1600, 50,
                        Organs.BLOOD.getEn(), Diseases.NONSPECIFIC_REACTIVE_HEPATITIS.getEn()},
                //serebryanyi 16
                {50, 100, 100, 200, 120, 20, 700, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.VIRAL_HEPATITIS.getEn() + " ? "},
                //sukarev 17
                {60, 60, 200, 200, 200, 10, 700, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                //timiryazev 18
                {100, 120, 200, 300, 300, 40, 1200, 30,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.TOXIC_DAMAGE.getEn()},
                //uvarov 19
                //{90, 100, 110, 220, 200, 10, 1200, 2,
                //        Organs.LIVER_N_TRACT.getEn(), Diseases.TOXIC_DAMAGE.getEn()},
                //udonov 20
                {60, 140, 200, 2300, 120, 10, 780, 5,
                        Organs.LIVER_N_TRACT.getEn(), rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS")},
                //faronov 21
                {140, 60, 40, 200, 100, 20, 700, 20,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                //hudyakov 22
                {140, 50, 1700, 200, 120, 230, 820, 4,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.ALCOHOLIC_TOXIC_CIRRHOSIS.getEn() + " ? "},
                //cereteli 23
                {50, 130, 130, 400, 1000, 30, 1100, 2,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.TOXIC_DAMAGE.getEn()},
                //chekmincev 24
                {130, 40, 100, 300, 1200, 200, 1300, 5,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.BILIARY_CIRRHOSIS.getEn() + " ? "},
                //shuvalov 25
                {50, 150, 100, 700, 300, 60, 700, 10,
                        Organs.LIVER_N_TRACT.getEn(), rb.getString("diseases.MONONUCLEOSIS_INFECTIOUS")},
                //emanoylov 26
                {100, 200, 100, 230, 100, 200, 1300, 20,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.ALCOHOLIC_HEPATITIS.getEn() + " ? "},
                //umashev 27
                {60, 20, 120, 1000, 100, 200, 1400, 3,
                        Organs.BLOOD.getEn(), Diseases.ALCOHOLIC_TOXIC_CIRRHOSIS.getEn()},
                //hacker 28
                {50, 60, 100, 300, 80, 12, 1500, 70,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.CHRONIC_PERSISTENT_HEPATITIS.getEn()},


        };
    }

    public EnzimLogicTest(float asT, float alT, float KFK, float LDG, float shF, float GGTP, float HE, float glDG,
                          String injuredOrgan, String disease){
        patient = new Patient(name, surname, asT, alT, KFK, LDG, shF, GGTP, HE, glDG);
        this.injuredOrgan = injuredOrgan;
        this.disease = disease;
    }

    @Test
    public void testDiagnose() throws Exception {
        Diagnosis diagnosis = new EnzimLogic();
        diagnosis.diagnose(patient);
        assertEquals(injuredOrgan, patient.getInjuredOrgan());
        assertEquals(disease, patient.getDisease());
    }
}