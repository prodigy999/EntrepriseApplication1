<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="../../JS/jemacarse.js" type="text/javascript"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul id="menu_horizontal">
    <c:choose>
        <c:when test="${connecte==null}">
            Veuillez vous connecter ou vous inscrire
        </c:when>
        <c:otherwise>
            <c:import url="_TITRE.jsp"/>
            <li><a href="accueil">Accueil</a></li>
            <li><a href="historique"><img src="PNG/HISTORIQUE.PNG" width="40" alt=""/></a></li>
            <li><img src="PNG/LOGO.png" width="50" alt="" onclick="boited();" /></li>
            <li><a href="deconnexion"><img src="PNG/GNOME.png" alt=""/></a></li>
            <li>Bonjour ${connecte.login}</li>
            </c:otherwise>
        </c:choose>
            
</ul>