$(".submit").click(submitDictionary);
$(".reset").click(clearDictionary);
$(".searchBtn").click(search);
$("#addBtn").mouseover(addBtnOver);
$("#addBtn").mouseout(addBtnOut);
$("#add").mouseout(addBtnOut);
$("#addBtn").mousemove(addSectionOver);
$("#add").mousemove(addSectionOver);
$("body").click(clickBody);
$(".status").change(changBg);
$("#queryCondition").change(searchByStatus);
$("#mode").click(changeMode);
$(".status").change(updateStatus);

$(".ch").mouseover(popUpCh);
$(".eg").mouseover(popUpEg);
$(".eg").mouseout(removeEgpopUp);
// $("#chPopUp").mouseout(removeChPopUp);

function submitDictionary() {
    $.post("word/add", {
        "word" : $("#wordInput").val(),
        "mean" : $("#meanInput").val(),
        "example" : $("#exampleInput").val()
    }, function(data) {
        if (data == "success") {
            $(".infoDiv").append("<span class='operateSuccess'>Add Word Success!</div>");
            setTimeout(function() {
                $(".operateSuccess").hide(1000);
            }, 1000);
        } else {
            alert("Add New Word Fail!");
        }
    });
}

function clearDictionary() {
    $("#wordInput").val("");
    $("#meanInput").val("");
    $("#exampleInput").val("");
}

var searchResult;
function search() {
    var content = $("#searchContent").val();
    // keep the least length of the search content
    // TODO
    
    searchResult = null;
    $("#searchResult").html("");
    $.post("word/search", {
        "keyWord" : content,
    }, function(data) {
        searchResult = data;
        for ( var i = 0; i < data.length; i++) {
            var divNode = "<div id='" + data[i].id + "' class='search-word' dir='" + i +"'>" +
            "<div class='en'>" + data[i].en + "</div>" +
            "<div class='ch'>" + data[i].ch + "</div>" + "</div><br style='clear:both;'>";
            $("#searchResult").append(divNode);
        }
        
        // make these words draggable
        $(".search-word").draggable({
            connectToSortable: "#sortable",
            revert: "invalid",
            helper: "clone"
        });
    });
}

var willShowAdd = false;
function addBtnOver(){
    willShowAdd = true;
    setTimeout(showAdd, 500);
}

function addBtnOut(){
    willShowAdd = false;
    isAddSectionOver = false;
}

var isAddSectionOver = false;
function showAdd(){
    isAddSectionOver = true;
    if (willShowAdd) {
        $("#add").show();
    }
}

function addSectionOver(){
    isAddSectionOver = true;
    $("#addBtn").css({"background-color" : "#ECEFF1"});
}

function clickBody(){
    if(isAddSectionOver){
        // $("#add").show();
    } else {
        $("#add").hide();
        $("#addBtn").css({"background-color" : "#DEDEDE"});
    }
}

/** Change word status's backgound color */
function changBg(){
    this.className = "status " + this.value;
    
}

function updateStatus(){
    $.post('word/updateStatus',{
        'id':this.parentNode.id,
        'status':this.value
    }, function(data){
        if (data != 'success') {
            alert('Change word status error!');
        }
    });
    
    // wordId = $(this).parent()[0].id;
}

// search by status
function searchByStatus(){
    location.href = "word/query?status=" + this.value + "&currentPageIndex=0";
}

var isEdit = false;
function changeMode(){
    if ($("#mode").html() == 'Read') {
        isEdit = true;
        $("#mode").html('Edit');
        $("#chPopUp").hide();
        $("#egPopUp").hide();
    } else {
        isEdit = false;
        $("#mode").html('Read');
    }
}

function popUpCh(){
    if(!isEdit) {
        $("#chContent").html(this.innerHTML);
        var className = $(this).nextAll(".status")[0].className;
        className = className.replace('status ','');
        $("#chPopUp")[0].className = className;
        
        var leftSize = this.offsetLeft + this.offsetWidth / 2 - $("#chPopUp").width() / 2 - 5 + "px";
        var topSize = this.parentNode.offsetTop + "px";
        $("#chPopUp").css({'top':topSize,'left':leftSize});
        $("#chPopUp").show();
    }
}

function popUpEg(){
    if(!isEdit) {
        if (this.innerHTML.length > 15) {
            // hide ch pop up dialog
            $("#chPopUp").hide();
            $("#egContent").html(this.innerHTML);
            var className = $(this).nextAll(".status")[0].className;
            className = className.replace('status ','');
            $("#egPopUp")[0].className = className;
            $(".tooltip-arrow").css({"border-top-color" : $("." + className).css("background-color")});
            
            var leftSize = $("#content")[0].offsetLeft + this.offsetLeft + this.offsetWidth / 2 - $("#egPopUp").width() / 2 + "px";
            var topSize = this.parentNode.offsetTop + $("#content")[0].offsetTop - $("#egPopUp").height() + 5 + "px";
            $("#egPopUp").css({'top':topSize,'left':leftSize});
            $("#egPopUp").show();
        }
    }
}

function removeChPopUp(){
    $("#chPopUp").hide();
}

function removeEgpopUp(){
    $("#egPopUp").hide();
}