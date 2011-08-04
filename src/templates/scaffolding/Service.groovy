<%=packageName ? "package ${packageName}\n\n" : ''%>
class ${className}Service {

    boolean transactional = true
    def getAll(${className}Command params) {
        def c = ${className}.createCriteria()
        def results = c.list([offset:params.offset,max:params.max]) {
            and{
           <%excludedProps = ['version', 'id']
           props = domainClass.properties.findAll { !excludedProps.contains(it.name) }
            Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
            props.each { p ->
                if(!Collection.class.isAssignableFrom(p.type)) {
                    cp = domainClass.constrainedProperties[p.name]
                    display = (cp ? cp.display : true)
                    if(display) {
                        if(p.type.toString().contains("String")){%>
                        if(params.${p.name}!=null){
                            like('${p.name}', params.${p.name})
                        }
                    <%}}
                }
            }%>
            }
        }

        return results
    }
    def getAllCount(${className}Command params) {
        def c = ${className}.createCriteria()
         def results = c.get() {
           <%excludedProps = ['version', 'id']
           props = domainClass.properties.findAll { !excludedProps.contains(it.name) }
            Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
            props.each { p ->
                if(!Collection.class.isAssignableFrom(p.type)) {
                    cp = domainClass.constrainedProperties[p.name]
                    display = (cp ? cp.display : true)
                    if(display) {
                        if(p.type.toString().contains("String")){%>
                        if(params.${p.name}!=null){
                            like('${p.name}', params.${p.name})
                        }
                    <%}}
                }
            }%>
            projections{
                count("id")
            }
        }
        return results
    }
}