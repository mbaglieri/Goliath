package ar.com.goliath

import ar.com.goliath.Auditoria;
import ar.com.goliath.AuditoriaCommand;

class AuditoriaService {

    boolean transactional = true
  java.text.SimpleDateFormat fm= new java.text.SimpleDateFormat("dd/MM/yyyy")
    def getAllAuditoria(AuditoriaCommand params) {
        def c = Auditoria.createCriteria()
        def results = c.list([offset:params.offset,max:params.max]) {
            and{
                 if(params.usuario!="" && params?.usuario){
                    like('usuario', params.usuario)
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
        def c = Auditoria.createCriteria()
        def results = c.get() {
            if(params.usuario!="" && params?.usuario){
                like('usuario', params.usuario)
            }
            if(params?.accion){
                like('accion', params.accion)
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
}
