package ar.com.goliath


import org.codehaus.groovy.grails.commons.ConfigurationHolder
import ar.com.goliath.RequestmapCommand;
class RequestmapController {
    def exportService
	def springSecurityService
    def requestmapService
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
                 def requestmapInstance = new RequestmapCommand()

        if(requestmapInstance.validateAllParams(params)!=""){
           flash.message=requestmapInstance.validateAllParams(params)
        }
        requestmapInstance.commandSetParameters(params)
        def count=requestmapService.getAllCount(requestmapInstance)
        if(params?.format && params.format != "html")requestmapInstance.max=count
        def results=requestmapService.getAll(requestmapInstance)
        if(params?.format && params.format != "html"){
            exportToFile(results)
         }
	[ requestmapInstanceList:results, requestmapInstanceTotal:count ,requestmapInstance:requestmapInstance]
    }

    def show = {
        def requestmapInstance = Requestmap.get( params.id )

        if(!requestmapInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), params.id])}"
            redirect(action:list)
        }
        else { return [ requestmapInstance : requestmapInstance ] }
    }

    def delete = {
        def requestmapInstance = Requestmap.get( params.id )
        if(requestmapInstance) {
            try {
                requestmapInstance.delete(flush:true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), params.id])}"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), params.id])}"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), params.id])}"
            redirect(action:list)
        }
    }

    def edit = {
        def requestmapInstance = Requestmap.get( params.id )

        if(!requestmapInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), params.id])}"
            redirect(action:list)
        }
        else {
            return [ requestmapInstance : requestmapInstance ]
        }
    }

    def update = {
        def requestmapInstance = Requestmap.get( params.id )
        if(requestmapInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(requestmapInstance.version > version) {
                 
                    requestmapInstance.errors.rejectValue("version", "requestmap.optimistic.locking.failure", "Otro usuario esta modificando  Requestmap mientras usted lo esta editando.")
                    render(view:'edit',model:[requestmapInstance:requestmapInstance])
                    return
                }
            }
            requestmapInstance.properties = params
            if(!requestmapInstance.hasErrors() && requestmapInstance.save()) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), requestmapInstance.id])}"
                redirect(action:show,id:requestmapInstance.id)
            }
            else {
                render(view:'edit',model:[requestmapInstance:requestmapInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), params.id])}"
            redirect(action:list)
        }
    }

    def create = {
        def requestmapInstance = new Requestmap()
        requestmapInstance.properties = params
        return ['requestmapInstance':requestmapInstance]
    }

    def save = {
        def requestmapInstance = new Requestmap(params)
        if(!requestmapInstance.hasErrors() && requestmapInstance.save()) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), requestmapInstance.id])}"
			springSecurityService.clearCachedRequestmaps()
			redirect(action:show,id:requestmapInstance.id)
        }
        else {
            render(view:'create',model:[requestmapInstance:requestmapInstance])
        }
    }
     def search = {
          def requestmapInstance = new RequestmapCommand()

        if(requestmapInstance.validateAllParams(params)!=""){
           flash.message=requestmapInstance.validateAllParams(params)
        }
        requestmapInstance.commandSetParameters(params)
        def count=requestmapService.getAllCount(requestmapInstance)
        if(params?.format && params.format != "html")requestmapInstance.max=count
        def results=requestmapService.getAll(requestmapInstance)
        if(params?.format && params.format != "html"){
            exportToFile(results)
         }
        render(view:'list', model:[ requestmapInstanceList:results, requestmapInstanceTotal:count ,requestmapInstance:requestmapInstance])
      }
      void exportToFile(List result){
        java.text.SimpleDateFormat fm= new java.text.SimpleDateFormat("dd/MM/yyyy")
        response.contentType = ConfigurationHolder.config.grails.mime.types[params.format]
        response.setHeader("Content-disposition", "attachment; filename=Requestmap.${params.extension}")
        List fields = ['url','configAttribute']
           Map labels = ['url':'url','configAttribute':'configAttribute']
        // Formatter closure
        def upperCase = { value -> return value.toUpperCase() }
        def dateFormat = { value -> return value!=null?fm.format(value):null }
        Map formatters = ["":""]
        Map parameters = [title: "Listado de Requestmap"]
        exportService.export(params.format, response.outputStream, result, fields, labels, formatters, parameters)

    }
}
