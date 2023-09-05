import { ADD_BLOG, DELETE_BLOG, UPDATE_BLOG } from "./actionTypes";

export const addBlog= (blog) => ({
  type: ADD_BLOG,
  payload: blog,
});

export const deleteBlog = (id) => ({
  type: DELETE_BLOG,
  payload: id,
});

export const updateBlog = (blog, id) => ({
  type: UPDATE_BLOG,
  payload: { blog: blog, blogId: id },
});
