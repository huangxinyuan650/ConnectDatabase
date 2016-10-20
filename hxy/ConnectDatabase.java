package hxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {
	private Connection conn=null;
	private Statement state=null;
	
	public Connection getConn(){
		return conn;
	}
	public Statement getState(){
		return state;
	}
	public ConnectDatabase(){
		XMLReader xr = new XMLReader();
		Database db = xr.getXML();
		getConnectDatabase(db);
	}

	public ConnectDatabase(Database db){
		getConnectDatabase(db);
	}
	
	public void closeConn(){
		try {
			conn.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getConnectDatabase(Database db){
		try{                                        ///////�������ݿ�
			Class.forName(db.getDriver());
			}
		catch(ClassNotFoundException e){
			System.out.println(e);
			}
		
		try{
			conn=DriverManager.getConnection("jdbc:"+db.getType().toLowerCase()+"://"+db.getUri()+":"+db.getPort()+"/"+db.getName(), db.getUser(), db.getPassword());
			System.out.println("You has connected to Mysql!!!");
			state=conn.createStatement();
		}
		catch(SQLException e){
			System.out.print(e);
		}
	}
}
