package com.dustinredmond.groovytime;

/*
 *  Copyright 2020  Dustin K. Redmond
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import groovy.lang.GroovyShell;
import java.util.Date;

public class ScriptedTimeCategory implements TimeCategory {

    private final String code;

    public ScriptedTimeCategory(String code) {
        this.code = code;
    }

    @Override
    public Date get() {
        GroovyShell shell = new GroovyShell();
        return (Date) shell.evaluate("Date date = new Date(); "
            + "use (groovy.time.TimeCategory) { date = " + this.code + " }; "
            + "return date");
    }

}
