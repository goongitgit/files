/*
 * Name: Zohaib Javed
 * Date: July 19 2022
 * Section: CSE 154 AA
 *
 * This is the JS file which implements functionality for the game Set!
 * All HTML elements are modified using this file to keep in line with
 * separation of concerns.
 */

"use strict";
(function() {
  // Required module globals
  let timerId;
  let remainingSeconds;
  const STYLE = ["solid", "outline", "striped"];
  const COLOR = ["green", "purple", "red"];
  const SHAPE = ["diamond", "oval", "squiggle"];
  const COUNT = [1, 2, 3];

  window.addEventListener("load", init);

  /**
   * Adds event listeners after page loads.
   */
  function init() {
    let startButton = document.getElementById("start-btn");
    let backButton = document.getElementById("back-btn");
    let refreshButton = document.getElementById("refresh-btn");
    refreshButton.addEventListener("click", function() {
      populateBoard("refresh");
    });
    startButton.addEventListener("click", toggleViews);
    startButton.addEventListener("click", startTimer);
    startButton.addEventListener("click", populateBoard);
    backButton.addEventListener("click", toggleViews);
    backButton.addEventListener("click", function() {
      endGame("back");
    });
  }

  // Required functions to implement are below
  /**
   * Toggles view between menu and game mode.
   */
  function toggleViews() {
    let gameView = document.getElementById("game-view");
    let mainView = document.getElementById("menu-view");
    mainView.classList.toggle("hidden");
    gameView.classList.toggle("hidden");
  }

  /**
   * Generates an array of randomly selected attributes for a card.
   * @param {isEasy} isEasy - A boolean value that indicates whether or not to
   * create an array of attributes representing an Easy card.
   * @return {NodeList} returns a nodeList of randomly selected attributes.
   */
  function generateRandomAttributes(isEasy) {
    let randAttributes = [];
    if (isEasy) {
      randAttributes[0] = STYLE[0];
    } else {
      randAttributes[0] = STYLE[Math.floor(Math.random() * (2 - 0 + 1)) + 0];

    }
    randAttributes[1] = SHAPE[Math.floor(Math.random() * (2 - 0 + 1)) + 0];
    randAttributes[2] = COLOR[Math.floor(Math.random() * (2 - 0 + 1)) + 0];
    randAttributes[3] = COUNT[Math.floor(Math.random() * (2 - 0 + 1)) + 0];
    return randAttributes;
  }

  /**
   * Generates a unique card using a div element and attributes returned from
   * GenerateRandomAttributes.
   * @param {isEasy} isEasy - A boolean value that indicates whether or not to create an Easy card.
   * @return {Node} returns a node representing a unique card.
   */
  function generateUniqueCard(isEasy) {
    let board = document.getElementById("board");
    let attributes = generateRandomAttributes(isEasy);
    let imgAltAndDivId =
    "" + attributes[0] + "-" + attributes[1] + "-" + attributes[2] + "-" + attributes[3];
    let cardContainer = document.createElement("div");
    cardContainer.id = imgAltAndDivId;
    cardContainer.addEventListener("click", cardSelected);

    if (cardExists(board, imgAltAndDivId) === false) {
      cardContainer.classList.add("card");

      let imgSrc = "img/" + attributes[0] + "-" + attributes[1] + "-" + attributes[2] + ".png";
      let img = document.createElement("img");
      img.src = imgSrc;
      img.alt = imgAltAndDivId;
      for (let i = 0; i < attributes[3]; i++) {
        cardContainer.appendChild(img.cloneNode(true));
      }
      return cardContainer;
    }

    return generateUniqueCard(isEasy);

  }

  /**
   * Checks to see if the attributes defining a new card already exists on the board
   * by getting all the cards on the board and matching them up to the generated card ID.
   * @param {cardsContainer} cardsContainer - Node representing game board.
   * @param {generatedCardId} generatedCardId - The newly
   * generated card ID to be checked for as a String object.
   * @return {boolean} True if the card is already on the board.
   */
  function cardExists(cardsContainer, generatedCardId) {
    let cards = cardsContainer.querySelectorAll(".card");
    for (let i = 0; i < cards.length; i++) {
      if (cards[i].id === generatedCardId) {
        return true;
      }
    }
    return false;
  }

  /**
   * Generates a board of cards with n amount of cards, where n corresponds to the
   * difficulty level chosen at the main menu.
   * @param {reason} reason - used to detect when refresh button is clicked, then do
   * not reset score.
   */
  function populateBoard(reason) {
    let allInputs = document.getElementsByTagName("input");
    let isEasy = allInputs[0].checked;
    let board = document.getElementById("board");
    board.innerHTML = "";
    let setCount = document.getElementById("set-count");
    if (reason !== "refresh") {
      setCount.textContent = "0";
    }
    let difficulty;
    document.getElementById("refresh-btn").disabled = false;
    if (isEasy) {
      difficulty = 9;
    } else {
      difficulty = 12;
    }
    for (let i = 0; i < difficulty; i++) {
      board.appendChild(generateUniqueCard(isEasy));
    }
  }

  /**
   * Starts the game timer with the specified time selection from main menu. Creates a
   * timeInterval of 1 second to update game timer.
   */
  function startTimer() {
    let timeOptions = document.getElementsByTagName("option");
    let times = ["01:00", "03:00", "05:00"];
    let time = document.getElementById("time");
    for (let i = 0; i < 3; i++) {
      if (timeOptions[i].selected) {
        remainingSeconds = timeOptions[i].value;
        time.textContent = times[i];
      }
    }
    timerId = setInterval(advanceTimer, 1000);
  }

  /**
   * Function used to update internal time as well as HTML time element on game board.
   * Updates every second. When time runs out, endGame is called.
   */
  function advanceTimer() {
    remainingSeconds -= 1;
    if (remainingSeconds !== 0) {
      let timeOnBoard = document.getElementById("time");
      if (remainingSeconds % 60 < 10) {
        timeOnBoard.textContent =
        "0" + Math.floor(remainingSeconds / 60) + ":0" + (remainingSeconds % 60);
      } else {
        timeOnBoard.textContent =
        "0" + Math.floor(remainingSeconds / 60) + ":" + remainingSeconds % 60;
      }
    } else {
      endGame("noTime");
    }
  }

  /**
   * Function used to reset values when the game ends. Either by time running out,
   * refresh button being clicked, or back to main menu button being clicked.
   * @param {reason} reason - String value indicating through which channel game has ended.
   */
  function endGame(reason) {
    let setCount = document.getElementById("set-count");
    let time = document.getElementById("time");
    clearInterval(timerId);
    time.textContent = "00:00";
    remainingSeconds = 0;
    if (reason === "back") {
      setCount.textContent = "0";
    } else {
      document.getElementById("refresh-btn").disabled = true;
      let cards = document.querySelectorAll(".card");
      for (let i = 0; i < cards.length; i++) {
        cards[i].classList.remove("selected");
        cards[i].removeEventListener("click", cardSelected);
      }
    }
  }

  /**
   * Adds the selected class to the card that was clicked. Checks if the current
   * amount of cards with class selected is 3, if true, uses isASet to determine
   * if the 3 selected cards make a set.
   */
  function cardSelected() {
    this.classList.toggle("selected");
    let cards = document.querySelectorAll(".selected");
    let setCount = document.getElementById("set-count");
    let allInputs = document.getElementsByTagName("input");
    let isEasy = allInputs[0].checked;
    if (cards.length === 3) {
      if (isASet(cards)) {
        setCount.textContent = parseInt(setCount.textContent) + 1;
        let correctSet = document.createElement("p");
        correctSet.textContent = "SET!";
        for (let i = 0; i < 3; i++) {
          let newCard = generateUniqueCard(isEasy);
          newCard.classList.add("hide-imgs");
          newCard.appendChild(correctSet.cloneNode(true));
          cards[i].parentElement.replaceChild(newCard, cards[i]);
        }
        setTimeout(removeMessages, 1000);
      } else {
        let incorrectSet = document.createElement("p");
        incorrectSet.textContent = "Not a Set";
        for (let i = 0; i < 3; i++) {
          cards[i].appendChild(incorrectSet.cloneNode(true));
          cards[i].classList.add("hide-imgs");
          cards[i].removeEventListener("click", cardSelected);
        }
        setTimeout(removeMessages, 1000);
      }
    }
  }

  /**
   * Removes the 1 second feedback message after a set of 3 cards is selected.
   */
  function removeMessages() {
    let blankCards = document.querySelectorAll(".hide-imgs");
    for (let i = 0; i < 3; i++) {
      blankCards[i].classList.remove("hide-imgs");
      blankCards[i].classList.remove("selected");
      blankCards[i].removeChild(blankCards[i].lastChild);
      blankCards[i].addEventListener("click", cardSelected);
    }
  }

  /**
   * Checks to see if the three selected cards make up a valid set. This is done by comparing each
   * of the type of attribute against the other two cards. If each four attributes for each card are
   * either all the same or all different, then the cards make a set. If not, they do not make a set
   * @param {DOMList} selected - list of all selected cards to check if a set.
   * @return {boolean} true if valid set false otherwise.
   */
  function isASet(selected) {
    let attributes = [];
    for (let i = 0; i < selected.length; i++) {
      attributes.push(selected[i].id.split("-"));
    }
    for (let i = 0; i < attributes[0].length; i++) {
      let diff = attributes[0][i] !== attributes[1][i] &&
                attributes[1][i] !== attributes[2][i] &&
                attributes[0][i] !== attributes[2][i];
      let same = attributes[0][i] === attributes[1][i] &&
                    attributes[1][i] === attributes[2][i];
      if (!(same || diff)) {
        return false;
      }
    }
    return true;
  }
})();