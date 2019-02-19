<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>






<link href="<s:url value="css/style_serlinea.css"/>" media="all" rel="stylesheet" type="text/css"/> 

<!DOCTYPE html>




<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDwUtRSTf7bWX0oThPdQAu1vd5mfJwVrCo&callback=initMap">
</script> 






<script type="text/javascript" src="https://www.google.com/jsapi"  charset="UTF-8"></script>





<script type="text/javascript"  charset="UTF-8">

    //GRAFICA REGION
    // Load the Visualization API and the piechart package.

    google.load('visualization', '1.0', {'packages': ['corechart']});
    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);
    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {
        // Create the data table.
       var data = google.visualization.arrayToDataTable([
            ['Genre', 'IMS', {role: 'annotation'}],
    <s:iterator value=" ListaSerlineaHistDiaMes" id=" ListaSerlineaHistDiaMes" status="stat">
            ['<s:property value="FECHA_ANTERIOR"/>',<s:property value="IMPACTO_DIA"/>, '<s:property value="IMPACTO_DIA"/>'],
    </s:iterator>


        ]);

        // Set chart options 

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('graf_dia'));
        function selectHandler() {
            var selectedItem = chart.getSelection()[0];
            if (selectedItem) {
                var topping = data.getValue(selectedItem.row, 0);
                window.location.assign(rutaGraficasOk + 'TipoD?topping=' + topping + '');
            }
        }

        var options = {

            bar: {groupWidth: '75%'},

            legend:  'none',
             hAxis: {      slantedTextAngle:90 , textStyle: {fontSize: 10  }   },

            titleTextStyle: {
                color: '#A4A4A4',
                fontSize: 16,
                fontName: 'Arial',

            },

            colors: ['#dc831a', '#0b7f9f', '#a574bd', '#9cbb5e'],

            animation: {
                duration: 2500,
                startup: true //This is the new option
            },

            textStyle: {
                color: '#1b9e77',
                fontSize: 20,
                fontName: 'Arial',

                italic: true
            },
            chartArea: {
   top: 30,
   height: '58%' ,
  width:'85%'
   
},
            annotations: {
                textStyle: {

                    fontSize: 13,

                    // The color of the text.
                    color: '#848484'
                            // The color of the text outline.

                            // The transparency of the text.

                }
            }




        };
        google.visualization.events.addListener(chart, 'select', selectHandler);
        chart.draw(data, options);
    }


</script>





<!-- Scripts de navegación de la aplicación -->

