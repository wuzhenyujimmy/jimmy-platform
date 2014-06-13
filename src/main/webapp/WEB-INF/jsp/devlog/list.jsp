<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="<%=basePath %>">
        <title>development log</title>
        
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/base.css" type="text/css" media="all" />
        
        <link rel="stylesheet" href="css/slide.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/custom.css" type="text/css" media="all" />
        
        <link rel="stylesheet" href="css/page/page.css" type="text/css" media="all" />
        
        <script src="jquery/jquery-1.11.0.min.js"></script>
        
    </head>
    <body>
    
        <jsp:include page="../common/head.jsp"></jsp:include>
        
        <div class="main">
        
            <jsp:include page="../common/crumb.jsp"></jsp:include>
        
            <jsp:include page="../common/left.jsp"></jsp:include>
            
            <input class="btn btn-middle btn-normal radius f-right slider-show" type="button" value="Add New Article">
            
            <div class="content">
            
                <c:forEach var="devlog" items="${page.entities }">
                
                    <div style="margin-top: 10px;" class="htmlContent">
                        <c:out value="${devlog.article.title }"></c:out>
                        <c:out value="${devlog.article.htmlContent }"></c:out>
                    </div>
                
                </c:forEach>
                
                <jsp:include page="../common/page.jsp"></jsp:include>
                <jsp:include page="../common/slider.jsp"></jsp:include>
                
            </div>
            
            <br style="clear:both"/>
        
        </div>
        
        <footer>
            This is footer
        </footer>
        
        <script type="text/javascript" src="js/common/slider.js"></script>
        <script type="text/javascript" src="js/devlog/devlog.js"></script>
        
        <script type="text/javascript">
        
            $("#showSlider").click(function() {
                slider.show();
            });
            
            $("#hideSlider").click(function() {
                slider.hide();
            });
        
        </script>
        
         <script type="text/javascript">
            $(function(){
                var $htmlContentDiv = $(".htmlContent");
                $htmlContentDiv.html($htmlContentDiv.text());
            });
        </script>
    </body>
    
</html>