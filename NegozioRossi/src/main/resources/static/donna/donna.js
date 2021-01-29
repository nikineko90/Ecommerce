
/*
    ASPETTO IL CARICAMENTO DEL DOCUMENTO PER STAMPARE I VARI PRODOTTI.
*/
var productsDOM = document.querySelector(".products-center");

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


let getArticolo = (id) => {
    $.ajax({
        url: `http://localhost:8080/articoli?id=${id}`,
        type: 'GET',
        success: function(res){
            let ris = "";
            ris += `
            <div class="row">
                <div class="col-4">
                    <div id="carouselExampleControls" class="carousel slide dettaglio" data-bs-ride="carousel">
                        <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src=${res[id-1].immagine} class="d-block w-100 img-fluid w3-image" width="600" height="400" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src=${res[id-1].immagine} class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src=${res[id-1].immagine} class="d-block w-100" alt="...">
                        </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                        </a>
                    </div>
        
        
                </div>

                <div class="col-2">
                </div>

                <div class="col-6">
                    <div class="row mb-3">
                        <h3>Nome:${res[id-1].nome}</h3> 
                    </div>
                    <div class="row mb-3">
                        <h3>Prezzo: ${res[id-1].prezzo}</h3>
                    </div>

                    <select class="form-select mb-3" aria-label="Default select example">
                        <option selected>Taglia</option>
                        <option value="1">L</option>
                        <option value="2">XL</option>
                        <option value="3">XXL</option>
                    </select>

                    <select class="form-select mb-3" aria-label="Default select example">
                        <option selected>Colore</option>
                        <option value="1">Rosso</option>
                        <option value="2">Verde</option>
                        <option value="3">Bianco</option>
                        <option value="4">Giallo</option>
                    </select>

                    <button class="carrello-btn" data-id=${res.id} onClick="aggiungiAlCarrello(${{
                        nome: res[id-1].nome,
                        prezzo: res[id-1].prezzo
                    }})">
                        <i class="fas fa-shopping-cart"></i>
                        aggiungi al carrello
                    </button>
                </div>
            </div>
            `;
            productsDOM.innerHTML = ris;
        }
    });
}

$(document).ready(function(){
    let productsDOM = document.querySelector(".products-center");
    console.log(productsDOM);
    console.log("hello");

    /* CHIAMATA AJAX CHE FA GET DI TUTTO. */
    function getArticoli(res) {
        $.ajax({
            url: "http://localhost:8080/articoli?sesso=F",
            type: "GET",
            success: res => {
                let ris = "";
                for(let i = 0; i < res.length; i++){
                    console.log(res[i]);
                    ris += `
                    <article class="product">
                    <div class="img-container">
                        <img src=${res[i].immagine} alt="" class="product-img">
                        <button class="bag-btn" data-id=${res[i].id} onclick="getArticolo(${res[i].id})">
                            vai al prodotto
                        </button>
                    </div>
                    <h3>${res[i].nome}</h3>
                    <h4>${res[i].prezzo}&euro;</h4>
                    </article>
                    `;
                }
    
                productsDOM.innerHTML = ris;
            }
        });
    }
    
    getArticoli();
});