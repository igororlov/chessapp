<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<h1>Contacts</h1>

<hr class="soften">

<div class="row">
  <div class="col-md-4 ">
    <address>
        <strong>Stormester &amp Stormester</strong><br>
        Hans Burums Vei 30<br>
        1357 Bekkestua<br>
    </address>
     
    <address>
        <strong>Olga Dolzhykova</strong><br>
        <i class="fa fa-envelope-o"></i> <a href="mailto:olga@chess-destination.com">olga@chess-destination.com</a><br>
        <i class="fa fa-phone"></i> +47 988 55 900
    </address>

    <address>
        <strong>Simen Adgestein</strong><br>
        <i class="fa fa-envelope-o"></i> <a href="mailto:olga@chess-destination.com">simena@ntg.no</a><br>
        <i class="fa fa-phone"></i> +47 952 55 900
    </address>
  </div>
  
  <div class="col-md-3 col-md-offset-1">
    <div style="overflow:hidden;height:400px;width:400px;">
    <div id="gmap_canvas" style="height:400px;width:400px;">
    </div>
    <a href="http://www.embed-google-map.com">embed-google-map.com</a>
    </div>
  </div>
  
</div>  
  
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false">
</script>
<script type="text/javascript"> 
  function init_map(){
    var myOptions = {zoom:13,center:new google.maps.LatLng(59.9256164,10.591008699999975),mapTypeId: google.maps.MapTypeId.ROADMAP};
    map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);
    marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(59.9256164, 10.591008699999975)});
    infowindow = new google.maps.InfoWindow({content:'<div style="position:relative;line-height:1.34;overflow:hidden;white-space:nowrap;display:block;"><div style="margin-bottom:2px;font-weight:500;">NTG</div><span>Hans Burums Vei 30 <br> 1357 Oslo</span></div>' });
    google.maps.event.addListener(marker, "click", function(){infowindow.open(map,marker);});infowindow.open(map,marker);}
  google.maps.event.addDomListener(window, 'load', init_map);
</script>




 