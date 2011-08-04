

package ar.com.goliath

import ar.com.goliath.AuditoriaCommand;
import ar.com.goliath.Auditoria;

class AuditoriaController {
    def auditoriaService
    
    def index = {
        redirect action:"list", params:params 
    }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
        def auditoriaInstance = new AuditoriaCommand()
        if(auditoriaInstance.validateAllParams(params)!=""){
           flash.message=auditoriaInstance.validateAllParams(params)
        }
        auditoriaInstance.auditoriaCommandSetParameters(params)
        [ auditoriaInstanceList: Auditoria.list( params ), auditoriaInstanceTotal: Auditoria.count(),auditoriaInstance1:auditoriaInstance, params:params  ]
    }

    def show = {
        def auditoriaInstance = Auditoria.get( params.id )

        if(!auditoriaInstance) {
            flash.message = "Auditoria not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            [ auditoriaInstance : auditoriaInstance ]
        }
    }
   
    def search = {
        def auditoriaInstance = new AuditoriaCommand()
        if(auditoriaInstance.validateAllParams(params)!=""){
           flash.message=auditoriaInstance.validateAllParams(params)
        }
        auditoriaInstance.auditoriaCommandSetParameters(params)
        def count=auditoriaService.getAllAuditoriaCount(auditoriaInstance)
        def results=auditoriaService.getAllAuditoria(auditoriaInstance)
        render(view:'list', model:[ auditoriaInstanceList:results, auditoriaInstanceTotal:count ,auditoriaInstance1:auditoriaInstance, params:params ])
    }
}
