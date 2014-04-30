slider = {
               
    width : "100%",
                
    getSlide : function() {
        return $(".slider");
    },
    
    show : function() {
        
        var $slide = slider.getSlide();
        
        $slide.show();
        
        $slide.animate({
            width: slider.width
        }, function() {
            $(".sceditor-container").width("96%");
            slider.frame().width("99%");
            console.log(slider.frame()[0]);
        });
        
    },
    
    hide : function() {
        slider.getSlide().animate({
            width: "0%"
        }, function() {
            $(this).hide();
        });
    },
    
    frame: function() {
        return $(document.getElementsByTagName("iframe")[0]);
    }
        
};