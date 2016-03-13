package com.multicampus.biz.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object)
@Repository
public class UserDAOSpring {
	@Autowired
	private JdbcTemplate spring;
	
	// SQL
	private final String USER_GET = "select * from users where id=? and password=?";

	// CRUD   
	public void insertUser(UserVO vo) {
		System.out.println("===> Spring JDBC insertUser()  ");
	}

	//  
	public void updateUser(UserVO vo) {
		System.out.println("===> Spring JDBC updateUser()  ");
	}

	//  
	public void deleteUser(UserVO vo) {
		System.out.println("===> Spring JDBC deleteUser()  ");
	}

	//   
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring JDBC getUser()  ");
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}

	//   ˻
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> Spring JDBC getUserList()  ");
		return null;
	}
}


class UserRowMapper implements RowMapper<UserVO> {

	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setId(rs.getString("ID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setName(rs.getString("NAME"));
		user.setRole(rs.getString("ROLE"));
		return user;
	}
	
}