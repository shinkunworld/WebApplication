package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Statement;
import web.Kakeibo;

public class SampleDAO {
	Connection con = null;

	// 接続メソッド
	public void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/a?useSSL=false", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 切断メソッド
	public void disconnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// sampletbの一覧を出力するメソッド
	public ArrayList<Kakeibo> selectAll() {
		ArrayList<Kakeibo> list = new ArrayList<Kakeibo>();
		connection();
		if (con != null) {
			String sql = "select * from b";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					// 表示せず、ArrayListに代入、あとで利用するので
					// 今回はnameとageだけ
					// 1行分のクラスを生成してフィールドに代入
					// Kakeibo p = new Kakeibo();
//					p.setId(rs.getInt("id"));
//					p.setIncome(rs.getInt("income"));
//					p.setExpense(rs.getInt("expense"));
//					p.setDetails(rs.getString("details"));
//					p.setDate(rs.getTimestamp("date"));
//					list.add(p);
					int id = rs.getInt("id");
					int income = rs.getInt("income");
					int expense = rs.getInt("expense");
					String details = rs.getString("details");
					Timestamp date = rs.getTimestamp("date");
					Kakeibo kakeibo = new Kakeibo(id, income, expense, details, date);
					list.add(kakeibo);
				}
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
		return list;
	}

	public void printSelectByID(int id) {
		connection();
		if (con != null) {
			String sql = "select * from b where id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				// set
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("id列の取得" + rs.getInt("id"));
					System.out.println("imcome列の取得" + rs.getInt("income"));
					System.out.println("expense列の取得" + rs.getInt("expense"));
					System.out.println("details列の取得" + rs.getString("details"));

				}
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
	}

	// sampletbに追加メソッド
	public int insert(int income, int expense, String details) {
		int rs = 0;
		// InsertMiniの内容をペーストする
		connection();
		if (con != null) {
			String sql = "insert into b(Income,Expense,Details,date) values(?,?,?,now())";
			try {
				PreparedStatement ps = con.prepareStatement(sql);

				// ps.setDate(1, date);
				// ps.setDate(1, new Date(date.getTime()));
				ps.setInt(1, income);
				ps.setInt(2, expense);
				ps.setString(3, details);
				rs = ps.executeUpdate();
				System.out.println("操作した行数は" + rs + "行です");
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
		return rs;
	}

	// 変更メソッド
	public int update(int id, int income, int expense, String details) {
		int rs = 0;
		// InsertMiniの内容をペーストする
		connection();
		if (con != null) {
			// update sampletb set name = 'aa', age=10 where id = 10;
			// update sampletb set name = ?, age=? where id = ?;

			String sql = "update b set Income=?, Expense=?,Details=?,Date=now() where id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, income);
				ps.setInt(2, expense);
				ps.setString(3, details);
				ps.setInt(4, id);
				rs = ps.executeUpdate();
				System.out.println("操作した行数は" + rs + "行です");
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
		return rs;
	}

	// 削除メソッド
	public int delete(int id) {
		int rs = 0;
		connection();
		if (con != null) {
			// delete from sampletb where id = 10;
			// delete from sampletb where id = ?;
			String sql = "delete from b where id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeUpdate();
				System.out.println("操作した行数は" + rs + "行です");
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
		return rs;
	}

}
