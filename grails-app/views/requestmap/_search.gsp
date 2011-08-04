
<script type="text/javascript">
  function cleanForm(){
	

			document.getElementById("url").value="";
                    

			document.getElementById("configAttribute").value="";
                    
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
                                    <label for="url"><g:message code="requestmap.url.label" default="Url" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:requestmapInstance,field:'url','errors')}">
                                    <g:textField name="url" value="${requestmapInstance?.url}" />
                                </td>
                        
                            
                            
                                <td valign="top" class="name">
                                    <label for="configAttribute"><g:message code="requestmap.configAttribute.label" default="Config Attribute" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:requestmapInstance,field:'configAttribute','errors')}">
                                    <g:textField name="configAttribute" value="${requestmapInstance?.configAttribute}" />
                                </td>
                        
                            </tr>
                        </tbody>
                    </table>
                </div>

            </g:form>
