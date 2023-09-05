 import { NavLink as ReactLink } from "react-router-dom";

import React, { useState,useEffect, useContext } from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  NavbarText,
 
} from "reactstrap";
import userContext from "../Context/userContext";
function CustomNavbar(args) {

const [login,setLogin]=useState(false)
const user=useContext(userContext);

useEffect(()=>{
setLogin(true)
},[login])

const logout=()=>{
  setLogin(false)
  console.log("loggeg out");
}
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  return (
    <div>
      <Navbar className="ps-5" color="dark" dark expand="md" fixed="">
        <NavbarBrand href="/">MyBlogs</NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar>
            <NavItem>
              <NavLink tag={ReactLink} to="/">
                Home
              </NavLink>
            </NavItem>
          </Nav>

          <Nav navbar>
            {login && (
              <>
                <NavItem className="mx-5">
                  <NavLink onClick={logout} tag={ReactLink} to="/login">
                    Logout   
                  </NavLink>
                </NavItem>
                <NavbarText>Hello {user.name} </NavbarText>
              </>
            )}

            {!login && (
              <>
                <NavItem>
                  <NavLink tag={ReactLink} to="/login">
                    Login
                  </NavLink>
                </NavItem>
                <NavItem>
                  <NavLink tag={ReactLink} to="/signup">
                    Signup
                  </NavLink>
                </NavItem>
              </>
            )}
          </Nav>
        </Collapse>
      </Navbar>
    </div>
  );
}

export default CustomNavbar;
