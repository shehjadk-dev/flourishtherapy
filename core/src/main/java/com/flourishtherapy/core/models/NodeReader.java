package com.flourishtherapy.core.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NodeReader {
	
	@ValueMapValue
    private String nodePath;
	
	private ValueMap properties;
	
	private String lastModified;

	@SlingObject
	@Required
	private SlingHttpServletRequest request;

    @PostConstruct
	protected void init() {
    	ResourceResolver resourceResolver = request.getResourceResolver();
    	Resource nodeResource = resourceResolver.getResource(nodePath);
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	if(nodeResource !=null) {
    	 properties = nodeResource.getValueMap();
    	 lastModified = formatter.format(properties.get("cq:lastModified", Date.class));
    	}
    	
    }
    
    public ValueMap getProperties() {
		return properties;
	}

	public void setProperties(ValueMap properties) {
		this.properties = properties;
	}
	
	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

}
