<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dunes - Login</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
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

									<form action="login" method="POST">

										<div class="d-flex align-items-center mb-3 pb-1">
											<i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
											<span class="h1 fw-bold mb-0">Dunes</span>
										</div>

										<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign
											into your account</h5>

										<div class="form-outline mb-4">
											<input type="text" id="username" name="username"
												class="form-control form-control-lg" required minlength="5"/> <label
												class="form-label" for="form2Example17">Username</label>
										</div>

										<div class="form-outline mb-4">
											<input type="password" id="password" name="password"
												class="form-control form-control-lg" required minlength="3"/> <label
												class="form-label" for="form2Example27">Password</label>
										</div>

										<div class="pt-1 mb-4">
										<input type="submit" value="Submit">
<!-- 											<button class="btn btn-dark btn-lg btn-block" type="button">Login</button>
 -->										
 										</div>
																		
										<p class="mb-5 pb-lg-2" style="color: #393f81;">
											Don't have an account? <a href="register" style="color: #393f81;">Register
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


