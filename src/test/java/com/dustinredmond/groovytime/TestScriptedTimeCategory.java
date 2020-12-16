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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestScriptedTimeCategory {


    /**
     * If this passes, we really don't need to test anything else, as
     * the rest is handled via Apache Groovy via the GroovyShell object.
     */
    @Test
    public void testScriptedTimeCategory() {
        LocalDate d = TestUtils.toLocalDate(TimeCategory.of("1.day.ago").get());
        LocalDate d2 = LocalDate.now();
        long daysBetween = TestUtils.getDaysBetween(d2, d);
        assertEquals(-1, daysBetween);
    }

    @Test
    public void testGetLocalDate() {
        LocalDate d = TimeCategory.of("1.day.ago").getLocalDate();
        LocalDate d2 = LocalDate.now();
        long daysBetween = TestUtils.getDaysBetween(d2, d);
        assertEquals(-1, daysBetween);
    }

    @Test
    public void testMinutesBetween() {
        LocalDateTime d = TimeCategory.of("15.minutes.ago").getLocalDateTime();
        LocalDateTime d2 = LocalDateTime.now();
        assertEquals(-15, ChronoUnit.MINUTES.between(d2, d));
    }

    @Test
    public void test15MinutesFromNow() {
        LocalDateTime d = TimeCategory.of("15.minutes.from.now").getLocalDateTime();
        LocalDateTime d2 = LocalDateTime.now();
        assertEquals(14, ChronoUnit.MINUTES.between(d2, d));
    }

    @Test
    public void test20MinutesFromNow() {
        LocalDateTime d = TimeCategory.of("20.minutes.from.now").getLocalDateTime();
        LocalDateTime d2 = LocalDateTime.now();
        assertEquals(19, ChronoUnit.MINUTES.between(d2, d));
    }

}
