
const Student = require("../model/student")

const teacherGetLogin=(req,res)=>{
    res.render("teacher/teacherLogin",{error:''})
}

const teacherPostLogin = (req, res) => {

    //******** Teacher Login Password **********//
    if (req.body.password === "pswd" && req.body.user==="admin") {
        res.redirect("/teacher/teacherView");
        console.log("You are logged");
    }
    else {
        res.render("teacher/teacherLogin", {
            error: "**Please enter correct details"
        })
    }
};

const addStudentForm = (req, res) => {
    res.render("teacher/addNewStudent");
};

const addStudent = async (req, res) => {

    let newStudent = {
        name: req.body.name,
        rollno: req.body.rollno,
        Dateofbirth: req.body.Dateofbirth,
        score: req.body.score,  
    }

    const student = await Student.create(newStudent)
    // res.status(200).send(student)

    res.redirect("/teacher/addStudent");
    console.log(student)

}


const getAllStudents = async (req, res) => {

    let students = await Student.findAll({})
    // res.status(200).send(students)
    res.render('teacher/teacherView', { students: students })

}


const getOneStudent = async (req, res) => {

    let id = req.params.id
    
    let student = await Student.findOne({ where: { id: id } })
    // res.status(200).send(student)
    console.log(student);
    res.render("teacher/editDetails",{student:student});

}

// 4. update student

const updateStudent = async (req, res) => {

    let id = req.params.id

    const student = await Student.update(req.body, { where: { id: id } })
   console.log("RECORD UPDATED");
    res.redirect("/teacher/teacherView")
    // res.status(200).send(student)


}

// 5. delete student by id

const deleteStudent = async (req, res) => {

    let id = req.params.id

    await Student.destroy({ where: { id: id } })
  res.redirect("/teacher/teacherView")
    // res.status(200).send('student is deleted !')

}

module.exports={
    addStudent,
    getAllStudents,
    getOneStudent,
    updateStudent,
    deleteStudent,
    teacherGetLogin,
    teacherPostLogin,
    addStudentForm

}