package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/wish")
public class WishMessageGenerator extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get current hour of the day
		LocalTime currentTime = LocalTime.now();
		int hour = currentTime.getHour();

		String message;
		if (hour < 12) {
			message = "Good Morning!";
		} else if (hour < 16) {
			message = "Good Afternoon!";
		} else if (hour < 20) {
			message = "Good Evening!";
		} else {
			message = "Good Night!";
		}

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body></html>");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}