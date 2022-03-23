
const routeId = document.getElementById("routeId").value;
const commentsContent = document.getElementById("commentCtnr");


fetch(`http://localhost:8080/api/comments/${routeId}/all`)
    .then(res=> res.json()).then(data=> {
        console.log(data)
    for (let comment of data) {
        console.log(comment)
        commentsContent.innerHTML+= `<p> date: ${comment.created} Author: ${comment.authorName}  <br> <h6>${comment.textContent} </h6>  </p>`
    }

})



