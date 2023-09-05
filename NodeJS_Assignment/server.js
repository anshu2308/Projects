const cors = require('cors')
const student = require("./model/student")
const express = require('express')
const studentController = require('./controller/teacherController.js');
const app = express()

//port
const PORT = process.env.PORT || 8080


// middleware

app.use(express.json())
app.use(express.static('public'))
app.use(express.urlencoded({ extended: true }))


app.set('view engine', 'ejs');
app.get('/', (req, res) => {
    res.render('index')
});

//express layouts
var expressLayouts = require('express-ejs-layouts');
app.use(expressLayouts);
app.set('layout', 'layouts/layout');

// routers
const tRouter = require('./routes/teacherRoute.js')
app.use('/teacher', tRouter)

const studRoutes = require("./routes/stuRoute")
app.use("/student", studRoutes);


//server
app.listen(PORT, () => {
    console.log(`server is running on port ${PORT}`)
});
