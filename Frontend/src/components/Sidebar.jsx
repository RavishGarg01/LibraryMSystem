import React from "react";
// import logo from '../logo.svg'
import "../App.css"
import { NavLink } from "react-router-dom";

function Sidebar() {
    return (
        <>
            <ul className="nav nav-pills list-group  text-start nav pills">
                <li className="list-group-item nav-iem p-0 ">
                    <NavLink className="nav-link" to="/about"     activeClassName="active">About us</NavLink>
                </li>
                <li className="list-group-item nav-item p-0">
                    <NavLink className="nav-link" to="/serchbook" activeClassName="active">Search Books</NavLink>
                </li>
                <li className="list-group-item nav-item p-0">
                    <NavLink className="nav-link" to="/services"  activeClassName="active">Services</NavLink>
                </li>
                <li className="list-group-item nav-item p-0">
                    <NavLink className="nav-link" to="/rules"      activeClassName="active">Library Rules</NavLink>
                </li>
                {/* <li className="list-group-item nav-item p-0">
                    <NavLink className="nav-link" to="/libraries"  activeClassName="active">Other Libraries</NavLink>
                </li> */}
                <li className="list-group-item nav-item p-0">
                    <NavLink className="nav-link" to="/donation"   activeClassName="active">Donation</NavLink>
                </li>
                <li className="list-group-item nav-item p-0">
                    <NavLink className="nav-link" to="/contactUs"  activeClassName="active">Contact Us</NavLink>
                </li>
                <li className="list-group-item nav-item p-0">
                    <NavLink className="nav-link" to="/feedback"   activeClassName="active">Feedback</NavLink>
                </li>
                <li className="list-group-item nav-item p-0">
                    <NavLink className="nav-link" to="/admin"  activeClassName="active">Admin</NavLink>
                </li>
            </ul>



            {/* 
                    <nav className="navbar navbar-expand-lg navbar-light m-0 p-0" >
   
   <div className="container-fluid m-0 p-0 flex-column">
             
       <div className="collapse navbar-collapse  justify-content-start m-0 p-0" id="navbarText">
           <ul className="nav nav-pills flex-column list-group-flush m-0 p-0 text-start border-secondary border-end border-1">
               <li className="nav-item list-group-item p-0">
                   <NavLink className="nav-link" aria-current="page" to="/about">About us</NavLink>
               </li>
               <li className="nav-item list-group-item p-0">
                   <NavLink className="nav-link" to="/services" activeClassName="active">Services</NavLink>
               </li>
               <li className="nav-item list-group-item p-0">
                   <NavLink className="nav-link" to="/contacts" activeClassName="active">Contact</NavLink>
               </li>
               <li className="nav-item list-group-item p-0">
                   <NavLink className="nav-link" to="/serchbook" activeClassName="active">Search Books</NavLink>
               </li>
               <li className="nav-item list-group-item p-0">
                   <NavLink className="nav-link" to="rules" activeClassName="active">Library Rules</NavLink>
               </li>
               <li className="nav-item list-group-item p-0">
                   <NavLink className="nav-link" to="donation" activeClassName="active">Donation</NavLink>
               </li>
               <li className="nav-item list-group-item p-0">
                   <NavLink className="nav-link" to="libraries" activeClassName="active">Other Libraries</NavLink>
               </li>
               <li className="nav-item list-group-item p-0">
                   <NavLink className="nav-link" to="feedback" activeClassName="active">Feedback</NavLink>
               </li>
           </ul>
           <span className="navbar-text">
           </span>
       </div>
   </div>
   
</nav> */}

        </>
    )
}

export default Sidebar;