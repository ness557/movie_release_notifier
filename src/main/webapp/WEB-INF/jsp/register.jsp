<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:directive.include file="header.jsp"/>

<h3>
    Register page
</h3>

<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        <h4 class="error">${error}</h4>
    </c:forEach>
</c:if>

<spring:hasBindErrors name="emptyEmailAndId">pidr</spring:hasBindErrors>

<%--@elvariable id="user" type="com.ness.movie_release_notifier.model.User"--%>
<form:form action='/register' method='post' modelAttribute="user">

    <form:hidden path="id"/>

    <table class="table">

        <tr>
            <td><form:label path="login"> Login </form:label></td>
            <td><form:input path="login" cssClass="form-control"/></td>
            <td><form:errors path="login" cssClass="error"/></td>
        </tr>

        <tr>
            <td><form:label path="encPassword"> Password </form:label></td>
            <td><form:password path="encPassword" cssClass="form-control"/></td>
            <td><form:errors path="encPassword" cssClass="error"/></td>
        </tr>

        <tr>
            <td><form:label path="email"> Email </form:label></td>
            <td><form:input path="email" cssClass="form-control"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>

        <tr>
            <td><form:label path="telegramId"> Telegram Id </form:label></td>
            <td><form:input path="telegramId" cssClass="form-control"/></td>
            <td><form:errors path="telegramId" cssClass="error"/></td>
        </tr>

        <tr>
            <td>
                <form:label path="telegramNotify">
                    Should we notify you via Telegram? </form:label>
            </td>
            <td><form:checkbox path="telegramNotify" cssClass="form-check-input" value="true"/></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Submit" class="btn btn-primary"/></td>
            <td></td>
        </tr>

    </table>

</form:form>


<jsp:include page="footer.jsp"></jsp:include>