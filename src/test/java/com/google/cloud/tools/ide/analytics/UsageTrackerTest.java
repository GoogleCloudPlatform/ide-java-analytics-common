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

import static com.google.common.truth.Truth.assertThat;

import org.junit.Assert;
import org.junit.Test;

/** Tests for {@link UsageTracker}. */
public class UsageTrackerTest {

  @Test
  public void createWithNullSettings_throwsException() {
    try {
      UsageTracker.create(null);
      Assert.fail("Exception expected");
    } catch (NullPointerException npe) {
      // success, exception expected
    }
  }

  @Test
  public void createWithTrackingEnabled_returnsGoogleUsageTracker() {
    UsageTracker tracker = UsageTracker.create(newUsageTrackerSettings(() -> true));

    assertThat(tracker).isInstanceOf(GoogleUsageTracker.class);
  }

  @Test
  public void createWithTrackingDisabled_returnsNoOpUsageTracker() {
    UsageTracker tracker = UsageTracker.create(newUsageTrackerSettings(() -> false));

    assertThat(tracker).isInstanceOf(NoOpUsageTracker.class);
  }

  private static UsageTrackerSettings newUsageTrackerSettings(UsageTrackerManager manager) {
    return new UsageTrackerSettings.Builder()
        .manager(manager)
        .analyticsId("123")
        .clientId("123")
        .pageHost("host")
        .platformName("platform")
        .platformVersion("platform-version")
        .pluginName("plugin")
        .pluginVersion("plugin-version")
        .userAgent("agent")
        .build();
  }
}
