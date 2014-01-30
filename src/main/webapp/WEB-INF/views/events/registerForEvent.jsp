<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Registrating for ${event.name}</h1>

<hr class="soften">

<div class="col-sm-6 well">
  <form:form role="form">
     <c:forEach items="${event.formFields}" var="formField">
        <div class="form-group">
          <label for="exampleInputEmail1">Email address</label>
          <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Password</label>
          <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
    </c:forEach>
    
    <button type="submit" class="btn btn-default">Submit</button>
  
  </form:form>
</div>