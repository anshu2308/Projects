import {
  ADD_BLOG,
  DELETE_BLOG,
  UPDATE_BLOG,
} from "../Actions/actionTypes";

const initialState = [
  {
    title: "This is a React Post ",
    category: "Programming",
    content:
      "React is a JavaScript library created by Facebook React is a User Interface (UI) library React is a tool for building UI components",
  },
  {
    title: "This is a  Angular Post",
    category: "Programming",
    content:
      "Angular's component model offers strong encapsulation and an intuitive application structure. Components also make your application painless to unit test and can improve the general readability of your code.",
  },
];

export default (state = initialState, action) => {
  switch (action.type) {
    case ADD_BLOG:
      console.log("adding Blogs");
      return [...state, action.payload];

    case DELETE_BLOG:
      const newState = state.filter((blog) => blog.id !== action.payload);
      return newState;

    case UPDATE_BLOG:
      const updatedState = state.map((blog) => {
        if (blog.id === action.payload.blogId) {
          blog.title = action.payload.blog.title;
          blog.category = action.payload.blog.category;
          blog.content = action.payload.blog.content;
        }
        return blog;
      });
      return updatedState;

    default:
      return state;
  }
};
