function question(){
    let btn = document.getElementById("basic-question");
    fetch("/question")
        .then(res => {
            return res.text();
        }).then(data =>
        btn.innerHTML = data).then(data => fetch("http://localhost:8084/say/" + data))
}

function answer(){

    fetch("/answer")
        .then(res => {
            return res.text();
        })
        .then(data => fetch("http://localhost:8084/say/" + data))
}