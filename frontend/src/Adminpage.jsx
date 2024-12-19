import React from "react";
import { Link } from "react-router-dom";

const Adminpage = () => {
  return (
    <div style={styles.container}>
      {/* Sidebar */}
      <div style={styles.sidebar}>
        <Link to="/cashier-dashboard" style={styles.link}>
          Home
        </Link>
        <Link to="/view-categories" style={styles.link}>
          Categories
        </Link>
        <Link to="/view-products" style={styles.link}>
          Products
        </Link>
        <Link to="/view-purchases" style={styles.link}>
          Purchases
        </Link>
        <Link to="/view-sales" style={styles.link}>
          Sales
        </Link>
        <Link to="/logout" style={styles.link}>
          Logout
        </Link>
      </div>

      {/* Main content */}
      <div style={styles.content}>
        <div style={styles.welcomeContainer}>
          <h1 style={styles.title}>Welcome to Admin Dashboard</h1>
          <p style={styles.description}>
            You can View Categories, Products, Purchases, and Sales.
          </p>
        </div>
      </div>
    </div>
  );
};

// Inline styles
const styles = {
  container: {
    display: "flex",
    fontFamily: "'Segoe UI', system-ui, -apple-system, sans-serif",
    margin: 0,
    padding: 0,
    backgroundImage: "linear-gradient(120deg, #fdfbfb 0%, #ebedee 100%)",
    backgroundAttachment: "fixed",
    color: "#2d3748",
  },
  sidebar: {
    height: "100vh",
    width: "250px",
    position: "fixed",
    top: 0,
    left: 0,
    backgroundColor: "#2d3748",
    paddingTop: "20px",
    color: "white",
    boxShadow: "2px 0px 5px rgba(0, 0, 0, 0.1)",
  },
  link: {
    display: "block",
    color: "white",
    padding: "16px",
    textDecoration: "none",
    fontSize: "18px",
    textTransform: "uppercase",
    transition: "background-color 0.3s",
    hover: {
      backgroundColor: "#4f46e5",
    },
  },
  content: {
    marginLeft: "250px",
    padding: "20px",
    width: "100%",
  },
  welcomeContainer: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    height: "80vh",
    textAlign: "center",
    background: "rgba(255, 255, 255, 0.9)",
    borderRadius: "15px",
    padding: "40px",
    boxShadow:
      "0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06)",
  },
  title: {
    fontSize: "3rem",
    margin: "0 0 20px",
    background: "linear-gradient(135deg, #6366f1 0%, #4f46e5 100%)",
    WebkitBackgroundClip: "text",
    WebkitTextFillColor: "transparent",
  },
  description: {
    fontSize: "1.25rem",
    color: "#4a5568",
    margin: "0 0 30px",
  },
};

export default Adminpage;
