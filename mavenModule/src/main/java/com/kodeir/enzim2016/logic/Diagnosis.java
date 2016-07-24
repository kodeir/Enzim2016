package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.pi.Coefficients;

/**
 * Created by Sergei Riabinin on 11.06.2016.
 */
public interface Diagnosis {

    String defineInjuredOrgan(Coefficients coefficients);
    String defineDisease(Coefficients coefficients);
}
