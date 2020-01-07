<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<div>
	<div>
		<div class="post">
			<div class="photo" id="detail photo">
				<img src="img/parks/${selectedPark.parkCodeLowercase}.jpg" />
			</div>
			<div class="text">
				<h1>${selectedPark.parkName}</h1>
				<p>${selectedPark.parkDescription}</p>
				<p><b>Inspirational Quote:</b> "${selectedPark.inspirationalQuote}"
					-${selectedPark.inspirationalQuoteSource}</p>
			</div>
		</div>


		<div id="table-info">
			<table id="info">
				<tr>
					<th>Acerage</th>
					<th>Location</th>
					<th>Elevation</th>
					<th>Miles Of Trails</th>
					<th>Number Of Campsites</th>

				</tr>
				<tr>
				<fmt:formatNumber type = "number" value = "${selectedPark.acreage}" var="ace"/>
					<td><p>${ace} Acers</p></td>
					<td><p>${selectedPark.state}</p></td>
					<fmt:formatNumber type = "number" value = "${selectedPark.elevation}" var="el"/>
					<td><p>${el} FT</p></td>
					<td><p>${selectedPark.milesOfTrail} Miles</p></td>
					<fmt:formatNumber type = "number" value = "${selectedPark.numberOfCampsites}" var="noc"/>
					<td><p>${noc}</p></td>

				</tr>
				<tr>
					<th>Climate</th>
					<th>Year Founded</th>
					<th>Annual Visitor Count</th>
					<th>Entry Fee</th>
					<th>Number Of Animal Types</th>
				</tr>
				<tr>
					<td><p>${selectedPark.climate}</p></td>
					<td><p>${selectedPark.yearFounded}</p></td>
					<fmt:formatNumber type = "number" value = "${selectedPark.annualVisitorCount}" var="visitorcount"/>
					<td><p>${visitorcount}</p></td>
				    <fmt:formatNumber value = "${selectedPark.entryFee}" type = "currency" var="entryfee"/>
					<td><p>${entryfee}</p></td>
					<td><p>${selectedPark.numberOfAnimalSpecies}</p></td>
				</tr>

			</table>

		</div>
	</div>
</div>

<h1 style="text-align:center;">5 DAY FORECAST!</h1>
<c:set var="temp" value="${tempChoice}" />
<div id="tempbutton">
	<form method="POST" id="tempbutton1">
		<c:choose>
			<c:when test="${temp == 2}">
				<button class="btn btn-danger" name="tempChoice" value="1"
					type="submit">Change Temperatures to Fahrenheit</button>
			</c:when>
			<c:otherwise>
				<button class="btn btn-primary" name="tempChoice" value="2"
					type="submit">Change Temperatures to Celcius</button>
			</c:otherwise>
		</c:choose>
	</form>
</div>

<div class="weather w3-container ">
	<c:forEach var="w" items="${weather}">

		<c:choose>
			<c:when test="${w.getValue().fiveDayForecast == 1}">

				<div id="today" class="card w3-center w3-animate-bottom">
					<h1>TODAY!</h1>
					<div>
						<img
							src="img/weather/${w.getValue().getCamelCaseWords(w.getValue().forecast)}.png" />
						<span class="card-text">${w.getValue().getFlavorText(w.getValue().forecast, w.getValue().high, w.getValue().low)}</span>
					</div>
					<div id="temp">
						<c:choose>
							<c:when test="${temp == 2}">
								<span><br>High: ${w.getValue().highC}° C</span>
							</c:when>
							<c:otherwise>
								<span><br>High: ${w.getValue().high}° F</span>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="temp">
						<c:choose>
							<c:when test="${temp == 2}">
								<span><br>Low: ${w.getValue().lowC}° C</span>
							</c:when>
							<c:otherwise>
								<span><br>Low: ${w.getValue().low}° F</span>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div id="forecast" class="card w3-center w3-animate-bottom">
					<div>
						<img
							src="img/weather/${w.getValue().getCamelCaseWords(w.getValue().forecast)}.png" />
						<span class="card-text">${w.getValue().getFlavorText(w.getValue().forecast, w.getValue().high, w.getValue().low)}</span>
					</div>
					<div id="temp">
						<c:choose>
							<c:when test="${temp == 2}">
								<span><br>High: ${w.getValue().highC}° C</span>
							</c:when>
							<c:otherwise>
								<span><br>High: ${w.getValue().high}° F</span>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="temp">
						<c:choose>
							<c:when test="${temp == 2}">
								<span><br>Low: ${w.getValue().lowC}° C</span>
							</c:when>
							<c:otherwise>
								<span><br>Low: ${w.getValue().low}° F</span>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:otherwise>
		</c:choose>

	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />