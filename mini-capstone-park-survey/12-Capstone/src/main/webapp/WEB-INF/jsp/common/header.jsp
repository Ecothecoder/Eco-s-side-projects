<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Weather Service</title>
<c:url value="/css/npgeekcss.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
	<header>
		<c:url value="/" var="homePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${homePageHref}"> <img src="${logoSrc}"
			alt="National Park Geek logo" />
		</a>
	</header>
	<nav>

		<div>
			<ul class="butt">
				<li><a href="<c:url value="/"/>"><button>Home</button></a></li>
				<li><a href="<c:url value="/Survey"/>"><button>Survey</button></a></li>
			</ul>
		</div>

	</nav>