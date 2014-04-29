<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>development log</title>
        
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/base.css" type="text/css" media="all" />
        
        <script src="jquery/jquery-1.11.0.min.js"></script>
        
        <style type="text/css">
        
            .content {
                width: 1200px;
                min-height: 100%;
                margin: 0px auto;
                background: #CACACA;
                position: relative;
            }
            
            .slider {
                width: 0px;
                float: right;
                height: 100%;
            }
            
            html, body {
                height: 100%;
            }
            
            .form-header,
            .form-item {
                width: 100%;
            }
            
            .form-header input, .form-header div,
            .form-item input, .form-header div {
                width: 95%;
            }
            
        </style>
        
        
        
    </head>
    <body>
        
        <div class="content">
        
            <button id="showSlider">Show</button>
            <button id="hideSlider">Hide</button>
        
            <div class="slider">
                <div class="form-header">
                    <input id="slider-title" readonly="readonly" value="Add new article">
                    <input id="slider-submit-btn" type="button" value="Save">
                </div>
                <jsp:include page="../widget/article.jsp"></jsp:include>
            </div>
        </div>
        
        <script type="text/javascript">
        
        	$("#showSlider").click(function() {
        	    
        	    $(".slider").animate({
        	        width: "80%"
        	    });
        	    
        	});
        
        </script>
    </body>
    
</html>