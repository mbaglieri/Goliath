<% import org.codehaus.groovy.grails.orm.hibernate.support.ClosureEventTriggeringInterceptor as Events %>
<%=packageName%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />       
	<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
        <title><g:message code="default.list.label" args="[entityName]" default="Listado ${className}"/></title>
        <export:resource />
    </head>
    <body>
  	<div id="main" role="main">
    	<hr class="space"/>
        <div class="nav">
            <span class="menuButton"><a class="home" href="\${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" default="Nuevo ${className}"/></g:link></span>
        </div>
            <h1><g:message code="default.list.label" args="[entityName]" default="Listado ${className}"/></h1>
             <g:render template="/${grails.util.GrailsNameUtils.getPropertyName(className)}/search"/>
            <g:if test="\${flash.message}">
            <div class="message">\${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        <%
                            excludedProps = ['version',
                                               Events.ONLOAD_EVENT,
                                               Events.BEFORE_DELETE_EVENT,
                                               Events.BEFORE_INSERT_EVENT,
                                               Events.BEFORE_UPDATE_EVENT]
                            
                            props = domainClass.properties.findAll { !excludedProps.contains(it.name) && it.type != Set.class }
                            Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
                            props.eachWithIndex { p,i ->
                   	            if(i < 6) {
                   	                if(p.isAssociation()) { %>
                                          <th><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" /></th>
                                          <%          } else { %>
                                          <g:sortableColumn property="${p.name}" title="\${message(code: '${domainClass.propertyName}.${p.name}.label', default: '${p.naturalName}')}" />
                                        <%  }   }   } %>

                            <th nowrap>
                                 <label><g:message code="editar.label" default="Editar"/></label>
                            </th>
                            <th nowrap>
                                 <label><g:message code="ver.label" default="Ver"/></label>
                            </th>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="\${${propertyName}List}" status="i" var="${propertyName}">
                        <tr class="\${(i % 2) == 0 ? 'odd' : 'even'}">
                             <%  props.eachWithIndex { p,i ->
                                  if(i == 0) { %>
                              <td>\${fieldValue(bean:${propertyName}, field:'${p.name}')}</td>
                          <%      } else if(i < 6) { 
			     if(p.type == Date.class || p.type == java.sql.Date.class || p.type == java.sql.Time.class){%>
                              <td><fmt:dateFormat value="\${${propertyName}.${p.name}}" format="dd/MM/yyyy"/></td>
			   <%}else{%>
                              <td>\${fieldValue(bean:${propertyName}, field:'${p.name}')}</td>
                          <% } }   } %>
                          <td>
                            <g:link action="edit" class="editar" id="\${${propertyName}.id}">&nbsp;</g:link>
                          </td>
                          <td>
                            <g:link action="show" class="show" id="\${${propertyName}.id}">&nbsp;</g:link>
                          </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="\${${propertyName}Total}" max="5"/>
            </div>
            </div>
    </body>
</html>
