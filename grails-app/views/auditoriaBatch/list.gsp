
<%@ page import="ar.com.goliath.AuditoriaCommand" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'auditoriaBatch.label', default:'AuditoriaBatch')}" />
        <title>Listado de Batch </title>
    </head>
    <body>
    <div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Inicio</a></span>
        </div>
            <h1>Listado de Batch </h1>
             <g:render template="/auditoriaBatch/search"/>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>


                   	        <g:sortableColumn property="fechaLog" title="${message(code:'auditoriaBatch.fechaLog.label', default:'Fecha Log')}" />

                   	        <g:sortableColumn property="accion" title="${message(code:'auditoriaBatch.accion.label', default:'Accion')}" />

                                <g:sortableColumn property="nombreObjeto" title="${message(code:'auditoriaBatch.nombreObjeto.label', default:'Nombre Objeto')}" />

                   	        <g:sortableColumn property="usuario" title="${message(code:'auditoriaBatch.usuario.label', default:'Usuario')}" />

                                <g:sortableColumn property="status" title="${message(code:'auditoriaBatch.status.label', default:'Estado')}" />

                                <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${auditoriaBatchInstanceList}" status="i" var="auditoriaBatchInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">


                            <td>${fieldValue(bean:auditoriaBatchInstance, field:'fechaLog')}</td>

                            <td>${fieldValue(bean:auditoriaBatchInstance, field:'accion')}</td>


                            <td>${fieldValue(bean:auditoriaBatchInstance, field:'nombreObjeto')}</td>

                            <td>${fieldValue(bean:auditoriaBatchInstance, field:'usuario')}</td>


                            <g:if test="${auditoriaBatchInstance.status}">
                              <td><img src="images/icons/accept.png" /></td>
                            </g:if>
                            <g:if test="${!auditoriaBatchInstance.status}">
                              <td><img src="images/icons/cross.png" /></td>
                            </g:if>
                            <td><g:link action="show" id="${auditoriaBatchInstance.id}">ver</g:link></td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${auditoriaBatchInstanceTotal}" params="${params}"  max="5" />
            </div>
      </div>
    </body>
</html>
