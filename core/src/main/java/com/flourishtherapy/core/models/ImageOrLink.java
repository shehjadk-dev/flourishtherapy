package com.flourishtherapy.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageOrLink {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@ValueMapValue
    private String image;

	@ValueMapValue
	private String linktext;
	
	@ValueMapValue
    private String linkurl;
    
	@ValueMapValue
    private String imageorlink;
	
	private boolean showImage;

	
	@SlingObject
	@Required
	private SlingHttpServletRequest request;
	
	@PostConstruct
	protected void init() {
		
		if(imageorlink.equals("image"))
		{
			showImage = true;
		} else {
			showImage = false;
		}
		
	}

    //private List<Profile> profiles = new ArrayList<>();
    
    public boolean isShowImage() {
		return showImage;
	}

	public void setShowImage(boolean showImage) {
		this.showImage = showImage;
	}

	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLinktext() {
		return linktext;
	}

	public void setLinktext(String linktext) {
		this.linktext = linktext;
	}

	public String getLinkurl() {
		return linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	public String getImageorlink() {
		return imageorlink;
	}

	public void setImageorlink(String imageorlink) {
		this.imageorlink = imageorlink;
	}

	public SlingHttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(SlingHttpServletRequest request) {
		this.request = request;
	}

	public Logger getLogger() {
		return logger;
	}

	
    
	
	
	

}
