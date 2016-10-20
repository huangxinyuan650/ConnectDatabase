package hxy;

public class MainCom {	
	public static void main(String[] args) {
//		Connection conn = null;
//		Statement state =null;
//		try{                                        ///////Á´½ÓÊý¾Ý¿â
//			Class.forName("com.mysql.jdbc.Driver");
//			}
//		catch(ClassNotFoundException e){
//			System.out.println(e);
//			}
//		
//		try{
//			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql", "root", "huang650");
//			//System.out.println("You has connected to Mysql!!!");
//			state=conn.createStatement();
//			state.executeUpdate("create database huangxinyuan;");
//			state.close();
//			conn.close();
//			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/huangxinyuan", "root", "huang650");
//			System.out.println("You has connected to Mysql!!!");
//			state=conn.createStatement();
//			state.executeUpdate("create table huang(name char(20));");
//		}
//		catch(SQLException e){
//			System.out.print(e);
//		}
				new CreateDatabaseConfig();
			}
}
