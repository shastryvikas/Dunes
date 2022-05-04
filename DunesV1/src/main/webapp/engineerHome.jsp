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
    
    <script>
	    
	    function makeInventory(rowId) 
	    {
	    	var d = document.getElementById("taskID2");
	    	d.value = rowId;
	        document.getElementById("form2").submit();
	    }
    
    </script>
    
<meta charset="UTF-8">
<title>Dunes - Engineer</title>
</head>
<body>
<h1 class="display-4">Construction Engineer Dashboard</h1>


	
		
        <h1 class="display-6">See all your tasks here</h1><br/><br/>
        
        <form id="form2" name="form2" action="editTask" method="post">
            <table class="table table-striped table-hover" border = "1" width="60%">
                <thead class="table-dark">
                    <th>Task ID<th/>
                    <th>Task Name<th/>
                    <th>Project Name<th/>
                    <th>Assigned Engineer<th/>
                    <th>Status<th/>
                </thead>
                
                <c:if test="${not empty tasks}">
				    <c:forEach items="${tasks}" var="task">
				    	
				    	<tr onclick="makeInventory(${ task.getId() })" >
	                        <td> ${ task.getId() } <td/>
	                        <td> ${ task.getTaskName() } <td/>
	                        <td> ${ task.getProject().getProjectName() } <td/>
	                        <td> ${ task.getEngineer().getUsername() } <td/>
	                        <td> ${ task.getTaskStatus() } <td/>
	                    <tr/>
				       
					</c:forEach>
				</c:if>
				
            </table>
            
            <input id="taskID2" name="taskID2" type="hidden" />
            
        </form> 
	
	        <h1 class="display-8"><a href="logout" style="color: #393f81;">Logout</a></h1>
	

</body>
</html>