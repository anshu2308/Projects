//importing student model
const Student = require('../model/student');

const studentLoginGet = (req, res) => {
  res.render("student/login");
};

const studentLoginPost = async (req, res) => {

  const stuId = req.body.roll;
  // console.log("ROLL NO",stuId);
  const individualStudent =await Student.findOne({ where: { rollno: stuId } })
  // console.log(individualStudent);
  if (!individualStudent) {
    res.render("student/login", {
      error: "Login with correct roll number"
    })
  }
  res.render("student/stuResult", { one: individualStudent });
};

//exporting student controller functions
module.exports = {
  studentLoginGet,
  studentLoginPost
}