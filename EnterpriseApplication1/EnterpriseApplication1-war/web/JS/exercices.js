var solution = [
    [{src: 'IMG/00.jpeg'}, {src: 'IMG/01.jpeg'}, {src: 'IMG/02.jpeg'}, {src: 'IMG/03.jpeg'}, {src: 'IMG/04.jpeg'}],
    [{src: 'IMG/10.jpeg'}, {src: 'IMG/11.jpeg'}, {src: 'IMG/12.jpeg'}, {src: 'IMG/13.jpeg'}, {src: 'IMG/14.jpeg'}],
    [{src: 'IMG/20.jpeg'}, {src: 'IMG/21.jpeg'}, {src: 'IMG/22.jpeg'}, {src: 'IMG/23.jpeg'}, {src: 'IMG/24.jpeg'}],
    [{src: 'IMG/30.jpeg'}, {src: 'IMG/31.jpeg'}, {src: 'IMG/32.jpeg'}, {src: 'IMG/33.jpeg'}, {src: 'IMG/34.jpeg'}],
    [{src: 'IMG/40.jpeg'}, {src: 'IMG/41.jpeg'}, {src: 'IMG/42.jpeg'}, {src: 'IMG/43.jpeg'}, {src: 'IMG/44.jpeg'}],
]

var melange = melanger();

function genererImage(t) {

    var ligne = t.length;
    var colonne = t[0].length;

    for (var i = 0; i < ligne; i++) {

        for (var j = 0; j < colonne; j++) {

            var calcul = document.getElementById(i + "" + j);
            calcul.innerHTML = '<img src="' + t[i][j].src + '" />';
        }
    }
}

function shuffle(tab) {
    var a = tab.slice();
    var j, x, i;
    
    for (i = a.length; i; i -= 1) {
        j = Math.floor(Math.random() * i);
        x = a[i - 1];
        a[i - 1] = a[j];
        a[j] = x;
    }
    return a;    
}

function melanger() {
    
    melange = shuffle(solution);
    
    for(var i = 0; i < melange.length; i++) {        
        melange[i] = shuffle(melange[i]);
    }
    genererImage(melange);
}

function verifier (tab, solution){
    
    var ligne = tab.length;
    var colonne = tab[0].length;
    
    for (i = 0; i < ligne; i++){
        
        for (j = 0; j < colonne; j++){
            
            if (tab[i][j].src !== solution[i][j].src);
                return false;
        }
    }
    return true;
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    ev.target.appendChild(document.getElementById(data));
}