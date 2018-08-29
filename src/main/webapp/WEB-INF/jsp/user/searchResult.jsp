<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:directive.include file="../header.jsp"/>

<div class="row">
<%--@elvariable id="film" type="com.ness.movie_release_notifier.model.OmdbWrapper"--%>
<c:forEach items="${films}" var="film" varStatus="count">
    <c:if test="${count.index % 3 eq 0}">
        </div>
        <div class="row">
    </c:if>
    <div class="col col-lg-4">
        <table class="table">
            <tr>
                <td colspan="3" rowspan="5">
                    <img src="${film.posterUrl}" width="200" onerror="">
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
            <tr>
                <td colspan="2">
                    <form action="/user/getFilm" method="get">
                        <input type="hidden" name="imdbId" value="${film.imdbId}"/>
                        <input type="submit" value="View Full Info" class="btn btn-primary"/>
                    </form>
                </td>
            </tr>

        </table>

    </div>
</c:forEach>
</div>

<c:set var="params" value="${requestScope['javax.servlet.forward.query_string']}"/>
<c:set var="requestPath" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<c:set var="req" value="${requestPath}?${params}"/>
<c:set var="oldPagePar" value="${'page='.concat(page)}"/>

<table class="table pagesTable center">
    <tr>
        <th>Pages: </th>
        <c:forEach begin="1" end="${pageCount}" var="curPage">

            <c:set var="newPagePar" value="${'page='.concat(curPage)}"/>
            <c:set var="result" value="${
            fn:contains(req, 'page') ?
            fn:replace(req, oldPagePar, newPagePar) :
            req.concat('&').concat(newPagePar)
            }"/>
            <td>
                <a href="${result}">${curPage}</a>
            </td>
        </c:forEach>
    </tr>
</table>

<jsp:include page="../footer.jsp"/>