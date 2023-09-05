
import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import Home from './Components/Home';
import Signup from './Components/Signup';
import Login from './Components/Login';
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer } from 'react-toastify';
import BlogPage from './Components/BlogPage'
import User from './Components/User';
import AddBlog from './Components/AddBlog';
import UserProvider from './Context/UserProvider';
import store from './Redux/store';
import { Provider } from "react-redux";
function App() {
  return (
    <Provider store={store}>
      <UserProvider>
        <BrowserRouter>
          <ToastContainer position="top-center" />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/user" element={<User />}>
              <Route path="blogs" element={<BlogPage />} />
              <Route path="addblog" element={<AddBlog />} />
            </Route>
          </Routes>
        </BrowserRouter>
      </UserProvider>
    </Provider>
  );
}

export default App;
