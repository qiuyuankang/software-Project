package searchSQL;

import java.sql.*;

public class test2 {
	public static void main(String[] args) {

		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=图书馆";
		String userName = "sa";
		String userPwd = "123456";

		try {
			Class.forName(driverName);
			System.out.println("加载驱动成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}

		try {

			Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			// 执行成功提示
			System.out.println("连接数据库成功！");

			PreparedStatement pstmt = null;
			
			/*
			 pstmt = dbConn.prepareStatement(
			 "INSERT INTO 管理员 VALUES ( '123369','王容','男','18021313759','946655' )"
			 ); 
			 pstmt.executeUpdate(); 
			 System.out.println("成功插入一条数据记录！");
			 */

			// 读取数据
			Statement smt = dbConn.createStatement() ; 
			System.out.println("开始读取数据");
			ResultSet rs = smt.executeQuery("SELECT * FROM 管理员");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				System.out.println(rs.getString("工作证号") + "\t" +
						           rs.getString("姓名") + "\t" + 
						           rs.getString("性别") + "\t" +
						           rs.getString("联系电话")  
						          );
			}
			System.out.println("读取完毕");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server连接失败！");
		}

	}

}
