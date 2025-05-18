import React, { useState, useEffect } from "react";

import "../css/suggestion.css"; // Import the CSS file
function SearchBook() {
  const [inputValue, setInputValue] = useState("");
  const [apiResponse, setApiResponse] = useState([]);
  const [error, setError] = useState(null);
  const [suggestions, setSuggestions] = useState([]);
  // const [searchResults, setSearchResults] = useState([]);

  const handleSearch = async () => {
    try {
      const response = await fetch(`http://localhost:8080/book-by-approxname`, {
        method: "POST",
        credentials:'include',
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ name: inputValue }),
      });
      const data = await response.json();

      if (response.ok) {
        setApiResponse(data);
        setSuggestions([]);
        setError(null);
      } else {
        setApiResponse([]);
        setError(`Error: ${data.message}`);
      }
    } catch (error) {
      setApiResponse(`Error fetching data: ${error.message}`);
    }
  };
  const fetchSuggestions = async (query) => {
    try {
      const response = await fetch(`http://localhost:8080/book-by-approxname`, {
        method: "POST",
        credentials:'include',
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ name: query }),
      });
      const data = await response.json();

      if (response.ok) {
        setSuggestions(data);
        setError(null);
      } else {
        setSuggestions([]);
        setError(`Error: ${data.message}`);
      }
    } catch (error) {
      console.error("Error fetching suggestions:", error);
    }
  };
  useEffect(() => {
    if (inputValue.length >= 4) {
      const timeoutId = setTimeout(() => {
        fetchSuggestions(inputValue);
      }, 300);

      return () => clearTimeout(timeoutId);
    }
  }, [inputValue]);

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      <div style={{ display: "flex", flexFlow: "row wrap" }}>
        <input
          type="text"
          value={inputValue}
          // onChange={handleInputChange}
          onChange={(e) => setInputValue(e.target.value)}
        />
        <button title="Search" type="submit" onClick={handleSearch}>
          Search
        </button>
      </div>

      {suggestions.length > 0 && (
        <div
          className="suggestion-box"
        >
          <ul className="suggestion-list">
            {suggestions.map((suggestion, index) => (
              <li key={index} className="suggestion" >{suggestion.name}</li>
            ))}
          </ul>
        </div>
      )}
      {/* {apiResponse !== null && <div>{apiResponse}</div>} */}
      {error && <div>{error}</div>}

      <table>
        <thead>
          <tr>
            <th>Sr. No.</th>
            <th>Title</th>
            <th>Author</th>
          </tr>
        </thead>
        {apiResponse.length > 0 && (
          <tbody>
            {apiResponse.map((book, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td>{book.name}</td>
                <td>{book.author}</td>
              </tr>
            ))}
          </tbody>
        )}
      </table>
    </div>
  );
}
export default SearchBook;
