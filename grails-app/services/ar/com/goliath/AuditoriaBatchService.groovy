package ar.com.goliath
import ar.com.goliath.AuditoriaBatch;
import ar.com.goliath.AuditoriaCommand;
import grails.converters.*

class AuditoriaBatchService {

    boolean transactional = true
    java.text.SimpleDateFormat fm= new java.text.SimpleDateFormat("dd/MM/yyyy")
    def getAllAuditoria(AuditoriaCommand params) {
        def c = AuditoriaBatch.createCriteria()
        def results = c.list([offset:params.offset,max:params.max]) {
            and{
                 if(params.usuario!="" && params?.usuario){
                    like('usuario', params.usuario)
                }

                if(params?.nombreObjeto){
                    like('nombreObjeto', params.nombreObjeto)
                }
                if(params?.hasStatus){
                    eq('status', params.status)
                }
                if(params?.accion){
                    like('accion', params.accion)
                }

                if(params?.fechaLogd){
                    between('fechaLog',params.fechaLogd,params.fechaLogh)
                }
            }
            order(params.sort,params.order)

        }

        return results
    }
      def getAllAuditoriaCount(AuditoriaCommand params) {
        def c = AuditoriaBatch.createCriteria()
        def results = c.get() {
            if(params.usuario!="" && params?.usuario){
                like('usuario', params.usuario)
            }

            if(params?.nombreObjeto){
                like('nombreObjeto', params.nombreObjeto)
            }
            if(params?.accion){
                like('accion',params.accion)
            }
            if(params?.hasStatus){
                eq('status', params.status)
            }
            if(params?.fechaLogd){
                between('fechaLog',params.fechaLogd,params.fechaLogh)
            }
            projections{
                count("id")
            }
        }
        return results
    }
    public void addAuditoriaUpload(String action,String NombObjeto,JSON detalle,boolean status,String usuario){
        def audit=new AuditoriaBatch()
        audit.usuario=usuario
        audit.accion=action
        audit.nombreObjeto=NombObjeto
        audit.status=status
        audit.detalle=detalle
        audit.save()
    }
    public void addAuditoriaUploadString(String action,String NombObjeto,String detalle,boolean status,String usuario){
        def audit=new AuditoriaBatch()
        audit.usuario=usuario
        audit.accion=action
        audit.nombreObjeto=NombObjeto
        audit.status=status
        audit.detalle=detalle
        audit.save()
    }
    public void addAuditoriaInterface(String accion,String NombObjeto,JSON detalle,boolean status,String usuario){
        def audit=new AuditoriaBatch()
        audit.usuario=""
        audit.accion=accion
        audit.nombreObjeto=NombObjeto
        audit.status=status
        audit.detalle=detalle
        audit.save()
    }
}
