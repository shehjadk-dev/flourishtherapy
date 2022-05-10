package com.flourishtherapy.core.models;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ChildList {
	
	@ValueMapValue
    private String rootPath;
	
	private String title;
	private String path;
	
	private Iterator<Page> childPages;
	
	
	@SlingObject
	@Required
	private SlingHttpServletRequest request;

    //private List<Profile> profiles = new ArrayList<>();
    
    @PostConstruct
	protected void init() {
		
		ResourceResolver resourceResolver = request.getResource().getResourceResolver();
		
		Page rootPage = resourceResolver.getResource(rootPath).adaptTo(Page.class);
		childPages = rootPage.listChildren();
		title = rootPage.getTitle();
		path = rootPath;
	
		
		// page1.getDescription();
		// API documentation https://developer.adobe.com/experience-manager/reference-materials/6-5/javadoc/com/day/cq/commons/LabeledResource.html#getDescription 
	}
   
    
    public Iterator<Page> getChildPages() {
		return childPages;
	}


	public void setChildPages(Iterator<Page> childPages) {
		this.childPages = childPages;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	

}
