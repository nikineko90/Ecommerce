const cartBtn = document.querySelector('.cart-btn');
const closeCartBtn = document.querySelector('.close-cart');
const clearCartBtn = document.querySelector('.clear-cart');
const cartDOM = document.querySelector('.cart');
const cartOverlay = document.querySelector('.cart-overlay');
const cartItems = document.querySelector('.cart-items');
const cartTotal = document.querySelector(".cart-total");
const cartContent = document.querySelector(".cart-content");
const productsDOM = document.querySelector(".products-center");

/* 
    CARRELLO
*/
let carrello = [];
/*
    BOTTONI
*/
let bottoniDOM = [];


/* 
    PRENDO I PRODOTTI DA JSON
*/
class Prodotti{

/* 
 * Sgart.it - chiamata ajax in GET
 * url: url del servizio da chiamare con eventuali parametri in query string
 * fnCallbackOk: funzione richiamata in caso di successo
 * fnCallbackError: funzione richiamata in caso di errore
 */
  getProdotti(url, fnCallbackOk, fnCallbackError) {
  // creo l'oggetto per la chiamata
  var xHttp = new XMLHttpRequest();
  // gestisco la callback di risposta
  xHttp.onreadystatechange = function () {
    if (this.readyState === 4) {
      if (this.status === 200) {
        if (typeof fnCallbackOk === "function") {
          // se ho un  200 tutto ok, 
          // chiamo la funzione passata di callback passandogli l'oggetto json
          fnCallbackOk(JSON.parse(this.responseText));
        } else {
          // se non ho passato una funzione stampo un warning in console;
          console.log("warning: reponse ok but no calback function", url);
        }
      } else {
        // se sono qui c'è stato un errore, lo scrivo sempre in console
        console.log("Error", url, this.status, this.responseText);
        if (typeof fnCallbackError === "function") {
          // se esiste chiamo la callback di errore
          fnCallbackError(this.status, this.responseText);
        }
      }
    }
  };
  // inposto la chiamata in GET asincrona (true)
  xHttp.open("GET", url, true);
  // imposto il content type per le chiamate json
  xHttp .setRequestHeader("Content-type", "application/json");
  // header necessario per le chiamate alla API di SharePoint
  xHttp .setRequestHeader("Accept", "application/json; odata=verbose");
  // eseguo la chiamata
  xHttp.send();
};





 //   async getProdotti(){
     prendiProdotti(res){
        try {
                // prendi il vettore "prodotti" del file
                let prodotti = res.prodotti;
                prodotti = prodotti.map(prodotto =>{
                /*
                    PER OGNI PRODOTTO DEL VETTORE PRODOTTI,
                    PRENDO LE PROPRIETA' CHE MI INTERESSANO, 
                    NE CREO UN NUOVO OGGETTO IN FORMATO JSON,
                    E LO RITORNO
                */
               const id = prodotto.id;
               const nome = prodotto.nome;
               const prezzo = prodotto.prezzo;
               //const immagine = prodotto.immagine.file.url;
               console.log(nome);
               return {id, nome, prezzo};
            });
            return prodotti;
        } catch (error) {
            console.log(error);
        }
    }
}

/*
    CLASSE UI -> USER INTERFACE, SERVIRA' A RENDERIZZARE TUTTO.
*/


/*
    CLASSE STORE, SERVE A FARE LE OPERAZIONI DI GET E SAVE DEI PRODOTTI.
*/
class Store{

}


/*
    ASPETTO IL CARICAMENTO DEL DOCUMENTO PER STAMPARE I VARI PRODOTTI.
*/
$(document).ready(function(){

	const productsDOM = document.querySelector(".products-center");
    function getArticoli(res) {
        $.get("articoli?sesso=M", function (res) {
            
            let ris = "";
            for(let i = 0; i < res.length; i++){
            	console.log(res[i])
                ris += `
                <article class="product">
                <div class="img-container">
                    <img src="#" alt="" class="product-img">
                    <button class="bag-btn" data-id=${res[i].id}>
                        <i class="fas fa-shopping-cart"></i>
                        aggiungi al carrello
                    </button>
                </div>
                <h3>${res[i].nome}</h3>
                <h4>${res[i].prezzo}&euro;</h4>
                <h3>${res[i].id}</h3>
                </article>
                `;
            }

            productsDOM.innerHTML = ris;
        });
    }


    getArticoli();
});