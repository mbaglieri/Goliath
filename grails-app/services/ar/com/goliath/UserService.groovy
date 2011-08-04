package ar.com.goliath


class UserService {

    boolean transactional = true
    def getAll(UserCommand params) {
        def c = User.createCriteria()
        def results = c.list([offset:params.offset,max:params.max]) {
            and{
           
                        if(params.username!=null){
                            like('username', params.username)
                        }
                    
                        if(params.password!=null){
                            like('password', params.password)
                        }
                    
            }
        }

        return results
    }
    def getAllCount(UserCommand params) {
        def c = User.createCriteria()
         def results = c.get() {
           
                        if(params.username!=null){
                            like('username', params.username)
                        }
                    
                        if(params.password!=null){
                            like('password', params.password)
                        }
                    
            projections{
                count("id")
            }
        }
        return results
    }
}