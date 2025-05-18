import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
axios.defaults.withCredentials = true;
function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  async function login(event) {
    event.preventDefault();
    try {
      await axios
        .post(
          "http://localhost:8080/auth/login",
          {
            username: username,
            password: password,
          },
          {
            headers: {
              "Content-Type": "application/json",
              Accept: "*/*",
            },
          }
        )
        .then(
          (res) => {
            console.log(res.data);

            if (res.data.message === "Username not exits") {
              alert("Username not exits");
            } else if (res.data == "Login successful!") {
              navigate("/admin");
            } else {
              alert("Incorrect Username and Password not match");
            }
          },
          (fail) => {
            console.error(fail); // Error!
          }
        );
    } catch (err) {
      alert(err);
    }
  }

  return (
    <>
      {/* Full-Width Horizontal Line */}

      <div className="d-flex flex-column align-items-center">
        {/* <div className="container" style={{ maxWidth: "400px" }}> */}
          <div className="row justify-content-center">
            <div className="col-12">
              {/* <h2 className="text-center mb-4">Login</h2> */}

              <form>
                <div className="mb-4">
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
                {/*  2 column grid layout for inline styling  */}
                <div className="row mb-4">
                  <div className="col d-flex justify-content-center">
                    {/*  Checkbox  */}
                    <div className="form-check">
                      <input
                        className="form-check-input"
                        type="checkbox"
                        value=""
                        id="form2Example31"
                        checked
                      />
                      <label className="form-check-label" for="form2Example31">
                        {" "}
                        Remember me{" "}
                      </label>
                    </div>
                  </div>

                  <div className="col">
                    {/* Simple link */}
                    <a href="#!">Forgot password?</a>
                  </div>
                </div>
                <button
                  type="submit"
                  className="btn btn-primary btn-block mb-4"
                  onClick={login}
                >
                  Sign in
                </button>
                <div className="text-center">
                  <p>
                    Not a member? <a href="/register">Register</a>
                  </p>
                  <p>or sign up with:</p>
                  <button
                    type="button"
                    className="btn btn-link btn-floating mx-1"
                  >
                    <i className="fab fa-facebook-f"></i>
                  </button>

                  <button
                    type="button"
                    className="btn btn-link btn-floating mx-1"
                  >
                    <i className="fab fa-google"></i>
                  </button>

                  <button
                    type="button"
                    className="btn btn-link btn-floating mx-1"
                  >
                    <i className="fab fa-twitter"></i>
                  </button>

                  <button
                    type="button"
                    className="btn btn-link btn-floating mx-1"
                  >
                    <i className="fab fa-github"></i>
                  </button>
                </div>
              </form>
            </div>
          </div>
        {/* </div> */}
      </div>
    </>
  );
}

export default Login;
