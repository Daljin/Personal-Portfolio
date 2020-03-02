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
import java.util.Map;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
// Tells the server which URL the servlet maps to.
@WebServlet("/data")
public class DataServlet extends HttpServlet {
  private List<String> greetings = new ArrayList<>();
  private List<String> messages = new ArrayList<>();

  /** Initializes the DataServlet object which runs when the browser is started. */
  @Override
  public void init() {
    greetings.add("Hola!");
    greetings.add("Hello!");
    greetings.add("Hi!");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Query query = new Query("Comment").addSort("emailInput", SortDirection.DESCENDING);
    PreparedQuery results = datastore.prepare(query);
    
    List<String> userEmail = new ArrayList<String>();
    Map<String, String> userComment = new HashMap<String, String>();
    for (Entity entity : results.asIterable()) {
        String email = (String) entity.getProperty("emailInput");
        String comment = (String) entity.getProperty("messageInput");
        
        userEmail.add(email);
        userComment.put(email, comment);
    }

    String randomUser = userEmail.get((int)(Math.random() * userEmail.size()));
    
    Gson gson = new Gson();

    String merge = randomUser + "\n" + userComment.get(randomUser);

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(merge));
}

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    persistMessage(request.getParameter("emailInput"), request.getParameter("messageInput"));

    // Redirect the url to commentPage.html.
    response.sendRedirect("commentPage.html");
  }

  // Get the input from the form, and sends them to the datastore.
  public void persistMessage(String email, String message) {
    Entity commentEntity = new Entity("Comment");

    commentEntity.setProperty("emailInput", email);
    commentEntity.setProperty("messageInput", message);

    // Store the entity by passing into the datastore.
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(commentEntity);
  }
}