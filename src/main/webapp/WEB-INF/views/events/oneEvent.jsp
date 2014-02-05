<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>


   

<div class="col-md-6 col-md-offset-3">
  <h1> ${event.name} </h1>

  <div class="panel panel-primary ">
    <div class="panel-heading">
      <h3 class="panel-title">Description</h3>
    </div>
    <div class="panel-body">
      ${event.description}
    </div>
  </div>

  <div class="panel panel-primary ">
    <div class="panel-heading">
      <h3 class="panel-title">Location</h3>
    </div>
    <div class="panel-body">
      Nedre Ullevål 7, Oslo
    </div>
  </div>
  
  <div class="btn-toolbar" role="toolbar">
    <button type="button" class="btn btn-primary">View participants</button>
    <button type="button" class="btn btn-success">Register now</button>
  </div>
  
</div>