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
import java.time.ZoneId;
import java.util.Date;

public interface TimeCategory {

    Date get();
    static DefaultTimeCategory of(int value) {
        return new DefaultTimeCategory(value);
    }

    static ScriptedTimeCategory of(String code) { return new ScriptedTimeCategory(code); }

    default LocalDate getLocalDate() {
        return get().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
