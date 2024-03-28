package controller.serverlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.StudentModel;
import util.StringUtil;

@WebServlet(asyncSupported = true, urlPatterns = {StringUtil.REGISTER_SERVERLET})
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    DatabaseController dbController = new DatabaseController();

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printOut = response.getWriter();
        printOut.print("Hello World"); 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //PrintWriter printOut = response.getWriter();
        
        String firstName = request.getParameter(StringUtil.FIRST_NAME);
        String lastName = request.getParameter(StringUtil.LAST_NAME);
        String date = request.getParameter(StringUtil.BRITHDAY);
        LocalDate dob = LocalDate.parse(date);
        String gender = request.getParameter(StringUtil.GENDER);
        String email = request.getParameter(StringUtil.EMAIL);
        String phoneNumber = request.getParameter(StringUtil.PHONE_NUMBER);
        String subject = request.getParameter(StringUtil.SUBJECT);
        String username = request.getParameter(StringUtil.USER_NAME);
        String password = request.getParameter(StringUtil.PASSWORD);
        String retypePassword = request.getParameter(StringUtil.RETYPE_PASSWORD);
        
        


        
        StudentModel studentModel = new StudentModel(firstName, lastName, dob, gender, email, phoneNumber, subject, username, password);
        
        int result = dbController.addStudent(studentModel);
        if(password.equals(retypePassword)) 
        {
        	switch(result) 
        	{
        	case 1 :
        	{
        			request.setAttribute(StringUtil.SUCCESS_MESSAGE, StringUtil.SUCCESS_REGISTER_MESSSAGE);
        			request.getRequestDispatcher(StringUtil.REGISTER_PAGE).forward(request, response);
        	}
        	case 0 :
        	{
    			request.setAttribute(StringUtil.ERROR_MESSAGE, StringUtil.REGISTER_ERROR_MESSAGE);
    			request.getRequestDispatcher(StringUtil.REGISTER_PAGE).forward(request, response);
        	}
        	case -1 :
        	{
    			request.setAttribute(StringUtil.ERROR_MESSAGE, StringUtil.SERVER_ERROR_MESSAGE);
    			request.getRequestDispatcher(StringUtil.REGISTER_PAGE).forward(request, response);
        	}
        	case -2 :
        	{
    			request.setAttribute(StringUtil.ERROR_MESSAGE, StringUtil.USERNAME_ERROR_MESSAGE);
    			request.getRequestDispatcher(StringUtil.REGISTER_PAGE).forward(request, response);
    		}
        	case -4 :
        	{
    			request.setAttribute(StringUtil.ERROR_MESSAGE, StringUtil.PHONE_ERROR_MESSAGE);
    			request.getRequestDispatcher(StringUtil.REGISTER_PAGE).forward(request, response);
        	}
        	case -5 :
        	{
    			request.setAttribute(StringUtil.ERROR_MESSAGE, StringUtil.EMAIL_ERROR_MESSAGE);
    			request.getRequestDispatcher(StringUtil.REGISTER_PAGE).forward(request, response);
        	}
        	default :
        	{
    			request.setAttribute(StringUtil.ERROR_MESSAGE, StringUtil.SERVER_ERROR_MESSAGE);
    			request.getRequestDispatcher(StringUtil.REGISTER_PAGE).forward(request, response);
        	}
        	}
        
        }
        else 
        {
			request.setAttribute(StringUtil.ERROR_MESSAGE, StringUtil.PASSWORD_WRONG);
			request.getRequestDispatcher(StringUtil.REGISTER_PAGE).forward(request, response);
        }
    }
}
