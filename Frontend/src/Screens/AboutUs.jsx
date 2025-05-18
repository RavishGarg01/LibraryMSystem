import React from "react";
import {  Outlet, NavLink, Route, Routes } from "react-router-dom";

import History from "./History";
import Location from "./Location";
import Charges from "./Charges";

function AboutUs() {
  const routes = [
    { path: "", element: <Location />, title: " Location & Hours" },
    { path: "charges", element: <Charges />, title: "Charges" },
    { path: "history", element: <History />, title: "History" },
  ];

  const routeElements = routes.map((route) => (
    <li key={route.path} className="nav-item">
      <NavLink
        to={`/about/${route.path}`}
        activeClassName="active"
        className="nav-link"
      >
        {route.title}
      </NavLink>
    </li>
  ));

  return (
    <>
      <div className="container-fluid p-0">
        <div className="navbar justify-content-start p-0">
          <ul className="nav nav-tabs">{routeElements}</ul>
        </div>
        <hr className="m-0" />
        <Outlet />
      </div>
    </>
  );
}

export default AboutUs;
