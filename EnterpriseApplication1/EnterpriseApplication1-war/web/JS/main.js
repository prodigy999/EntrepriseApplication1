function color() {

    var p = document.getElementById("paraph");
    p.style.color = "red";

}

function ajouter(col, ligne) {

    var tab = document.getElementById("nouvTableau").insertRow(-1);
    var ligne = tab.insertRow(col);
    var cellule = ligne.insertCell(ligne);
}

function random() {
    var random = document.getElementById("resultat");

    var min = 0;
    var max = 12;
    Math.floor(Math.random() * (max - min + 1) + min);

}

function nouveauNombre() {

    var ligne = window.prompt("Entrer le nombre de lignes :");
    var col = window.prompt("Entre le nombre de colonnes :");

    for (var i = 0; i < col; i++) {
        var tab = document.getElementById("nouvTableau").insertRow(-1);

        for (var y = 0; y < ligne; y++) {
            var cellule = tab.insertCell(0);
            cellule.innerHTML = "ligne" + i + " colonne " + y;
        }
    }
}

function supprimerOption() {

    var optionASuppr = document.getElementById("listOption");
    optionASuppr.remove(optionASuppr.selectedIndex);
}



