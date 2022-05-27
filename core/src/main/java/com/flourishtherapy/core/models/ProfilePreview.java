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
public class ProfilePreview {

	@ValueMapValue
    private String rootPage;
	
	private Iterator<Page> iterator;

	@SlingObject
	@Required
	private SlingHttpServletRequest request;

	@PostConstruct
	protected void init() {
		ResourceResolver resourceResolver = request.getResourceResolver();
		
		Resource rootPageResource = resourceResolver.getResource(rootPage);
		Page rootPathPage = rootPageResource.adaptTo(Page.class);
		iterator = rootPathPage.listChildren();
	}
	
	public Iterator<Page> getIterator() {
		return iterator;
	}

	public void setIterator(Iterator<Page> iterator) {
		this.iterator = iterator;
	}

	public String getRootPage() {
		return rootPage;
	}

	public void setRootPage(String rootPage) {
		this.rootPage = rootPage;
	}

	

}
