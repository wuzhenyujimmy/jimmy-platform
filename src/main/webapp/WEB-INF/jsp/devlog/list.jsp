<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>development log</title>
    </head>
    <body>
        <jsp:include page="../widget/article.jsp"></jsp:include>
        
        <input id="add-btn" type="button" value="add">
    </body>
    
    <script type="text/javascript">
        $("#add-btn").click(function(){
            $.post("devlog/add", {
            	"title" : article.getTitle(),
            	"htmlContent" : article.getHtmlContent()
            }, function(returnData) {
            	console.log(returnData);
            });
        });        
    </script>
</html>