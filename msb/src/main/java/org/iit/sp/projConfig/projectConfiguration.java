package org.iit.sp.projConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class projectConfiguration {
	public Properties Loadproperties() throws IOException {
		Properties pro = new Properties();
		String fpath = "E:\\Selenium Training2\\msb\\config\\config.properties";
		//File f  = new File(fpath);
		
		InputStream fis = new FileInputStream(fpath);
		
	
		pro.load(fis);
		return pro;
	}


}
