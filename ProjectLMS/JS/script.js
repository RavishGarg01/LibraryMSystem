fetch("http://localhost:8080/student").then((data)=>
{
    // console.log(data);
    return data.json();
}).then((student)=>
{
    console.log(student[0].name);
    let tableData="";
    student.map((values)=>{
        tableData+=` <tr>
        <td>${values.id}</td>
        <td>${values.name}</td>
        <td>${values.branch}</td>
        <td>${values.course}</td>
        <td>${values.year}</td>
        
      </tr>
      `
    })
    document.getElementById("table_body").
    innerHTML=tableData;
})


