package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.StaffInsertDao;
import service.*;


@WebServlet("/StaffInsert")
public class StaffInsertServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffInsertDao dao = new StaffInsertDao();
		ArrayList<Skill> skillList = dao.selectSkill();
		ArrayList<School> schoolList = dao.selectSchoolGraduate();
		ArrayList<Religion> religionList = dao.selectReligion();
		
		request.setAttribute("religionList", religionList);
		request.setAttribute("skillList", skillList);
		request.setAttribute("schoolList", schoolList);
		request.getRequestDispatcher("/staff/staffInsertForm.jsp").forward(request, response);
	}

	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------StaffInsertServlet doPost 메서드 실행------------");
		
		request.setCharacterEncoding("euc-kr");
		String s_name=request.getParameter("s_name");
		System.out.println("param s_name is" + s_name);
		
		String s_secnoFront=request.getParameter("s_secnoFront");
		String s_secnoBack=request.getParameter("s_secnoBack");
		String s_secno = s_secnoFront + "-" + s_secnoBack;
		System.out.println("param s_secno is" + s_secno);
		String s_graduateday = request.getParameter("s_graduateday");
		System.out.println("s_graduateday is "+s_graduateday);
		
		int r_no=Integer.parseInt(request.getParameter("r_no"));
		System.out.println("param r_no is " + r_no);
		int sc_no=Integer.parseInt(request.getParameter("sc_no"));
		System.out.println("param sc_no is " + sc_no);
		
		Staff staff = new Staff();
		staff.setS_name(s_name);
		staff.setS_secno(s_secno);
		staff.setR_no(r_no);
		staff.setSc_no(sc_no);
		staff.setS_graduateday(s_graduateday);
		
		System.out.println("insertStaff 메서드 실행 전");
		StaffInsertDao dao = new StaffInsertDao();
		dao.insertStaff(staff);
		
		String[] sk_no = request.getParameterValues("sk_no");
		int[] skillNo = new int[sk_no.length];
		for(int i=0;i<sk_no.length;i++){
			skillNo[i] = Integer.parseInt(sk_no[i]);
			StaffSkill staffskill = new StaffSkill();
			staffskill.setSk_no(skillNo[i]);
			dao.insertStaffSkill(s_secno,staffskill);
		}
		
		System.out.println("-----------StaffInsertServlet doPost 메서드 종료------------");
	}


}
