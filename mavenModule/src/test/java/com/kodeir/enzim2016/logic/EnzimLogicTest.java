package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.patients.Patient;
import com.kodeir.enzim2016.thesaurus.Diseases;
import com.kodeir.enzim2016.thesaurus.Organs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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

    @Parameterized.Parameters
    public static Object[][] patientData() {
        return new Object[][] {
                {100, 1, 200, 200, 100, 1, 700, 13,
                        Organs.HEART.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                {130, 20, 120, 200, 1200, 300, 800, 2,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.BILIARY_CIRRHOSIS.getEn() + " ? "},
                {64, 50, 180, 2500, 1200, 20, 1200, 2,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                {50, 150, 30, 500, 150, 120, 700, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.VIRAL_HEPATITIS.getEn()},
                {51, 100, 20, 200, 1200, 20, 1500, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.CHRONIC_PERSISTENT_HEPATITIS.getEn()},
                {100, 130, 20, 200, 1000, 1, 600, 30,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.TOXIC_DAMAGE.getEn()},
                {80, 90, 200, 1200, 1500, 200, 1200, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.TOXIC_DAMAGE.getEn()},
                {120, 120, 1500, 200, 1000, 200, 600, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.BILIARY_CIRRHOSIS.getEn() + " ? "},
                {68, 102, 200, 300, 230, 20, 789, 20,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.TOXIC_DAMAGE.getEn()},
                {110, 60, 100, 500, 200, 10, 1000, 10,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()}

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