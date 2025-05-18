import { useState } from "react";
import axios from "axios";

function Register() {
  // const [employeename, setEmployeename] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  async function save(event) {
    event.preventDefault();
    try {
      await axios.post("http://localhost:8080/auth/register", {
        username: username,
        password: password,
      },
      {
        headers: {
          "Content-Type": "application/json",
          Accept: "*/*",
        },
      }).then(
        (res)=> {
          alert(res.data.message);
        }
      );
    } catch (err) {
      if (err.response) {
        // Server responded with a status other than 2xx
        console.log("line 29")
        console.log(err)
        alert(`Error ${err.response.status}: ${err.response.data.message || 'Something went wrong'}`);
      } else if (err.request) {
        // Request was made but no response was received
        console.log("line 32")
        alert("No response received from the server.");
      } else {
        // Something else happened in making the request
        console.log("line 35")
        alert("An unexpected error occurred: " + err.message);
      }
    }
  }

  return (
    <div>
      <div className="d-flex flex-column align-items-center">
        <div className="row justify-content-center">
        <div className="col-12">
          <h1>User Registation</h1>

          <form>
          <div className="form-outline mb-4">
                  <label htmlFor="username" className="form-label">
                    Username
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="username"
                    placeholder="Enter Username"
                    value={username}
                    onChange={(event) => setUsername(event.target.value)}
                  />
                </div>

                <div className="form-outline mb-4">
                  <label htmlFor="password" className="form-label">
                    Password
                  </label>
                  <input
                    type="password"
                    className="form-control"
                    id="password"
                    placeholder="Enter Password"
                    value={password}
                    onChange={(event) => setPassword(event.target.value)}
                  />
                </div>





            <button type="submit" class="btn btn-primary mt-4" onClick={save}>
            Sign Up
            </button>
          </form>
        </div>
        </div>
      </div>
    </div>
  );
}

export default Register;
