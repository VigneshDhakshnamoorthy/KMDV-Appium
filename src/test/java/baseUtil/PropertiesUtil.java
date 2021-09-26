package baseUtil;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesUtil extends BaseClass{
	private FileReader reader;
	private Properties p;
	public PropertiesUtil(String AppPropName) throws Exception {
		reader=new FileReader(getPropertyPath(AppPropName));  
		p=new Properties();  
		p.load(reader);  
	}


	public String getAppProperty(String propertyName) {
		
		return p.getProperty(propertyName);
		
	}

}
