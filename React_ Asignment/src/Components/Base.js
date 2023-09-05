import CustomNavbar from "./CustomNavbar";
import Footer from "./Footer";

const Base = ({ title = "Welcome to our website", children }) => {
  return (
    <div>
      <CustomNavbar />
      {children}
      {/* <Footer /> */}
    </div>
  );
};
export default Base;