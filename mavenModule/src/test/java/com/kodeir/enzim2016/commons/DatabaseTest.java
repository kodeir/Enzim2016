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

package com.kodeir.enzim2016.commons;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Sergei Riabinin on 10.07.2016.
 */
public class DatabaseTest {

    private static Database database;

    private static void deleteDatabse(){
        org.h2.tools.DeleteDbFiles.execute("~/data","testDatabase",true);
    }

    @BeforeClass
    public static void createDatabase(){
        database = new Database();
    }

    @Before
    public void before(){
        deleteDatabse();
    }

    @Test
    public void testSetConnectionExist() throws Exception {
        assertFalse(database.setConnectionExist("testDatabase", "sa", "1lk12l4r; ;124r4r1`"));
    }

    @Test
    public void testSetConnectionNew() throws Exception {
        assertTrue(database.setConnectionNew("testDatabase", "sa", "1lk12l4r; ;124r4r1`"));
    }

    @Test
    public void testCloseConnection() throws Exception {
        assertTrue(database.closeConnection());
    }

    @After
    public void after(){
        deleteDatabse();
    }
}