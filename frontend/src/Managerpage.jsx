import React, { useEffect, useState } from "react";
import axios from "axios";

const Managerpage = () => {
  const [salesData, setSalesData] = useState([]);
  const [searchQuery, setSearchQuery] = useState("");
  const [summary, setSummary] = useState({
    totalSales: 0,
    totalRevenue: 0,
    mostSoldProduct: "Loading...",
  });

  // Fetch sales data
  const fetchSalesData = async (query = "") => {
    try {
      const response = await axios.get(`http://localhost:5000/sales`, {
        params: { search: query },
      });
      setSalesData(response.data.sales);
      setSummary(response.data.summary);
    } catch (error) {
      console.error("Error fetching sales data:", error);
    }
  };

  // On component mount, fetch initial data
  useEffect(() => {
    fetchSalesData();
  }, []);

  // Handle search submission
  const handleSearch = (e) => {
    e.preventDefault();
    fetchSalesData(searchQuery);
  };

  return (
    <div style={{ display: "flex" }}>
      {/* Sidebar */}
      <div className="sidebar">
        <a href="/cashier">HOME</a>
        <a href="/categories">CATEGORIES</a>
        <a href="/products">PRODUCTS</a>
        <a href="/purchases">PURCHASES</a>
        <a href="/sales">SALES</a>
        <a href="/">LOGOUT</a>
      </div>

      {/* Main Content */}
      <div className="main-content">
        <h1>View Sales</h1>

        {/* Summary Section */}
        <div className="summary">
          <div id="mostSoldProduct">
            Most Sold: {summary.mostSoldProduct}
          </div>
          <div id="totalSales">Total Sales: {summary.totalSales}</div>
          <div id="totalRevenue">Total Revenue: RWF{summary.totalRevenue}</div>
        </div>

        {/* Search Bar */}
        <div className="search-bar">
          <form onSubmit={handleSearch}>
            <input
              type="text"
              placeholder="Search by Name/ID..."
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
            />
            <button type="submit">Search</button>
          </form>
        </div>

        {/* Sales Table */}
        <table>
          <thead>
            <tr>
              <th>Sales ID</th>
              <th>Product Name</th>
              <th>Quantity</th>
              <th>Sale Date</th>
              <th>Price</th>
              <th>Total Price</th>
            </tr>
          </thead>
          <tbody>
            {salesData.map((sale) => (
              <tr key={sale.salesid}>
                <td>{sale.salesid}</td>
                <td>{sale.productname}</td>
                <td>{sale.quantity}</td>
                <td>{sale.saledate}</td>
                <td>{sale.price}</td>
                <td>{sale.totalprice}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Managerpage;
