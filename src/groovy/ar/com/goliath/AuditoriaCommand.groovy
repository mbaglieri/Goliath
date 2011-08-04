/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.goliath

/**
 *
 * @author matias
 */
class AuditoriaCommand {
        String usuario;
        //Rol del usuario (rol_name).
        String role;
        //Acción que realizó el usuario, modificar, borrar, crear..
        String accion;
        //Nombre de la clase del objeto JSON.
        String nombreObjeto;
        //Contiene la info de la acción (XML, obj JSON)
        String detalle;
        String sort;
        String order
        //Fecha en la que se realizó la acción
        boolean status ,hasStatus=false,statusA,statusB

	 Date fechaLogh
	 Date fechaLogd
         String offset
         String max
         boolean hasfechaLog(){
             fechaLogd!=null &&fechaLogh!=null
         }
         boolean hasFechaDesaf(){
             //fecDesafd!=null &&fecDesafh!=null
         }
         String validateAllParams(Object params){
             String val=""

             if(params?.fechaLogd_value || params?.fechaLogh_value){
                if((params.fechaLogd_value!="" && params.fechaLogh_value=="")
                    ||(params.fechaLogd_value=="" && params.fechaLogh_value=="")){
                    val=val+"Para filtrar por fecha de log debe ingresar desde y hasta /"
                }
             }/*/*
             if(params?.fecDesafd || params?.fecDesafh ){
                if(!params?.fecDesafd || !params?.fecDesafh ){
                    val=val+"Para filtrar por fecha de desafectación debe ingresar desde y hasta"
                }
             }*/
            return val
         }
         void auditoriaCommandSetParameters(Object params){
            usuario=params.usuario
            accion=params.accion
            nombreObjeto=params?.nombreObjeto
            statusA=params?.statusA
            statusB=params?.statusB
            sort=params?.sort?params?.sort:"fechaLog"
            order=params?.order?params.order:"desc"

            if(params?.statusA&& params.statusA=="on" &&!params?.statusB&& params.statusB!="on"){
                status=true
                hasStatus=true
            }else if(params?.statusB&& params.statusB=="on" &&!params?.statusA&& params.statusA!="on"){
                status=false
                hasStatus=true
            }
            offset=params?.offset?params.offset:"0"
            max=params?.max?params.max:"5"
            java.text.SimpleDateFormat fm= new java.text.SimpleDateFormat("dd/MM/yyyy")
             if(params?.fechaLogh_value && params?.fechaLogd_value ){
                 if((params.fechaLogd_value!="" && params.fechaLogh_value!="")){
                fechaLogh=fm.parse("${params.fechaLogh_value}")
                fechaLogd=fm.parse("${params.fechaLogd_value}")
                }
            }/*
            if(params?.fecDesafd && params?.fecDesafh && params.fecDesafd_day!="" && params.fecDesafh_day!=""){
                fecDesafd=fm.parse("${params.fecDesafd_value}")
                fecDesafh=fm.parse("${params.fecDesafh_value}")
            }    */
         }
}

