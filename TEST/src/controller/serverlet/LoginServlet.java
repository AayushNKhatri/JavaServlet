package controller.serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import util.StringUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtil.LOGIN_SERVERLET})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	DatabaseController dbController = new DatabaseController();
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter(StringUtil.USER_NAME);
		String password = request.getParameter(StringUtil.PASSWORD);
		
		int loginResult = dbController.getStudentLoginInfo(username, password);
		
		
		if(loginResult == 1) 
		{
			response.sendRedirect(request.getContextPath() + StringUtil.WELCOME_PAGE);
		}
		else if(loginResult == 0) 
		{
			response.setContentType("text/html");
			PrintWriter printOut = response.getWriter();
	        printOut.println("<html><body>");
	        printOut.println("<h2>User or password incorrect</h2>");
	        printOut.println("</html></body>");
		}
		else if(loginResult == -1)
		{
			response.setContentType("text/html");
			PrintWriter printOut = response.getWriter();
	        printOut.println("<html><body>");
	        printOut.println("<h2>User Not Found</h2>");
	        printOut.println("</html></body>"); 
		}
		else 
		{
			response.setContentType("text/html");
			PrintWriter printOut = response.getWriter();
	        printOut.println("<html><body>");
	        printOut.println("<h2>Server Error</h2>");
	        printOut.println("</html></body>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
