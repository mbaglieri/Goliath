
<script type="text/javascript">
  function cleanForm(){
	

			document.getElementById("authority").value="";
                    
}
</script>
          <input type="button" name="btn" id="btn"value="Ocultar Filtros" onclick="doExpandCollapse('search')">
             <g:form action="search" method="post"  name="search" id="search" onsubmit="validarStruct()">
                <div class="buttons">
                  <input type="submit" value="Buscar" class="Search"/>
                  <input type="button" value="Limpiar Filtros" class="Clean" onclick="cleanForm()"/>
                </div>
                <div class="dialog1">
                  <table>
                        <tbody>
                        
                            
                            <tr class="prop">
                            
                            
                                <td valign="top" class="name">
                                    <label for="authority"><g:message code="role.authority.label" default="Authority" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:roleInstance,field:'authority','errors')}">
                                    <g:textField name="authority" value="${roleInstance?.authority}" />
                                </td>
                        
                            </tr>
                        </tbody>
                    </table>
                </div>

            </g:form>
