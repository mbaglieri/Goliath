<script type="text/javascript">
  function cleanForm(){
    document.getElementById("accion").value="";
    document.getElementById("usuario").value="";
    document.getElementById("fechaLogd").value="";
    document.getElementById("fechaLogh").value="";
    document.getElementById("fechaLogd_value").value="";
    document.getElementById("fechaLogh_value").value="";
  }
</script>
          <input type="button" name="btn" id="btn"value="Ocultar Filtros" onclick="doExpandCollapse('search')">
             <g:form action="search" method="post"  name="search" id="search" onsubmit="validarStruct()">
                <div class="buttons">
                  <input type="submit" value="Buscar" class="Search"/>
                  <input type="button" value="Limpiar Filtros" onclick="cleanForm()" class="Clean"/>
                </div>
                <div class="dialog1">
                <table>
                   <tr class='prop'>
                      <td valign='top' class='name1'>
                        <label for='usuario'><g:message code="usuario"/>:</label>
                     </td>
                     <td valign='top' class='value'>
                       <input type="text"  name='usuario' id ='usuario' value="${auditoriaInstance1?.usuario}"/>
                       
                     </td>
                      <td valign="top" class="name1">
                         <label for="accion"><g:message code="accion"/>:</label>
                      </td>
                      <td valign="top" class="value ${hasErrors(bean:auditoriaInstance1,field:'accion','errors')}">
                        <input type="text" name='accion' id ='accion' value="${auditoriaInstance1?.accion}"/>
                       </td>
                   </tr>
                 <tr class="prop">
                      <td valign="top">
                        <label for="fechaLogd"><g:message code="fechaLogd"/>:</label>
                      </td>
                      <td>
                        <calendar:datePicker name="fechaLogd" value="${auditoriaInstance1?.fechaLogd}" dateFormat="%d/%m/%Y" ></calendar:datePicker>
                      </td>
                      <td valign="top">
                       <label for="fechaLogh"><g:message code="fechaLogh"/>:</label>
                      </td>
                      <td>
                        <calendar:datePicker name="fechaLogh" value="${auditoriaInstance1?.fechaLogh}" dateFormat="%d/%m/%Y" ></calendar:datePicker>

                   </td>
                </table>
                </div>

            </g:form>
