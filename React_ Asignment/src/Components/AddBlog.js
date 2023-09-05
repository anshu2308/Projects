import React,{useState} from 'react'
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup,  Input, Label, ListGroup, ListGroupItem, Row, } from 'reactstrap'
import Base from './Base'
import { addBlog } from '../Redux/Actions/Blog'
import { connect } from 'react-redux'
import { NavLink } from 'react-router-dom'

const AddBlog = ({addBlog,blogs}) => {

    const [blog,setBlog]=useState({
        title:'',
        category:'',
        content:''
    })

    const handleSubmit=(e)=>{
        e.preventDefault();
        addBlog(blog)
        console.log(blog);
       
        setBlog({
          title: "",
          category: "",
          content: "",
        });
    }
  return (
    <Base>
      <Container className="my-3 ">
        <Row>
          <Button tag={NavLink} to="../blogs">
            Back
          </Button>
        </Row>
        <Row>
          <Col sm={{ offset: 2, size: 8 }}>
            <Card>
              <CardHeader className="text-center">Add a Blog!!!</CardHeader>
              <CardBody>
                <Form onSubmit={handleSubmit}>
                  <FormGroup>
                    <Label for="title">Enter title</Label>
                    <Input
                      type="text"
                      placeholder="Enter here"
                      required
                      id="title"
                      value={blog.title}
                      onChange={(e) =>
                        setBlog({
                          ...blog,
                          title: e.target.value,
                        })
                      }
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="category">Enter category</Label>
                    <Input
                      type="select"
                      placeholder="Enter here"
                      required
                      id="category"
                      value={blog.category}
                      onChange={(e) =>
                        setBlog({
                          ...blog,
                          category: e.target.value,
                        })
                      }
                    >
                      <option>Science</option>
                      <option>Programming</option>
                      <option>Space</option>
                      <option>Bollywood</option>
                      <option>Wildlife</option>
                    </Input>
                  </FormGroup>
                  <FormGroup>
                    <Label for="content">Enter content</Label>
                    <Input
                      type="textarea"
                      placeholder="Enter here"
                      required
                      style={{ height: "200px" }}
                      id="content"
                      value={blog.content}
                      onChange={(e) =>
                        setBlog({
                          ...blog,
                          content: e.target.value,
                        })
                      }
                    />
                  </FormGroup>
                  <Container className="text-center">
                    <Button type="submit" color="primary">
                      Post
                    </Button>
                    <Button color="secondary" type="reset" className="ms-4">
                      Clear Content
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
}
const mapBlogsToProps = (state) => { 
  return { blogs: state.blogs }
}
const mapDispatchToProps = (dispatch) => ({
  addBlog: (blog) => (dispatch(addBlog(blog)))
})
export default connect(mapBlogsToProps,mapDispatchToProps) (AddBlog);