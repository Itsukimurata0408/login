package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class LoginModel {

	/**
	 * 入力されてデータがDBに上に存在するかどうか調べる。
	 *
	 * @param username ユーザ名
	 * @param password
	 * @return ログイン成功=true,失敗=false
	 */

	public boolean loginCheck(String username, String password) {
		//実行結果を格納する変数
		ResultSet rs = null;

		try {
			//DB接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//SQLを実行
			String SQL = "SELECT * FROM `users` WHERE `username`='"+username+"' AND `password`='"+password+"'";
			rs = DBUtil.execute(SQL);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}
}
