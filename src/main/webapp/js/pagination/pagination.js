function redirect(url, thisNode) {
	var currentPageIndex = thisNode.innerHTML;
	var maxResult = document.getElementById("maxResult").value;
	location.href = url + "?currentPageIndex=" + currentPageIndex + "&maxResult=" + maxResult;
}

function queryForm() {
	var form = document.forms[0];
	form.submit();
}

function queryLink(thisNode, currentIndex) {
	var form = document.forms[0];
	form.action = form.action.replace("form", "query");

	var currentPageIndex = thisNode.innerHTML;
	var maxResult = $("#maxResult").val();

	var currentInputHtml = "";
	var maxResultHtml = "";
	
	// 上一页
	if (-1 == thisNode) {
		currentInputHtml = "<input name='currentPageIndex' type='hidden' value=" + (parseInt(currentIndex, 10) - 1) + ">";
		maxResultHtml = "<input name='maxResult' type='hidden' value='" + maxResult + "'>";
	}
	// 下一页
	else if (1 == thisNode) {
		currentInputHtml = "<input name='currentPageIndex' type='hidden' value=" + (parseInt(currentIndex, 10) + 1) + ">";
		maxResultHtml = "<input name='maxResult' type='hidden' value='" + maxResult + "'>";
	} else {
		currentInputHtml = "<input name='currentPageIndex' type='hidden' value=" + currentPageIndex + ">";
		maxResultHtml = "<input name='maxResult' type='hidden' value='" + maxResult + "'>";
	}

	$(form).append($(currentInputHtml));
	$(form).append($(maxResultHtml));

	form.submit();
}

/** word query link */
function queryLink(pageIndex, status){
    location.href = "word/query?currentPageIndex="+pageIndex + "&status="+status;
}
