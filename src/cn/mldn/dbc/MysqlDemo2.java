package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MysqlDemo2{
	private static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/mldn";
	private static final String DBUSER="root";
	private static final String PASSWORD="mysqladmin";
	public static void main(String[] args) throws Exception{
		Class.forName(DBDRIVER);
		Connection conn=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		String sql="SELECT mid,name,age,salary,birthday,note FROM member limit ?,?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		int currentPage=1;
		int lineSize=10;
		pstmt.setInt(1,(currentPage-1)*lineSize);
		pstmt.setInt(2, lineSize);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(6));
		}
		
	}
}