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
<title>Dunes - Place Order</title>
</head>
<body>

<h1 class="display-4">Project Manager Dashboard</h1>

<h1>Create your Task here:</h1>
	
	<form action="placeOrder" method="POST"> 
		<table>			
			<tr>
			    <td>Product Quantity:</td>
			    <td><input type="number" name="orderQuantity"  maxlength="20" size="30" required="required"/></td>
			</tr>
			<tr>
				<label for="cars">Choose a Product:</label>
				<select name="product" id="product">
				 <c:if test="${not empty products}">
				    <c:forEach items="${products}" var="product">
				    	<option value="${ product.getId() }">${ product.getProductName() }</option>
				    </c:forEach>
				</c:if>
				</select>
			</tr>
			
			<input type="hidden" name="status" value="${ orderStatus }"/>  
			<input type="hidden" name="date" value="${ orderDate }"/>  
			<input type="hidden" name="supplier" value="${ supplier }"/>  
			<input type="hidden" name="project" value="${ project }"/>  
						
			<tr>
			    <td colspan="2"><input type="submit" value="Create Order" /></td>
			</tr>	
		</table>
	</form>
	
	        <h1 class="display-8"><a href="logout" style="color: #393f81;">Logout</a></h1>
	

</body>
</html>