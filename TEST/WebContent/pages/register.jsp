<%@ page import = "util.StringUtil" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../stylesheets/register.css" />
</head>
<body>
	<div class="container">
		<%
		String errorMessage = (String) request.getAttribute(StringUtil.ERROR_MESSAGE);
		if(errorMessage != null && !errorMessage.isEmpty()){
		%>
		<p class = "error-message"><%=errorMessage %></p>
		<%
		}
		%>
		<h1>Registration Form</h1>
		<form action="../RegisterServlet" method="post">
			<div class="row">
				<div class="col">
					<label for="firstName">First Name:</label> <input type="text"
						id="firstName" name="firstName" required>
				</div>
				<div class="col">
					<label for="lastName">Last Name:</label> <input type="text"
						id="lastName" name="lastName" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="username">User Name:</label> <input type="text"
						id="username" name="username" required>
				</div>
				<div class="col">
					<label for="birthday">Birthday:</label> <input type="date"
						id="dateOfBirth" name="dob" required>
				</div>

			</div>
			<div class="row">
				<div class="col">
					<label for="gender">Gender:</label> <select id="gender"
						name="gender" required>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
				<div class="col">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="phoneNumber">Phone Number:</label> <input type="tel"
						id="phoneNumber" name="phoneNumber" required>
				</div>
				<div class="col">
					<label for="subject">Subject:</label> <select id="subject"
						name="subject" required>
						<option value="computing">Computing</option>
						<option value="multimedia">Multimedia</option>
						<option value="networking">Networking</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				<div class="col">
					<label for="retypePassword">Retype Password:</label> <input
						type="password" id="retypePassword" name="retypePassword" required>
				</div>
			</div>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
