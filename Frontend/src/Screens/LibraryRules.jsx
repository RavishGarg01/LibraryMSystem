import React from "react";

function LibraryRules() {
  return (
    <div>
      <header style={headerStyle}>
        <h1>Welcome to Our Library</h1>
      </header>

      <main style={mainStyle}>
        <h2 style={headingStyle}>Library Rules</h2>

        <div style={ruleStyle}>
          <h3 style={subHeadingStyle}>Membership</h3>
          <p style={textStyle}>All students and staff members are eligible for library membership.</p>
        </div>

        <div style={ruleStyle}>
          <h3 style={subHeadingStyle}>Borrowing Books</h3>
          <p style={textStyle}>Members can borrow a maximum of 3 books for a period of 14 days.</p>
        </div>

        <div style={ruleStyle}>
          <h3 style={subHeadingStyle}>Returning Books</h3>
          <p style={textStyle}>Books must be returned on or before the due date to avoid late fees.</p>
        </div>

        <div style={ruleStyle}>
          <h3 style={subHeadingStyle}>Fine</h3>
          <p style={textStyle}>A fine of Rs. 1/- per day per book for the first week of delayed return and Rs. 10/- per day per book thereafter will be levied.</p>
        </div>
        
        {/* Add more rules here */}
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

const ruleStyle = {
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

export default LibraryRules;
