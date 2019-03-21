function question(){
    let btn = document.getElementById("basic-question");
    let helper = document.getElementById("helper-button");
    fetch("/question")
        .then(res => {
            return res.text();
        }).then(data =>
        btn.innerHTML = data).then(data => fetch("http://localhost:8084/say/" + data))
        .then(helper.classList.remove("btn-hidden"))
}

function answer(){

    fetch("/answer")
        .then(res => {
            return res.text();
        })
        .then(data => fetch("http://localhost:8084/say/" + data))
}