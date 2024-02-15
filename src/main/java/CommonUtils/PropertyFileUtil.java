package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {

	public String getdatafromPropertyFile(String Key) throws IOException {
		FileInputStream file01 = new FileInputStream("src\\test\\resources\\login.properties");
		Properties pt = new Properties();
		pt.load(file01);
		String value = pt.getProperty(Key);
		return value;
	}

}
