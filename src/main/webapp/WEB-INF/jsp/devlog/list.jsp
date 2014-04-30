<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>development log</title>
        
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/base.css" type="text/css" media="all" />
        
        <link rel="stylesheet" href="css/slide.css" type="text/css" media="all" />
        
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
            
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
                hello<br>
            
                <div class="slider">
                    <div class="form-header">
                        <input id="slider-title" readonly="readonly" value="Add new article">
                        <button id="slider-submit-btn" type="button">Save</button>
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
    </body>
    
</html>