<script type="text/javascript">

    function guarda(accion) {

        document.forma.action = accion;
        document.forma.submit();
    }


    function acronimo(accion, valor) {

        document.forma.BUSCAR_ACRONIMO.value = valor;
        document.forma.action = accion;
        document.forma.target = "_self";
        document.forma.submit();
    }
    
     function mesconsulta(accion, valor) {

        document.forma.MES_CONSULTA.value = valor;
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

    function tipoRegionProg(accion, valor) {

        document.forma.AUXTIPOPROG.value = valor;
        document.forma.action = accion;
         
      
        
        document.forma.target = "_self";
        document.forma.submit();
    }

    function regSelect(accion, valor, nomreg) {

        document.forma.IDREGION.value = valor;
        document.forma.NOMREGION.value = nomreg;
     
        
        
        document.forma.action = accion;
        document.forma.target = "_self";
        document.forma.submit();
          }

    function munSelect(accion, valor, mun) {

        document.forma.cvemun.value = valor;
        document.forma.mun.value = mun;
        document.forma.action = accion;
        document.forma.target = "_self";
        document.forma.submit();
    }

    //PARA REGRESAR EN DONDE SE QUEDO...........

       
       window.onload = function () {
              var pos = window.name || 0;
              window.scrollTo(0, pos);
            }
       window.onunload = function () {
                window.name = self.pageYOffset
                        || (document.documentElement.scrollTop + document.body.scrollTop);
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






<html>
    <body onload="startTime()" >

        <s:form value="forma" id="forma" enctype="multipart/form-data">

            <div class="div_img_mex"> <img src="img/edomex.png" alt="Gobierno del Estado de México"/></div>
            <h1 class="titulo_banner">Tablero de Control</h1>
            <h1 class="titulo_banner2">Secretaría de Educación</h1>
           <div class="div_logom" ><img src="img/logom.png" alt="Logo de identidad"/></div>


            <header id="main-header">

                <nav>

                </nav><!-- / nav -->

            </header><!-- / #main-header -->




            <section id="main-content" >



                <div class="div_cont">
                    <!-- MENU DE NAVEGACION -->
                    <aside>

                        <a href="Javascript:guarda('inicio')"> <img src="img/home.png" alt="home" class="home"></img></a>
                        <div class="menu-prog">

                            <nav class="nav_botones">
                              
                                    
                                <div   style="color: white; text-shadow: 3px 3px 6px #333; background: purple; border-radius: 20px 0px 20px 0px;  width: 130px; text-align: center;"> Servicios relevantes</div>
                               
                                <ul class="ul-boton" style="width: 130px;" >
                                    
                                    
                               
                                    
                                    <s:iterator value=" ListaMenuSerlinea" id=" ListaMenuSerlinea" status="stat">
                                        <li ><a href="Javascript:acronimo('serlineaConsulta','<s:property value="ACRONIMO"/>')"><div class="div_ul_prog" <s:if test="ACRONIMO==serlinea.BUSCAR_ACRONIMO">style="width: 120px;  text-align: center;  margin-top: 15px;    background: #666;    color:white;    border-radius: 10px;    box-shadow: 5px 5px 10px #666;"</s:if> >  <s:property value="NOMBRE_SISTEMA"/></div></a></li>
                                        </s:iterator>
                                        
                                        


                                </ul>
                                
                                <s:if test="banderamenu">
                                
                                    <a href="Javascript:guarda('serlineaMenuTodos')"><div   style="color: #000099; text-decoration: underline; width: 130px; text-align: center; margin-top: 30px;"> Más Servicios </div></a>
                                
                                </s:if>
                                
                                 <s:if test="banderamenumenos">
                                
                                <a href="Javascript:guarda('serlinea')"><div   style="color: #000099; text-decoration: underline; width: 130px; text-align: center; margin-top: 30px;"> Menos Servicios </div></a>
                                
                                </s:if>
                 
                                <ul class="ul-boton" >
                                    
                                    
                                  
                                                                                                                                                                        
                                    
                                     <s:iterator value="ListaMenuSerlineaPermanente" id="ListaMenuSerlineaPermanente" status="stat">
                                        <li><a href="Javascript:acronimo('serlineaConsulta','<s:property value="ACRONIMO"/>')"><div class="div_ul_prog" <s:if test="ACRONIMO==serlinea.BUSCAR_ACRONIMO">style="width: 120px;  text-align: center;  margin-top: 15px;    background: #666;    color:white;    border-radius: 10px;    box-shadow: 5px 5px 10px #666;"</s:if>   > <s:property value="NOMBRE_SISTEMA"/></div></a></li>
                                        </s:iterator>
                                        
                                        
                                        

           

                                </ul>
                  
                  
                            </nav>


                        </div>
                        <!-- COLORES DE DIVS DE NAVEGACION -->
                        <div class="div_color1"></div>
                        <div class="div_color2"></div>
                        <div class="div_color3"></div>
                        <div class="div_color4"></div>
                        <div class="div_color5"></div>
                        <div class="div_color6"></div>
                        <div class="div_color1"></div>
                        <div class="div_color1"></div>
                        <div class="div_color2"></div>
                        <div class="div_color3"></div>
                        <div class="div_color4"></div>
                        <div class="div_color5"></div>
                        

                    </aside>

                    <!-- TERMINA NAVEGACION -->



                    <div class="titulo-progras"><h3><s:property value="serlinea.NOMBRE_SISTEMA"></s:property> </h3> </div>

                    <div class="div-colores-tit">
                        <div class="div_color2_tit"></div>
                        <div class="div_color3_tit"></div>
                        <div class="div_color4_tit"></div>
                        <div class="div_color5_tit"></div>
                        <div class="div_color6_tit"></div>
                        <div class="div_color1_tit" ></div>
                    </div>


                    <div class="contenedor-graf">

                        <!-- Inicia Articulo 1 --> 

                        <article class="article1">
                          
                            <div class="div_sec1" style="background: #f2f2f2; " >
                                
                                   <p><strong>Objetivo:</strong><s:property value="serlinea.OBJETIVO"></s:property></p>
                                   <p><strong>Alcance:</strong><s:property value="serlinea.ALCANCE"></s:property></p>
                                   <p><strong>Usuarios:</strong><s:property value="serlinea.USUARIOS"></s:property></p>
                                   <p><strong>Período de vigencia: </strong><s:property value="serlinea.VIGENCIA"/></p>
                                   <a href="#popup" style="text-decoration: none;" > <h4 class="link">Ver más...</h4></a>
                            </div>
                            
                            
                            

                        </article> 
                                        
                                        
                                        
                                        
                                        

                        <!-- INICIA ARTICULO 2 -->

                        <article class="article2"> 
                            <div class="div_sec1" style="background: white; ">
                                
                                
                                
                                <div style="background: #f8e3cc; width: 50%; height: 150px; display: inline-block; height: 200px; border-radius: 20px; position: absolute; margin-left: 30px; ">
                                    
                                    <div style="position: absolute; width: 100%; text-align: center; color: #496e82; font-size: 12px; "><h3 style="font-size: 14px; color: #496e82;"> Nivel de impacto</h3></div>
                                    <img src="img/compu.png" style="width: 100px; margin-top: 50px; margin-left: 45px;"></img>
                                    <div style="position: absolute; color: #666; margin-left: 60px; margin-top: -70px; width: 70px;  text-align: center; "><h4><s:property value="serlinea.IMPACTO_SOCIEDAD"/></h4></div>
                                    
                                    
                                </div>
                                
                                
                                
                             <!--  <div style="background: #edf1db; width: 47%; height: 150px; display: inline-block; margin-left: 10px;  height: 200px; border-radius: 20px; position: absolute; margin-left: 205px; ">
                                    
                                    <div style="position: absolute; width: 100%; text-align: center; color: #496e82; font-size: 12px; "><h3 style="font-size: 14px; color: #496e82;"> % de avance del servicio</h3></div>
                                    <img src="img/porcentaje.png" style="width: 90px; margin-top: 50px; margin-left: 45px;"></img>
                                      <div style="position: absolute; color: white; margin-left: 60px; margin-top: -90px; width: 70px;  font-size: 22px;    text-align: center; "><h4><s:property value="serlinea.PORCENTAJE_AVANCE"/>%</h4></div>
                                    
                                </div>-->
                                
                                
                                
                                
                            </div>
                            <div style="background: #f2f2f2; width: 120px; height: 60px;  position: absolute; margin-left: 70px; margin-top: -50px; border-radius: 10px; box-shadow: 5px 5px 10px #333;">
                                
                                 <div id="clockdate" style="float: right; font-size: 12px; text-align: center; margin-right: 25px; color: #496e82;  font-weight:bold; position: relative; margin-top: 10px;">
                                     <div class="clockdate-wrapper">
                                         <div id="date" style="height: 13px;"></div>
                                        <div id="clock"></div>
                                         
                                     </div>
                                
                            </div>
                                
                                
                              
                                    
                                </div>
                                    
                                
                               
                                    
                                

                        </article> 
                        
                       
                        
                          <!-- BOTONES DE NIVEL E INFOGRAFIA     -->    
                           <div style="width: 76%; height: 20px;  margin-left: 160px;  position: relative; margin-top: 170px;">
                               
                               
                               
                                <div class="titulo-progras"><h3>Monitoreo de Sistemas </h3> </div>
                               
                               
                               
                             <table style="width: 100%; margin-top: -180px;">
                                   <tr>
                                       <td style="width: 35%;" align="center"><img src="img/logoservicio.png" style="width: 70px; margin: auto;"></img> </td>
                                       <td style="width: 65%;"><a href="Javascript:guarda('serlineaConsulta')"><s:if test="nivelimpacto"><div style=" margin: auto; height: 40px; width: 300px; background: #e6a757; text-align: center; color: white;  border-radius: 20px; padding: 10px 0px 0px 10px; margin-top: 18px; "></s:if> <s:else><div style="height: 40px; width: 220px; background: #e6a757; text-align: center; color: white; text-shadow: 5px 5px 5px #333; border-radius: 20px; box-shadow: 5px 5px 10px #666; padding: 10px 0px 0px 10px; margin-top: 18px;"></s:else>Monitoreo de Aplicaciones <img src="img/manogral.png" style="width: 20px; position: absolute; margin-left: 20px; margin-top: 20px;"></img></div></a></td>-
                                       <td style="width: 25%;" align="center"><img src="img/infografia.png" style="width: 60px;"></img> </td><
                                            <td style="width: 25%;"><a href="Javascript:guarda('infografia')"><s:if test="infografia"><div style="height: 40px; width: 220px; background: #487081; text-align: center; color: white;  border-radius: 20px;  padding: 10px 0px 0px 10px; margin-top: 18px;"></s:if><s:else><div style="height: 40px; width: 220px; background: #487081; text-align: center; color: white; text-shadow: 5px 5px 5px #333; border-radius: 20px; box-shadow: 5px 5px 10px #666; padding: 10px 0px 0px 10px; margin-top: 18px;"></s:else> Consultas al Web Service <img src="img/manogral.png" style="width: 20px; position: absolute; margin-left: 20px; margin-top: 20px;"></img></div></a></td>-
                                  
                                   </tr>
                                   
                               </table>
                              
                               
                           </div>

                    
                          
                          
                          <s:if test="nivelimpacto">
                          
                          
                          
                          <!-- DESCRIPCION NARANJA-->    
                               
                              <div style="width: 76%; height: 55px;  margin-left: 160px;  position: relative; margin-top: 0px; ">
                                  
                                  
                                  
                                  <div style="width: 100%; margin: auto; background: #72b1bc; height: 50px; "><div style="width: 95%; margin: auto;  "><h4 style="color: white; font-size: 13px;">Descripción: En este apartado se miden diferentes indicadores que se obtienen de la página web en donde esta publicada la aplicación, cabe señalar que son datos en tiempo real que se obtienen del sistema de monitoreo de la UDAI.</h4></div> </div>
                              
                               
                           </div>


                              <!-- CONTADOR DE ACCESOS A LA PAGINA -->    
                           
                            <div style="width: 76%; height: 280px;  margin-left: 160px;  position: relative; margin-top: 0px; margin-top: 5px;">
                                  
                                <div style="width: 24%; height: 240px;  position: absolute;">
                                    
                                    <div style="width: 100%; height: 40px; background: #8ab66d; text-align: center; color:white; text-shadow: 5px 5px 5px #666; line-height: 1 ; font-size: 14px;">Contador de accesos a la página Web</div>
                                    <div style="width: 100%; height: 250px; background: #f2f2f2;"><div style="width: 100%; position: absolute; margin-top: 62px; text-align: center;"><h4 style="font-size: 35px;"><s:property value="serlinea.IMPACTO_SOCIEDAD"/></h4></div></div>
                                    
                                </div>
                                
                                  <!-- PERSONAS QUE ESTAN ACCESANDO EN ESTE MOMNETO -->    
                                      
                                <div style="width: 24%; height: 280px;  position: absolute; margin-left: 250px; border-bottom: 2px solid #f2f2f2;  ">
                                    
                                     <div style="width: 100%; height: 40px; background: #007cba; text-align: center; color:white; text-shadow: 5px 5px 5px #666; line-height: 1 ; font-size: 14px;">Personas que están accesando en este momento</div>
                                     <div style="width: 100%; height: 200px; "><div id="widgetIframe" style="height: 200px; margin-top: 40px;"><iframe width="102%" height="200" src="https://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&widget=1&moduleToWidgetize=Live&actionToWidgetize=getSimpleLastVisitCount&idSite=<s:property value="%{serlinea.ID_APLICACION}"/>&period=day&date=yesterday&disableLink=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="no" frameborder="0" marginheight="0" marginwidth="0"></iframe></div> <div style="width: 205px; height: 50px; background: white;  margin: auto; margin-top: -50px; z-index: 1; position: relative; margin-bottom: 1px solid #333;"> </div></div>
                                    
                                    
                                </div> 
                                
                                  <!-- VISITAS DESDE REDES SOCIALES -->    
                                
                               
                                <div style="width: 45%; height: 280px;  position: absolute; margin-left: 500px; border-bottom: 2px solid #f2f2f2;">
                         
                                    <div style="width: 100%; height: 30px; background: #dd534d; text-align: center; color:white; text-shadow: 5px 5px 5px #666; line-height: 1 ; padding: 10px 0px 0px 0px; z-index: 1;  position: relative; font-size: 14px; ">Visitas desde redes sociales</div>

                                    
                                    <div id="widgetIframe"><iframe width="102%" height="240" src="https://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&widget=1&moduleToWidgetize=Referrers&actionToWidgetize=getSocials&idSite=<s:property value="%{serlinea.ID_APLICACION}"/>&period=range&date=<s:property value="%{serlinea.FECHA_INICIO}"/>,<s:property value="%{serlinea.FECHA_HOY}"/>&disableLink=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="no" frameborder="0" marginheight="0" marginwidth="0"></iframe></div>

                                </div> 
                                
                                                                                                                                                                                                             
                           </div>
                        
                      <!-- GRAFICA DE VISITAS POR HORA -->                        
                           
                              <div style="width: 76%; height: 310px;  margin-left: 160px;  position: relative; margin-top: 40px; background: #f2f2f2;">
                                  
                                  
                                  
                                  <div style="width: 100%; margin: auto; background: #48aa9d; height: 50px;  "><div style="width: 95%; margin: auto; text-align: center;  "><h4 style="color: white; font-size: 14px; padding: 12px 0px 0px 0px; ">Gráfica de visitas por hora</h4></div> </div>
                            <div style="width: 100%; margin: auto; height: 280px;   "> <div id="widgetIframe"><iframe width="100%" height="300" src="https://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&widget=1&moduleToWidgetize=VisitTime&actionToWidgetize=getVisitInformationPerServerTime&idSite=<s:property value="%{serlinea.ID_APLICACION}"/>&period=day&date=<s:property value="%{serlinea.FECHA_HOY}"/>&disableLink=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="no" frameborder="0" marginheight="0" marginwidth="0"></iframe></div></div>

                               
                           </div>

                        <!-- GRAFICA DE HISTORICO DE ACCESOS POR DIA -->    
                            
                        <div style="width: 76%; height: 300px;  margin-left: 160px;  position: relative; margin-top: 0px; background: #f2f2f2;">
                                  
                                  
                                  
                                  <div style="width: 100%; margin: auto; background: #78a4fb; height: 50px;  "><div style="width: 95%; margin: auto; text-align: center;  "><h4 style="color: white; font-size: 14px; padding: 12px 0px 0px 0px; ">Gráfica de histórico de accesos por día</h4></div> </div>
                                  <nav class="nav_botones" style="margin-left: 10px;" >
                                      <ul class="ul-boton" style="margin-left: 30ox;" >
                                    
                                    
                                  
                                                                                                                                                                        
                                    
                                     <s:iterator value="ListaSerlineaHistDia" id="ListaSerlineaHistDia" status="stat">
                                         <li style="display: inline-block; width: 250px; margin-left: 25px;"><a href="Javascript:mesconsulta('serlineaMesConsulta','<s:property value="MES"/>')"><div class="div_ul_prog" <s:if test="serlinea.MES_CONSULTA==MES"> style="display: inline-block; width:250px; border: 1px solid #666; margin-left: 10px ; background: #666; color:white;"</s:if><s:else>style="display: inline-block; width:250px; border: 1px solid #666; margin-left: 10px; "</s:else> > <s:property value="MES_LETRA"/></div></a></li>
                                        </s:iterator>
                                        
                                        
                                        

           

                                </ul>
                                  
                                  </nav>   
                                  
                                  
                                  
                                  
                        <div style="width: 100%; margin: auto; height: 320px;   ">  <div id="graf_dia" style="margin: auto; width: 90%; height: 180px; margin-bottom: 32px; margin-top: 15px;" ></div></div>

                               
                           </div> 
                        
                          <!-- VIISITAS DE TIPOS DE ACCESO Y TIPO DE DISPOSITIVO -->    
                        
                         <div style="width: 76%; height: 350px;  margin-left: 160px;  position: relative; margin-top: 30px  ">
                             
                             <!-- VIISITAS DE TIPOS DE ACCESO -->    
                                  
                             <div style=" width: 49%; height: 250px; background: blue; position: absolute;">
                                 
                                 <div style="width: 100%; height: 38px; background: #36b1e0; text-align: center; color:white; text-shadow: 5px 5px 5px #666; line-height: 1 ; padding: 12px 0px 0px 0px;"> Visitas desde tipos de acceso</div>
                                 <div style="width: 100%; height: 300px; background: #f2f2f2; text-align: center; color:white; "> 
                                 
                                     <table style=" margin-top: 25px; position: absolute; margin-left: 0px; color: #333;">
                                        
                                         <tr>
                                             <td style="width: 130px;" align="center"><div style="width: 110px; height: 110px; background: #007cba; border-radius: 50%;"><div style="display: block; width: 70px; ;"><div style="position: absolute; margin-top: 26px;"><h4 style=" font-size:  26px; margin-top: 0px;  color: white; text-align: center;">http://</h4></div>  </div><div style="display: block; width: 70px; margin-top: 5px; position: absolute; margin-top: 60px; margin-left: 20px;"><h4 style="margin-top: 0px; font-size: 14px; color: white;"><s:property value="serlinea.PORCE_ENTRADA_DIRECTA"/>%</h4></div></div></td>
                                              <td style="width: 33%;" align="center"><div style="width: 110px; height: 110px; background: #007cba; border-radius: 50%;"><div style="display: block; width: 70px; ;"><img src="img/iconointernet.png" style="margin-top: 20px;"></img></div><div style="display: block; width: 70px; margin-top: 5px;"><h4 style="margin-top: 0px; font-size: 14px; color: white;"><s:property value="serlinea.PORCE_SITIOS_INTERNET"/>%</h4></div></div></td>
                                               <td style="width: 33%;"align="center"><div style="width: 110px; height: 110px; background: #007cba; border-radius: 50%;"><div style="display: block; width: 70px; ;"><img src="img/iconomotores.png" style="margin-top: 28px;"></img></div><div style="display: block; width: 70px; margin-top: 5px;"><h4 style="margin-top: 0px; font-size: 14px; color: white;"><s:property value="serlinea.PORCE_MOTORES_BUSQUEDA"/>%</h4></div></div></td>
                                         </tr>
                                         
                                          <tr>
                                             <td>Entrada directa</td>
                                              <td>Sitios de Internet</td>
                                               <td>Motores de Búsqueda</td>
                                         </tr>
                                         
                                       
                                         
                                         
                                     </table>
                                     
                                 
                                 
                                 
                                 </div>
                               
                                 
                                 <div><h4 style="margin-top: 0px; position: absolute; font-size: 8px; margin-top: -80px;"><strong style="color:black;">Nota:</strong> El % es con respecto al total de visitas.</h4></div>    
                                 <div style="margin-left: 10px;">
                                     <p style="padding: 0px; margin-top: 0px; margin-bottom: 0px; line-height: 1;"><h4 style="margin-top: 0px; position: absolute; font-size: 8px; margin-top: -60px;"><strong style="color:black;">Entrada directa:</strong> Es aquel donde el usuario accede directamente a un sitio web escribiendo la dirección en el navegador.</h4></p>
                                     <p style="padding: 0px; margin-top: 0px; margin-bottom: 0px; line-height: 1;" ><h4 style="margin-top: 0px; position: absolute; font-size: 8px; margin-top: -60px;"><strong style="color:black;">Sitios de internet:</strong> Diversas direcciones web.</h4></p>
                                     <p style="padding: 0px; margin-top: 0px; margin-bottom: 0px; line-height: 1;"><h4 style="margin-top: 0px; position: absolute; font-size: 8px; margin-top: -60px;"><strong style="color: black;">Motores de búsqueda:</strong> Palabras clave.</h4></p>

                                 </div>   
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                             
                             
                             
                             </div>
                                         
                                         
                             
                              
                             
                             <!--  TIPO DE DISPOSITIVO -->    
                             
                             <div style=" width: 50%; height: 250px; position: absolute; margin-left: 50%; ">
                                 
                                 <div style="width: 100%; height: 38px; background: #ea7f33; text-align: center; color:white; text-shadow: 5px 5px 5px #666; line-height: 1 ; padding: 12px 0px 0px 0px;"> Visitas desde tipos de acceso</div>
                                  <div style="width: 100%; height: 300px; background: #f2f2f2; text-align: center; color:white; "> 
                                 
                                      <table style=" margin-top: 5px; position: absolute; margin-left: 60px; color: #333;">
                                          <tr>
                                              <td>Teléfono </td>
                                              <td>Escritorio</td>

                                          </tr>
                                          <tr>
                                              <td style="width: 150px;" align="center"><div style="width: 90px; height: 90px; background: #fcbc42; border-radius: 50%;"><div style="display: block; width: 70px; "><img src="img/iconotelefono.png" style="margin-top: 8px;"></img></div><div style="display: block; width: 70px;"><h4 style="margin-top: 0px; font-size: 14px; color: white;"><s:property value="serlinea.PORCE_TIPO_TEL"/>%</h4></div> </div></td>
                                              <td style="width: 50%;" align="center"><div style="width: 90px; height: 90px; background: #fcbc42; border-radius: 50%;"><div style="display: block; width: 70px; "><img src="img/iconoscomputadora.png" style="margin-top: 20px;"></img></div><div style="display: block; width: 70px; margin-top: 5px;"><h4 style="margin-top: 0px; font-size: 14px; color: white;"><s:property value="serlinea.PORCE_TIPO_ESCRITORIO"/>%</h4></div></div></td>

                                          </tr>

                                           <tr>
                                              <td>Tableta</td>
                                              <td>Otros</td>

                                          </tr>
                                          <tr>
                                              <td style="width: 150px;" align="center"><div style="width: 90px; height: 90px; background: #fcbc42; border-radius: 50%;"><div style="display: block; width: 70px; ;"><img src="img/iconostableta.png" style="margin-top: 20px;"></img></div><div style="display: block; width: 70px; margin-top: 5px;"><h4 style="margin-top: 0px; font-size: 14px; color: white;"><s:property value="serlinea.PORCE_TIPO_TABLETA"/>%</h4></div></div></td>
                                              <td style="width: 50%;" align="center"><div style="width: 90px; height: 90px; background: #fcbc42; border-radius: 50%;"><div style="text-align: center;"><h4 style="margin-top: 33px; font-size: 18px;  margin-left: 0px; color: white; position: absolute; text-align: center;  width: 90px; "><s:property value="serlinea.PORCE_TIPO_OTROS"/>%</h4></div></td>

                                          </tr>



                                      </table>
                                     
                                 
                                 
                                 
                                 </div>
                                <div><h4 style="margin-top: 0px; position: absolute; font-size: 9px; margin-top: -30px; margin-left: 10px; line-height: 1;"><strong style="color:black;">Nota:</strong> Otros dispositivos (tabléfono, consola, televisión, reproductor de medios portátil, desconocidos).</h4></div>    

                                 
                             </div>
                               
                           </div>
                        
                        
                          <!-- VISITAS DESDE DIFERENTES MUNICIPIOS -->    
                        
                        <div style="width: 76%; height: 350px;  margin-left: 160px;  position: relative; margin-top: 10px; ">
                             
                            
                                  
                             <div style=" width: 49%; height: 250px; background: blue; position: absolute;">
                                 
                                 <div style="width: 100%; height: 38px; background: #e6767d; text-align: center; color:white; text-shadow: 5px 5px 5px #666; line-height: 1 ; padding: 12px 0px 0px 0px;"> Visitas desde diferentes ciudades</div>
                                 <div style="width: 100%; height: 300px; background: #f2f2f2; text-align: center; color:white; ">
                                 
                                 <div id="widgetIframe"><iframe width="100%" height="350" src="https://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&widget=1&moduleToWidgetize=UserCountry&actionToWidgetize=getCity&idSite=<s:property value="%{serlinea.ID_APLICACION}"/>&period=range&date=<s:property value="%{serlinea.FECHA_INICIO}"/>,<s:property value="%{serlinea.FECHA_TERMINO}"/>&disableLink=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="si" frameborder="0" marginheight="0" marginwidth="0"></iframe></div>
                                 
                                 
                                 </div>
                             </div>
                                 
                                 
                                 
                                 <div style=" width: 50%; height: 250px; position: absolute; margin-left: 50%; ">
                                 
                                 
                                 
                                 
                                 
                                     <div style="width: 100%; height: 38px; background: #d30f0f; text-align: center; color:white; text-shadow: 5px 5px 5px #666; line-height: 1 ; padding: 12px 0px 0px 0px;"> Páginas Visitas </div>
                                 <div style="width: 100%; height: 300px; background: #f2f2f2; text-align: center; color:white; ">
                                 
                                 <div id="widgetIframe"><iframe width="100%" height="320" src="https://monitoreo.edu-edomex.gob.mx/index.php?module=Widgetize&action=iframe&widget=1&moduleToWidgetize=Actions&actionToWidgetize=getPageUrls&idSite=<s:property value="%{serlinea.ID_APLICACION}"/>&period=range&date=<s:property value="%{serlinea.FECHA_INICIO}"/>,<s:property value="%{serlinea.FECHA_TERMINO}"/>&disableLink=1&widget=1&token_auth=8659d47958cf980c51546df31dbcd6be" scrolling="no" frameborder="0" marginheight="0" marginwidth="0"></iframe></div>
                                 
                                 
                           
                                 
                             </div>
                             
                           
                             
                           
                               
                           </div>
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                        


                           </s:if>      


                          <!-- SECCION DE INFOGRAFIA Y AVANCE       ################################################################3-->
                          
                              <s:if test="infografia">
                          
                         <!-- 
                             <div style="width: 76%; height: 55px;  margin-left: 160px;  position: relative; margin-top: 0px; ">
                                  
                                  
                                  
                                 <div style="width: 100%; margin: auto; background: #487081; height: 50px; border-radius: 15px 15px 0px 0px; "><div style="width: 95%; margin: auto;  "><h4 style="color: white; font-size: 14px;">Descripción:<s:property value="serlinea.DESCRIPCION"></s:property></h4></div> </div>
                              
                               
                           </div>

                          
                           <div style="width: 76%;  margin-left: 160px;  position: relative; margin-top: 0px; background: #f2f2f2;">
                                  
                                  
                                  
                                  <div style="width: 100%; margin: auto; background: #8c9f4c; height: 50px;  "><div style="width: 95%; margin: auto; text-align: center;  "><h4 style="color: white; font-size: 18px; padding: 12px 0px 0px 0px; text-shadow: 5px 5px 10px #333; ">Avance registrado al día de hoy</h4></div> </div>
                                  
                                  
                                  
                                  
                                  
                        <div style="width: 100%; margin: auto; border-bottom: 50px; margin-bottom: 30px;   "> 
                        
                            <table style=" width: 85%; margin-left: 50px; margin-top: 30px; border-collapse: collapse; height: 65%; font-size: 14px; margin-bottom: 30px; ">
                                <tr style="background:#8c9f4c; color: white; border-radius: 5px;  " >
                                    <th style="width: 200px;">    </th>
                                    <th colspan="2">Alumnos</th>
                                   
                                    <th colspan="2">Docentes</th>
                                   
                                    <th colspan="2">Escuelas</th>
                                    
                                    <th colspan="2">Municipios</th>
                                   
                                    
                                </tr>
                                
                                 <tr style="background:#8c9f4c; color: white; border-radius: 5px;   " >
                                    <th style="width: 200px; " width="200" >    </th>
                                    <th width="100">Total</th>
                                    <th width="100">%</th>
                                    <th width="100">Total</th>
                                    <th width="100">%</th>
                                     <th width="100">Total</th>
                                    <th width="100">%</th>
                                    <th width="100">Total</th>
                                    <th width="100">%</th>
                                    
                                </tr>
                                
                            <s:if test="ListaserlineInfografiaAvance.size()>0">
                                
                            <s:iterator value="ListaserlineInfografiaAvance" id="ListaserlineInfografiaAvance" status="stat">
                                
                                <tr style="text-align: center; background: #d7d7d7; ">
                                    
                                    <td style="color:#487081;"><s:property value="TITULO"/></td>
                                    <td><s:property value="ALUMNOS"/>    </td>
                                    <td><s:property value="PORCE_ALUMNOS"/></td>
                                    <td><s:property value="DOCENTES"/></td>
                                    <td><s:property value="PORCE_DOCENTES"/></td>
                                     <td><s:property value="ESCUELAS"/></td>
                                    <td><s:property value="PORCE_ESCUELAS"/></td>
                                    <td><s:property value="MUNICIPIOS"/></td>
                                    <td><s:property value="PORCE_MUNICIPIOS"/></td>
                                    
                                    
                                </tr>
                                </s:iterator>
                         
                        
                                
                                </s:if>
                                
                            <s:else>
                                
                                <tr style="text-align: center; background: #d7d7d7; ">
                                    
                                    <td style="color:#487081;" colspan="9" height="150">¡No hay infomación para mostrar!</td>
                                    
                                    
                                    
                                </tr>
                                
                                
                            </s:else>
                                
                            </table>
                        
                        
                        
                        </div>
                          
                                  <div style="font-size: 16px; color: black; margin-bottom: 10px; margin-top: -10px; margin-left: 15px; height: 40px;"> <s:if test="ListaserlineInfografiaAvance.size()>0">Nota:<s:property value="serlinea.NOTA_AVANCE"/></s:if></div>

                              
                           </div> 
                          
                          
                           --> 
                          
                          
                          
                          
                          <!-- BENEFIAACIARIOS CON LOGOS -->
                          
                          
                          
                          <!-- 
                          
                           <div style="width: 76%;  margin-left: 160px;  position: relative; margin-top: 0px; background: #f2f2f2;">
                                  
                                  
                                  
                                  <div style="width: 100%; margin: auto; background: #a1b2b9; height: 50px;  "><div style="width: 95%; margin: auto; text-align: center;  "><h4 style="color: white; font-size: 18px; padding: 12px 0px 0px 0px; text-shadow: 5px 5px 10px #333; ">Alcance esperado</h4></div> </div>
                                  
                                  
                                  
                                  
                                  
                        <div style="width: 100%; margin: auto; border-bottom: 50px; margin-bottom: 30px;   "> 
                        
                            <table style=" width: 75%; margin-left: 100px; margin-top: 30px; border-collapse: collapse; height: 65%; font-size: 14px; margin-bottom: 30px; ">
                                <tr style="background:#a1b2b9; color: white; border-radius: 5px;  " >
                                    <th style="width: 100px;" colspan="2">    </th>
                                    <th ><img src="img/iconomundo.png" style="width: 30px;"/></th>
                                   
                                    <th><img src="img/iconosblancos.png" style="width: 30px;"/></th>
                                   
                                    <th><img src="img/icoporcentaje.png" style="width: 30px;"/></th>
                                    
                                   
                                   
                                    
                                </tr>
                                <tr style="background:#a1b2b9; color: white; border-radius: 5px;  " >
                                    <th style="width: 100px;" colspan="2">    </th>
                                    <th >Universo</th>
                                   
                                    <th>Beneficiarios</th>
                                   
                                    <th>% de Beneficiarios</th>
                                    
                                   
                                   
                                    
                                </tr>   
                                <s:if test="ListaserlineInfografiaAlcance.size()>0">
                                <s:iterator value="ListaserlineInfografiaAlcance" id="ListaserlineInfografiaAlcance" status="stat">  
                                
                                <tr style="text-align: center; background: #d7d7d7; ">
                                    
                                    <td><s:if test="DESCRIPCION=='ALUMNOS'"><img src="img/alumnos.png" style="width: 50px;"></img></s:if>          <s:if test="DESCRIPCION=='DOCENTES'"><img src="img/docentes.png" style="width: 50px;"></img></s:if>   <s:if test="DESCRIPCION=='ESCUELAS'"><img src="img/escuelas.png" style="width: 50px;"></img></s:if>     <s:if test="DESCRIPCION=='MUNICIPIOS'"><img src="img/logoEst.png" style="width: 50px;"></img></s:if>    </td>
                                    <td><s:property value="DESCRIPCION"/></td>
                                    <td><s:property value="UNIVERSO"/></td>
                                    <td><s:property value="BENEFICIARIOS"/></td>
                                    <td><s:property value="PORCE_BENEFICIARIO"/></td>
                                   
                                    
                                </tr>
                                    
                                    </s:iterator>
                                
                                </s:if>
                                <s:else>
                                
                                <tr style="text-align: center; background: #d7d7d7; ">
                                    
                                    <td style="color:#487081;" colspan="5" height="150">¡No hay infomación para mostrar!</td>
                                    
                                    
                                    
                                </tr>
                                
                                
                            </s:else>
                                
                                
                                
                                
                                
                              
                                
                            </table>
                        
                        
                        </div>
                        
                                  <div style="font-size: 16px; color: black; margin-bottom: 10px; margin-top: -10px; margin-left: 100px; height: 40px; background: #4d707f; color:white; width: 75%;"><s:if test="ListaserlineInfografiaAlcance.size()>0">Nota:<s:property value="serlinea.NOTA_ALCANCE"/></s:if></div>
                        
                               
                           </div> 
                          
                          
                        
                          
                          
                          
                          
                          
                              
                          
                          
                          
                          
                          
                          
                          
                       
                    </div>   
                          
                           <div style="width: 76%; height: 400px;  margin-left: 160px;  position: relative; margin-top: 0px; background: #f2f2f2;">
                                  
                                  
                                  
                                  <div style="width: 100%; margin: auto; background: #36b1e0; height: 50px;  "><div style="width: 95%; margin: auto; text-align: center;  "><h4 style="color: white; font-size: 18px; padding: 12px 0px 0px 0px; text-shadow: 5px 5px 10px #333;">Histórico por día de registros realizados en el sistema</h4></div> </div>
                                    
                                  
                                  
                                  
                                  
                                  <div style="width: 100%; margin: auto; height: 420px;   ">  <div id="graf_dia" style="margin: auto; width: 90%; height: 280px; margin-bottom: 32px; margin-top: 15px;" ></div>
                                      
                                      
                                       <div style="font-size: 16px; color: black; margin-bottom: 10px; margin-top: -10px; margin-left: 15px; height: 40px;">Nota:<s:property value="serlinea.NOTA_SEC3"/></div>

                                      
                                  </div>
                        
                       
                               
                           </div> 
-->

<iframe src="https://prototipoconstanciae.edugem.gob.mx/consola/estats/tablero_ws.php" frameborder="0" gesture="media" allow="encrypted-media"  style="width: 80%; min-height: 1200px; max-height: 1500px; margin-top: 20px;"></iframe>



                                  </s:if>


                    <!-- BORINES DE DESCARGA DE DOCUENNTOS -->
                    <div class="grafica-grande"> 
                        <div class="menu-botones" style="margin-top: 20px;">
                            <s:url action="GeneraPdf" id="myUrl" escapeAmp="false">

                                <s:param name="TipoReporte" value="'ReporteGrafica.jasper'"/>
                                <s:param name="MUNICIPIO" value="regioB.CLAVE_MUNICIPIO"/>
                                <s:param name="CicloEscolar" value="cat.CICLOAUX"/>
                                <s:param name="esExcel" value="'false'"/>
                                <s:param name="esPDF" value="'true'"/>            

                            </s:url> 
                            
                            <s:url action="GeneraPdf" id="myUrl1" escapeAmp="false">

                                <s:param name="TipoReporte" value="'RegioListado.jasper'"/>
                                <s:param name="MUNICIPIO" value="regioB.CLAVE_MUNICIPIO"/>
                                <s:param name="esExcel" value="'false'"/>
                                <s:param name="esPDF" value="'true'"/>            

                            </s:url> 




                        <!--    <a href= "<s:property value="#myUrl1"/>" target="_blank"><div class="div_bottones2" id="pdf_descarga" style="margin-left: 130px;"><div class="img-prog-ind"><img src="img/pdf.png" alt="home" ></img></div><div class="text-prog-ind2" >Escuelas Beneficiadas</div> <div class="text-prog-ind2" >por Municipio</div> </div></a>
                            <a href= "<s:property value="#myUrl" />" target="_blank"  ><div class="div_bottones2" id="pdf_descarga" style="margin-left: 30px;"><div class="img-prog-ind" ><img src="img/pdf.png" alt="home" ></img></div><div class="text-prog-ind2">Información Municipio</div>  <div class="text-prog-ind2" >Seleccionado</div>   </div></a>-->
                        </div>
                        
                        
                       
                                
                               

                        <!-- CAMPOS OCULTOS DE MANEJO DE APLICACIÓN-->
                     
                         <s:textfield name="serlinea.BUSCAR_ACRONIMO" id="BUSCAR_ACRONIMO" style='visibility:hidden'   ></s:textfield>
                          <s:textfield name="serlinea.MES_CONSULTA" id="MES_CONSULTA" style='visibility:hidden'  ></s:textfield>
                        </div>



                        <!-- ITERACION DE OBJETOS LISTAS -->    


                    <s:iterator value="ListaMenuSerlinea" id="ListaMenuSerlinea" status="stat">
                        <s:hidden  name = "ListaMenuSerlinea[%{#stat.index}].ACRONIMO" id="ACRONIMO"></s:hidden>
                        <s:hidden  name = "ListaMenuSerlinea[%{#stat.index}].NOMBRE_SISTEMA" id="NOMBRE_SISTEMA"></s:hidden>
                      
                    </s:iterator>

                     <s:iterator value="ListaMenuSerlineaPermanente" id="ListaMenuSerlineaPermanente" status="stat">
                        <s:hidden  name = "ListaMenuSerlineaPermanente[%{#stat.index}].ACRONIMO" id="ACRONIMO"></s:hidden>
                        <s:hidden  name = "ListaMenuSerlineaPermanente[%{#stat.index}].NOMBRE_SISTEMA" id="NOMBRE_SISTEMA"></s:hidden>
                      
                    </s:iterator>
                        
                        
                        
                          <s:hidden name="banderamenu" value="%{bandermenu}"/>
                           <s:hidden name="banderamenumenos" value="%{bandermenumenos}"/>

                              
                        

                </div>


            </section> 
                           
                 
                           
                           
                           
                          <div class="modal-wrapper" id="popup">
                                                    <div class="popup-contenedor">
                                                        <h2  >Datos del Programa</h2>

                                                        <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >
                                                            <table id="customers" style="text-align: left; border: none; " align="left">
                                                            <tr>
                                                                <th align="left" style="font-size: 12px; text-align: justify;"><s:property value="serlinea.VER_MAS"/></th>


                                                            </tr>
                                                            

                                                        </table>
                                                         </div>   
                                                        <a class="popup-cerrar" href="#">X</a>
                                                    </div>
                                                </div>  
                           
                           
                           
                           
                           
                           
                           
                           

        </s:form>


    </body>
    <div class="div-footer"> <h2 class="texto-footer">La información de este Tablero es de uso interno, para mas detalle favor de accesar a la página http://seduc.edomex.gob.mx/ <br>Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</h2> </div>

</html>
