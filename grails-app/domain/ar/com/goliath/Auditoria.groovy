package ar.com.goliath

class Auditoria {
  // Una auditoría pertence a un solo empleado
    //Usuario que realiza la acción (login name).
    String usuario;
    //Rol del usuario (rol_name).
    String role;
    //Acción que realizó el usuario, modificar, borrar, crear..
    String accion;
    //Nombre de la clase del objeto JSON.
    String nombreObjeto;
    //Contiene la info de la acción (XML, obj JSON)
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
