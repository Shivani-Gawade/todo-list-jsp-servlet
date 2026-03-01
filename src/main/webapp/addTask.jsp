<%@ page import="com.todo.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if(user == null) response.sendRedirect("login.jsp");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Task</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/addTask.css">
</head>
<body>

<div class="container">
    <h2>Add New Task</h2>

    <form action="AddTaskServlet" method="post">
        <label>Task Title</label>
        <input type="text" name="title" required>

        <label>Status</label>
        <select name="status">
            <option value="Pending">Pending</option>
            <option value="Completed">Completed</option>
        </select>

        <button type="submit">Add Task</button>
    </form>

    <a href="dashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>
