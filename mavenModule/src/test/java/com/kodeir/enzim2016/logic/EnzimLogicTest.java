package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.Enzim;
import com.kodeir.enzim2016.patients.Patient;
import com.kodeir.enzim2016.thesaurus.Diseases;
import com.kodeir.enzim2016.thesaurus.Organs;
import org.junit.Before;
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
    public static Collection patientData() {
        return Arrays.asList(new Object[][] {
                {100, 1, 200, 200, 100, 1, 13, 700,
                        Organs.HEART.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()},
                {130, 20, 120, 200, 1200, 300, 800, 2,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.BILIARY_CIRRHOSIS.getEn()},
                {64, 50, 180, 2500, 1200, 20, 2, 1200,
                        Organs.LIVER_N_TRACT.getEn(), Diseases.POSTHEPATITIS_CIRRHOSIS.getEn()}
        });
    }

    public EnzimLogicTest(float asT, float alT, float KFK, float LDG, float shF, float GGTP, float glDG, float HE,
                          String injuredOrgan, String disease){
        patient = new Patient(name, surname, asT, alT, KFK, LDG, shF, GGTP, glDG, HE);
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