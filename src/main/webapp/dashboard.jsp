<%@ page import="java.util.*,com.todo.dao.TaskDAO,com.todo.model.Task,com.todo.model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if(user == null){
        response.sendRedirect("login.jsp");
        return;
    }

    TaskDAO dao = new TaskDAO();
    List<Task> tasks = dao.getTasks(user.getId());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/dashboard.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>

<div class="container">

<h2>Welcome, <%= user.getName() %></h2>

<div class="actions">
    <a href="addTask.jsp" class="btn add">Add Task</a>

    <form id="logoutForm" action="LogoutServlet" method="post" style="display:inline;">
    <button type="button" class="btn logout" onclick="confirmLogout()">Logout</button>
	</form>

	<script>
	function confirmLogout(){
    Swal.fire({
        title: "Logout?",
        text: "Are you sure you want to logout?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#d33",
        cancelButtonColor: "#28a745",
        confirmButtonText: "Logout",
        cancelButtonText: "Cancel"
    }).then((result) => {
        if (result.isConfirmed) {
            document.getElementById("logoutForm").submit();
        }
    });
}
</script>

</div>

<table>
<tr>
<th>Title</th>
<th>Status</th>
<th>Actions</th>
</tr>

<% for(Task t : tasks) { %>
<tr>
<td><%= t.getTitle() %></td>
<td><%= t.getStatus() %></td>
<td>
	<a href="EditTaskServlet?task_id=<%=t.getTaskId()%>" class="btn edit">Edit</a>
	<a href="DeleteTaskServlet?task_id=<%=t.getTaskId()%>" class="btn delete">Delete</a>
</td>
</tr>
<% } %>

</table>

</div>
</body>
</html>