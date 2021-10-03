package util.Data;

import java.io.FileReader;
import java.util.Properties;
import java.util.Set;

import util.Common.BaseClass;

public class PropertiesUtil extends BaseClass{
	private FileReader reader;
	private Properties p;
	public PropertiesUtil(String AppPropName) throws Exception {
		reader=new FileReader(pathUtil.getPropertyPath(AppPropName));  
		p=new Properties();  
		p.load(reader);  
	}


	public String getAppProperty(String propertyName) {
		
		return p.getProperty(propertyName);
		
	}

	public Set<Object> getAllPropertyKeys() {
		return p.keySet();
	
	}
}
