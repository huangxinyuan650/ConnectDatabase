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
						System.out.print("配置文件创建失败！！！");
					}							
				}
				else{
					System.out.println("目录创建失败！！！");
				}
			}
			else{
				if(!filePath.exists()){
					new DBForm();
				}else{
					System.out.println("数据库已经配置成功直接进入应用！！！");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
	}
}
