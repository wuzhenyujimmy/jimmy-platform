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
        <title>Tag</title>
        
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/base.css" type="text/css" media="all" />
        
        <link rel="stylesheet" href="css/slide.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/custom.css" type="text/css" media="all" />
        
        <link rel="stylesheet" href="css/page/page.css" type="text/css" media="all" />
        
        <script src="jquery/jquery-1.11.0.min.js"></script>
        
        <style type="text/css">
        
            .tag-form .line {
            
                height: 40px;
                
            }
                
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
            
            .tag-line {
                height: 50px;
            }
            
            .tag-id {
                width: 350px;
            }
            
            .tag-name {
                width: 150px;
            }
            
            .tag-createDate {
                width: 200px;
            }
            
            .tag-line > div {
                text-indent: 20px;
            }
            
        </style>
        
    </head>
    <body>
    
        <jsp:include page="../common/head.jsp"></jsp:include>
        
        <div class="main">
        
            <jsp:include page="../common/crumb.jsp"></jsp:include>
        
            <jsp:include page="../common/left.jsp"></jsp:include>
        
            <div class="content">
                
                 <c:forEach var="tag" items="${page.entities }">
                
                    <div style="margin-top: 10px;" class="tag-line">
                        <div class="f-left tag-id">
                            <c:out value="${tag.id }"></c:out>
                        </div>
                        <div class="f-left tag-name">
                            <c:out value="${tag.name }"></c:out>
                        </div>
                        
                        <div class="f-left tag-createDate">
                            <c:out value="${tag.createDate }"></c:out>
                        </div>
                        
                        <div class="f-left tag-level">
                            <c:out value="${tag.level }"></c:out>
                        </div>
                        
                        <div class="f-left tag-disable">
                            <a href="tag/delete?id=${tag.id }">
                                <input type="button" class="btn btn-min btn-normal" value="Disable">
                            </a>
                        </div>
                        
                        <div class="f-left tag-update">
                            <a href="tag/toupdate?id=${tag.id }">
                                <input type="button" class="btn btn-min btn-normal" value="Update">
                            </a>
                        </div>
                        
                        <div class="f-left tag-add">
                            <a href="tag/toadd?parentTagId=${tag.id }">
                                <input type="button" class="btn btn-min btn-normal" value="Add">
                            </a>
                        </div>
                        
                    </div>
                
                </c:forEach>
                
                <jsp:include page="../common/page.jsp"></jsp:include>
            </div>
        
        </div>
        
        
        
    </body>
</html>