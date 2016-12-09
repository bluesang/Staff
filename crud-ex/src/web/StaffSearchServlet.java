package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Religion;
import service.School;
import service.Skill;
import Controller.*;


@WebServlet("/StaffSearch")
public class StaffSearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffInsertDao dao = new StaffInsertDao();
		ArrayList<Skill> skillList = dao.selectSkill();
		ArrayList<School> schoolList = dao.selectSchoolGraduate();
		ArrayList<Religion> religionList = dao.selectReligion();
		
		request.setAttribute("religionList", religionList);
		request.setAttribute("skillList", skillList);
		request.setAttribute("schoolList", schoolList);
		request.getRequestDispatcher("/staff/staffSearchForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
