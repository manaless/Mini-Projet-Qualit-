<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<head>
<title>Insert title here</title>


<spring:url value="/resources/css/starter-template.css" var="coreCss" />
<spring:url value="/resources/css/style.css" var="css" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${css}" rel="stylesheet" />
</head>

<body style="background-color: #f9f9f9">
	<div align="center" class="choix">
	<div align="center" style="padding-bottom: 70px;">
		<div style="font-size: 40px;font-weight: bold;">Bienvenue</div>
		<div style="font-size: 20px;color: #34495e">Veuillez choisir selon votre profil</div>
	</div>


	<br>



		<a href="adminindex"> Administrateur</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a href="userindex">Utilisateur</a>
	</div>


	<spring:url value="/resources/css/starter-template.css" var="coreCss" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />

	<script src="${coreJs}"></script>
	<script src="${bootstrapJs}"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>