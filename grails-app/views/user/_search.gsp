
<script type="text/javascript">
  function cleanForm(){
	

			document.getElementById("username").value="";
                    

			document.getElementById("password").value="";
                    
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
                                    <label for="username"><g:message code="user.username.label" default="Username" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'username','errors')}">
                                    <g:textField name="username" value="${userInstance?.username}" />
                                </td>
                        
                            
                            
                                <td valign="top" class="name">
                                    <label for="password"><g:message code="user.password.label" default="Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'password','errors')}">
                                    <g:textField name="password" value="${userInstance?.password}" />
                                </td>
                        
                            
                            </tr>
                            <tr class="prop">
                            
                            
                            
                            </tr>
                            <tr class="prop">
                            
                            
                            
                            </tr>
                            <tr class="prop">
                            
                            
                            
                            </tr>
                            <tr class="prop">
                            
                            
                            </tr>
                        </tbody>
                    </table>
                </div>

            </g:form>
