slider = {
               
    /** Methods about UI Start **/
                
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
            $(".sceditor-container").width("100%");
            slider.frame().width("100%");
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
    },
    
    /** Methods about UI End **/
};