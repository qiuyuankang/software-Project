package searchSQL;

import java.sql.*;

public class test2 {
	public static void main(String[] args) {

		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=ͼ���";
		String userName = "sa";
		String userPwd = "123456";

		try {
			Class.forName(driverName);
			System.out.println("���������ɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}

		try {

			Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			// ִ�гɹ���ʾ
			System.out.println("�������ݿ�ɹ���");

			PreparedStatement pstmt = null;
			
			/*
			 pstmt = dbConn.prepareStatement(
			 "INSERT INTO ����Ա VALUES ( '123369','����','��','18021313759','946655' )"
			 ); 
			 pstmt.executeUpdate(); 
			 System.out.println("�ɹ�����һ�����ݼ�¼��");
			 */

			// ��ȡ����
			Statement smt = dbConn.createStatement() ; 
			System.out.println("��ʼ��ȡ����");
			ResultSet rs = smt.executeQuery("SELECT * FROM ����Ա");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				System.out.println(rs.getString("����֤��") + "\t" +
						           rs.getString("����") + "\t" + 
						           rs.getString("�Ա�") + "\t" +
						           rs.getString("��ϵ�绰")  
						          );
			}
			System.out.println("��ȡ���");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server����ʧ�ܣ�");
		}

	}

}
