package com.kodeir.enzim2016;

import com.kodeir.enzim2016.commons.EnzimDatabase;
import com.kodeir.enzim2016.commons.EnzimLogger;
import com.kodeir.enzim2016.commons.InitialDatabase;
import com.kodeir.enzim2016.ui.cmd.CmdUi;
import com.kodeir.enzim2016.ui.swing.SwingApp;

import java.util.logging.Level;

/*
 * Copyright (c) 2007, 2016 Vyacheslav Ryabinin and/or his affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Vyacheslav Ryabinin or the names of his
 *     affiliates may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/**
 * Created by Sergei Riabinin on 5/31/16.
 *
 * The Enzim application implements diagnostic algorithms for liver diseases,
 * which was introduced by Vyacheslav Ryabinin in "The development and use
 * of new approaches to the analysis of laboratory and biochemical tests
 * for the differential diagnosis of liver diseases.", Chelyabinsk, 2007.
 *
 */
public class Enzim {

    private static final EnzimLogger logger = new EnzimLogger(Enzim.class.getName());

    public static void main(String[] args) {
        checkDatabase();
        if (args.length != 0) {
            logger.log(Level.INFO, "Starting in CMD mode;");
            CmdUi.startCmd();
        } else {
            logger.log(Level.INFO, "Starting with GUI;");
            SwingApp.startSwing();
        }
    }

    private static void checkDatabase(){
        if (!InitialDatabase.checkIfDbFileExists()){
            logger.log(Level.INFO, "Creating database;");
            InitialDatabase.createInitialDatabase();
        } else {
            logger.log(Level.INFO, "Existing database is used;");
        }
    }
}
