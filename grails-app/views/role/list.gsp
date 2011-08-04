
<%@ page import="ar.com.goliath.Role" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />       
	<g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />
        <title><g:message code="default.list.label" args="[entityName]" default="Listado Role"/></title>
        <export:resource />
    </head>
    <body>
  	<div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" default="Nuevo Role"/></g:link></span>
        </div>
            <h1><g:message code="default.list.label" args="[entityName]" default="Listado Role"/></h1>
             <g:render template="/role/search"/>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                                          <g:sortableColumn property="id" title="${message(code: 'role.id.label', default: 'Id')}" />
                                        
                                          <g:sortableColumn property="authority" title="${message(code: 'role.authority.label', default: 'Authority')}" />
                                        

                            <th nowrap>
                                 <label><g:message code="editar.label" default="Editar"/></label>
                            </th>
                            <th nowrap>
                                 <label><g:message code="ver.label" default="Ver"/></label>
                            </th>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${roleInstanceList}" status="i" var="roleInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                             
                              <td>${fieldValue(bean:roleInstance, field:'id')}</td>
                          
                              <td>${fieldValue(bean:roleInstance, field:'authority')}</td>
                          
                          <td>
                            <g:link action="edit" class="editar" id="${roleInstance.id}">&nbsp;</g:link>
                          </td>
                          <td>
                            <g:link action="show" class="show" id="${roleInstance.id}">&nbsp;</g:link>
                          </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${roleInstanceTotal}" max="5"/>
            </div>
             <export:formats params="${params}" formats="['excel','pdf','csv']"/>
        </div>
    </body>
</html>
