
/*
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
        c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
    }
    }
    return "";
}
let carrello = [];

let aggiungiProdottoAlCarrello = (nome, prezzo) =>{
    carrello.push({nome, prezzo});
    console.log(carrello[0].nome);
    console.log(carrello[0].prezzo);
}

let stampaCarrello = () =>{

   let tBody = document.querySelector(".table-body");
   let ris = "";
   for(let x = 0; x < carrello.length; x++){
        ris +=   `
            <tr>
        <td>${carrello[x].nome}</td>
        <td>${carrello[x].prezzo}</td>
        <td>1</td>
        <td>${carrello[x].prezzo}</td>
            </tr>
                `
   }
   tBody.innerHTML = ris;
}

*/

/*
    ASPETTO IL CARICAMENTO DEL DOCUMENTO PER STAMPARE I VARI PRODOTTI.
*/
/*
document.addEventListener("DOMContentLoaded", ()=>{
    console.log("sono dentro ");
    let nProdotti = document.cookie.split(";");
    console.log(nProdotti);
    nProdotti = nProdotti.length;
    console.log(nProdotti);

    for(let x = 0; x < nProdotti ; x++){
        console.log(x);
        let prodotti = getCookie(x).split(",");
        console.log(prodotti);
        for(let y = 0; y < prodotti.length; y++){
            console.log(prodotti);
            aggiungiProdottoAlCarrello(prodotti[0], prodotti[2]);
        }
    }

    stampaCarrello();
});

*/

let carrello = [];

function stampaCarrello(){
    let tBody = document.querySelector(".table-body");
    let totale = 0;
    let ris = "";
    for(let x = 0; x < carrello.length; x++){
        ris +=   `
            <tr>
        <td>${carrello[x].nome}</td>
        <td>${carrello[x].prezzo}</td>
        <td>1</td>
        <td>${carrello[x].prezzo}</td>
            </tr>
                `;
        totale += parseFloat(carrello[x].prezzo);
    }
    ris += `
        <tr>
            <td colspan="3">Totale carrello</td>
            <td>${totale}</td>
        </tr>
            `;
    tBody.innerHTML = ris;
}

function aggiungiAlCarrello(nome, prezzo){
    carrello.push({nome, prezzo});
}

document.addEventListener("DOMContentLoaded", ()=>{
    console.log("sono dentro");
    let nProdotti = localStorage.getItem('nProdotti');

    for(let i = 0; i < nProdotti; i++){
        let oggetto = localStorage.getItem(i+1);
        let prodotto = oggetto.split(',');
        console.log(prodotto);
        aggiungiAlCarrello(prodotto[0], prodotto[1]);
    }

    stampaCarrello();
    /*
        finisce qui
    */
});
