<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="<%=basePath %>">
        <title>Insert title here</title>
        
        <style type="text/css">
            .tag-form .label, .tag-form .left {
                float: left;
                width: 400px;
                text-align: right;
            }
            
             .tag-form .content, .tag-form .right {
                float: left;
                width: 600px;
            }
            
        </style>
        
    </head>
    <body>
        
        <form class="tag-form" action="tag/save" method="post">
        
            <div class="line">
                <div class="label">Name</div>
                <div class="content">
                    <input name="name">
                </div>
            </div>
            <div class="line">
            
            
            </div>
            <div class="line">
                <div class="left">
                    <input class="btn btn-cancel btn-middle radius" type="button">
                </div>
                <div class="right">
                    <input class="btn btn-normal btn-middle radius" type="button">
                </div>
            </div>
        </form>
        
    </body>
</html>