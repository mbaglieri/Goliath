if(grails.util.GrailsUtil.grailsVersion.startsWith("1.0")) {
    includeTargets << new File ( "${grailsHome}/scripts/Init.groovy" )
} else {
    includeTargets << grailsScript("_GrailsInit")
    includeTargets << grailsScript("_GrailsCreateArtifacts")

}
target('default': "Configure app With goliath plugin") {
    depends(js)
    depends(css)
    depends(img)
   // depends(libs)
   //depends(dominios)
   // depends(controllers)
   // depends(taglib)
   // depends(services)
   // depends(src)
   // depends(views)
	depends(srcG)
    depends(templates)
    depends(layout)
    installGoliathConfig()
}

target(installGoliathConfig: "Configuring.......") {
    depends(checkVersion)

    def configFile = "${basedir}/grails-app/conf/Config.groovy"
   
        Ant.copy(
                file:"${goliathPluginDir}/grails-app/baseconfig/DefaultConfig",
                tofile:configFile,
                overwrite: true
        )
        event("CreatedFile", [configFile])
    def configFile0 = "${basedir}/grails-app/conf/DataSource.groovy"
    def confirm = confirmInput1("Desea configurar su aplicacion con la base de datos Mysql?")
    if(!(configFile0 as File).exists() ||confirm) {
        Ant.copy(
                file:"${goliathPluginDir}/grails-app/baseconfig/DefaultDataSourceMySql",
                tofile:configFile0,
                overwrite: true
        )        
        event("CreatedFile", [configFile0])
    }
    def configFile1 = "${basedir}/grails-app/conf/DataSource.groovy"
    if(!(configFile1 as File).exists() || !confirm) {
        Ant.copy(
                file:"${goliathPluginDir}/grails-app/baseconfig/DefaultDataSourceOracle",
                tofile:configFile1,
                overwrite: true
        )
        event("CreatedFile", [configFile1])
    }
    def configFile2 = "${basedir}/grails-app/conf/LoggingFilters.groovy"
        Ant.copy(
                file:"${goliathPluginDir}/grails-app/baseconfig/LoggingFilters",
                tofile:configFile2,
                overwrite: true
        )
        event("CreatedFile", [configFile2])
    def configFile3 = "${basedir}/grails-app/conf/SecurityFilters.groovy"
        Ant.copy(
                file:"${goliathPluginDir}/grails-app/baseconfig/SecurityFilters",
                tofile:configFile3,
                overwrite: true
        )
        event("CreatedFile", [configFile])
    def configFile4 = "${basedir}/grails-app/conf/UrlMappings.groovy"
        Ant.copy(
                file:"${goliathPluginDir}/grails-app/baseconfig/UrlMappings",
                tofile:configFile4,
                overwrite: true
        )
        event("CreatedFile", [configFile4])
    def configFile5 = "${basedir}/grails-app/conf/BootStrap.groovy"
        Ant.copy(
                file:"${goliathPluginDir}/grails-app/baseconfig/BootStrap",
                tofile:configFile5,
                overwrite: true
        )
        event("CreatedFile", [configFile5])
    def configFile6 = "${basedir}/src/groovy/org/codehaus/groovy/grails/scaffolding/DefaultGrailsTemplateGeneratorGoliath.groovy"
        Ant.copy(
                file:"${goliathPluginDir}/grails-app/baseconfig/DefaultGrailsTemplateGeneratorGoliath",
                tofile:configFile6,
                overwrite: true
        )
        event("CreatedFile", [configFile6])

        event("StatusFinal", ["Configuration Instaled..."])
		def configFile7 = "${basedir}/grails-app/conf/BuildConfig.groovy"
		Ant.copy(
				file:"${goliathPluginDir}/grails-app/baseconfig/BuildConfig",
				tofile:configFile7,
				overwrite: true
		)
		event("CreatedFile", [configFile7])
}
confirmInput1 = {String message ->
    Ant.input(message: message, addproperty: "confirm1.message", validargs: "y,n")
    Ant.antProject.properties."confirm1.message" == "y"
}
//Copiando Libs
target( 'libs' : 'Copiando jars') {
	ant.echo("Copiando Jars")
	ant.copy(todir: "${basedir}/lib") {
                path(refid: 'properties')
        }

}
def properties = ant.path(id: 'properties') {
 	fileset(dir: "${goliathPluginDir}/lib") {
                    include(name: '*.jar')
            }
}
//Copiando Dominios
target( 'dominios' : 'Copiando dominios') {
	ant.echo("Copiando dominios")
	ant.copy(todir: "${basedir}/grails-app/domain") {
                path(refid: 'dominios')
        }

}
def dominios = ant.path(id: 'dominios') {
 	fileset(dir: "${goliathPluginDir}/grails-app/domain") {
                    include(name: '**')
            }
}
//copiando Controllers
target( 'controllers' : 'Copiando controllers') {
	ant.echo("Copiando controllers")
	ant.copy(todir: "${basedir}/grails-app/controllers") {
                path(refid: 'controllers')
        }

}
def controllers = ant.path(id: 'controllers') {
 	fileset(dir: "${goliathPluginDir}/grails-app/controllers") {
                    include(name: '**')
            }
}
//copiar views
target( 'layout' : 'Copiando layout') {
	ant.echo("Copiando layout")
	ant.copy(todir: "${basedir}/grails-app/views/layouts") {
                path(refid: 'layout')
        }

}
def layout = ant.path(id: 'layout') {
 	fileset(dir: "${goliathPluginDir}/grails-app/views/layouts") {
                    include(name: '**')
            }
}
target( 'views' : 'Copiando views') {
	ant.echo("Copiando views")
	ant.copy(todir: "${basedir}/grails-app/views") {
                path(refid: 'views')
        }

}
def views = ant.path(id: 'views') {
 	fileset(dir: "${goliathPluginDir}/grails-app/views") {
                    include(name: '**')
            }
}
//copiar taglibs
target( 'taglib' : 'Copiando taglib') {
	ant.echo("Copiando taglib")
	ant.copy(todir: "${basedir}/grails-app/taglib") {
                path(refid: 'taglib')
        }

}
def taglib = ant.path(id: 'taglib') {
 	fileset(dir: "${goliathPluginDir}/grails-app/taglib") {
                    include(name: '**')
            }
}
//copiar services
target( 'services' : 'Copiando services') {
	ant.echo("Copiando services")
	ant.copy(todir: "${basedir}/grails-app/services") {
                path(refid: 'services')
        }

}
def services = ant.path(id: 'services') {
 	fileset(dir: "${goliathPluginDir}/grails-app/services") {
                    include(name: '**')
            }
}
//copiar src
target( 'src' : 'Copiando src') {
	ant.echo("Copiando src")
	ant.copy(todir: "${basedir}/src") {
                path(refid: 'src')
        }

}
def src = ant.path(id: 'src') {
 	fileset(dir: "${goliathPluginDir}/src") {
                    include(name: '**')
            }
}
//copiar src
target( 'srcG' : 'Copiando srcG') {
	ant.echo("Copiando srcG")
	ant.mkdir(dir:"${basedir}/src/groovy/org/codehaus/groovy/grails/scaffolding")
	

}

