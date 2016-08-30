<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="../../JS/jemacarse.js" type="text/javascript"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul id="menu_horizontal">
    <c:choose>
        <c:when test="${connecte==null}">
            Veuillez vous connecter ou vous inscrire
        </c:when>
        <c:otherwise>
            <label>Jemacarse Vite fait, bien fait !!</label>
            <li><a href="historique"><img src="PNG/HISTORIQUE.PNG" width="45" alt=""/></a></li>
            <li><a href="itineraire"><img src="PNG/LOGOCLIENT.png" width="70" alt=""/></a></li>
            <li><a href="deconnexion"><img src="PNG/GNOME.png" width="35" alt=""/></a></li>
            <li>Bonjour ${connecte.login}</li>
            <li><a href="geolocalisation">Accueil</a></li>
            </c:otherwise>
        </c:choose>
</ul>