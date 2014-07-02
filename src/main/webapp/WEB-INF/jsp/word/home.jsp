<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="cache-control" content="no-cache">
		<base href="<%=basePath %>">
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="jquery-ui-1.10.2/themes/base/jquery.ui.all.css">
		<script src="jquery-ui-1.10.2/jquery-1.9.1.js"></script>
		<script src="jquery-ui-1.10.2/ui/jquery.ui.core.js"></script>
		<script src="jquery-ui-1.10.2/ui/jquery.ui.widget.js"></script>
		<script src="jquery-ui-1.10.2/ui/jquery.ui.mouse.js"></script>
		<script src="jquery-ui-1.10.2/ui/jquery.ui.draggable.js"></script>
		<script src="jquery-ui-1.10.2/ui/jquery.ui.sortable.js"></script>
		
		<link href="css/word/word.css" type="text/css" rel="stylesheet"></link>
        <link rel="stylesheet" href="css/page/page.css" type="text/css" media="all" />
	</head>
	<body>
		<div class="head">
			English Word Management
		</div>
		
		<div id="content">	
			<div id="view">
				<div id="queryTitle">
					<span id="mode">Read</span>
					The Query Result
					<select id="queryCondition" class="status ${currentStatus }">
						<option></option>
						<c:forEach items="${status }" var="s">
							<c:choose>
								<c:when test="${s.name == currentStatus }">
									<option class="${s.name }" selected="selected">${s.name }</option>
								</c:when>
								<c:otherwise>
									<option class="${s.name }">${s.name }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<div id="addBtn">Add</div>
				</div>
				
				<div id="sortable">
					<c:choose>
						<c:when test="${fn:length(page.entities) > 0 }">
							<c:forEach items="${page.entities }" var="e">
								<div id="${e.id }" class="word-show">
									<div class="en">${e.en }  ${e.id }</div>
									<div class="ch">${e.ch }</div>
									<div class="eg">${e.eg }</div>
									<select class="status ${e.status.name }">
										<c:forEach items="${status }" var="s">
											<c:choose>
												<c:when test="${s.name == e.status.name }">
													<option class="${s.name }" selected="selected">${s.name }</option>
												</c:when>
												<c:otherwise>
													<option class="${s.name }">${s.name }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
									<br style="clear: both;">
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</div>
				
				<span id="chPopUp">
					<span id="chContent"></span>
				</span>
                
                <jsp:include page="../common/page.jsp"></jsp:include>
			</div>
			
			<div id="search">
				<div id="searchTitle">
					<input id="searchContent">
					<span class="searchBtn"></span>
				</div>
				<div id="searchResult">
					
				</div>
			</div>
			<br style="clear: both;">
			
			<div id="add">
				<div class="infoDiv"></div>
				<div>
					<span class="label">Word:</span>
					<input id="wordInput">
				</div>
				<div>
					<span class="label">Mean:</span>
					<input id="meanInput">
				</div>
				<div>
					<span class="label textareaLable">Example:</span>
					<textarea id="exampleInput"></textarea>
				</div>
				<div>
					<span class="submit">Add</span>
					<span class="reset">Clear</span>
				</div>
			</div>
			<div class="root">
				This is the root section
			</div>
		</div>
		<span id="egPopUp">
			<span id="egContent"></span>
			<span class="tooltip-arrow"></span>
		</span>
	</body>
	<script type="text/javascript" src="js/word/word.js"></script>
	<script type="text/javascript" src="js/word/drag.js"></script>
	<script type="text/javascript" src="js/pagination/pagination.js"></script>
</html>