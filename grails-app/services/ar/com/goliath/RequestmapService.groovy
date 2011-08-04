package ar.com.goliath


class RequestmapService {

    boolean transactional = true
    def getAll(RequestmapCommand params) {
        def c = Requestmap.createCriteria()
        def results = c.list([offset:params.offset,max:params.max]) {
            and{
           
                        if(params.url!=null){
                            like('url', params.url)
                        }
                    
                        if(params.configAttribute!=null){
                            like('configAttribute', params.configAttribute)
                        }
                    
            }
        }

        return results
    }
    def getAllCount(RequestmapCommand params) {
        def c = Requestmap.createCriteria()
         def results = c.get() {
           
                        if(params.url!=null){
                            like('url', params.url)
                        }
                    
                        if(params.configAttribute!=null){
                            like('configAttribute', params.configAttribute)
                        }
                    
            projections{
                count("id")
            }
        }
        return results
    }
}