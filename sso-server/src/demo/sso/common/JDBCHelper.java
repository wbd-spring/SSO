package demo.sso.common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * JDBC 辅助类
 * 
 * @author Administrator
 *
 */
public class JDBCHelper {

	// 禁止实例化
	private JDBCHelper() {
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://118.190.71.215:3308/eshop";
		String user = "root";
		String passwd = "123456";

		return DriverManager.getConnection(url, user, passwd);
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
