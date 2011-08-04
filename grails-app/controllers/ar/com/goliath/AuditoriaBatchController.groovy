

package ar.com.goliath

import ar.com.goliath.AuditoriaCommand;
import ar.com.goliath.AuditoriaBatch;

class AuditoriaBatchController {
    def auditoriaBatchService
    def index = {
        redirect action:"list", params:params 
    }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 5,  100)
        [ auditoriaBatchInstanceList: AuditoriaBatch.list( params ), auditoriaBatchInstanceTotal: AuditoriaBatch.count() ]
    }

    def show = {
        def auditoriaBatchInstance = AuditoriaBatch.get( params.id )

        if(!auditoriaBatchInstance) {
            flash.message = "AuditoriaBatch not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            [ auditoriaBatchInstance : auditoriaBatchInstance ]
        }
    }

    def delete = {
        def auditoriaBatchInstance = AuditoriaBatch.get( params.id )
        if(auditoriaBatchInstance) {
            try {
                auditoriaBatchInstance.delete(flush:true)
                flash.message = "AuditoriaBatch ${params.id} deleted"
                redirect(action:"list")
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "AuditoriaBatch ${params.id} could not be deleted"
                redirect(action:"show",id:params.id)
            }
        }
        else {
            flash.message = "AuditoriaBatch not found with id ${params.id}"
            redirect(action:"list")
        }
    }

    def edit = {
        def auditoriaBatchInstance = AuditoriaBatch.get( params.id )

        if(!auditoriaBatchInstance) {
            flash.message = "AuditoriaBatch not found with id ${params.id}"
            redirect action:'list'
        }
        else {
            return [ auditoriaBatchInstance : auditoriaBatchInstance ]
        }
    }

    def update = {
        def auditoriaBatchInstance = AuditoriaBatch.get( params.id )
        if(auditoriaBatchInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(auditoriaBatchInstance.version > version) {
                    
                    auditoriaBatchInstance.errors.rejectValue("version", "auditoriaBatch.optimistic.locking.failure", "Another user has updated this AuditoriaBatch while you were editing.")

                    render view:'edit', model:[auditoriaBatchInstance:auditoriaBatchInstance]
                    return
                }
            }
            auditoriaBatchInstance.properties = params
            if(!auditoriaBatchInstance.hasErrors() && auditoriaBatchInstance.save()) {
                flash.message = "AuditoriaBatch ${params.id} updated"

                redirect action:'show', id:auditoriaBatchInstance.id
            }
            else {
                render view:'edit', model:[auditoriaBatchInstance:auditoriaBatchInstance]
            }
        }
        else {
            flash.message = "AuditoriaBatch not found with id ${params.id}"
            redirect action:'list'
        }
    }

    def create = {
        def auditoriaBatchInstance = new AuditoriaBatch()
        auditoriaBatchInstance.properties = params
        return ['auditoriaBatchInstance':auditoriaBatchInstance]
    }

    def save = {
        def auditoriaBatchInstance = new AuditoriaBatch(params)
        if(auditoriaBatchInstance.save(flush:true)) {
            flash.message = "AuditoriaBatch ${auditoriaBatchInstance.id} created"

            redirect action:"show", id:auditoriaBatchInstance.id
        }
        else {
            render view:'create', model:[auditoriaBatchInstance:auditoriaBatchInstance]
        }
    }
   def search = {
        def auditoriaInstance = new AuditoriaCommand()
        if(auditoriaInstance.validateAllParams(params)!=""){
           flash.message=auditoriaInstance.validateAllParams(params)
        }
        auditoriaInstance.auditoriaCommandSetParameters(params)
        def count=auditoriaBatchService.getAllAuditoriaCount(auditoriaInstance)
        def results=auditoriaBatchService.getAllAuditoria(auditoriaInstance)
        render(view:'list', model:[ auditoriaBatchInstanceList:results, auditoriaBatchInstanceTotal:count ,auditoriaInstance1:auditoriaInstance])
  }
}
