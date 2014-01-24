<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Users:</h1>

<table class="table table-striped table-hover">
  <c:forEach items="${userAccounts}" var="userAccount">
    <tr>
        <td>${userAccount.id}</td>
        <td>${userAccount.firstName}</td>
        <td>${userAccount.lastName}</td>
        <td>${userAccount.birthDate}</td>
        <td>
          <a href="users/${userAccount.id}" class="btn btn-success btn-large" >View Profile</a>
        </td>
    </tr>
  </c:forEach>
</table>