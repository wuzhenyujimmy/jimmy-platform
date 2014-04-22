<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    
    <style type="text/css">
        ul,li{
            list-style: none;
            margin: 0px;
            padding: 0px;
            display: inline-block;
        }
        
        li{
            width: 150px;
            border-right: 1px solid red;
            list-style: none;
            text-indent: 10px;
        }
        
        ul {
            border-left: 1px solid red;
            border-top: 1px solid red;
        }
        
        ul:nth-last-of-type(1) {
            border-bottom: 1px solid red;
        }
        
    </style>

    <link rel="stylesheet" href="css/reset.css" type="text/css" media="all" />
    <link rel="stylesheet" href="css/base.css" type="text/css" media="all" />

</head>
<body>

    <jsp:forward page="devlog/list"></jsp:forward>

    <jsp:include page="WEB-INF/jsp/widget/head.jsp"></jsp:include>
    
    <div>
        <jsp:include page="WEB-INF/jsp/widget/article.jsp"></jsp:include>
    </div>
</body>
</html>