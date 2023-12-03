<%@page import="entities.Ville"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des villes</title>
<style>
    body {
        background-color: teal; /* Définition de la couleur de fond en bleu */
        color: white; /* Changement de la couleur du texte pour le contraste */
        text-align: center; /* Centrer le contenu */
    }

    ul {
        list-style: none; /* Supprime les puces de la liste */
        padding: 0;
    }

    ul li {
        display: inline-block; /* Affiche les éléments de la liste en ligne */
        margin: 5px;
    }

    table {
        margin: 0 auto; /* Centre le tableau horizontalement */
        border-collapse: collapse;
        width: 50%; /* Largeur du tableau */
    }

    th, td {
        border: 1px solid white; /* Bordure pour les cellules */
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #2c3e50; /* Couleur de fond pour les cellules d'en-tête */
    }

    tr:nth-child(even) {
        background-color: #4CAF50; /* Couleur de fond pour les lignes paires */
    }

    tr:nth-child(odd) {
        background-color: #357ca5; /* Couleur de fond pour les lignes impaires */
    }

    td {
        color: white; /* Couleur du texte dans les cellules */
    }
</style>
</head>
<body>

    <form action="VilleController">
        Nom : <input type="text" name="ville" /> <br>
        <button>Enregistrer</button>
    </form>

    <h1>Liste des villes : </h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${villes}" var="v">
                <tr>
                    <td>${v.id}</td>
                    <td>${v.nom}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
