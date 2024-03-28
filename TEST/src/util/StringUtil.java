package util;

public class StringUtil {
	
	public static final String INSERT_STUDENT = "INSERT INTO student_info" + "(FirstName, LastName, BirthDate, Gender, Email, PhoneNumber, Subject, username, password)" + 
			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	public static final String GET_LOGIN_STUDENT_INFO =  "SELECT * FROM student_info WHERE username = ?";
	public static final String GET_USERNAME = "SELECT COUNT (*) FROM student_info WHERE username = ?";
	public static final String GET_PHONE = "SELECT COUNT (*) FROM student_info WHERE phone_number = ?";
	public static final String GET_EMAIL = "SELECT COUNT (*) FROM student_info WHERE email = ?";
		
	
	
	public static final String USER_NAME = "username";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String BRITHDAY = "dob";
	public static final String GENDER = "gender"; 
	public static final String EMAIL = "email";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String SUBJECT = "subject";
	public static final String PASSWORD = "password";
	public static final String RETYPE_PASSWORD = "retypePassword";
	//public static final String GET_ALL_STUDENT_INFO = "SELECT * FROM student_info";
	
	
	public static final String SUCCESS_REGISTER_MESSSAGE = "Sucessfully Register";
	public static final String REGISTER_ERROR_MESSAGE = "Please correcet the form data";
	public static final String SERVER_ERROR_MESSAGE = "An unexpected error occured";
	public static final String SUCCESS_MESSAGE = "sucessMessage";
	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String USERNAME_ERROR_MESSAGE = "Username is already register";
	public static final String EMAIL_ERROR_MESSAGE = "Email is already register";
	public static final String PHONE_ERROR_MESSAGE = "Phone number already register";
	public static final String PASSWORD_WRONG = "Password Worng";
	
	public static final String LOGIN_PAGE = "/pages/login.jsp";
	public static final String REGISTER_PAGE = "/pages/register.jsp";
	public static final String WELCOME_PAGE = "/pages/welcome.jsp";
	public static final String LOGIN_SERVERLET = "/LoginServlet"; 
	
	
	public static final String REGISTER_SERVERLET = "/RegisterServlet";


	

}
