<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Username: <input type="text" name="username" required></label><br>
        <label>Password: <input type="password" name="password" required></label><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>