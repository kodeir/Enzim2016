package java.com.kodeir.enzim2016.ui.cmd;

import java.com.kodeir.enzim2016.logic.Diagnosis;
import java.com.kodeir.enzim2016.logic.EnzimLogic;
import java.com.kodeir.enzim2016.patients.Patient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;

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
        String name = readFromConsole();
        System.out.println("Enter patient surname");
        String surname = readFromConsole();
        patient = new Patient(name,surname);
        System.out.println("--");
    }

    private void fillCoefficients(){
        System.out.println("Enter AsT");
        patient.setAsT(Float.parseFloat(readFromConsole()));
        System.out.println("Enter AlT");
        patient.setAlT(Float.parseFloat(readFromConsole()));
        System.out.println("Enter KFK");
        patient.setKFK(Float.parseFloat(readFromConsole()));
        System.out.println("Enter LDG");
        patient.setLDG(Float.parseFloat(readFromConsole()));
        System.out.println("Enter ShF");
        patient.setShF(Float.parseFloat(readFromConsole()));
        System.out.println("Enter GGTP");
        patient.setGGTP(Float.parseFloat(readFromConsole()));
        System.out.println("Enter GlDG");
        patient.setGlDG(Float.parseFloat(readFromConsole()));
        System.out.println("Enter AsAT");
        patient.setAsAT(Float.parseFloat(readFromConsole()));
        System.out.println("Enter AlAT");
        patient.setAlAT(Float.parseFloat(readFromConsole()));
        System.out.println("Enter HE");
        patient.setHE(Float.parseFloat(readFromConsole()));
        System.out.println("Enter HE");
        patient.setHE(Float.parseFloat(readFromConsole()));
        System.out.println("--");
    }

    private void doDiagnostic(){
        Diagnosis diagnosis = new EnzimLogic();
        diagnosis.diagnose(patient.getAsT(),patient.getAlT(),patient.getKFK(),patient.getLDG(),patient.getShF(),patient.getGGTP(),patient.getGlDG(),patient.getAsAT(),patient.getAlAT(),patient.getHE(),patient.getGDG());
    }

    private String readFromConsole(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String consoleInput = null;
        try {
            consoleInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consoleInput;
    }
}
