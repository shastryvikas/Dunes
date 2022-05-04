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
	    	var d = document.getElementById("orderID");
	    	d.value = rowId;
	        document.getElementById("form").submit();
	    }
	    
	    function makeInventory(rowId) 
	    {
	    	var d = document.getElementById("productID");
	    	d.value = rowId;
	        document.getElementById("form2").submit();
	    }
    
    </script>

<meta charset="UTF-8">
<title>Dunes - Supplier</title>
</head>
<body>
<h1 class="display-4">Supplier Dashboard</h1>

<h1 class="display-6">Add new product to inventory:</h1>
	<form action="addProduct" method="POST"> 
		<table>
			<tr>
			    <td>Product Name:</td>
			    <td><input type="text" name="productName"  maxlength="20" size="30" required="required" /></td>
			</tr>			
			<tr>
			    <td>Stock:</td>
			    <td><input type="number" name="productStock"  maxlength="20" size="30" required="required"/></td>
			</tr>
			<tr>
			    <td>Unit Price:</td>
			    <td><input type="number" name="productPrice"  maxlength="20" size="30" required="required"/></td>
			</tr>		
			<tr>
			    <td colspan="2"><input type="submit" value="Add product" /></td>
			</tr>	
		</table>
	</form>
	
	
	
	<h1 class="display-6">See all your orders here</h1><br/><br/>
        
        <form id="form" name="form" action="editOrder" method="post">
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
				    	
				    	<tr onclick="makeOrder(${ order.getId() })" >
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
            
            <input id="orderID" name="orderID" type="hidden" />
            
        </form> 
        
        
        <h1 class="display-6">See all your inventory here</h1><br/><br/>
        
        <form id="form2" name="form2" action="editInventory" method="post">
            <table class="table table-striped table-hover" border = "1" width="60%">
                <thead class="table-dark">
                    <th>Product ID<th/>
                    <th>Product Name<th/>
                    <th>Stock<th/>
                    <th>Supplier Name<th/>
                    <th>Unit Price<th/>
                </thead>
                
                <c:if test="${not empty products}">
				    <c:forEach items="${products}" var="product">
				    	
				    	<tr onclick="makeInventory(${ product.getId() })">
	                        <td> ${ product.getId() } <td/>
	                        <td> ${ product.getProductName() } <td/>
	                        <td> ${ product.getStock() } <td/>
	                        <td> ${ product.getSupplier().getUsername() } <td/>
	                        <td> ${ product.getPrice() } <td/>
	                    <tr/>
				       
					</c:forEach>
				</c:if>
				
            </table>
            
            <input id="productID" name="productID" type="hidden" />
            
        </form> 
	
	        <h1 class="display-8"><a href="logout" style="color: #393f81;">Logout</a></h1>
	

</body>
</html>