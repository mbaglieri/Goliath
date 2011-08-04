<html>
<!--[if lt IE 7 ]> <html class="no-js ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]>    <html class="no-js ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]>    <html class="no-js ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails" /></title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="google-site-verification" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Canonical -->
		<link rel="canonical" href="http://www.domain.com" />
		<!-- Icons &amp; Splash -->
		<link rel="shortcut icon" href="${createLinkTo(dir:'img',file:'favicon.ico')}">
		<link rel="apple-touch-icon" href="${createLinkTo(dir:'img',file:'apple-touch-icon.png')}">
		<link rel="icon" href="${createLinkTo(dir:'img',file:'favicon.png')}" sizes="16x16"/>
		<link rel="icon" href="${createLinkTo(dir:'img',file:'icon-32.png')}" sizes="32x32"/>
		<link rel="icon" href="${createLinkTo(dir:'img',file:'icon-48.png')}" sizes="48x48"/>
		<link rel="icon" href="${createLinkTo(dir:'img',file:'icon-96.png')}" sizes="96x96"/>
		<link rel="apple-touch-icon" href="${createLinkTo(dir:'img',file:'apple-touch-icon-57.png')}" />
		<link rel="apple-touch-icon" sizes="72x72" href="${createLinkTo(dir:'img',file:'apple-touch-icon-72.png')}" />
		<link rel="apple-touch-icon" sizes="114x114" href="${createLinkTo(dir:'img',file:'apple-touch-icon-114.png')}" />
		<link rel="apple-touch-startup-image" href="${createLinkTo(dir:'img',file:'ios-splash-1024x748.png')}" />
		<!-- Icons &amp; Splash Ends -->
		<link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'css',file:'style.css?v=2')}" />
		<link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'css',file:'master.css')}" />
		<link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'css',file:'gradients.css')}" />
		<link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'css',file:'prettyPhoto.css')}" />
		<link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}" />
		<link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'css/coda',file:'coda.css')}" />
		<!--[if IE]>
		  <g:javascript src="http://html5shiv.googlecode.com/svn/trunk/html5.js" />
		  <![endif]-->
		<!-- Scripts-->
		<g:javascript src="libs/jquery-1.5.1.js" />
		<g:javascript src="libs/modernizr-1.7.min.js" />
		<!-- My Scripts-->
		<g:javascript src="mylibs/cufon/Cufon-Font.js" />
		<g:javascript src="mylibs/cufon/Cufon-Settings.js" />
		<g:javascript src="mylibs/coda-slider-2.0/jquery.easing.1.3.js" />
		<g:javascript src="mylibs/coda-slider-2.0/jquery.coda-slider-2.0.js" />
		<g:javascript src="mylibs/swfobject.js" />
		<g:javascript src="mylibs/jquery.placeholder.js" />
		<g:javascript src="mylibs/jquery.h5validate.js" />
		<g:javascript src="mylibs/jquery.prettyPhoto.js" />
		<g:javascript src="mylibs/navigation/dropdown.js" />
		<g:javascript src="mylibs/twitter-1.13.1.min.js" />
		<g:javascript src="application1.js" />

		<!-- <script src="http://twitterjs.googlecode.com/svn/trunk/src/twitter.min.js"></script> -->
		<!-- External Scripts-->
		<script src="http://platform.twitter.com/widgets.js"></script>
		<script src="https://apis.google.com/js/plusone.js">{lang: 'es-419'}</script>
		<script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script>
		<!-- Open Graph Protocol Tags http://ogp.me/ -->
		<meta property="og:url" content="DomainUrl" />
		<meta property="og:title" content="DomainTitle" />
		<meta property="og:type" content="FBType" />
		<meta property="og:image" content="DomainLogoUrl" />
		<meta property="fb:app_id" content="FBAppNumber" />
		<meta property="fb:admins" content="FBAdminsNumber" />
		<meta property="og:site_name" content="DomainTitle" />
		<meta property="og:description" content="DomainDescription" />
        <g:layoutHead />
	</head>
	<body>
		<div id="container">
	    	<g:render template="/layouts/menu"/>
    		<g:layoutBody />
    	</div>
		<!-- scripts concatenated and minified via ant build script--> 
		<g:javascript src="plugins.js" />
		<g:javascript src="script.js" />
		<!--[if lt IE 7 ]>
			<g:javascript src="libs/dd_belatedpng.js" />
		  <script>DD_belatedPNG.fix("img, .png_bg");</script>
		<![endif]--> 
    </body>
</html>
