package hxy;

import java.io.File;

public class CreateDatabaseConfig {
	@SuppressWarnings("static-access")
	public CreateDatabaseConfig(){
		new CreateDBConfig();
		while(true){
			File file = new File("config//config.xml");
			if(file.exists())
				break;
			try {
				Thread.currentThread().sleep(500);
				System.out.println("�ȴ����ݿ�������ɣ�����");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
