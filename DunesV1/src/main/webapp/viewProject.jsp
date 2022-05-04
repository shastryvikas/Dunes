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
<title>Dunes - Project Dashboard</title>
</head>
<body>

<h1 class="display-4">Project Manager Dashboard</h1>

<h1 class="display-6">Create your Task here:</h1>
	<form action="addTask" method="POST"> 
		<table>
			<tr>
			    <td>Task Name:</td>
			    <td><input type="text" name="taskName"  maxlength="20" size="30" required="required" /></td>
			</tr>			
			<tr>
			    <td>Task Status:</td>
			    <td><input type="text" name="taskStatus"  maxlength="20" size="30" required="required"/></td>
			</tr>
			
			<tr>
				<label for="cars">Choose an Engineer:</label>
				<select name="engineer" id="engineer">
				 <c:if test="${not empty engineers}">
				    <c:forEach items="${engineers}" var="engineer">
				    	<option value="${ engineer.getId() }">${ engineer.getUsername() }</option>
				    </c:forEach>
				</c:if>
				</select>
			</tr>
			
			<input type="hidden" name="projectId" value="${ project }"/>
						
			<tr>
			    <td colspan="2"><input type="submit" value="Create Task" /></td>
			</tr>	
		</table>
	</form>
	
	
	<br>
	
	<h1 class="display-6">Create your Order here:</h1>
	
	<form action="addOrder" method="POST"> 
		<table>			
			<tr>
			    <td>Order Status:</td>
			    <td><input type="text" name="orderStatus"  maxlength="20" size="30" required="required"/></td>
			</tr>
			<tr>
			    <td>Order Date:</td>
			    <td><input type="text" name="orderDate"  maxlength="20" size="30" required="required"/></td>
			</tr>
			<tr>
				<label for="cars">Choose a Supplier:</label>
				<select name="supplier" id="supplier">
				 <c:if test="${not empty suppliers}">
				    <c:forEach items="${suppliers}" var="supplier">
				    	<option value="${ supplier.getId() }">${ supplier.getUsername() }</option>
				    </c:forEach>
				</c:if>
				</select>
			</tr>
			
			<input type="hidden" name="project" value="${ project }"/>  
						
			<tr>
			    <td colspan="2"><input type="submit" value="Create Order" /></td>
			</tr>	
		</table>
	</form>
	
	
	<br>
	
	
	
		
        <h1 class="display-6"">See all your tasks here</h1><br/><br/>
        
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
        
        
        <h1 class="display-6">See all your orders here</h1><br/><br/>
        
        <form id="form" name="form" action="viewProject" method="post">
            <table class="table table-striped table-hover" border = "1" width="60%">
                <thead class="table-dark">
                    <th>Order ID<th/>
                    <th>Project Name<th/>
                    <th>Supplier<th/>
                    <th>Product<th/>
                    <th>Quantity<th/>
                    <th>Date<th/>
                    <th>Cost<th/>
                    <th>Status<th/>
                </thead>
                
                <c:if test="${not empty orders}">
				    <c:forEach items="${orders}" var="order">
				    	
				    	<tr>
	                        <td> ${ order.getId() } <td/>
	                        <td> ${ order.getProject().getProjectName() } <td/>
	                        <td> ${ order.getSupplier().getUsername() } <td/>
	                        <td> ${ order.getProduct().getProductName() } <td/>
	                        <td> ${ order.getQuantity() } <td/>
	                        <td> ${ order.getDate() } <td/>
	                        <td> ${ order.getCost() } <td/>
	                        <td> ${ order.getStatus() } <td/>
	                    <tr/>
				       
					</c:forEach>
				</c:if>
				
            </table>
            
            <input id="projectID" name="projectID" type="hidden" />
            
        </form> 
	
        <h1 class="display-8"><a href="logout" style="color: #393f81;">Logout</a></h1>


</body>
</html>