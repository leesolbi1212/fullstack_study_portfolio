import React from "react";
// 1) ReactDOM 전체를 가져와서 createRoot 메소드 사용
import ReactDOM from "react-dom/client";

import App from "./App.jsx";

import { BrowserRouter } from "react-router-dom";

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);
