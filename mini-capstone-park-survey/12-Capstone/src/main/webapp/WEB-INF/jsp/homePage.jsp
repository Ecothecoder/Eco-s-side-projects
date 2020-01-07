<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div id="main-page">
	<c:forEach var="park" items="${parks}">
		<div class="post">
			<div class="photo">
			
				<a  href="parkDetail?parkCode=${park.parkCode}"><img src="img/parks/${park.parkCodeLowercase}.jpg" /></a>
			</div>
			<div class="text">
				<h1>${park.parkName} - ${park.state}</h1>
				<p>${park.parkDescription}</p>
			</div>
		</div>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />