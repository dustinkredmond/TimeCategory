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
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDefaultTimeCategory {

    private final DefaultTimeCategory ONE = TimeCategory.of(1);

    @Test
    public void testSmokeTest() {
        // Basic smoke test. If this fails,
        // we've done something very, very wrong.
        assertNotNull(TimeCategory.of(0));
    }

    @Test
    public void testFromNow() {
        LocalDate d = TestUtils.toLocalDate(ONE.days().from().now().get());
        LocalDate d2 = LocalDate.now();
        assertEquals(1, TestUtils.getDaysBetween(d2, d));

    }

    @Test
    public void testAgo() {
        LocalDate d = TestUtils.toLocalDate(ONE.days().ago().get());
        LocalDate d2 = LocalDate.now();
        assertEquals(-1, TestUtils.getDaysBetween(d2, d));
    }

    @Test
    public void testMinutesAgo() {
        LocalDateTime d = TimeCategory.of(15).minutes().ago().getLocalDateTime();
        LocalDateTime d2 = LocalDateTime.now();
        assertEquals(-15, ChronoUnit.MINUTES.between(d2, d));
    }


}
