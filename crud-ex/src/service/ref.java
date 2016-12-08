package service;

public class ref {
	secNostmt = conn.prepareStatement("SELECT s_no FROM staff WHERE s_secno=?");
	secNostmt.setString(1, staff.getS_secno());		
	System.out.println("secNostmt is " + secNostmt);
	rs = secNostmt.executeQuery();
	System.out.println("secNostmt2 is " + secNostmt);
	
	if(rs.next()){
		rsNo = rs.getInt("s_no");
		System.out.println("rsNo is "+rsNo);
	}
	secNostmt.close();
	System.out.println("rs complete!");
	
	for(int i=0;i<sk_no.length;i++){
		skillstmt = conn.prepareStatement("INSERT INTO staffskill(s_no,sk_no)VALUES(?,?)");
		skillstmt.setInt(1, rsNo);
		skillstmt.setInt(2, Integer.parseInt(sk_no[i]));
		skillrs = skillstmt.executeUpdate();
		System.out.println("skillrs complete!");
	}	
	if(staffrs ==0|| skillrs==0){
		check=false;
	}else{
		check=true;
	}
		
	conn.setAutoCommit(true);
}
