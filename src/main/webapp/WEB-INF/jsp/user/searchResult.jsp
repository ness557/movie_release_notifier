<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:directive.include file="../header.jsp"/>

<table>
    <%--@elvariable id="film" type="com.ness.movie_release_notifier.model.OmdbWrapper"--%>
    <c:forEach items="${films}" var="film">
        <tr>
            <td>
                <table class="table">
                    <tr>
                        <td colspan="3" rowspan="4">
                            <img src="${film.posterUrl}" width="200">
                        </td>
                    </tr>
                    <tr>
                        <td>Title</td>
                        <td>${film.title}</td>
                    </tr>
                    <tr>
                        <td>Year</td>
                        <td>${film.year}</td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td>${film.type}</td>
                    </tr>
                </table>
            </td>
        </tr>
    </c:forEach>
</table>

<c:set var="params" value="${requestScope['javax.servlet.forward.query_string']}"/>
<c:set var="requestPath" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<c:set var="req" value="${requestPath}?${params}"/>
<c:set var="oldPagePar" value="${'page='.concat(page)}"/>
${page}
<table class="table">
    <tr>
        <c:forEach begin="1" end="${pageCount}" var="curPage">

            <c:set var="newPagePar" value="${'page='.concat(curPage)}"/>
            <c:set var="result" value="${fn:replace(req, oldPagePar, newPagePar)}"/>

            <td>
                <a href="${result}">${curPage}</a>
            </td>
        </c:forEach>
    </tr>
</table>

<jsp:include page="../footer.jsp"/>