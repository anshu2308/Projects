import React, { useState } from "react";
import {
    CardFooter,
    ModalFooter,
    Nav,
  Navbar,
  NavbarBrand,
  NavbarText,
} from "reactstrap";

function Footer(args) {

  return (
    <CardFooter className="bg-dark  text-center">
      <h4 style={{color:'white',bottom:0}}> &copy;Nagarro</h4>
    </CardFooter>
  );
}

export default Footer;
