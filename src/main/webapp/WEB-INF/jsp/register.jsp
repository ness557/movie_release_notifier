<jsp:directive.include file="header.jsp"/>

<h3>
    Register page
</h3>

<form:form action='/register' method='post' modelAttribute="user">

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