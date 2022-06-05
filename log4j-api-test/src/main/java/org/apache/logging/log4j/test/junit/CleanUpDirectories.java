/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */

package org.apache.logging.log4j.test.junit;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * JUnit extension to automatically clean up a list of directories and their contents before and after test execution.
 * This will automatically retry deletion up to 10 times per file while pausing for 200ms each time.
 * These can be overridden with system properties {@value AbstractFileCleaner#MAX_TRIES_PROPERTY} and
 * {@value AbstractFileCleaner#SLEEP_PERIOD_MILLIS_PROPERTY}.
 *
 * @see DirectoryCleaner
 * @see CleanUpFiles
 * @since 2.14.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Inherited
@ExtendWith(DirectoryCleaner.class)
public @interface CleanUpDirectories {
    String[] value();
}
