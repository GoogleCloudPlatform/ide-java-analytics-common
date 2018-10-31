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

public class TestUsage {

  //    private final UsageTracker usageTracker;

  public TestUsage() {
    //        UsageTrackerManager manager = new UsageTrackerManager() {
    //            @Override
    //            public boolean isTrackingEnabled() {
    //                return true;
    //            }
    //        };
    //        UsageTrackerSettings settings = new UsageTrackerSettings.Builder()
    //                .manager(manager)
    //                .analyticsId("UA-36037335-1")
    //                .pageHost("virtual.intellij")
    //                .platformName("idea")
    //                .platformVersion("2018.2.0.0")
    //                .pluginName("gcloud-intellij")
    //                .pluginVersion("18.4.2-SNAPSHOT")
    //                .clientId("123454321")
    //                .userAgent("gcloud-intellij-cloud-tools-plugin/18.4.2-SNAPSHOT (IntelliJ IDEA
    // Ultimate Edition/IU-182.3684.90)")
    //                .build();
    //
    //        usageTracker = UsageTracker.create(settings);
  }

  public static void main(String[] args) {
    UsageTrackerManager manager =
        new UsageTrackerManager() {
          @Override
          public boolean isTrackingEnabled() {
            return true;
          }
        };
    UsageTrackerSettings settings =
        new UsageTrackerSettings.Builder()
            .manager(
                () -> {
                  return false;
                })
            .analyticsId("UA-36037335-1")
            .pageHost("virtual.intellij")
            .platformName("idea")
            .platformVersion("2018.2.0.0")
            .pluginName("gcloud-intellij")
            .pluginVersion("18.4.2-SNAPSHOT")
            .clientId("123454321")
            .userAgent(
                "gcloud-intellij-cloud-tools-plugin/18.4.2-SNAPSHOT (IntelliJ IDEA Ultimate Edition/IU-182.3684.90)")
            .build();

    UsageTracker tracker = UsageTracker.create(settings);

    tracker.trackEvent("just-a-test").addMetadata("foo", "bar").ping();
  }
}
