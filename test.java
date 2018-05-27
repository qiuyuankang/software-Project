package searchMysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class test {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			// System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/图书馆管理系统?"+
			        "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&"+
					"useSSL=true",
					"root", "123456");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

			// System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from 图书"); // user 为表的名称

			System.out.printf("%-6s","图书类编号");
			System.out.printf("%-14s","图书名称");
			System.out.printf("%-6s","图书编号");
			System.out.printf("%-14s","入库时间");
			System.out.printf("%-6s","库存位置");
			System.out.printf("%-6s","照片编号");
			System.out.printf("%-6s\n","新旧描述");

			while (rs.next()) {
				System.out.printf("%-6s",rs.getString("图书类编号"));
				System.out.printf("%-14s",rs.getString("图书名称"));
				System.out.printf("%-6s",rs.getString("图书编号"));
				System.out.printf("%-14s",rs.getString("入库时间"));
				System.out.printf("%-6s",rs.getString("库存位置"));
				System.out.printf("%-6s",rs.getString("照片编号"));
				System.out.printf("%-6s\n",rs.getString("新旧描述"));
			}
			
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
	}
}

