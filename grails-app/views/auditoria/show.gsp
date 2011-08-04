
<%@ page import="ar.com.goliath.Auditoria" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code:'auditoria.label', default:'Auditoria')}" />
        <title>Ver Entidad</title>
    </head>
    <body>
    <div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Listado de Entidades</g:link></span>
       </div>
        <div class="body">
            <h1>Ver Entidad</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
              <div class="list" style="width:1024px;overflow-x: scroll;">
              <table width="1024px">
                    <tbody>
  	                    <thead class="fixedHeader">

                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoria.fechaLog.label" default="Fecha Log" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaInstance, field:'fechaLog')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoria.accion.label" default="Accion" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaInstance, field:'accion')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoria.detalle.label" default="Detalle" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaInstance, field:'detalle')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoria.nombreObjeto.label" default="Nombre Objeto" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaInstance, field:'nombreObjeto')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoria.role.label" default="Role" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaInstance, field:'role')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">
                               <g:message code="auditoria.usuario.label" default="Usuario" />:
                            </td>
                            
                            <td valign="top" class="value">${fieldValue(bean:auditoriaInstance, field:'usuario')}</td>
                            
                        </tr>

                        </thead>

                    </tbody>
                </table>
            </div>
        </div>
      </div>
    </body>
</html>
