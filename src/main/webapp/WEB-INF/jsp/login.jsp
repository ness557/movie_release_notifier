<jsp:directive.include file="header.jsp"/>

<h3>
    Login page
</h3>
<form action='login' method='post'>
    <table class='table table-hover table-responsive table-bordered'>
        <tr>
            <td><b>Login</b></td>
            <td><input type='text' placeholder="Enter Login" name='username' class='form-control' required/></td>
        </tr>
        <tr>
            <td><b>Password</b></td>
            <td><input type='password' placeholder="Enter Password" name='password' class='form-control' required/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn btn-primary">Login</button>
            </td>
        </tr>
    </table>
</form>

<jsp:include page="footer.jsp"></jsp:include>