
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuario"%>
<!DOCTYPE html>
<html>	
	<head> <title> Restaurante DOO </title>
 <style> 
            ul{
                display: block;
                margin: 0;
                padding: 0;   
            }
            ul li{
                float: left;
                display: block;
            }
            ul li ul{
                display: none;
            }
            ul li:hover ul{
                display: block;
                
            }
            ul li:hover ul li{
                float: none;
                
            }
            ul li a{
                text-decoration: none;
                background: gray;
                color: white;
                display: block;
                padding: 20px 90px 15px 90px;
                margin-top: 1px;
                margin-left: 1px;
                
            }
            ul li:hover a{
                background: blue;
            }
            h1{
                color: chartreuse;
                text-align: center;
            }
            h2{
                color: white;
            }
            p{
                color: white;
            }
            body{
		background-image: url("RTAT.jpg");
            }
           	
        </style>	
<center>	Restaurante DOO	 </center> </head>
<body>
    <%
        Usuario usuario = (Usuario) session.getAttribute("user");
        if(usuario != null){ 
%>            
     
<center>
<p>Usted entro en la p&aacute;gina oficial del restaurante DOO donde podra ordenar diferentes platillos que est&aacute;n disponibles en el siguiente men&uacute; con sus diferentes ingredientes y tiempo de espera.<br> Esperamos que nuestra comida sea de su agrado y nos recomiende para seguir creciendo :) </p>
<h3> Men&uacute; </h3>
<table>
<ul>
<li><a href="opcion1.html">Flautas</a></li>
<li><a href="opcion2.html">Enchiladas</a></li>
<li><a href="opcion3.html">Tacos</a></li>
<li><a href="opcion4.html">Gorditas</a></li>
<li><a href="opcion5.html">Tostadas a la Siberia</a></li>
<li><a href="opcion6.html">Burritos</a></li>
</ul>
<br> <br>
</table>
<br> <br><br> <br><br> <br>
<h1>
<%=usuario.getNombre()
%>
<%=usuario.getCorreo()
%>
</h1>
       
<%
        }else{
%>
    
    
    
<center>
<p>Usted entro en la p&aacute;gina oficial del restaurante DOO donde podra ordenar diferentes platillos que est&aacute;n disponibles en el siguiente men&uacute; con sus diferentes ingredientes y tiempo de espera.<br> Esperamos que nuestra comida sea de su agrado y nos recomiende para seguir creciendo :) </p>
<h3> Men&uacute; </h3>
<table>
<ul>
<li><a href="opcion1.html">Flautas</a></li>
<li><a href="opcion2.html">Enchiladas</a></li>
<li><a href="opcion3.html">Tacos</a></li>
<li><a href="opcion4.html">Gorditas</a></li>
<li><a href="opcion5.html">Tostadas a la Siberia</a></li>
<li><a href="opcion6.html">Burritos</a></li>
</ul>
<br> <br>
</table>

<table>
<ul>
<li><a href="LoginSer.html">Login</a></li>
<li><a href="Registro.html">Registrarse</a></li>
</ul>
<br> <br>
</table>
        <br><br><br><br><br><br><br><br><br><br><br><br><br>
        <%}%>
</center>
</body>
</html>

