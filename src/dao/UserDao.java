package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import bean.User;

public class UserDao {
	private static final String url = "jdbc:mysql://localhost:3306/User?serverTimezone=JST";
	private static final String user = "root";
	private static final String pw = "KenJirou325276mysql";

	public static ArrayList<User> selectAllUser(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "SELECT * FROM user";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<User> list = new ArrayList<User>();

			while( rs.next() ){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String text = rs.getString("text");
				Timestamp datenow = rs.getTimestamp("datenow");
				Timestamp dateedit = rs.getTimestamp("dateedit");

				User result = new User(id, name, text, dateedit, dateedit);
				list.add(result);
			}
			return list;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑫DBとの切断処理
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		//途中でExceptionが発生した時はnullを返す。
		return null;
	}


	public static void insertUser(User s){
		//②アクセスに必要な変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			//③JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//④データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);

			//⑤SQL文の元を作成する
			//?をプレースホルダと言います。
			//後の手順で?に値を設定します。
			String sql = "INSERT INTO User(name, text, datenow,dateedit) VALUES(?,?,?,?)";

			//⑥SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);

			//⑦プレースホルダに値を設定
			//第1引数→何番目の?に設定するか(1から数える)
			//第2引数→?に設定する値
			pstmt.setString(1, s.getname());
			pstmt.setString(2, s.gettext());
			pstmt.setTimestamp(3,  s.getdatenow());
			pstmt.setTimestamp(4,  s.getdateedit());

			//⑧SQLを実行し、DBから結果を受領する
			int result = pstmt.executeUpdate();

			//おまけ：⑥の準備が完了すれば?の値を更新して
			//続けてINSERTすることができる。
			//pstmt.setString(1, "takahashi");
			//pstmt.setInt(2, 20);
			//pstmt.executeUpdate();


		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑨DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}

	//DELETE文を実行するメソッドのサンプル
	//引数は削除する学生のID
	public static void deleteUser(int id){
		//②アクセスに必要な変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			//③JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "DELETE FROM User WHERE id = ?";

			//⑥SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id);

			//⑧SQLを実行し、DBから結果を受領する
			int result = pstmt.executeUpdate();


		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑨DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	public static void UpdataUser(User s){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "UPDATA user SET text = ?, dateedit = ? WHERE id = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s.gettext());
			pstmt.setTimestamp(2, s.getdateedit());


		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑨DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
}