<% import org.codehaus.groovy.grails.orm.hibernate.support.ClosureEventTriggeringInterceptor as Events %>
<%=packageName%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />        
	<title><g:message code="default.edit.label" args="[entityName]" default="Editar ${className}"/></title>
    </head>
    <body>
  	<div id="main" role="main">
    	<hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="\${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">
		<g:message code="default.list.label" args="[entityName]" default="Listado ${className}"/></g:link>
	    </span>
            <span class="menuButton"><g:link class="create" action="create">
		<g:message code="default.new.label" args="[entityName]" default="Nuevo ${className}" /></g:link>
	    </span>

        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" default="Editar ${className}"/></h1>
            <g:if test="\${flash.message}">
            <div class="message">\${flash.message}</div>
            </g:if>
            <g:hasErrors bean="\${${propertyName}}">
            <div class="errors">
                <g:renderErrors bean="\${${propertyName}}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" <%= multiPart ? ' enctype="multipart/form-data"' : '' %>>
                <input type="hidden" name="id" value="\${${propertyName}?.id}" />
                <input type="hidden" name="version" value="\${${propertyName}?.version}" />
                <div class="dialog">
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
                            
                            Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
                            props.each { p ->
                                cp = domainClass.constrainedProperties[p.name]
                                display = (cp ? cp.display : true)        
                                if(display) { %>
                            <tr class="prop">
                                <td valign="top" class="name">
					<label for="${p.name}"><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" />
					</label>
                                </td>
                                <td valign="top" class="value \${hasErrors(bean:${propertyName},field:'${p.name}','errors')}">
                                    ${renderEditor(p)}
                                </td>
                            </tr> 
                        <%  }   } %>
                        </tbody>
                    </table>
                </div>
    		<div class="buttons">
                    <span class="button">
			<g:actionSubmit class="save" action="update" value="\${message(code: 'default.button.update.label', default: 'Modificar')}" />
		    </span>
                    <span class="button">
			<g:actionSubmit class="delete" action="delete" value="\${message(code: 'default.button.delete.label', default: 'Borrar')}" onclick="return confirm('\${message(code: 'default.button.delete.confirm.message', default: 'Esta seguro que desea eliminarlo?')}');" />
		    </span>
                </div>
            </g:form>
        </div>
        </div>
    </body>
</html>
