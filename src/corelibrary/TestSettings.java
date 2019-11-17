package corelibrary;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public abstract class TestSettings {
	private static Properties settings;
	

	public static Properties getSettingProperties(){
		if (settings == null) {
			loadFrameworkSettings();
		}
		return settings;
	}
	
	private static void loadFrameworkSettings(){
		settings = new Properties();
		try(InputStream ins = new FileInputStream(System.getProperty("user.dir") + "/supportfiles/FrameworkSettings.properties")){
			settings.load(ins);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static String getTestSetting(String key){
		return getSettingProperties().getProperty(key);
	}
}
