package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.pi.Coefficients;

import java.util.Map;

/**
 * Created by Sergei Riabinin on 11.06.2016.
 */
public interface Diagnosis {

    Map<Integer, String> defineInjuredOrgan(Coefficients coefficients);
    String defineDisease(Coefficients coefficients);
    String getDiagnose(Map<Integer,String> diagnoseMap);

}
