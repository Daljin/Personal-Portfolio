// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
// Tells the server which URL the servlet maps to.
@WebServlet("/data")
public class DataServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Gson gson = new Gson();
    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(readMessages()));
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    persistMessage(request.getParameter("emailInput"), request.getParameter("messageInput"));

    response.sendRedirect("commentPage.html");
  }

  // Get the input from the form, and sends them to the datastore.
  private void persistMessage(String email, String message) {
    Entity commentEntity = new Entity("Comment");

    commentEntity.setProperty("emailInput", email);
    commentEntity.setProperty("messageInput", message);

    // Store the entity by passing into the datastore.
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(commentEntity);
  }

  private List<String> readMessages() {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Query query = new Query("Comment").addSort("emailInput", SortDirection.DESCENDING);
    PreparedQuery results = datastore.prepare(query);

    List<String> allComments = new ArrayList<String>();

    for (Entity entity : results.asIterable()) {
      String comment = (String) entity.getProperty("messageInput");
      if (comment != null) {
        allComments.add(comment);
      }
    }

    return allComments;
  }
}