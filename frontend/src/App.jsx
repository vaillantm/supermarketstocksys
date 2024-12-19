import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./Home.jsx";
import Login from "./Login.jsx";
import SignUp from "./SignUp.jsx";
import ForgotPassword from "./ForgotPassword.jsx";
import ManagerPage from "./Managerpage.jsx";
import CashierPage from "./Cashierpage.jsx";
import AdminPage from "./Adminpage.jsx";

import "./App.css"; // Link to your CSS file

const App = () => {
  return (
    <Router>
      <nav className="nav-container">
        <h1>Supermarket System</h1>
        <div className="nav-links">
          <Link to="/" className="nav-link">Home</Link>
          <Link to="/login" className="nav-link">Login</Link>
          <Link to="/signup" className="nav-link">Sign Up</Link>
          
        </div>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/forgotpassword" element={<ForgotPassword />} />
        <Route path="/managerpage" element={<ManagerPage />} />
        <Route path="/cashierpage" element={<CashierPage />} />
        <Route path="/adminpage" element={<AdminPage />} />
      </Routes>
    </Router>
  );
};

export default App;
