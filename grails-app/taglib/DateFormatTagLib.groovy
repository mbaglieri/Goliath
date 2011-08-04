class DateFormatTagLib {
    static namespace = 'fmt'
    def dateFormat = { attrs ->
         out << (attrs.value==null?new String(''):new java.text.SimpleDateFormat(attrs.format).format(attrs.value))
    }
    def inputDateFormat = { attrs ->
         out <<  "<input type='text' id='${attrs.id}' readonly='true'   name='${attrs.id}' value='"
         out << (attrs.value==null?new String(''):new java.text.SimpleDateFormat(attrs.format).format(attrs.value))
         out << "' />"
    }
}
