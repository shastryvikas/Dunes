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
<title>Dunes - Edit Product</title>
</head>
<body>
<h1 class="display-4">Inventory Manager</h1>

<h1 class="display-6">Edit order details:</h1>
	<form action="saveEditProduct" method="POST"> 
		<table>
			<tr>
			    <td>Product IDs:</td>
			    <td><input type="text" name="id" value="${ product.getId() }" maxlength="20" size="30" required="required" contentEditable="false" readonly/></td>
			</tr>			
			<tr>
			    <td>Product Name:</td>
			    <td><input type="text" name="name" value="${ product.getProductName() }" maxlength="20" size="30" required="required" /></td>
			</tr>
			<tr>
			    <td>Supplier:</td>
			    <td><input type="text" name="productPrice" value="${ product.getSupplier().getUsername() }" maxlength="20" size="30" required="required" contentEditable="false" readonly/></td>
			</tr>	
			<tr>
			    <td>Stock:</td>
			    <td><input type="number" name="quantity" value="${ product.getStock() }" maxlength="20" size="30" required="required" contentEditable="true"/></td>
			</tr>
			<tr>
			    <td>Unit Price:</td>
			    <td><input type="number" name="cost" value="${ product.getPrice() }" maxlength="20" size="30" required="required" contentEditable="true"/></td>
			</tr>
			<tr>
			    <td colspan="2"><input type="submit" value="Save Order Changes" /></td>
			</tr>	
		</table>
	</form>
	
	        <h1 class="display-8"><a href="logout" style="color: #393f81;">Logout</a></h1>
	
	
</body>
</html>