/*
 * Copyright 2018 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.tools.ide.analytics;

import org.junit.Assert;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Tests for {@link UsageTrackerSettings}.
 */
public class UsageTrackerSettingsTest {

    @Test
    public void buildWithNullManager_throwsException() {
        try {
            new UsageTrackerSettings.Builder().build();
            Assert.fail("NPE exception expected");
        } catch (NullPointerException npe) {
            // success, exception expected
        }
    }

    @Test
    public void buildWithNonNullManager_createsSettings() {
        UsageTrackerSettings settings = new UsageTrackerSettings.Builder().manager(() -> true).build();
        assertThat(settings).isNotNull();
    }

}
