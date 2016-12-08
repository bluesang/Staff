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
		ArrayList<Skill> skillList = dao.selectSkill();
		ArrayList<School> schoolList = dao.selectSchoolGraduate();
		ArrayList<Religion> religionList = dao.selectReligion();
		
		request.setAttribute("religionList", religionList);
		request.setAttribute("skillList", skillList);
		request.setAttribute("schoolList", schoolList);
		request.getRequestDispatcher("/staff/staffInsertForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------StaffInsertServlet doPost 메서드 실행------------");
		request.setCharacterEncoding("euc-kr");
		String s_name=request.getParameter("s_name");
		System.out.println("param s_name is" + s_name);
		String s_secnoFront=request.getParameter("s_secnoFront");
		String s_secnoBack=request.getParameter("s_secnoBack");
		String s_secno = s_secnoFront + "-" + s_secnoBack;
		System.out.println("param s_secno is" + s_secno);
		int r_no=Integer.parseInt(request.getParameter("r_no"));
		int sc_no=Integer.parseInt(request.getParameter("sc_no"));
		int sk_no = Integer.parseInt(request.getParameter("sk_no"));
		System.out.println("sk_no is" + sk_no);
		String s_graduateday = request.getParameter("s_graduateday");
		
		Staff staff = null;
		staff.setS_name(s_name);
		staff.setS_secno(s_secno);
		staff.setR_no(r_no);
		staff.setSc_no(sc_no);
		staff.setS_graduateday(s_graduateday);
		
		StaffDao dao = new StaffDao();
		staff = dao.insertStaff();
		
		System.out.println("-----------StaffInsertServlet doPost 메서드 종료------------");
	}

}
