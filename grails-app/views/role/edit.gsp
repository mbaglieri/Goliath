
<%@ page import="ar.com.goliath.Role" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />        
	<title><g:message code="default.edit.label" args="[entityName]" default="Editar Role"/></title>
    </head>
    <body>
  	<div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">
		<g:message code="default.list.label" args="[entityName]" default="Listado Role"/></g:link>
	    </span>
            <span class="menuButton"><g:link class="create" action="create">
		<g:message code="default.new.label" args="[entityName]" default="Nuevo Role" /></g:link>
	    </span>

        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" default="Editar Role"/></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${roleInstance}">
            <div class="errors">
                <g:renderErrors bean="${roleInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${roleInstance?.id}" />
                <input type="hidden" name="version" value="${roleInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
					<label for="authority"><g:message code="role.authority.label" default="Authority" />
					</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:roleInstance,field:'authority','errors')}">
                                    <g:textField name="authority" value="${roleInstance?.authority}" />
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
    		<div class="buttons">
                    <span class="button">
			<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Modificar')}" />
		    </span>
                    <span class="button">
			<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Borrar')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Esta seguro que desea eliminarlo?')}');" />
		    </span>
                </div>
            </g:form>
        </div>
        </div>
    </body>
</html>
