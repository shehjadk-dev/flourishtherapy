package com.flourishtherapy.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CardJava {


	@ValueMapValue
    private String image;

	@ValueMapValue
    private String imagealttext;
	
	@ValueMapValue
    private String heading;
	
	
	
	@ValueMapValue
    private String description;
	
	@ValueMapValue
    private String buttonurl;
	
	@ValueMapValue
    private String linktext;

	@SlingObject
	@Required
	private SlingHttpServletRequest request;

	@PostConstruct
	protected void init() {
		// Nothing
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImagealttext() {
		return imagealttext;
	}

	public void setImagealttext(String imagealttext) {
		this.imagealttext = imagealttext;
	}

	public String getHeading() {
		return  "Sir/Mam" + heading ;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getButtonurl() {
		return buttonurl;
	}

	public void setButtonurl(String buttonurl) {
		this.buttonurl = buttonurl;
	}

	public String getLinktext() {
		return linktext;
	}

	public void setLinktext(String linktext) {
		this.linktext = linktext;
	}

	public SlingHttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(SlingHttpServletRequest request) {
		this.request = request;
	}


}
