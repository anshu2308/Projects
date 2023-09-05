import {
  Button,
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  Form,
  FormGroup,
  Input,
  Label,
  Row,
} from "reactstrap";
import Base from "./Base";
import { toast } from "react-toastify";
import React,{useContext, useState} from 'react';
// import UserLogin  from "../Service/UserSignup";
import userContext from "../Context/userContext";
import { useNavigate } from "react-router-dom";
const Login = () => {

  const navigate=useNavigate()
const [loginDetail,setLoginDetail]=useState({
    username:'',
    password:''
})

const handleChange=(e,field)=>{
    let actualValue=e.target.value
    setLoginDetail({
        ...loginDetail,
        [field]:actualValue
    })
}
const users=useContext(userContext);
const handleOnSubmit=(e)=>{
    e.preventDefault();
  if(users.email===loginDetail.username)
  {
    toast.success("Login successfully")
    navigate("/user/blogs")
  }
  else{
   toast.error("Invalid Credentials")
  }
    // UserLogin(loginDetail);
     setLoginDetail({
       username: "",
       password: "",
     });
}


const resetDetails=()=>{
 setLoginDetail({
   username: "",
   password: "",
 });
}
  return (
    <Base>
      <Container>
        <Row className="mt-3">
          <Col sm={{ offset: 3, size: 6 }}>
            <Card color="secondary" inverse>
              <CardHeader>Login Here!!!</CardHeader>
              <CardBody>
                <Form onSubmit={handleOnSubmit}>
                  <FormGroup>
                    <Label for="email">Enter email</Label>
                    <Input
                      type="email"
                      required
                      id="email"
                      placeholder="Enter here"
                      value={loginDetail.username}
                      onChange={(e) => handleChange(e, "username")}
                    ></Input>
                  </FormGroup>
                  <FormGroup>
                    <Label for="password">Enter Password</Label>
                    <Input
                      type="password"
                      id="password"
                      required
                      placeholder="Enter here"
                      value={loginDetail.password}
                      onChange={(e) => handleChange(e, "password")}
                    ></Input>
                  </FormGroup>
                  <Container className="text-center">
                    <Button color="dark">Login</Button>
                    <Button
                      onClick={resetDetails}
                      color="secondary"
                      type="reset"
                      className="ms-4"
                    >
                      Reset
                    </Button>
                  </Container>
                </Form>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </Base>
  );
};

export default Login;
