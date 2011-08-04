package ar.com.goliath


import org.codehaus.groovy.grails.commons.ConfigurationHolder
class RoleController {
    def exportService
   
    def roleService
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
                 def roleInstance = new RoleCommand()

        if(roleInstance.validateAllParams(params)!=""){
           flash.message=roleInstance.validateAllParams(params)
        }
        roleInstance.commandSetParameters(params)
        def count=roleService.getAllCount(roleInstance)
        if(params?.format && params.format != "html")roleInstance.max=count
        def results=roleService.getAll(roleInstance)
        if(params?.format && params.format != "html"){
            exportToFile(results)
         }
	[ roleInstanceList:results, roleInstanceTotal:count ,roleInstance:roleInstance]
    }

    def show = {
        def roleInstance = Role.get( params.id )

        if(!roleInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), params.id])}"
            redirect(action:list)
        }
        else { return [ roleInstance : roleInstance ] }
    }

    def delete = {
        def roleInstance = Role.get( params.id )
        if(roleInstance) {
            try {
                roleInstance.delete(flush:true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'role.label', default: 'Role'), params.id])}"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'role.label', default: 'Role'), params.id])}"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), params.id])}"
            redirect(action:list)
        }
    }

    def edit = {
        def roleInstance = Role.get( params.id )

        if(!roleInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), params.id])}"
            redirect(action:list)
        }
        else {
            return [ roleInstance : roleInstance ]
        }
    }

    def update = {
        def roleInstance = Role.get( params.id )
        if(roleInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(roleInstance.version > version) {
                 
                    roleInstance.errors.rejectValue("version", "role.optimistic.locking.failure", "Otro usuario esta modificando  Role mientras usted lo esta editando.")
                    render(view:'edit',model:[roleInstance:roleInstance])
                    return
                }
            }
            roleInstance.properties = params
            if(!roleInstance.hasErrors() && roleInstance.save()) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'role.label', default: 'Role'), roleInstance.id])}"
                redirect(action:show,id:roleInstance.id)
            }
            else {
                render(view:'edit',model:[roleInstance:roleInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), params.id])}"
            redirect(action:list)
        }
    }

    def create = {
        def roleInstance = new Role()
        roleInstance.properties = params
        return ['roleInstance':roleInstance]
    }

    def save = {
        def roleInstance = new Role(params)
        if(!roleInstance.hasErrors() && roleInstance.save()) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'role.label', default: 'Role'), roleInstance.id])}"
            redirect(action:show,id:roleInstance.id)
        }
        else {
            render(view:'create',model:[roleInstance:roleInstance])
        }
    }
     def search = {
          def roleInstance = new RoleCommand()

        if(roleInstance.validateAllParams(params)!=""){
           flash.message=roleInstance.validateAllParams(params)
        }
        roleInstance.commandSetParameters(params)
        def count=roleService.getAllCount(roleInstance)
        if(params?.format && params.format != "html")roleInstance.max=count
        def results=roleService.getAll(roleInstance)
        if(params?.format && params.format != "html"){
            exportToFile(results)
         }
        render(view:'list', model:[ roleInstanceList:results, roleInstanceTotal:count ,roleInstance:roleInstance])
      }
      void exportToFile(List result){
        java.text.SimpleDateFormat fm= new java.text.SimpleDateFormat("dd/MM/yyyy")
        response.contentType = ConfigurationHolder.config.grails.mime.types[params.format]
        response.setHeader("Content-disposition", "attachment; filename=Role.${params.extension}")
        List fields = ['authority']
           Map labels = ['authority':'authority']
        // Formatter closure
        def upperCase = { value -> return value.toUpperCase() }
        def dateFormat = { value -> return value!=null?fm.format(value):null }
        Map formatters = ["":""]
        Map parameters = [title: "Listado de Role"]
        exportService.export(params.format, response.outputStream, result, fields, labels, formatters, parameters)

    }
}
