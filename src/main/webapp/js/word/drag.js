$(function(){
    $("#sortable").sortable({
        revert : true,
        update : stopDrag,
        receive : function(event, ui){
            var wordClone = $(".word-show").clone();   
            
            // remove the exist word before rearranging the dragging word's position
            var id = ui.item[0].id;
            var words = $(".word-show");
            for ( var i = 0; i < words.length; i++) {
                if (words[i].id == id) {
                    $(words[i]).remove();
                }
            }
            
            // replace
            ui.item.html(wordClone.html());
            ui.item[0].className = wordClone[0].className;
            ui.item[0].style = "";
            
            // 0. en
            ui.item.children()[0].innerHTML = searchResult[ui.item[0].dir].en;
            
            // 1. ch
            ui.item.children()[1].innerHTML = searchResult[ui.item[0].dir].ch;
            
            // 2. eg
            ui.item.children()[2].innerHTML = searchResult[ui.item[0].dir].eg;
            
            // 3. select
            var select = ui.item.children()[3];
            var status = searchResult[ui.item[0].dir].status;
            select.className = "status " + status;
            select.value = status;
        }
    });
    
    function stopDrag(event, ui){
        // if the word's index changed
        var draggingNode = ui.item[0];        
        var lastId = $(".word-show").last()[0].id;
        
        var nextId = null;
        var nextPage = 1;
        if (draggingNode.id == lastId) {
            nextPage = 1;
            nextId = ui.item[0].previousSibling.id;
        } else {
            nextId = draggingNode.nextSibling.id == undefined ? draggingNode.nextSibling.nextSibling.id : draggingNode.nextSibling.id;
            nextPage = 0;
        }

        // send request 
        $.post('word/changIndex',{
            'firstId' : draggingNode.id,
            'nextId' : nextId,
            'nextPage' : nextPage 
        }, function(data){
            
        });
    }
    
});