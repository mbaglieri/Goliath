package ar.com.goliath

class AuditoriaBatch {
    String usuario;
    //Acción que realizó el usuario, modificar, borrar, crear..
    String accion;
    //Nombre de la clase del objeto JSON.
    String nombreObjeto;
    //Contiene la info de la acción (XML, obj JSON)
    Boolean status
    
    String detalle;
    //Fecha en la que se realizó la acción
    Date fechaLog;
   def beforeInsert = {
       fechaLog = new Date()
   }

    static constraints = {
        fechaLog(nullable:true)
    }
    static mapping = {
      detalle type:'text'
   }
}
