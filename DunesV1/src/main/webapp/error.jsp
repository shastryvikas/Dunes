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
<title>Dunes - Error</title>
</head>
<body>

<h1 class="display-4">Oops! We encountered an error. Try again?.</h1>

<h1 class="display-8">You could be trying to access data that you do not have access to</h1>
<h1 class="display-8">Try logging in again</h1>


<h1 class="display-10"><a href="logout" style="color: #393f81;">Take me home</a></h1>

</body>
</html>