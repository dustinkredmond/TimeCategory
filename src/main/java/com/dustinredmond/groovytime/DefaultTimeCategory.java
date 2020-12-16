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
import java.time.LocalDate;
import java.util.Date;
import java.util.StringJoiner;

@SuppressWarnings("unused")
public class DefaultTimeCategory implements TimeCategory {

    private StringJoiner sj = new StringJoiner(".");

    public DefaultTimeCategory(int value) {
        sj.add(String.valueOf(value));
    }

    public DefaultTimeCategory day() {
        sj.add("day");
        return this;
    }

    public DefaultTimeCategory days() {
        sj.add("days");
        return this;
    }

    public DefaultTimeCategory hour() {
        sj.add("hour");
        return this;
    }

    public DefaultTimeCategory hours() {
        sj.add("hours");
        return this;
    }

    public DefaultTimeCategory week() {
        sj.add("week");
        return this;
    }

    public DefaultTimeCategory weeks() {
        sj.add("weeks");
        return this;
    }

    public DefaultTimeCategory minute() {
        sj.add("minute");
        return this;
    }

    public DefaultTimeCategory minutes() {
        sj.add("minutes");
        return this;
    }

    public DefaultTimeCategory second() {
        sj.add("second");
        return this;
    }

    public DefaultTimeCategory seconds() {
        sj.add("seconds");
        return this;
    }

    public DefaultTimeCategory millisecond() {
        sj.add("millisecond");
        return this;
    }

    public DefaultTimeCategory milliseconds() {
        sj.add("milliseconds");
        return this;
    }

    public DefaultTimeCategory month() {
        sj.add("month");
        return this;
    }

    public DefaultTimeCategory months() {
        sj.add("months");
        return this;
    }

    public DefaultTimeCategory year() {
        sj.add("year");
        return this;
    }

    public DefaultTimeCategory years() {
        sj.add("years");
        return this;
    }

    public DefaultTimeCategory from() {
        sj.add("from");
        return this;
    }

    public DefaultTimeCategory now() {
        sj.add("now");
        return this;
    }

    public DefaultTimeCategory ago() {
        sj.add("ago");
        return this;
    }

    public DefaultTimeCategory today() {
        sj.add("today");
        return this;
    }

    @Override
    public Date get() {
        GroovyShell shell = new GroovyShell();
        String code = sj.toString();
        sj = new StringJoiner(".");
        return (Date) shell.evaluate("Date date = new Date(); "
            + "use (groovy.time.TimeCategory) { date = " + code + " }; "
            + "return date");
    }

    @Override
    public String toString() {
        return get().toString();
    }
}
