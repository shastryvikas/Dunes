<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style> 
    form{ margin-left: 25%; margin-right: 25%;}
    label{display: inline-block;
        width: 240px;
        text-align: left;}
    
        h1{
            margin-top: 5%;
            text-align: center;
        }
        body{
            background-color: aliceblue;
        }
    </style>

<meta charset="UTF-8">
<title>Dunes - Edit Task</title>
</head>
<body>


<h1 class="display-4">Task Manager</h1>

<h1 class="display-6">Edit task details:</h1>
	<form action="saveEditTask" method="POST"> 
		<table>
			<tr>
			    <td>Task IDs:</td>
			    <td><input type="text" name="id" value="${ task.getId() }" maxlength="20" size="30" required="required" contentEditable="false" readonly/></td>
			</tr>			
			<tr>
			    <td>Task Name:</td>
			    <td><input type="text" name="name" value="${ task.getTaskName() }" maxlength="20" size="30" required="required" /></td>
			</tr>
			<tr>
			    <td>Project:</td>
			    <td><input type="text" name="productPrice" value="${ task.getProject().getProjectName() }" maxlength="20" size="30" required="required" contentEditable="false" readonly/></td>
			</tr>	
			<tr>
			    <td>Engineer:</td>
			    <td><input type="text" name="productPrice" value="${ task.getEngineer().getUsername() }" maxlength="20" size="30" required="required" contentEditable="false" readonly/></td>
			</tr>	
			<tr>
			    <td>Status:</td>
			    <td><input type="text" name="status" value="${ task.getTaskStatus() }" maxlength="20" size="30" required="required" /></td>
			</tr>
			<br/>
			<tr>
			    <td colspan="2"><input type="submit" value="Save Task Changes" /></td>
			</tr>	
		</table>
	</form>
	
	        <h1 class="display-8"><a href="logout" style="color: #393f81;">Logout</a></h1>
	
	
</body>
</html>