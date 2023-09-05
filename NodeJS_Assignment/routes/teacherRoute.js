const teacherController = require('../controller/teacherController.js');
const router = require('express').Router()

router.get('/login', teacherController.teacherGetLogin);
router.post('/login', teacherController.teacherPostLogin);

router.get('/addStudent', teacherController.addStudentForm);
router.post('/addStudent', teacherController.addStudent);
router.get('/allStudents', teacherController.getAllStudents)
router.get('/edit/:id', teacherController.getOneStudent)
router.post('/edit/:id', teacherController.updateStudent)
router.get('/delet/:id', teacherController.deleteStudent)
router.get('/teacherView', teacherController.getAllStudents)
module.exports = router