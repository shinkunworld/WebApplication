package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Kakeibo;

import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Statement;

public class DAO {
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
					Timestamp date = rs.getTimestamp("date");
					String details = rs.getString("details");
					String remark = rs.getString("remark");
					String payment = rs.getString("payment");
					int amount = rs.getInt("amount");
					Kakeibo kakeibo = new Kakeibo(id, date, details, remark, payment, amount);
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


	// sampletbに追加メソッド
	public int insert(String details, String remark, String payment, int amount) {
		int rs = 0;
		// InsertMiniの内容をペーストする
		connection();
		if (con != null) {
			String sql = "insert into b(date,details,remark,payment,amount) values(now(),?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, details);
				ps.setString(2, remark);
				ps.setString(3, payment);
				ps.setInt(4, amount);
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
	public int update(String details, String remark, String payment, int amount, int id) {
		int rs = 0;
		// InsertMiniの内容をペーストする
		connection();
		if (con != null) {
			// update sampletb set name = 'aa', age=10 where id = 10;
			// update sampletb set name = ?, age=? where id = ?;

			String sql = "update b set date=now(),details=?, remark=?,payment=?,amount=? where id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, details);
				ps.setString(2, remark);
				ps.setString(3, payment);
				ps.setInt(4, amount);
				ps.setInt(5, id);
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
