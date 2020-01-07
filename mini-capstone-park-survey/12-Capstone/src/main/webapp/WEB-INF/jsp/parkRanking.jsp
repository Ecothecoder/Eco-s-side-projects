<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<script src="js/confetti.js"></script>
<div>
<div class="text"><h1>Survey Results</h1></div>
	
	
	<c:forEach var="park" items="${parks}">
		<c:choose>
			<c:when test="${park == parks.get(0)}">
				<div id="favheader"><h2>Winner: </h2> </div>
				<div id="fav" class="post">
				
			</c:when>	
			<c:otherwise>
				<div id="favheader"><h2>Runner Up: </h2> </div>
				<div class="post">
			</c:otherwise>
		</c:choose>

		<div class="photo">
			<a  href="parkDetail?parkCode=${park.parkCode}"><img src="img/parks/${park.parkCodeLowercase}.jpg" /></a>
		</div>
		<div class="text">
			<h1>${park.parkName}</h1>
			<p>Number of votes! ${park.favoriteCount}</p>
		</div>
	</div>
	<c:choose>
	<c:when test="${park == parks.get(0)}">
	</c:when>
	</c:choose>
	</c:forEach>
	<script>confetti.start();</script>

</div>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />