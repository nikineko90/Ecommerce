
/*
function setCookie(cname, cvalue, exdays) {
    if(cname === "nProdotti"){
        let x = getCookie("nProdotti");
        console.log(x);
        x = parseInt(x);
        console.log(x);
        x += 1;
        console.log(x);
        document.cookie = `nProdotti=${x}`;
        return;
    }
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

setCookie("nProdotti", "0");

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
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

let aggiungiAlCarrello = (oggetto) => {
    setCookie("nProdotti");
    setCookie(getCookie("nProdotti")-1, oggetto);

    let x = getCookie("prodotti");
    console.log(x[0]);
    console.log(x);
}

*/
//let carrello = [];
//localStorage.setItem("carrello", carrello);
/*
let aggiungiAlCarrello = (oggetto) => {
    console.log(oggetto);
    carrello.push(oggetto);

    for(let i = 0; i < carrello.length; i++){
        console.log(carrello[i]);
    }
    console.log(carrello.length);
}
*/