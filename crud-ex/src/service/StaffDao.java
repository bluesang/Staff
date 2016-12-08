package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StaffDao {
	private final String driverClassName = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://127.0.0.1:3306/staff?useUnicode=true&characterEncoding=euckr";
	private final String username = "root";
	private final String password = "java0000";
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	Skill sk = null;
	Religion re = null;
	School sc = null;
	
	//기술 선택사항 Mysql에서 불러오기
	public ArrayList<Skill> selectSkill(){
		System.out.println("--------------------selectSkill 메서드 실행--------------------");
		ArrayList<Skill> skillList = new ArrayList<Skill>();
		try{
			conn = this.getConnection();
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
		System.out.println("--------------------selectSkill 메서드 종료--------------------");
		return skillList;
	}
		
	//학교졸업 선택사항 Mysql에서 불러오기
	public ArrayList<School> selectSchoolGraduate(){
		System.out.println("--------------------selectSchoolGraduate 메서드 실행--------------------");
		ArrayList<School> schoolList = new ArrayList<School>();
		try{
			conn = this.getConnection();
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
		System.out.println("--------------------selectSchoolGraduate 메서드 종료--------------------");
		return schoolList;
	}
	
	//종교 선택사항 Mysql에서 불러오기
	public ArrayList<Religion> selectReligion(){
		System.out.println("--------------------selectReligion 메서드 실행--------------------");
		ArrayList<Religion> religionList = new ArrayList<Religion>();
		try{
			conn = this.getConnection();
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
		System.out.println("--------------------selectReligion 메서드 종료--------------------");
		return religionList;
	}
	
	public StaffSkill insertStaffSkill(int s_secno, int sk_no){
		StaffSkill staffskill = null;
			try{
				conn= this.getConnection();
				stmt = conn.prepareStatement("INSERT INTO staffskill(s_no,sk_no)VALUES((SELECT s_no FROM staff WHERE s_secno=?),?)");
				stmt.setInt(1, s_secno);
				stmt.setInt(1, sk_no);
				rs=stmt.executeQuery();
				if(rs.next()){
					staffskill = new StaffSkill();
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, rs);
			}
		return staffskill;
	}
	//staff 정보 입력 메서드
	public Staff insertStaff(){
		Staff staff = null;
			try{
				conn = this.getConnection();
				stmt = conn.prepareStatement("INSERT INTO staff(s_name,s_secno,s_graduateday,sc_no,r_no) VALUES(?,?,?,?,?)");
				System.out.println("stmt is " + stmt);
				stmt.setString(1, staff.getS_name());
				stmt.setString(2, staff.getS_secno());
				stmt.setString(3, staff.getS_graduateday());
				stmt.setInt(4, staff.getSc_no());
				stmt.setInt(5, staff.getR_no());
				System.out.println("stmt2 is " + stmt);
				rs= stmt.executeQuery();
				System.out.println("staffrs complete!");
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, rs);
			}
			
		System.out.println("--------------------insertStaff 메서드 종료--------------------");
		return staff;
	}
	
	//db 연결 메서드
	private Connection getConnection(){	
		Connection conn = null;
		try{
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(conn + "<--BoardDao getConnection()");
		return conn;
	}
	
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
