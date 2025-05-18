function Charges() {
  return (
    <div style={membershipStyle}>
      <h3 style={headingStyle}>Membership Charges</h3>
      <div>
        <h4 style={subHeadingStyle}>Yearly Membership</h4>
        <p style={priceStyle}>650 Rs</p>
        <p>Additional 100 Rs for renewal of membership every year</p>
      </div>
      <div>
        <h4 style={subHeadingStyle}>Life Time Membership</h4>
        <p style={priceStyle}>2100 Rs</p>
      </div>
      <div>
        <h4 style={subHeadingStyle}>Institutional Membership</h4>
        <p style={priceStyle}>5100 Rs</p>
        <p>
          Any Institute (like Schools, Colleges, and Coaching Classes) can
          provide membership to its students and workers.
        </p>
      </div>
    </div>
  );
}

const membershipStyle = {
  textAlign: "left",
  padding: "20px",
  border: "1px solid #ccc",
  backgroundColor: "#f5f5f5",
  boxShadow: "0 2px 4px rgba(0, 0, 0, 0.1)",
};

const headingStyle = {
  color: "#007acc",
};

const subHeadingStyle = {
  color: "#333",
};

const priceStyle = {
  fontWeight: "bold",
};

// const contentStyle = {
//   color: "#666",
// };

export default Charges;
