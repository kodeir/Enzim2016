/*
 * Copyright (c) 2007, 2016 Vyacheslav Ryabinin and/or his affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Vyacheslav Ryabinin or the names of his
 *     affiliates may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 *  THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.kodeir.enzim2016.ui.swing.commons;

import java.awt.*;

/**
 * Created by Sergei Riabinin on 03.07.2016.
 */
public class EnzimSwingCommons {

    public static GridBagConstraints setConstraintsHorizontal(double weightx, int gridx, int gridy){
        return setConstraintsHorizontal(weightx, gridx, gridy, 1);
    }

    public static GridBagConstraints setConstraintsHorizontal(double weightx, int gridx, int gridy, int gridwidth){
        return setConstraintsHorizontal(weightx, gridx, gridy, gridwidth, 1);
    }

    public static GridBagConstraints setConstraintsHorizontal(double weightx, int gridx, int gridy, int gridwidth, int gridheight){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = weightx;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.ipady = 5;
        return constraints;
    }

    public static void setSize(Component component, int width, int height){
        component.setMinimumSize(new Dimension(width,height));
        component.setMaximumSize(new Dimension(width,height));
        component.setPreferredSize(new Dimension(width,height));
    }
}
