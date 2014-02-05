<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
  <script type="text/javascript">
    var id = ${event.id};
    var url = "http://localhost:8080/chessapp/api/eventsApi/" + id + "/formFields";
    
    $.getJSON( url, function( data ) {      
      
      var formFields = [];
      
      for (var i = 0; i < data.length; i++) { 
        var formField = document.createElement("div");
        formField.setAttribute('class', 'form-group'); 
        
        var formFieldLabel = document.createElement("label");
        if (data[i].required) {
          formFieldLabel.innerHTML = data[i].name + "*";
        } else {
           formFieldLabel.innerHTML = data[i].name;
        }
        
        formField.appendChild(formFieldLabel);   
        
        var formFieldInput;
        switch (data[i].formFieldType) {
          case 'string':
            formFieldInput = document.createElement("input");
            formFieldInput.setAttribute('class', 'form-control'); 
            formFieldInput.setAttribute('type', 'text');
            formFieldInput.setAttribute('placeholder', data[i].name); 
            break
          case 'date':
            formFieldInput = document.createElement("input");
            formFieldInput.setAttribute('class', 'form-control');
            formFieldInput.setAttribute('type', 'text');
            formFieldInput.setAttribute('value', '12-02-2012');
            //alert('Date not implemented yet, see: http://www.eyecon.ro/bootstrap-datepicker/')
            break
          case 'stringAlternative':
            formFieldInput = document.createElement("select");
            formFieldInput.setAttribute('class', 'form-control'); 
            formFieldInput.innerHTML = '<option>1</option><option>2</option>'; // TODO edit normally
            break
          case 'bool':
            formFieldInput = document.createElement('input');
            formFieldInput.setAttribute('type', 'checkbox');
            formFieldInput.innerHTML = data[i].name;
            break
          case 'integer':
            alert('Integer not implemented yet')
            break
          case 'decimal':
            alert('Decimal not implemented yet')
            break                         
          default:
            alert('Failed to map FormFieldType')  
        }
        
        formField.appendChild(formFieldInput);   
        
        document.getElementById('myForm').appendChild(formField); 
        
        //console.log(data[i].name);
      } 
      
    });
  </script>

<div class="col-md-8 col-md-offset-2">
  <h1 class="text-center"> Registrating for <a href=".">${event.name}</a> </h1>
  <hr class="soften">
</div>

<div class="col-md-6 col-md-offset-3 well">
  <form:form id="myForm" role="form">
    
  </form:form>
</div>