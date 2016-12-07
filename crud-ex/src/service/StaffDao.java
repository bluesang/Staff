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
		ArrayList<Skill> als = new ArrayList<Skill>();
		try{
			conn = this.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM skill ORDER BY sk_no ASC");
			System.out.println("stmt is" + stmt);
			rs = stmt.executeQuery();
			if(rs.next()){
				sk = new Skill();
				sk.setSk_no(rs.getInt("sk_no"));
				sk.setSk_name(rs.getString("sk_name"));
				als.add(sk);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, stmt, rs);
		}
		System.out.println("--------------------selectSkill 메서드 종료--------------------");
		return als;
	}
		
	//학교졸업 선택사항 Mysql에서 불러오기
	public School selectSchoolGraduate(int sc_no){
		System.out.println("--------------------selectSchoolGraduate 메서드 실행--------------------");
		try{
			conn = this.getConnection();
			stmt = conn.prepareStatement("SELECT sc_graduate FROM school WHERE sc_no=?");
			stmt.setInt(1, sc_no);
			rs = stmt.executeQuery();
			if(rs.next()){
				sc = new School();
				sc.setSc_no(sc_no);
				sc.setSc_name(rs.getString("sc_graduate"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, stmt, rs);
		}
		System.out.println("--------------------selectSchoolGraduate 메서드 종료--------------------");
		return sc;
	}
	
	//종교 선택사항 Mysql에서 불러오기
	public Religion selectReligion(int r_no){
		System.out.println("--------------------selectReligion 메서드 실행--------------------");
		try{
			conn = this.getConnection();
			stmt = conn.prepareStatement("SELECT r_name FROM religion WHERE r_no=?");
			stmt.setInt(1, r_no);
			rs = stmt.executeQuery();
			if(rs.next()){
				re = new Religion();
				re.setR_no(r_no);
				re.setR_name(rs.getString("r_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, stmt, rs);
		}
		System.out.println("--------------------selectReligion 메서드 종료--------------------");
		return re;
	}
	public int insertStaff(Staff staff){
		int staffCount = 0;
		
			try{
				conn = this.getConnection();
				stmt = conn.prepareStatement("INSERT INTO staff() VALUES()");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, rs);
				
			}
		return staffCount;
	}
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
