function bookfunc(){
    var Name=$(`#name`).val()
    var Author=$(`#author`).val()
    
    fetch("http://localhost:8080/transection/16/book",{
        method:'POST',
        body:JSON.stringify({
            name:Name,
            author:Author,
            isissued:'true',
           
        
            
        }),

        headers: {
             'Content-type':'application/json; charset=UTF-8',
            },
        
    } )
    .then((response) => response.json())
    .then((data)=>console.log(data));
}