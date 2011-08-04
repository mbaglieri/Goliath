
<%@ page import="ar.com.goliath.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />       
	<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.list.label" args="[entityName]" default="Listado User"/></title>
        <export:resource />
    </head>
    <body>
  	<div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" default="Nuevo User"/></g:link></span>
        </div>
            <h1><g:message code="default.list.label" args="[entityName]" default="Listado User"/></h1>
             <g:render template="/user/search"/>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                                          <g:sortableColumn property="id" title="${message(code: 'user.id.label', default: 'Id')}" />
                                        
                                          <g:sortableColumn property="username" title="${message(code: 'user.username.label', default: 'Username')}" />
                                        
                                          <g:sortableColumn property="password" title="${message(code: 'user.password.label', default: 'Password')}" />
                                        
                                          <g:sortableColumn property="accountExpired" title="${message(code: 'user.accountExpired.label', default: 'Account Expired')}" />
                                        
                                          <g:sortableColumn property="accountLocked" title="${message(code: 'user.accountLocked.label', default: 'Account Locked')}" />
                                        
                                          <g:sortableColumn property="enabled" title="${message(code: 'user.enabled.label', default: 'Enabled')}" />
                                        

                            <th nowrap>
                                 <label><g:message code="editar.label" default="Editar"/></label>
                            </th>
                            <th nowrap>
                                 <label><g:message code="ver.label" default="Ver"/></label>
                            </th>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                             
                              <td>${fieldValue(bean:userInstance, field:'id')}</td>
                          
                              <td>${fieldValue(bean:userInstance, field:'username')}</td>
                          
                              <td>${fieldValue(bean:userInstance, field:'password')}</td>
                          
                              <td>${fieldValue(bean:userInstance, field:'accountExpired')}</td>
                          
                              <td>${fieldValue(bean:userInstance, field:'accountLocked')}</td>
                          
                              <td>${fieldValue(bean:userInstance, field:'enabled')}</td>
                          
                          <td>
                            <g:link action="edit" class="editar" id="${userInstance.id}">&nbsp;</g:link>
                          </td>
                          <td>
                            <g:link action="show" class="show" id="${userInstance.id}">&nbsp;</g:link>
                          </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${userInstanceTotal}" max="5"/>
            </div>
             <export:formats params="${params}" formats="['excel','pdf','csv']"/>
            </div>
    </body>
</html>
