<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>


<link href="<s:url value="css/style_progyapoyo.css"/>" media="all" rel="stylesheet" type="text/css"/> 

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
                    ['Genre', 'Estatal', 'Federalizado' ],

    <s:iterator value="ListaGrafNivelProg" id=" ListaGrafNivelProg" status="stat">
                    ['<s:property value="NOMBRE_NIVEL"/>', <s:property value="DATO_ESTATAL"/>, <s:property value="DATO_FEDERALIZADO"/>],

    </s:iterator>

                ]);

                // Set chart options 

                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.ColumnChart(document.getElementById('chart_div2'));
                function selectHandler() {
                    var selectedItem = chart.getSelection()[0];
                    if (selectedItem) {
                        var topping = data.getValue(selectedItem.row, 0);
                        window.location.assign(rutaGraficasOk + 'TipoD?topping=' + topping + '');
                    }
                }

                var options = {

                    legend: {position: 'top', maxLines: 3, legend: 'left'},
                    bar: {groupWidth: '70%'},

                    titleTextStyle: {
                        color: '#A4A4A4',
                        fontSize: 16,
                        fontName: 'Arial',

                    },

                    colors: ['#276c59', '#58bca6'],

                    animation: {
                        duration: 2500,
                        startup: true //This is the new option
                    },
                    bar: {groupWidth: '75%'},
                    isStacked: true,

                    textStyle: {
                        color: '#1b9e77',
                        fontSize: 20,
                        fontName: 'Arial',

                        italic: true
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
            ['Genre', '<s:property value="prog.NOMBRE_PROGRAMA_GRAFICA"/>', {role: 'style'}, {role: 'annotation'}],
    <s:iterator value=" ListaHistoricoProg" id=" ListaHistoricoProg" status="stat" >
            ['<s:property value="CICLO_ESCOLAR"/>', <s:property value="NO_ESCUELAS"/>, '<s:property value="ID_COLOR"/>', '<s:property value="NO_ESCUELAS"/>  '],

    </s:iterator>

        ]);

        // Set chart options 

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('graf_historia'));
        function selectHandler() {
            var selectedItem = chart.getSelection()[0];
            if (selectedItem) {
                var topping = data.getValue(selectedItem.row, 0);
                window.location.assign(rutaGraficasOk + 'TipoD?topping=' + topping + '');
            }
        }

        var options = {

            legend:  'none',
            bar: {groupWidth: '75%'},

            titleTextStyle: {
                color: '#A4A4A4',
                fontSize: 16,
                fontName: 'Arial',

            },

            colors: ['#dc831a', '#0b7f9f'],

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
            ['Genre', '<s:property value="prog.NOMBRE_PROGRAMA_GRAFICA"/>', {role: 'annotation'}, {role: 'style'}],
    <s:iterator value=" ListaGrafRegionProg" id=" ListaGrafRegionProg" status="stat">
            ['<s:property value="NOMBRE_REGION"/>',<s:property value="TOTAL_REGION"/>, '<s:property value="TOTAL_REGION"/>', '<s:property value="COLOR"/>'],
    </s:iterator>


        ]);

        // Set chart options 

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('graf_region'));
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
        
        <s:iterator value="ListaGrafNacionalProg" id="ListaGrafNacionalProg" status="stat">
       
            <s:if test="CVEESTADO==15">
                var colorF='stroke-color: #94c741; stroke-opacity: 0.6; stroke-width: 8; fill-color: #94c741; fill-opacity: 0.2; fontSize: 18;';
            </s:if>
            <s:else>
                var colorA='#7F3390';
            </s:else>
        
    </s:iterator>
        
        
        
        var data = google.visualization.arrayToDataTable([
            ['Year', '<s:property value="prog.NOMBRE_PROGRAMA_GRAFICA"/>', {role: 'annotation'}, {role: 'style'}],
    <s:iterator value="ListaGrafNacionalProg" id="ListaGrafNacionalProg" status="stat">
       
       
    ['<s:property value="NOMBRE_ESTADO"/>', <s:property value="NO_ESCUELAS"/>, '<s:property value="NO_ESCUELAS"/>',<s:if test="CVEESTADO==15">colorF</s:if> <s:else>colorA</s:else> ],
    </s:iterator>  ]);

        // Set chart options 

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('graf_nacional'));
        function selectHandler() {
            var selectedItem = chart.getSelection()[0];
            if (selectedItem) {
                var topping = data.getValue(selectedItem.row, 0);
                window.location.assign(rutaGraficasOk + 'TipoD?topping=' + topping + '');
            }
        }

        var options = {

            bar: {groupWidth: '75%'},

            legend: 'none',
            hAxis: {      slantedTextAngle:90 , fontSize: 10     },
           

            titleTextStyle: {
                color: '#A4A4A4',
                fontSize: 10,
                fontName: 'Arial',

            },
            chartArea: {
   top: 30,
   height: '60%' ,
  width:'90%'
   
},

            animation: {
                duration: 2500,
                startup: true //This is the new option
            },

            
            annotations: {
                textStyle: {

                    fontSize: 11,

                    // The color of the text.
                    color: '#FFFFFF'
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
           <div class="div_logom" ><img src="img/logom.png" alt="Logo de identidad"/></div>
            <header id="main-header">

                <nav>

                </nav><!-- / nav -->

            </header><!-- / #main-header -->


            <section id="main-content">



                <div class="div_cont">
                    <aside>
                        <s:if test='cat.TIPO_PROGRAMA=="E"' >
                        
                        <div class="div-tipo-prog" id="inver_prog"> Programas Estatales Vigentes</div>
                        
                        </s:if>
                         <s:if test='cat.TIPO_PROGRAMA=="F"' >
                        
                             <div class="div-tipo-prog" id="municipio_prog"> Programas Federales Vigentes</div>
                        
                        </s:if>
                         <s:if test='cat.TIPO_PROGRAMA=="C"' >
                        
                             <div class="div-tipo-prog" id="alumno_prog"> Programas Concluidos</div>
                        
                        </s:if>
                        
                        
                        
                        <a href="Javascript:guarda('inicio')"> <img src="img/home.png" alt="home" class="home"></img></a>
                        <div class="menu-prog">

                            <nav class="nav_botones">
                                <ul class="ul-boton" >
                                    <s:iterator value=" ListaMenuProg" id=" ListaMenuProg" status="stat">
                                        <li><a href="Javascript:tipoProg('programaSelect','<s:property value="ID_PROGRAMA"/>')"><div class="div_ul_prog" <s:if test="ID_PROGRAMA==cat.ID_PROGRAMA"> style="color:  white; background: #666; border-radius: 20px 0px 20px 0px; box-shadow: 2px 4px 12px #666;"</s:if>  > <s:property value="NOMBRE_PROGRAMA"/></div></a></li>
                                        </s:iterator>

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

                    <div class="titulo-progras"><h3 style="margin-top: 15px;"><s:property value="prog.NOMBRE_PROGRAMA"/></h3> </div>

                    <div class="menu-botones">




                       <div class="div_bottones" id="alumno_prog"><div class="img-prog-ind"><img src="img/recursos.png" alt="home" ></img></div><div class="text-prog-ind"> Alumnos </div> <div class="text-prog-ind" id="letra17" > <s:property value="prog.NO_ALUMNOS"/></div></div>

                        <div class="div_bottones" id="escuela_prog"><div class="img-prog-ind" ><img src="img/escprog.png" alt="home" ></img></div><div class="text-prog-ind"> Escuelas </div> <div class="text-prog-ind" id="letra17"> <s:property value="prog.NO_ESC_PROG"/> </div></div>

                        <div class="div_bottones" id="municipio_prog"><div class="img-prog-ind"><img src="img/munprog.png" alt="home" ></img></div><div class="text-prog-ind"> Municipios </div> <div class="text-prog-ind" id="letra17"> <s:property value="prog.MUNICIPIOS"/> </div></div>

                       <div class="div_bottones" id="inver_prog"><div class="img-prog-ind"><img src="img/inverprog.png" alt="home" ></img></div><div class="text-prog-ind"> Inversión </div> <div class="text-prog-ind" id="letra17"> <s:property value="prog.INVERSION"/> </div></div>









                    </div>

                    <div class="contenedor-graf">


                        <!-- Inicia Articulo 1 --> 
                        <article class="article1">
                            <div class="div_sec1">


                                <p>
                                    <Strong>Objetivo:</Strong> <s:property value="desprg.OBJETIVO_CORTO"/><br><Strong>Alcance:</Strong> <s:property value="desprg.ALCANCE_CORTO"/>
                                                <br><Strong>Nota:</Strong> <s:property value="prog.NOTA"/>
                                                </p>
                                                <a href="#popup" style="text-decoration: none;" > <h4 class="link">Ver más...</h4></a>


                                                </div>

                                                <div class="div_sec1">
                                                    <div class="titulo-progras"><h3>Histórico de aplicación del programa</h3></div>
                                                   
                                                    
                                                    <s:if test=" ListaHistoricoProg.size()>0">
                                                        <div id="graf_historia" style="margin: auto; width: 90%; height: 300px; margin-bottom: 20px;" ></div>
                                                    <div class="anotacion-progras"><h3><s:property value="desprg.DESCRIPCION_HISTORICO"/></h3></div>

                                                         </s:if>
                                                        <s:else>
                                                            <div  class="mensaje-error" style="height: 300px;" >¡No hay datos que mostrar!</div> 
                                                    
                                                        </s:else>
                                                   

                                                </div>



                                    <div class="div_sec1" style="height: 415px;">
                                                    <div class="titulo-progras"><h3>Por Municipio</h3></div>
                                                    <s:if test="ListaGrafMunicipioProg.size()>0">
                                                        <div class="hoverflow-tab-mun">

                                                            <table id="customers">
                                                                <tr>
                                                                    <th>No</th>
                                                                    <th>Municipio</th>
                                                                    <th>Total de Escuelas</th>

                                                                </tr>
                                                                <s:iterator value=" ListaGrafMunicipioProg" id=" ListaGrafMunicipioProg" status="stat">
                                                                    <tr>
                                                                        <td><s:property value="CVEMUNICIPIO"/></td>
                                                                        <td><s:property value="NOMBRE_MUNICIPIO"/></td>
                                                                        <td><s:property value="TOTAL_MUNICIPIO"/></td>

                                                                    </tr>
                                                                </s:iterator>


                                                            </table>

                                                        </div>

                                                    <div class="anotacion-progras"><h3><s:property value="desprg.DESCRIPCION_MUNICIPIO"/></h3></div>
                                                    
                                                    
                                                        </s:if>
                                                        <s:else>
                                                            <div  class="mensaje-error" style="height: 250px;" >¡No hay datos que mostrar!</div> 
                                                    
                                                        </s:else>
                                                    
                                                </div>

                                                </article> 

                                                <article class="article2"> 

                                                    <div class="div_sec1">
                                                        <div class="titulo-progras"><h3>Escuelas Beneficiadas por Nivel Educativo</h3></div>
                                                        
                                                        
                                                        <s:if test="ListaGrafNivelProg.size()>0">
                                                        
                                                        <div id="chart_div2" style="margin: auto; width: 90%; height: 320px; margin-bottom: 20px;" ></div>
                                                        
                                                         
                                                        <table id="customers1">
                                                            <tr>
                                                                <th>Subsistema</th>
                                                                    <s:iterator value="ListaGrafNivelProg" id=" ListaGrafNivelProg" status="stat">
                                                                    <th><s:property value="NOMBRE_NIVEL"/></th>
                                                                    </s:iterator>

                                                            </tr>
                                                            <tr>
                                                                <td>Estatal</td>
                                                                <s:iterator value="ListaGrafNivelProg" id=" ListaGrafNivelProg" status="stat">
                                                                    <td><s:property value="DATO_ESTATAL"/></td>
                                                                </s:iterator>

                                                            </tr>
                                                            <tr>
                                                                <td>Federalizado</td>
                                                                <s:iterator value="ListaGrafNivelProg" id=" ListaGrafNivelProg" status="stat">
                                                                    <td><s:property value="DATO_FEDERALIZADO"/></td>
                                                                </s:iterator>
                                                            </tr>

                                                        </table>
                                                        

                                                        <div class="anotacion-progras"><h3><s:property value="desprg.DESCRIPCION_NIVEL"/></h3></div>
                                                       
                                                         </s:if>
                                                        <s:else>
                                                            <div  class="mensaje-error"  style="height: 450px;">¡No hay datos que mostrar!</div> 
                                                        </s:else>
                                                        <br>   

                                                    </div>

                                                    <div class="div_sec1">
                                                        <div class="titulo-progras" id="ajusta-region"><h3>Por Región</h3></div>
                                                        <s:if test=" ListaGrafRegionProg.size()>0">
                                                        <div id="graf_region" style="margin: auto; width: 90%; height: 380px; margin-bottom: 42px;" ></div>
                                                        <div class="anotacion-progras"><h3><s:property value="desprg.DESCRIPCION_REGION"/></h3></div>
                                                        </s:if>
                                                        <s:else>
                                                            <div  class="mensaje-error" style="height: 370px;" >¡No hay datos que mostrar!</div> 
                                                        </s:else>
                                                    </div>
                                                </article> 







                                                </div>   
                                                <div class="grafica-grande"> 


                                                    <div class="contenedor-graf-prin" > 
                                                        <div class="titulo-progras"><h3><br>Nivel Nacional</h3></div>
                                                        
                                                        <s:if test=" ListaGrafNacionalProg.size()>0">
                                                        <div id="graf_nacional" style="margin: auto; width: 95%; height: 280px; margin-bottom: 20px; margin-top: 20px; padding: 20px;" ></div>

                                                        <div class="anotacion-progras"><h3><s:property value="desprg.DESCRIPCION_NACIONAL"/></h3></div>
                                                        </s:if>
                                                         <s:else>
                                                            <div  class="mensaje-error" >¡No hay datos que mostrar!</div> 
                                                        </s:else>
                                                    </div>
                                                    

                                                        <div class="menu-botones" style="margin-top: 20px;">
                                                            
                                                            <s:url action="GeneraPdf" id="myUrl" escapeAmp="false">

                                                                 <s:param name="TipoReporte" value="'ProgramasListado.jasper'"/>
                                                                 <s:param name="IDPROGRAMA" value="cat.ID_PROGRAMA"/>
                                                                 <s:param name="esExcel" value="'false'"/>
                                                                 <s:param name="esPDF" value="'true'"/>            

                                                            </s:url> 


                                                            <s:url action="GeneraPdf" id="myUrl1" escapeAmp="false">

                                                                 <s:param name="TipoReporte" value="'ReportePrograma.jasper'"/>
                                                                 <s:param name="IdPrograma" value="cat.ID_PROGRAMA"/>
                                                                 <s:param name="CicloEscolar" value="cat.CICLOAUX"/>
                                                                 <s:param name="esExcel" value="'false'"/>
                                                                 <s:param name="esPDF" value="'true'"/>            

                                                            </s:url> 

                                                        <a href= "<s:property value="myUrl"/>" target="_blank"><div class="div_bottones2" id="pdf_descarga"><div class="img-prog-ind"><img src="img/pdf.png" alt="home" ></img></div><div class="text-prog-ind2" >Listado de</div> <div class="text-prog-ind2" >Escuelas participantes</div> </div></a>

                                                        <a href= "<s:property value="myUrl1"/>" target="_blank" ><div class="div_bottones2" id="pdf_descarga"><div class="img-prog-ind" ><img src="img/pdf.png" alt="home" ></img></div><div class="text-prog-ind2">Información</div>  <div class="text-prog-ind2" >del Programa</div>   </div></a>

                                                        <a href= "<s:property value="desprg.REGLAS_DOC"/>" target="_blank"><div class="div_bottones2" id="pdf_descarga_reglas" ><div class="img-prog-ind" ><img src="img/pdf.png" alt="home" ></img></div><div class="text-prog-ind2">Reglas de Operación</div>  <div class="text-prog-ind2" >del Programa</div>   </div></a>



                                                    </div>
                                                         <div style="float: right; margin-right: 50px; "><h7>Fuente: Niveles Educativos</h7></div>

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

                                                        <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >
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
                                                            </div>
                                                            
                                                        <a class="popup-cerrar" href="#">X</a>
                                                    </div>
                                                </div>

                                                </section> <!-- / #main-content -->

                                            </s:form>

                                                <div class="div-footer"> <h2 class="texto-footer" style="margin-top: 20px;">La información de este Tablero es de uso interno, para mas detalle favor de accesar a la página http://seduc.edomex.gob.mx/ <br>Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</h2> </div>

                                            </body>
                       </html>
