var statusElements = document.querySelectorAll(".status");

statusElements.forEach(function(status) {
    if (status.textContent === "Em andamento") {
        status.classList.add("andamento");
    } else if (status.textContent === "Concluído") {
        status.classList.add("concluido");
    } else if (status.textContent === "Desistiu") {
        status.classList.add("desistiu");
    }
});


function toggleLista(icon){
    let td = icon.closest("td")
    let lista = td.querySelector(".lista-status")
    if(lista.style.display==="none" || lista.style.display ===""){
        icon.style.color="rgb(70, 210, 70)";
        lista.style.display= "block";
    } else{
        icon.style.color="black";
        lista.style.display ="none";
    }
}