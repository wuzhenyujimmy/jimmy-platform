<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="jimmy" uri="http://www.jimmy.com/jsp/ui/jimmy" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="<%=basePath %>">
        <title>Tag</title>
        
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/base.css" type="text/css" media="all" />
        
        <link rel="stylesheet" href="css/slide.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/custom.css" type="text/css" media="all" />
        
        <link rel="stylesheet" href="css/page/page.css" type="text/css" media="all" />
        <link rel="stylesheet" href="ionicons-1.5.2/css/ionicons.css" type="text/css" media="all" />
        
        <script src="jquery/jquery-1.11.0.min.js"></script>
        
        <style type="text/css">
                
            .tag-form .line .label, .tag-form .line .cencelBtn {
                float: left;
                width: 350px;
                text-align: right;
            }
            
            .tag-form .value, .tag-form .submitBtn {
                float: left;
                width: 400px;
            }
            
            .tag-form .value{
                margin-left: 10px;
            }
            
            /* -------------------- CSS for tree Start ------------------ */
            
            .tree-level2, .tree-level3, .tree-level4, .tree-level5 {
                display: none;
            }
            
            .tree-level1 {
                background-color: #EEEEEE;
            }
            
            .tree-level2 {
                margin-left: 50px;
                background-color: #EEEEEE;
            }
            
            .tree-level3 {
                margin-left: 100px;
                background-color: #EEEEEE;
            }
            
            .tree-level4 {
                margin-left: 150px;
                background-color: #EEEEEE;
            }
            
            .tree-level5 {
                margin-left: 200px;
                background-color: #EEEEEE;
            }
            
            /* ------------------ CSS for tree end ----------------------- */
            
            .tag-line {
                height: 50px;
                line-height: 50px;
                border: 1px solid black;
                margin-bottom: 4px;
            }
            
            /* Tree arrow */
            .tag-line i {
                font-size: 30px;
                color: blue;
                margin-top: 10px;
                cursor: pointer;
                width: 30px;
                position: absolute;
                left: 10px;
            }
            
            .tag-line input {
                margin-top: 10px;
            }
            
            .tag-name {
                width: 150px;
            }
            
            .tag-level {
                width: 100px;
            }
            
            .tag-child {
                width: 80px;
            }
            
            .tag-createDate {
                width: 180px;
            }
            
            .tag-line > div {
                text-indent: 30px;
            }
            
        </style>
        
    </head>
    <body>
    
        <jsp:include page="../common/head.jsp"></jsp:include>
        
        <div class="main">
        
            <jsp:include page="../common/crumb.jsp"></jsp:include>
        
            <jsp:include page="../common/left.jsp"></jsp:include>
        
            <div class="content">
                 
                <jimmy:tree treeMap="${treeMap }"/>
                 
                <jsp:include page="../common/page.jsp"></jsp:include>
            </div>
        
        </div>
        
        <script type="text/javascript">
        
            $(".tag-line .icon").click(function() {
                
                var arrowforwardclazz = "ion-chevron-right";
                var arrowdownclazz = "ion-chevron-down";
                
                var parentNode = this.parentNode;
                var id = parentNode.id;
                console.log(id + "    ---");
                var childNodes = $("div[parent='" + id + "']");
                if (this.className.indexOf(arrowforwardclazz) > 0) {
                    this.className = this.className.replace(arrowforwardclazz, arrowdownclazz);
                    $(this).css("left", "0px");
                    childNodes.slideDown(500);
                } else {
                    this.className = this.className.replace(arrowdownclazz, arrowforwardclazz);
                    $(this).css("left", "10px");
                    childNodes.slideUp(500);
                }
                
            });
        
        </script>
        
    </body>
</html>