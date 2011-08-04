
<%@ page import="ar.com.goliath.AuditoriaCommand" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'auditoria.label', default:'Auditoria')}" />
        <title>Listado de Eventos</title>
    </head>
    <body>
    <div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
        </div>
            <h1>Listado de Eventos</h1>
             <g:render template="/auditoria/search"/>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="fechaLog" title="${message(code:'auditoria.fechaLog.label', default:'Fecha Log')}" />
                        
                   	        <g:sortableColumn property="accion" title="${message(code:'auditoria.accion.label', default:'Accion')}" />
                        
                   	        <g:sortableColumn property="usuario" title="${message(code:'auditoria.usuario.label', default:'Usuario')}" />
                        
                   	        <g:sortableColumn property="nombreObjeto" title="${message(code:'auditoria.nombreObjeto.label', default:'Nombre Objeto')}" />
                        
                   	        <g:sortableColumn property="role" title="${message(code:'auditoria.role.label', default:'Role')}" />

                                <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${auditoriaInstanceList}" status="i" var="auditoriaInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                           
                            <td>${fieldValue(bean:auditoriaInstance, field:'fechaLog')}</td>
                        
                            <td>${fieldValue(bean:auditoriaInstance, field:'accion')}</td>
                        
                            <td>${fieldValue(bean:auditoriaInstance, field:'usuario')}</td>
                        
                            <td>${fieldValue(bean:auditoriaInstance, field:'nombreObjeto')}</td>
                        
                            <td>${fieldValue(bean:auditoriaInstance, field:'role')}</td>

                            <td><g:link action="show" id="${auditoriaInstance.id}">ver</g:link></td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${auditoriaInstanceTotal}" params="${params}"  max="5" />
            </div>
        </div>
    </body>
</html>
