package com.flourishtherapy.core.models;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkList {

	Iterator<Resource> iterator;

	boolean componentEmpty;

	@SlingObject
	@Required
	private SlingHttpServletRequest request;

	@PostConstruct
	protected void init() {
		//
		Resource componentResource = request.getResource();

		Resource linksResource = componentResource.getChild("links");
		if (linksResource != null) {
			iterator = linksResource.listChildren();
		} else {
			componentEmpty = true;
		}
	}

	public Iterator<Resource> getIterator() {
		return iterator;
	}

	public void setIterator(Iterator<Resource> iterator) {
		this.iterator = iterator;
	}

}
