function loadMap() {

    var mapOptions = {
        center: new google.maps.LatLng(50.606447, 3.152580),
        zoom: 15,
        panControl: false,
        zoomControl: true,
        scaleControl: false,
        mapTypeControl: false,
        streetViewControl: false,
        overviewMapControl: false,
        rotateControl: false
    }

    var map = new google.maps.Map(document.getElementById("sample"), mapOptions);

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = {
                enableHighAccuracy: true,
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            map.setCenter(pos);

            var marker = new google.maps.Marker({
                position: pos,
                map: map,
                draggable: false,
                icon: 'PNG/CLIENT.PNG',
                title: 'Votre position actuelle'
            });
        }, function () {
            erreurLocalisation(true, infoWindow, map.getCenter());
        });
    } else {

        erreurLocalisation(false, infoWindow, map.getCenter());
    }


    function erreurLocalisation(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
                'Erreur: La geolocalisation à échoué.' :
                'Erreur: Votre navigateur ne supporte pas la géolocalisation');
    }

    
    var contentMarker = [
        '<div id="containerTabs">',
        '<div id="tabs">',
        '<ul>',
        '<li><a href="#tab-1"><span>Lorem</span></a></li>',
        '<li><a href="#tab-2"><span>Ipsum</span></a></li>',
        '<li><a href="#tab-3"><span>Dolor</span></a></li>',
        '</ul>',
        '<div id="tab-1">',
        '<h3>Lille</h3><p>Suspendisse quis magna dapibus orci porta varius sed sit amet purus. Ut eu justo dictum elit malesuada facilisis. Proin ipsum ligula, feugiat sed faucibus a, <a href="http://www.google.fr">google</a> sit amet mauris. In sit amet nisi mauris. Aliquam vestibulum quam et ligula pretium suscipit ullamcorper metus accumsan.</p>',
        '</div>',
        '<div id="tab-2">',
        '<h3>Aliquam vestibulum</h3><p>Aliquam vestibulum quam et ligula pretium suscipit ullamcorper metus accumsan.</p>',
        '</div>',
        '<div id="tab-3">',
        '<h3>Pretium suscipit</h3><ul><li>Lorem</li><li>Ipsum</li><li>Dolor</li><li>Amectus</li></ul>',
        '</div>',
        '</div>',
        '</div>'
    ].join('');
    
    var panel = document.getElementById('panel');
    
    var direction = new google.maps.DirectionsRenderer({
        map: map
    });
    
    var infoWindow = new google.maps.InfoWindow({
        content: contentMarker,
        position: pos
    });

    google.maps.event.addListener(marker, 'click', function () {
        infoWindow.open(map, marker);
    });

    google.maps.event.addListener(infoWindow, 'domready', function () { 
        jQuery("#tabs").tabs();
    });
    
    calculate = function () {
        
    origin = map.getCenter();
    alert(origin);
    destination = document.getElementById('destination').value; // Le point d'arrivé
    if (origin && destination) {
        var request = {
            origin: origin,
            destination: destination,
            travelMode: google.maps.DirectionsTravelMode.DRIVING // Mode de conduite
        };
        var directionsService = new google.maps.DirectionsService(); // Service de calcul d'itinéraire
        directionsService.route(request, function (response, status) { // Envoie de la requête pour calculer le parcours
            if (status == google.maps.DirectionsStatus.OK) {
                direction.setDirections(response); // Trace l'itinéraire sur la carte et les différentes étapes du parcours
                alert("Réponse Ok de google");
                alert(calcDistance(origin, origin));
                var route = response.routes[0];
            
            var summaryPanel = document.getElementById('directions_panel');
            summaryPanel.innerHTML = '';
            
            var distance_totale = 0;
            var duree_totale = 0;
            for (var i = 0; i < route.legs.length; i++) {
            var routeSegment = i + 1;
            summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment + '</b><br>';
            summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
            summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
            summaryPanel.innerHTML += route.legs[i].duration.text + '<br>';
            summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
            
            distance_totale = distance_totale + route.legs[i].distance.value;
            duree_totale = duree_totale + route.legs[i].duration.value;
            }
            
            document.getElementById('distance_trajet').value = (Math.floor(distance_totale / 1000)) + "," + (distance_totale % 1000) + " km";
            document.getElementById('duree_trajet').value = (Math.floor(duree_totale / 60)) + " m " + (duree_totale % 60) + " s";
        }});
    }};
}
