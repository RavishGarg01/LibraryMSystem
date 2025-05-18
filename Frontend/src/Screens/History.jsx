import React from "react";
import InaugurationImage from "../assets/Adobe Scan Dec 04, 2021_1 (1).jpg";

const containerStyle = {
  display: "flex",
  justifyContent: "center",
  alignItems: "center",
  padding: "40px",  // Increased padding
  backgroundColor: "#f9f9f9",
};

const textStyle = {
  flex: "1",
  padding: "20px",
  color: "#333",
  fontFamily: "Arial, sans-serif",
  fontWeight: "400",
  lineHeight: "1.6",
  fontSize: "18px",
};

const imageStyle = {
  flex: "1",
  maxWidth: "40%",  // Reduced image size
  boxShadow: "0 2px 4px rgba(0, 0, 0, 0.1)",
  marginLeft: "40px",  // Added margin
};

function History() {
  return (
    <div style={containerStyle}>
      <div style={textStyle}>
        <p>
          Welcome to our library, a place of knowledge and remembrance. This library stands as a tribute to the memory of the Dabwali Fire Tragedy. It is a testament to the power of community and the spirit of learning.
        </p>
      </div>
      <div style={imageStyle}>
        <img src={InaugurationImage} alt="Library Inauguration Stone Tile" style={{ width: "100%", height: "auto" }} />
      </div>
    </div>
  );
}

export default History;
