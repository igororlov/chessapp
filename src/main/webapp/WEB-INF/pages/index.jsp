 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <html>
<head>
    
    <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.js"></script>
    <script src="<c:url value="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js" />"></script>
    <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" media="screen" />
    
    <script type="text/javascript">
        $(document).ready(function(){  
            $('#w-input-search').autocomplete({
                source: function (request, response) {
                    var request = 'requestString='+$('#w-input-search').val();
                    
                    $.getJSON('${pageContext.request.contextPath}/getTags', request, function(result) {
                        response($.map(result, function(item) {
                            return {
                                // following property gets displayed in drop down
                                label: item.tagName + "(" + item.id + ")",
                                // following property gets entered in the textbox
                                value: item.tagName
                            }
                        }));
                    });
                }
             }); // end autocomplete
            
            }); // end document.ready 
    </script>
</head>

<body>    
    <div>
        <input type="text" id="w-input-search" value="" data-provide="typeahead" autocomplete="on">
    </div>

</body>
</html>