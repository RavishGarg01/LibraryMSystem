import React from "react";
function Services(){
    return (
        <div>
          <header style={headerStyle}>
            <h1>Welcome to Our Library</h1>
          </header>
    
          <main style={mainStyle}>
            <h2 style={headingStyle}>Library Services</h2>
    
            <div style={serviceStyle}>
              <h3 style={subHeadingStyle}>Book Borrowing</h3>
              <p style={textStyle}>Members can borrow a variety of books from our extensive collection.</p>
            </div>
    
            <div style={serviceStyle}>
              <h3 style={subHeadingStyle}>Research Assistance</h3>
              <p style={textStyle}>Our knowledgeable librarians are available to help with your research needs.</p>
            </div>
    
            <div style={serviceStyle}>
              <h3 style={subHeadingStyle}>Online Resources</h3>
              <p style={textStyle}>Access a wide range of online databases, e-books, and journals.</p>
            </div>
            {/* Add more services here */}
          </main>
    
          <footer style={footerStyle}>
            <p style={footerTextStyle}>&copy; 2023 Library Name. All rights reserved.</p>
          </footer>
        </div>
      );
    }
    
    const headerStyle = {
      backgroundColor: "#007acc",
      color: "white",
      textAlign: "center",
      padding: "10px",
    };
    
    const mainStyle = {
      padding: "20px",
    };
    
    const headingStyle = {
      color: "#007acc",
    };
    
    const serviceStyle = {
      marginBottom: "20px",
      border: "1px solid #ccc",
      padding: "15px",
      backgroundColor: "#f5f5f5",
      boxShadow: "0 2px 4px rgba(0, 0, 0, 0.1)",
    };
    
    const subHeadingStyle = {
      color: "#333",
    };
    
    const textStyle = {
      color: "#666",
    };
    
    const footerStyle = {
      position: "absolute",
      bottom: 0,
      width: "100%",
      backgroundColor: "#007acc",
    };
    
    const footerTextStyle = {
      color: "white",
    };
    
    
export default Services;