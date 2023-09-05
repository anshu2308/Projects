var express = require("express");
const router = express.Router();
const studentController = require('../controller/studentController.js');

router.get('/login',studentController.studentLoginGet);
router.post('/login',studentController.studentLoginPost);

module.exports = router;