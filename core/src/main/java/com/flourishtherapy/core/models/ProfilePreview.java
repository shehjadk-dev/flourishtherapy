package com.flourishtherapy.core.models;

import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProfilePreview {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@ValueMapValue
    private String pagePath1;

	@ValueMapValue
	private String pagePath2;
	
	@ValueMapValue
    private String pagePath3;
    
	@ValueMapValue
    private String pagePath4;
	
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	
	@SlingObject
	@Required
	private SlingHttpServletRequest request;

    //private List<Profile> profiles = new ArrayList<>();
    
    @PostConstruct
	protected void init() {
		
		ResourceResolver resourceResolver = request.getResource().getResourceResolver();
		
		Page page1 = resourceResolver.getResource(pagePath1).adaptTo(Page.class);
		Page page2 = resourceResolver.getResource(pagePath2).adaptTo(Page.class);
		Page page3 = resourceResolver.getResource(pagePath3).adaptTo(Page.class);
		Page page4 = resourceResolver.getResource(pagePath4).adaptTo(Page.class);
		
		name1 = page1.getTitle();
		name2 = page2.getTitle();
		name3 = page3.getTitle();
		name4 = page4.getTitle();
		
		// page1.getDescription();
		// API documentation https://developer.adobe.com/experience-manager/reference-materials/6-5/javadoc/com/day/cq/commons/LabeledResource.html#getDescription 
	}
    
	public Logger getLogger() {
		return logger;
	}

	public String getPagePath1() {
		return pagePath1;
	}

	public String getPagePath2() {
		return pagePath2;
	}

	public String getPagePath3() {
		return pagePath3;
	}

	public String getPagePath4() {
		return pagePath4;
	}

	public String getName1() {
		return name1;
	}

	public String getName2() {
		return name2;
	}

	public String getName3() {
		return name3;
	}

	public String getName4() {
		return name4;
	}

	public SlingHttpServletRequest getRequest() {
		return request;
	}

	
    
	
	
	

}
