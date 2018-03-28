package com.internousdev.login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.internousdev.dto.LoginDTO;
import com.internousdev.util.DBConnector;

public class LoginDAO {
	//*メソッド名は分かりやすく「select」にします
	public LoginDTO select(String name,String password) throws SQLException{
		LoginDTO dto = new LoginDTO();
		DBConnector db = new DBConnector();
		Connection son = db.getConnection();
		String sql ="select * form user where user_name=? and password=?";
	
	try {
		com.mysql.jdbc.PreparedStatement ps = con.prerareStatement(sql);
		//*セキュリティ対策を考慮してJavaではprerareStatementを利用
		ps.setString(1, name);
		ps.setString(2, password);
		//*SQL文の「？」パラメーターに指定した値を挿入することが出来ます上に書いた下記の文
		//String sql ="select * form user where user_name=? and password=?";
		ResultSet rs = ps.executeQuery();
		//*SQL文を実行します
		
		if(rs.next()) {
			dto.setName(rs.getString("user_name"));
			dto.setName(rs.getString("password"));
			//*「select文」でDBから取得した情報をDTOクラスに格納します。
		}
	}catch (SQLException e){
		e.printStackTrace();
		//*処理中にSQL関連にエラーがでた際に実行する処理
	}finally {
		con.close();
		//*必ず実行する処理です。DB接続を切断する
	}
	return dto;
	} 
}
