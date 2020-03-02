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
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
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
    String greeting = greetings.get((int) (Math.random() * greetings.size()));
    
    // Converts a ServerStats instance into a JSON string using the Gson library. 
    Gson gson = new Gson();
    String json = gson.toJson(greeting);

    // Send the Json as the response.
    response.setContentType("application/json;");
    response.getWriter().print(json);
  }

   @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the input from the form.
    String message = request.getParameter("messageInput");
<<<<<<< HEAD

=======
>>>>>>> master


<<<<<<< HEAD


=======
>>>>>>> master
    // Redirect the url to index.html.
    response.sendRedirect("index.html");
  }
}
