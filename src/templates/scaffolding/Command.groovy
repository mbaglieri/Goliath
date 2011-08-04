
<%=packageName ? "package ${packageName}\n\n" : ''%>class ${className}Command {
   <%excludedProps = ['version', 'id']
   props = domainClass.properties.findAll { !excludedProps.contains(it.name) }
    Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
    props.each { p ->
        if(!Collection.class.isAssignableFrom(p.type)) {
            cp = domainClass.constrainedProperties[p.name]
            display = (cp ? cp.display : true)
            if(display) {
                if(p.type.toString().contains("String")){%>
                String ${p.name}<%}}}}%>
    String offset
    String max
    String validateAllParams(Object params){
         String val=""
        /* if(params?.fechAfecd || params?.fechAfech){
            if(!params?.fechAfecd || !params?.fechAfech){
                val=val+"Para filtrar por fecha de afectación debe ingresar desde y hasta /"
            }
         }
         if(params?.fecDesafd || params?.fecDesafh ){
            if(!params?.fecDesafd || !params?.fecDesafh ){
                val=val+"Para filtrar por fecha de desafectación debe ingresar desde y hasta"
            }
         }*/
        return val
     }

     void commandSetParameters(Object params){
            offset=params?.offset?params.offset:"0"
            max=params?.max?params.max:"5"
               <%excludedProps = ['version', 'id']
   props = domainClass.properties.findAll { !excludedProps.contains(it.name) }
    Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
    props.each { p ->
        if(!Collection.class.isAssignableFrom(p.type)) {
            cp = domainClass.constrainedProperties[p.name]
            display = (cp ? cp.display : true)
            if(display) {
                if(p.type.toString().contains("String")){%>
                ${p.name}=params?.${p.name}?params.${p.name}:null<%}}}}%>

     }
}

