package banana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Bang07DAO_MariaImpl implements Bang07DAO{

	@Override
	public List<Bang07VO> findAll() throws Exception {
		List<Bang07VO> ls = new ArrayList<Bang07VO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://183.111.242.21:3306/pukyung21",
					"pukyung21","pukyung00!!1");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from bang_07_T");
			
			while(rs.next()) {
				Bang07VO vo = new Bang07VO();
				vo.setNo(rs.getInt("no"));
				vo.setContent(rs.getString("content"));
				ls.add(vo);
			}
		}
		catch (Exception e){	
		}
		finally {
			System.out.println("finally...");
			if (conn!=null) conn.close();
			if (stmt!=null) stmt.close();
			if (rs!=null) rs.close();
		}
		
		return ls;
	}

	@Override
	public Bang07VO findByPk(Bang07VO pvo) throws Exception {
		Bang07VO vo = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://183.111.242.21:3306/pukyung21",
					"pukyung21","pukyung00!!1");
			stmt = conn.prepareStatement("select * from bang_07_T where no=?");
			stmt.setInt(1, pvo.getNo());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				vo = new Bang07VO();
				vo.setNo(rs.getInt("no"));
				vo.setContent(rs.getString("content"));
			}
			
		}
		catch(Exception e){}
		finally {
			if (conn!=null) conn.close();
			if (stmt!=null) stmt.close();
			if (rs!=null) rs.close();
		}
		
		
		return vo;
	}

	@Override
	public int delByPK(Bang07VO pvo) throws Exception {
		int uc = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		//이부분 원문이랑 약간 다름.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://183.111.242.21:3306/pukyung21",
					"pukyung21","pukyung00!!1");
			stmt = conn.prepareStatement("DELETE FROM bang_07_T where no=?");
			stmt.setInt(1, pvo.getNo());
			uc=  stmt.executeUpdate();
		}
		catch (Exception e) {}
		
		finally {
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
		}
		
		
		return uc;
	}

	@Override
	public int add(Bang07VO pvo) throws Exception {
		int uc = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://183.111.242.21:3306/pukyung21",
					"pukyung21","pukyung00!!1");
			stmt = conn.prepareStatement("insert into bang_07_T values(default, ?)");
			stmt.setString(1, pvo.getContent());
			uc = stmt.executeUpdate();
		}
		catch(Exception e) {}
		finally {
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
		}
		
		
		
		return uc;
	}

	
}
