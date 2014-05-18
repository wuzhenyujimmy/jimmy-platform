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
    
        <header>
            <nav>
                This is header
            </nav>
        </header>
        
        <div class="main">
        
            <div class="bread-crumb">
                username : jimmy.wu
            </div>
        
            <div class="left">
                <button id="showSlider">Show</button>
                <button id="hideSlider">Hide</button>
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
                hello world, this is a beautiful place. You can come here later.
            </div>
            
            <div class="content">
            
                <c:forEach var="devlog" items="${page.entities }">
                
                    <div style="margin-top: 10px;" class="htmlContent">
                        <c:out value="${devlog.article.title }"></c:out>
                        <c:out value="${devlog.article.htmlContent }"></c:out>
                    </div>
                
                </c:forEach>
                
                <jsp:include page="../common/page.jsp"></jsp:include>
            
                <div class="slider radius shadow">
                    <div class="slider-header">
                        <input class="slider-title" readonly="readonly" value="Add new article">
                        <div class="btn btn-normal btn-middle radius">Save</div>
                        <div class="btn btn-cancel btn-middle radius">Cancel</div>
                    </div>
                    <jsp:include page="../widget/article.jsp"></jsp:include>
                </div>
            </div>
            
            <br style="clear:both"/>
        
        </div>
        
        <footer>
            This is footer
        </footer>
        
        <script type="text/javascript" src="js/common/slider.js"></script>
        
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