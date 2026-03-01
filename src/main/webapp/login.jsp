<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/style.css">
</head>
<body>
<div class="container">
    <h2>Login</h2>

    <form action="LoginServlet" method="post">
        <input type="email" name="email" placeholder="Enter Email" required>
        <input type="password" name="password" placeholder="Enter Password" required>
        <button type="submit">Login</button>
    </form>

    <p style="text-align:center;margin-top:10px;">
        Don't have an account? <a href="register.jsp">Register</a>
    </p>

    <% if(request.getParameter("error") != null) { %>
        <p style="color:red;text-align:center;">Invalid email or password</p>
    <% } %>
</div>
</body>
</html>
