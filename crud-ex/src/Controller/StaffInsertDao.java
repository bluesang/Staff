package Controller;

import java.sql.Connection;
import service.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Controller.DBConnection;;
public class StaffInsertDao {
	
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	DBConnection DBCon = new DBConnection();
	
	Skill sk = null;
	Religion re = null;
	School sc = null;
	
	//��� ���û��� Mysql���� �ҷ�����
	public ArrayList<Skill> selectSkill(){
		System.out.println("--------------------selectSkill �޼��� ����--------------------");
		ArrayList<Skill> skillList = new ArrayList<Skill>();
		try{
			conn = DBCon.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM skill ORDER BY sk_no ASC");
			System.out.println("stmt is" + stmt);
			rs = stmt.executeQuery();
			while(rs.next()){
				sk = new Skill();
				sk.setSk_no(rs.getInt("sk_no"));
				sk.setSk_name(rs.getString("sk_name"));
				skillList.add(sk);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, stmt, rs);
		}
		System.out.println("--------------------selectSkill �޼��� ����--------------------");
		return skillList;
	}
		
	//�б����� ���û��� Mysql���� �ҷ�����
	public ArrayList<School> selectSchoolGraduate(){
		System.out.println("--------------------selectSchoolGraduate �޼��� ����--------------------");
		ArrayList<School> schoolList = new ArrayList<School>();
		try{
			conn = DBCon.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM school ORDER BY sc_no ASC");
			rs = stmt.executeQuery();
			while(rs.next()){
				sc = new School();
				sc.setSc_no(rs.getInt("sc_no"));
				sc.setSc_graduate(rs.getString("sc_graduate"));
				schoolList.add(sc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, stmt, rs);
		}
		System.out.println("--------------------selectSchoolGraduate �޼��� ����--------------------");
		return schoolList;
	}
	
	//���� ���û��� Mysql���� �ҷ�����
	public ArrayList<Religion> selectReligion(){
		System.out.println("--------------------selectReligion �޼��� ����--------------------");
		ArrayList<Religion> religionList = new ArrayList<Religion>();
		try{
			conn = DBCon.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM religion ORDER BY r_no ASC");
			rs = stmt.executeQuery();
			while(rs.next()){
				re = new Religion();
				re.setR_no(rs.getInt("r_no"));
				re.setR_name(rs.getString("r_name"));
				religionList.add(re);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, stmt, rs);
		}
		System.out.println("--------------------selectReligion �޼��� ����--------------------");
		return religionList;
	}
	
	public void insertStaffSkill(String s_secno, StaffSkill staffskill){
			try{
				conn= DBCon.getConnection();
				stmt = conn.prepareStatement("INSERT INTO staffskill(s_no,sk_no)VALUES((SELECT s_no FROM staff WHERE s_secno=?),?)");
				stmt.setString(1, s_secno);
				stmt.setInt(2, staffskill.getSk_no());
				stmt.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, rs);
			}
	
	}
	//staff ���� �Է� �޼���
	public void insertStaff(Staff staff){
			try{
				conn = DBCon.getConnection();
				stmt = conn.prepareStatement("INSERT INTO staff(s_name,s_secno,s_graduateday,sc_no,r_no) VALUES(?,?,?,?,?)");
				System.out.println("stmt is " + stmt);
				stmt.setString(1, staff.getS_name());
				stmt.setString(2, staff.getS_secno());
				stmt.setString(3, staff.getS_graduateday());
				stmt.setInt(4, staff.getSc_no());
				stmt.setInt(5, staff.getR_no());
				System.out.println("stmt2 is " + stmt);
				stmt.executeUpdate();
				System.out.println("stmt complete!");
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, rs);
			}
			
		System.out.println("--------------------insertStaff �޼��� ����--------------------");
	}
	
	//db ���� �޼���
	
	
	private void close(Connection conn, Statement stmt, ResultSet rs)  {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
