<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<h1>Events page!</h1>

<table class="table table-striped table-hover">
  <c:forEach items="${events}" var="event">
    <tr>
      <td>${event.name}</td>
      <td>${event.description}</td>
    </tr>
  </c:forEach>
</table>


