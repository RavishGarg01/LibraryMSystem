import React from "react";
import BackgroundImage from "../assets/donation-background.jpg"; // Replace with your image path

const donationPageStyle = {
  textAlign: "center",
  padding: "50px",
  backgroundImage: `url(${BackgroundImage})`, // Set background image
  backgroundSize: "cover",
  color: "white",
};

const donationTitleStyle = {
  fontSize: "32px",
  color: "#007acc",
  marginBottom: "20px",
};

const donationText = `
  Your contribution can make a difference! By donating, you're supporting our mission to provide valuable resources and services to our community. Whether it's books, technology, or educational programs, your donation matters. Thank you for being a part of this good cause.
`;

const donationMessage = `
  Every donation helps us to create a positive impact. Your support empowers us to continue our efforts in promoting education, knowledge, and growth. We greatly appreciate your generosity and partnership in making a positive change.
`;

const donateButtonStyle = {
  backgroundColor: "#007acc",
  color: "white",
  border: "none",
  borderRadius: "5px",
  padding: "10px 20px",
  fontSize: "18px",
  cursor: "pointer",
};

function Donation() {
  return (
    <div style={donationPageStyle}>
      {/* <h1 style={donationTitleStyle}>Donate for a Good Cause</h1> */}
      <p>{donationText}</p>
      <p>{donationMessage}</p>
      <button style={donateButtonStyle}>Donate Now</button>
    </div>
  );
}

export default Donation;
