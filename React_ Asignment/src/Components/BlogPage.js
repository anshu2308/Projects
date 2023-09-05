import React from "react";
import { Button, Card, CardBody, CardHeader,Col,ListGroup,ListGroupItem, Row } from "reactstrap";
import Base from "./Base";
import { connect } from "react-redux";
import { NavLink } from "react-router-dom";

const BlogPage = ({blogs}) => {
  
  return (
    <Base>
      <Row className="text-center">
        <Col sm={{ offset: 8, size: 3 }}>
          <Button tag={NavLink} to="../addblog" color="secondary">
            New Post
          </Button>
        </Col>
      </Row>
      <Row>
        <Card>
          <CardHeader>Blog List</CardHeader>
          <CardBody>
            <ListGroup>
              {blogs.map((blog, index) => (
                <ListGroupItem key={index}>
                  <h4>{blog.title}</h4>
                  <h6>{blog.category}</h6>
                  <p>{blog.content}</p>
                </ListGroupItem>
              ))}
            </ListGroup>
          </CardBody>
        </Card>
      </Row>
    </Base>
  );
};

const mapBlogsToProps=(state)=>{
   return{blogs:state.blogs}
}
 const mapDispatchToProps=(dispatch)=>({})
export default connect( mapBlogsToProps,mapDispatchToProps) (BlogPage);
