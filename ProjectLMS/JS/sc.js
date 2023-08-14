fetch("http://localhost:8080/book").then((data)=>
{
    // console.log(data)
    return data.json();

}).then((book)=>{
    console.log(book);
    let tableData="";
    book.map((values)=>{
        tableData+=`
        
        <td>${values.name}</td>
        <td>${values.author}</td>
        <td>${values.isissued}</td>`;
    })
    document.getElementById("book_table").
    innerHTML=tableData;
})