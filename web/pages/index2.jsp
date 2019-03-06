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

           

                <nav>

                </nav><!-- / nav -->
                
               <label for="menu-toogle" class="menu-toogle"></label>
<input type="checkbox" class="checkbox" id="menu-toogle" />

<nav class="navmenu">
    <ul  style="display: block;" >




                            <s:iterator value="ListaBotones" id="ListaBotones" status="stat">


                            <a href= "Javascript:nivel('nivelcomunidad2','<s:property value="ID_OPCION"/>')" style="font-size:40px; text-shadow: 2px 4px 12px black;" >    <div class="div-menu-cel"<s:if test="ID_OPCION==cat.OPCION">style="background: #a574bd;"</s:if>>  <li style="margin-top: 25px;" > <s:if test="ID_OPCION==cat.OPCION"></s:if>  <s:property value="VALOR"/></li></div></a>
                                   


                            </s:iterator>

                        </ul>
</nav>
                
                
                
                
                
                
                

            </header><!-- / #main-header -->


            <section id="main-content">
                <div class="menu-botones">

                    <nav class="nav_botones">
                        <ul class="ul-boton" >




                            <s:iterator value="ListaBotones" id="ListaBotones" status="stat">


                                <li ><a href= "Javascript:nivel('nivelcomunidad2','<s:property value="ID_OPCION"/>')"><div class="div_bottones" <s:if test="ID_OPCION==cat.OPCION">style="background: #7F3390; "</s:if> >  <s:property value="VALOR"/></div></a></li>
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

                                <div class="div_img_contenedor_matricula"> <a href="#"><img src="img/alumnos.png" class="position-logo-totales"></img> <h7 class="totales-tit"> Alumnos </h7><br></img> <h7 class="totales-cantidad" style="color:black;"> <s:property value="comedu.TOTALALUMAT"/></h7>  <img src="img/manogral.png" style="width: 20px; float: right; margin-top: -30px; margin-right: -10px;"></img> </div> </a> 
                                <div class="div_img_contenedor_matricula"><a href="#"><img src="img/docentes.png"  class="position-logo-totales"></img> <h7 class="totales-tit">Docentes</h7><br></img> <h7 class="totales-cantidad" style="color:black;"><s:property value="comedu.TOTALDOCENTE"/></h7> <img src="img/manogral.png" style="width: 20px; float: right; margin-top: -30px; margin-right: -10px;"></img></div></a> 
                                 <div class="div_img_contenedor_matricula"><a href="#"><img src="img/escuelas.png" class="position-logo-totales"></img>  <h7 class="totales-tit">Escuelas</h7><br></img><h7 class="totales-cantidad" style="color:black;"><s:property value="comedu.TOTALESCU"/></h7><img src="img/manogral.png" style="width: 20px; float: right; margin-top: -30px; margin-right: -10px;"></img></div></a>  

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

                 
                                                                    
                              
                                                                    
                                                                    
                                                                    
            <!-- Regiones no mover -->                                  
                         
                                                             
                                                                    

                        <!-- Termina Sección de Programas y Apoyos -->



                      

                        <!-- Termina Articulo 1 -->      



                        <!-- Inicia Articulo 2 -->

                    </article> <!-- /article -->







                    <article class="art2">


                        <s:if test="cat.OPCION<=0">

                        <div class="div_sec1" id="sec2" style=" border-right:  4px solid #0ea2dc" >
                        <!-- <div class="subtitulo-seccion"><h2>Del Sector</h2></div>-->
                           <img  class="position-img-etiqueta"  src="img/indica.png" alt="Comunidad Educativa" />
                           <a href="#">    <div class="titulo_est_fed" style=" border: 1px solid #0ea2dc ; margin-top: -40px; margin-left: 35px;"><h8>Del Sector</h8> <img src="img/SEC.png" class="position-logotit"  style="width: 40px;"></img>  <img src="img/manogral.png" style="width: 20px; float: right;  margin-top: 5px;"></img>  </div></a>
                            
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
                          
                                  <div style="width: 190px; height: 150px;  float: right;  margin-top: -163px;"><div style="height: 20px; width: 80px; text-align: center; float: right; margin-top: 30px; position: absolute; margin-left: 105px; color: red; "> <s:property value="cat.LCPRINCIPAL"/>%</div><a href="#" ><img src="img/logo_eva.png" ></a> <div style="height: 20px; width: 80px; text-align: center; float: right; margin-top: -35px; position: absolute; margin-left: 105px; color: red; ">  <s:property value="cat.MATPRINCIPAL"/>%  </div></img></div>
                             
                             <a href="#"> <div class="titulo_est_fed" style=" border: 1px solid #ffcc01 ; margin-top: -10px; margin-left: 35px; margin-bottom: 50px; width: 65%;"><h8 style="margin-left: 55px;">Cobertura por nivel Educativo</h8><img src="img/SEC2.png" class="position-logotit" style="width: 40px;"></img>  <img src="img/manogral.png" style="width: 20px; float: right; margin-top: 5px;"></img></div>   </a> 
                             
                             
                             
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
                             <a href="#"> <div class="titulo_est_fed" style=" border: 1px solid #ffcc01 ; margin-top: -10px; margin-left: 35px; margin-bottom: 50px; width: 55%;"><h8 style="margin-left: 55px;">Cobertura por nivel Educativo</h8><img src="img/SEC2.png" class="position-logotit" style="width: 40px;"></img>  <img src="img/manogral.png" style="width: 20px; float: right; margin-top: 5px;"></img></div>   </a> 
                            
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
