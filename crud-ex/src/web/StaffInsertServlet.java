package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;


@WebServlet("/StaffInsert")
public class StaffInsertServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffDao dao = new StaffDao();
		ArrayList<Skill> skill = dao.selectSkill();
		request.setAttribute("skill", skill);
		request.getRequestDispatcher("/staff/staffInsertForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String s_name=request.getParameter("s_name");
		System.out.println("param s_name is" + s_name);
		String s_secnoFront=request.getParameter("s_secnoFront");
		String s_secnoBack=request.getParameter("s_secnoBack");
		String s_secno = s_secnoFront + "-" + s_secnoBack;
		System.out.println("param s_secno is" + s_secno);
		String r_name=request.getParameter("r_name");
		response.sendRedirect(request.getContextPath()+"/staffInsert");
	}

}
