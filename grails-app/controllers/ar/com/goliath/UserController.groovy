package ar.com.goliath


import org.codehaus.groovy.grails.commons.ConfigurationHolder
class UserController {
    def exportService
	def springSecurityService
    def userService
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
                 def userInstance = new UserCommand()

        if(userInstance.validateAllParams(params)!=""){
           flash.message=userInstance.validateAllParams(params)
        }
        userInstance.commandSetParameters(params)
        def count=userService.getAllCount(userInstance)
        if(params?.format && params.format != "html")userInstance.max=count
        def results=userService.getAll(userInstance)
        if(params?.format && params.format != "html"){
            exportToFile(results)
         }
	[ userInstanceList:results, userInstanceTotal:count ,userInstance:userInstance]
    }

    def show = {
        def userInstance = User.get( params.id )

        if(!userInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action:list)
        }
        else { return [ userInstance : userInstance ] }
    }

    def delete = {
        def userInstance = User.get( params.id )
        if(userInstance) {
            try {
                userInstance.delete(flush:true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action:list)
        }
    }

    def edit = {
        def userInstance = User.get( params.id )

        if(!userInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action:list)
        }
        else {
            return [ userInstance : userInstance ]
        }
    }

    def update = {
        def userInstance = User.get( params.id )
        if(userInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(userInstance.version > version) {
                 
                    userInstance.errors.rejectValue("version", "user.optimistic.locking.failure", "Otro usuario esta modificando  User mientras usted lo esta editando.")
                    render(view:'edit',model:[userInstance:userInstance])
                    return
                }
            }
			if (userInstance.password != params.password) {
				params.password = springSecurityService.encodePassword(
						   params.password, userInstance.username)
			 }
            userInstance.properties = params
            if(!userInstance.hasErrors() && userInstance.save()) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
				if (springSecurityService.loggedIn &&
					springSecurityService.principal.username == userInstance.username) {
									springSecurityService.reauthenticate userInstance.username
					}
				redirect(action:show,id:userInstance.id)
            }
            else {
                render(view:'edit',model:[userInstance:userInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action:list)
        }
    }

    def create = {
        def userInstance = new User()
        userInstance.properties = params
        return ['userInstance':userInstance]
    }

    def save = {
        def userInstance = new User(params)
		userInstance.password = springSecurityService.encodePassword(
			params.password, userInstance.username)
        if(!userInstance.hasErrors() && userInstance.save()) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
            redirect(action:show,id:userInstance.id)
        }
        else {
            render(view:'create',model:[userInstance:userInstance])
        }
    }
     def search = {
          def userInstance = new UserCommand()

        if(userInstance.validateAllParams(params)!=""){
           flash.message=userInstance.validateAllParams(params)
        }
        userInstance.commandSetParameters(params)
        def count=userService.getAllCount(userInstance)
        if(params?.format && params.format != "html")userInstance.max=count
        def results=userService.getAll(userInstance)
        if(params?.format && params.format != "html"){
            exportToFile(results)
         }
        render(view:'list', model:[ userInstanceList:results, userInstanceTotal:count ,userInstance:userInstance])
      }
      void exportToFile(List result){
        java.text.SimpleDateFormat fm= new java.text.SimpleDateFormat("dd/MM/yyyy")
        response.contentType = ConfigurationHolder.config.grails.mime.types[params.format]
        response.setHeader("Content-disposition", "attachment; filename=User.${params.extension}")
        List fields = ['username','password','accountExpired','accountLocked','enabled','passwordExpired']
           Map labels = ['username':'username','password':'password','accountExpired':'accountExpired','accountLocked':'accountLocked','enabled':'enabled','passwordExpired':'passwordExpired']
        // Formatter closure
        def upperCase = { value -> return value.toUpperCase() }
        def dateFormat = { value -> return value!=null?fm.format(value):null }
        Map formatters = ["":""]
        Map parameters = [title: "Listado de User"]
        exportService.export(params.format, response.outputStream, result, fields, labels, formatters, parameters)

    }
}
