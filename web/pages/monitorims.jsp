<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>


<link href="<s:url value="css/style_monitorms.css"/>" media="all" rel="stylesheet" type="text/css"/> 

<!DOCTYPE html>
















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

        document.forma.ID_PROGRAMA.value = valor;
        document.forma.action = accion;
        document.forma.target = "_self";
        document.forma.submit();
    }

    //PARA REGRESAR EN DONDE SE QUEDO...........
    
   
</script>




<html>
    <body>

        <s:form value="forma" id="forma" enctype="multipart/form-data">

            <div class="div_img_mex"> <img src="img/edomex.png" alt="Gobierno del Estado de México"/></div>
            <h1 class="titulo_banner">Tablero de Control</h1>
            <h1 class="titulo_banner2">Secretaría de Educación</h1>
           <!-- <div class="div_logom" ><img src="img/logom.png" alt="Logo de identidad"/></div>-->
            <header id="main-header">

                <nav>

                </nav><!-- / nav -->

            </header><!-- / #main-header -->


            <section id="main-content">



                <div class="div_cont">
                    <aside>
                        
                        <div class="div-tipo-prog" id="inver_prog">Servicios relevantes en línea</div>
                        
                        
                         
                        
                        <a href="Javascript:guarda('inicio')"> <img src="img/home.png" alt="home" class="home"></img></a>
                        <div class="menu-prog">

                            <nav class="nav_botones">
                                <ul class="ul-boton" >
                                   
                                    <li><a href="#"><div class="div_ul_prog" style="color:  white; background: #666; border-radius: 20px 0px 20px 0px; box-shadow: 2px 4px 12px #666; " > Ingreso Media Superior</div></a></li>
                                        <li><a href="#"><div class="div_ul_prog"  >Formación Continua, Actualización y Desarrollo Profesional Docente (CEF DOCENTE)</div></a></li>
                                        <li><a href="#"><div class="div_ul_prog"  >Portal de la Secretaría de Educación</div></a></li>


                                </ul>
                            </nav>


                        </div>
                        <div class="div_color1"></div>
                        <div class="div_color2"></div>
                        <div class="div_color3"></div>
                        <div class="div_color4"></div>
                        <div class="div_color5"></div>
                        <div class="div_color6"></div>
                        <div class="div_color1"></div>
                        <div class="div_color2"></div>
                        <div class="div_color3"></div>

                    </aside>
                    
                   <!-- <img src="logosprog/<s:property value="cat.ID_PROGRAMA" />_LOGO.png"  class="img-logo-prog"> </img>-->

                    <div class="titulo-progras"><h3 style="margin-top: 15px;">Indicadores de visitas al sitio en tiempo real<br/>Ingreso Media Superior</h3> </div>

                  <!--  <div class="menu-botones">


                       <div class="div_bottones" id="alumno_prog"><div class="img-prog-ind"><img src="img/recursos.png" alt="home" ></img></div><div class="text-prog-ind"> Alumnos </div> <div class="text-prog-ind" id="letra17" > <s:property value="prog.NO_ALUMNOS"/></div></div>

                        <div class="div_bottones" id="escuela_prog"><div class="img-prog-ind" ><img src="img/escprog.png" alt="home" ></img></div><div class="text-prog-ind"> Escuelas </div> <div class="text-prog-ind" id="letra17"> <s:property value="prog.NO_ESC_PROG"/> </div></div>

                        <div class="div_bottones" id="municipio_prog"><div class="img-prog-ind"><img src="img/munprog.png" alt="home" ></img></div><div class="text-prog-ind"> Municipios </div> <div class="text-prog-ind" id="letra17"> <s:property value="prog.MUNICIPIOS"/> </div></div>

                       <div class="div_bottones" id="inver_prog"><div class="img-prog-ind"><img src="img/inverprog.png" alt="home" ></img></div><div class="text-prog-ind"> Inversión </div> <div class="text-prog-ind" id="letra17"> <s:property value="prog.INVERSION"/> </div></div>


                    </div> -->

                    <div class="contenedor-graf">


                        <!-- Inicia Articulo 1 --> 
                        <article class="article1">
                            <div class="div_sec1">


                                <p>
                                    <Strong>Objetivo:</Strong> Ofrecer acceso a escuelas y planteles, con una convocatoria  conjunta que permita un concurso de ingreso con equidad y transparencia.  Ofrece la posibilidad de solicitar ingreso simultáneo hasta en seis  opciones educativas diferentes generando mayores y mejores posibilidades  de acceso a este nivel educativo.<br><br><Strong>Alcance:</Strong> 122,438 alumnos de educación Media Superior.<br>

                                                </p>
                                               

                                                </div>

                                                <div class="div_sec1" style="height: 325px;">
                                                      <div class="titulo-progras"><h3>Visitas  en tiempo real<br/><a href="http://ingresoms.edugem.gob.mx/"  target="_blank">http://ingresoms.edugem.gob.mx/</a></h3></div>

                                                    
                                                   
                                                        <div id="graf_historia" style="margin: auto; width: 90%; height: 320px; margin-bottom: 20px;" >
                                                            
                                                            <div id="widgetIframe"><iframe width="100%" height="220" src="http://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&widget=1&moduleToWidgetize=Live&actionToWidgetize=getSimpleLastVisitCount&idSite=21&period=day&date=today&disableLink=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="no" frameborder="0" marginheight="0" marginwidth="0"></iframe></div>
                                                            <div class="anotacion-progras" style="margin-left: 2px; margin-top: -15px;"><h3>Muestra número de accesos en los últimos 3 minutos</h3></div>

                                                        
                                                        </div>
                                                   

                                                </div>



                                    <div class="div_sec1" style="height: 325px;">
                                    <div class="titulo-progras" ><h3>Mapa de accesos</h3></div>

                                                    <div id="" style="margin: auto; width: 90%; height: 250px; margin-bottom: 42px;" >
                                                            
                                                            <div id="widgetIframe"><iframe width="100%" height="220" src="http://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&widget=1&moduleToWidgetize=UserCountryMap&actionToWidgetize=realtimeMap&idSite=21&period=month&date=2018-06-05&disableLink=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="no" frameborder="0" marginheight="0" marginwidth="0"></iframe></div>
                                                            <div class="anotacion-progras" style="margin-left: 2px; margin-top: -12px;"><h3>Muestra los principales lugares de acceso</h3></div>

                                                    </div>
                                                    
                                                </div>
                                    
                                    
                                    
                                    
                                    
                                    
                                    <div class="div_sec1">
                                                        <div class="titulo-progras"><h3>Dispositivos utilizados para acceso</h3></div>
                                                        
                                                        
                                                        
                                                        
                                                            <div style="margin: auto; width: 90%; height: 580px; margin-bottom: 50px;" >
                                                                
                                                                    <div id="widgetIframe"><iframe width="100%" height="550" src="http://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&widget=1&moduleToWidgetize=DevicesDetection&actionToWidgetize=getType&idSite=21&period=month&date=2018-06-05&disableLink=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="no" frameborder="0" marginheight="0" marginwidth="0"></iframe></div>
                                                                  <div class="anotacion-progras" style="margin-left: 2px; margin-top: -5px;"><h3>Muestra el total acumulado de visitas realizadas clasificándolo dependiendo del tipo de dispositivo desde donde se realizó el acceso, desde que comenzó el programa.</h3></div>
                                                           </div>
                                                        

                                                    </div>
                                    
                                                 

                                                </article> 

                                                <article class="article2"> 
                                                    
                                                    
                                                 <div class="div_sec1">
                                                        <div class="titulo-progras" id="ajusta-region"><h3>Visitas por hora durante el día</h3></div>
                                                        
                                                        <div id="" style="margin: auto; width: 90%; height: 350px; margin-bottom: 42px;" >
                                                            
                                                            <div id="widgetIframe"><iframe width="100%" height="350" src="http://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&widget=1&moduleToWidgetize=VisitTime&actionToWidgetize=getVisitInformationPerLocalTime&idSite=21&period=day&date=today&disableLink=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="no" frameborder="0" marginheight="0" marginwidth="0"></iframe></div>
                                                             <div class="anotacion-progras" style="margin-left: 2px; margin-top: -5px;"><h3>Muestra el número total de accesos a la página por cada hora del día.</h3></div>
                                                        
                                                        </div>
                                                        
                                                        
                                                    </div>
                                                    
                                                    
                                                    <div class="div_sec1" style="height: 950px;">
                                                    <div class="titulo-progras"><h3>Total de visitas realizadas y tiempo promedio de respuesta</h3></div>
                                                    <div id="" style="margin: auto; width: 90%; height: 950px; margin-bottom: 42px;" >
                                                            
                                                        <div id="widgetIframe"><iframe width="100%" height="850" src="http://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&containerId=VisitOverviewWithGraph&widget=1&moduleToWidgetize=CoreHome&actionToWidgetize=renderWidgetContainer&idSite=21&period=month&date=2018-06-05&disableLink=1&widget=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="no" frameborder="0" marginheight="0" marginwidth="0"></iframe></div>
                                                        
                                                        
                                                        </div>
                                                    
                                                </div>
                                                    
                                                    
                                                    <div class="div_sec1" style="height: 400px;">
                                                    <div class="titulo-progras"><h3>Beneficiarios por Subsistema</h3></div>
                                                   
                                                        <div class="hoverflow-tab-mun">

                                                            <table id="customers">
                                                                <tr>
                                                                    <th>Subsistema</th>
                                                                    <th>Capacidad Total</th>
                                                                    <th>Asignados</th>
                                                                    <th>Ocupación</th>

                                                                </tr>
                                                               
                                                                   
                                                                
                                                                 <tr>
                                                                        <td>CBT</td>
                                                                        <td>20,955</td>
                                                                        <td>18,238</td>
                                                                        <td>87%</td>

                                                                    </tr>
                                                                <tr>
                                                                        <td>COBAEM</td>
                                                                        <td>19,610</td>
                                                                        <td>7,947</td>
                                                                        <td>41%</td>

                                                                    </tr>
                                                                 <tr>
                                                                        <td>CONALEP</td>
                                                                        <td>22,474</td>
                                                                        <td>3,932</td>
                                                                        <td>17%</td>

                                                                    </tr>
                                                                
                                                                  <tr>
                                                                        <td>CECYTEM</td>
                                                                        <td>6,275</td>
                                                                        <td>6,006</td>
                                                                        <td>96%</td>

                                                                    </tr>
                                                                 <tr>
                                                                        <td>DGB</td>
                                                                        <td>360</td>
                                                                        <td>378</td>
                                                                        <td>105%</td>

                                                                    </tr>
                                                                 <tr>
                                                                        <td>DGETI</td>
                                                                        <td>3,515</td>
                                                                        <td>3,357</td>
                                                                        <td>96%</td>

                                                                    </tr>
                                                                 <tr>
                                                                        <td>DGETA</td>
                                                                        <td>1,270</td>
                                                                        <td>410</td>
                                                                        <td>32%</td>

                                                                    </tr>
                                                                <tr>
                                                                        <td>EPOEM</td>
                                                                        <td>35,236</td>
                                                                        <td>31,229</td>
                                                                        <td>89%</td>

                                                                    </tr>

                                                                   <tr>
                                                                        <td>UAEMEX</td>
                                                                        <td>0</td>
                                                                        <td>0</td>
                                                                        <td>0%</td>

                                                                    </tr
                                                                     <tr>
                                                                        <td>TB COMUNITARIO</td>
                                                                        <td>12,743</td>
                                                                        <td>3,547</td>
                                                                        <td>28%</td>

                                                                    </tr>

                                                                    <tr style="background: green; color: white;">
                                                                        <td>TOTAL GENERAL</td>
                                                                        <td>122,438</td>
                                                                        <td>75,044</td>
                                                                        <td>61%</td>

                                                                    </tr>


                                                            </table>

                                                        </div>

                                                    
                                                    
                                                    
                                                </div>
                                                    
                                                   

                                                   
                                                </article> 







                                                </div>   
                                                




                                                <s:textfield name="cat.CICLOAUX" id="cat.CICLOAUX" style='visibility:hidden'/>
                                                <s:textfield name="cat.OPCION" id="OPCION" style='visibility:hidden'></s:textfield>
                                                <s:textfield name="cat.TIPO_PROGRAMA" id="TIPO_PROGRAMA"  style='visibility:hidden'></s:textfield>
                                                <s:textfield name="cat.ID_PROGRAMA" id="ID_PROGRAMA"  style='visibility:hidden'></s:textfield>








                                                <s:iterator value=" ListaMenuProg" id=" ListaMenuProg" status="stat">                        
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].ID" id="ID"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].ID_PROGRAMA" id=" ID_PROGRAMA"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].NOMBRE_PROGRAMA" id="NOMBRE_PROGRAMA"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].TIPO_PROGRAMA" id="TIPO_PROGRAMA"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].NO_ESC_PROG" id="NO_ESC_PROG"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].CICLO_ESCOLAR" id=" CICLO_ESCOLAR"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].MUNICIPIOS" id="MUNICIPIOS"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].INVERSION" id="INVERSION"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].NO_ESC_BASICA" id="NO_ESC_BASICA"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].NO_ESC_SEIEM" id="NO_ESC_SEIEM"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].NO_ALUMNOS" id="NO_ALUMNOS"></s:hidden>
                                                    <s:hidden  name = "ListaMenuProg[%{#stat.index}].CVENIV" id="CVENIV"></s:hidden>
                                                </s:iterator>


                                                <s:iterator value=" ListaIndicadoresProg" id=" ListaIndicadoresProg" status="stat">                        

                                                    <s:hidden  name = "ListaIndicadoresProg[%{#stat.index}].ID_PROGRAMA" id=" ID_PROGRAMA"></s:hidden>
                                                    <s:hidden  name = "ListaIndicadoresProg[%{#stat.index}].NO_ALUMNOS" id="NO_ALUMNOS"></s:hidden>
                                                    <s:hidden  name = "ListaIndicadoresProg[%{#stat.index}].NO_ESCUELAS" id=" NO_ESCUELAS"></s:hidden>
                                                    <s:hidden  name = "ListaIndicadoresProg[%{#stat.index}].NO_MUNIICIPIOS" id="NO_MUNIICIPIOS"></s:hidden>
                                                    <s:hidden  name = "ListaIndicadoresProg[%{#stat.index}].INVERSION" id="INVERSION"></s:hidden>
                                                    <s:hidden  name = "ListaIndicadoresProg[%{#stat.index}].CICLO_ESCOLAR" id="CICLO_ESCOLAR"></s:hidden>

                                                </s:iterator>


                                                <s:iterator value=" ListaDescripcionProg" id=" ListaDescripcionProg" status="stat">                        

                                                    <s:hidden  name = "ListaDescripcionProg[%{#stat.index}].OBJETIVO" id=" OBJETIVO"></s:hidden>
                                                    <s:hidden  name = "ListaDescripcionProg[%{#stat.index}].OBJETIVO_CORTO" id="OBJETIVO_CORTO"></s:hidden>
                                                    <s:hidden  name = "ListaDescripcionProg[%{#stat.index}].ALCANCE" id=" ALCANCE"></s:hidden>
                                                    <s:hidden  name = "ListaDescripcionProg[%{#stat.index}].ALCANCE_CORTO" id="ALCANCE_CORTO"></s:hidden>
                                                    <s:hidden  name = "ListaDescripcionProg[%{#stat.index}].PERIODO" id="PERIODO"></s:hidden>
                                                    <s:hidden  name = "ListaDescripcionProg[%{#stat.index}].MONTO_APOYO" id="MONTO_APOYO"></s:hidden>

                                                    <s:hidden  name = "ListaDescripcionProg[%{#stat.index}].DESCRIPCION_APOYO" id="DESCRIPCION_APOYO"></s:hidden>
                                                    <s:hidden  name = "ListaDescripcionProg[%{#stat.index}].NORMATIVIDAD" id="NORMATIVIDAD"></s:hidden>
                                                    <s:hidden  name = "ListaDescripcionProg[%{#stat.index}].CICLO_ESCOLAR" id="CICLO_ESCOLAR"></s:hidden>

                                                </s:iterator>
                                                <!-- /article -->



                                                <div class="modal-wrapper" id="popup">
                                                    <div class="popup-contenedor">
                                                        <h2  >Datos del Programa</h2>


                                                        <table id="customers" style="text-align: justify;">
                                                            <tr>
                                                                <th><s:property value="prog.NOMBRE_PROGRAMA"/></th>


                                                            </tr>
                                                            <tr>
                                                                <td><strong>Objetivo:</strong><s:property value="desprg.OBJETIVO"/></td>

                                                            </tr>
                                                            <tr>
                                                                <td><strong>Alcance:</strong><s:property value="desprg.ALCANCE"/></td>
                                                            </tr>

                                                            <tr>
                                                                <td><strong>Periodo:</strong><s:property value="desprg.PERIODO"/></td>
                                                            </tr>

                                                            <tr>
                                                                <td><strong>Monto de apoyo:</strong><s:property value="desprg.MONTO_APOYO"/></td>
                                                            </tr>

                                                            <tr>
                                                                <td><strong>Normatividad:</strong><s:property value="desprg.NORMATIVIDAD"/></td>
                                                            </tr>

                                                        </table>
                                                            
                                                        <a class="popup-cerrar" href="#">X</a>
                                                    </div>
                                                </div>

                                                </section> <!-- / #main-content -->

                                            </s:form>

                                                <div class="div-footer"> <h2 class="texto-footer" style="margin-top: 20px;">La información de este Tablero es de uso interno, para mas detalle favor de accesar a la página http://seduc.edomex.gob.mx/ <br>Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</h2> </div>

                                            </body>
                       </html>
