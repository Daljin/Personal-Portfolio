<%-- The Java code in this JSP file runs on the server when the user navigates
     to the homepage. This allows us to insert the Blobstore upload URL into the
     form without building the HTML using print statements in a servlet. --%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<% BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
   String uploadUrl = blobstoreService.createUploadUrl("/data"); %>

<!DOCTYPE html>
<html>
  <head>
    <title>Eduardo Heredia - UTD Student</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" type="/image/jpg" href="/images/favicon/jettSmug.jpg"/>
    <link rel="stylesheet" href="style.css">
    <script src="script.js"></script>
  </head>
  <body>
      <div id="intro">
          <div class="aboutContent">
                <div class="headStyle" >
                    <!-- The inverted exclamation point is causing minor problems. Might be the unicode or something.-->
                    <h2>Hola! I'm Eduardo Heredia!</h2>
                </div>
                <div>
                <p>
                    I'm a student at The University of Texas at Dallas, studying for my Bachelor Degree
                    in Software Engineering. I'm first generation of my family, along with my siblings, to attend a university, so
                    I hope I will be part of multiple opportunities.
                    <br><br>
                    I'm interested in two fields, with the first being Game Development. Video games have been a part
                    of my life since I first got into Mario 64 and World of Warcraft. Since then, I played multiple
                    games from different genres, and I found a good variety of games that are made with care and remarkable creativity.
                    I want to develop a game, starting small, and work my creativity to showcase to others. I think that's
                    going to be fun!
                    <br><br>
                    The second field is Cyber Security. This field is one I can go forward in jobs because of the field itself is in high demand, and it's a very crucial field for the world of technology. Cyber Security is a career where I want to help others in protecting their information and securing vital data from individuals who seek to harm others. Personally, whenever I help someone, my day gets better.
                </p>
                </div>
          </div>
      </div>
      <div id="education" class="educationBackground">
          <div class="headStyle"><h2> Education </h2></div>
          <div class="displayBox">
              <div class="educationText">
                  <h2>The University of Texas at Dallas</h2>
                  <h4>Expected: May 2022</h4>
                  <h3>Bachelor of Science in Software Engineering</h3>
                  <h4>GPA: 3.49</h4>
                  <ul>
                      <li>
                          Classes
                          <ul>
                              <li>Computer Science I&II</li>
                              <li>Discrete I&II</li>
                              <li>Computer Architecture</li>
                              <!--<li>Data Structure & Algorithm</li>
                              <li>C/C++ Programming in Unix Environment</li>-->
                          </ul>
                      </li>
                  </ul>
              </div>
          </div>
      </div>
      <div id="skill" class="skillBackground">
          <div class="headStyle"><h2> Skills </h2></div>
          <ul>
              <li>C/C++</li>
              <li>Java</li>
              <li>HTML/CSS</li>
              <li>Java-Script</li>
              <li>Assembly</li>
              <li>MongoDB</li>
              <li>ExpressJS</li>
              <li>AngularJS</li>
              <li>NodeJS</li>
          </ul>
          <div class="headStyle"><h2>Language</h2></div>
          <ul>
              <li>English</li>
              <li>Spanish</li>
          </ul>
      </div>
      <div id="project" class="projectBackground">
          <div class="headStyle"><h2> Projects </h2></div>
              <div class="displayBox">
                  <div class="projectText">
                      <h2>
                          Unorthodox Mapping
                      </h2>
                      <p>
                          Team-Based Project. Created a site that searches locations and users based on user's preferences.
                      </p>
                  </div>
              </div>
              <div class="displayBox">
                  <div class="projectText">
                      <h2>
                          Closest-Hangr
                      </h2>
                      <p>
                          Team-Based Project. Organize the team in assigning roles and tasks, and managed the github repository.
                      </p>
                      
                  </div>
              </div>
      </div>
      <footer>
          <div class="socialLink">
              <div class="contact" >
                    <h2>Leave a Message and Image!</h2>
                    <form method="POST" enctype="multipart/form-data" action="<%= uploadUrl %>">
                        <input type="file" name="image">
                        <textarea id="message" name="message" placeholder="Your messages" required></textarea>
                        <input type="submit" value="Submit">
                  </form>
              </div>
              <ul>
                  <li>
                      <a name="github-link" href="https://github.com/Daljin">
                            <img src="/images/githubLogo.png" alt="github" style="width: 6%; height: auto;">
                      </a>
                  </li>
                  <li>
                      <a name="linkedin-link" href="https://www.linkedin.com/in/eduardo-heredia/">
                            <img src="/images/linkedinLogo.png" alt="linkedin" style="width: 7%; height: auto;">
                      </a>
                  </li>
              </ul>
          </div>
      </footer>
  </body>
</html>
