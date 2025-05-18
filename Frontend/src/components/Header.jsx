import React from "react";
import logo from "../assets/logo.png";
import "../App.css";
import { useNavigate } from "react-router";
function Header() {
  const navigate = useNavigate();
  return (
    <>
    <nav class="navbar navbar-expand-lg ">
      <div class="container-fluid d-flex">
        <button class="navbar-brand m-1">
          <img src={logo} alt="" width="50" height="50" />
        </button>

        <div className="d-grid gap-2 d-md-flex justify-content-md-end">
          <button
            className="nav-item active btn btn-primary"
            onClick={() => navigate("/login")}
            // role="button"
          >
            Signin/SignUp
          </button>
          <button
            href="#"
            className="nav-item active btn btn-primary"
            // role="button"
          >
            Library is open
          </button>
        </div>
      </div>
      {/* <hr className="w-100 bg-dark m-0" style={{ height: "2px" }} /> */}
      {/* <div className="w-100">
    <hr className="bg-dark m-0" style={{ height: "2px" }} />
  </div> */}
    </nav>
      <hr className="w-100 bg-dark m-0" style={{ height: ".25px" }} />
</>
  );
}

export default Header;
