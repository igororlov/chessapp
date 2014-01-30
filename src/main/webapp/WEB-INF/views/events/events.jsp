<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<h1> Events </h1>

<table class="table table-striped table-hover table-bordered">
  <c:forEach items="${events}" var="event">
    <joda:format var="startTime" value="${event.startTime}" pattern="dd/MM/yyyy HH:mm" style="F-" dateTimeZone="Europe/Oslo"/>
    <joda:format var="deadlineTime" value="${event.deadlineTime}" pattern="dd/MM/yyyy HH:mm" style="F-" dateTimeZone="Europe/Oslo"/>

  
    <tr onclick="window.document.location='events/${event.id}';">
      <td>${event.name}</td>
      <td>${event.description}</td>
      <td>${deadlineTime}</td>
      <td>${startTime}</td>
      <td>
         <a href="events/${event.id}/register" class="btn btn-success btn-large" >Register now</a>
      </td>
    </tr>
  </c:forEach>
</table>

