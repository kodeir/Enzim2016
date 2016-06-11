package com.kodeir.enzim2016.ui.cmd;

import com.kodeir.enzim2016.logic.Diagnosis;
import com.kodeir.enzim2016.logic.EnzimLogic;
import com.kodeir.enzim2016.patients.Patient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rowan on 11.06.2016.
 */
public class CmdUi {

    private Patient patient;

    public CmdUi(){
        runCmd();
    }

    public static void startCmd(){
        CmdUi cmdUi = new CmdUi();
    }

    private void runCmd(){
        System.out.println("Enzim 2016");
        System.out.println("--");
        createPatient();
        fillCoefficients();
        doDiagnostic();
    }

    private void createPatient(){
        System.out.println("Enter patient name");
        String name = readStringFromConsole();
        System.out.println("Enter patient surname");
        String surname = readStringFromConsole();
        patient = new Patient(name,surname);
        System.out.println("Patient: " + name + " " + surname);
        System.out.println("--");
    }

    private void fillCoefficients(){
        System.out.println("Enter AsT");
        patient.setAsT(readFloatFromConsole());
        System.out.println("Enter AlT");
        patient.setAlT(readFloatFromConsole());
        System.out.println("Enter KFK");
        patient.setKFK(readFloatFromConsole());
        System.out.println("Enter LDG");
        patient.setLDG(readFloatFromConsole());
        System.out.println("Enter ShF");
        patient.setShF(readFloatFromConsole());
        System.out.println("Enter GGTP");
        patient.setGGTP(readFloatFromConsole());
        System.out.println("Enter GlDG");
        patient.setGlDG(readFloatFromConsole());
        System.out.println("Enter AsAT");
        patient.setAsAT(readFloatFromConsole());
        System.out.println("Enter AlAT");
        patient.setAlAT(readFloatFromConsole());
        System.out.println("Enter HE");
        patient.setHE(readFloatFromConsole());
        System.out.println("Enter GDG");
        patient.setGDG(readFloatFromConsole());
        System.out.println("--");
    }

    private void doDiagnostic(){
        Diagnosis diagnosis = new EnzimLogic();
        diagnosis.diagnose(patient);
        System.out.println(patient.getInjeredOrgan());
        System.out.println(patient.getDisease());
    }

    private String readStringFromConsole(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String consoleInput;
        try {
            consoleInput = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Wrong input! Try again.");
            consoleInput = readStringFromConsole();
        }
        return consoleInput;
    }

    private float readFloatFromConsole(){
        float coefficient = 0.0f;
        try {
            coefficient = Float.parseFloat(readStringFromConsole());
        } catch (NumberFormatException e) {
            System.out.println("Wrong input! Try again.");
            coefficient = readFloatFromConsole();
        }
        return coefficient;
    }


}
