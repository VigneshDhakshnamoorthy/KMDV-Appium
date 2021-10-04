package testCase;

import util.Common.BaseClass;
import util.Data.PropertiesUtil;

public class trialDemo extends BaseClass {

public static void main(String[] args) throws Throwable {

	PropertiesUtil prop = new PropertiesUtil("azamTv.properties");
	prop.getAllproperties();

}
}
