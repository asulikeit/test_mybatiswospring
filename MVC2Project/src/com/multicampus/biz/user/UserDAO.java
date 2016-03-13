package com.multicampus.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.JDBCUtil;

// 2. DAO(Data Access Object)
@Repository
public class UserDAO {
	// JDBC  
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 
	private final String USER_GET = "select * from users where id=? and password=?";

	// CRUD 
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC insertUser()  ");
	}

	//
	public void updateUser(UserVO vo) {
		System.out.println("===> JDBC updateUser()  ");
	}

	//
	public void deleteUser(UserVO vo) {
		System.out.println("===> JDBC deleteUser()  ");
	}

	//
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC getUser()  ");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}

	//
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> JDBC getUserList()  ");
		return null;
	}
}
