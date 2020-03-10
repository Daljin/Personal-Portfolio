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

/**
 * Fetch a random greetings from /data, then convert to text content and
 * display to the site.
 */
function getComments() {
  fetch('/data').then(response => response.json()).then((imageComments) => {
    // Convert the comment objects to a string
    const commentElement = document.getElementById('comments');

    imageComments.forEach((imageComment) => {
      commentElement.appendChild(createDisplayElement(imageComment));
    })
  });
}

function createDisplayElement(imageComment) {
  const displayBox = document.createElement('div');
  displayBox.setAttribute('class', 'displayBox');

  const imageElement = document.createElement('img');
  imageElement.style.display = 'block';
  imageElement.style.margin = '0 auto';
  imageElement.style.padding = '25px 0px';
  imageElement.src = imageComment.image;

  const commentElement = document.createElement('p');
  commentElement.style.textAlign = 'center';
  commentElement.style.margin = '0';
  commentElement.style.padding = '0px 0px 10px 0px';
  commentElement.innerText = imageComment.message;

  displayBox.appendChild(imageElement);
  displayBox.appendChild(commentElement);
  return displayBox;
}
