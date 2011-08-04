
<%@ page import="ar.com.goliath.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.create.label" args="[entityName]" default="Nuevo User"/></title>
    </head>
    <body>
  	<div id="main" role="main">
    <hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" default="Listado User"/></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" default="Nuevo User"/></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${userInstance}">
            <div class="errors">
                <g:renderErrors bean="${userInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="username"><g:message code="user.username.label" default="Username" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'username','errors')}">
                                    <g:textField name="username" value="${userInstance?.username}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password"><g:message code="user.password.label" default="Password" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'password','errors')}">
                                    <g:passwordField name="password" value="${userInstance?.password}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="accountExpired"><g:message code="user.accountExpired.label" default="Account Expired" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'accountExpired','errors')}">
                                    <g:checkBox name="accountExpired" value="${userInstance?.accountExpired}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="accountLocked"><g:message code="user.accountLocked.label" default="Account Locked" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'accountLocked','errors')}">
                                    <g:checkBox name="accountLocked" value="${userInstance?.accountLocked}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="enabled"><g:message code="user.enabled.label" default="Enabled" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'enabled','errors')}">
                                    <g:checkBox name="enabled" value="${userInstance?.enabled}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="passwordExpired"><g:message code="user.passwordExpired.label" default="Password Expired" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'passwordExpired','errors')}">
                                    <g:checkBox name="passwordExpired" value="${userInstance?.passwordExpired}" />
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="${message(code: 'default.button.create.label', default: 'Crear')}" /></span>
                </div>
            </g:form>
        </div>
        </div>
    </body>
</html>