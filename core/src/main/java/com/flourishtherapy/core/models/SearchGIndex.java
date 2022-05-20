package com.flourishtherapy.core.models;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Session;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SearchGIndex {
	
	@ValueMapValue
    private String propertyToSearch;
	
	@Inject
	QueryBuilder queryBuilder;
	
	SearchResult result;
	
	private boolean emptyResult;

	private boolean componentEmpty;
	
	@SlingObject
	@Required
	private SlingHttpServletRequest request;

    //private List<Profile> profiles = new ArrayList<>();
    
    @PostConstruct
	protected void init() {
    	if(propertyToSearch !=null)
    	{
    		// create query description as hash map (simplest way, same as form post)
    	    Map<String, String> map = new HashMap<String, String>();

    	// create query description as hash map (simplest way, same as form post)
    	    map.put("path", "/content/flourishtherapy/us/en");
    	    map.put("type", "cq:PageContent");
    	    map.put("p.limit", "-1"); // combine this group with OR
    	    map.put("property", "cq:robotsTags");
    	    map.put("property.value", propertyToSearch);
    	    
    	    Query query = queryBuilder.createQuery(PredicateGroup.create(map), request.getResourceResolver().adaptTo(Session.class));

    	    result = query.getResult();
    	    emptyResult = result.getHits().size() > 0  ? false: true;
    		
    	}else {
    		componentEmpty = true;
    	}
    	
    }
    
    
    public boolean isEmptyResult() {
		return emptyResult;
	}

	public void setEmptyResult(boolean emptyResult) {
		this.emptyResult = emptyResult;
	}

	public SearchResult getResult() {
		return result;
	}

	public void setResult(SearchResult result) {
		this.result = result;
	}
	
    public String getPropertyToSearch() {
		return propertyToSearch;
	}

	public void setPropertyToSearch(String propertyToSearch) {
		this.propertyToSearch = propertyToSearch;
	}

	public boolean isComponentEmpty() {
		return componentEmpty;
	}

	public void setComponentEmpty(boolean componentEmpty) {
		this.componentEmpty = componentEmpty;
	}

   
    
  
}