//copiar templates
target( 'templates' : 'Copiando templates') {
	ant.echo("Copiando templates")
	ant.copy(todir: "${basedir}/src/templates") {
                path(refid: 'templates')
        }

}
def templates = ant.path(id: 'templates') {
 	fileset(dir: "${goliathPluginDir}/src/templates") {
                    include(name: '**')
            }
}
//copiar css
target( 'css' : 'Copiando css') {
	ant.echo("Copiando css")
	ant.copy(todir: "${basedir}/web-app/css") {
                path(refid: 'css')
        }

}
def css = ant.path(id: 'css') {
 	fileset(dir: "${goliathPluginDir}/web-app/css") {
                    include(name: '**')
            }
}
//copiar js
target( 'js' : 'Copiando js') {
	ant.echo("Copiando js")
	ant.copy(todir: "${basedir}/web-app/js") {
                path(refid: 'js')
        }

}
def js = ant.path(id: 'js') {
 	fileset(dir: "${goliathPluginDir}/web-app/js") {
                    include(name: '**')
            }
}
//copiar images
target( 'img' : 'Copiando images') {
	ant.echo("Copiando images")
	ant.copy(todir: "${basedir}/web-app/img") {
                path(refid: 'img')
        }

}
def images = ant.path(id: 'img') {
 	fileset(dir: "${goliathPluginDir}/web-app/img") {
                    include(name: '**')
            }
}
