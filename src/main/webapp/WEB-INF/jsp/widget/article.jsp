<style>
    .article-title {
        width: 95%;
        height: 40px;
        line-height: 40px;
        font-size: 20px;
        font-family: Georgia;
        margin-bottom: 15px;
    }

</style>

<div>
    <input class="article-title" placeholder="Type a title here.">
</div>

<jsp:include page="sceditor.jsp"></jsp:include>

<script>
    var article = {
        getTitle : function() {
            return $(".article-title").val();
        },
        
        getHtmlContent : function() {
            return sceditor.getValue();
        }
    }
</script>