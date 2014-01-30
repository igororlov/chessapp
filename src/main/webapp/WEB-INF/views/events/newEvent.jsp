<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Create new event</h1>

<hr class="soften">

<div class="col-sm-6 well">
  <form:form role="form">
    <div class="form-group">
      <label>Name</label>
      <input type="text" class="form-control" placeholder="Text input">
    </div>
    
    <div class="form-group">
      <label>Description</label>  
      <textarea class="form-control" rows="3"></textarea>
    </div>
  </form:form>
</div>