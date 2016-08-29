<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul id="menu_horizontal">
    <c:choose>
        <c:when test="${connecte==null}">
            Veuillez vous connecter ou vous inscrire
            </c:when>
            <c:otherwise>
                <c:import url="_TITRE.jsp"/>
                Bonjour ${connecte.login}
                <li><a href="accueil">Accueil</a></li>
                <li><a href="historique">Historique</a></li>
                <li><a href="geolocalisation">Commander une course</a></li>
                <li><a href="deconnexion">Deconnexion</a></li>
            </c:otherwise>
        </c:choose>

</ul>