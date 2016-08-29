<%-- 
    Document   : boite_dialogue_taxi
    Created on : 29 août 2016, 15:23:04
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Boite dialogue taxi</title>
    </head>
    <body>

        <div class="container">
            <h2></h2>
            <!-- Trigger the modal with a button -->
            <button type="button" class="btn btn-info btn-lg" 
                    data-toggle="modal" data-target="#myModal">Detail 
                Taxi</button>
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-
                                    dismiss="modal">&times;</button>
                            <h4 class="modal-title">Titre taxi</h4>
                        </div>
                        <div class="modal-body">
                            <p>Affichage du detail du taxi</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-
                                    default" data-dismiss="modal">Fermer</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
