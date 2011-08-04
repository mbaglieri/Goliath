<%=packageName ? "package ${packageName}\n\n" : ''%>
import org.codehaus.groovy.grails.commons.ConfigurationHolder
class ${className}Controller {
    def exportService
   <%def lowerCaseName = grails.util.GrailsNameUtils.getPropertyName(className)%>
    def ${lowerCaseName}Service
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
                 def ${propertyName} = new ${className}Command()

        if(${propertyName}.validateAllParams(params)!=""){
           flash.message=${propertyName}.validateAllParams(params)
        }
        ${propertyName}.commandSetParameters(params)
        def count=${lowerCaseName}Service.getAllCount(${propertyName})
        if(params?.format && params.format != "html")${propertyName}.max=count
        def results=${lowerCaseName}Service.getAll(${propertyName})
        if(params?.format && params.format != "html"){
            exportToFile(results)
         }
	[ ${lowerCaseName}InstanceList:results, ${lowerCaseName}InstanceTotal:count ,${propertyName}:${propertyName}]
    }

    def show = {
        def ${propertyName} = ${className}.get( params.id )

        if(!${propertyName}) {
            flash.message = "\${message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])}"
            redirect(action:list)
        }
        else { return [ ${propertyName} : ${propertyName} ] }
    }

    def delete = {
        def ${propertyName} = ${className}.get( params.id )
        if(${propertyName}) {
            try {
                ${propertyName}.delete(flush:true)
                flash.message = "\${message(code: 'default.deleted.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])}"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "\${message(code: 'default.not.deleted.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])}"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "\${message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])}"
            redirect(action:list)
        }
    }

    def edit = {
        def ${propertyName} = ${className}.get( params.id )

        if(!${propertyName}) {
            flash.message = "\${message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])}"
            redirect(action:list)
        }
        else {
            return [ ${propertyName} : ${propertyName} ]
        }
    }

    def update = {
        def ${propertyName} = ${className}.get( params.id )
        if(${propertyName}) {
            if(params.version) {
                def version = params.version.toLong()
                if(${propertyName}.version > version) {
                 
                    ${propertyName}.errors.rejectValue("version", "${lowerCaseName}.optimistic.locking.failure", "Otro usuario esta modificando  ${className} mientras usted lo esta editando.")
                    render(view:'edit',model:[${propertyName}:${propertyName}])
                    return
                }
            }
            ${propertyName}.properties = params
            if(!${propertyName}.hasErrors() && ${propertyName}.save()) {
                flash.message = "\${message(code: 'default.updated.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])}"
                redirect(action:show,id:${propertyName}.id)
            }
            else {
                render(view:'edit',model:[${propertyName}:${propertyName}])
            }
        }
        else {
            flash.message = "\${message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])}"
            redirect(action:list)
        }
    }

    def create = {
        def ${propertyName} = new ${className}()
        ${propertyName}.properties = params
        return ['${propertyName}':${propertyName}]
    }

    def save = {
        def ${propertyName} = new ${className}(params)
        if(!${propertyName}.hasErrors() && ${propertyName}.save()) {
            flash.message = "\${message(code: 'default.created.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])}"
            redirect(action:show,id:${propertyName}.id)
        }
        else {
            render(view:'create',model:[${propertyName}:${propertyName}])
        }
    }
     def search = {
          def ${propertyName} = new ${className}Command()

        if(${propertyName}.validateAllParams(params)!=""){
           flash.message=${propertyName}.validateAllParams(params)
        }
        ${propertyName}.commandSetParameters(params)
        def count=${lowerCaseName}Service.getAllCount(${propertyName})
        if(params?.format && params.format != "html")${propertyName}.max=count
        def results=${lowerCaseName}Service.getAll(${propertyName})
        if(params?.format && params.format != "html"){
            exportToFile(results)
         }
        render(view:'list', model:[ ${lowerCaseName}InstanceList:results, ${lowerCaseName}InstanceTotal:count ,${propertyName}:${propertyName}])
      }
 
}
