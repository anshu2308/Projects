import { createStore, combineReducers } from "redux";
import BlogReducer from "./Reducer/BlogReducer";

const rootReducers = combineReducers({ blogs: BlogReducer });
const store = createStore(rootReducers);

export default store;
