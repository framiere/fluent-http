/**
 * Copyright (C) 2013 all@code-story.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package net.codestory.http.misc;

public enum Env {
  INSTANCE;

  private final boolean prodMode;
  private final boolean disableClassPath;
  private final boolean disableFilesystem;
  private final boolean disableGzip;

  private Env() {
    prodMode = getBoolean("PROD_MODE", false);
    disableClassPath = getBoolean("http.disable.classpath", false);
    disableFilesystem = getBoolean("http.disable.filesystem", false);
    disableGzip = getBoolean("http.disable.gzip", false);
  }

  public boolean prodMode() {
    return prodMode;
  }

  public int overriddenPort(int port) {
    return getInt("PORT", getInt("app.port", port));
  }

  public boolean disableClassPath() {
    return disableClassPath;
  }

  public boolean disableFilesystem() {
    return disableFilesystem;
  }

  public boolean disableGzip() {
    return disableGzip;
  }

  private static String get(String propertyName) {
    String env = System.getenv(propertyName);
    return (env != null) ? env : System.getProperty(propertyName);
  }

  private static boolean getBoolean(String propertyName, boolean defaultValue) {
    String value = get(propertyName);
    return (value == null) ? defaultValue : Boolean.parseBoolean(value);
  }

  private static int getInt(String propertyName, int defaultValue) {
    String value = get(propertyName);
    return (value == null) ? defaultValue : Integer.parseInt(value);
  }
}
