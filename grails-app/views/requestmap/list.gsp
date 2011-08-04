
<%@ page import="ar.com.goliath.Requestmap" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />       
	<g:set var="entityName" value="${message(code: 'requestmap.label', default: 'Requestmap')}" />
        <title><g:message code="default.list.label" args="[entityName]" default="Listado Requestmap"/></title>
        <export:resource />
    </head>
    <body>
  	<div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" default="Nuevo Requestmap"/></g:link></span>
        </div>
            <h1><g:message code="default.list.label" args="[entityName]" default="Listado Requestmap"/></h1>
             <g:render template="/requestmap/search"/>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                                          <g:sortableColumn property="id" title="${message(code: 'requestmap.id.label', default: 'Id')}" />
                                        
                                          <g:sortableColumn property="url" title="${message(code: 'requestmap.url.label', default: 'Url')}" />
                                        
                                          <g:sortableColumn property="configAttribute" title="${message(code: 'requestmap.configAttribute.label', default: 'Config Attribute')}" />
                                        

                            <th nowrap>
                                 <label><g:message code="editar.label" default="Editar"/></label>
                            </th>
                            <th nowrap>
                                 <label><g:message code="ver.label" default="Ver"/></label>
                            </th>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${requestmapInstanceList}" status="i" var="requestmapInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                             
                              <td>${fieldValue(bean:requestmapInstance, field:'id')}</td>
                          
                              <td>${fieldValue(bean:requestmapInstance, field:'url')}</td>
                          
                              <td>${fieldValue(bean:requestmapInstance, field:'configAttribute')}</td>
                          
                          <td>
                            <g:link action="edit" class="editar" id="${requestmapInstance.id}">&nbsp;</g:link>
                          </td>
                          <td>
                            <g:link action="show" class="show" id="${requestmapInstance.id}">&nbsp;</g:link>
                          </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${requestmapInstanceTotal}" max="5"/>
            </div>
             <export:formats params="${params}" formats="['excel','pdf','csv']"/>
        </div>
    </body>
</html>
