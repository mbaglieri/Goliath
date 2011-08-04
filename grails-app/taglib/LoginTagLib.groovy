class LoginTagLib {
  def loginControl = {
    if(session?.SPRING_SECURITY_LAST_USERNAME){
      out << "<gui:menuitem url='../logout'>${session.SPRING_SECURITY_LAST_USERNAME} logout</gui:menuitem>"
    }
  }
}
