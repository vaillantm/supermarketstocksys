import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom"; // For navigation


const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const navigate = useNavigate(); // Initialize useNavigate hook

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:5000/login", { email, password });
      setMessage(response.data.message || "Login successful!");

     // Redirect based on the role after successful login
    if (response.data.role === "MANAGER") {
      window.location.href = "/managerpage";
    } else if (response.data.role === "ADMIN") {
      window.location.href = "/adminpage";
    } else if (response.data.role === "CASHIER") {
      window.location.href = "/cashierpage";
    } else {
      setMessage("Role not recognized.");
    }
    } catch (error) {
      setMessage(error.response?.data?.message || "Invalid email or password.");
    }
  };

  return (
    <div className="content">
      <div className="container">
        <h2>Login</h2>
        <form onSubmit={handleLogin}>
          <label htmlFor="email">Email:</label>
          <input
            type="text"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <button type="submit">Login</button>
        </form>
        <button onClick={() => (window.location.href = "/forgotpassword")}>Forgot Password?</button>
        <p>{message}</p>
      </div>
    </div>
  );
};

export default Login;
