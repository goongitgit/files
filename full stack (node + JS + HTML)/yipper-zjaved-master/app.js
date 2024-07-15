/*
 * Name: Zohaib Javed
 * Date: Wednesday, August 17
 * Section: CSE 154 AA
 * Description: This is the node js file that takes care of my back-end API code.
 * It has 4 endpoints (2 GETS, 2 POSTS) and allows users to find posts from a user,
 * search all posts, create a post, and see all posts/yips. More information on these
 * endpoints can be found in the API documentation.
 */

'use strict';

const express = require('express');
const app = express();

const sqlite = require('sqlite');
const sqlite3 = require('sqlite3');

const multer = require('multer');

app.use(express.urlencoded({extended: true}));
app.use(express.json());
app.use(multer().none());

// returns all yips
app.get('/yipper/yips', async (req, res) => {
  let db;
  try {
    db = await getDBConnection();
    let searchTerm = req.query.search;
    if (!searchTerm) {
      let temp = 'FROM yips ORDER BY DATETIME(date) DESC;';
      let query = 'SELECT id, name, yip, hashtag, likes, date ' + temp;
      let result = await db.all(query);
      let returnObject = {};
      returnObject.yips = result;
      await db.close();
      res.json(returnObject);
    } else if (searchTerm) {
      let result = await db.all('SELECT id FROM yips WHERE yip LIKE ?;', "%" + searchTerm + "%");
      let returnObject = {};
      returnObject.yips = result;
      await db.close();
      res.json(returnObject);
    }
  } catch (err) {
    await db.close();
    res.type('text').status(500)
      .send('An error occurred on the server. Try again later.');
  }
});

// returns all yips from a specific user
app.get('/yipper/user/:user', async (req, res) => {
  let db;
  try {
    db = await getDBConnection();
    let user = req.params.user;
    if (user) {
      let temp = 'SELECT name, yip, hashtag, date';
      let temp2 = ' ORDER BY DATETIME(date) DESC;';
      let result = await db.all(temp + ' FROM yips WHERE name = ?' + temp2, user);
      await db.close();
      if (result.length === 0) {
        res.type('text').status(400)
          .send('Yikes. User does not exist.');
      } else {
        res.json(result);
      }
    }
  } catch (err) {
    await db.close();
    res.type('text').status(500)
      .send('An error occurred on the server. Try again later.');
  }
});

// returns the updated number of likes for a post
app.post('/yipper/likes', async (req, res) => {
  res.type('text');
  let db;
  try {
    db = await getDBConnection();
    let userId = req.body.id;
    if (userId) {
      let result = await db.all('SELECT likes FROM yips WHERE id =  ?;', userId);
      if (result.length === 0) {
        await db.close();
        res.status(400)
          .send('Yikes. ID does not exist.');
      } else {
        let prevValue = result[0].likes;
        let temp = 'UPDATE yips SET likes = ';
        result = await db.all(temp + (prevValue + 1) + ' WHERE id =  ?;', userId);
        await db.close();
        res.send('' + (prevValue + 1));
      }

    } else {
      await db.close();
      res.status(400)
        .send('Missing one or more of the required params.');
    }
  } catch (err) {
    await db.close();
    res.status(500)
      .send('An error occurred on the server. Try again later.');
  }
});

// returns a json object of a new yip (date, id, yip, hastag, etc.)
app.post('/yipper/new', async (req, res) => {
  let db = await getDBConnection();
  try {
    let name = req.body.name;
    let full = req.body.full;
    if (name && full) {
      let userPosts = await db.all('SELECT id FROM yips WHERE name = ?;', name);
      if (userPosts.length !== 0) {
        await db.close();
        res.json(await helper(name, full));
      } else {
        await db.close();
        res.type('text').status(400)
          .send('Yikes. User does not exist.');
      }
    } else {
      await db.close();
      res.type('text').status(400)
        .send('Missing one or more of the required params.');
    }
  } catch (err) {
    await db.close();
    res.type('text').status(500)
      .send('An error occurred on the server. Try again later.');
  }
});

/**
 * Helper function to get the JSON object for a new yip
 * @param {name} name provided name from request
 * @param {full} full provided full from request
 * @returns {Element} the json object of the new yip
 */
async function helper(name, full) {
  let db = await getDBConnection();
  full = full.trim();
  let text = full.substring(0, full.indexOf('#')).trim();
  let hashtag = full.substring(full.indexOf('#') + 1, full.length).trim();
  let query = 'INSERT INTO yips ("name", "yip", "hashtag", "likes") VALUES (?, ?, ?, "0");';
  let result = await db.all(query, name, text, hashtag);
  result = await db.all('SELECT * FROM yips ORDER BY id DESC LIMIT 1');
  return result[0];
}

/**
 * Establishes a database connection to the database and returns the database object.
 * Any errors that occur should be caught in the function that calls this one.
 * @returns {Object} - The database object for the connection.
 */
async function getDBConnection() {
  const db = await sqlite.open({
    filename: 'yipper.db',
    driver: sqlite3.Database
  });
  return db;
}

app.use(express.static('public'));
const PORT = process.env.PORT || 8000;
app.listen(PORT);