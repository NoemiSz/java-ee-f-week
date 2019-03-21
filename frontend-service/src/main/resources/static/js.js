function question(){
    let btn = document.getElementById("basic-question");
    fetch("/question")
        .then(res => {
            return res.text();
        }).then(data =>
        btn.innerHTML = data)
}