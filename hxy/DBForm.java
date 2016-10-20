package hxy;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

class DBForm extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField userName;
	private JPasswordField password;
	private JTextField databaseName;
	private JComboBox<String> databaseType;
	private JButton okButton;
	private Database DBdatabase;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DBForm() {
		setTitle("Database");
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 276);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DatabaseSet");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 10, 108, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblDatabasetype = new JLabel("DatabaseType");
		lblDatabasetype.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatabasetype.setBounds(64, 42, 82, 15);
		contentPanel.add(lblDatabasetype);
		
		databaseType = new JComboBox();
		databaseType.setModel(new DefaultComboBoxModel(new String[] {"MySql", "SQLServer"}));
		databaseType.setBounds(181, 39, 108, 21);
		contentPanel.add(databaseType);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(64, 76, 82, 15);
		contentPanel.add(lblUsername);
		
		userName = new JTextField();
		userName.setBounds(181, 73, 108, 21);
		contentPanel.add(userName);
		userName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(64, 113, 82, 15);
		contentPanel.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(181, 110, 108, 21);
		contentPanel.add(password);
		
		okButton = new JButton("OK");
		okButton.setVisible(false);
		//okButton.setVisible(true);
		//OKButton listener set
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Database db = getDatabase();				
				//��ʼĬ�����ݿ�������ɣ������������µ����ݿⲢ�������ʼ��
				//�������Ӷ���
				String dBName = DBdatabase.getName();
				DBdatabase.setName("mysql");
				ConnectDatabase conn = new ConnectDatabase(DBdatabase);
				//��ȡ���ӵ�statement����
				try {
					///�����µ����ݿⲢ�Բ���Ĭ�����ݿ��Ϊ�½������ݿ�
					conn.getState().executeUpdate("create database "+dBName+";");
					conn.getState().close();
					conn.getConn().close();
					DBdatabase.setName(dBName);
					XMLReader xr = new XMLReader();
					xr.setXML(DBdatabase);
					JOptionPane.showMessageDialog(okButton, "���ݿ��ʼ���ɹ�������");
					dispose();
//					new LogIn();
					System.out.println("���ݿ����óɹ�����Ӧ��ϵͳ������");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(okButton, "���ݿ��ʼ��ʧ�ܣ�����"+e);
					e.printStackTrace();
				}
			}
		});
		okButton.setBounds(71, 191, 93, 23);
		contentPanel.add(okButton);
		
		JButton testButton = new JButton("Test");
		/////////////TestButton listener
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBdatabase = getDatabase();
				String dbName = DBdatabase.getName();
				DBdatabase.setName("mysql");
				ConnectDatabase conn = new ConnectDatabase(DBdatabase);
				if(conn.getConn()!=null){
					okButton.setVisible(true);
					JOptionPane.showMessageDialog(testButton, "Test Successed!!!");
					DBdatabase.setName(dbName);
				}
				else{
					JOptionPane.showMessageDialog(testButton, "Test Failed!!!");
				}				
			}
		});
		testButton.setBounds(191, 191, 93, 23);
		contentPanel.add(testButton);
		
		JLabel lblNewLabel_1 = new JLabel("Database");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(64, 155, 82, 15);
		contentPanel.add(lblNewLabel_1);
		
		databaseName = new JTextField();
		databaseName.setBounds(181, 152, 108, 21);
		contentPanel.add(databaseName);
		databaseName.setColumns(10);
		
	}
	@SuppressWarnings("static-access")
	public Database getDatabase(){
		Database db = new Database();
		String dbType = databaseType.getSelectedItem().toString().trim();
		System.out.println(dbType);
		String dbUser = userName.getText().trim();
		@SuppressWarnings("deprecation")
		String dbPassword = password.getText().trim();
		String dbName = databaseName.getText().trim();
		if(dbType==null|dbUser==null|dbPassword==null|dbName==null){
			new JOptionPane().showMessageDialog(okButton, "���������ݿ���Ϣ!!!");;
		}
		else{
			if(dbType.equals("MySql")){
				db.setType(dbType);
				db.setDriver("com.mysql.jdbc.Driver");
				db.setUri("localhost");
				db.setPort("3306");
				db.setUser(dbUser);
				db.setPassword(dbPassword);
				db.setName(dbName);
			}
			else{				
				db.setType(dbType);
				db.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				db.setUri("localhost");
				db.setPort("1433");
				db.setUser(dbUser);
				db.setPassword(dbPassword);
				db.setName(dbName);
			}
		}			
		return db;
	}
	
}
