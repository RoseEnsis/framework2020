package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.model.entity.EmpVo;

public class EmpDao {

	private Connection getConnection() throws SQLException {
		String driver="org.mariadb.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test";
		String user="scott";
		String password="tiger";
		Connection conn=null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conn=DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	public ArrayList<EmpVo> selectAll() throws SQLException {
		ArrayList<EmpVo> list=new ArrayList<>();
		String sql="select * from emp";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EmpVo bean=new EmpVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				list.add(bean);
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return list;
	}

	public void insertOne(String name, int pay) throws SQLException {
		String sql="insert into emp (name,nalja,pay) values (?,now(),?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, pay);
			pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}

}
