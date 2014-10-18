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
package net.codestory.http;

import java.io.*;
import java.net.*;
import java.util.*;

import net.codestory.http.internal.*;

public interface Request extends Unwrappable {
  String uri();

  String method();

  String content() throws IOException;

  String contentType();

  List<String> headerNames();

  List<String> headers(String name);

  String header(String name);

  public default String header(String name, String defaultValue) {
    String value = header(name);
    return (value == null) ? defaultValue : value;
  }

  InputStream inputStream() throws IOException;

  InetSocketAddress clientAddress();

  boolean isSecure();

  Cookies cookies();

  Query query();

  List<Part> parts();
}
