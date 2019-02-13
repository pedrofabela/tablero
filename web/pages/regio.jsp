<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>


<link href="<s:url value="css/style_regio.css"/>" media="all" rel="stylesheet" type="text/css"/> 

<!DOCTYPE html>




<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDwUtRSTf7bWX0oThPdQAu1vd5mfJwVrCo&callback=initMap">
</script> 





<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                    ['Task', 'Escuelas por Nivel'],
    <s:iterator value="ListaRegioGrafNiv" id="ListaRegioGrafNiv" status="stat">

                    ['<s:property value="NOMNIV"/>:<s:property value="TOTALNIV"/>', <s:property value="TOTALNIV"/>],

    </s:iterator>

                            ]);

                            var options = {
                                title: 'Número de Escuelas del Municipio: Toluca',
                                backgroundColor: '#e7e6e6',
                                chartArea: {left: 20, top: 0, width: '85%', height: '100%'},
                                legend: {position: 'left', top: 20, width: '45%', textStyle: {fontSize: 13, color: 'black', fontName: 'Didactic'}},

                                colors: ['#eb5b74', '#25a1db', '#9dc325', '#fcce00', '#a29f9d', '#e1173e'],

                                textStyle: {

                                    fontSize: 16,

                                    // The color of the text.
                                    color: '#848484'
                                            // The color of the text outline.

                                            // The transparency of the text.

                                },
                                
                            






                            };



                            var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                            chart.draw(data, options);
                            
                            var counter = 0;

    var handler = setInterval(function(){ 
        counter = counter + 0.01
        options = {
                    
          slices: {                        
                    3: {offset: counter},
                    4: {offset: counter},                       
                    5: {offset: counter},                       
                    
          },
          
          
                                backgroundColor: '#e7e6e6',
                                chartArea: {left: 20, top: 25, width: '85%', height: '80%'},
                                legend: {position: 'left', top: 20, width: '45%', textStyle: {fontSize: 13, color: 'black', fontName: 'Didactic'}},

                                colors: ['#eb5b74', '#25a1db', '#9dc325', '#fcce00', '#a29f9d', '#e1173e'],

                                textStyle: {

                                    fontSize: 16,

                                    // The color of the text.
                                    color: '#848484'
                                            // The color of the text outline.

                                            // The transparency of the text.

                                },
          
          
          
          
          
          
        };
        chart.draw(data, options);

        if (counter > 0.15) clearInterval(handler);
    }, 200);    
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
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




            <section id="main-content" >



                <div class="div_cont">
                    <!-- MENU DE NAVEGACION -->
                    <aside>

                        <a href="Javascript:guarda('inicio')"> <img src="img/home.png" alt="home" class="home"></img></a>
                        <div class="menu-prog">

                            <nav class="nav_botones">
                                <ul class="ul-boton" >
                                    <s:iterator value=" ListaMenuRegio" id=" ListaMenuRegio" status="stat">
                                        <li><a href="Javascript:regSelect('RegioSelect','<s:property value="IDREGION"/>','<s:property value="NOMREGION  "/>')"><div class="div_ul_prog" <s:if test="IDREGION==regioB.IDREGION"> id="fondo-menu-regio"</s:if> > <s:property value="NOMREGION"/></div></a></li>
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

                    </aside>

                    <!-- TERMINA NAVEGACION -->



                    <div class="titulo-progras"><h3>Información de la Región <s:property value="regioB.NOMREGION"/> </h3> </div>

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
                            <div class="div_sec1">
                                <div class="titulo-progras" id="div-100"><h3 class="sub-tit">Datos de  municipios pertenecientes a la Región</h3></div>
                                <img src="img/cintamorada.png" alt="Imagen Morada" id="img-centrar" style="width: 90%;"></img>
                                <div class="hoverflow-tab-mun">
                                    <table id="customers">
                                        <tr class="borde-tabla-booton">
                                            <th>Municipio</th>
                                            <th>Alumnos</th>
                                            <th>Docentes</th>
                                            <th>Escuelas</th>
                                        </tr>

                                        <s:iterator value="ListaRegioMun" id="ListaRegioMun" status="stat">
                                            <tr>
                                                <td  <s:if test="CLAVE_MUNICIPIO==regioB.CLAVE_MUNICIPIO"> style=" background: #8c4f9b; "</s:if> id="td" style="text-decoration: none;" ><a href="Javascript:munSelect('municipioSelect','<s:property value="CLAVE_MUNICIPIO"/>','<s:property value="MUNICIPIO"/>')" <s:if test="CLAVE_MUNICIPIO==regioB.CLAVE_MUNICIPIO"> style="color:  white; text-decoration: none; "</s:if>><s:property value="MUNICIPIO"/></a></td>
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
                                </div>

                            </div>


                        </article> 

                        <!-- INICIA ARTICULO 2 -->

                        <article class="article2"> 
                            <div class="div_sec1">
                                <div class="titulo-progras"><h3 class="sub-tit">Escuelas Publicas Beneficiadas por Nivel Educativo del Municipio: <s:property value="regioB.MUNICIPIO"/></h3></div>
                                <div id="piechart" style="width: 95%; height: 250px; margin-top: 15px;"></div>
                                <div class="div-total_graf-region"><h3 class="sub-tit" style="text-align: center;">Total de Escuelas</h3></div>
                                <div class="div-total_graf-region" style="margin-top: -65px;"><h3 class="sub-tit" style="text-align: center;"> <s:property value="regioB.NO_ESCUELAS"/></h3></div>

                            </div>

                        </article> 



                                <div class="titulo-progras"><h3>Concentrado de Programas <strong style="color:#934493;">VIGENTES</strong> durante el Ciclo Escolar <s:property value="cat.CICLOAUX"/>, del Municipio: <s:property value="regioB.MUNICIPIO"/> </h3> </div>
                        <img src="img/cintamoradagrande.png" alt="Imagen Morada" id="img-centrar" style="margin-top: 40px; position: relative; margin-left: 210px;"></img>

                        <div class="div-contenedor-titulos-morado">
                            <div class="div-prog-morado"><a href="Javascript:tipoRegionProg('regioTipoProgBan','3')" style="color:white">Programas de Enseñanza Educativa<img src="img/mano1.png" style=" position: absolute; width: 3%;"></img></a> </div>
                            <div class="div-prog-morado" style="margin-left: 100px;"> <a href="Javascript:tipoRegionProg('regioTipoProgBan','2')" style="color:white" >Programas de Mobiliario y Equipo de Cómputo<img src="img/mano2.png" style="width: 3%; position: absolute;"></img></a> </div>
                            <div class="div-prog-morado" style="margin-left: 100px;"><a href="Javascript:tipoRegionProg('regioTipoProgBan','1')" style="color:white; " >Programas de Infraestructura<img src="img/mano3.png" style="width: 3%; position: absolute;"></img></a></div>
                        </div>







                        <!-- CONTENEDOR DE CUADROS GRISES DE PROGRAMAS -->

                        <div class="div-contenedor-gris">

                            <!-- CUADRO DE PROGRAMAS DE INFRAESTRUCTURA -->

                            <div class="div-prog-gris">
                                <div class="hoverflow-tab-prog">
                                 
                                        
                                      <s:if test="ListaRegioEECiclo.size()>0">
                                        <table id="customers1">
                                            <s:iterator value="ListaRegioEECiclo" id="ListaRegioEECiclo" status="stat">
                                                <tr>
                                                    <td style="text-align: left;"> <s:property value="DESCRIPCION_PROGRAMA"/></td>
                                                </tr>
                                            </s:iterator>   
                                        </table>
                                    </s:if>
                                    <s:else>
                                        <div class="error-sindatos">¡No hay información para mostrar!</div>
                                    </s:else>  
                                        
                                </div>
                            </div>



                            <!-- CUADRO DE PROGRAMAS DE MOBILIARIO Y EQUIPO DE COMPUTO -->

                            <div class="div-prog-gris">
                                <div class="hoverflow-tab-prog">
                                    <s:if test="ListaRegioECCiclo.size()>0">
                                        <table id="customers1">
                                            <s:iterator value="ListaRegioECCiclo" id="ListaRegioECiclo" status="stat">
                                                <tr>
                                                    <td style="text-align: left;"> <s:property value="DESCRIPCION_PROGRAMA"/></td>        
                                                </tr>
                                            </s:iterator> 
                                        </table>
                                    </s:if>
                                    <s:else>
                                        <div class="error-sindatos">¡No hay información para mostrar!</div>
                                    </s:else>
                                </div>
                            </div>

                            <!-- CUADRO DE PROGRAMAS DE ENSEÑANZA EDUCATIVA -->

                            <div class="div-prog-gris">
                                <div class="hoverflow-tab-prog">
                                      <s:if test="ListaRegioInfCiclo.size()>0">
                                        <table id="customers1">

                                            <s:iterator value="ListaRegioInfCiclo" id="ListaRegioInfCiclo" status="stat">
                                                <tr>

                                                    <td style="text-align: left;"> <s:property value="DESCRIPCION_PROGRAMA"/></td>
                                                </tr>
                                            </s:iterator> 

                                        </table>
                                    </s:if>
                                    <s:else>
                                        <div class="error-sindatos">¡No hay información para mostrar!</div>
                                    </s:else>
                                </div>
                            </div>
                        </div>
                        <!-- TERMINA CONTENEDOR DE CUADROS GRISES-->



                        <!-- TABLAS DE PROGRAMAS POR AÑO Y TIPO DE PROGRAMA -->


                        <!-- CONTENEDOR DE TABLAS -->
                        <div class="div-tablas-gris">

                            <s:if test="tipoProg1">   <!-- CONDICION PARA MOSTRAR TABLA -->
                                <s:if test="ListaRegioInf.size()>0">
                                    <div class="titulo-progras" style="text-align: left; margin-left: 10px;"><h3>Histórico de <strong style="color:#934493;">Programas de Infraestructura</strong> que han beneficiado al municipio </h3> </div>
                                    <div class="div-total-regio"><h3 style="margin: auto; color: black; font-size: 14px; text-align: center;">Total de recurso:   <s:property value="regioB.TOTALTIPOPROG"/></h3></div>

                                    <!-- CONTENEDOR DE TABLA DE INFRAESTRUCTURA -->
                                    <div class="div-cont-tab-tipo">
                                        <table id="customers2">
                                            <tr >
                                                <th>Ciclo Escolar  </th>
                                                <th>Nombre del Programa </th>
                                                <th>Escuelas Beneficiadas  </th>
                                               <!-- <th>Área Ejecutora  </th> --> 
                                                <th>Recursos </th>
                                            </tr>
                                            <s:iterator value="ListaRegioInf" id="ListaRegioInf" status="stat">
                                                <tr>

                                                    <td><s:property value="CICLO_PROGRAMA"/>  </td>
                                                    <td><s:property value="IDPROGRAMA"/>-<s:property value="DESCRIPCION_PROGRAMA"/>  </td>
                                                    <td><s:property value="NO_ESCUELAS"/>  </td>
                                                   <!-- <td><s:property value="AREA_EJECUTORA"/>  </td>  -->
                                                    <td><s:property value="RECURSOS"/>  </td>
                                                </tr>
                                            </s:iterator> 

                                        </table>
                                    </div>
                                </s:if>
                                <s:else>
                                    <div class="titulo-progras" style="text-align: left; margin-left: 10px;"><h3>Histórico de <strong style="color:#934493;">Programas de Infraestructura</strong> que han beneficiado al municipio </h3> </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <div class="error-sindatos">¡No hay información para mostrar!</div>
                                </s:else>
                            </s:if> 


                            <!-- TABLA DE MOVILIARIO Y EQUIPO DE COMPUTO-->   

                            <s:if test="tipoProg2">

                                <s:if test="ListaRegioEC.size()>0">
                                    <div class="titulo-progras" style="text-align: left; margin-left: 10px;"><h3>Histórico de <strong style="color:#934493;"> Programas de Mobiliario y Equipo de Cómputo</strong> que han beneficiado al municipio </h3> </div>
                                    <div class="div-total-regio"><h3 style="margin: auto; color: black; font-size: 14px; text-align: center;">Total de Recurso:<s:property value="regioB.TOTALTIPOPROGEC"/></h3></div>

                                    <!-- CONTENEDOR DE TABLA DE EQUIPO DE COMPUTO -->
                                    <div class="div-cont-tab-tipo">
                                        <table id="customers2">
                                            <tr >
                                                <th>Ciclo Escolar  </th>
                                                <th>Nombre del Programa </th>
                                                <th>Escuelas Beneficiadas  </th>
                                              <!--  <th>Área Ejecutora  </th> --> 
                                                <th>Recursos </th>
                                            </tr>
                                            <s:iterator value="ListaRegioEC" id="ListaRegioEC" status="stat">
                                                <tr>
                                                    <td><s:property value="CICLO_PROGRAMA"/>  </td>
                                                    <td><s:property value="IDPROGRAMA"/>-<s:property value="DESCRIPCION_PROGRAMA"/>  </td>
                                                    <td><s:property value="NO_ESCUELAS"/>  </td>
                                                   <!-- <td><s:property value="AREA_EJECUTORA"/>  </td> --> 
                                                    <td><s:property value="RECURSOS"/>  </td>
                                                </tr>
                                            </s:iterator> 

                                        </table>
                                    </div>
                                </s:if>
                                <s:else>
                                    <div class="titulo-progras" style="text-align: left; margin-left: 10px;"><h3>Histórico de <strong style="color:#934493;"> Programas de Mobiliario y Equipo de Cómputo </strong>que han beneficiado al municipio </h3> </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <div class="error-sindatos">¡No hay información para mostrar!</div>
                                </s:else>


                            </s:if>


                            <!-- TABLA DE PROGRAMAS DE ENSEÑANZA -->   

                            <s:if test="tipoProg3">
                                <s:if test="ListaRegioEE.size()>0">
                                    <div class="titulo-progras" style="text-align: left; margin-left: 10px;"><h3>Histórico de <strong style="color:#934493;">Programas de Enseñanza Educativa</strong> que han beneficiado al municipio </h3> </div>
                                    <div class="div-total-regio"><h3 style="margin: auto; color: black; font-size: 14px; text-align: center;">Total de Recurso:<s:property value="regioB.TOTALTIPOPROGEE"/></h3></div>
                                    <div class="div-cont-tab-tipo">
                                        <table id="customers2">
                                            <tr >
                                                <th>Ciclo Escolar  </th>
                                                <th>Nombre del Programa </th>
                                                <th>Escuelas Beneficiadas  </th>
                                               <!--  <th>Área Ejecutora  </th>  -->
                                                <th>Recursos </th>
                                            </tr>
                                            <s:iterator value="ListaRegioEE" id="ListaRegioEE" status="stat">
                                                <tr>
                                                    <td><s:property value="CICLO_PROGRAMA"/>  </td>
                                                    <td><s:property value="IDPROGRAMA"/>-<s:property value="DESCRIPCION_PROGRAMA"/>  </td>
                                                    <td><s:property value="NO_ESCUELAS"/>  </td>
                                                   <!-- <td><s:property value="AREA_EJECUTORA"/>  </td>  -->
                                                    <td><s:property value="RECURSOS"/>  </td>
                                                </tr>
                                            </s:iterator> 
                                        </table>
                                    </div>
                                </s:if>
                                <s:else>
                                    <div class="titulo-progras" style="text-align: left; margin-left: 10px;"><h3>Histórico de <strong style="color:#934493;">Programas de Enseñanza Educativa</strong> que han beneficiado al municipio </h3> </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <div class="error-sindatos">¡No hay información para mostrar!</div>
                                </s:else>

                            </s:if>


                        </div>   <!-- TERMINA CONTENEDOR DE TABLAS DE PROGRAMAS -->


                       
                    </div>   





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




                            <a href= "<s:property value="#myUrl1"/>" target="_blank"><div class="div_bottones2" id="pdf_descarga" style="margin-left: 130px;"><div class="img-prog-ind"><img src="img/pdf.png" alt="home" ></img></div><div class="text-prog-ind2" >Escuelas Beneficiadas</div> <div class="text-prog-ind2" >por Municipio</div> </div></a>
                            <a href= "<s:property value="#myUrl" />" target="_blank"  ><div class="div_bottones2" id="pdf_descarga" style="margin-left: 30px;"><div class="img-prog-ind" ><img src="img/pdf.png" alt="home" ></img></div><div class="text-prog-ind2">Información Municipio</div>  <div class="text-prog-ind2" >Seleccionado</div>   </div></a>
                        </div>

                        <!-- CAMPOS OCULTOS DE MANEJO DE APLICACIÓN-->
                        <s:textfield name="regioB.MUNICIPIO" id="mun" style='visibility:hidden' ></s:textfield>
                        <s:textfield name="regioB.NOMREGION" id="NOMREGION" style='visibility:hidden' ></s:textfield>
                        <s:textfield name="regioB.AUXTIPOPROG" id="AUXTIPOPROG"  style='visibility:hidden' ></s:textfield>
                        </div>



                        <!-- ITERACION DE OBJETOS LISTAS -->    


                    <s:iterator value="ListaRegioMun" id="ListaRegioMun" status="stat">
                        <s:hidden  name = "ListaRegioMun[%{#stat.index}].MUNICIPIO" id="MUNICIPIO"></s:hidden>
                        <s:hidden  name = "ListaRegioMun[%{#stat.index}].MATRICULA" id="MATRICULA"></s:hidden>
                        <s:hidden  name = "ListaRegioMun[%{#stat.index}].NO_DOCENTES" id="NO_DOCENTES"></s:hidden>
                        <s:hidden  name = "ListaRegioMun[%{#stat.index}].NO_ESCUELAS" id="NO_ESCUELAS"></s:hidden>
                    </s:iterator>

                    <s:hidden  name = "regioB.TOTALREGMATRICULA" id="regioB.TOTALREGMATRICULA"></s:hidden>
                    <s:hidden  name = "regioB.TOTALREGDOCENTES" id="regioB.TOTALREGDOCENTES"></s:hidden>
                    <s:hidden  name = "regioB.TOTALREGESCUELAS" id="regioB.TOTALREGESCUELAS"></s:hidden>

                    <s:hidden  name = "regioB.TOTALTIPOPROG" id="regioB.TOTALTIPOPROG"></s:hidden>
                    <s:hidden  name = "regioB.TOTALTIPOPROGEC" id="regioB.TOTALTIPOPROGEC"></s:hidden>
                    <s:hidden  name = "regioB.TOTALTIPOPROGEE" id="regioB.TOTALTIPOPROGEE"></s:hidden>

                    <s:textfield name="cat.CICLOAUX" id="cat.CICLOAUX" style='visibility:hidden'/>
                     <s:textfield name="regioB.CICLOAUX" id="regioB.CICLOAUX" style='visibility:hidden'/>

                    <s:textfield name="cat.OPCION" id="OPCION" style='visibility:hidden'></s:textfield>
                    <s:textfield name="cat.TIPO_PROGRAMA" id="TIPO_PROGRAMA"  style='visibility:hidden'></s:textfield>
                    <s:textfield name="cat.ID_PROGRAMA" id="ID_PROGRAMA"  style='visibility:hidden'></s:textfield>

                    <s:textfield name="regioB.IDREGION" id="IDREGION"  style='visibility:hidden'></s:textfield>
                    <s:textfield name="regioB.CLAVE_MUNICIPIO" id="cvemun"  style='visibility:hidden'></s:textfield>

                    <s:iterator value="ListaRegioGrafNiv" id="ListaRegioGrafNiv" status="stat">
                        <s:hidden  name = "ListaRegioGrafNiv[%{#stat.index}].CVENIV" id="CVENIV"></s:hidden>
                        <s:hidden  name = "ListaRegioGrafNiv[%{#stat.index}].NOMCVENIV" id="NOMCVENIV"></s:hidden>
                        <s:hidden  name = "ListaRegioGrafNiv[%{#stat.index}].TOTALNIV" id="TOTALNIV"></s:hidden>
                    </s:iterator>

                    <s:iterator value="ListaRegioInf" id="ListaRegioInf" status="stat">
                        <s:hidden  name = "ListaRegioInf[%{#stat.index}].CICLO_PROGRAMA" id="CICLO_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioInf[%{#stat.index}].IDPROGRAMA" id="IDPROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioInf[%{#stat.index}].DESCRIPCION_PROGRAMA" id="DESCRIPCION_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioInf[%{#stat.index}].NO_ESCUELAS" id="NO_ESCUELAS"></s:hidden>
                        <s:hidden  name = "ListaRegioInf[%{#stat.index}].AREA_EJECUTORA" id="AREA_EJECUTORA"></s:hidden>
                        <s:hidden  name = "ListaRegioInf[%{#stat.index}].RECURSOS" id="RECURSOS"></s:hidden>
                    </s:iterator> 

                    <s:iterator value="ListaRegioEC" id="ListaRegioEC" status="stat">
                        <s:hidden  name = "ListaRegioEC[%{#stat.index}].CICLO_PROGRAMA" id="CICLO_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioEC[%{#stat.index}].IDPROGRAMA" id="IDPROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioEC[%{#stat.index}].DESCRIPCION_PROGRAMA" id="DESCRIPCION_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioEC[%{#stat.index}].NO_ESCUELAS" id="NO_ESCUELAS"></s:hidden>
                        <s:hidden  name = "ListaRegioEC[%{#stat.index}].AREA_EJECUTORA" id="AREA_EJECUTORA"></s:hidden>
                        <s:hidden  name = "ListaRegioEC[%{#stat.index}].RECURSOS" id="RECURSOS"></s:hidden>
                    </s:iterator> 

                    <s:iterator value="ListaRegioEE" id="ListaRegioEE" status="stat">
                        <s:hidden  name = "ListaRegioEE[%{#stat.index}].CICLO_PROGRAMA" id="CICLO_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioEE[%{#stat.index}].IDPROGRAMA" id="IDPROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioEE[%{#stat.index}].DESCRIPCION_PROGRAMA" id="DESCRIPCION_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioEE[%{#stat.index}].NO_ESCUELAS" id="NO_ESCUELAS"></s:hidden>
                        <s:hidden  name = "ListaRegioEE[%{#stat.index}].AREA_EJECUTORA" id="AREA_EJECUTORA"></s:hidden>
                        <s:hidden  name = "ListaRegioEE[%{#stat.index}].RECURSOS" id="RECURSOS"></s:hidden>
                    </s:iterator> 
                    
                     <s:iterator value="ListaRegioInfCiclo" id="ListaRegioInfCiclo" status="stat">
                        <s:hidden  name = "ListaRegioInfCiclo[%{#stat.index}].CICLO_PROGRAMA" id="CICLO_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioInfCiclo[%{#stat.index}].IDPROGRAMA" id="IDPROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioInfCiclo[%{#stat.index}].DESCRIPCION_PROGRAMA" id="DESCRIPCION_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioInfCiclo[%{#stat.index}].NO_ESCUELAS" id="NO_ESCUELAS"></s:hidden>
                        <s:hidden  name = "ListaRegioInfCiclo[%{#stat.index}].AREA_EJECUTORA" id="AREA_EJECUTORA"></s:hidden>
                        <s:hidden  name = "ListaRegioInfCiclo[%{#stat.index}].RECURSOS" id="RECURSOS"></s:hidden>
                    </s:iterator> 

                    <s:iterator value="ListaRegioECCiclo" id="ListaRegioECCiclo" status="stat">
                        <s:hidden  name = "ListaRegioECCiclo[%{#stat.index}].CICLO_PROGRAMA" id="CICLO_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioECCiclo[%{#stat.index}].IDPROGRAMA" id="IDPROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioECCiclo[%{#stat.index}].DESCRIPCION_PROGRAMA" id="DESCRIPCION_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioECCiclo[%{#stat.index}].NO_ESCUELAS" id="NO_ESCUELAS"></s:hidden>
                        <s:hidden  name = "ListaRegioECCiclo[%{#stat.index}].AREA_EJECUTORA" id="AREA_EJECUTORA"></s:hidden>
                        <s:hidden  name = "ListaRegioECCiclo[%{#stat.index}].RECURSOS" id="RECURSOS"></s:hidden>
                    </s:iterator> 

                    <s:iterator value="ListaRegioEECiclo" id="ListaRegioEECiclo" status="stat">
                        <s:hidden  name = "ListaRegioEECiclo[%{#stat.index}].CICLO_PROGRAMA" id="CICLO_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioEECiclo[%{#stat.index}].IDPROGRAMA" id="IDPROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioEECiclo[%{#stat.index}].DESCRIPCION_PROGRAMA" id="DESCRIPCION_PROGRAMA"></s:hidden>
                        <s:hidden  name = "ListaRegioEECiclo[%{#stat.index}].NO_ESCUELAS" id="NO_ESCUELAS"></s:hidden>
                        <s:hidden  name = "ListaRegioEECiclo[%{#stat.index}].AREA_EJECUTORA" id="AREA_EJECUTORA"></s:hidden>
                        <s:hidden  name = "ListaRegioEECiclo[%{#stat.index}].RECURSOS" id="RECURSOS"></s:hidden>
                    </s:iterator> 


                </div>


            </section> 

        </s:form>


    </body>
    <div class="div-footer"> <h2 class="texto-footer">La información de este Tablero es de uso interno, para mas detalle favor de accesar a la página http://seduc.edomex.gob.mx/ <br>Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</h2> </div>

</html>
