<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div id="paging">
    <!-- 页码链接部分    开始 -->
    
    <!-- 上一页 -->
    <c:if test="${page.currentPageIndex > 1}">
        <a class="preLink" href="<c:out value='${page.baseUrl }'></c:out>?pageIndexFrom=1">
            <c:out value="${index }">第一页</c:out>
        </a>
        <a class="preLink" href="<c:out value='${page.baseUrl }'></c:out>?pageIndexFrom=<c:out value='${page.currentPageIndex - 1}'></c:out>">
            <c:out value="${index }">上一页</c:out>
        </a>
    </c:if>
    
    <c:forEach begin="${page.pageIndexFrom }" end="${page.pageIndexTo }" var="index">
        <c:choose>
            <c:when test="${index == page.currentPageIndex}">
                <a class="pageLink currentLink" href="<c:out value='${page.baseUrl }'></c:out>?pageIndexFrom=<c:out value='${index }'></c:out>">
                    <c:out value='${index }'></c:out>
                </a>
            </c:when>
            <c:otherwise>
                <a class="pageLink" href="<c:out value='${page.baseUrl }'></c:out>?pageIndexFrom=<c:out value='${index }'></c:out>">
                    <c:out value='${index }'></c:out>
                </a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    
    <!-- 下一页 -->
    <c:if test="${page.currentPageIndex < page.totalPageCount}">
        <a class="nextLink" href="<c:out value='${page.baseUrl }'></c:out>?pageIndexFrom=<c:out value='${page.currentPageIndex + 1}'></c:out>">
            <c:out value="${index }">下一页</c:out>
        </a>
        <a class="nextLink" href="<c:out value='${page.baseUrl }'></c:out>?pageIndexFrom=<c:out value='${page.totalPageCount}'></c:out>">
           <c:out value="${index }">最后一页</c:out>
        </a>
    </c:if>
    
    <!-- 页码链接部分    结束 -->
    <div id="summary">
        每页最大记录数:<input type="hidden" id="hiddenMaxResult" value="<c:out value='${page.recordCountInPage }'></c:out>">
        <select id="maxResult">
            <option>5</option>
            <option>10</option>
            <option>15</option>
            <option>20</option>
            <option>25</option>
            <option>30</option>
        </select>
        <script type="text/javascript">
            document.getElementById("maxResult").value = document.getElementById("hiddenMaxResult").value;
        </script>
                       共<c:out value="${page.totalPageCount }"></c:out>页
        <c:out value="${page.totalRecordCount }"></c:out>条记录
        <br style="clear: both;">
    </div>
</div>
