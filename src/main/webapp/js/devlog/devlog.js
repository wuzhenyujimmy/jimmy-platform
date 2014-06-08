function DevLog(id) {

    this.id = undefined == id ? null : id;
    this.titleNode = $(".article-title");
    this.htmlContentNode = sceditor;
    this.url = "devlog/save";

    this.clear = function() {
        titleNode.val("");
        htmlContentNode.setValue("");
    };
}

function save(entity) {
    
    var title = entity.titleNode.val();
    var htmlContent = entity.htmlContentNode.getValue();
    
    if (title.trim().length == 0 || htmlContent.trim().length == 0) {
        return;
    }
    
    $.post(entity.url, {
        "id" : entity.id,
        "title" : title,
        "htmlContent" : htmlContent
    }, function(redirectUrl) {
        location.href = redirectUrl;
    });
}

$(function() {
    
    var devlog = new DevLog();

    // Add click function to specific class html node
    $(".slider-show").on("click", function() {
        slider.show();
    });

    $(".slider #slider-save").click(function() {
        save(devlog);
    });

    $(".slider #slider-cancel").click(function() {
        slider.hide();
        devlog.clear();
    });
});