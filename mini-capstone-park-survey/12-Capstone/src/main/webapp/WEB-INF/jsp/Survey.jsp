<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="parkRankingUrl" value="/parkRanking" />
<div class="survey">
<table>
	<form:form id="signUp" action="${parkRankingUrl}" method="POST"
		modelAttribute="formData">
		
			<tr>
				<td><label for="email">Email</label></td>
				<td><form:input id="email" name="email"
						placeholder="enter email" type="text" path="emailAddress" required="required"/>
						<form:errors
						path="emailAddress" class="error" /></td> 
			</tr>
			<tr>
				<td><label for="verify">Verify Email</label></td>
				<td><form:input id="verify" type="text"
					placeholder="confirm email address" path="emailVerification" required="required"/>
				<form:errors path="emailMatching" class="error" /></td>
			</tr>
			<tr>
				<td><label for="state">State</label></td>
				<td><form:select name="state" path="state">
					<c:forEach var="state" items="${states}">
						<form:option value="${state}">${state}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="validState" class="error"/>
				</td>
			</tr>
			<tr>
				<td><label for="parkCode">Choose Your Favorite Park!</label></td>
				<td><form:select name="parkCode" path="parkCode">
					<c:forEach var="park" items="${parks}">
						<form:option value="${park.parkCode}">${park.parkName}</form:option>
					</c:forEach>
				</form:select>
				<%-- <form:errors path="validParkCode" class="error"/>--%>
				</td>
			</tr>
			<tr>
			<td><label for="activityLevel">How Active Are You!?</label></td>
			<td>	
				<form:radiobutton name="activityLevel" path="activityLevel" value="Inactive" checked="checked"/> Inactive
				<form:radiobutton name="activityLevel" path="activityLevel" value="Sedentary" /> Sedentary
				<form:radiobutton name="activityLevel" path="activityLevel" value="Active" /> Active
				<form:radiobutton name="activityLevel" path="activityLevel" value="EXTREMEly Active" /> EXTREMEly Active
			</tr>
			<tr>
				<td><input type="submit" value="Submit!" /></td>
			</tr>
		
	</form:form>
	</table>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />