package com.viagging.rest.dto;

public class VariabilidadDTO {
    
	private boolean hasReport;
	
	private boolean hasMessage;
	
	private boolean hasComments;
	
	private boolean hasWeather;
	
	private boolean hasFacebook;
	
	private boolean hasTwitter;
	
	
	
	public VariabilidadDTO(boolean hasReport, boolean hasMessage,
			boolean hasComments, boolean hasWeather, boolean hasFacebook,
			boolean hasTwitter) {
		super();
		this.hasReport = hasReport;
		this.hasMessage = hasMessage;
		this.hasComments = hasComments;
		this.hasWeather = hasWeather;
		this.hasFacebook = hasFacebook;
		this.hasTwitter = hasTwitter;
	}

	public boolean isHasFacebook() {
		return hasFacebook;
	}

	public void setHasFacebook(boolean hasFacebook) {
		this.hasFacebook = hasFacebook;
	}

	public boolean isHasTwitter() {
		return hasTwitter;
	}

	public void setHasTwitter(boolean hasTwitter) {
		this.hasTwitter = hasTwitter;
	}

	public boolean isHasReport() {
		return hasReport;
	}

	public void setHasReport(boolean hasReport) {
		this.hasReport = hasReport;
	}

	public boolean isHasMessage() {
		return hasMessage;
	}

	public void setHasMessage(boolean hasMessage) {
		this.hasMessage = hasMessage;
	}

	public boolean isHasComments() {
		return hasComments;
	}

	public void setHasComments(boolean hasComments) {
		this.hasComments = hasComments;
	}

	public boolean isHasWeather() {
		return hasWeather;
	}

	public void setHasWeather(boolean hasWeather) {
		this.hasWeather = hasWeather;
	}

}
