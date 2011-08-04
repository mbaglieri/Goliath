

import groovyx.net.http.AsyncHTTPBuilder
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.RESTClient
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import java.lang.reflect.InvocationTargetException


class GoliathGrailsPlugin {
   // the plugin version
    def version = "0.5"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.4 > *"
    // the other plugins this plugin depends on
   def dependsOn = [calendar:'1.2.0 > *',
            quartz: '0.4.1 > *',
            bubbling:"2.1.2 > *",
            hibernate:"1.1.2 > *",
            tomcat:"1.1 > *",
            yui:"2.7.0.1 > *" ,
            springSecurityCore:"1.0.1 > *"]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]
    def observe = ['controllers', 'services']


    // TODO Fill in these fields
    def author = "Carlos Matias Baglieri"
    def authorEmail = "matiasbaglieri@gmail.com"
    def title = "Plugin Goliath Custom Crud With Search filters,authentication, menu, quartz...."
    def description = '''\\
    This plugin has a custom crud , menu quartz and Spring Security Core base configuration. export configured and others thinks.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/goliath"

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before 
    }

    def doWithSpring = {
        
    }

    def doWithDynamicMethods = { ctx ->
        processArtifacts()
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = {  event ->
        processArtifacts()
    }

    def onConfigChange = {event ->
        processArtifacts()
    }
	private processArtifacts() {
		def config = ConfigurationHolder.config
		def application = ApplicationHolder.application
		def types = config.grails?.rest?.injectInto ?: ["Controller", "Service"]
		types.each { type ->
		   application.getArtefacts(type).each{ klass ->
			  addDynamicMethods(klass)
		   }
		}
	 }
	private addDynamicMethods(klass) {
		klass.metaClass.withAsyncHttp = withClient.curry(AsyncHTTPBuilder, klass)
		klass.metaClass.withHttp = withClient.curry(HTTPBuilder, klass)
		klass.metaClass.withRest = withClient.curry(RESTClient, klass)
	 }
	private withClient = { Class klass, Object target, Map params, Closure closure ->
		def client = null
		if(params.id) {
		   String id = params.remove("id").toString()
		   if(target.metaClass.hasProperty(target, id)) {
			  client = target."$id"
		   } else {
			  client = makeClient(klass, params)
			  target.metaClass."$id" = client
		   }
		} else {
		  client = makeClient(klass, params)
		}
  
		if(params.containsKey("proxy")) {
		   Map proxyArgs = [scheme: "http", port: 80] + params.remove("proxy")
		   if(!proxyArgs.host) throw new IllegalArgumentException("proxy.host cannot be null!")
		   client.setProxy(proxyArgs.host, proxyArgs.port as int, proxyArgs.scheme)
		}
  
		if(closure) {
		   closure.delegate = client
		   closure.resolveStrategy = Closure.DELEGATE_FIRST
		   closure()
		}
	 }
  
	 private makeClient(Class klass, Map params) {
		if(klass == AsyncHTTPBuilder) {
		   try {
			  Map args = [:]
			  ["threadPool", "poolSize", "uri", "contentType", "timeout"].each { arg ->
				 if(params[(arg)] != null) args[(arg)] = params[(arg)]
			  }
			  return klass.newInstance(args)
		   } catch (IllegalArgumentException e) {
			  throw new RuntimeException("Failed to create async http client reason: $e", e)
		   } catch (InvocationTargetException e) {
			  throw new RuntimeException("Failed to create async http client reason: $e", e)
		   }
		}
		try {
		   def client =  klass.newInstance()
		   if(params.uri) client.uri = params.remove("uri")
		   if(params.contentType) client.contentType = params.remove("contentType")
		   return client
		} catch (IllegalArgumentException e) {
		   throw new RuntimeException("Failed to create ${(klass == HTTPBuilder? 'http' : 'rest')} client reason: $e", e)
		} catch (InvocationTargetException e) {
		   throw new RuntimeException("Failed to create ${(klass == HTTPBuilder? 'http' : 'rest')} client reason: $e", e)
		}
	 }
}
