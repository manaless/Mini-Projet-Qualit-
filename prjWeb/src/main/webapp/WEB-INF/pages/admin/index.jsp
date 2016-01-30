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

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div class="titre">Espace client</div>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<div align="right" class="login">
					<img class="img" src="<c:url value="/resources/images/a.png"/>" />
					&nbsp; ${pageContext.request.userPrincipal.name} - <a href="<c:url value="/logout" />">Déconnexion</a>
				</div>
			</div>

		</div>
	</nav>

	<div class="contenu">

		<div class="hello">
			Bienvenue : <strong>${l.prenom} ${l.nom}</strong>
		</div>


		<div class="row" style="width: 800px">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Client</th>
						<th>Type transaction</th>
						<th>Montant</th>
						<th>Date</th>
						<th>Etat</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${transaction}" var="t" >
						<tr>
							<td><c:out
									value="${lp.getClient(t.client.idClient).nom} ${lp.getClient(t.client.idClient).prenom}" /></td>
							<td><c:out value="${t.type}" /></td>
							<td><c:out value="${t.montant}" /></td>
							<td><c:out value="${t.date}" /></td>
							<td><c:out value="${t.etat}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>





	</div>
	<spring:url value="/resources/css/starter-template.css" var="coreCss" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />

	<script src="${coreJs}"></script>
	<script src="${bootstrapJs}"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>