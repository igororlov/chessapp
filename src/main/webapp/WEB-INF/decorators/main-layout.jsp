<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Chess Event</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css"
        rel="stylesheet"  type="text/css" />
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"  type="text/css" />
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">  
</head>

<body>
    <div id="wrap">

        <c:import url="/WEB-INF/views/tags/navbar.jsp"/>

        <div class="container">
            <div class="row">
                <div class="col-md-2">
                  <div class="well sidebar-nav">
                    <c:import url="/WEB-INF/views/tags/menu.jsp"/>
                  </div>
                </div>

                <div class="col-md-10">
                    

                    <div class="row">
                      <div class="col-md-12">
                        
                        <decorator:body />

                      </div>
                    </div><!--/col-->
                </div><!--/row-->
            </div><!--/col-->
          </div><!--/row-->

          <hr class="soften">
    </div>

    <c:import url="/WEB-INF/views/tags/footer.jsp"/>

	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/demo.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/json2.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/date.format.js" />"></script>
</body>
</html>
