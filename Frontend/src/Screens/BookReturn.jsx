import React from "react";
function BookReturn(){
    return(
        <h5 style={{textAlign:"left"}}>library Members can borrow books for 2 weeks.<br/>
        Return of the borrowed book is mandatory before the due date. A fine of Rs.1/- per day per book for the first week of delayed return and Rs.10/- per day per book thereafter will be levied. Books can be renewed once, before the due date, if there is no pending reservation against it.
        </h5>
    );
}
export default BookReturn;