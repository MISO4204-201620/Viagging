package com.orange.viagging.builder.main;

import java.util.List;

import com.orange.viagging.builder.IFeatureReader;
import com.orange.viagging.builder.impl.FeatureTxtReader;
import com.orange.viagging.builder.impl.MavenVariability;

/**
 * Principal que ejecuta la aplicación
 * @author karenvega
 *
 */
public class Main {

	public final static String CONFIG_FILE_NAME = "config";
	public final static String VIAGGING_PATH = "VIAGGING_PATH";
	public final static String FEATURES_PATH = "resources/features.txt";
	public final static String REPORT_FEATURE = "Reportes";
	public final static String MESSAGING_FEATURE = "Mensajeria";
	public final static String FACEBOOK_FEATURE = "Facebook";
	public final static String TWITTER_FEATURE = "Twitter";
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	public void run() {
		IFeatureReader reader = new FeatureTxtReader();
		List<String> features = reader.readFeatures(FEATURES_PATH);
		Processor processor = new Processor(features);
		if (processor.isFeature(REPORT_FEATURE)) {
			MavenVariability maven = new MavenVariability();
			maven.modifyPom(CONFIG_FILE_NAME, VIAGGING_PATH);
		}
	}
}
