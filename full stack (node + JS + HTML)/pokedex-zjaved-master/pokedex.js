/*
 * Name: Zohaib Javed
 * Date: August 1st 2022
 * Section: CSE 154 AA
 *
 * This is the JS file which implements functionality for the game pokemon. It allows the user to
 * click on sprites to select pokemon, then battle other randomly selected pokemon. After choosing a
 * pokemon and starting a battle P2 (computer)'s card will appear and fight with your pokemon
 * eery time you choose an attack/move. Beaten pokemon then appear as selectable sprites at the
 * pokedex homepage.
 * All HTML elements are modified using this file to keep in line with
 * separation of concerns.
 */

"use strict";
(function() {
  window.addEventListener("load", init);

  /**
   * init function that adds responsiveness to buttons after page loads
   */
  function init() {
    makeRequestPokedex();
    document.getElementById("start-btn").addEventListener("click", startBattle);
    document.getElementById("flee-btn").addEventListener("click", flee);
    document.getElementById("endgame").addEventListener("click", returnToMenu);
  }

  const BASE_URL = "https://courses.cs.washington.edu/courses/cse154/webservices/pokedex/";
  const GAME_URL = "https://courses.cs.washington.edu/courses/cse154/webservices/pokedex/game.php";
  let selectedPokemon;
  let otherPokemon;
  let gameId;
  let playerId;
  let hp;

  /**
   * Changes view to game view, shows result content, health bar, etc.
   */
  function startBattle() {
    hideAndShowOnStart();

    let data = new FormData();
    data.append("startgame", "true");
    data.append("mypokemon", "" + selectedPokemon);
    fetch(GAME_URL, {method: 'POST', body: data})
      .then(statusCheck)
      .then(res => res.json())
      .then(populateCardHelper)
      .catch(console.error);
    let buttons = document.querySelectorAll("#p1 .moves button");
    for (let i = 0; i < buttons.length; i++) {
      buttons[i].disabled = false;
    }

    let moveButtons = document.querySelectorAll("#p1 .card button");
    for (let i = 0; i < moveButtons.length; i++) {
      if (moveButtons[i].disabled === false) {
        moveButtons[i].addEventListener("click", attack);
      }
    }
  }

  /**
   * Hides and shows necessary elements when battle is started. Resets
   * elements to ensure data from previous game does not appear.
   */
  function hideAndShowOnStart() {
    document.getElementById("pokedex-view").classList.add("hidden");
    document.getElementById("start-btn").classList.add("hidden");

    document.querySelector(".hp-info").classList.remove("hidden");
    document.getElementById("flee-btn").classList.remove("hidden");
    document.getElementById("p2").classList.remove("hidden");

    document.querySelector("header h1").textContent = "Pokemon Battle!";
    document.getElementById("results-container").classList.remove("hidden");
    document.querySelector("#p1 .health-bar").style.width = "100%";
    document.querySelector("#p2 .health-bar").style.width = "100%";
    document.querySelector("#p1 .health-bar").classList.remove("low-health");
    document.querySelector("#p2 .health-bar").classList.remove("low-health");
    document.getElementById("p1-turn-results").textContent = "";
    document.getElementById("p2-turn-results").textContent = "";
  }

  /**
   * This function hides game elements including the health bar, p2, and results and
   * reverts back to the pokedex view.
   */
  function returnToMenu() {
    document.getElementById("pokedex-view").classList.remove("hidden");
    document.getElementById("start-btn").classList.remove("hidden");

    document.getElementById("p2").classList.add("hidden");
    document.getElementById("results-container").classList.add("hidden");
    document.querySelector("#p1 .hp-info").classList.add("hidden");
    document.getElementById("endgame").classList.add("hidden");
    document.querySelector("header h1").textContent = "Your Pokedex";
    document.getElementById("flee-btn").classList.add("hidden");

    document.querySelector("header h1").textContent = "Your Pokedex";
    document.querySelector("#p1 .hp").textContent = hp + "HP";
  }

  /**
   * This function chanages the game page's elements when the player flees from
   * the battle. It reduces the health to zero and shows the result of the game
   * after fleeing.
   */
  function flee() {
    let buttons = document.querySelectorAll("#p1 .moves button");
    for (let i = 0; i < buttons.length; i++) {
      buttons[i].disabled = true;
    }
    let data = new FormData();
    data.append("guid", gameId);
    data.append("pid", playerId);
    data.append("movename", "flee");
    fetch(GAME_URL, {method: 'POST', body: data})
      .catch(console.error);
    document.querySelector("#p1 .hp").textContent = "0HP";
    document.querySelector("#p1 .health-bar").style.width = "0%";
    document.querySelector("#p1 .health-bar").classList.add("low-health");
    document.getElementById("p1-turn-results").classList.remove("hidden");
    document.getElementById("p1-turn-results").textContent = "Player 1 played flee and lost!";
    document.getElementById("p2-turn-results").textContent = "";
    document.querySelector("header h1").textContent = "You Lost!";
    document.getElementById("endgame").classList.remove("hidden");
    document.getElementById("flee-btn").classList.add("hidden");
  }

  /**
   * Sends chosen attack move to game API and shows pikachu loading sprite while
   * waiting for API to respond.
   */
  async function attack() {
    let move = this.querySelector(".move").textContent.toLowerCase();
    move = move.replace(/\s/g, '');
    try {
      document.getElementById("loading").classList.remove("hidden");
      let data = new FormData();
      data.append("guid", gameId);
      data.append("pid", playerId);
      data.append("movename", move);
      let response = await fetch(GAME_URL, {method: 'POST', body: data});
      response = await statusCheck(response);
      response = await response.json();
      document.getElementById("loading").classList.add("hidden");
      updatePage(response);
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * After an attack is sent to the game API, the response results (health, moves) sent back
   * are used to populate the current state of the game.
   * @param {response} response The JS object with updated game data.
   */
  function updatePage(response) {
    document.getElementById("p1-turn-results").classList.remove("hidden");
    document.getElementById("p2-turn-results").classList.remove("hidden");

    if (response.p1["current-hp"] >= 0) {
      let resultP1String = "Player 1 played " + response.results["p1-move"];
      resultP1String += " and " + response.results["p1-result"];
      document.getElementById("p1-turn-results").textContent = resultP1String;
    }
    if (response.p2["current-hp"] !== 0) {
      let resultP2String = "Player 2 played " + response.results["p2-move"];
      resultP2String += " and " + response.results["p2-result"];
      document.getElementById("p2-turn-results").textContent = resultP2String;
    } else {
      document.getElementById("p2-turn-results").classList.add("hidden");
    }
    if ((response.p1["current-hp"] / response.p1.hp) < 0.2) {
      document.querySelector("#p1 .health-bar").classList.add("low-health");
    }
    if ((response.p2["current-hp"] / response.p2.hp) < 0.2) {
      document.querySelector("#p2 .health-bar").classList.add("low-health");
    }
    updateHelper(response);
  }

  /**
   * helper function for updating page elements
   * @param {response} response response object used to update game state
   */
  function updateHelper(response) {
    let width = (response.p1["current-hp"] / response.p1.hp) * 100 + "%";
    document.querySelector("#p1 .health-bar").style.width = width;
    width = (response.p2["current-hp"] / response.p2.hp) * 100 + "%";
    document.querySelector("#p2 .health-bar").style.width = width;
    document.querySelector("#p1 .hp").textContent = response.p1["current-hp"] + "HP";
    document.querySelector("#p2 .hp").textContent = response.p2["current-hp"] + "HP";
    if (response.p1["current-hp"] === 0) {
      endGame("p1");
    } else if (response.p2["current-hp"] === 0) {
      endGame("p2");
    }
  }

  /**
   * Hides the flee button and shows the pokedex menu button. Disables buttons for p1.
   * @param {player} player lets the function know which player won.
   */
  function endGame(player) {
    document.querySelector("#p1 #flee-btn").classList.add("hidden");
    document.querySelector("#p1 #endgame").classList.remove("hidden");
    let buttons = document.querySelectorAll("#p1 .moves button");
    for (let i = 0; i < buttons.length; i++) {
      buttons[i].disabled = true;
    }

    if (player === "p1") {
      document.querySelector("header h1").textContent = "You Lost!";

    } else {
      document.querySelector("header h1").textContent = "You Won!";
      let sprites = document.querySelectorAll("#pokedex-view .sprite");
      for (let i = 0; i < sprites.length; i++) {
        if (sprites[i].alt.substring(18, sprites[i].alt.length) === otherPokemon) {
          sprites[i].classList.add("found");
          sprites[i].addEventListener("click", populateCardRequestHelper);
        }
      }
    }
  }

  /**
   * Make the request for the list of all pokemon
   */
  function makeRequestPokedex() {
    fetch(BASE_URL + "pokedex.php?pokedex=all")
      .then(statusCheck)
      .then(res => res.text())
      .then(populatePokedex)
      .catch(console.error);
  }

  /**
   * Uses the response for the pokemon list query, and populates the pokedex with sprites.
   * @param {response} response List of all pokemon names (Full name:Short Name)
   */
  function populatePokedex(response) {
    let shortNames = response.split("\n");
    let spriteImg = document.createElement("img");
    let spriteContainer = document.getElementById("pokedex-view");
    let baseSpriteUrl = BASE_URL + "sprites/";
    for (let i = 0; i < shortNames.length; i++) {
      shortNames[i] = shortNames[i].substring(shortNames[i].indexOf(":") + 1, shortNames[i].length);
      spriteImg = document.createElement("img");
      spriteImg.classList.add("sprite");
      let temp1 = shortNames[i] === "squirtle";
      let temp2 = shortNames[i] === "charmander" || shortNames[i] === "bulbasaur";
      if (temp1 || temp2) {
        spriteImg.classList.add("found");
        spriteImg.addEventListener("click", populateCardRequestHelper);
      }
      spriteImg.src = baseSpriteUrl + shortNames[i] + ".png";
      spriteImg.alt = "A sprite image of " + shortNames[i];
      spriteContainer.appendChild(spriteImg);
    }
  }

  /**
   * When a found sprite is clicked, this function is called. It will fetch the pokemon
   * info for the clicked sprite.
   * @param {event} event included in order to be able to properly pass pokName
   * @param {pokName} pokName optional parameter passed to specify what pokemon to populate card
   * with.
   */
  function populateCardRequestHelper(event, pokName) {
    let name;
    if (pokName === undefined) {
      let alt = this.alt;
      name = alt.substring(18, alt.length);
      selectedPokemon = name;
    } else {
      name = pokName;
      selectedPokemon = name;
    }
    let pokParamsUrl = BASE_URL + "pokedex.php?pokemon=";
    fetch(pokParamsUrl + name)
      .then(statusCheck)
      .then(res => res.json())
      .then(populateCard)
      .catch(console.error);
  }

  /**
   * Helper function called for populating p2's card when a battle is started.
   * @param {response} response response from sending intial POST to game API (has p1 and p2 info)
   */
  function populateCardHelper(response) {
    gameId = response.guid;
    playerId = response.pid;
    otherPokemon = response.p2.shortname;
    populateCard(response, "p2");
  }

  /**
   * Main function that populates card with pokemon data.
   * @param {response} response response from game API or pokedex API
   * @param {player} player String indicating which player's card to populate
   */
  function populateCard(response, player) {
    helper1(response, player);
    if (player !== "p2") {
      player = "p1";
    }
    let moveButtons = document.querySelectorAll("#" + player + " .moves button");
    let moveSpans = document.querySelectorAll("#" + player + " .moves .move");
    let moveDps = document.querySelectorAll("#" + player + " .moves .dp");
    let moveImgs = document.querySelectorAll("#" + player + " .moves img");
    let movesInJson;
    if (player === "p2") {
      helper2(response, "p2");
      movesInJson = response.p2.moves;
    } else {
      helper3(response, "p1");
      movesInJson = response.moves;
    }
    for (let i = 0; i < 4; i++) {
      if (i < movesInJson.length) {
        moveButtons[i].classList.remove("hidden");
        moveSpans[i].textContent = movesInJson[i].name;
        if (movesInJson[i].dp !== undefined) {
          moveDps[i].textContent = movesInJson[i].dp + " DP";
        }
        moveImgs[i].src = BASE_URL + "icons/" + movesInJson[i].type + ".jpg";
      } else {
        moveButtons[i].classList.add("hidden");
      }
    }
  }

  /**
   * helper function for populating card
   * @param {response} response response object
   * @param {player} player identifies player to be populated
   */
  function helper1(response, player) {
    if (player === "p2") {
      clearPreviousData(player);
    }
    if (player !== "p2") {
      clearPreviousData("p1");
      hp = response.hp;
    }
  }

  /**
   * helper function for populating card
   * @param {response} response response object
   * @param {player} player lets function know what player to pop card for
   */
  function helper2(response, player) {
    let cardName = document.querySelector("#" + player + " .name");
    let cardPokePic = document.querySelector("#" + player + " .pokepic");
    let cardType = document.querySelector("#" + player + " .type");
    let cardWeakType = document.querySelector("#" + player + " .weakness");
    let hpSpan = document.querySelector("#" + player + " .hp");
    let descriptionTag = document.querySelector("#" + player + " .info");
    cardName.textContent = response.p2.name;
    cardPokePic.src = BASE_URL + response.p2.images.photo;
    cardType.src = BASE_URL + response.p2.images.typeIcon;
    cardWeakType.src = BASE_URL + response.p2.images.weaknessIcon;
    hpSpan.textContent = response.p2.hp + "HP";
    descriptionTag.textContent = response.p2.info.description;
  }

  /**
   * helper function for populating card
   * @param {response} response response object
   * @param {player} player lets function know what player to pop card for
   */
  function helper3(response, player) {
    let cardName = document.querySelector("#" + player + " .name");
    let cardPokePic = document.querySelector("#" + player + " .pokepic");
    let cardType = document.querySelector("#" + player + " .type");
    let cardWeakType = document.querySelector("#" + player + " .weakness");
    let hpSpan = document.querySelector("#" + player + " .hp");
    let descriptionTag = document.querySelector("#" + player + " .info");
    document.getElementById("start-btn").classList.remove("hidden");
    cardName.textContent = response.name;
    cardPokePic.src = BASE_URL + response.images.photo;
    cardType.src = BASE_URL + response.images.typeIcon;
    cardWeakType.src = BASE_URL + response.images.weaknessIcon;
    hpSpan.textContent = response.hp + "HP";
    descriptionTag.textContent = response.info.description;
  }

  /**
   * Makes sure that when a card is populated that it doenst add on to previous data by
   * setting text contnt of elements to an empty string.
   * @param {player} player the player's card to reset
   */
  function clearPreviousData(player) {
    document.querySelector("#" + player + " .name").textContent = "";
    document.querySelector("#" + player + " .pokepic").src = "";
    document.querySelector("#" + player + " .type").src = "";
    document.querySelector("#" + player + " .weakness").src = "";

    document.querySelector("#" + player + " .hp").textContent = "";

    document.querySelector("#" + player + " .info").textContent = "";

    let moveSpans = document.querySelectorAll("#" + player + " .moves .move");
    let moveDps = document.querySelectorAll("#" + player + " .moves .dp");
    let moveImgs = document.querySelectorAll("#" + player + " .moves img");

    for (let i = 0; i < 4; i++) {
      moveSpans[i].textContent = "";
      moveDps[i].textContent = "";
      moveImgs[i].src = "";
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