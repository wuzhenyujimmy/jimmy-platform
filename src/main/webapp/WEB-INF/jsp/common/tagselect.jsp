<style>
    
    .tags > div {
        height: 40px;
        line-height: 40px;
    }

    .tag-select select {
        float: left;
        margin-right: 10px;
    }

</style>

<div class="tags">
    <div>Tags</div>
    <div class="tag-select"></div>
</div>

<script type="text/javascript">

function appendSelectNode(json) {
    var options = "";
    $.each(json, function(key, value) {
        var option = "<option value='" + key + "'>" + value + "</div>";
        options += option;
    });
    
    var selectNode = "<select>" + options + "</select>";
    $(".tag-select").append(selectNode);
}

function bindSelectEvent(treejson) {
    $(document).on("change",".tag-select select",function(){
        $(this).nextAll().remove();
        
        var id = this.value;
        var json = treejson[id];
        appendSelectNode(json);
    });
}

$.post("tag/treejson", {}, function(treejson) {
    var firstLevelJson = treejson[""];
    appendSelectNode(firstLevelJson);
    
    bindSelectEvent(treejson);
});

function getSelectedTagId() {
    return $(".tag-select select").last().getVal("id");
}

</script>