
<%@ page import="ar.com.goliath.Requestmap" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'requestmap.label', default: 'Requestmap')}" />        
	<title><g:message code="default.edit.label" args="[entityName]" default="Editar Requestmap"/></title>
    </head>
    <body>
  	<div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">
		<g:message code="default.list.label" args="[entityName]" default="Listado Requestmap"/></g:link>
	    </span>
            <span class="menuButton"><g:link class="create" action="create">
		<g:message code="default.new.label" args="[entityName]" default="Nuevo Requestmap" /></g:link>
	    </span>

        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" default="Editar Requestmap"/></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${requestmapInstance}">
            <div class="errors">
                <g:renderErrors bean="${requestmapInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${requestmapInstance?.id}" />
                <input type="hidden" name="version" value="${requestmapInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
					<label for="url"><g:message code="requestmap.url.label" default="Url" />
					</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:requestmapInstance,field:'url','errors')}">
                                    <g:textField name="url" value="${requestmapInstance?.url}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
					<label for="configAttribute"><g:message code="requestmap.configAttribute.label" default="Config Attribute" />
					</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:requestmapInstance,field:'configAttribute','errors')}">
                                    <g:textField name="configAttribute" value="${requestmapInstance?.configAttribute}" />
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
