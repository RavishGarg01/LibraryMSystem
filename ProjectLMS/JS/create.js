
function myFunc(){

var Names= $(`#name`).val();
var Course=$('#course').val();
var Branch=$('#branch').val();
var Year=$('#year').val();
fetch('http://localhost:8080/student', {
  method: 'POST',
  body: JSON.stringify({
    name: Names,
    course: Course,
    branch: Branch,
    year:Year,
  }),
  headers: {
    'Content-type': 'application/json; charset=UTF-8',
  },
})
  .then((response) => response.json())
  .then((obj) => console.log(obj));
}