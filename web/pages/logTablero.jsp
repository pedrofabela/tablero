<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>


<link href="<s:url value="css/logTab.css"/>" media="all" rel="stylesheet" type="text/css"/> 

<!DOCTYPE html>







<script>
  
   
   var URLactual = window.location;
if(URLactual=="http://tablero.edugem.gob.mx/"){
    location.href ="https://tablero.edugem.gob.mx/";
}
</script>




<!-- Scripts de navegación de la aplicación -->

<script type="text/javascript">

    function guarda(accion) {

        document.forma.action = accion;
        document.forma.submit();
    }


    function nivel(accion, valor) {

        document.forma.OPCION.value = valor;
        document.forma.action = accion;
        document.forma.target = "_self";
        document.forma.submit();
    }

    function tipoProg(accion, valor) {

        document.forma.TIPO_PROGRAMA.value = valor;
        document.forma.action = accion;
        document.forma.target = "_self";
        document.forma.submit();
    }



    //PARA REGRESAR EN DONDE SE QUEDO...........


</script>




<html>
    <body>





        <div class="div_img_mex"> <img src="img/edomex.png" alt="Gobierno del Estado de México"/></div>
        <h1 class="titulo_banner">Tablero de Control</h1>
        <h1 class="titulo_banner2">Secretaría de Educación</h1>
        <!--   <div class="div_logom" ><img src="img/logom.png" alt="Logo de identidad"/></div>-->
        <header id="main-header">

            <nav>

            </nav><!-- / nav -->

            <label for="menu-toogle" class="menu-toogle"></label>
            <input type="checkbox" class="checkbox" id="menu-toogle" />










        </header><!-- / #main-header -->






        <s:form name="forma" action="verAcceso">
            <div class="div_login">
                <div class="div_login_camp">


                    <div class="div_cont_log">
                 <h7 clase="usuario_tam">Usuario:</h7>
                        <s:password name="cveusuario" id="cveusuario" cssClass="campo_login"   ></s:password>
                        </div>
                        <br/>
                        <br/>    
                    <%--<div class="div_cont_log" >                   
                        <h7 clase="usuario_tam">Password:</h7>
                            <s:password name="pasusuario" id="pasusuario" cssClass="campo_login" ></s:password>
                    </div>--%>


                    <a href="Javascript:guarda('verAcceso')">
                        <div class="div_boton_login">
                            <div style="text-align: center; padding: 20px; font-size: 25px;">  Ingresar</div>
                        </div>
                    </a>

                </div>
                <div class="mensaje-error" align="center">
                    <s:actionerror />
                    <s:fielderror />
                </div>    
            </div>
        </s:form>

        <!--<footer id="main-header">

            <nav>
                <div style="padding: 15px;">  <h2 class="titulo_banner3" style="margin-top: -5px;" >La información de este Tablero es de uso interno, para mas detalle favor de accesar a la página http://seduc.edomex.gob.mx/ <br> Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</h2></div>
            </nav><!-- / nav 

        </footer>-->


    </body>
</html>
