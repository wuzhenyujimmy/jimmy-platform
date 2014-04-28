<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.jimmy.com/jsp/ui/flatui" prefix="flatui" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        
        <!-- Loading Bootstrap -->
        <link href="Flat-UI-master/bootstrap/css/bootstrap.css" rel="stylesheet">
    
        <!-- Loading Flat UI -->
        <link href="Flat-UI-master/css/flat-ui.css" rel="stylesheet">
    
        <link rel="shortcut icon" href="Flat-UI-master/images/favicon.ico">
    
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
          <script src="js/respond.min.js"></script>
        <![endif]-->
        
    </head>
    <body>
    
        <flatui:button value="hello"/>
        <flatui:button value="name" isWide="true"/>
        <flatui:button value="world" type="danger" isWide="true"/>
        
        <!-- Load JS here for greater good =============================-->
        <script src="Flat-UI-master/js/jquery-1.8.3.min.js"></script>
        <script src="Flat-UI-master/js/jquery-ui-1.10.3.custom.min.js"></script>
        <script src="Flat-UI-master/js/jquery.ui.touch-punch.min.js"></script>
        <script src="Flat-UI-master/js/bootstrap.min.js"></script>
        <script src="Flat-UI-master/js/bootstrap-select.js"></script>
        <script src="Flat-UI-master/js/bootstrap-switch.js"></script>
        <script src="Flat-UI-master/js/flatui-checkbox.js"></script>
        <script src="Flat-UI-master/js/flatui-radio.js"></script>
        <script src="Flat-UI-master/js/jquery.tagsinput.js"></script>
        <script src="Flat-UI-master/js/jquery.placeholder.js"></script>
        
    </body>
    
</html>