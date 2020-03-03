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

/** Fetch a random greetings from /data, then convert to text content and display to the site. */
function getComment() {
    fetch('/data').then(response => response.json()).then((allComment) => {
        // Convert the comment objects to a string
        const commentElement = document.getElementById('comments');
        allComment.forEach((allComment) => {
            console.log(allComment);
            commentElement.appendChild(createTaskElement(allComment));
        })
    });
}

/** Creates an element that represents a comment. **/
function createTaskElement(allComment) {
  const commentElement = document.createElement('p');
  commentElement.innerText = allComment
  return commentElement;
}