package com.kodeir.enzim2016.logic;

import com.kodeir.enzim2016.thesaurus.Diseases;

/**
 * Created by Rowan on 11.06.2016.
 */
public interface Diagnosis {

    Diseases diagnose(float asT, float alT, float KFK, float LDG, float shF, float GGTP, float glDG, float asAT, float alAT, float HE, float GDG);
}
