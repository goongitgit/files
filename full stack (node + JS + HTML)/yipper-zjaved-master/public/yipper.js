/*
 * Name: Zohaib Javed
 * Date: Wednesday, August 17
 * Section: CSE 154 AA
 * Description: This is the JS file that the yipper site uses. It allows to create new yips,
 * see all yips, see yips from a specific user, and provides searchability of yips.
 */

"use strict";
(function() {
  window.addEventListener("load", init);

  /**
   * initialization function
   */
  function init() {
    allYipsRequest();
    let search = document.getElementById('search-term');
    search.addEventListener('input', checkSearchBar);
    let searchBtn = document.getElementById('search-btn');
    searchBtn.addEventListener('click', requestSearch);
    document.getElementById('home-btn').addEventListener('click', showHome);
    document.getElementById('yip-btn').addEventListener('click', showNew);
    document.querySelector('#new form').addEventListener('submit', function(e) {
      e.preventDefault();
      newYip();
    });
  }

  /**
   * create a new yip
   */
  async function newYip() {
    try {
      let formData = new FormData(document.querySelector('#new form'));
      let response = await fetch('/yipper/new', {method: 'POST', body: formData});
      response = await statusCheck(response);
      response = await response.json();
      document.getElementById('home').prepend(constructCard(response));
      document.getElementById('name').value = '';
      document.getElementById('yip').value = '';
      setTimeout(function() {
        showHome();
      }, 2000);
    } catch (error) {
      handleError(error);
    }
  }

  /**
   * Shows new Yip view
   */
  function showNew() {
    document.getElementById('search-btn').disabled = true;
    showView('new');
  }

  /**
   * Show the user view
   */
  async function showUserYips() {
    let username = this.textContent;
    try {
      let response = await fetch('/yipper/user/' + username);
      response = await statusCheck(response);
      response = await response.json();
      populateUserYips(response);
    } catch (error) {
      handleError(error);
    }
  }

  /**
   * Populates user yips and shows user view
   * @param {response} response Response containing user yips
   */
  function populateUserYips(response) {
    let userSection = document.getElementById('user');
    userSection.innerHTML = '';
    let yipsContainer = document.createElement('article');
    yipsContainer.classList.add('single');
    let h2 = document.createElement('h2');
    h2.textContent = 'Yips shared by ' + response[0].name + ':';
    yipsContainer.appendChild(h2);
    let shortYip;
    for (let i = 0; i < response.length; i++) {
      shortYip = document.createElement('p');
      let temp = 'Yip ' + (i + 1) + ': ';
      shortYip.textContent = temp + response[i].yip + ' #' + response[i].hashtag;
      yipsContainer.appendChild(shortYip);
    }
    userSection.appendChild(yipsContainer);
    showView('user');
  }

  /**
   * Show all cards and Clear search bar
   */
  function showHome() {
    showView('home');
    document.getElementById('search-term').value = '';
    let cards = document.querySelectorAll('.card');
    for (let i = 0; i < cards.length; i++) {
      cards[i].classList.remove('hidden');
    }
  }

  /**
   * check if search button shoudl be enabled
   */
  function checkSearchBar() {
    let searchBtn = document.getElementById('search-btn');
    if (this.value.trim().length !== 0) {
      searchBtn = document.getElementById('search-btn');
      searchBtn.disabled = false;
    } else {
      searchBtn.disabled = true;
    }
  }

  /**
   * Makes request to API with search term
   */
  async function requestSearch() {
    showView('home');
    try {
      let searchText = document.getElementById('search-term').value;
      let response = await fetch('/yipper/yips?search=' + searchText);
      response = await statusCheck(response);
      response = await response.json();
      updatePageAfterSearch(response);
    } catch (error) {
      handleError(error);
    }
  }

  /**
   * Updates page to shwo search results
   * @param {searchResponse} searchResponse the ids provided by search response
   */
  function updatePageAfterSearch(searchResponse) {
    let matchingIds = [];
    for (let i = 0; i < searchResponse.yips.length; i++) {
      matchingIds[i] = searchResponse.yips[i].id;
    }
    let cards = document.querySelectorAll('.card');
    for (let i = 0; i < cards.length; i++) {
      if (!matchingIds.includes(parseInt(cards[i].id))) {
        cards[i].classList.add('hidden');
      } else {
        cards[i].classList.remove('hidden');
      }
    }
    document.getElementById('search-btn').disabled = true;
  }

  /**
   * Sued to show selected page and hide all other views
   * @param {viewType} viewType the view type to show
   */
  function showView(viewType) {
    let views = ['home', 'user', 'new', 'error'];
    for (let i = 0; i < 4; i++) {
      if (views[i] === viewType) {
        document.getElementById(views[i]).classList.remove('hidden');
      } else {
        document.getElementById(views[i]).classList.add('hidden');
      }
    }
  }

  /**
   * Requests all yips
   */
  async function allYipsRequest() {
    try {
      let response = await fetch("/yipper/yips");
      response = await statusCheck(response);
      response = await response.json();
      populateAllYips(response);
    } catch (error) {
      handleError(error);
    }
  }

  /**
   * populates all yips
   * @param {response} response array of all yips
   */
  function populateAllYips(response) {
    let homeContainer = document.getElementById('home');
    for (let i = 0; i < response.yips.length; i++) {
      let card = constructCard(response.yips[i]);
      homeContainer.appendChild(card);
    }
  }

  /**
   * Constructs card
   * @param {yip} yip object with yip data
   * @returns {Element} a card container
   */
  function constructCard(yip) {
    let image = document.createElement('img');
    image.src = 'img/' + yip.name.toLowerCase().replaceAll(' ', '-') + '.png';
    image.alt = "a picture of " + yip.name;
    let div1 = document.createElement('div');
    let div1p1 = document.createElement('p');
    div1p1.classList.add('individual');
    div1p1.addEventListener('click', showUserYips);
    div1p1.textContent = yip.name;
    let div1p2 = document.createElement('p');
    div1p2.textContent = yip.yip + ' #' + yip.hashtag;
    div1.appendChild(div1p1);
    div1.appendChild(div1p2);
    let div2 = constructDiv2(yip);
    let cardContainer = document.createElement('article');
    cardContainer.classList.add('card');
    cardContainer.id = yip.id;
    cardContainer.appendChild(image);
    cardContainer.appendChild(div1);
    cardContainer.appendChild(div2);
    return cardContainer;
  }

  /**
   * construct div  for card
   * @param {yip} yip yip object data
   * @returns {Element} a div (div 2)
   */
  function constructDiv2(yip) {
    let div2 = document.createElement('div');
    let div2p = document.createElement('p');
    div2.classList.add('meta');
    div2p.textContent = new Date(yip.date).toLocaleString();
    let div2div = document.createElement('div');
    let div2divimg = document.createElement('img');
    div2divimg.src = 'img/heart.png';
    let div2divp = document.createElement('p');
    div2divimg.addEventListener('click', updateLikes);
    div2divp.textContent = yip.likes;
    div2.appendChild(div2p);
    div2div.appendChild(div2divimg);
    div2div.appendChild(div2divp);
    div2.appendChild(div2div);
    return div2;
  }

  /**
   * update the amount of lieks for a yip
   */
  async function updateLikes() {
    let id = this.parentElement.parentElement.parentElement.id;
    try {
      let data = new FormData();
      data.append("id", id);
      let response = await fetch('/yipper/likes', {method: 'POST', body: data});
      response = await statusCheck(response);
      response = await response.text();
      this.parentElement.querySelector('p').textContent = response;
    } catch (error) {
      handleError(error);
    }
  }

  /**
   * This function is used to display a simple error message if a promise within our .then chain
   * fails.
   */
  function handleError() {
    document.getElementById('yipper-data').classList.add('hidden');
    showView('error');
    document.getElementById('error').classList.remove('hidden');
    let buttons = document.querySelectorAll('#search-btn, #home-btn, #yip-btn');
    for (let i = 0; i < 3; i++) {
      buttons[i].disabled = true;
    }
  }

  /**
   * Checks if the response recieved from the API has a value of 200, indicating it is an okay
   * response.
   * @param {response} response - The Promise object to be checked for an okay value
   * @returns {Object} the response if the response is okay, if not, throws an error.
   */
  async function statusCheck(response) {
    if (!response.ok) {
      throw new Error(await response.text());
    }
    return response;
  }
})();
