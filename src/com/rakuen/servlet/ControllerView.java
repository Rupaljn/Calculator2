package com.rakuen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

/**
 * Servlet implementation class ControllerView
 */
@WebServlet("/ControllerView")
public class ControllerView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String num1 = request.getParameter("num1");
String num2 = request.getParameter("num2");
try{
	int n1 = Integer.parseInt(num1);
	int n2 = Integer.parseInt(num2);
	int result = n1/n2;
	request.setAttribute("result", result);
RequestDispatcher rd =	request.getRequestDispatcher("HomeViewPage.jsp");
	rd.forward(request, response);
}
catch(NumberFormatException n){
	n.printStackTrace();
	String mas = "Please enter only numeric";
	request.setAttribute("mas", mas);
	RequestDispatcher rd = request.getRequestDispatcher("HomeViewPage.jsp");
	rd.forward(request, response);
	
}
catch(ArithmeticException a){
a.printStackTrace();
String mas1 = "Please do not divied by zero";
request.setAttribute("mas1", mas1);
RequestDispatcher rd = request.getRequestDispatcher("HomeViewPage.jsp");
rd.forward(request, response);
}
}

}
