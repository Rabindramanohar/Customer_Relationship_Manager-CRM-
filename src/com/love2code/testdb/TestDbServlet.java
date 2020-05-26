package com.love2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// setup connectino variable
		String user = "hbstudent";
		String pwd = "hbstudent";
		
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// get connection to db
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: "+jdbcURL);
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(jdbcURL, user, pwd);
			
			out.println("\nSuccessful!!");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
