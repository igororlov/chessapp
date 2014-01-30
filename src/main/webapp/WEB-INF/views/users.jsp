<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Users</h1>

<hr class="soften">

<table class="table table-striped table-hover">
  <tbody>
    <c:forEach items="${userAccounts}" var="userAccount">
      <tr onclick="window.document.location='users/${userAccount.id}';" >
          <td>${userAccount.id}</td>
          <td>${userAccount.firstName}</td>
          <td>${userAccount.lastName}</td>
          <td>${userAccount.birthDate}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>