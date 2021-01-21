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
    async getProdotti(){
        try {
            //PRENDI IL FILE prodotti.json
            let ris = await fetch('prodotti.json');
            let dati = await ris.json();
            // prendi il vettore "prodotti" del file
            let prodotti = dati.prodotti;
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
               const immagine = prodotto.immagine.file.url;
               console.log(nome);
               return {id, nome, prezzo, immagine};
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
class UI{
    stampaProdotti(prodotti){
        let ris = '';
        prodotti.forEach(prodotto =>{
            ris += `
            <article class="product">
            <div class="img-container">
                <img src=${prodotto.immagine} alt="" class="product-img">
                <button class="bag-btn" data-id=${prodotto.id}>
                    <i class="fas fa-shopping-cart"></i>
                    aggiungi al carrello
                </button>
            </div>
            <h3>${prodotto.nome}</h3>
            <h4>${prodotto.prezzo}&euro;</h4>
        </article>
            `
        });

        productsDOM.innerHTML = ris;
    }

}

/*
    CLASSE STORE, SERVE A FARE LE OPERAZIONI DI GET E SAVE DEI PRODOTTI.
*/
class Store{

}


/*
    ASPETTO IL CARICAMENTO DEL DOCUMENTO PER STAMPARE I VARI PRODOTTI.
*/
document.addEventListener("DOMContentLoaded", ()=>{
    const ui = new UI();
    const prodotti = new Prodotti();

    prodotti.getProdotti()
    .then(prodotti =>{
        ui.stampaProdotti(prodotti); //STAMPO I PRODOTTI.
    });

});