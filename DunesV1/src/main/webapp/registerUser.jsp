<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dunes - Registration</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<script>
	function ajaxEvent() {
		var xmlHttp;
		try // Firefox, Opera 8.0+, Safari
		{
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try // Internet Explorer
			{
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				document.getElementById("info").innerHTML = xmlHttp.responseText;
			}
		}

		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		xmlHttp.open("POST", "../ajaxservice.htm?username=" + username
				+ "&password=" + password, true);
		xmlHttp.send();
	}
</script>

</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<section class="vh-100" style="background-color: #6B9CD6;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-xl-10">
					<div class="card" style="border-radius: 1rem;">
						<div class="row g-0">
							<div class="col-md-6 col-lg-5 d-none d-md-block">
								<img
									src="https://mdbootstrap.com/img/new/ecommerce/vertical/004.jpg"
									alt="login form" class="img-fluid"
									style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 d-flex align-items-center">
								<div class="card-body p-4 p-lg-5 text-black">

									<form action="registerUser" method="POST">
										
										<div class="d-flex align-items-center mb-2 pb-1">
											<i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
											<span class="h1 fw-bold mb-0">Dunes</span>
										</div>
										
										<h5 class="fw-normal mb-2 pb-3" style="letter-spacing: 1px;">Get your new account</h5>
										
										<div class="form-outline mb-2">
											<input type="text" id="newusername" name="newusername"
												class="form-control form-control-lg" required minlength="5"/> <label
												class="form-label" for="form2Example17">Username</label>
										</div>
										
										<div class="form-outline mb-2">
											<input type="password" id="newpassword" name="newpassword"
												class="form-control form-control-lg" required minlength="5"/> <label
												class="form-label" for="form2Example27">Password</label>
										</div>
										
										<div class="form-outline mb-2">
											<input type="text" id="newname" name="newname"
												class="form-control form-control-lg" required minlength="5"/> <label
												class="form-label" for="form2Example17">Name</label>
										</div>
										
										<div class="pt-1 mb-2">
										<label for="role">CHOOSE YOUR ROLE:     </label>
											<select id="role" name="role">
												<option value="Engineer">Engineer</option>
												<option value="Manager">Manager</option>
												<option value="Supplier">Supplier</option>
											</select>
										</div>
												
										<div class="pt-1 mb-2">
											<input type="submit" value="Create Account">
 										</div>
												
											
										<p class="mb-2 pb-1" style="color: #393f81;">
											Already have an account? <a href="home" style="color: #393f81;">Login
												here</a>
										</p>
										
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>


