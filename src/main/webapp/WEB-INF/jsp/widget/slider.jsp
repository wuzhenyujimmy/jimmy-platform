
<style>
    .slider #slider-title {
        border: none;
        max-width: 700px;
    }
    
    .slider #slider-submit-btn {
        width: 80px;
        height: 36px;
        margin-left: 20px;
        background-color: green;
        color: white;
    }

</style>

<div class="slider">

    <div>
        <input id="slider-title" readonly="readonly" value="Add new article">
        <input id="slider-submit-btn" type="button" value="Save">
    </div>
    
    <jsp:include page="article.jsp"></jsp:include>

</div>
