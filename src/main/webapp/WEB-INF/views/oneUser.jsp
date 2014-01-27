<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>

<body>    
    <div class="container">
      <div class="row">
          <div class="col-xs-12 col-sm-6 col-md-9">
              <div class="well well-sm">
                  <div class="row">
                      <div class="col-sm-4 col-md-3">
                          <img src="http://placehold.it/380x500" alt="" class="img-rounded img-responsive" />
                      </div>
                      <div class="col-sm-6 col-md-8">
                          <h3>${userAccount.firstName} ${userAccount.lastName}</h3>
                          
                          <cite title="Oslo, Norway">Oslo, Norway <i class="fa fa-map-marker"></i>
                          </cite>
                          
                          <hr />
                          
                          <p>
                              <i class="fa fa-envelope-o"></i> ${userAccount.email} <br />
                              <i class="fa fa-phone"></i> ${userAccount.mobileNumber} <br />
                              <i class="fa fa-gift"></i> ${userAccount.birthDate} <br />
                          </p>
                        
                      </div>
                  </div>
              </div>
          </div>
      </div>
    </div>

</body>
</html>