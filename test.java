package searchMysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class test {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // ����MYSQL JDBC��������
			// System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ͼ��ݹ���ϵͳ?"+
			        "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&"+
					"useSSL=true",
					"root", "123456");
			// ����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������

			// System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ͼ��"); // user Ϊ�������

			System.out.printf("%-6s","ͼ������");
			System.out.printf("%-14s","ͼ������");
			System.out.printf("%-6s","ͼ����");
			System.out.printf("%-14s","���ʱ��");
			System.out.printf("%-6s","���λ��");
			System.out.printf("%-6s","��Ƭ���");
			System.out.printf("%-6s\n","�¾�����");

			while (rs.next()) {
				System.out.printf("%-6s",rs.getString("ͼ������"));
				System.out.printf("%-14s",rs.getString("ͼ������"));
				System.out.printf("%-6s",rs.getString("ͼ����"));
				System.out.printf("%-14s",rs.getString("���ʱ��"));
				System.out.printf("%-6s",rs.getString("���λ��"));
				System.out.printf("%-6s",rs.getString("��Ƭ���"));
				System.out.printf("%-6s\n",rs.getString("�¾�����"));
			}
			
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
	}
}

