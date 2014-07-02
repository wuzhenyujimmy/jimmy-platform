<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div id="paging">
    <!-- 页码链接部分    开始 -->
    
    <c:if test="${page.pageIndexTo > page.pageIndexFrom }">
    
        <!-- 上一页 -->
        <c:if test="${page.currentPageIndex > 1}">
            <a class="preLink" href="${page.baseUrl }?currentPageIndex=1">
                <c:out value="${index }">第一页</c:out>
            </a>
            <a class="preLink" href="${page.baseUrl }?currentPageIndex=${page.currentPageIndex - 1}">
                <c:out value="${index }">上一页</c:out>
            </a>
        </c:if>
        
        <c:forEach begin="${page.pageIndexFrom }" end="${page.pageIndexTo }" var="index">
            <c:choose>
                <c:when test="${index == page.currentPageIndex}">
                    <a class="pageLink currentLink" href="${page.baseUrl }?currentPageIndex=${index }">
                        ${index }
                    </a>
                </c:when>
                <c:otherwise>
                    <a class="pageLink" href="${page.baseUrl }?currentPageIndex=${index }">
                        ${index }
                    </a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        
        <!-- 下一页 -->
        <c:if test="${page.currentPageIndex < page.totalPageCount}">
            <a class="nextLink" href="${page.baseUrl }?currentPageIndex=${page.currentPageIndex + 1}">
                <c:out value="${index }">下一页</c:out>
            </a>
            <a class="nextLink" href="${page.baseUrl }?currentPageIndex=${page.totalPageCount}">
               <c:out value="${index }">最末页</c:out>
            </a>
        </c:if>
        
        <!-- 页码链接部分    结束 -->
        <div id="summary">
                                    每页最大记录数:
            <input type="hidden" id="hiddenMaxResult" value="${page.recordCountInPage }">
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
    
    </c:if>

</div>
