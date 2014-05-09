<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
  <script type="text/javascript">
    $.getJSON( "http://localhost:8080/chessapp/api/formFieldsApi/getAllAsDto", function( data ) {      
      
      for (var i = 0; i < data.length; i++) { 
        var formField = document.createElement("div");
        formField.setAttribute('class', 'checkbox'); 
        
        var formFieldLabel = document.createElement("label");
        if (data[i].required) {
          formFieldLabel.innerHTML = "<input type='checkbox' disabled='disabled' checked> " + data[i].name;
        } else {
          formFieldLabel.innerHTML = "<input type='checkbox'> " + data[i].name;
        }
        formField.appendChild(formFieldLabel);   
        
        document.getElementById('registrationParametersGroup').appendChild(formField); 
        
        //console.log(data[i].name);
      } 
      
    });
  </script>

<div class="col-md-8 col-md-offset-2">
  <h1 class="text-center"> Create new event </h1>
  <hr class="soften">
</div>

<div class="col-md-6 col-md-offset-3 well">
  <form:form role="form">
    <div class="form-group">
      <label>Name</label>
      <input type="text" class="form-control" placeholder="Text input">
    </div>
    <div class="form-group">
      <label>Description</label>  
      <textarea class="form-control" rows="3"></textarea>
    </div>
    <div id="registrationParametersGroup" class="form-group">
      <label>Required fields</label>
    </div>  
  </form:form>
</div>

