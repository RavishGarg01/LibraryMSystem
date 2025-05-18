import React, { useState } from "react";
// import axios from "axios";

function Search(props) {
  const [searchText, setSearchText] = useState("");
  const [searchOption, setSearchOption] = useState("name"); // Default search option
  const [showDropdown, setShowDropdown] = useState(false);

  const handleBookSearch = async (
    event,
    searchOptionSelect,
    searchTextSelect
  ) => {
    const triggeringElement = event.target;
    console.log("Triggering element:", triggeringElement);
    try {
      const response = await fetch(props.dropdownOptions[searchOption], {
        method: "POST",
        credentials:'include',
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ [searchOption]: searchText }),
      });
      const data = await response.json();

      if (response.ok) {
        console.log(data);
        props.handleCallback(data);
      } else {
        //   setError(`Error: ${data.message}`);
      }
    } catch (error) {
      // setApiResponse(`Error fetching data: ${error.message}`);
    }
  };

  const handleDropdownToggle = () => {
    setShowDropdown(!showDropdown);
  };

  const handleOptionSelect = (option) => {
    setSearchOption(option);
    setShowDropdown(false);
    setSearchText("");
  };

  return (
    <>
      <div>
        <input
          type="text"
          value={searchText}
          onChange={(e) => setSearchText(e.target.value)}
          placeholder={"Search by " + searchOption}
        />
        <div className="btn-group">
          <button
            type="button"
            onClick={(e) => {
              e.preventDefault();
              handleBookSearch(searchOption, searchText);
            }}
            className="btn btn-sm btn-primary"
          >
            Search
          </button>
          <button
            onClick={(e) => {
              e.preventDefault();
              handleDropdownToggle();
            }}
            type="button"
            className="btn btn-sm btn-primary dropdown-toggle dropdown-toggle-split"
          >
            <span class="visually-hidden">Toggle Dropdown</span>
          </button>
          {showDropdown && (
            <ul
              className="dropdown-menu"
              style={{
                display: "block",
                position: "absolute",
                color: "black",
                background: "white",
                textAlign: "left",
                margin: "30px",
                ransform: "translateY(-50%)",
              }}
            >
              {Object.keys(props.dropdownOptions).map((option, index) => (
                <li
                  key={index}
                  onClick={() => handleOptionSelect(option)}
                  className="dropdown-item"
                >
                  {option}
                </li>
              ))}
            </ul>
          )}
        </div>
      </div>
    </>
  );
}

export default Search;
