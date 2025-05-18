import "./App.css";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";
import AboutUs from "./Screens/AboutUs";
import SearchBook from "./Screens/SearchBook";
import ContactForm from "./Screens/ContactForm";
import Feedback from "./Screens/Feedback";
import {
  Navigate,
  Routes,
  Route,
  BrowserRouter,
  NavLink,
} from "react-router-dom";

import Services from "./Screens/Services";
import NotFound from "./Screens/NotFound";
import Donation from "./Screens/Donation";
import LibraryRules from "./Screens/LibraryRules";
import Admin from "./Screens/Admin";
import Register from "./Screens/Register";
import Login from "./Screens/Login";
import Location from "./Screens/Location";
import Charges from "./Screens/Charges";
import History from "./Screens/History";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <div className="row justify-content-start m-0 p-0">
          <div className="col col-2 justify-content-start m-0 p-0">
            <Sidebar />
          </div>
          <div className="col align-self-start m-0 p-0 love">
            <Routes>
              <Route path="/" element={<Navigate to="/about" />} />
              <Route path="/about" element={<AboutUs />}>
                <Route path="" element={<Location />} />
                <Route path="charges" element={<Charges />} />
                <Route path="history" element={<History />} />
              </Route>
              <Route path="/services" element={<Services />} />
              <Route path="/serchbook" element={<SearchBook />} />
              <Route path="/donation" element={<Donation />} />
              <Route path="/rules" element={<LibraryRules />} />
              <Route path="/admin" element={<Admin />} />
              <Route path="/register" element={<Register />} />
              <Route path="/login" element={<Login />} />
              <Route
                path="/ContactUs"
                element={<ContactForm title="Contact Us" />}
              />
              <Route path="/feedback" element={<Feedback title="feedback" />} />
              <Route element={<NotFound />} />
            </Routes>
          </div>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
