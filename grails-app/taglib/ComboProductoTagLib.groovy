class ComboProductoTagLib {
  def comboProducto = {attrs->
    
    out << "<select name='estado' id='estado'>"
    out << "<option value='null' "
    if(attrs.value==null){
        out << "selected='selected'"
    }
    out<<">Seleccionar</option>"
    out << "<option value='A' "
    if(attrs.value=="A" && attrs.value!=null){
        out << "selected='selected'"
    }
    out<<">A</option>"
    out << "<option value='B' "
    if(attrs.value=="B" && attrs.value!=null){
        out << "selected='selected'"
    }
    out<<">B</option>"
    out << "</select>"

  }
}
