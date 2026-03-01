<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Task</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/editTask.css">
</head>
<body>

<div class="container">
<h2>Edit Task</h2>

<form action="UpdateTaskServlet" method="post">

    <input type="hidden" name="task_id" value="${task_id}">

    <label>Title</label>
    <input type="text" name="title" value="${title}" required>

    <label>Status</label>
    <select name="status">
        <option value="Pending" ${status=='Pending'?'selected':''}>Pending</option>
        <option value="Completed" ${status=='Completed'?'selected':''}>Completed</option>
    </select>

    <button type="submit">Update Task</button>

</form>
</div>

</body>
</html>