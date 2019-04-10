<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>


<link href="<s:url value="css/style.css"/>" media="all" rel="stylesheet" type="text/css"/> 

<!DOCTYPE html>



 


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<!-- Gráfica de Programas Estatales -->
<script type="text/javascript">
    google.charts.load('current', {packages: ['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {

        var data = google.visualization.arrayToDataTable([
            ['Programas Estatales', 'Ciclo escolar:<s:property value="cat.CICLOAUX"/> ', {role: 'annotation'}],
    <s:iterator value="ListaProgEst" id="ListaProgEst" status="stat">

            ['<s:property value="NOMBRE_PROGRAMA"/> ', <s:property value="NO_ESC_PROG"/>, '<s:property value="NO_ESC_PROG"/> '],

    </s:iterator>


        ]);

        var options = {

             chartArea: {
                top: 0,
                height: '95%',
                width: '30%'

            },

            

            animation: {
                duration: 2500,
                startup: true //This is the new option
            },

            annotations: {
                textStyle: {

                    fontSize: 14,

                }
            },

            titleTextStyle: {
                color: '#A4A4A4',
                fontSize: 14,
                fontName: 'Arial'


            },

            'is3D': true,
            bar: {groupWidth: '95%'},
            legend: 'none',

            colors: ['#5ebfd9' ]
        };

        var chart = new google.visualization.BarChart(document.getElementById('estatales'));

        chart.draw(data, options);
    }

</script>


<!-- Gráfica de Programas Federales -->
<script type="text/javascript">
    google.charts.load('current', {packages: ['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {

        var data = google.visualization.arrayToDataTable([
            ['Programas Estatales', 'Escuelas Beneficiadas:', {role: 'annotation'}],
    <s:iterator value="ListaProgFed" id="ListaProgFed" status="stat">

            ['<s:property value="NOMBRE_PROGRAMA"/> ', <s:property value="NO_ESC_PROG"/>, '<s:property value="NO_ESC_PROG"/> '],

    </s:iterator>


        ]);

        var options = {
            
            
            animation: {
                duration: 2500,
                startup: true //This is the new option
            },

            annotations: {
                textStyle: {

                    fontSize: 14,

                }
            },
            chartArea: {
                top: 0,
                height: '95%',
                width: '30%'

            },

            titleTextStyle: {
                color: '#ffffff',
                fontSize: 14,
                fontName: 'Arial'


            },

            'is3D': true,
            bar: {groupWidth: '95%'},
            legend: 'none',

            colors: ['#5db774']
        };

        var chart = new google.visualization.BarChart(document.getElementById('federales'));

        chart.draw(data, options);
    }

</script>

<script>

function startTime() {
    var today = new Date();
    var hr = today.getHours();
    var min = today.getMinutes();
    var sec = today.getSeconds();
    ap = (hr < 12) ? "<span>am</span>" : "<span>pm</span>";
    hr = (hr == 0) ? 12 : hr;
    hr = (hr > 12) ? hr - 12 : hr;
    //Add a zero in front of numbers<10
    hr = checkTime(hr);
    min = checkTime(min);
    sec = checkTime(sec);
    document.getElementById("clock").innerHTML = hr + ":" + min + ":" + sec + " " + ap;
    
    var months = ['Enero', 'Febrero', 'Marzo', 'April', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
    var days = ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado'];
    var curWeekDay = days[today.getDay()];
    var curDay = today.getDate();
    var curMonth = months[today.getMonth()];
    var curYear = today.getFullYear();
    var date = curDay+" "+'de'+" "+curMonth;
    document.getElementById("date").innerHTML = date;
    
    var time = setTimeout(function(){ startTime() }, 500);
}
function checkTime(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
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
    
    function aMayusculas(obj,id){
    obj = obj.toUpperCase();
    document.getElementById(id).value = obj;
}

   
    //PARA REGRESAR EN DONDE SE QUEDO...........
   
   
</script>




<html>
    <body onload="startTime()">

        <s:form value="forma" id="forma" enctype="multipart/form-data">

            <div class="div_img_mex"> <img src="img/edomex.png" alt="Gobierno del Estado de México"/></div>
            <h1 class="titulo_banner">Tablero de Control</h1>
            <h1 class="titulo_banner2">Secretaría de Educación</h1>
            <div class="div_logom" ><img src="img/logom.png" alt="Logo de identidad"/></div>
            <header id="main-header">

                <nav>

                </nav><!-- / nav -->
                
               <label for="menu-toogle" class="menu-toogle"></label>
<input type="checkbox" class="checkbox" id="menu-toogle" />

<nav class="navmenu">
    <ul  style="display: block;" >




                            <s:iterator value="ListaBotones" id="ListaBotones" status="stat">


                            <a href= "Javascript:nivel('nivelcomunidad','<s:property value="ID_OPCION"/>')" style="font-size:40px; text-shadow: 2px 4px 12px black;" >    <div class="div-menu-cel"<s:if test="ID_OPCION==cat.OPCION">style="background: #a574bd;"</s:if>>  <li style="margin-top: 25px;" > <s:if test="ID_OPCION==cat.OPCION"></s:if>  <s:property value="VALOR"/></li></div></a>
                                   


                            </s:iterator>

                        </ul>
</nav>
                
                
                
                
                
                
                

            </header><!-- / #main-header -->


            <section id="main-content">
                <div class="menu-botones">

                    <nav class="nav_botones">
                        <ul class="ul-boton" >




                            <s:iterator value="ListaBotones" id="ListaBotones" status="stat">


                                <li ><a href= "Javascript:nivel('nivelcomunidad','<s:property value="ID_OPCION"/>')"><div class="div_bottones" <s:if test="ID_OPCION==cat.OPCION">style="background: #7F3390; "</s:if> >  <s:property value="VALOR"/></div></a></li>
                                    <s:hidden  name = "ListaBotones[%{#stat.index}].ID_OPCION" id="ID_OPCION"></s:hidden>
                                    <s:hidden  name = "ListaBotones[%{#stat.index}].VALOR" id="VALOR"></s:hidden>
                                    <s:hidden  name = "ListaBotones[%{#stat.index}].CICLO_ESCOLAR" id="CICLO_ESCOLAR"></s:hidden>


                            </s:iterator>

                        </ul>
                    </nav>


                </div>


                <div class="div_cont">

                    <!-- Inicia Articulo 1 --> 
                    <article  class="art1">

                        <!-- Inicia sección de Comunidad Educativa -->


                        <div class="div_sec1" style="border-right:  4px solid  color #782f88">
                            <div class="subtitulo-seccion" style="font-size: 11px; width: 200px; height: 50px; "><div style="width: 160px; height: 50px; background: #782f88; margin: auto; border-radius: 30px 5px 34px 30px; box-shadow: 5px 5px 15px #333;" ><h2 style="margin-top: 0px; padding: 10px; color: white"><s:property value="cat.OPCION_NOMBRE"/> </h2></div></div>  
                            <img  class="position-img-etiqueta"  src="img/comunidad.png" alt="Comunidad Educativa" />


                            <div class="div-totales-position">

                                <div class="div_img_contenedor_matricula"> <a href="http://tablerow.edugem.gob.mx/tablero/comunidad-alumnos.html"><img src="img/alumnos.png" class="position-logo-totales"></img> <h7 class="totales-tit"> Alumnos </h7><br></img> <h7 class="totales-cantidad" style="color:black;"> <s:property value="comedu.TOTALALUMAT"/></h7>  <img src="img/manogral.png" style="width: 20px; float: right; margin-top: -30px; margin-right: -10px;"></img> </div> </a> 
                                <div class="div_img_contenedor_matricula"><a href="http://tablerow.edugem.gob.mx/tablero/comunidad-docentes.html"><img src="img/docentes.png"  class="position-logo-totales"></img> <h7 class="totales-tit">Docentes</h7><br></img> <h7 class="totales-cantidad" style="color:black;"><s:property value="comedu.TOTALDOCENTE"/></h7> <img src="img/manogral.png" style="width: 20px; float: right; margin-top: -30px; margin-right: -10px;"></img></div></a> 
                                 <div class="div_img_contenedor_matricula"><a href="http://tablerow.edugem.gob.mx/tablero/comunidad-escuelas.html"><img src="img/escuelas.png" class="position-logo-totales"></img>  <h7 class="totales-tit">Escuelas</h7><br></img><h7 class="totales-cantidad" style="color:black;"><s:property value="comedu.TOTALESCU"/></h7><img src="img/manogral.png" style="width: 20px; float: right; margin-top: -30px; margin-right: -10px;"></img></div></a>  

                            </div>


                            <div class="div-esc-pub-priv">
                                <div class="div-totales-priv-pub">
                                    <img src="img/publicas.png" alt="Públicas" ><h7 class="totales-tit" style="color:black;">Públicas:</h7> <h7 class="totales-cantidad"> &nbsp;&nbsp;  &nbsp;<strong><s:property value="comedu.TOTALESCPUB"/></strong></h7></img>
                                </div>
                                <div class="div-totales-priv-pub">
                                    <img src="img/privada.png" alt="Privadas"><h7 class="totales-tit" style="color:black;">Privadas:</h7><h7 class="totales-cantidad" > &nbsp; &nbsp;<strong><s:property value="comedu.TOTALESCPRIV"/></strong></h7></img>
                                </div>
                            </div>
                            <div>
                                <h1 class="fuente"><h7 class="totales-tit2" style="line-height: 1;">Fuente:Consolidado Estadístico de Inicio de cursos 2017-2018 (Dirección de Información y Planeación). </h7></h1>
                            </div> 



                        </div>

                        <!-- Termina sección de Comunidad Educativa-->

                        <!-- Sección de programas y apoyos -->

                        <div class="div_sec1" style=" border-right:  4px solid #d81f25">
 
                          
                           
                            <img  class="position-img-etiqueta"  src="img/servicios.png" alt="Comunidad Educativa" />
                            <a href="Javascript:guarda('serlinea')"  >   <div class="titulo_est_fed" style=" border: 1px solid #a56505 ; margin-top: -30px; margin-left: 35px;">  <img src="img/enlinea.png" class="position-logotit" style="position: absolute;  z-index: 1;  width: 40px; "></img><h8 style="margin-left: 60px;">Otros Servicios</h8> <img src="img/manogral.png" style="width: 20px; float: right; margin-top: 5px; margin-right: -10px;"></img> </div></a>
                           <!-- <div style="margin-left: 50px; text-align: left; position: absolute; margin-top: -20px;"><h4>En construcción...</h4></div>-->
                            
                             <div style="margin: auto; width: 100%; text-align: center; height: 20px; margin-top: 45px; margin-bottom: -45px; text-shadow: 5px 5px 10px #666;"> <s:property value="serlinea.NOMBRE_SISTEMA"/></div>
                             <div style="margin: auto; width: 100%; text-align: center; height: 15px; margin-top: 45px; margin-bottom: -50px;"> (<s:property value="serlinea.VIGENCIA"/>)</div>
                             <a href="Javascript:guarda('serlinea')"  > 
                             <div style="width: 430px; height: 250px; background: #eeeeef; border: 2px solid #f39c3b; margin: auto; margin-top: 10px; border-radius: 15px;">

                                 <div id="clockdate" style="float: right; font-size: 12px; text-align: center; margin-right: 22px; color: #496e82;  font-weight:bold; position: relative; margin-top: 20px;">
                                     <div class="clockdate-wrapper">
                                         <div id="date" style="height: 13px;"></div>
                                        <div id="clock"></div>
                                         
                                     </div>
                                     
                                    
                                     
                                     
                                     
                                     
                                 </div>
                                 
                                  
                                 <table  style="margin-top: 45px; width: 400px; height: 150px;">
                                         <tr>
                                             <td align="center" style="height: 10px;"><h4 style="position: absolute; margin-top: 27px; margin-left: 35px; "><s:property value="serlinea.IMPACTO_SOCIEDAD"/></h4><img src="img/compu.png" style="width: 100px;"></img><img src="img/manogral.png" style="width: 20px; position: absolute; margin-left: -20px; margin-top: 60px;"></img></td>
                                             <td align="center" style="height: 70px;  width: 70%; margin: auto; color: white;"><img src="img/alumnos.png" style="position: absolute; margin-left: -110px; margin-top: 10px;"></img><div style="width: 70%; height: 70px; background: purple; border-radius: 10px;"> <div style="width: 100%; display: block; padding: 5px;">Total de Aspirantes</div><div style="width: 100%; display: block; font-size: 26px;"><s:property value="cat.TOTAL_ASPIRANTES"></s:property></div></div></td>

                                             <!-- <td align="center" style="height: 80px;"><h4 style="position: absolute; margin-top: 40px; margin-left: 77px; font-size: 20px; color: white;"><s:property value="serlinea.PORCENTAJE_AVANCE"/>%</h4><img src="img/porcentaje.png" style="width: 80px; margin-top: 12px;"></img></td>-->
                                         </tr>
                                         <tr>
                                             <td align="center" style="height: 10px;"><h4 style="font-size: 13px; color:#16195c;">Impacto en la Sociedad</h4></td>
                                             <td align="center" style="height: 70px;  width: 70%; margin: auto;">    <div style="width: 34%; height: 70px; border: 2px solid green; border-radius: 10px; display: inline-block;margin-right: 2%;">         <div style="width: 100%; display: block; font-size: 12px; line-height: 1; margin-top: 10px;">Aspirantes con validación digital</div>      <div style="width: 100%; display: block; font-size: 20px; margin-top: 5px; color: green;"><s:property value="cat.TOTAL_VALIDADOS"></s:property></div>                          </div>                <div style="width: 34%; height: 70px; border: 2px solid orangered; border-radius: 10px; display: inline-block;">      <div style="width: 100%; display: block; font-size: 12px; line-height: 1; margin-top: 10px;">Aspirantes sin validación digital</div>     <div style="width: 100%; display: block; font-size: 18px; margin-top: 5px; color: orangered;"><s:property value="cat.TOTAL_NOVALIDADOS"></s:property></div>       </div></td>
                                          <!--   <td align="center" style="height: 10px;"><h4 style="font-size: 13px; color:#16195c;">% de avance del servicio</h4></td>-->
                                         </tr>
                                        
                                       
                                     </table>
                                 
                                             <div><h4 style="font-size: 12px; position: absolute; margin-top: 0px; margin-left: 8px; color: #666;">Nota: <s:property value="serlinea.NOTA"/></h4></div>
                             </div>
                             </a>
                            
                            <br></br>
                       

                            <div >
                                <h1 class="fuente"><h7 class="totales-tit2">Fuente: Sistemas UDAI y Plataforma IMS </h7></h1>
                            </div>



                        </div>
                                                                    
                              
                                                                    
                                                                    
                                                                    
            <!-- Regiones no mover -->                                  
                         
                        <div class="div_sec1" style=" border-right:  4px solid #d81f25">
                          
                           
                            <img  class="position-img-etiqueta"  src="img/gabinete.png" alt="Comunidad Educativa" />
                            <a href="Javascript:guarda('Regio')" >   <div class="titulo_est_fed" style=" border: 1px solid #d81f25 ; margin-top: -40px; margin-left: 35px;">  <img src="img/icoregion.png" class="position-logotit" style="position: absolute;  z-index: 1;  width: 40px; "></img><h8 style="margin-left: 60px;">20 Regiones</h8> <img src="img/manogral.png" style="width: 20px; float: right; margin-top: 5px; margin-right: -10px;"></img> </div></a>
                             
                            
                             <div style="margin: auto; width: 100%; text-align: center; height: 20px; margin-top: 40px; margin-bottom: -40px;"> Región XVII - Toluca</div>
                            
                             
                             <table id="customers" style="margin-top: 60px; margin-bottom: 25px;">
                                <tr class="borde-tabla-booton"  >
                                                                    
                                                             <th >Municipio</th>
                                                                    <th>Alumnos</th>
                                                                     <th>Docentes</th>
                                                                     
                                                                    <th>Escuelas</th>

                                                                </tr>
                                                               
                                
                                                                <s:iterator value="ListaRegioMun" id="ListaRegioMun" status="stat">
                                                                <tr>
                                                                    <td><s:property value="MUNICIPIO"/></td>
                                                                        <td><s:property value="MATRICULA"/></td>
                                                                        <td><s:property value="NO_DOCENTES"/></td>
                                                                        <td><s:property value="NO_ESCUELAS"/></td>
                                                                    </tr>
                                                                
                                                                  </s:iterator>  
                                                                
                                                                 <tr >
                                                                       <td>Total General</td>
                                                                        <td><s:property value="regioB.TOTALREGMATRICULA" /></td>
                                                                        <td><s:property value="regioB.TOTALREGDOCENTES" /></td>
                                                                        <td><s:property value="regioB.TOTALREGESCUELAS" /></td>
                                                                    </tr>

                                                            </table>
                            
                           
                            <!--<div class="div-region-inicial">
                                <img src="img/icoregion.png" style="position: absolute;  z-index: 1; margin-left: 55px;"></img>
                              <a href="http://tablerow.edugem.gob.mx/tablero/gabinete-toluca.html">
                               <a href="Javascript:guarda('Regio')" > 
                                <div class="div-booton-20" >
                                    <h7 class="totales-cantidad" style="text-align: center; text-decoration: none; "> <strong >20 Regiones</strong></h7>
                                   <img src="img/manogral.png" style="width: 40px; float: right; margin-right: -30px"></img>
                                </div>
                                </a>
                                
                            </div>-->
                            
                            <br></br>

                           <div>
                                <h1 class="fuente"><h7 class="totales-tit2">Fuente:    Estadístico 911 (Dirección de Información y Planeación) </h7></h1>
                            </div>



                        </div>                                           
                                                                    

                        <!-- Termina Sección de Programas y Apoyos -->



                        <div class="div_sec1" style=" border-right:  4px solid #f89c20" >
                           <!-- <div class="subtitulo-seccion"><h2 style="font-size: 16px ;color: #484848;"> En construcción...</h2></div>-->

                            <img  class="position-img-etiqueta"  src="img/geolocaliza.png" alt="GeoLocalizacion" />
                            <div class="titulo_Mapa" style="margin-top: 20px;" ><h8>Ubicación de escuelas por nivel: <s:property value="ACTIVcat.NOMNIVEL"/></h8></div>
                            
                           <s:select    name="cat.CLAVE_MUNICIPIO" id="cat.CLAVE_MUNICIPIO" list="ListaCatMun"  listKey="CLAVE_MUNICIPIO"  listValue="MUNICIPIO"  headerKey="" headerValue="SELECCIONA UN MUNICIPIO" cssStyle="max-width: 90%; min-width:94%; margin:auto; margin-bottom: 15px; border-radius:15px; margin-left:10px; height:25px;" onchange="Javascript:guarda('municipioMapa')"  /><img src="img/manogral.png" style="width: 20px; float: right; margin-top: 5px; margin-right: 0px;"></img>
                        <table style="width:90%; margin: auto; text-align: justify; font-size: 14px;  ">
                                <tr>                              
                                    <td style="width: 15px;"><div style="height: 6px; width: 6px; background: #00a19a; border-radius: 50%;"></div></td>
                                   <td>Preescolar</td>
                                   <td style="text-align: left; width: 30px;"><s:property value="regioB.PREESCOLAR"/></td>
                                   <td style="text-align: left; width: 30px;"></td>
                                   <td style="width: 15px;"><div style="height: 6px; width: 6px; background: #f89c20; border-radius: 50%;"></div></td>            
                                   <td>Media Superior</td>
                                    <td style="text-align: left; width: 40px;"><s:property value="regioB.MEDIA_SUPERIOR"/></td>
                                </tr>                                     
                               <tr>                              

                                   <td style="width: 15px;"><div style="height: 6px; width: 6px; background: #7f3390; border-radius: 50%;"></div></td>
                                   <td>Primaria</td>
                                     <td style="text-align: left; width: 30px;"><s:property value="regioB.PRIMARIA"/></td>
                                  <td style="text-align: left; width: 30px;"></td>
                                  <td style="width: 15px;"><div style="height: 6px; width: 6px; background: #76983f; border-radius: 50%;"></div></td>                  
                                   <td>Superior</td>
                                     <td style="text-align: left; width: 30px;"><s:property value="regioB.SUPERIOR"/></td>
                                </tr>
                               <tr>                              
                                   <td style="width: 15px;"><div style="height: 6px; width: 6px; background: #961c20; border-radius: 50%;"></div></td>
                                   <td>Secundaria</td>
                                   <td style="text-align: left; width: 30px;"><s:property value="regioB.SECUNDARIA"/></td>
                                     <td style="text-align: left; width: 30px;"></td>
                                   <td style="width: 15px;"><div style="height: 6px; width: 6px; background: black; border-radius: 50%;"></div></td>                     
                                   <td>Otros</td>
                                    <td style="text-align: left; width: 30px;"><s:property value="regioB.OTRO"/></td>
                                </tr>
                                
                                                              

                                                            </table>
                                    <div style="widows: 90%; height: 30px; margin: auto; margin-top: 10px; text-align: center; font-size: 14px; ">Total de Escuelas: <s:property value="regioB.TOTAL_ESCUELAS_NIV"/></div>


                            <div  class="mapa"  >
                                
                                <img src="img/mapa2.png" style="width: 100%; border-radius: 20px;"></img>
                                
                            </div>
                           
                           
                          
                           
                           
                           
                             <div>
                                <h1 class="fuente"><h7 class="totales-tit2" style="margin-top: 1px;">Fuente:Dirección de Información y Planeación (2017)</h7></h1>
                            </div> 


                        </div>

                        <!-- Termina Articulo 1 -->      



                        <!-- Inicia Articulo 2 -->

                    </article> <!-- /article -->







                    <article class="art2">


                        <s:if test="cat.OPCION<=0">

                        <div class="div_sec1" id="sec2" style=" border-right:  4px solid #0ea2dc" >
                        <!-- <div class="subtitulo-seccion"><h2>Del Sector</h2></div>-->
                           <img  class="position-img-etiqueta"  src="img/indica.png" alt="Comunidad Educativa" />
                           <a href="http://tablerow.edugem.gob.mx/tablero/indicadores-2.html">    <div class="titulo_est_fed" style=" border: 1px solid #0ea2dc ; margin-top: -40px; margin-left: 35px;"><h8>Del Sector</h8> <img src="img/SEC.png" class="position-logotit"  style="width: 40px;"></img>  <img src="img/manogral.png" style="width: 20px; float: right;  margin-top: 5px;"></img>  </div></a>
                            
                         <div style="margin-top: 40px; width: 500px; ">
                         
                       <div class="div-contenedor-bottones-animados">
                          
                             <div class="div-marea">
                          <div class="div-marea-texto" <s:if test="cat.ANAPRICIPAL_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.ANAPRICIPAL"/>%</div>
                           <div class="preloader"></div> 
                          
                           </div>
                             
                             <div class="div-marea">
                                 <div class="div-marea-texto" <s:if test="cat.ESCOLARIDADPRICIPAL_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.ESCOLARIDADPRICIPAL"/></div>
                          <div class="preloader2" ></div> 
                          
                          
                          </div>
                             
                            
                             
                         </div>
                      
                         <div class="div-contenedor-bottones-animados">
                                 
                                 <div style="width: 40%; line-height: 1; text-align: center; margin-right: 15px; float: right;  margin-left: 15px;"><h7 class="totales-tit" id="letra_cambio">Grado promedio de escolaridad</h7></div> 
                                 <div style="width: 40%; line-height: 1;  text-align: center;  margin-left: 25px;"><h7 class="totales-tit" id="letra_cambio">Analfabetismo</h7> </div> 
                                 
                             </div>  
                          
                                  <div style="width: 190px; height: 150px;  float: right;  margin-top: -163px;"><div style="height: 20px; width: 80px; text-align: center; float: right; margin-top: 30px; position: absolute; margin-left: 105px; color: red; "> <s:property value="cat.LCPRINCIPAL"/>%</div><a href="http://tablerow.edugem.gob.mx/tablero/planea.html" ><img src="img/logo_eva.png" ></a> <div style="height: 20px; width: 80px; text-align: center; float: right; margin-top: -35px; position: absolute; margin-left: 105px; color: red; ">  <s:property value="cat.MATPRINCIPAL"/>%  </div></img></div>
                             
                             <a href="http://tablerow.edugem.gob.mx/tablero/indicadores.html"> <div class="titulo_est_fed" style=" border: 1px solid #ffcc01 ; margin-top: -10px; margin-left: 35px; margin-bottom: 50px; width: 65%;"><h8 style="margin-left: 55px;">Cobertura por nivel Educativo</h8><img src="img/SEC2.png" class="position-logotit" style="width: 40px;"></img>  <img src="img/manogral.png" style="width: 20px; float: right; margin-top: 5px;"></img></div>   </a> 
                             
                             
                             
                             <div class="div-contenedor-bottones-animados" style="width:100%;">
                          
                             <div class="div-marea">
                                 <div class="div-marea-texto" <s:if test="cat.BASICAPRINCIPAL_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.BASICAPRINCIPAL"/>%</div>
                           <div class="preloader3"></div> 
                          
                           </div>
                             
                             <div class="div-marea">
                          <div class="div-marea-texto"<s:if test="cat.BASICAMSUPERIOR_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.BASICAMSUPERIOR"/>%</div>
                          <div class="preloader4" ></div> 
                          
                          
                          </div>
                             
                             <div class="div-marea">
                          <div class="div-marea-texto" <s:if test="cat.BASICASUPERIOR_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.BASICASUPERIOR"/>%</div>
                          <div class="preloader5" ></div> 
                          
                          
                          </div>
                             
                         </div>
                      
                             <div class="div-contenedor-bottones-animados" style="width: 100%;  max-height: 50px;">
                                 <div style="width: 30%; display: inline-block;  text-align: center;  margin-left: 5px;"><h7 class="totales-tit" id="letra_cambio">Básica</h7> </div> 
                                 <div style="width: 30%; display: inline-block; text-align: center;  margin-left: 5px;"><h7 class="totales-tit" id="letra_cambio">Media Superior</h7></div> 
                                 
                                 <div style="width: 30%; display: inline-block;  text-align: center;  margin-left: -10px;"><h7 class="totales-tit" id="letra_cambio">Superior</h7></div> 

                             </div>  
                          
                                <div style="margin-left: 20px; "><div style="width: 5px; height: 5px; background: green; display: inline-block; margin-left: 5px;"></div><h7 class="totales-tit" style="display: inline-block;" id="letra_cambio">Por encima de la media Nacional</h7> </div>
                             <div style="margin-left: 20px; "><div style="width: 5px; height: 5px; background: red; display: inline-block; margin-left: 5px;"></div><h7 class="totales-tit" style="display: inline-block;" id="letra_cambio"> Por de bajo de la media Nacional</h7> </div>
                          <br>
                          
                          <h1 class="fuente"><h7 class="totales-tit2" style="line-height: 1;">Fuente:Sistema Nacional de Información Estadística Educativa Ciclo Escolar: 2016-2017</h7></h1>
                         </div>
                        
                         
                         
                         
                           
                         <!--    <img src="img/const_indicadores.png" style="border-radius: 50px;"></img> 
                            <div id="preloader6">
                                   <span></span>
                                   <span></span>
                                   <span></span>
                                   <span<></span>
                               </div> -->

                            <!-- <h2 style="text-align: center; font-size: 18px; color: #333;  text-shadow: 2px 5px 15px #333;"> En Construcción... </h2>-->


                        </div>
                        
                        </s:if>
                        
                        
                        <s:if test="cat.OPCION>0">
                        
                        <div class="div_sec1" id="sec2" style=" border-right:  4px solid #0ea2dc" >
                        <!-- <div class="subtitulo-seccion"><h2>Del Sector</h2></div>-->
                           <img  class="position-img-etiqueta"  src="img/indica.png" alt="Comunidad Educativa" />
                             <a href="http://tablerow.edugem.gob.mx/tablero/indicadores.html"> <div class="titulo_est_fed" style=" border: 1px solid #ffcc01 ; margin-top: -10px; margin-left: 35px; margin-bottom: 50px; width: 55%;"><h8 style="margin-left: 55px;">Cobertura por nivel Educativo</h8><img src="img/SEC2.png" class="position-logotit" style="width: 40px;"></img>  <img src="img/manogral.png" style="width: 20px; float: right; margin-top: 5px;"></img></div>   </a> 
                            
                         <div style="margin-top: 40px; width: 500px; ">
                         
                       
                      
                         
                          
                        
                             
                             
                             
                             
                             <div class="div-contenedor-bottones-animados" style="width:100%;">
                          
                             <div class="div-marea">
                                 <div class="div-marea-texto"<s:if test="cat.COBERTURA_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.COBERTURA"/>%</div>
                           <div class="preloader"></div> 
                          
                           </div>
                             
                             <div class="div-marea">
                          <div class="div-marea-texto" <s:if test="cat.REPROBACION_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.REPROBACION"/>%</div>
                          <div class="preloader2" ></div> 
                          
                          
                          </div>
                             
                             <div class="div-marea">
                                 <div class="div-marea-texto" <s:if test="cat.ABANDONO_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.ABANDONO"/>%</div>
                          <div class="preloader3" ></div> 
                          
                          
                          </div>
                             
                         </div>
                      
                             <div class="div-contenedor-bottones-animados" style="width: 100%;  max-height: 50px;">
                                 <div style="width: 30%; display: inline-block;  text-align: center;  margin-left: 5px;"><h7 class="totales-tit" id="letra_cambio">Cobertura</h7> </div> 
                                 <div style="width: 30%; display: inline-block; text-align: center;  margin-left: 5px;"><h7 class="totales-tit" id="letra_cambio">Reprobación</h7></div> 
                                 
                                 <div style="width: 30%; display: inline-block;  text-align: center;  margin-left: -10px;"><h7 class="totales-tit" id="letra_cambio" style="line-height: 0.4;" >Abandono   <br></br>   (Deserción)</h7></div> 

                             </div>  
                             
                             
                             
                             <div class="div-contenedor-bottones-animados" style="width:100%;">
                          
                             <div class="div-marea">
                                 <div class="div-marea-texto" <s:if test="cat.ABSORCION_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.ABSORCION"/>%</div>
                           <div class="preloader3"></div> 
                          
                           </div>
                             
                             <div class="div-marea">
                          <div class="div-marea-texto" <s:if test="cat.EFICIENCIAT_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.EFICIENCIAT"/>%</div>
                          <div class="preloader4" ></div> 
                          
                          
                          </div>
                             
                             <div class="div-marea">
                          <div class="div-marea-texto" <s:if test="cat.TAZA_COLOR=='VERDE'"> style="color:green;"</s:if> <s:else>style="color:red;"</s:else>><s:property value="cat.TAZA"/>%</div>
                          <div class="preloader5" ></div> 
                          
                          
                          </div>
                             
                         </div>
                      
                             <div class="div-contenedor-bottones-animados" style="width: 100%;  max-height: 50px;">
                                 <div style="width: 30%; display: inline-block;  text-align: center;  margin-left: 5px;"><h7 class="totales-tit" id="letra_cambio">Absorción</h7> </div> 
                                 <div style="width: 30%; display: inline-block; text-align: center;  margin-left: 5px;"><h7 class="totales-tit" id="letra_cambio">Eficiencia Terminal</h7></div> 
                                 
                                 <div style="width: 30%; display: inline-block;  text-align: center;  margin-left: -10px;"><h7 class="totales-tit" id="letra_cambio" style="line-height: 1;">Tasa neta de Escolarización</h7></div> 

                             </div>  
                          
                             
                             
                             
                          
                                <div style="margin-left: 20px; "><div style="width: 5px; height: 5px; background: green; display: inline-block; margin-left: 5px;"></div><h7 class="totales-tit" style="display: inline-block;" id="letra_cambio">Por encima de la media Nacional</h7> </div>
                             <div style="margin-left: 20px; "><div style="width: 5px; height: 5px; background: red; display: inline-block; margin-left: 5px;"></div><h7 class="totales-tit" style="display: inline-block;" id="letra_cambio"> Por de bajo de la media Nacional</h7> </div>
                          <br>
                          
                          <h1 class="fuente"><h7 class="totales-tit2" style="line-height: 1;">Fuente:Sistema Nacional de Información Estadística Educativa Ciclo Escolar: 2016-2017</h7></h1>
                         </div>
                        
                             
                             
                             
                         
                               
                         
                         
                           
                         <!--    <img src="img/const_indicadores.png" style="border-radius: 50px;"></img> 
                            <div id="preloader6">
                                   <span></span>
                                   <span></span>
                                   <span></span>
                                   <span<></span>
                               </div> -->

                            <!-- <h2 style="text-align: center; font-size: 18px; color: #333;  text-shadow: 2px 5px 15px #333;"> En Construcción... </h2>-->


                        </div>
                        
                        </s:if>
                        
                        
                        
                        
                        
                        
                        

                        <div class="div_sec1" style=" border-right:  4px solid #94c740">
                            <div class="subtitulo-seccion"><h2>Programas Vigentes 2018 Cantidad de escuelas
                                </h2></div>
                            <img  class="position-img-etiqueta"  src="img/progapoyo.png" alt="Comunidad Educativa" />
                            
                               <div  class="fondo_busqueda" style=" width: 280px; height: 70px; position: absolute; margin-left: 100px; font-size: 13px; margin-top: 20px; border-radius: 15px; ">  <s:textfield name="busquedaCCT.BUSCAR_CCT" id="BUSCAR_CCT" placeholder="Escribe una CCT" cssStyle="margin-left: 20px; margin-top:20px; border-radius: 15px; height: 30px; font-size: 14px;  text-align:center; text-transform:uppercase;" onblur="aMayusculas(this.value,this.id)"></s:textfield><div style="   border-radius: 8px; height: 30px; width: 30px; position: absolute; margin-left: 200px; margin-top: -27px;"><a href="Javascript:guarda('busquedaCCTInicio')"> <img src="img/buscarEscuela.png" style="position: absolute; width: 40px; margin-top: -15px;" ></img><img src="img/manogral.png" style="width: 20px; margin-left: 30px; position: absolute; margin-top: 20px;"></img></a></div></div>
                                <s:if test="errorFormato">
                            
                            <div style="width: 100%;  text-align: center; margin-top: 70px; position: absolute;">
                                <h7 style="text-align: center; color: gray; font-size: 12px; margin-left: -50px; " >Formato no valido</h7>
                            </div> 
                            
                            </s:if>
                            
                             <s:if test="errorNoEncontrado">
                            
                            <div style="width: 100%;  text-align: center; margin-top: 70px; position: absolute;">
                                <h7 style="text-align: center; color: gray; font-size: 12px; margin-left: -50px; " >No hay información de la CCT</h7>
                            </div> 
                            
                            </s:if>

                            <!-- Gráfica de Programas Estatales -->

                            <a href="Javascript:tipoProg('menuProgyApoyo','E')"> <div class="titulo_est_fed" style=" border: 1px solid #0ea2dc ; margin-bottom: 20px; margin-top: 110px;"><h8>Estatales</h8> <img src="img/logoEst.png" class="position-logotit" ></img> <img src="img/manogral.png" style="width: 20px; float: right; margin-top: 5px;"></img></div></a>

                            <s:if test="ListaProgEst.size()>0">

                                <div id="estatales"  class="graf-prog-propiedades"  ></div> 
                            </s:if>
                            <s:else>
                                <div  class="mensaje-error" >¡No hay datos que mostrar!</div> 
                            </s:else>

                            <!-- Gráfica de Programas Federales  -->

                            <a href="Javascript:tipoProg('menuProgyApoyo','F')">  <div class="titulo_est_fed" style=" border: 1px solid #94c740 ; margin-bottom: 20px;"> <h8>Federales</h8><img src="img/logofed.png" class="position-logotit" ></img> <img src="img/manogral.png" style="width: 20px; float: right; margin-top: 5px;"></img></div></a>
                                        <s:if test="ListaProgFed.size()>0">

                                <div id="federales"  class="graf-prog-propiedades" ></div> 
                            </s:if>
                            <s:else>
                                <div  class="mensaje-error" >¡No hay datos que mostrar!</div> 
                            </s:else>
                                
                                

                            <a href="Javascript:tipoProg('menuProgyApoyo','C')">   <img src="img/concluidos2.png " alt="Concluidos" style="margin-left: 35px;"></img></a>
                            
                            
                           
                           
                            <div>
                                <h1 class="fuente" ><h7 class="totales-tit2" ><a href="Javascript:guarda('monitorIms')">Fuente:Niveles Educativos (Abril 2018)</a></h7></h1>
                            </div> 
                        
                        
                        </div>
                          
                        <!-- <div class="div_sec1" style=" border-right:  4px solid #94c740">
                                <a href="Javascript:guarda('monitorIms')"><img src="img/monitor.png " alt="monitor" style="margin-left: 35px;"></img></a>
                            </div> -->



                    </article> <!-- /article -->

                </div>

                <s:if test="mensajeerror">

                    <div id='ventana-flotante'>

                        <a class='cerrar' href='javascript:void(0);' onclick='document.getElementById(&apos;ventana-flotante&apos;).className=&apos;oculto&apos;'>x</a>

                        <div id='contenedor'>

                            <div class='contenido'>

                                ¡Favor de elegir un Nivel Educativo!.

                            </div>

                        </div>

                    </div>
                </s:if>



                            <s:iterator value="ListaRegioMun" id="ListaRegioMun" status="stat">
      
                                <s:hidden  name = "ListaRegioMun[%{#stat.index}].MUNICIPIO" id="MUNICIPIO"></s:hidden>

                                <s:hidden  name = "ListaRegioMun[%{#stat.index}].MATRICULA" id="MATRICULA"></s:hidden>
                     
                                <s:hidden  name = "ListaRegioMun[%{#stat.index}].NO_DOCENTES" id="NO_DOCENTES"></s:hidden>
                                
                               <s:hidden  name = "ListaRegioMun[%{#stat.index}].NO_ESCUELAS" id="NO_ESCUELAS"></s:hidden>

                            </s:iterator>
                            

                           <s:hidden  name = "regioB.TOTALREGMATRICULA" id="regioB.TOTALREGMATRICULA"></s:hidden>
                            <s:hidden  name = "regioB.TOTALREGDOCENTES" id="regioB.TOTALREGDOCENTES"></s:hidden>
                                 <s:hidden  name = "regioB.TOTALREGESCUELAS" id="regioB.TOTALREGESCUELAS"></s:hidden>
                                 
                                  <s:hidden  name = "regioB.PREESCOLAR" id="regioB.PREESCOLAR"></s:hidden>
                            <s:hidden  name = "regioB.PRIMARIA" id="regioB.PRIMARIA"></s:hidden>
                                 <s:hidden  name = "regioB.SECUNDARIA" id="regioB.SECUNDARIA"></s:hidden>
                                  <s:hidden  name = "regioB.MEDIA_SUPERIOR" id="regioB.MEDIA_SUPERIOR"></s:hidden>
                            <s:hidden  name = "regioB.SUPERIOR" id="regioB.SUPERIOR"></s:hidden>
                                 <s:hidden  name = "regioB.OTRO" id="regioB.OTRO"></s:hidden>
                                  <s:hidden  name = "regioB.TOTAL_ESCUELAS_NIV" id="regioB.TOTAL_ESCUELAS_NIV"></s:hidden>
                                
                            

                                  <s:iterator value="ListaCatMun" id="ListaCatMun" status="stat">
                            <s:hidden  name = "ListaCatMun[%{#stat.index}].CLAVE_MUNICIPIO" id="CLAVE_MUNICIPIO">  </s:hidden> 
                            <s:hidden  name = "ListaCatMun[%{#stat.index}].MUNICIPIO" id="MUNICIPIO">  </s:hidden> 
                        </s:iterator>
                                 
                                 
                                 

                <s:textfield name="cat.CICLOAUX" id="cat.CICLOAUX" style='visibility:hidden'/>
                <s:textfield  name="cat.OPCION" id="OPCION" style='visibility:hidden'></s:textfield>
                <s:textfield name="cat.TIPO_PROGRAMA" id="TIPO_PROGRAMA"  style='visibility:hidden' ></s:textfield>
                 <s:textfield name="regioB.AUXTIPOPROG" id="AUXTIPOPROG"  style='visibility:hidden' ></s:textfield>


                </section> <!-- / #main-content -->





        </s:form>
                
<header id="main-header">
                                <a href="Javascript:guarda('monitorIms')"><img src="img/monitor.png " alt="monitor" style="margin-right:  35px;  margin-top: 5px; float: right;"></img></a>

                <nav>
                    <div style="padding: 15px;">  <h2 class="titulo_banner3" style="margin-top: -5px;" >La información de este Tablero es de uso interno, para mas detalle favor de accesar a la página http://seduc.edomex.gob.mx/ <br> Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</h2></div>
                </nav><!-- / nav -->

            </header>


    </body>
    <script>
    
    
    function initMap() {
       
        
        
        var map = new google.maps.Map(document.getElementById("mapa"), {
           
            center: {lat: 19.363882, lng: -99.044922},
             zoom:5
        });
        var ctaLayer = new google.maps.KmlLayer({
            url: 'http://reubicacionescuela.edugem.gob.mx/cta.kmz',
            map: map
        });
        var bounds = {
            north: 19.363882,
            south: 20.203405,
            east: -99.044922,
            west: -100.244141,
           
        };
        // Display the area between the location southWest and northEast.
        map.fitBounds(bounds);
        
        // Add 5 markers to map at random locations.
        // For each of these markers, give them a title with their index, and when
        // they are clicked they should open an infowindow with text from a secret
        // message.
        var lngSpan = bounds.east - bounds.west;
        var latSpan = bounds.north - bounds.south;
        var image = 'img/preico.png';
         var image2 = 'img/priico.png';
         var image3 = 'img/secico.png';
          var image4 = 'img/ms.png';
           var image5 = 'img/s.png';
            var image6 = 'img/otroico.png';
      

        

        // var u=0;

        // u=u+0.02;
          var secretMessages = [<s:iterator value="ListaMapa" status="rowstatus" >
    '<s:property value="LONGITUD"/>',
    </s:iterator>
    ];
    // var u=0;

    // u=u+0.02;
    var i = 0;
    <s:iterator value="ListaMapa" status="rowstatus" >
    var marker = new google.maps.Marker({
    position: {

    lat: <s:property value="LATITUD"/>,
            lng: <s:property value="LONGITUD"/>
    },  
            map: map,
            title: 'CCT:<s:property value="CLAVE"/>\n ESCUELA:<s:property value="NOMBRE"/> \n MATRICULA:<s:property value="MATRICULA"/> ALUMNOS \n NIVEL:<s:property value="FILTRO_PARA_TABLERO"/> \n DOMICILIO:<s:property value="DOMICILIO"/> \n LOCALIDAD:<s:property value="LOCALIDAD"/>',
            
            <s:if test="CVE_NIVEDU==1">
        icon: image 
          </s:if>
               <s:if test="CVE_NIVEDU==2">
        icon: image2
          </s:if>
               
               <s:if test="CVE_NIVEDU==3">
        icon: image3
          </s:if>
               <s:if test="CVE_NIVEDU==4">
        icon: image4
          </s:if>
              <s:if test="CVE_NIVEDU==5">
        icon: image5
          </s:if>
               <s:if test="CVE_NIVEDU==6">
        icon: image6
          </s:if>

    });
    i++;
    </s:iterator>
          
        attachSecretMessage(marker, secretMessages[i]);
    }

    // Attaches an info window to a marker with the provided message. When the
    // marker is clicked, the info window will open with the secret message.
    function attachSecretMessage(marker, secretMessage) {
        var infowindow = new google.maps.InfoWindow({
            content: secretMessage
        });
        marker.addListener('click', function () {
            infowindow.open(marker.get('mapa'), marker);
        });
    }
    
   
</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDX8E8BNrVI5vS1vv5q_dz5k9PhGHZopS0&callback=initMap">
</script> 


</html>
