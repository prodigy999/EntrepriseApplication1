<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/csspp.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/cssb.css" rel="stylesheet" type="text/css"/>
        <c:import url="_STYLESHEET.jsp"/>            
    </head>
    <body>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">
            <table>
                <thead>
                    <tr>
                        <th width="150" style="text-align: center">Pseudo</th>
                        <th width="150" style="text-align: center">Nom</th>
                        <th width="150" style="text-align: center">Prenom</th>
                        <th width="150" style="text-align: center">Adresse</th>
                        <th width="150" style="text-align: center">Mail</th>
                        <th width="150" style="text-align: center">Moyenne note</th>
                        <th width="150" style="text-align: center">Courses</th>    
                        <c:if test="${connecte.rolePersonne=='CHAUFFEUR'}">
                            <th width="150" style="text-align: center">Vehicules</th>
                        </c:if>
                    </tr>
                </thead>
                    <tbody>
                        <tr>
                            <td style="text-align: center">${personne.login}</td>
                            <td style="text-align: center">${personne.nom}</td>
                            <td style="text-align: center">${personne.prenom}</td>
                            <td style="text-align: center">${personne.adresse}</td>
                            <td style="text-align: center">${personne.mail}</td>
                            <td style="text-align: center">${personne.noteGlobale}</td>
                            <c:forEach items="${personne.courses}" var="course">
                                <td style="text-align: center"><a href="/detailCourse/?idCourse=${course.id}">${course.dateCourse}</a></td>
                            </c:forEach>
                            <c:if test="${connecte.rolePersonne=='CHAUFFEUR'}">
                                <c:forEach items="${personne.vehicules}" var="vehicule">
                                    <td style="text-align: center"><a href="/detailVehicule/?idVehicule=${vehicule.id}">${vehicule.marque}</a></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                    </tbody>
                </table>
            </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
