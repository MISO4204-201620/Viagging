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
	public static final String FEATURES_PATH = "../viagging-feature/configs/default.config";
	
	//FeatureIDE 
	public static final String REPORT_FEATURE = "Reportes";
	public static final String MESSAGING_FEATURE = "Mensajeria";
	public static final String COMMENTS_FEATURE = "PCalificar";
	public static final String FACEBOOK_FEATURE = "Facebook";
	public static final String TWITTER_FEATURE = "Twitter";
	public static final String PUBLISH_FACEBOOK_FEATURE = "PFacebook";
	public static final String PUBLISH_TWITTER_FEATURE = "PTwitter";
	public static final String WEATHER_FEATURE = "Clima";
	
	//Properties
	public static final String REPORTES_FRONT = "derivador.reportes";
	public static final String MESSAGING_FRONT = "derivador.mensajes";
	public static final String COMMENTS_FRONT = "derivador.comentarios";
	public static final String FACEBOOK_FRONT = "derivador.facebook";
	public static final String TWITTER_FRONT = "derivador.twitter";
	public static final String PUBLISH_FACEBOOK_FRONT = "derivador.pfacebook";
	public static final String PUBLISH_TWITTER_FRONT = "derivador.ptwitter";
	public static final String WEATHER_FRONT = "derivador.clima";
	
	public static final String VARIABILITY_PROPERTIES_PATH = "VARIABILITY_PROPERTIES_PATH";
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	public void run() {
		IFeatureReader reader = new FeatureTxtReader();
		IPropertiesVariability propertiesVariability = new PropertiesVariability();
		List<String> features = reader.readFeatures(FEATURES_PATH);
		Processor processor = new Processor(features);
		MavenVariability maven = new MavenVariability();

		String variabilityPropertiesPath = Utils.getAttributeConfiguration(CONFIG_FILE_NAME, VARIABILITY_PROPERTIES_PATH);
		
		boolean isReportFeature = processor.isFeature(REPORT_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, REPORTES_FRONT, isReportFeature);
		maven.modifyPom(CONFIG_FILE_NAME, VIAGGING_PATH, "viagging-api-report", isReportFeature);
		
		boolean isMessagingFeature = processor.isFeature(MESSAGING_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, MESSAGING_FRONT, isMessagingFeature);
		maven.modifyPom(CONFIG_FILE_NAME, VIAGGING_PATH, "viagging-api-message", isMessagingFeature);
		
		boolean isCommentsFeature = processor.isFeature(COMMENTS_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, COMMENTS_FRONT, isCommentsFeature);
		
		boolean isFacebookFeature = processor.isFeature(FACEBOOK_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, FACEBOOK_FRONT, isFacebookFeature);

		boolean isTwitterFeature = processor.isFeature(TWITTER_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, TWITTER_FRONT, isTwitterFeature);
		
		boolean isPublishFacebookFeature = processor.isFeature(PUBLISH_FACEBOOK_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, PUBLISH_FACEBOOK_FRONT, isPublishFacebookFeature);
		
		boolean isPublishTwitterFeature = processor.isFeature(PUBLISH_TWITTER_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, PUBLISH_TWITTER_FRONT, isPublishTwitterFeature);
		
		boolean isWeatherFeature = processor.isFeature(WEATHER_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, WEATHER_FRONT, isWeatherFeature);
		maven.modifyPom(CONFIG_FILE_NAME, VIAGGING_PATH, "viagging-api-weather", isWeatherFeature);
		
		
	}
}
