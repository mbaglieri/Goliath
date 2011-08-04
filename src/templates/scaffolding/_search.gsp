<% import org.codehaus.groovy.grails.orm.hibernate.support.ClosureEventTriggeringInterceptor as Events %>
<script type="text/javascript">
  function cleanForm(){
	<%excludedProps = ['version', 'id']
           props = domainClass.properties.findAll { !excludedProps.contains(it.name) }
            Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
            props.each { p ->
                if(!Collection.class.isAssignableFrom(p.type)) {
                    cp = domainClass.constrainedProperties[p.name]
                    display = (cp ? cp.display : true)
                    if(display) {
                        if(p.type.toString().contains("String")){%>

			document.getElementById("${p.name}").value="";
                    <%}}
                }
            }%>
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
                        <%

                            excludedProps = ['version',
                                             'id',
                                               Events.ONLOAD_EVENT,
                                               Events.BEFORE_DELETE_EVENT,
                                               Events.BEFORE_INSERT_EVENT,
                                               Events.BEFORE_UPDATE_EVENT]
                            props = domainClass.properties.findAll { !excludedProps.contains(it.name) }
                            int a=2
                            boolean hasEnd=false
                            Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
                            props.each { p ->
                                if(!Collection.class.isAssignableFrom(p.type)) {
                                    cp = domainClass.constrainedProperties[p.name]
                                    display = (cp ? cp.display : true)
                                    if(display) { %>
                            <%if(a==2 ){%>
                            <tr class="prop">
                            <%}
                            if(!(a%2)&&(a!=2)){%>
                            </tr>
                            <tr class="prop">
                            <%}%>
                            <%if(p.type.toString().contains("String")){%>
                                <td valign="top" class="name">
                                    <label for="${p.name}"><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" /></label>
                                </td>
                                <td valign="top" class="value \${hasErrors(bean:${propertyName},field:'${p.name}','errors')}">
                                    ${renderEditor(p)}
                                </td>
                        <%  a++}}   }   } %>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </g:form>
