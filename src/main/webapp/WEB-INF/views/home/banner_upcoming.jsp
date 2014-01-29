<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<joda:format var="deadlineTime" value="${upcomingEvent.deadlineTime}" pattern="dd/MM/yyyy HH:mm" style="F-" dateTimeZone="Europe/Oslo"/>

<h1>Upcoming event!</h1>
<h1>${upcomingEvent.name}</h1>
<p>${upcomingEvent.description}</p>
<p>Registration deadline: ${deadlineTime}</p>
<p><a href="<c:url value="/events/${upcomingEvent.id}" />" class="btn btn-success btn-lg">Register Now &raquo;</a></p>   

