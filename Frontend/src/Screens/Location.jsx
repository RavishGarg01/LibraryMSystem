import React from "react";
function Location() {
    return (<>
        <div className="d-flex flex-row">
            <div className="col">
                <h3>Location</h3>
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d13826.631069446628!2d74.7032923!3d29.9605211!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x94402b24f013eb57!2se%20library!5e0!3m2!1sen!2sin!4v1638694969283!5m2!1sen!2sin"
                    width="400"
                    height="400"
                    style={{ border: 0 }}
                    allowfullscreen=""
                    loading="lazy"
                    title="library location">
                </iframe>
            </div>
            <div className="col d-flex flex-column  align-items-start">
            <h3>Timing</h3>
                <h5 style={{textAlign:"left"}}>
                    Monday-Thursday: 9 am-5 pm<br/>
                    Friday: Closed<br/>
                    Saturday,Sunday: 9 am-5 pm<br/>
                </h5>
            </div>
        </div>


    </>
    );
}
export default Location;