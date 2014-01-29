<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="jumbotron">
    
    <c:set var="passUpcomingEvent" value="${upcomingEvent}" scope="request" />
    <jsp:include page="/WEB-INF/views/home/${upcomingJsp}" >
      <jsp:param name="upcomingEvent" value="passUpcomingEvent"/>
    </jsp:include>
    
</div>

<c:import url="/WEB-INF/views/home/infocolumns.jsp"/>
    
