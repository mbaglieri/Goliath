package ar.com.goliath


class RoleService {

    boolean transactional = true
    def getAll(RoleCommand params) {
        def c = Role.createCriteria()
        def results = c.list([offset:params.offset,max:params.max]) {
            and{
           
                        if(params.authority!=null){
                            like('authority', params.authority)
                        }
                    
            }
        }

        return results
    }
    def getAllCount(RoleCommand params) {
        def c = Role.createCriteria()
         def results = c.get() {
           
                        if(params.authority!=null){
                            like('authority', params.authority)
                        }
                    
            projections{
                count("id")
            }
        }
        return results
    }
}