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
    	
	    function makeOrder(rowId) 
	    {
	    	var d = document.getElementById("projectID");
	    	d.value = rowId;
	        document.getElementById("form").submit();
	    }
    
    </script>

<meta charset="UTF-8">
<title>Dunes - Manager</title>
</head>
<body>

<h1 class="display-4">Project Manager Dashboard</h1>


<h1 class="display-6">Create Project:</h1><br/>
	<form action="addProject" method="POST"> 
		<table>
			<tr>
			    <td>Project Name:</td>
			    <td><input type="text" name="projectName"  maxlength="20" size="30" required="required" /></td>
			</tr>			
			<tr>
			    <td>Project Budget:</td>
			    <td><input type="number" name="projectBudget"  maxlength="20" size="30" required="required"/></td>
			</tr>
						
			<tr>
			    <td colspan="2"><input type="submit" value="Create Project" /></td>
			</tr>	
		</table>
	</form>
	
	
		
        <h1 class="display-6">Choose Project To Manage</h1><br/>
        
        <form id="form" name="form" action="viewProject" method="post">
            <table class="table table-striped table-hover" border = "1" width="60%">
                <thead class="table-dark">
                    <th>Project ID<th/>
                    <th>Project Name<th/>
                    <th>Project Manager<th/>
                    <th>Budget<th/>
                </thead>
                
                <c:if test="${not empty projects}">
				    <c:forEach items="${projects}" var="project">
				    	
				    	<tr onclick="makeOrder(${ project.getId() })" >
	                        <td> ${ project.getId() } <td/>
	                        <td> ${ project.getProjectName() } <td/>
	                        <td> ${ project.getProjectManager().getUsername() } <td/>
	                        <td> ${ project.getProjectBudget() } <td/>
	                    <tr/>
				       
					</c:forEach>
				</c:if>
				
            </table>
            
            <input id="projectID" name="projectID" type="hidden" />
            
        </form>
        
        
        <h1 class="display-8"><a href="logout" style="color: #393f81;">Logout</a></h1>
        
</body>
</html>