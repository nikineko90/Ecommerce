
/*
    SE L'UTENTE NON E' MAI ENTRATO IN QUESTA SESSIONE,
    CREO UN CARRELLO.
*/
/*
if(!localStorage.getItem("carrello")){
    console.log("non c'è ancora");
    localStorage.setItem("carrello", []);
}
else {
    console.log("c'è!!");
}
/*
    FUNZIONE CHE AGGIUNGE UN OGGETTO AL CARRELLO.
*/
/*
let aggiungiAlCarrello = (oggetto) => {
    console.log(oggetto);
    let tmp = localStorage.getItem("carrello");
    tmp.push(oggetto);

    for(let i = 0; i < tmp.length; i++){
        console.log(carrello[i]);
    }
    console.log(carrello.length);
}
*/
function aggiungiAlCarrello(oggetto){
    let numeroProdotto = numeroProdotti();
    localStorage.setItem(numeroProdotto, oggetto);
    console.log(localStorage.getItem(numeroProdotto));
}

function numeroProdotti (){
    let nProdotti = localStorage.getItem('nProdotti');

    nProdotti = parseInt(nProdotti);

    if(nProdotti){
        localStorage.setItem('nProdotti', nProdotti +1);
        nProdotti++;
    } else {
        localStorage.setItem('nProdotti', 1);
        nProdotti = 1;
    }

    return nProdotti;
}