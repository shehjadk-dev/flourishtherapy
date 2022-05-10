package com.flourishtherapy.core.models;

import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.jcr.Node;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
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
	
	private boolean componentEmpty;
	
	private String nodeType;


	@SlingObject
	@Required
	private SlingHttpServletRequest request;

    //private List<Profile> profiles = new ArrayList<>();
    
    @PostConstruct
	protected void init() {
		
    	// Step1
		ResourceResolver resourceResolver = request.getResource().getResourceResolver();
        // Get resource From path
		// Get resource Resolver as in step 1 above
		// Get the resource from resource resolver
		//Step 2
		Resource myResource= resourceResolver.getResource(rootPath);
		
		// now if the path is not existing in AEM it will give you null so after step 2 always check for null
		// If the resource is not null you can adapt it to Node
		if(myResource !=null) {
		  Node myNode = myResource.adaptTo(Node.class);
		} else {
			// Resource is null so we can cannot call adapt to
		}
		
		
		// *** how to read a value from node *** //
		if(myResource !=null) {
			ValueMap properties = myResource.getValueMap();
			
			nodeType = properties.get("jcr:primaryType", "");
		
		}
		
		
		if(resourceResolver.getResource(rootPath) != null && nodeType.equals("cq:Page")) {
			Page rootPage = resourceResolver.getResource(rootPath).adaptTo(Page.class);
			childPages = rootPage.listChildren();
			title = rootPage.getTitle();
			path = rootPath;
		} else {
			componentEmpty = true;
		}
	
		
		
		
		
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
	
	
	public boolean isComponentEmpty() {
		return componentEmpty;
	}


	public void setComponentEmpty(boolean componentEmpty) {
		this.componentEmpty = componentEmpty;
	}
	

	public String getNodeType() {
		return nodeType;
	}


	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	
	public String getRootPath() {
		return rootPath;
	}


	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}




	public SlingHttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(SlingHttpServletRequest request) {
		this.request = request;
	}

	

}
