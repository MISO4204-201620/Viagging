package com.orange.viagging.builder.main;

import java.util.List;

import com.orange.viagging.builder.IFeatureReader;
import com.orange.viagging.builder.IPropertiesVariability;
import com.orange.viagging.builder.impl.FeatureTxtReader;
import com.orange.viagging.builder.impl.MavenVariability;
import com.orange.viagging.builder.impl.PropertiesVariability;
import com.orange.viagging.builder.utils.Utils;

/**
 * Principal que ejecuta la aplicación
 * @author karenvega
 *
 */
public class Main {

	public static final String CONFIG_FILE_NAME = "config";
	public static final String VIAGGING_PATH = "VIAGGING_PATH";
	//public static final String FEATURES_PATH = "resources/features.txt";
	public static final String FEATURES_PATH = "../viagging-feature/configs/default.config";
	public static final String REPORT_FEATURE = "Reportes";
	public static final String MESSAGING_FEATURE = "Mensajeria";
	public static final String FACEBOOK_FEATURE = "Facebook";
	public static final String TWITTER_FEATURE = "Twitter";
	public static final String REPORTES_FRONT = "derivador.reportes";
	public static final String MESSAGING_FRONT = "derivador.mensajes";
	public static final String PROPERTIES_PROVIDERS_PATH = "PROPERTIES_PROVIDERS_PATH";
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	public void run() {
		IFeatureReader reader = new FeatureTxtReader();
		IPropertiesVariability propertiesVariability = new PropertiesVariability();
		List<String> features = reader.readFeatures(FEATURES_PATH);
		Processor processor = new Processor(features);
		
		if (processor.isFeature(REPORT_FEATURE)) {
			MavenVariability maven = new MavenVariability();
			maven.modifyPom(CONFIG_FILE_NAME, VIAGGING_PATH);
			propertiesVariability.changeProperties(Utils.getAttributeConfiguration(CONFIG_FILE_NAME, PROPERTIES_PROVIDERS_PATH),REPORTES_FRONT);
		} 
		
		if (processor.isFeature(MESSAGING_FEATURE)) {
			propertiesVariability.changeProperties(Utils.getAttributeConfiguration(CONFIG_FILE_NAME, PROPERTIES_PROVIDERS_PATH),MESSAGING_FRONT);
		}
	}
}
