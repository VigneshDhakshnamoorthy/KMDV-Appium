package util.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import util.Common.BaseClass;

public class PropertiesUtil extends BaseClass{
	private FileReader reader;
	private Properties p;
	
	public PropertiesUtil(String AppPropName) {
		try {
			reader=new FileReader(pathUtil.getPropertyPath(AppPropName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
		p=new Properties();  
		try {
			p.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}


	public String getValue(String propertyName) {
		
		return p.getProperty(propertyName);
		
	}

	public Set<Object> getKeys() {
		return p.keySet();
	}
}
