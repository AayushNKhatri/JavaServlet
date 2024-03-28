package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PasswordEncryptionWithAes;
import model.StudentModel;
import util.StringUtil;

public class DatabaseController {
	
	public Connection getConnection() throws SQLException, ClassNotFoundException
	{	
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/college_app";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
		
	}
	
	public int addStudent(StudentModel studentModel) 
	{
		try(Connection con = getConnection())
		{
			PreparedStatement st = con.prepareStatement(StringUtil.INSERT_STUDENT);
			PreparedStatement checkUsername = con.prepareStatement(StringUtil.GET_USERNAME);
			PreparedStatement checkPhone = con.prepareStatement(StringUtil.GET_PHONE);
			PreparedStatement checkMail = con.prepareStatement(StringUtil.GET_EMAIL);
			checkUsername.setString(1, studentModel.getUsername());
			checkPhone.setString(1, studentModel.getPhoneNumber());
			checkMail.setString(1, studentModel.getEmail());
            ResultSet checkUsernameRs = checkUsername.executeQuery();
            ResultSet checkPhoneRs = checkPhone.executeQuery();
            ResultSet checkMailRs = checkPhone.executeQuery();
            
            checkUsernameRs.next();
            checkPhoneRs.next();
            checkMailRs.next();
            
            
            if(checkUsernameRs.getInt(1) > 0) 
            {
            	return -2;
            }
            
            if(checkPhoneRs.getInt(1) > 0) 
            {
            	return -4;
            }
            if(checkMailRs.getInt(1) > 0) 
            {
            	return -5;
            }
            
            
            
            
			
            st.setString(1, studentModel.getFristName());
            st.setString(2, studentModel.getLastName()); 
            st.setDate(3, Date.valueOf(studentModel.getDob()));
            st.setString(4, studentModel.getGender());
            st.setString(5, studentModel.getEmail());
            st.setString(6, studentModel.getPhoneNumber());
            st.setString(7, studentModel.getSubject());
            st.setString(8, studentModel.getUsername());
            st.setString(9, PasswordEncryptionWithAes.encrypt(studentModel.getUsername(), studentModel.getPassword()));
            
            int result = st.executeUpdate();
            return result > 0 ? 1 : 0;

            
            
            

		}
		catch(SQLException | ClassNotFoundException ex) 
		{
			ex.printStackTrace();
			return -1;
		}
		
	}
	public int getStudentLoginInfo(String username, String password) {
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtil.GET_LOGIN_STUDENT_INFO );
			st.setString(1, username);
			ResultSet result = st.executeQuery();

			if (result.next()) {
				// User name and password match in the database
				String userDb = result.getString(StringUtil.USER_NAME);
				String passwordDb = result.getString(StringUtil.PASSWORD);
				String decPwd = PasswordEncryptionWithAes.decrypt(passwordDb, username);
				
				if (decPwd != null && userDb.equals(username) && decPwd.equals(password)) {
					return 1;
				}
				else {
					return 0;
				}
			}else {
				return 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

}
