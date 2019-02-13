<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<link href="<s:url value="css/style_busqueda_cct.css"/>" media="all" rel="stylesheet" type="text/css"/> 

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

        document.forma.AUXTIPOPROG.value = valor;
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
                    <!-- MENU DE NAVEGACION --><a href="Javascript:guarda('inicio')"> <img src="img/home.png" alt="home" class="home"></img></a>


                    <!-- TERMINA NAVEGACION -->



                    <div class="titulo-progras" style="text-align: left; margin-left: 120px; "><h3>Busqueda por CCT:   <s:textfield name="busquedaCCT.BUSCAR_CCT" id="BUSCAR_CCT" cssStyle="margin-left: 5px; margin-top:0px; border-radius: 15px; height: 20px; font-size: 14px;  text-align:center; position:absolute ; width: 140px;"/> <div style="background: orange; border-radius: 8px; height: 30px; width: 30px; position: absolute; margin-left: 300px; margin-top: -30px;"><a href="Javascript:guarda('busquedaCCT')"><img src="img/buscarico.png" style="position: absolute; width: 28px;" ></img></a></div></h3></div>

                    <s:if test="errorFormato">

                        <div style="width: 670px;  text-align: center; margin-top: -52px; position: absolute; ">
                            <h7 style="text-align: center; color: gray; font-size: 14px; " >Formato no valido</h7>
                        </div> 

                    </s:if>

                    <s:if test="errorNoEncontrado">

                        <div style="width: 670px;  text-align: center; margin-top: -52px; position: absolute; ">
                            <h7 style="text-align: center; color:gray; font-size: 14px; " >No hay información de la CCT</h7>
                        </div> 

                    </s:if>
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



                        <!-- INICIA ARTICULO 2 -->

                        <article class="article2"> 
                            <div class="div_sec1">

                                <div class="titulo-progras" style="" ><h3>Información de la Escuela: <s:property value="busquedaCCT.NOMBRE_ESCUELA"></s:property></h3></div>

                                    <div class="div_indicadores_cct">
                                        <img src="img/lapiz.png" style="margin-top: 30px; position: absolute; margin-left: 20px"></img>
                                        <div style="width:250px; height: 30px;  margin-left:100px; margin-top: 10px; position: absolute; text-align: center; "><h4><strong style="color: black;">CCT:</strong > <s:property value="busquedaCCT.CCT"></s:property></h4></div>
                                    <div style="width:250px; height: 30px;  margin-left:100px; margin-top: 40px; position: absolute; text-align: center; "><table style="width: 95%; height: 30px;"> <tr> <td style="border-right: 1px solid black;"> <h4 style="margin-top: 0px;"><s:property value="busquedaCCT.NIVEL"></s:property></h4></td>    <td><h4 style="margin-top: 0px;"><s:property value="busquedaCCT.VERTIENTE"></s:property></h4></td>    </tr></table></div>
                                    <div style="width:250px; height: 30px;  margin-left:100px; margin-top: 75px; position: absolute; text-align: center; "><h4><s:property value="busquedaCCT.TURNO"></s:property></h4></div>
                                        <div style="width: 28%; height: 2px; background:  orange; position: absolute; margin: auto; margin-left: 30px; margin-top: 130px; box-shadow: 5px 5px 10px #333"></div>

                                    </div>
                                    <div class="div_indicadores_cct">
                                        <a href="#popup" style="text-decoration: none;" >  <img src="img/mano3.png" style="width: 25px; z-index: 1; margin-left: 40px; position: absolute; margin-top: 48px;"></img>  <img src="img/localiza.png"  style="margin-top: 30px; position: absolute ; margin-left: 20px;"></img></a>
                                        <div style="width:250px; height: 20px;  margin-left:100px; margin-top: 10px; position: absolute; text-align: center; "><h4><strong style="color: black; font-weight:bold;">MUNICIPIO:</strong></h4></div>
                                        <div style="width:250px; height: 20px;  margin-left:100px; margin-top: 30px; position: absolute; text-align: center; "><h4 style="color: #666;"><s:property value="busquedaCCT.MUNICIPIO"></s:property></h4></div>
                                        <div style="width:250px; height: 30px;  margin-left:100px; margin-top: 50px; position: absolute; text-align: center; "><h4><strong style="color: black; font-weight:bold;">LOCALIDAD:</strong></h4></div>
                                        <div style="width:250px; height: 30px;  margin-left:100px; margin-top: 70px; position: absolute; text-align: center; line-height: 1; "><h4 style="color: #666;"><s:property value="busquedaCCT.LOCALIDAD"></s:property></h4></div>

                                        <div style="width: 28%; height: 2px; background:  orange; position: absolute; margin: auto; margin-left: 30px; margin-top: 130px; box-shadow: 5px 5px 10px #333"></div>

                                    </div>
                                    <div class="div_indicadores_cct">
                                        <div><img src="img/matindica.png" style="margin-top: 30px; position: absolute; margin-left: 20px;"></img></div>
                                        <div><img src="img/mujerlogo.png" style="margin-top: 30px; position: absolute; margin-left: 55px;"></img></div>

                                        <div style="width:250px; height: 30px;  margin-left:100px; margin-top: 10px; position: absolute; text-align: center; "><h4><strong style="color: black;">MATRICULA:</strong> <strong style="font-size: 14px; color: #666;"> <s:property value="busquedaCCT.MATRICULA"></s:property></strong></h4></div>
                                    <div style="width:250px; height: 30px;  margin-left:100px; margin-top: 40px; position: absolute; text-align: center; "><h4><strong style="color: black;">DOCENTES:</strong> <strong style="font-size: 14px; color: #666;"><s:property value="busquedaCCT.NO_DOCENTES"></s:property></strong></h4></div>
                                    <s:if test="ListaResultadosPlanea.size()==2"> <div style="width:250px; height: 30px;  margin-left:100px; margin-top: 70px; position: absolute; text-align: center; "><a href="#popup2"><div style="width: 200px; height: 30px; background: #cccccc; border-radius: 10px; margin-left: 15px; box-shadow: 5px 5px 10px #666; "><h4 style="margin-top: 15px; padding: 5px;">GRÁFICA DE RESULTADOS <img src="img/mano3.png" style="width: 25px; z-index: 1; margin-left: 5px; position: absolute; margin-top: 10px;"></img></a></div> </h4></div>

                                    </s:if>
                                        <div style="width: 28%; height: 2px; background:  orange; position: absolute; margin: auto; margin-left: 30px; margin-top: 130px; box-shadow: 5px 5px 10px #333"></div>


                                    </div>
                                        
                                        
                                          <div style="margin: auto; ">
                                            
                                            
                                            
                                            <table style="width:98% ; position: relative; margin: auto; border: 1px solid white; text-align: center;"  >
                                            <tr>
                                                <td  colspan="2"  style="width: 10%;"> <div style="position: absolute; margin-top: -10px; font-size: 25px; margin-left: 20px; width: 88px; background: #333; color: white; border-radius: 10px; height: 47px; " > PLANEA </div></td>
                                                 
                                                <td colspan="4" style="width: 45%;" ><div style="width: 100%; height: 25px; background:  #6c3483 ; color:white; border-radius: 10px 10px 0px 0px; margin: auto;">Lenguaje y Comunicación</div></td>
                                                <td colspan="4"  style="width: 45%;"><div style="width: 100%; height: 25px; background: purple; color:white; border-radius: 10px 10px 0px 0px; margin: auto;">Matemáticas</div></td>
                                                
                                            </tr>
                                            
                                                
                                                <tr style="font-size: 12px;">
                                                 <td style="width: 10%;" colspan="2"></td>
                                              
                                                 <td style="width: 11.25%;"><div style="background:    #76448a  ; width: 100%; height: 20px; margin: auto; color:white; border-radius: 0px 0px 0px 10px; ">Insuficiente I</div></td>
                                                <td style="width: 11.25%;" ><div style="background:    #76448a  ; width: 100%; height: 20px; margin: auto; color:white;  ">Básico II</div></td>
                                                <td style="width: 11.25%;"><div style="background:    #76448a  ; width: 100%; height: 20px; margin: auto; color:white;  ">Satisfactorio III</div></td>
                                                <td style="width: 11.25%;" ><div style="background:    #76448a  ; width: 100%; height: 20px; margin: auto; color:white; border-radius: 0px 0px 10px 0px;   ">Sobresaliente IV</div></td>
                                                <td style="width: 11.25%;" ><div style="background:    purple  ; width: 100%; height: 20px; margin: auto; color:white; border-radius: 0px 0px 0px 10px; ">Insuficiente I</div></td>
                                                <td style="width: 11.25%;" ><div style="background:    purple  ; width: 100%; height: 20px; margin: auto; color:white;  ">Básico II</div></td>
                                                <td style="width: 11.25%;" ><div style="background:    purple  ; width: 100%; height: 20px; margin: auto; color:white;  ">Satisfactorio III</div></td>
                                                <td style="width: 11.25%;" ><div style="background:    purple  ; width: 100%; height: 20px; margin: auto; color:white; border-radius: 0px 0px 10px 0px; ">Sobresaliente IV</div></td>
                                            </tr>
                                            
                                            <s:iterator value="ListaResultadosPlanea" id="ListaResultadosPlanea" status="stat">   
                                             <tr style="font-size: 12px; background: #d8aac3">
                                                 <td style="width: 10%; background: #f7f7f7;" colspan="2"><div style=" ; width: 80%; height: 20px; margin: auto;  border-radius: 0px 10px 10px 0px; background: #d30f7c; color:white; float: right; "><s:property value="CICLO_ESCOLAR" /></div></td>
                                              
                                                 <td style="width: 11.25%;"><div style=" ; width: 100%; height: 20px; margin: auto;  border-radius: 0px 0px 0px 10px; "><s:property value="LC_I" />%</div></td>
                                                <td style="width: 11.25%;" ><div style="       width: 100%; height: 20px; margin: auto;   "><s:property value="LC_II" />%</div></td>
                                                <td style="width: 11.25%;"><div style="       width: 100%; height: 20px; margin: auto;   "><s:property value="LC_III" />%</div></td>
                                                <td style="width: 11.25%;" ><div style="       width: 100%; height: 20px; margin: auto;  border-radius: 0px 0px 10px 0px;   "><s:property value="LC_IV" />% <s:if test="MAYOR==1"><img src="img/flecha_v.gif" style="width: 25px; margin-top: 5px; float: right; position: absolute; margin-left: 20px;"  /></s:if> <s:if test="MAYOR==2"><img src="img/flecha_r.gif" style="width: 25px; margin-top: 5px; float: right; position: absolute; margin-left: 20px; border-radius: 50%; -moz-transform: rotate(-180deg);     -o-transform: rotate(-180deg);     -webkit-transform: rotate(-180deg);     transform: rotate(-180deg);"</s:if> </div></td>
                                                <td style="width: 11.25%;" ><div style="       width: 100%; height: 20px; margin: auto;   background: #edc4f1; "><s:property value="M_I" />%</div></td>
                                                <td style="width: 11.25%;" ><div style="       width: 100%; height: 20px; margin: auto; background: #edc4f1;  "><s:property value="M_II" />%</div></td>
                                                <td style="width: 11.25%;" ><div style="       width: 100%; height: 20px; margin: auto;  background: #edc4f1;  "><s:property value="M_III" />%</div></td>
                                                <td style="width: 11.25%;" ><div style="       width: 100%; height: 20px; margin: auto; background: #edc4f1;  "><s:property value="M_IV" />%<s:if test="MAYOR_M==1"><img src="img/flecha_v.gif" style="width: 25px; margin-top: 5px; float: right; position: absolute; margin-left: 20px;"  /></s:if> <s:if test="MAYOR_M==2"><img src="img/flecha_r.gif" style="width: 25px; margin-top: 5px; float: right; position: absolute; margin-left: 20px; border-radius: 50%; -moz-transform: rotate(-180deg);     -o-transform: rotate(-180deg);     -webkit-transform: rotate(-180deg);     transform: rotate(-180deg);"</s:if> </div></td>
                                            </tr>
                                             </s:iterator>
                                             
                                             
                                               
                                            
                                            
                                        </table>    
                                             
                                              
                                              <table style="width: 100%; margin: auto; margin-top: 10px;">
                                                  <tr>
                                                      <td><img src="img/flecha_v.gif" style="width: 25px; margin-left: 50px;"></img></td>
                                                      <td>Mejoró el % de nivel de logro sobresaliente, de un ciclo escolar a otro.</td>
                                                      <td><img src="img/flecha_r.gif" style="margin-left: 50px; width: 25px; -moz-transform: rotate(180deg);    -o-transform: rotate(180deg);     -webkit-transform: rotate(180deg);     transform: rotate(180deg);"></img></td>
                                                      <td>Empeoró el % de nivel de logro sobresaliente, de un ciclo escolar a otro.</td>
                                                  </tr>
                                                 

                                              </table>
                                            
                                        </div>       
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        

                                </div>


                            </article> 


                                       
                                        
                                      
                                        
                                        
                                        
                                        
                                        
                                        
                                        

                            <div class="titulo-progras"><h3>Concentrado de Programas <strong style="color:#934493;">VIGENTES</strong> durante el Ciclo Escolar <s:property value="cat.CICLOAUX"/> </h3> </div>
                        <img src="img/churronaranja.png" alt="Imagen Morada" id="img-centrar" style="margin-top: 40px; position: relative; margin-left: 210px;"></img>

                        <div class="div-contenedor-titulos-morado">
                            <div class="div-prog-morado"><a href="Javascript:tipoProg('busquedaCCT','3')" style="color:white">Programas de Enseñanza Educativa<img src="img/mano3.png" style=" position: absolute; width: 3%;"></img></a> </div>
                            <div class="div-prog-morado" style="margin-left: 120px;"> <a href="Javascript:tipoProg('busquedaCCT','2')" style="color:white" >Programas de Mobiliario y Equipo de Cómputo<img src="img/mano2.png" style="width: 3%; position: absolute;"></img></a> </div>
                            <div class="div-prog-morado" style="margin-left: 120px;"><a href="Javascript:tipoProg('busquedaCCT','1')" style="color:white; " >Programas de Infraestructura<img src="img/mano3.png" style="width: 3%; position: absolute;"></img></a></div>
                        </div>







                        <!-- CONTENEDOR DE CUADROS GRISES DE PROGRAMAS -->

                        <div class="div-contenedor-gris">

                            <!-- CUADRO DE PROGRAMAS DE INFRAESTRUCTURA -->

                            <div class="div-prog-gris">
                                <div class="hoverflow-tab-prog">


                                    <s:if test="ListaProgVigentesEECCT.size()>0">
                                        <table id="customers1">
                                            <s:iterator value="ListaProgVigentesEECCT" id="ListaProgVigentesEECCT" status="stat">
                                                <tr>
                                                    <td style="text-align: left;"> <s:property value="DESC_PROG"/></td>
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
                                    <s:if test="ListaProgVigentesMECCT.size()>0">
                                        <table id="customers1">
                                            <s:iterator value="ListaProgVigentesMECCT" id="ListaProgVigentesMECCT" status="stat">
                                                <tr>
                                                    <td style="text-align: left;"> <s:property value="DESC_PROG"/></td>        
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
                                    <s:if test="ListaProgVigentesIFCCT.size()>0">
                                        <table id="customers1">

                                            <s:iterator value="ListaProgVigentesIFCCT" id="ListaProgVigentesIFCCT" status="stat">
                                                <tr>

                                                    <td style="text-align: left;"> <s:property value="DESC_PROG"/></td>
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

                        

                            <s:if test="tipoProg3">   <!-- CONDICION PARA MOSTRAR TABLA -->
                                <s:if test="ListaProgTodosEECCT.size()>0">
                                    <div class="titulo-progras" style=" text-align: left; margin-left: 120px;"><h3>Histórico de <strong style="color:#934493;">Programas de Enseñanza Educativa</strong>  </h3> </div>
                                   
                                    <!-- CONTENEDOR DE TABLA DE INFRAESTRUCTURA -->
                                    <div class="div-tablas-gris">
                                        
                                    <div class="div-total-regio"><h3 style="margin: auto; color: black; font-size: 14px; text-align: center;">Total de recurso:   <s:property value="regioB.TOTALTIPOPROGEE"/></h3></div>
                                    <div class="div-cont-tab-tipo">
                                        <table id="customers2">
                                            <tr >
                                                <th>Ciclo Escolar  </th>
                                                <th>Nombre del Programa </th>
                                                <th>Concepto  </th>
                                                <th>Recursos </th>
                                            </tr>
                                            <s:iterator value="ListaProgTodosEECCT" id="ListaProgTodosEECCT" status="stat">
                                                <tr>

                                                    <td><s:property value="CICLOESCOLAR"/>  </td>
                                                    <td><s:property value="IDPROGRAMA"/>-<s:property value="DESC_PROG"/>  </td>
                                                    <td> <s:property value="CONCEPTO"/>  </td>  
                                                    <td><s:property value="MONTO"/>  </td>
                                                </tr>
                                            </s:iterator> 

                                        </table>
                                    </div>
                                    </div>    
                                </s:if>
                                <s:else>
                                    <div class="titulo-progras" style="text-align: left; margin-left: 120px;;"><h3>Histórico de <strong style="color:#934493;">Programas de Enseñanza Educativa</strong> </h3> </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <div class="error-sindatos">¡No hay información para mostrar!</div>
                                </s:else>
                            </s:if> 


                            <!-- TABLA DE MOVILIARIO Y EQUIPO DE COMPUTO-->   

                            <s:if test="tipoProg2">

                                <s:if test="ListaProgTodosMECCT.size()>0">
                                    <div class="titulo-progras" style="text-align: left; margin-left: 120px;"><h3>Histórico de <strong style="color:#934493;"> Programas de Mobiliario y Equipo de Cómputo</strong> </h3> </div>
                                    
                                    <!-- CONTENEDOR DE TABLA DE EQUIPO DE COMPUTO -->
                                    <div class="div-tablas-gris">
                                        
                                    <div class="div-total-regio"><h3 style="margin: auto; color: black; font-size: 14px; text-align: center;">Total de Recurso:<s:property value="regioB.TOTALTIPOPROGEC"/></h3></div>    
                                    <div class="div-cont-tab-tipo">
                                        <table id="customers2">
                                            <tr >
                                                <th>Ciclo Escolar  </th>
                                                <th>Nombre del Programa </th>                        
                                                <th>Concepto </th> 
                                                <th>Recursos </th>
                                            </tr>
                                            <s:iterator value="ListaProgTodosMECCT" id="ListaProgTodosMECCT" status="stat">
                                                <tr>

                                                    <td><s:property value="CICLOESCOLAR"/>  </td>
                                                    <td><s:property value="IDPROGRAMA"/>-<s:property value="DESC_PROG"/>  </td>
                                                    <td><s:property value="CONCEPTO"/>  </td>  
                                                    <td><s:property value="MONTO"/>  </td>
                                                </tr>
                                            </s:iterator> 

                                        </table>
                                    </div>
                                    </div>    
                                </s:if>
                                <s:else>
                                    <div class="titulo-progras" style="text-align: left; margin-left: 120px;"><h3>Histórico de <strong style="color:#934493;"> Programas de Mobiliario y Equipo de Cómputo </strong></h3> </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <div class="error-sindatos">¡No hay información para mostrar!</div>
                                </s:else>


                            </s:if>


                            <!-- TABLA DE PROGRAMAS DE ENSEÑANZA -->   

                            <s:if test="tipoProg1">
                                <s:if test="ListaProgTodosIFCCT.size()>0">
                                    <div class="titulo-progras" style="text-align: left; margin-left: 120px;"><h3>Histórico de <strong style="color:#934493;">Programas de Infraestructura</strong> </h3> </div>
                                                                        <div class="div-tablas-gris">
                                    <div class="div-cont-tab-tipo">
                                        <div class="div-total-regio"><h3 style="margin: auto; color: black; font-size: 14px; text-align: center;">Total de Recurso:<s:property value="regioB.TOTALTIPOPROG"/></h3></div>
                                        <table id="customers2">
                                            <tr >
                                                <th>Ciclo Escolar  </th>
                                                <th>Nombre del Programa </th>
                                                <th>Concepto </th>  
                                                <th>Recursos </th>
                                            </tr>
                                            <s:iterator value="ListaProgTodosIFCCT" id="ListaProgTodosIFCCT" status="stat">
                                                <tr>

                                                    <td><s:property value="CICLOESCOLAR"/>  </td>
                                                    <td><s:property value="IDPROGRAMA"/>-<s:property value="DESC_PROG"/>  </td>

                                                    <td><s:property value="CONCEPTO"/>  </td> 
                                                    <td><s:property value="MONTO"/>  </td>
                                                </tr>
                                            </s:iterator> 
                                        </table>
                                    </div>
                                    </div>    
                                </s:if>
                                <s:else>
                                    <div class="titulo-progras" style="text-align: left; margin-left: 120px;"><h3>Histórico de <strong style="color:#934493;">Programas de Infraestructura</strong> </h3> </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <div class="error-sindatos">¡No hay información para mostrar!</div>
                                </s:else>

                            </s:if>


                           <!-- TERMINA CONTENEDOR DE TABLAS DE PROGRAMAS -->



                    </div>   





                    <!-- BORINES DE DESCARGA DE DOCUENNTOS -->
                    <div class="grafica-grande"> 
                        <div class="menu-botones" style="margin-top: 20px;">
                            <s:url action="GeneraPdf" id="myUrl" escapeAmp="false">

                                <s:param name="TipoReporte" value="'BusquedaCct.jasper'"/>
                                <s:param name="CCT" value="busquedaCCT.BUSCAR_CCT"/>
                                <s:param name="CicloEscolar" value="cat.CICLOAUX"/>
                                <s:param name="esExcel" value="'false'"/>
                                <s:param name="esPDF" value="'true'"/>            

                            </s:url> 





                            <a href= "<s:property value="#myUrl"/>" target="_blank" ><div class="div_bottones2" id="pdf_descarga" style=" width: 100%; margin-left: 280px; margin-top: -5px; "><div class="img-prog-ind"><img src="img/pdf.png" alt="home" ></img></div><div class="text-prog-ind2" >Información de la </div> <div class="text-prog-ind2" >CCT seleccionada</div> </div></a>


                        </div>
                        <div style="position: relative; width: 100%; text-align: right; margin-top: -30px;">Fuente: Niveles Educativos, 10 de Enero de 2018</div>

                        <!-- CAMPOS OCULTOS DE MANEJO DE APLICACIÓN-->

                        <s:textfield name="regioB.AUXTIPOPROG" id="AUXTIPOPROG" style='visibility:hidden'></s:textfield>
                        <s:textfield name="cat.CICLOAUX" id="cat.CICLOAUX" style='visibility:hidden'/>

                    </div>



                    <!-- ITERACION DE OBJETOS LISTAS -->    




                </div>

                <div class="modal-wrapper" id="popup">
                    <div class="popup-contenedor">


                        <h2  >Dirección de la Escuela</h2>


                        <table id="customers" style="text-align: justify;">
                            <tr>
                                <th><s:property value="busquedaCCT.NOMBRE_ESCUELA"/></th>



                            </tr>
                            <tr>

                                <th><s:property value="busquedaCCT.DOMICILIO"/></th>


                            </tr>

                        </table>

                        <div id="map"  ></div>  
                        <a class="popup-cerrar" href="#">X</a>
                    </div>
                </div>

                                
                                
                <!-- POPUP DE GRAFICAS DE RESULTADOS PLANEA -->    
                
                
                 <div class="modal-wrapper" id="popup2">
                    <div class="popup-contenedor">


                        <h2  >Gráficas de resultados PLANEA</h2>

                        <div style="min-height: 450px; max-height: 600px; overflow-y: scroll;">
                        <table id="customers" style="text-align: justify; font-size: 12px; background: white; width: 100%;" border="0">
                            
                             <tr>
                                 <th colspan="2" > <div style="width: 100%; border-radius: 10px 10px 0px 0px; background: #6c3483; color: white; height: 30px;"> Lenguaje y Comunicación </div></th>



                            </tr>
                            
                            <tr>
                                <th style="width: 50%;" align="center"><div style="width: 100%; border-radius: 10px 10px 0px 0px; background: #6c3483; color: white; height: 30px; margin: auto;"><s:iterator value="ListaResultadosPlanea" id="ListaResultadosPlanea" begin="1" end="1" status="stat"> <s:property value="CICLO_ESCOLAR"/></s:iterator></div></th>
                                <th style="width: 50%;" align="center"> <div style="width: 100%; border-radius: 10px 10px 0px 0px; background: #6c3483; color: white; height: 30px; margin: auto;">   <s:iterator value="ListaResultadosPlanea" id="ListaResultadosPlanea" begin="0" end="0" status="stat"> <s:property value="CICLO_ESCOLAR"/></s:iterator></div> </th>



                            </tr>
                            
                            
                            
                            <tr>
                                <th style="width: 50%;"><div id="lc_ciclo2" style="width: 100%; height: 200px; border-radius: 10px;"></div></th>

                                <th style="width: 50%;">    <div id="lc_ciclo1" style="width: 100%; height: 200px; border-radius: 10px;"></div></th>


                            </tr>
                                
                                
                                
                              <!--Matemáticas -->  
                                 <tr>
                                 <th colspan="2" > <div style="width: 100%; border-radius: 10px 10px 0px 0px; background: #934493; color: white; height: 30px;"> Matemáticas </div></th>



                            </tr>
                            
                            <tr>
                                <th style="width: 50%;" align="center"><div style="width: 100%; border-radius: 10px 10px 0px 0px; background: #d8aac3; color: #333; height: 30px; margin: auto;"><s:iterator value="ListaResultadosPlanea" id="ListaResultadosPlanea" begin="1" end="1" status="stat"> <s:property value="CICLO_ESCOLAR"/></s:iterator></div></th>
                                <th style="width: 50%;" align="center"> <div style="width: 100%; border-radius: 10px 10px 0px 0px; background: #d8aac3; color: #333; height: 30px; margin: auto;">   <s:iterator value="ListaResultadosPlanea" id="ListaResultadosPlanea" begin="0" end="0" status="stat"> <s:property value="CICLO_ESCOLAR"/></s:iterator></div> </th>



                            </tr>
                            
                            
                            
                            <tr>
                                <th style="width: 50%;"><div id="m_ciclo2" style="width: 100%; height: 200px; border-radius: 10px;"></div></th>

                                <th style="width: 50%;">    <div id="m_ciclo1" style="width: 100%; height: 200px; border-radius: 10px;"></div></th>


                            </tr>
                           

                        </table>
                                
                                
                                   
                      </div>

                        <div id="map"  ></div>  
                        <a class="popup-cerrar" href="#">X</a>
                    </div>
                </div>
               
                                
                                
                                
                                
                                
            </section> 

        </s:form>


    </body>
    <div class="div-footer"> <h2 class="texto-footer">La información de este Tablero es de uso interno, para mas detalle favor de accesar a la página http://seduc.edomex.gob.mx/ <br>Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</h2> </div>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDX8E8BNrVI5vS1vv5q_dz5k9PhGHZopS0&callback=initMap">
    </script> 

    <style>
        #map {
            height: 400px;
            width: 100%;
        }
    </style>

    <script>
        function initMap() {
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 16,
                mapTypeId: 'roadmap'
            });
            var ctaLayer = new google.maps.KmlLayer({
                url: 'http://refaccionesfabela.com/cta.kmz',
                map: map
            });

            var bounds = {
                north: 19.363882,
                south: 20.203405,
                east: -99.144922,
                west: -100.244141
            };

            // Display the area between the location southWest and northEast.
            map.fitBounds(bounds);

            // Add 5 markers to map at random locations.
            // For each of these markers, give them a title with their index, and when
            // they are clicked they should open an infowindow with text from a secret
            // message.
            var lngSpan = bounds.east - bounds.west;
            var latSpan = bounds.north - bounds.south;


            // var u=0;

            // u=u+0.02;
            var i = 0;

            var marker = new google.maps.Marker({
                position: {

                    lat: <s:property value="busquedaCCT.LATITUD"/>,
                    lng: <s:property value="busquedaCCT.LONGITUD"/>
                },
                map: map, title: '<s:property value="CCT"/>'


            });
            i++;

            attachSecretMessage(marker, secretMessages[i]);

        }

        // Attaches an info window to a marker with the provided message. When the
        // marker is clicked, the info window will open with the secret message.
        function attachSecretMessage(marker, secretMessage) {
            var infowindow = new google.maps.InfoWindow({
                content: secretMessage
            });

            marker.addListener('click', function () {
                infowindow.open(marker.get('map'), marker);
            });
        }
    </script>
                
   <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
         
      <s:iterator value="ListaResultadosPlanea" id="ListaResultadosPlanea" begin="0" end="0" status="stat">
                  ['Insuficiente I', <s:property value="LC_I"/>],  ['Básico II',     <s:property value="LC_II"/>], ['Satisfactorio III',     <s:property value="LC_III"/>], ['Sobresaliente IV',     <s:property value="LC_IV"/>],
      </s:iterator>
          
        ]);

        var options = {
         
          is3D: true,
          colors: ['red', 'orange', 'yellow', 'green', '#f6c7b6'],
          legend:{position: 'bottom', textStyle: {color: '#333333', fontSize: 10}},
           backgroundColor: '#E4E4E4',
          
        };
       

        var chart = new google.visualization.PieChart(document.getElementById('lc_ciclo1'));
        chart.draw(data, options);
      }
    </script>

                
                
  <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
         
      <s:iterator value="ListaResultadosPlanea" id="ListaResultadosPlanea" begin="1" end="1" status="stat">
                  ['Insuficiente I', <s:property value="LC_I"/>],  ['Básico II',     <s:property value="LC_II"/>], ['Satisfactorio III',     <s:property value="LC_III"/>], ['Sobresaliente IV',     <s:property value="LC_IV"/>],
      </s:iterator>
          
        ]);

        var options = {
        
          is3D: true,
          colors: ['red', 'orange', 'yellow', 'green', '#f6c7b6'],
          legend:{position: 'bottom', textStyle: {color: '#333333', fontSize: 10}},
            backgroundColor: '#E4E4E4',
          
        };
       

        var chart = new google.visualization.PieChart(document.getElementById('lc_ciclo2'));
        chart.draw(data, options);
      }
    </script>
                
                
                
                
                
                
                
                <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
         
      <s:iterator value="ListaResultadosPlanea" id="ListaResultadosPlanea" begin="0" end="0" status="stat">
                  ['Insuficiente I', <s:property value="M_I"/>],  ['Básico II',     <s:property value="M_II"/>], ['Satisfactorio III',     <s:property value="M_III"/>], ['Sobresaliente IV',     <s:property value="M_IV"/>],
      </s:iterator>
          
        ]);

        var options = {
         
          is3D: true,
          colors: ['red', 'orange', 'yellow', 'green', '#f6c7b6'],
          legend:{position: 'bottom', textStyle: {color: '#333333', fontSize: 10}},
           backgroundColor: '#E4E4E4',
          
        };
       

        var chart = new google.visualization.PieChart(document.getElementById('m_ciclo1'));
        chart.draw(data, options);
      }
    </script>

                
                
  <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
         
      <s:iterator value="ListaResultadosPlanea" id="ListaResultadosPlanea" begin="1" end="1" status="stat">
                  ['Insuficiente I', <s:property value="M_I"/>],  ['Básico II',     <s:property value="M_II"/>], ['Satisfactorio III',     <s:property value="M_III"/>], ['Sobresaliente IV',     <s:property value="M_IV"/>],
      </s:iterator>
          
        ]);

        var options = {
        
          is3D: true,
          colors: ['red', 'orange', 'yellow', 'green', '#f6c7b6'],
          legend:{position: 'bottom', textStyle: {color: '#333333', fontSize: 10}},
            backgroundColor: '#E4E4E4',
          
        };
       

        var chart = new google.visualization.PieChart(document.getElementById('m_ciclo2'));
        chart.draw(data, options);
      }
    </script>

</html>
