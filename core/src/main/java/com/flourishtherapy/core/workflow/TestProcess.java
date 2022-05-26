package com.flourishtherapy.core.workflow;

import org.osgi.service.component.annotations.Component;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(property = { "process.label=Test Process Variable" })
public class TestProcess implements WorkflowProcess {

	@Override
	public void execute(WorkItem wfitem, WorkflowSession wfsession, MetaDataMap args) throws WorkflowException {
		String testData = wfitem.getWorkflowData().getMetaDataMap().get("test", String.class);
		System.out.println(" Test data :: "+ testData);
	}


}
