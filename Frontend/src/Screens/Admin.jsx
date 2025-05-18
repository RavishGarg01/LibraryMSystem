import React, { useState, useEffect } from "react";
import Popup from "../components/Popup";
import Search from "../components/Search";
import "../css/suggestion.css"; // Import the CSS file
const columnStyle = {
  width: "48%", // Adjust width as needed
  // alignSelf: 'flex-start',
  border: "1px solid #ccc",
  padding: "15px",
  backgroundColor: "#f5f5f5",
  boxShadow: "0 2px 4px rgba(0, 0, 0, 0.1)",
  marginBottom: "20px",

  flex: 1, // Let columns take equal space
};
const columnStyleRight = {
  justifyContent: "right",
  textAlign: "right",
  // alignSelf: 'flex-start',
  width: "48%", // Adjust width as needed
  border: "1px solid #ccc",
  padding: "15px",
  backgroundColor: "#f5f5f5",
  boxShadow: "0 2px 4px rgba(0, 0, 0, 0.1)",
  marginBottom: "20px",
  flex: 1, // Let columns take equal space
};

const AdminPage = () => {
  const [showPopup, setShowPopup] = useState(false);
  const [popupMessage, setPopupMessage] = useState("");
  const [popupColor, setPopupColor] = useState("");
  const [bookSearchResults, setBookSearchResults] = useState([]);
  const [studentSearchResults, setStudentSearchResults] = useState([]);
  const [selectedStudent, setSelectedStudent] = useState(null);
  const [selectedBook, setSelectedBook] = useState(null);
  const [issuedBooks, setIssuedBooks] = useState([]);

  const studentRows = document.querySelectorAll(
    ".student .custom-table tbody tr"
  );

  const handleStudentSelect = async (student) => {
    console.log(student);
    studentRows.forEach((row) => {
      row.addEventListener("click", () => {
        studentRows.forEach((r) => r.classList.remove("selected"));
        row.classList.add("selected");
      });
    });
    setSelectedStudent(student);
  };
  const bookRows = document.querySelectorAll(".book .custom-table tbody tr");
  const handleBookSelect = async (book) => {
    console.log(book);
    bookRows.forEach((row) => {
      row.addEventListener("click", () => {
        bookRows.forEach((r) => r.classList.remove("selected"));
        row.classList.add("selected");
      });
    });
    setSelectedBook(book);
  };

  const handleReturnBook = async (book, student) => {
    try {const response = await fetch(
        "http://localhost:8080/transection/return",
        {
          method: "POST",
          credentials: 'include',
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            studentName: student.name,
            bookName: book.name,
          }),
        }
      );
      // Update the issued books list after returning the book
      if (response.ok) {
        console.log("Return Successfully: ", response);
        setPopupMessage("Return Successfully");
        setPopupColor("success");
        setShowPopup(true); 
        setIssuedBooks(issuedBooks.filter((bookInstance) => bookInstance !== book));
        
      } else {
        const result = await response.text();
        console.error("Request failed with status:", result);
        setPopupMessage(result);
        setPopupColor("error");
        setShowPopup(true);
      }
    } catch (error) {
      console.error("Error returning book:", error);
    }
  };

  const handleIssueBook = async () => {
    if (selectedStudent && selectedBook) {
      console.log(selectedStudent);
      console.log(selectedBook);
      try {
        const response = await fetch(
          "http://localhost:8080/transection/issue",
          {
            method: "POST",
            credentials: 'include',
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({
              studentName: selectedStudent.name,
              bookName: selectedBook.name,
            }),
          }
        );
        // console.log(response);

        // Update the issued books list after issuing the book
        // setIssuedBooks([...issuedBooks, selectedBook]);
        if (response.ok) {
          const data = response.json();
          console.log(data);
          setPopupMessage("Issued Successfully");
          setPopupColor("success");
          setShowPopup(true);
          setIssuedBooks([...issuedBooks, selectedBook]);
        } else {
          const result = await response.text();
          console.error("Request failed with status:", result);
          setPopupMessage(result);
          setPopupColor("error");
          setShowPopup(true);
        }
      } catch (error) {
        console.error("An error occurred:", error);
        setPopupMessage(error);
        setPopupColor("error");
        setShowPopup(true);
      }
    }
  };
  useEffect(() => {
    // Automatically close the popup after 10 seconds
    const timeout = setTimeout(() => {
      setShowPopup(false);
    }, 3000);

    // Clean up the timeout when the component unmounts
    return () => clearTimeout(timeout);
  }, [showPopup]);
  const handleIssuedBooks = async (student) => {
    try {
      const response = await fetch("http://localhost:8080/student/books", {
        method: "POST",
        credentials: 'include',
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          name: student.name,
        }),
      });

      if (response.ok) {
        const data = await response.json();
        console.log(data);
        setIssuedBooks(data);
      }
      console.log("I m here");
    } catch (error) {
      console.error("Error fetching issued books:", error);
    }
  };
  useEffect(() => {
    // Clear issued books when selected student changes
    setIssuedBooks([]);
  }, [selectedStudent]);


  function BookResultCallback(data) {
    console.log("Here",data,bookSearchResults);
    setBookSearchResults(data);
    console.log("Here",data,bookSearchResults);
  }
  function StudentResultCallback(data) {
    setStudentSearchResults(data);
  }
  return (
    <>
      <header style={headerStyle}>
        <h1>Admin Page</h1>
      </header>
      <div style={{ display: "flex", justifyContent: "center" }}>
        {
          <Popup
            message={popupMessage}
            color={popupColor}
            visible={showPopup}
          />
        }
        <button
          onClick={handleIssueBook}
          disabled={!selectedStudent || !selectedBook}
          style={{
            position: "absolute",
            // alignSelf: 'flex-start',
            // left:"50%",
            transform: "translateY(50%)",
            // bottom:"10px",
            justifyContent: "center",
            height: "50px",
            backgroundColor: "#007acc",
            color: "white",
            padding: "10px 20px",
            borderRadius: "5px",
            border: "none",
            cursor: selectedStudent && selectedBook ? "pointer" : "default",
          }}
        >
          Issue Book
        </button>

        <div style={columnStyle}>
          <h2>Search Books</h2>
          <Search
            // dropdownOptions={[{"author":"http://localhost:8080/book-by-approxname"}, {"name":"http://localhost:8080/book-by-approxname"}, {"published year":""},{ "id ":""}]}
            dropdownOptions={{
              "author": `http://localhost:8080/book-by-author`,
              "name": `http://localhost:8080/book-by-approxname`,
              "published year": "",
              "bookId": `http://localhost:8080/book-by-id`
            }}
            
            handleCallback={BookResultCallback}
          />
          <div className="book">
            <table className="custom-table">
              <thead>
                <tr>
                  <th style={{ width: "1.5cm" }}>Sr. No.</th>
                  <th style={{ width: "10cm" }}>Title</th>
                  <th style={{ width: "3cm" }}>Author</th>
                </tr>
              </thead>
              {bookSearchResults.length > 0 ? (
                <tbody>
                  {bookSearchResults.map((book, index) => (
                    <tr
                      key={book.bookId}
                      onClick={() => handleBookSelect(book)}
                    >
                      <td>{index + 1}</td>
                      <td>{book.name}</td>
                      <td>{book.author}</td>
                    </tr>
                  ))}
                </tbody>
              ) : (
                <tbody>
                  <tr>
                    <td colSpan="3">No data available</td>
                  </tr>
                </tbody>
              )}
            </table>
          </div>
        </div>

        <div style={columnStyleRight}>
          <h2>Search Students</h2>
          <Search
            dropdownOptions={{"name":"http://localhost:8080/student-by-approxname", "college ID":""}}
            handleCallback={StudentResultCallback}
          />
          <div className="student">
            <table className="custom-table">
              <thead>
                <tr>
                  <th style={{ width: "2cm" }}>Sr. No.</th>
                  <th style={{ width: "3cm" }}>collegeId</th>
                  <th style={{ width: "3cm" }}>name</th>
                  <th style={{ width: "2cm" }}>branch</th>
                  <th style={{ width: "2cm" }}>year</th>
                  <th style={{ width: "2cm" }}>fine</th>
                </tr>
              </thead>
              {studentSearchResults.length > 0 ? (
                <tbody>
                  {studentSearchResults.map((student, index) => (
                    <React.Fragment key={student.id}>
                      <tr onClick={() => handleStudentSelect(student)}>
                        <td>{index + 1}</td>
                        <td>{student.collegeId}</td>
                        <td>{student.name}</td>
                        <td>{student.branch}</td>
                        <td>{student.year}</td>
                        <td>{student.fine}</td>
                        <button
                          onClick={() => handleIssuedBooks(student)}
                          style={{
                            backgroundColor: "#007acc",
                            color: "white",
                            // padding: "5px 10px",
                            // borderRadius: "50%",
                            border: "none",
                            cursor: "pointer",
                            // marginLeft: "10px",
                          }}
                        >
                          <span role="img" aria-label="Down Arrow">
                            &#x25BC;
                          </span>
                          {/* down arrow character */}
                        </button>
                      </tr>
                      {selectedStudent && selectedStudent.id === student.id && (
                        <>
                          {issuedBooks.length > 0 ? (
                            <>
                              {issuedBooks.map((book, index) => (
                                <tr key={book.bookId}>
                                  <td colspan="1" style={{ width: "1cm" }}>
                                    {index + 1}
                                  </td>
                                  <td colspan="2" style={{ width: "55cm" }}>
                                    {book.name}
                                  </td>
                                  <td colspan="2" style={{ width: "15cm" }}>
                                    {book.author}
                                  </td>
                                  <button
                                    onClick={() =>
                                      handleReturnBook(book, student)
                                    }
                                  >
                                    Return
                                  </button>
                                </tr>
                              ))}
                            </>
                          ) : (
                            <tbody>
                              <tr>
                                <td colSpan="3">No data available</td>
                              </tr>
                            </tbody>
                          )}
                        </>
                      )}
                    </React.Fragment>
                  ))}
                </tbody>
              ) : (
                <tbody>
                  <tr>
                    <td colSpan="6">No data available</td>
                  </tr>
                </tbody>
              )}
            </table>
          </div>

          {/* {selectedStudent && (
            <div>
              <h3>Issued Books for {selectedStudent.name}</h3>
              <ul>
                {issuedBooks.map((book) => (
                  <li key={book.id}>
                    {book.name}
                    <button onClick={() => handleReturnBook(book)}>
                      Return
                    </button>
                  </li>
                ))}
              </ul>
            </div>
          )} */}
        </div>
      </div>
    </>
  );
};
const headerStyle = {
  backgroundColor: "#007acc",
  color: "white",
  textAlign: "center",
  padding: "10px",
};

export default AdminPage;
