import org.codehaus.groovy.grails.scaffolding.*
import org.codehaus.groovy.grails.scaffolding.DefaultGrailsTemplateGenerator
import grails.util.GrailsNameUtils
import groovy.text.*
import org.codehaus.groovy.text.*

includeTargets << grailsScript("_GrailsCreateArtifacts")
includeTargets << grailsScript("_GrailsGenerate")
includeTargets << grailsScript("_GrailsBootstrap")

generateForName = null
generateViews = true
generateController = true
generateService = true
generateCommand=true
target ('default': "Generates a CRUD interface (controller + views + service +command) for a domain class") {
	depends( configureProxy, packageApp, classpath, loadApp, configureApp,parseArguments ,checkVersion)
    	promptForName(type: "Domain Class")


    try {
        def name = argsMap["params"][0]
        if (!name || name == "*") {
            uberGenerate()
        }
        else {
            generateForName = name
            generateForOne()
        }
        }
    catch(Exception e) {
        logError("Error running generate-crud", e)
        exit(1)
    }
}


target(generateForOne: "Generates controllers and views and service and command for only one domain class.") {

    def name = generateForName
    name = name.indexOf('.') > -1 ? name : GrailsNameUtils.getClassNameRepresentation(name)
    def domainClass = grailsApp.getDomainClass(name)

    if(!domainClass) {
        println "Domain class not found in grails-app/domain, trying hibernate mapped classes..."
        bootstrap()
        domainClass = grailsApp.getDomainClass(name)
    }

    if(domainClass) {
        generateForDomainClass(domainClass)
        event("StatusFinal", ["Finished generation for domain class ${domainClass.fullName}"])
    }
    else {
        event("StatusFinal", ["No domain class found for name ${name}. Please try again and enter a valid domain class name"])
    }
}

target(uberGenerate: "Generates controllers and views and service and command for all domain classes.") {

    def domainClasses = grailsApp.domainClasses

    if (!domainClasses) {
        println "No se encontraron dominios"
        bootstrap()
        domainClasses = grailsApp.domainClasses
    }

   if (domainClasses) {
        domainClasses.each { domainClass ->
	   if(!domainClass.name.equals("Role")&&!domainClass.name.equals("Auditoria")&&
										    !domainClass.name.equals("AuditoriaBatch")&&
										    !domainClass.name.equals("Person")&&
										    !domainClass.name.equals("Requestmap")&&
										    !domainClass.name.equals("User")&&
										    !domainClass.name.equals("UserRole")){
            generateForDomainClass(domainClass)
            }
        }
        event("StatusFinal", ["Fin de generacion de las clases"])
    }
    else {
        event("StatusFinal", ["No se encontraron dominios"])
    }
}


def generateForDomainClass(domainClass) {
    def templateGenerator = new DefaultGrailsTemplateGenerator(classLoader)
    def templateGenerator1 =classLoader.loadClass("org.codehaus.groovy.grails.scaffolding.DefaultGrailsTemplateGeneratorGoliath").getConstructor().newInstance()
        event("StatusUpdate", ["Generating views for domain class ${domainClass.fullName}"])
        templateGenerator.generateViews(domainClass, basedir)
        event("GenerateViewsEnd", [domainClass.fullName])
        event("StatusUpdate", ["Generating controller for domain class ${domainClass.fullName}"])
        templateGenerator.generateController(domainClass, basedir)
        event("GenerateControllerEnd", [domainClass.fullName])
        event("StatusUpdate", ["Generating Service for domain class ${domainClass.fullName}"])
        templateGenerator1.generateService(domainClass, basedir)
        event("generateService", [domainClass.fullName])
        event("StatusUpdate", ["Generating Command for domain class ${domainClass.fullName}"])
        templateGenerator1.generateCommand(domainClass, basedir)
        event("generateCommand", [domainClass.fullName])
}
