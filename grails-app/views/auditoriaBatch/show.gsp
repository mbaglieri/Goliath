
<%@ page import="ar.com.goliath.AuditoriaBatch" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'auditoriaBatch.label', default:'AuditoriaBatch')}" />
        <title>Ver Batch</title>
    </head>
    <body>
    <div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Inicio</a></span>
            <span class="menuButton"><g:link class="list" action="list">Listado de Batch</g:link></span>
        </div>
        <div class="body">
            <h1>Ver Batch</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoriaBatch.fechaLog.label" default="Fecha Log" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaBatchInstance, field:'fechaLog')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoriaBatch.accion.label" default="Accion" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaBatchInstance, field:'accion')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoriaBatch.detalle.label" default="Detalle" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaBatchInstance, field:'detalle')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoriaBatch.nombreObjeto.label" default="Nombre Objeto" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaBatchInstance, field:'nombreObjeto')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoriaBatch.usuario.label" default="Usuario" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaBatchInstance, field:'usuario')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
        </div>
      </div>
    </body>
</html>
