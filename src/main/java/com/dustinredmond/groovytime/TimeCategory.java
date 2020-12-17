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
import java.util.Date;

/**
 * {@code} TimeCategory is a wrapper class for {@code groovy.time.TimeCategory} and
 * it's DSL. All API methods are reached through this interface's static methods.
 */
public interface TimeCategory {

    /**
     * A builder-like syntax for Groovy's {@code TimeCategory} class that
     * may be more familiar to Java developers.
     * @param value An initial starting unit
     * @return TimeCategory in which date is retrieved via
     *         Java builder-style syntax.
     */
    static DefaultTimeCategory of(int value) {
        return new DefaultTimeCategory(value);
    }

    /**
     * Invokes a call to {@code groovy.time.TimeCategory}'s DSL.
     * <p>Examples:
     * <ul>
     *     <li>TimeCategory.of("2.days.from.now")</li>
     *     <li>TimeCategory.of("14.minutes.ago")</li>
     *     <li>TimeCategory.of("52.weeks.ago")</li>
     * </ul>
     * </p>
     * @param code The Groovy DSL for {@code TimeCategory}
     * @return TimeCategory in which date is retrieved via DSL
     */
    static ScriptedTimeCategory of(String code) {
        return new ScriptedTimeCategory(code);
    }

    /**
     * Returns a @{code java.util.Date}
     * @return Date as determined by {@code groovy.time.TimeCategory}
     */
    Date get();

    /**
     * Returns a {@code java.time.LocalDate}
     * @return A {@code LocalDate} retrieved from {@code groovy.time.TimeCategory}
     */
    default LocalDate getLocalDate() {
        return get().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Returns a {@code java.time.LocalDateTime}
     * @return A {@code LocalDate} retrieved from {@code groovy.time.TimeCategory}
     */
    default LocalDateTime getLocalDateTime() {
        return get().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
