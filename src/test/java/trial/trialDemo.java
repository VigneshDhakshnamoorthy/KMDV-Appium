package trial;

import java.io.File;

public class trialDemo {
	protected static File classPathRoot = new File(System.getProperty("user.dir"));
	protected static File appRoot = new File(classPathRoot,"src/test/resources/APK");
	protected static File app;
public static void main(String[] args) {
	app = new File(System.getProperty("user.dir")+"src/test/resources/APK/AzamTV.apk");
	System.out.println(app.getAbsolutePath());
}
}
