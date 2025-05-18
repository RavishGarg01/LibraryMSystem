import React, { useEffect, useState } from "react";
import "../css/popup.css";

function Popup({ message, color,visible}) {
  const [isVisible, setIsVisible] = useState(visible);

//   useEffect(() => {
//     setIsVisible(visible)
//     // Automatically close the popup after 10 seconds
//     const timeout = setTimeout(() => {
//       setIsVisible(false);
//     }, 10000);

//     // Clean up the timeout when the component unmounts
//     return () => clearTimeout(timeout);
//   }, [visible]);

  return (
    <div className={`popup ${color} ${visible ? "visible" : ""}`}>
      {message}
    </div>
  );
}

export default Popup;
