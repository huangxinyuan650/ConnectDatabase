package hxy;

import java.io.File;

class CreateDBConfig {
	public CreateDBConfig(){
		try {
			File file = new File("config");
			File filePath = new File("config//config.xml");
			if(!file.exists()){
				if(file.mkdir()){
					if(!filePath.exists()){
						new DBForm();
					}else{
						System.out.print("�����ļ�����ʧ�ܣ�����");
					}							
				}
				else{
					System.out.println("Ŀ¼����ʧ�ܣ�����");
				}
			}
			else{
				if(!filePath.exists()){
					new DBForm();
				}else{
					System.out.println("���ݿ��Ѿ����óɹ�ֱ�ӽ���Ӧ�ã�����");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
	}
}
