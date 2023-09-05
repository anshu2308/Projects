import { useContext,  useState } from "react";
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap";
// import { signUp } from "../Service/UserSignup";
import userContext from "../Context/userContext";
import Base from "./Base";
// import { UserSignup } from "../Service/UserSignup";
import {toast } from 'react-toastify';
const Signup = () => {
  
    const [user,setUser]=useState(
      {
        name:'',
        email:'',
        password:'',
    }
    )
  const [users, setUsers] = useContext(userContext);
  

    // const[error,setError]=useState({
    //     errors:{},
    //     isError:false,
    // })

  //  useEffect(()=>{
  //   console.log(user);
  //  },[user])

   const resetUser=()=>{
    setUser({
        name:'',
        email:'',
        password:''
    })
   }
    const handleChange=(event,property)=>{
        setUser({...user,[property]:event.target.value})
    }

    const submitForm=(e)=>{
      e.preventDefault();
       console.log(users);
      setUsers({ ...users, user} );
      console.log(users);
      
      toast.success("User is registered successfully!!!");
  setUser({
    name: "",
    email: "",
    password: "",
  });
     
    };

  return (
    <Base>
      <Container>
        <Row className="mt-3">
          <Col sm={{ size: 6, offset: 3 }}>
            <Card>
              <CardHeader>
                <h3>Fill information to Register!!</h3>
              </CardHeader>
              <CardBody>
                <Form onSubmit={submitForm}>
                  <FormGroup>
                    <Label for="name">Enter Name</Label>
                    <Input
                      type="text"
                      placeholder="Enter here"
                      required
                      id="name"
                      value={user.name}
                      onChange={(e) => handleChange(e, "name")}
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="email">Enter Email</Label>
                    <Input
                      type="email"
                      placeholder="Enter here"
                      required
                      id="email"
                      value={user.email}
                      onChange={(e) => handleChange(e, "email")}
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="password">Enter Password</Label>
                    <Input
                      type="password"
                      placeholder="Enter here"
                      required
                      id="password"
                      onChange={(e) => handleChange(e, "password")}
                      value={user.password}
                    />
                  </FormGroup>
                  <Container className="text-center">
                    <Button color="dark">Register</Button>
                    <Button onClick={resetUser } color="secondary" type="reset" className="ms-4">
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

export default Signup;
