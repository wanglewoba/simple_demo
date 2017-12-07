package common.util;

import java.io.InputStreamReader;
import java.util.Properties;

public class Propertieser {
	private Properties prop = new Properties();

	public Propertieser(String proPath) throws Exception {
		prop.load(new InputStreamReader(Propertieser.class.getClassLoader()
				.getResourceAsStream(proPath), "UTF-8"));
	}

	public String get(String key) {
		return prop.getProperty(key);
	}

	public static void main(String[] args) {
		try {
			Propertieser p = new Propertieser("app.properties");
			String x = p.get("aa.bb.name");//key值
			System.out.println(x);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
